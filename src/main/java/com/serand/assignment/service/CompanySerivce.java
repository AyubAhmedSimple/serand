package com.serand.assignment.service;

import com.serand.assignment.model.Company;

public interface CompanySerivce {

	Company createCompany(Company company);
	
	void deleteCompany(String id);
	
	Company findCompanyById(String id);
}
