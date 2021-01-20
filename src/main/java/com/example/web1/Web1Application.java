package com.example.web1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@MapperScan("com.example.web1.mapper")
public class Web1Application {

    public static void main(String[] args) {
        SpringApplication.run(Web1Application.class, args);
    }

}



