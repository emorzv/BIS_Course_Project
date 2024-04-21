package com.example.demo.alcohol;


import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlcoholEntityListener {

    private static AlcoholRepository alcoholRepository;

    @Autowired
    public void setAlcoholRepository(AlcoholRepository repository) {
        AlcoholEntityListener.alcoholRepository = repository;
    }
    @PrePersist
    public void prePersist(Alcohol alcohol) {
        // Generate unique cipher by appending a sequential number
        String baseCipher = alcohol.getCipher();
        int count = alcoholRepository.countByCipherStartingWith(baseCipher);
        alcohol.setCipher(baseCipher + count);
    }
}
