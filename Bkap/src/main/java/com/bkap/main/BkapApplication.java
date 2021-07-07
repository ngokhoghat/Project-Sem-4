package com.bkap.main;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bkap.model.FilesStorageService;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({ "com.bkap.api", "com.bkap.config", "com.bkap.controllers", "com.bkap.controllers.admin",
		"com.bkap.service", "com.bkap.utils", })
@EnableJpaRepositories("com.bkap.repository")
@EntityScan(basePackages = { "com.bkap.entities" })
public class BkapApplication implements CommandLineRunner {
	@Resource
	FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(BkapApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
//		storageService.deleteAll();
//		storageService.init();
	}
}
