package com.example.demo.alcohol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlcoholRepository  extends JpaRepository<Alcohol, Long> {
    List<Alcohol> findByCipher(String cipher);
}
