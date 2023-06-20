package com.serand.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serand.assignment.model.Company;
import com.serand.assignment.service.CompanySerivce;

/**
 * Responsible for all company related end points.
 */
@RestController
@RequestMapping("/api/companies")
public class CompanyController {


	@Autowired
	private CompanySerivce companySerivce;

	@GetMapping("/company/{id}")
	public ResponseEntity<Company> getSurveysByCompanyId(@PathVariable("id") String id) {
		Company foundCompany = companySerivce.findCompanyById(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(foundCompany);
	}
	
	@PostMapping
	public ResponseEntity<Company> createCompany(@RequestBody Company company) {
		Company savedCompany = companySerivce.createCompany(company);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedCompany);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteCompay(@PathVariable("id") String id) {
	  try {
		  companySerivce.deleteCompany(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  } catch (Exception e) {
	    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}
	
}
