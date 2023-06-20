package com.serand.assignment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serand.assignment.model.Company;
import com.serand.assignment.repository.CompanyRepository;

/**
 * 
 * @author ayub.ahmed
 *
 *	This service will perform all company related methods.
 */
@Service
public class CompanyServiceImpl implements CompanySerivce{

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public Company createCompany(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public void deleteCompany(String id) {
		companyRepository.deleteById(id);		
	}

	@Override
	public Company findCompanyById(String id) {
		
		Optional<Company> optionalCompany = companyRepository.findById(id);
		if(optionalCompany.isPresent()) {
			return optionalCompany.get();
		} 
		else {
			System.out.println("Company Not found by Id");
			
		}
		return null;
			
	}

}
