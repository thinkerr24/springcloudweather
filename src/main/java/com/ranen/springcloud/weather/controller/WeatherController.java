package com.ranen.springcloud.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranen.springcloud.weather.service.WeatherDataService;
import com.ranen.springcloud.weather.vo.WeatherResponse;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	private WeatherDataService weatherDataService;
	@GetMapping("/cityCode/{cityCode}")
	public WeatherResponse getWeatherByCityCode(@PathVariable("cityCode")String cityCode) {
		return weatherDataService.getDataByCityCode(cityCode);
	}
	
	@GetMapping("/cityName/{cityName}")
	public WeatherResponse getWeatherByCityName(@PathVariable("cityName")String cityName) {
		return weatherDataService.getDataByCityName(cityName);
	}
}
