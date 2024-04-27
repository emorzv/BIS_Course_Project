package com.example.demo.delivery;

import com.example.demo.inventory.InventoryService;
import com.example.demo.products.alcohol.Alcohol;
import com.example.demo.products.alcohol.AlcoholRepository;
import com.example.demo.products.soda.Soda;
import com.example.demo.products.soda.SodaRepository;
import com.example.demo.products.tobacco.Tobacco;
import com.example.demo.products.tobacco.TobaccoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final AlcoholRepository alcoholRepository;
    private final TobaccoRepository tobaccoRepository;
    private final SodaRepository sodaRepository;
    private final InventoryService inventoryService;
    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository, AlcoholRepository alcoholRepository, TobaccoRepository tobaccoRepository, SodaRepository sodaRepository, InventoryService inventoryService) {
        this.deliveryRepository = deliveryRepository;
        this.alcoholRepository = alcoholRepository;
        this.tobaccoRepository = tobaccoRepository;
        this.sodaRepository = sodaRepository;
        this.inventoryService = inventoryService;
    }

    public void deleteDelivery(Long deliveryId) {
        deliveryRepository.deleteById(deliveryId);
    }

//    public List<Delivery> getDeliveriesForProducts(Product products) {
//        List<Delivery> allDeliveries = new ArrayList<>();
//        if (products.getProductType().equals(ProductType.ALCOHOL)) {
//
//            for (Alcohol product : products.getAlcoholList()) {
//                List<Delivery> deliveriesForProduct = deliveryRepository.findByProductCipher(product.getCipher());
//                allDeliveries.addAll(deliveriesForProduct);
//            }
//        }
//        if (products.getProductType().equals(ProductType.TOBACCO)) {
//
//            for (Tobacco product : products.getTobaccoList()) {
//                List<Delivery> deliveriesForProduct = deliveryRepository.findByProductCipher(product.getCipher());
//                allDeliveries.addAll(deliveriesForProduct);
//            }
//        }
//
//        return allDeliveries;
//    }

    public List<Delivery> searchByCipher(String cipher) {
        return deliveryRepository.findByProductCipherContaining(cipher);
    }

    public List<Delivery> searchByCipherAndSupplier(String productCipher, String supplierCipher) {
        return deliveryRepository.findByProductCipherAndSupplierCipherContaining(productCipher, supplierCipher);
    }

    public List<Delivery> searchBySupplier(String supplierCipher) {
        return deliveryRepository.findBySupplierCipherContaining(supplierCipher);
    }

    // TODO: Delivery should specify the product type

    //TODO: Validate that the supplier exists

    //TODO: Validate that the product exists

    //TODO: Is this enough to add a delivery?

    public boolean addDelivery(String supplierCipher, String productCipher, Long quantity) {
        Delivery delivery = new Delivery(supplierCipher, productCipher, quantity);

        inventoryService.newDelivery(productCipher, quantity);

        deliveryRepository.save(delivery);
        return true;
    }

    public List<Delivery> searchByProductName(String brand) {
        // Find alcohol, tobacco, and soda once
        Alcohol alcohol = alcoholRepository.findByBrand(brand);
        Tobacco tobacco = tobaccoRepository.findByBrand(brand);
        Soda soda = sodaRepository.findByBrand(brand);

// Check if any of them exist and have a non-empty cipher
        if ((alcohol != null && !alcohol.getCipher().isEmpty())
                || (tobacco != null && !tobacco.getCipher().isEmpty())
                || (soda != null && !soda.getCipher().isEmpty())) {
            // Determine the cipher
            String cipher = "";
            if (alcohol != null && !alcohol.getCipher().isEmpty()) {
                cipher = alcohol.getCipher();
            } else if (tobacco != null && !tobacco.getCipher().isEmpty()) {
                cipher = tobacco.getCipher();
            } else {
                cipher = soda.getCipher();
            }
            // Return delivery by product cipher
            return deliveryRepository.findByProductCipher(cipher);
        }
        return null;
    }

    public Delivery getQuantity(String productCipher, String supplierCipher) {
        List<Delivery> deliveries = searchByCipherAndSupplier(productCipher, supplierCipher);
        Long quantity = 0L;
        for (Delivery delivery : deliveries) {
            quantity += delivery.getQuantity();
        }
        return new Delivery(supplierCipher, productCipher, quantity);
    }

    public Map<String, Long> getMostDelivered(String supplierCipher) {
        List<Delivery> deliveries = deliveryRepository.findBySupplierCipherContaining(supplierCipher);
        Map<String, Long> entries = new HashMap<>();

        for (Delivery delivery : deliveries) {
            if (entries.containsKey(delivery.getProductCipher())) {
                entries.put(delivery.getProductCipher(), entries.get(delivery.getProductCipher()) + delivery.getQuantity());
            } else {
                entries.put(delivery.getProductCipher(), delivery.getQuantity());
            }
        }

        return sortByValue(entries, false);
    }

    private static Map<String, Long> sortByValue(Map<String, Long> unsortedMap, final boolean ascending) {
        List<Map.Entry<String, Long>> list = new LinkedList<>(unsortedMap.entrySet());

        // Sorting the list based on values
        list.sort((o1, o2) -> ascending ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }

    public double deliveryExpenses() {
        List<Delivery> deliveries = deliveryRepository.findAll();

        double total = 0;
        for (Delivery delivery : deliveries) {
            String productCipher = delivery.getProductCipher();

            double priceForCipher = inventoryService.getPriceByCipher(productCipher);

            total += (priceForCipher*delivery.getQuantity());
        }
        return total;
    }
}
