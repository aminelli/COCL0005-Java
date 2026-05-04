package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// SCANNIG - CONDIONAL BEAN

// sip porta dietro @Scomponent Scan e @ServiceScan per scansionare i pacchetti e trovare i componenti da iniettare
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
