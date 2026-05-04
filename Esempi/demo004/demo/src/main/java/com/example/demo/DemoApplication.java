package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.listeners.MyEarlyListener;
import com.example.demo.services.SmsService;

// CONDITIONAL BEANS

@SpringBootApplication
// Bad Configuration
@ComponentScan(basePackages = "com.example.demo.services.EmailService")
// Best Practices
@ComponentScan(basePackageClasses = SmsService.class)
public class DemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);
		SpringApplication app = new SpringApplication(DemoApplication.class);
		// Register the early listener
		app.addListeners(new MyEarlyListener());
		app.run(args);

	}

}
