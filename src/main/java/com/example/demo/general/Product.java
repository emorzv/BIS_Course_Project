package com.example.demo.general;

import com.example.demo.products.alcohol.Alcohol;
import com.example.demo.products.soda.Soda;
import com.example.demo.products.tobacco.Tobacco;

import java.util.List;

public class Product {

    private ProductType productType;

    private List<Alcohol> alcoholList;

    private List<Tobacco> tobaccoList;

    private List<Soda> sodaList;

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

    public List<Soda> getSodaList() {
        return sodaList;
    }

    public void setSodaList(List<Soda> sodaList) {
        this.sodaList = sodaList;
    }

}
