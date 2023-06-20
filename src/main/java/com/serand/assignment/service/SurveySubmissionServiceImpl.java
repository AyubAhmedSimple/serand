package com.serand.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serand.assignment.model.SurveySubmissions;
import com.serand.assignment.repository.SubmittedSurveyRepository;

/**
 * 
 * @author ayub.ahmed
 *
 *         This service will perform all survey submission related methods.
 */
@Service
public class SurveySubmissionServiceImpl implements SurveySubmissionService {

	@Autowired
	private SubmittedSurveyRepository submittedSurveyRepository;

	@Autowired
	private ScoreCalculationService scoreCalculationService;

	@Override
	public void submitSurvey(SurveySubmissions surveySubmit) {

		submittedSurveyRepository.save(surveySubmit);
		System.out.println("Survey submitted with id " + surveySubmit.getId());

		System.out.println("Survey submitted now calculating its score.");
		scoreCalculationService.calculateScore(surveySubmit);
	}

}
