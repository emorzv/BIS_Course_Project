package com.example.demo.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping(value = "/")
    public String home() {
        return "index";
    }
    @RequestMapping(value = "/searchByProductCipher")
    public String searchByProductCipher() {
        return "searchByProductCipher";
    }
    @RequestMapping(value = "/searchDeliveryByProduct")
    public String searchDeliveryByProduct() {
        return "searchDeliveryByProduct";
    }

    @RequestMapping(value = "/addDeliveryForm")
    public String addDeliveryForm() {
        return "addDeliveryForm";
    }

    @RequestMapping(value = "/deliveryConfirmation")
    public String deliveryConfirmation() {
        return "deliveryConfirmation";
    }

    @RequestMapping(value = "/searchDeliveryByProductAndSupplier")
    public String searchDeliveryByProductAndSupplier() {
        return "searchDeliveryByProductAndSupplier";
    }

    @RequestMapping(value = "/searchSupplierByProductName")
    public String searchSupplierByProductName() {
        return "searchSupplierByProductName";
    }
}
