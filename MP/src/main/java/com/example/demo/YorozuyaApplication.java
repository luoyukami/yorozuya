package com.example.demo;

import com.example.demo.entity.two.SetInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class YorozuyaApplication {
	@Autowired
	private RunTenDateDataService runTenDateDataService;
	public static void main(String[] args) {
		SpringApplication.run(YorozuyaApplication.class, args);
	}

	@RequestMapping("/powerplant/test")
	public String getRedisService(){

		//storeFanQualityDataService.storeVibrationQualityData();
		runTenDateDataService.storeFanQualityData();
		runTenDateDataService.storeVibrationQualityData();
		return "ok";

	}
}



