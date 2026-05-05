package com.example.demo.config;

import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.Yaml;

import jakarta.annotation.PostConstruct;

 

// Recupero di uno yaml remoto, ad esempio da un server di configurazione centralizzato, 
// e aggiunta al contesto dell'applicazione

@Configuration
public class RemoteConfig {
    
    private final ConfigurableEnvironment environment;

    public RemoteConfig(ConfigurableEnvironment environment) {
        this.environment = environment;
    }

    @PostConstruct
    public void loadYamlFromRemote() {
        // Simulazione del recupero di un file YAML remoto

        String url = "https://example.com/config.yaml";

        RestTemplate restTemplate = new RestTemplate();

        String yaml = restTemplate.getForObject(url, String.class);

        Yaml yamlParser = new Yaml();
        Map<String, Object> yamlData = yamlParser.load(yaml);

        // Aggiunta del contenuto YAML al contesto dell'applicazione
        environment.getPropertySources().addFirst(
            new org.springframework.core.env.PropertySource<String>(yaml) {
                @Override
                public Object getProperty(String name) {
                    if (name.equals("app.name")) {
                        return yamlData.get("app.name");
                    } else if (name.equals("app.version")) {
                        return "1.0.0";
                    }
                    return null;
                }
            }
        );
    }

}
