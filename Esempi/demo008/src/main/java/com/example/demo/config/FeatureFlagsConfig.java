package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties(prefix = "app.features")
public class FeatureFlagsConfig {
    private boolean newCheckout;
    private boolean betaPaymentMethod;
    private boolean experimentalSearch; 

    public boolean isNewCheckout() {
        return newCheckout;
    }

    public void setNewCheckout(boolean newCheckout) {
        this.newCheckout = newCheckout;
    }

    public boolean isBetaPaymentMethod() {
        return betaPaymentMethod;
    }

    public void setBetaPaymentMethod(boolean betaPaymentMethod) {
        this.betaPaymentMethod = betaPaymentMethod;
    }

    public boolean isExperimentalSearch() {
        return experimentalSearch;
    }

    public void setExperimentalSearch(boolean experimentalSearch) {
        this.experimentalSearch = experimentalSearch;
    }

}