package com.serand.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.serand.assignment.model.SurveySubmissions;
import com.serand.assignment.service.ScoreCalculationService;

@RestController
@RequestMapping("/api/score")
public class CandidateScoreController {

	@Autowired
	private ScoreCalculationService scoreCalculationService;

	@GetMapping("/{score}")
	public List<SurveySubmissions> getSurveysByScore(@PathVariable("score") Integer score) {
		return scoreCalculationService.searchSurveysByScore(score);

	}
	
	@GetMapping("/search")
	public ResponseEntity<Page<SurveySubmissions>> getAll(@RequestParam(required = false) String jobId,
			@RequestParam(required = false) Integer score,
			@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {
		
		Pageable pageable = PageRequest.of(page != null ? page : 0, size != null ? size : 10);
		return ResponseEntity.ok(scoreCalculationService.searchSurvey(jobId, score, pageable));
	}
}
