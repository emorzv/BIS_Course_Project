package com.example.demo.alcohol;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AlcoholConfig {
    @Bean
    CommandLineRunner commandLineRunnerAlcohol(AlcoholRepository repository) {
        return args -> {
            Alcohol vodka = new Alcohol(
                    "AH",
                    "Savoy",
                    10.0,
                    "Vodka",
                    1,
                    0.7
                    );

            Alcohol bear = new Alcohol(
                    "ABL",
                    "Heineken",
                    2.0,
                    "Beer Light",
                    2,
                    0.5
            );
            Alcohol wine = new Alcohol(
                    "AWO",
                    "Bratanov",
                    30.0,
                    "Wine Red",
                    1,
                    3.0
            );
            Alcohol wiskey = new Alcohol(
                    "AH",
                    "Bratanov",
                    30.0,
                    "Wine Red",
                    3,
                    1.0
            );
            repository.saveAll(
                    List.of(vodka, bear, wine, wiskey)
            );

        };

    }
}
