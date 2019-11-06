package com.ranen.springcloud.weather.vo;

import java.io.Serializable;
import java.util.List;

public class Forecast implements Serializable {

	private static final long serialVersionUID = 1L;

	private Yesterday yesterday;
	private String city;
	private List<Weather> forecast;
	private String ganmao;
	private String wendu;

	public Yesterday getYesterday() {
		return yesterday;
	}

	public void setYesterday(Yesterday yesterday) {
		this.yesterday = yesterday;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Weather> getForecast() {
		return forecast;
	}

	public void setForecast(List<Weather> forecast) {
		this.forecast = forecast;
	}

	public String getGanmao() {
		return ganmao;
	}

	public void setGanmao(String ganmao) {
		this.ganmao = ganmao;
	}

	public String getWendu() {
		return wendu;
	}

	public void setWendu(String wendu) {
		this.wendu = wendu;
	}

}
