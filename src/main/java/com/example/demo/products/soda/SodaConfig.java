package com.example.demo.products.soda;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SodaConfig {
    @Bean
    CommandLineRunner commandLineRunnerSoda(SodaRepository repository) {
        return args -> {
            Soda cocaCola = new Soda(
                    "SC",
                    "Coca Cola",
                    2.0,
                    "Soda",
                    0.5
            );

            Soda fantaa = new Soda(
                    "SF",
                    "Fanta",
                    3.0,
                    "Soda",
                    0.5
            );

            Soda sprite = new Soda(
                    "SS",
                    "Sprite",
                    2.5,
                    "Soda",
                    0.5
            );
            repository.saveAll(
                    List.of(cocaCola, fantaa, sprite)
            );
        };

    }
}