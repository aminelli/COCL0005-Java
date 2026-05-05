package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.demo.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		// Esempio abilitazione di più profili
		/*
		SpringApplication app = new SpringApplication(DemoApplication.class);
		app.setAdditionalProfiles("prod", "sec");
		app.run(args);
		*/
	}

}
