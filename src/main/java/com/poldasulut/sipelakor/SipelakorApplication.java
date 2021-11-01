package com.poldasulut.sipelakor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@EnableConfigurationProperties({
//		FileUploadProperties.class
//})
public class SipelakorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SipelakorApplication.class, args);
	}

}
