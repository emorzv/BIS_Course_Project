package com.example.demo.delivery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeliveryConfig {
    @Bean
    CommandLineRunner commandLineRunnerDelivery(DeliveryRepository repository) {
        return args -> {
        };
    }
}
