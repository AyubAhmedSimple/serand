package com.serand.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serand.assignment.model.SurveySubmissions;
import com.serand.assignment.service.SurveySubmissionService;

/**
 * Responsible for all survey submission related end points.
 */
@RestController
@RequestMapping("/api/survey/submit")
public class SurveySubmissionController {

	@Autowired
	private SurveySubmissionService surveySubmissionService;
	
	@PostMapping
	public ResponseEntity<SurveySubmissions> submitSurvey(@RequestBody SurveySubmissions surveySubmit) {
		surveySubmissionService.submitSurvey(surveySubmit);
		return ResponseEntity.status(HttpStatus.CREATED).body(surveySubmit);
	}
	
}
