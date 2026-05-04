package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.annotation.CustomComponent;

// Customizzare il component scanning

@SpringBootApplication
@ComponentScan(
	basePackages = {
		"com.example.demo.core", 
		"com.example.demo.api",
		"com.thirdparty.integration" // Include external package for scanning
	},
	excludeFilters = @ComponentScan.Filter(
		type = org.springframework.context.annotation.FilterType.REGEX, 
		pattern = "com\\.example\\.demo\\.legacy\\..*" // Exclude in legacy code
	),
	includeFilters = @ComponentScan.Filter(
		type = org.springframework.context.annotation.FilterType.ANNOTATION, 
		classes = CustomComponent.class // Include custom stereotype	
	)
)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
