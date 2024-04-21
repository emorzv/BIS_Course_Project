package com.example.demo.soda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SodaRepository extends JpaRepository<Soda, Long> {
    List<Soda> findByCipherContaining(String cipher);

    int countByCipherStartingWith(String baseCipher);
}