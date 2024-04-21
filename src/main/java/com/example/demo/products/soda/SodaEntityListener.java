package com.example.demo.products.soda;

public class SodaEntityListener {
    private static SodaRepository sodaRepository;

    public void setSodaRepository(SodaRepository repository) {
        SodaEntityListener.sodaRepository = repository;
    }

    public void prePersist(Soda soda) {
        // Generate unique cipher by appending a sequential number
        String baseCipher = soda.getCipher();
        int count = sodaRepository.countByCipherStartingWith(baseCipher);
        soda.setCipher(baseCipher + count);
    }
}
