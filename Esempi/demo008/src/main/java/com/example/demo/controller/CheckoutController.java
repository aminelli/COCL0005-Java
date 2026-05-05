package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckoutController {
    
    private final FeatureFlagsConfig featureFlagsConfig;

    public CheckoutController(FeatureFlagsConfig featureFlagsConfig) {
        this.featureFlagsConfig = featureFlagsConfig;
    }

    @GetMapping("/checkout")
    public String checkout() {
        if (featureFlagsConfig.isNewCheckout()) {
            return "New checkout feature is enabled!";
        } else {
            return "New checkout feature is disabled.";
        }
    }

}
