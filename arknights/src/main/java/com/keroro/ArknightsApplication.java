package com.keroro;

import com.keroro.arknights.config.ArknightsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableConfigurationProperties({ ArknightsProperties.class })
@EnableDiscoveryClient
public class ArknightsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArknightsApplication.class, args);
    }
}