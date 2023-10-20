package com.quiz.booking.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {
	
	@Autowired
	private BookingMapper bookingMapper;

	// input:X     output:List<Booking>
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	// input:id    output:X
	public void deleteBookingById(int id) {
		bookingMapper.deleteBookingById(id);
	}
	
	public void addBooking(String name, String date, 
			int day, int headcount, String phoneNumber) {
		
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	// input : name, phonNumber    output: Booking(null or Booking)
	public Booking getBookingByNamePhoneNumber(String name, String phoneNumber) {
		List<Booking> bookingList = bookingMapper.selectBookingByNamePhoneNumber(name,phoneNumber );
		// 0 1(최신)
		// 리스트가 비어있으면 null이 아[]
		if(bookingList.isEmpty()) {
			return null; // null
		}
		
		//리스트가 비어있지 않으면 마지막 객체 리턴
		return bookingList.get(bookingList.size() - 1); //Booking
	}
}