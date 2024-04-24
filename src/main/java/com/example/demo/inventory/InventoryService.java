package com.example.demo.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public void newDelivery(String productCipher, Long quantity) {
        if (productCipher.startsWith("A")) {
            if (inventoryRepository.existsByAlcoholCipher(productCipher)) {
                System.out.println("Alcohol exists in inventory");
                inventoryRepository.updateQuantity(productCipher, quantity);
            } else {
                System.out.println("Alcohol DOES NOT exist in inventory");
                inventoryRepository.save(new Inventory(productCipher, quantity));
                inventoryRepository.updateAlcoholCipherInInventory(productCipher);
            }
        }
    }


    public List<Inventory> searchByCipher(String cipher) {
        if (cipher.startsWith("A")) {
            return inventoryRepository.findByAlcoholCipherContaining(cipher);
        } else
            return inventoryRepository.findByAlcoholCipherContaining(cipher);
    }
}
