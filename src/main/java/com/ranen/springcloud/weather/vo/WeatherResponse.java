package com.ranen.springcloud.weather.vo;

import java.io.Serializable;

public class WeatherResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Forecast data;
	private String status;
	private String desc;

	public Forecast getData() {
		return data;
	}

	public void setData(Forecast data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
