package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@Profile("!staging")
//@Profile("prod & sec")
@Profile("prod | sec")
public class AdvancedConfigDemo {

    @Bean
    public DataSource dataSource() {
        return null;
    }
    
}
