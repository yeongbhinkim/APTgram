package com.project.apt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AptApplication {

	public static void main(String[] args) {
		SpringApplication.run(AptApplication.class, args);
	}

}
