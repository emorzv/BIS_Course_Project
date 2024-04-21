package com.example.demo.supplier;

import com.example.demo.products.tobacco.Tobacco;
import com.example.demo.products.tobacco.TobaccoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SupplierConfig {
    @Bean
    CommandLineRunner commandLineRunnerSupplier(SupplierRepository repository) {
        return args -> {
            Supplier supplier1 = new Supplier(
                    "Ivan",
                    "SA"
            );

            Supplier supplier2 = new Supplier(
                    "Pesho",
                    "ST"
            );

            Supplier supplier3 = new Supplier(
                    "Gosho",
                    "SS"
            );

            repository.saveAll(
                    List.of(supplier1, supplier2, supplier3)
            );

        };
    }
}
