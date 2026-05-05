package com.example.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.example.demo.services.AdvancedService;
import com.example.demo.services.EmailService;
import com.example.demo.services.SmsService;

@Configuration
public class FeatureConfiguration {

    // Bean creato se feature.mail.enabled è true
    // BAD CONFIGURATION
    // Approccio imperativo, non dichiarativo. Non sfrutta appieno il potere di Spring
    @Bean
    public EmailService emailService2(Environment env) {
        if ("true".equals(env.getProperty("feature.email.enabled"))) {
            return new EmailService();
        }
        return null;
    }


    // Bean creato se feature.mail.enabled è true
    // BEST PRACTICES
    // Approccio dichiarativo, sfrutta appieno il potere di Spring
    @Bean
    @ConditionalOnProperty(
        prefix = "feature.mail",
        name = "enabled", 
        havingValue = "true"
    )
    public EmailService emailService() {
        return new EmailService();
    }

    // Bean creato se feature.sms.enabled è true
    @Bean
    @ConditionalOnProperty(
        prefix = "feature.sms",
        name = "enabled", 
        havingValue = "true",
        matchIfMissing = true // Se la proprietà è assente, il bean sarà creato
    )
    public SmsService smsService() {
        return new SmsService();
    }
    
    // Bean creato con qualsiasi valore di feature.advanced.mode, purché sia presente eccetto caso "false"
    @Bean
    @ConditionalOnProperty(
        prefix = "feature.advanced",
        name = "mode"
    )
    public AdvancedService advancedService() {
        return new AdvancedService();
    }

}