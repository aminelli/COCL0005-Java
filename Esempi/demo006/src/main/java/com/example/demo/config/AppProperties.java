package com.example.demo.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public class AppProperties {

    public static class ApiClient {
        private final String name;
        private final String clientId;
        private final List<String> scopes;

        public ApiClient(String name, String clientId, List<String> scopes) {
            this.name = name;
            this.clientId = clientId;
            this.scopes = scopes;
        }

        public String getName() {
            return name;
        }

        public String getClientId() {
            return clientId;
        }

        public List<String> getScopes() {
            return scopes;
        }
    }

    public static class RateLimit {
        private final int requestsPerMinute;
        private final int burst;

        public RateLimit(int requestsPerMinute, int burst) {
            this.requestsPerMinute = requestsPerMinute;
            this.burst = burst;
        }

        public int getRequestsPerMinute() {
            return requestsPerMinute;
        }

        public int getBurst() {
            return burst;
        }
    }
    
    private final List<String> allowedOrigins;
    private final List<String> apiEndpoints;
    private final List<ApiClient> apiClients;
    private final Map<String, Boolean> featureFlags;
    private final Map<String, RateLimit> rateLimits;
    
    public AppProperties(
        List<String> allowedOrigins, 
        List<String> apiEndpoints, 
        List<ApiClient> apiClients,
        Map<String, Boolean> featureFlags, 
        Map<String, RateLimit> rateLimits
    ) {
        this.allowedOrigins = allowedOrigins;
        this.apiEndpoints = apiEndpoints;
        this.apiClients = apiClients;
        this.featureFlags = featureFlags;
        this.rateLimits = rateLimits;
    }



}
