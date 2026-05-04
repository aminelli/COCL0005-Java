package com.example.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.services.ServiceA;
import com.example.demo.services.ServiceB;

@Configuration
public class ConfigurationA {
    
    @Bean
    @ConditionalOnBean(ServiceB.class)
    public ServiceA serviceA() {
        return new ServiceA();
    }
    
}
