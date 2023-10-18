package com.quiz.weather_history;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/weather")
@Controller
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	// 날씨 목록 화면
	// http://localhost:8080/weather/history-view
	@GetMapping("/history-view")
	public String historyView(Model model) {
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistoryList();
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		return "weather_history/history";
	}
	
	// 날씨 추가 화면
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
	// 날씨 추가 로직
	@PostMapping("/add-weather")
	public String addWeather(
			//@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
			@RequestParam("date") String date,
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation, 
			@RequestParam("windSpeed") double windSpeed) {
		
		// db insert
		weatherHistoryBO.addWeatherHistory(date, weather, microDust, 
				temperatures, precipitation, windSpeed);
		
		// response
		// redirect => 히스토리 페이지
		return "redirect:/weather/history-view";
	}
	
	
}