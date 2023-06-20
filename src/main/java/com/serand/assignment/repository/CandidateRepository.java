package com.serand.assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.serand.assignment.model.Candidate;

@Repository
public interface CandidateRepository extends MongoRepository<Candidate, String> {

}