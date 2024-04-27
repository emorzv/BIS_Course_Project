package com.example.demo.general;

import com.example.demo.delivery.DeliveryService;
import com.example.demo.sale.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    private final DeliveryService deliveryService;
    private final SaleService saleService;

    @Autowired
    public WebController(DeliveryService deliveryService, SaleService saleService) {
        this.deliveryService = deliveryService;
        this.saleService = saleService;
    }

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

    @RequestMapping(value = "/addSaleForm")
    public String addSaleForm() {
        return "addSaleForm";
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

    @RequestMapping(value = "/searchMostDeliveries")
    public String searchMostDeliveries() {
        return "searchMostDeliveries";
    }

    @RequestMapping(value = "/report")
    public String getProfitAndExpense(Model model) {
        double expenses = deliveryService.deliveryExpenses();
        double profit = saleService.saleProfit();
        model.addAttribute("deliveriesExpenses", expenses);
        model.addAttribute("salesProfit", profit);
        return "report";
    }
}
