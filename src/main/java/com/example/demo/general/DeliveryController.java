package com.example.demo.general;

import com.example.demo.delivery.Delivery;
import com.example.demo.delivery.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
            @RequestParam("quantity") Long quantity,
            RedirectAttributes redirectAttributes,
            Model model) {

        // Create and save the new delivery
        boolean isSuccess = deliveryService.addDelivery(supplierId, productId, quantity);

        if (isSuccess) {
            // Add a flash attribute to indicate that delivery was added
            redirectAttributes.addFlashAttribute("deliveryAdded", true);
        } else {
            // If delivery was not added successfully, add an error message to the model
            model.addAttribute("errorMessage", "Error occurred while adding delivery");
        }

        // Redirect to the same page
        return "redirect:/addDeliveryForm";
    }


    public void deleteDelivery(Long deliveryId) {
        deliveryService.deleteDelivery(deliveryId);
    }

    @GetMapping(path = "/search/deliveries")
    public String getDelqiveriesForProducts(@RequestParam String cipher, Model model) {
        Product products = this.productService.searchByCipher(cipher);
        model.addAttribute("deliveries", deliveryService.getDeliveriesForProducts(products));
        model.addAttribute("products", products);

        return "listOfDeliveries";
    }
}
