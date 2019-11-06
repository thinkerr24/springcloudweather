package com.ranen.springcloud.weather.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ranen.springcloud.weather.vo.WeatherResponse;

/**
 * 
 * @author Ranen
 * 测试WeatherService层(注意将WeatherDataServiceImpl类打上@Service注解)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WeatherDataServiceTest {
	@Autowired
	private WeatherDataService service;
	@Test
	public void testGetDataByCityCode() {
		String parameter = "101200103";
		WeatherResponse result = service.getDataByCityCode(parameter);
		System.out.println(result);
	}
}
