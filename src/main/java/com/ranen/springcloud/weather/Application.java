package com.ranen.springcloud.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

/**
  *  Notes:
  *  Weather interface website:
  *  1.http://wthrcdn.etouch.cn/weather_mini?city=武汉 	 
  *  2.http://wthrcdn.etouch.cn/weather_mini?citykey=101280601
  *  3.城市列表(城市名字->code): http://mobile.weather.com.cn/js/citylist.xml (@Deprecated)
  *     参考:https://blog.csdn.net/yiyincanfeng/article/details/102298163 
  *     或者直接:https://yiyingcanfeng.github.io/data/2019-03-13-cn_weather_citylist.json
  */