package com.quiz.lesson07.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {
	@Autowired
	private CompanyRepository companyRepository;  //JPA
	
	//JPA
	// input : 파라미터들  output: CompanyEntity
	public CompanyEntity addCompany() {};
}
