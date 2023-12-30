package com.demo.learning;

import com.demo.learning.model.Content;
import com.demo.learning.model.Status;
import com.demo.learning.model.Type;
import com.demo.learning.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class LearningApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(LearningApplication.class, args);
		RestTemplate restTemplate = (RestTemplate) configurableApplicationContext.getBean("restTemplate");
		// adding programmatically rows into database
	}
	@Bean
	CommandLineRunner commandLineRunner(ContentRepository repository){
		return args -> {
			// insert some data into the database on launch
			// we do not supply id
			Content content = new Content(null,
					"first blog post",
					"description", Status.IDEA,
					Type.ARTICLE,
					LocalDateTime.now(),
					null,
					"");
			repository.save(content);
		};
	}
}
