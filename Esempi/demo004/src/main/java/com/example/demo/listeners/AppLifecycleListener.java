package com.example.demo.listeners;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppLifecycleListener 
implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
      if (event instanceof ApplicationStartingEvent) {
        System.out.println("Application is starting...");
      } else if (event instanceof ApplicationEnvironmentPreparedEvent) {
        System.out.println("Environment is prepared...");
      } else if (event instanceof ApplicationContextInitializedEvent) {
        System.out.println("Application is ready...");
      }
      // Other lifecycle events can be handled here
        
    }

   
    
}
