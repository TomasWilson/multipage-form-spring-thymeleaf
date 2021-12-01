package com.example.testing.demo.material;

import org.javamoney.moneta.Money;
import org.salespointframework.catalog.Product;

import javax.money.MonetaryAmount;
import javax.persistence.Entity;

@Entity
public class Material extends Product {

    private String description;

    // Product already has a "price" attribute, which we use, to model the selling Price
    // (i.e. what the customer will be charged)
    // however, we also want to model the purchasing price:
    @SuppressWarnings("JpaAttributeTypeInspection")
    private MonetaryAmount purchasingPrice;

    private MaterialType materialType;

    @SuppressWarnings("unused, deprecation")
    public Material() {}

    public Material(String name, String description, Money purchasingPrice, Money sellingPrice, MaterialType materialType) {
        super(name, sellingPrice);
        this.description = description;
        this.purchasingPrice = purchasingPrice;
        this.materialType = materialType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MonetaryAmount getPurchasingPrice() {
        return purchasingPrice;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    @Override
    public String toString() {
        return String.format("Material(name=%s, desc=%s, price=%s, purchasingPrice=%s, materialType=%s)",
                getName(), getDescription(), getPrice(), getPurchasingPrice(), getMaterialType().toString());
    }

}
