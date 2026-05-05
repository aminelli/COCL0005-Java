package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.example.demo.conditions.LinuxCondition;
import com.example.demo.conditions.WindowsCondition;
import com.example.demo.services.files.IFileSystem;
import com.example.demo.services.files.LinuxFileSystemService;
import com.example.demo.services.files.WindowsFileSystemService;

@Configuration
public class PlatformConfiguration {
    
    @Bean
    @Conditional(LinuxCondition.class)
    public IFileSystem linuxFileSystem() {
        return new LinuxFileSystemService();
    }

    @Bean
    @Conditional(WindowsCondition.class)
    public IFileSystem windowsFileSystem() {
        return new WindowsFileSystemService();
    }

}
