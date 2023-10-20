package com.quiz.booking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.booking.domain.Booking;

@Repository
public interface BookingMapper {
	public List<Booking> selectBookingList();
	
	public void deleteBookingById(int id);
	
	public void insertBooking(
			@Param("name") String name, 
			@Param("date") String date, 
			@Param("day") int day, 
			@Param("headcount") int headcount, 
			@Param("phoneNumber") String phoneNumber);
	
	public List<Booking> getBookingByNamePhoneNumber(
			@Param("name") String name, 
			@Param("phoneNumber") String phoneNumber);
}