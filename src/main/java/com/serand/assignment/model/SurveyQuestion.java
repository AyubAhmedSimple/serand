package com.serand.assignment.model;

import org.springframework.data.annotation.Id;

public class SurveyQuestion {

	@Id
	private String id;
	private String surveyId;
	private String questionId;
	
 }
