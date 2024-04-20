package com.example.demo.delivery;

import com.example.demo.tobacco.Tobacco;
import com.example.demo.tobacco.TobaccoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DeliveryConfig {
    @Bean
    CommandLineRunner commandLineRunnerDelivery(DeliveryRepository repository) {
        return args -> {
        };
    }
}
