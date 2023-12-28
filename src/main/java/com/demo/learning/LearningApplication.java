package com.demo.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class LearningApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(LearningApplication.class, args);
		RestTemplate restTemplate = (RestTemplate) configurableApplicationContext.getBean("restTemplate");
	}
}
