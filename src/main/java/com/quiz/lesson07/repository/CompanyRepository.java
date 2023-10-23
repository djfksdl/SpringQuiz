package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.CompanyEntity;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
	// JpaRepository: Spring Data JPA
	
	// save(엔티티객체) - insert, update(id 채워져있으면)
	//findById - 조회
	//delete(엔티티)
}