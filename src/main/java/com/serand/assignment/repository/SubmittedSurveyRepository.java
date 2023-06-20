package com.serand.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.serand.assignment.model.SurveySubmissions;

@Repository
public interface SubmittedSurveyRepository extends MongoRepository<SurveySubmissions, String>{

	
}
