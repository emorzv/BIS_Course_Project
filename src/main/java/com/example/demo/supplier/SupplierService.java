package com.example.demo.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;
    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }



    public List<Supplier> searchByCipher(String cipher) {
        System.out.println("Searching for supplier with cipher: " + cipher);
        List<Supplier> supplier = null;
        try {
            supplier = supplierRepository.findByCipherContaining(cipher);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return supplier;
    }

}
