package com.serand.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serand.assignment.model.Survey;
import com.serand.assignment.repository.SurveyRepository;

/**
 * 
 * @author ayub.ahmed
 *
 *	This service will perform all survey related methods.
 */
@Service
public class SurveyServiceImpl implements SurveyService{

	@Autowired
	private SurveyRepository surveyRepository;
	
	@Override
	public Survey createSurvey(Survey survey) {
		return surveyRepository.save(survey);
	}

	@Override
	public void deleteSurvey(String id) {
		surveyRepository.deleteById(id);
	}

	@Override
	public List<Survey> findSurveyByCompanyId(String companyId) {
		return surveyRepository.findByCompanyId(companyId);		
	}

	
}
