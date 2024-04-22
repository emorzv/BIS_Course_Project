package com.example.demo.products.alcohol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlcoholRepository extends JpaRepository<Alcohol, Long> {
    List<Alcohol> findByCipherContaining(String cipher);
    int countByCipherStartingWith(String baseCipher);
}
