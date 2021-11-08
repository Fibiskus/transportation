package com.example.transportation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example.transportation.controller"})
@EntityScan("com.example.transportation.entity")
public class TransportationApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(TransportationApplication.class, args);
    }

}
