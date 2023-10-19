package com.quiz.booking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {

	@Autowired
	private BookingBO bookingBO;
	
	// 예약 목록 보기 화면
	@GetMapping("/booking-list-view")
	public String reservationListView(Model model) {
		List<Booking> bookingList = bookingBO.getBookingList();
		model.addAttribute("bookingList", bookingList);
		return "booking/bookingList";
	}
	
	// 예약 삭제 기능 - AJAX 요청
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		
		// db insert
		bookingBO.deleteBookingById(id);
		
		// {"code":200, "result":"success"}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");
		return result;
	}
	
	// 예약하기 화면
	@GetMapping("/add-booking-view")
	public String addBookingView() {
		return "booking/addBooking";
	}
	
	// 예약 추가 - AJAX 요청
	@ResponseBody
	@PostMapping("/add-booking")
	public Map<String, Object> addBooking(
			@RequestParam("name") String name,
			@RequestParam("date") String date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// DB insert
		bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");
		return result;  // JSON String
	}
	
	// 예약 조회 - AJAX요청
	@ResponseBody
	@PostMapping("/search-booking")
	public Map<String,Object> searchBooking(
			@RequestParam("name") String name,
			@RequestParam("PhoneNumber") String PhoneNumber) {
		
		
		//DB select
		Booking booking = bookingBO.
		
		//응답값
		Map <String,Object> result = new HashMap<>();
		
		return result;
		
	}
}