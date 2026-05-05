package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.services.ServiceB;

@Configuration
public class ConfigurationB {
    
    @Bean
    public ServiceB serviceB() {
        return new ServiceB();
    }

}
