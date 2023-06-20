package com.serand.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serand.assignment.model.Question;
import com.serand.assignment.repository.QuestionRepository;

/**
 * Responsible for all question and answer related end points.
 */
@RestController
@RequestMapping("/api/question")
public class QuestionAnswerController {

	@Autowired
	private QuestionRepository questionRepository;
	
	@PostMapping
	public ResponseEntity<Question> createSurvey(@RequestBody Question question) {
		Question savedSurvey = questionRepository.save(question);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedSurvey);
	}
}
