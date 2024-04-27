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

    public boolean productAvailable(String productCipher, Long quantity) {
        List<Inventory> inventory = null;
        if (productCipher.startsWith("A")) {
            inventory = inventoryRepository.findByAlcoholCipherContaining(productCipher);
        } else if (productCipher.startsWith("T")) {
            inventory = inventoryRepository.findByTobaccoCipherContaining(productCipher);
        } else if (productCipher.startsWith("S")) {
            inventory = inventoryRepository.findBySodaCipherContaining(productCipher);
        }

        assert inventory != null;
        if (!inventory.isEmpty()) {
            if (inventory.get(0).getQuantity() >= quantity) {
                inventoryRepository.updateQuantitySubtract(productCipher, quantity);
                return true;
            }
        }
        return false;
    }

    public double getPriceByCipher(String productCipher) {
        double inventory = 0;
        if (productCipher.startsWith("A")) {
            inventory = inventoryRepository.getPriceByAlcoholCipher(productCipher);
        } else if (productCipher.startsWith("T")) {
            inventory = inventoryRepository.getPriceByTobaccoCipher(productCipher);
        } else if (productCipher.startsWith("S")) {
            inventory = inventoryRepository.getPriceBySodaCipher(productCipher);
        }

        return inventory;
    }
}
