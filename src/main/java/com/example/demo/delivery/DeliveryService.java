package com.example.demo.delivery;

import com.example.demo.alcohol.Alcohol;
import com.example.demo.general.Product;
import com.example.demo.general.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryService {
private final DeliveryRepository deliveryRepository;
    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public void deleteDelivery(Long deliveryId) {
        deliveryRepository.deleteById(deliveryId);
    }

    public List<Delivery> getDeliveriesForProducts(Product products) {
        List<Delivery> allDeliveries = new ArrayList<>();
        if (products.getProductType().equals(ProductType.ALCOHOL)) {

            for (Alcohol product : products.getAlcoholList()) {
                List<Delivery> deliveriesForProduct = deliveryRepository.findByProductId(product.getProductID());
                allDeliveries.addAll(deliveriesForProduct);
            }
        }

        return allDeliveries;
    }

    public void addDelivery(Long supplierId, Long productId, Long quantity) {
        Delivery delivery = new Delivery(supplierId, productId, quantity);
        deliveryRepository.save(delivery);
    }
}
