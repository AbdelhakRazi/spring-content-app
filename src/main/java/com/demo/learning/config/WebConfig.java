package com.demo.learning.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class WebConfig {
    @Bean // method level annotation
    // @Component is a class level annotation
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder().build();
    }
}
