package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.boot.origin.Origin;
import org.springframework.boot.origin.OriginTrackedValue;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class ConfigDebugger implements ApplicationRunner {
    
    @Autowired
    private ConfigurableEnvironment environment;
    
    @Override
    public void run(ApplicationArguments args) {
        MutablePropertySources sources = environment.getPropertySources();
        
        for (PropertySource<?> ps : sources) {
            if (ps instanceof OriginTrackedMapPropertySource) {
                OriginTrackedMapPropertySource otps = (OriginTrackedMapPropertySource) ps;
                System.out.println("PropertySource: " + ps.getName());
                
                // Properties with line numbers
                otps.getSource().forEach((key, value) -> {
                    if (value instanceof OriginTrackedValue) {
                        Origin origin = ((OriginTrackedValue) value).getOrigin();
                        System.out.println("  " + key + " = " + value + 
                            " (from " + origin + ")");
                    }
                });
            }
        }
    }
}