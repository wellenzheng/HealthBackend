package com.example.healthbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
public class HealthbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthbackendApplication.class, args);
    }

}
