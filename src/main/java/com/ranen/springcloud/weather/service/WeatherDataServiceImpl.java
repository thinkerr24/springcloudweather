package com.ranen.springcloud.weather.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ranen.springcloud.weather.vo.WeatherResponse;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
	private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public WeatherResponse getDataByCityCode(String cityCode) {
		String uri = WEATHER_URI + "citykey=" + cityCode;
		return doGetWeather(uri);
	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) {
		String uri = WEATHER_URI + "city=" + cityName;
		return doGetWeather(uri);
	}
	
	private WeatherResponse doGetWeather(String uri) {
		ResponseEntity<String> repsString = restTemplate.getForEntity(uri, String.class);
		WeatherResponse weatherRes = null;
		String strBody = null;
		ObjectMapper mapper = new ObjectMapper();
		if (repsString.getStatusCodeValue() == 200) {
		    strBody = repsString.getBody();
		}
		try {
			weatherRes = mapper.readValue(strBody, WeatherResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return weatherRes;
	}

}
