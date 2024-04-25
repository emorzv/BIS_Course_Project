package com.example.demo.products.soda;

import com.example.demo.products.alcohol.Alcohol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SodaRepository extends JpaRepository<Soda, Long> {
    List<Soda> findByCipherContaining(String cipher);

    int countByCipherStartingWith(String baseCipher);

    Soda findByBrand(String brand);
}