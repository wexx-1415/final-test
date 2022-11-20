package com.example.finaltest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages= "com.example.finaltest.dao")
public class FinalTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalTestApplication.class, args);
    }

}
