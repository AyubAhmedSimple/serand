package com.serand.assignment.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import com.serand.assignment.model.Answer;
import com.serand.assignment.model.CandidateSurveyScore;
import com.serand.assignment.model.Question;
import com.serand.assignment.model.Survey;
import com.serand.assignment.model.SurveySubmissions;
import com.serand.assignment.repository.CandidateSurveyScoreRepository;
import com.serand.assignment.repository.QuestionRepository;
import com.serand.assignment.repository.SubmittedSurveyRepository;
import com.serand.assignment.repository.SurveyRepository;

/**
 * 
 * @author ayub.ahmed
 *
 *	This service will perform all score calculation related methods.
 */
@Service
public class ScoreCalculationServiceImpl implements ScoreCalculationService {

	@Autowired
	private CandidateSurveyScoreRepository candidateSurveyScoreRepository;

	@Autowired
	private SubmittedSurveyRepository submittedSurveyRepository;

	@Autowired
	private SurveyRepository surveyRepository;

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public CandidateSurveyScore calculateScore(SurveySubmissions submittedSurvey) {

		Integer score = 0;
		for (Answer i : submittedSurvey.getAnswerList()) {
			Optional<Question> question = questionRepository.findById(i.getQuestionId());
			if (i.getGivenAnswerText() != null) {
				// Optional<Question> question = questionRepository.findById(i.getQuestionId());
				if (question.isPresent()) {
					if (i.getGivenAnswerText().equals(question.get().getAnswerText())) {
						score = score + 1;
					}
				}
			}

			if (i.getSpecifyAnswer() != null) {

				for (Map.Entry<String, String> entry : i.getSpecifyAnswer().entrySet()) {

					if (question.get().getSpecifyAnswer().containsValue(entry.getValue())) {
						if (entry.getValue().equals("IntelliJ")) {
							score = score + 2;
							System.out.println("Adding 2 points in score for IntelliJ");
						} else if (entry.getValue().equals("Entrepreneurial")
								|| entry.getValue().equals("Disruptive")) {
							score = score + 2;
							System.out.println("Adding 2 points in score for Entrepreneurial or Disruptive");
						} else {
							score = score + 1;
							System.out.println("Adding 1 point in score");
						}
						System.out.println("Score is now " + score);
					}
					System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
				}
			}
		}

		CandidateSurveyScore candidateSurveyScore = new CandidateSurveyScore();
		candidateSurveyScore.setCandidateId(submittedSurvey.getCandidateId());
		candidateSurveyScore.setScore(score);
		candidateSurveyScore.setSurveyId(submittedSurvey.getSurveyId());
		candidateSurveyScore.setSubmittedSurveyId(submittedSurvey.getId());
		candidateSurveyScore.setTimestamp(new Timestamp(System.currentTimeMillis()));
		candidateSurveyScoreRepository.save(candidateSurveyScore);

		return candidateSurveyScore;
	}

	@Override
	public List<SurveySubmissions> searchSurveysByScore(Integer score) {

		List<CandidateSurveyScore> candidateSurveyScore = candidateSurveyScoreRepository.findByScore(score);
		List<SurveySubmissions> submittedSurveys = getAllSurveys(candidateSurveyScore);

		return submittedSurveys;
	}

	@Override
	public Page<SurveySubmissions> searchSurvey(String jobId, Integer score, Pageable pageable) {
		var query = new Query().with(pageable);
		List<String> surveySubmitIds = new ArrayList<>();

		if (jobId != null && !jobId.isBlank()) {
			Survey survey = surveyRepository.findByJobId(jobId);
			if (survey != null) {

				if (survey.getId() != null && !survey.getId().isBlank()) {
					query.addCriteria(Criteria.where("surveyId").is(survey.getId()));
					System.out.println("Adding search criteria based on job id");
				}

			}

		}

		if (score != null && score >= 0) {
			List<SurveySubmissions> surveySubmits = searchSurveysByScore(score);
			for (SurveySubmissions i : surveySubmits) {
				surveySubmitIds.add(i.getId());
			}
			query.addCriteria(Criteria.where("id").in(surveySubmitIds));
			System.out.println("Adding search criteria based on score");
		}

		return PageableExecutionUtils.getPage(mongoTemplate.find(query, SurveySubmissions.class), pageable,
				() -> mongoTemplate.count(query.skip(0).limit(0), SurveySubmissions.class));

	}

	private List<SurveySubmissions> getAllSurveys(List<CandidateSurveyScore> candidateSurveyScoreList) {

		List<SurveySubmissions> submittedSurveys = new ArrayList<>();
		for (CandidateSurveyScore i : candidateSurveyScoreList) {
			Optional<SurveySubmissions> survbSubmit = submittedSurveyRepository.findById(i.getSubmittedSurveyId());
			if (survbSubmit.isPresent()) {
				submittedSurveys.add(survbSubmit.get());
			}
		}

		return submittedSurveys;
	}

}
