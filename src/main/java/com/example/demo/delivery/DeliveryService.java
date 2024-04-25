package com.example.demo.delivery;

import com.example.demo.inventory.InventoryService;
import com.example.demo.products.alcohol.Alcohol;
import com.example.demo.products.alcohol.AlcoholRepository;
import com.example.demo.products.soda.SodaRepository;
import com.example.demo.products.tobacco.TobaccoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        if (deliveryRepository.save(delivery) == null) {
            return false;
        }
        return true;
    }

    public List<Delivery> searchByProductName(String brand) {
        String cipher;
        if (!(cipher = alcoholRepository.findByBrand(brand).getCipher()).isEmpty()
                || !(cipher = tobaccoRepository.findByBrand(brand).getCipher()).isEmpty()
                || !(cipher = sodaRepository.findByBrand(brand).getCipher()).isEmpty()) {
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
}
