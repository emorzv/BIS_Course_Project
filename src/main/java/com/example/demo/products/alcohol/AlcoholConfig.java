package com.example.demo.products.alcohol;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AlcoholConfig {
    @Bean
    CommandLineRunner commandLineRunnerAlcohol(AlcoholRepository repository) {
        return args -> {
            Alcohol ABH = new Alcohol(
                    "ABH",
                    "Heineken",
                    2.5,
                    "Beer",
                    0.7
                    );

            Alcohol ABA = new Alcohol(
                    "ABA",
                    "Ariana",
                    2.0,
                    "Beer Light",
                    0.5
            );
            Alcohol ABP = new Alcohol(
                    "ABP",
                    "Pirinsko",
                    2.0,
                    "Beer Light",
                    0.5
            );
            Alcohol ABT = new Alcohol(
                    "ABT",
                    "Tuborg",
                    2.0,
                    "Beer Light",
                    0.5
            );
            Alcohol ABK = new Alcohol(
                    "ABK",
                    "Kamenitza",
                    2.0,
                    "Beer Light",
                    0.5
            );

            Alcohol AWO = new Alcohol(
                    "AWO",
                    "Bratanov",
                    30.0,
                    "Wine Red",
                    3.0
            );
            Alcohol AWE = new Alcohol(
                    "AWE",
                    "Bratanov",
                    30.0,
                    "Wine Red",
                    3.0
            );
            Alcohol AWW = new Alcohol(
                    "AWW",
                    "Bratanov",
                    30.0,
                    "Wine Red",
                    3.0
            );

            Alcohol AHWW = new Alcohol(
                    "AHWW",
                    "JohnyWalker",
                    30.0,
                    "Wine Red",
                    1.0
            );
            Alcohol AHWD = new Alcohol(
                    "AHWD",
                    "JackDaniels",
                    30.0,
                    "Wine Red",
                    1.0
            );
            Alcohol AHWB = new Alcohol(
                    "AHWB",
                    "JimBeam",
                    30.0,
                    "Wine Red",
                    1.0
            );

            Alcohol AHVB = new Alcohol(
                    "AHVB",
                    "Beluga",
                    30.0,
                    "Wine Red",
                    1.0
            );
            Alcohol AHVG = new Alcohol(
                    "AHWG",
                    "Goose",
                    30.0,
                    "Wine Red",
                    1.0
            );
            Alcohol AHVC = new Alcohol(
                    "AHVC",
                    "Ciroc",
                    30.0,
                    "Wine Red",
                    1.0
            );
            repository.saveAll(
                    List.of(ABH, ABA, ABP, ABT, ABK, AWO, AWE, AWW, AHWW, AHWD, AHWB, AHVB, AHVG, AHVC)
            );

        };

    }
}
