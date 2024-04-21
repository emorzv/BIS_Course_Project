package com.example.demo.supplier;

import com.example.demo.products.alcohol.AlcoholEntityListener;
import com.example.demo.products.alcohol.AlcoholRepository;
import jakarta.persistence.PrePersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SupplierEntityListener {
    private static SupplierRepository supplierRepository;
    @Autowired
    public void setAlcoholRepository(SupplierRepository repository) {
        SupplierEntityListener.supplierRepository = repository;
    }

    @PrePersist
    public static void prePersist(Supplier supplier) {
        // Generate unique cipher by appending a sequential number
        String baseCipher = supplier.getCipher();
        int count = supplierRepository.countByCipherStartingWith(baseCipher);
        supplier.setCipher(baseCipher + count);
    }

}
