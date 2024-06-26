package com.example.demo.general;

import com.example.demo.alcohol.Alcohol;
import com.example.demo.tobacco.Tobacco;

import java.util.List;

public class Product {

    private ProductType productType;

    private List<Alcohol> alcoholList;

    private List<Tobacco> tobaccoList;
    // TODO: add soda


    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public List<Alcohol> getAlcoholList() {
        return alcoholList;
    }

    public void setAlcoholList(List<Alcohol> alcoholList) {
        this.alcoholList = alcoholList;
    }

    public List<Tobacco> getTobaccoList() {
        return tobaccoList;
    }

    public void setTobaccoList(List<Tobacco> tobaccoList) {
        this.tobaccoList = tobaccoList;
    }
}
