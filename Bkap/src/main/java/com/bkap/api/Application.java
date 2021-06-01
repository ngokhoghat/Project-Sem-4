package com.bkap.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.bkap.service", "com.bkap.utils", "com.bkap.api"})
@EnableJpaRepositories("com.bkap.repository")
@EntityScan(basePackages = {"com.bkap.entity"}) 
public class Application {
   public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}