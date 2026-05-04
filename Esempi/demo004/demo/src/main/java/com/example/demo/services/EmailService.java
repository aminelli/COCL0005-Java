package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendEmail(String to, String subject, String body) {
        // Logica per inviare l'email
        System.out.println("Invio email a: " + to);
        System.out.println("Oggetto: " + subject);
        System.out.println("Corpo: " + body);
    }
}

