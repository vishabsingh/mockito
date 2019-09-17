package com.vs.mock;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.vs.mock")
public class MockitoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MockitoApplication.class, args);
    }
}
