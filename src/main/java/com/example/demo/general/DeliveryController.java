package com.example.demo.general;

import com.example.demo.delivery.Delivery;
import com.example.demo.delivery.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DeliveryController {
    private final DeliveryService deliveryService;
    private final ProductService productService;
    @Autowired
    public DeliveryController(ProductService productService, DeliveryService deliveryService) {
        this.productService = productService;
        this.deliveryService = deliveryService;
    }

    @PostMapping("/addDelivery")
    public String addDelivery(
            @RequestParam("supplierId") Long supplierId,
            @RequestParam("productId") Long productId,
            @RequestParam("quantity") Long quantity) {

        // Create and save the new delivery
        deliveryService.addDelivery(supplierId, productId, quantity);

        // Redirect to a confirmation page or any other appropriate page
        return "redirect:/deliveryConfirmation";
    }

    public void deleteDelivery(Long deliveryId) {
        deliveryService.deleteDelivery(deliveryId);
    }

    @GetMapping(path = "/search/deliveries")
    public String getDelqiveriesForProducts(@RequestParam String cipher, Model model) {
        Product products = this.productService.searchByCipher(cipher);
        model.addAttribute("deliveries", deliveryService.getDeliveriesForProducts(products));

        return "listOfDeliveries";
    }
}
