package com.example.demo.products.tobacco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TobaccoRepository extends JpaRepository<Tobacco, Long> {
    List<Tobacco> findByCipherContaining(String cipher);

    int countByCipherStartingWith(String baseCipher);
}
