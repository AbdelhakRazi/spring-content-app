package com.demo.learning.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LongWayDataLoader implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        // runs after dependecy injection happens when application starts
        System.out.println("Hello mate");
    }
}
