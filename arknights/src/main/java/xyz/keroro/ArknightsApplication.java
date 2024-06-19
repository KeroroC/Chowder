package xyz.keroro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import xyz.keroro.arknights.config.ArknightsProperties;

@SpringBootApplication
@EnableConfigurationProperties({ ArknightsProperties.class })
@EnableDiscoveryClient
public class ArknightsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArknightsApplication.class, args);
    }
}