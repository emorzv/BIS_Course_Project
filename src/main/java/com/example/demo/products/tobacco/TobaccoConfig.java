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
                    "TCC",
                    "Camel",
                    2.0,
                    "Tobacco",
                    "Slim"
            );

            Tobacco winston = new Tobacco(
                    "TCW",
                    "Winston",
                    3.0,
                    "Tobacco",
                    "Regular"
            );
            Tobacco marlboro = new Tobacco(
                    "TCM",
                    "Marlboro",
                    4.0,
                    "Tobacco",
                    "Regular"
            );
            Tobacco hoyoDeMonterrey = new Tobacco(
                    "TPH",
                    "Hoyo De Monterrey",
                    30.0,
                    "Tobacco",
                    "Light"
            );
            Tobacco cohiba = new Tobacco(
                    "TPC",
                    "Cohiba",
                    30.0,
                    "Tobacco",
                    "Strong"
            );

            Tobacco davidoff = new Tobacco(
                    "TPD",
                    "Davidoff",
                    30.0,
                    "Tobacco",
                    "Strong"
            );


            repository.saveAll(
                    List.of(camel, winston, marlboro, hoyoDeMonterrey, cohiba, davidoff)
            );

        };
    }
}
