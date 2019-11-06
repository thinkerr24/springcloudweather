package com.ranen.springcloud.weather.service;

import com.ranen.springcloud.weather.vo.WeatherResponse;

public interface WeatherDataService {
	/**
	   *  根据城市ID查询天气
	 */
	WeatherResponse getDataByCityCode(String cityCode);

	/**
	    * 根据城市name查询天气
	 */
	WeatherResponse getDataByCityName(String cityName);
}
