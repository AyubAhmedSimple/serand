package com.serand.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.serand.assignment.model.Question;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String>{

}
