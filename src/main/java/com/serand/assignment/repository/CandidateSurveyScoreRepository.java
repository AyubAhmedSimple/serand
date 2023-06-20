package com.serand.assignment.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.serand.assignment.model.CandidateSurveyScore;
import com.serand.assignment.model.Survey;

@Repository
public interface CandidateSurveyScoreRepository extends MongoRepository<CandidateSurveyScore, String> {

	List<CandidateSurveyScore> findByScore(Integer score);
}