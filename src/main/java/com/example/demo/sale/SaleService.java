package com.example.demo.sale;

import com.example.demo.delivery.Delivery;
import com.example.demo.inventory.InventoryRepository;
import com.example.demo.inventory.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    private SaleRepository saleRepository;
    private InventoryService inventoryService;

    @Autowired
    public SaleService(SaleRepository saleRepository, InventoryService inventoryService) {
        this.saleRepository = saleRepository;
        this.inventoryService = inventoryService;
    }

    public boolean addSale(String productCipher, Long quantity) {
        Sale sale = new Sale(productCipher, quantity);

        if (inventoryService.productAvailable(productCipher, quantity)) {
            saleRepository.save(sale);
            return true;
        }
        return false;
    }

    public double saleProfit() {
        List<Sale> sales = saleRepository.findAll();
        final double PROFIT = 1.2;

        double total = 0;
        for (Sale sale : sales) {
            String productCipher = sale.getProductCipher();

            double priceForCipher = inventoryService.getPriceByCipher(productCipher);

            total += PROFIT*(priceForCipher*sale.getQuantity());
        }
        return total;
    }
}
