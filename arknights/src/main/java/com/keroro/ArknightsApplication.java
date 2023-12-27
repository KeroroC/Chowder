package com.keroro;

import com.keroro.arknights.config.ArknightsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ ArknightsProperties.class })
public class ArknightsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArknightsApplication.class, args);
    }
}