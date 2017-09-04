package com.luoyu.yorozuya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//@Configuration
//@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
@SpringBootApplication
//@ImportResource({"classpath:spring-bean.xml"})
public class YorozuyaApplication {
	public static void main(String[] args) {
		SpringApplication.run(YorozuyaApplication.class, args);
	}
}



