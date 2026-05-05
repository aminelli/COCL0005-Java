package com.example.demo.debug;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class PropertySourceDebugger implements CommandLineRunner {

    private final ConfigurableEnvironment environment;

    public PropertySourceDebugger(ConfigurableEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Debugging Property Sources...");
        // Here you can add code to inspect the property sources, for example:
        // Environment env = ...; // Get the environment
        // System.out.println(env.getProperty("some.property"));

        // PropertySource Ordering
        int index = 1;
        for (PropertySource<?> propertySource : environment.getPropertySources()) {
            System.out.printf(
                "%2d. %-50s [%s]%n",
                index++, 
                propertySource.getName(),
                propertySource.getClass().getSimpleName()
            );

            
        }

    }


}