package com.example.demo.tobacco;


import com.example.demo.alcohol.Alcohol;
import com.example.demo.alcohol.AlcoholRepository;
import jakarta.persistence.PrePersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TobaccoEntityListener {

    private static TobaccoRepository tobaccoRepository;

    @Autowired
    public void setAlcoholRepository(TobaccoRepository repository) {
        TobaccoEntityListener.tobaccoRepository = repository;
    }
    @PrePersist
    public void prePersist(Tobacco tobacco) {
        // Generate unique cipher by appending a sequential number
        String baseCipher = tobacco.getCipher();
        int count = tobaccoRepository.countByCipherStartingWith(baseCipher);
        tobacco.setCipher(baseCipher + count);
    }
}
