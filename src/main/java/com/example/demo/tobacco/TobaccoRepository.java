package com.example.demo.tobacco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TobaccoRepository extends JpaRepository<Tobacco, Long> {
    List<Tobacco> findByCipher(String cipher);
}
