package com.serand.assignment.service;

import java.util.List;

import com.serand.assignment.model.Survey;

public interface SurveyService {

	Survey createSurvey(Survey survey);
	
	void deleteSurvey(String id);
	
	List<Survey> findSurveyByCompanyId(String companyId);
}
