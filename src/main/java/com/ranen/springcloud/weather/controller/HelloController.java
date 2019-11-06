package com.ranen.springcloud.weather.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	// @GetMapping("/hello")
	@RequestMapping("/hello")
	public String hello() {
		return "<h1>Hello, World!</h1>";
	}
}
