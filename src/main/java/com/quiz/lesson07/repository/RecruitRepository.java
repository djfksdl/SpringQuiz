package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.RecruitEntity;

@Repository
public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer> {
	// Spring Data JPA
	// findById
	
	// JPQL => 엔티티 조회
	public List<RecruitEntity> findByCompanyId(int companyId);
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region, int salaryStart, int salaryEnd);
	
	// Native query 조회 => DB 직접 조회
	//마감일이 2026-04-10 이후이고 
	// 연봉이 8100 이상인 정규직 공고를 연봉 내림차순
	@Query(value = "select * from `recruit` "
			+ "where `deadline` > :deadline "
			+ "and `salary` >= :salary "
			+ "and `type` = :type "
			+ "order by salary desc", nativeQuery = true)
	public List<RecruitEntity> findByDeadlineAndSalaryGreaterThanEqualAndTypeOrderBySalaryDesc(
			@Param("deadline") String deadline,
			@Param("salary") int salary,
			@Param("type") String type);
}