package com.serand.assignment.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.serand.assignment.model.CandidateSurveyScore;
import com.serand.assignment.model.SurveySubmissions;

public interface ScoreCalculationService {

	CandidateSurveyScore calculateScore(SurveySubmissions submittedSurvey);
	
	List<SurveySubmissions> searchSurveysByScore(Integer score);
	
	Page<SurveySubmissions> searchSurvey(String jobId, Integer score, Pageable pageable);
}
