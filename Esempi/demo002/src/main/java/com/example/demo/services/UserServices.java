package com.example.demo.services;

import org.springframework.stereotype.Service;

// La classe viene scoperta in auto-discovery grazie alla annotazione @Service, che la rende un bean gestito da Spring.
@Service
public class UserServices {
    public String getUser() {
        return "Hello User";
    }

}