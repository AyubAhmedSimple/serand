package com.serand.assignment.controller;


import com.serand.assignment.model.Candidate;
import com.serand.assignment.model.Survey;
import com.serand.assignment.repository.SurveyRepository;
import com.serand.assignment.service.SurveyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Responsible for all survey related end points.
 */
@RestController
@RequestMapping("/api/surveys")
public class SurveyController {


	@Autowired
	private SurveyService surveyService;

	@GetMapping("/company/{companyId}")
	public List<Survey> getSurveysByCompanyId(@PathVariable("companyId") String companyId) {
		return surveyService.findSurveyByCompanyId(companyId);
	}
	
	@PostMapping
	public ResponseEntity<Survey> createSurvey(@RequestBody Survey survey) {
		Survey savedSurvey = surveyService.createSurvey(survey);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedSurvey);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteSurvey(@PathVariable("id") String id) {
	  try {
		  surveyService.deleteSurvey(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  } catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}

}