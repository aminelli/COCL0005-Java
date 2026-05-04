package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class SmsService {

    public void sendSms(String to, String message) {
        // Logica per inviare l'SMS
        System.out.println("Invio SMS a: " + to);
        System.out.println("Messaggio: " + message);
    }
}