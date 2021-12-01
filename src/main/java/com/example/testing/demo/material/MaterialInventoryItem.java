package com.example.testing.demo.material;

import org.salespointframework.catalog.Product;
import org.salespointframework.inventory.MultiInventoryItem;
import org.salespointframework.quantity.Quantity;

import javax.persistence.Entity;

@Entity
public class MaterialInventoryItem extends MultiInventoryItem {

    private StockType stockType;

    @SuppressWarnings("unused")
    public MaterialInventoryItem() { }

    public MaterialInventoryItem(Material material, Quantity quantity, StockType stockType) {
        super(material, quantity);
        this.stockType = stockType;
    }

    public StockType getStockType() {
        return stockType;
    }

    public Material getMaterial() {
        return (Material) getProduct();
    }

    @Override
    public String toString() {

        return String.format("%s(for Material(%s) and StockType %s)",
                getClass().getSimpleName(), getMaterial().toString(), stockType.toString());

    }

}
