package com.example.demo.products.tobacco;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TobaccoConfig {
    @Bean
    CommandLineRunner commandLineRunnerTobacco(TobaccoRepository repository) {
        return args -> {
            Tobacco camel = new Tobacco(
                    "TC1",
                    "Camel",
                    2.0,
                    "Tobacco",
                    1,
                    "Slim"
            );

            Tobacco winston = new Tobacco(
                    "TC0",
                    "Winston",
                    3.0,
                    "Tobacco",
                    2,
                    "Regular"
            );
            Tobacco marlboro = new Tobacco(
                    "TC0",
                    "Marlboro",
                    4.0,
                    "Tobacco",
                    3,
                    "Regular"
            );
            Tobacco luckyStrike = new Tobacco(
                    "TP0",
                    "Hoyo De Monterrey",
                    30.0,
                    "Tobacco",
                    4,
                    "Light"
            );
            Tobacco dsf = new Tobacco(
                    "ABK",
                    "Hoyo De Monterrey",
                    30.0,
                    "Tobacco",
                    4,
                    "Light"
            );
            repository.saveAll(
                    List.of(camel, winston, marlboro, luckyStrike, dsf)
            );

        };
    }
}
