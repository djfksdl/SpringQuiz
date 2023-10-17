package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {

	public RealEstate selectRealEstateById(int id);
	
	public List<RealEstate> selectRealEstateListByRentPrice(
			@Param("rentPrice1") int rentPrice);
	
	public List<RealEstate> selectRealEstateListByAreaPrice(
			// @Param 하나의 map이 된다.(파라미터가 2개 이상일 때)
			@Param("area") int area1111111111111,
			@Param("price") int price2222222222222);
	
	// mybatis가 성공된 행의 개수를 채워서 리턴해줌
	public int insertRealEstate(RealEstate realEstate);
	
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId1111, 
			@Param("address") String address2222, 
			@Param("area") int area333, 
			@Param("type") String type344, 
			@Param("price") int price3434, 
			@Param("rentPrice") Integer rentPrice);
	
	public int updateRealEstateById(
			@Param("id") int id, 
			@Param("price") int price, 
			@Param("type") String type);
	
	public int deleteRealEstateById(int id);
}