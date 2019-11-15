package com.ranen.springcloud.weather.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ranen.springcloud.weather.vo.WeatherResponse;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
	private static final Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);
	private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
	private static final long TIME_OUT = 1800L; // test is 10s 
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
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
		String key = uri;
		String strBody = null;
		WeatherResponse weatherRes = null;
		ObjectMapper mapper = new ObjectMapper();
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
		// 先查缓存, 如果有取缓存中的数据
		if (stringRedisTemplate.hasKey(key)) {
			logger.info("Redis has data");
			strBody = ops.get(key);
		}
		// 如果缓存中没有再调用第三方接口
		else {
			logger.info("Redis has no data");
			ResponseEntity<String> repsString = restTemplate.getForEntity(uri, String.class);
			if (repsString.getStatusCodeValue() == 200) {
			    strBody = repsString.getBody();
			}
			// 数据写入缓存
			ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
		}
		// 不管是缓存中取还是原始接口中取最终都要转化字符串成WeatherResponse实体
		try {
			weatherRes = mapper.readValue(strBody, WeatherResponse.class);
		} catch (IOException e) {
			logger.error("Error!", e);
		}
		
		return weatherRes;
	}

}
