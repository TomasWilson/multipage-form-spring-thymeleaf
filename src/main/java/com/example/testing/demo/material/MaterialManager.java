package com.example.testing.demo.material;

import org.salespointframework.catalog.Catalog;
import org.salespointframework.inventory.InventoryItems;
import org.salespointframework.inventory.MultiInventory;
import org.salespointframework.inventory.MultiInventoryItem;
import org.salespointframework.quantity.Quantity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class MaterialManager {

    MaterialMultiInventory materialMultiInventory;

    MaterialCatalog materialCatalog;

    public MaterialManager(MaterialMultiInventory materialMultiInventory, MaterialCatalog materialCatalog) {
        this.materialMultiInventory = materialMultiInventory;
        this.materialCatalog = materialCatalog;
    }

    // adds a new material to the stock, by creating a MultiInventoryItem for each existing StockType
    public void registerMaterial(Material material) {

        materialCatalog.save(material);

        for(StockType stockType : StockType.values()) {
            MaterialInventoryItem mat = new MaterialInventoryItem(material, Quantity.of(0), stockType);
            materialMultiInventory.save(mat);
        }

    }

    // returns true if the material is registered in the repository
    public boolean materialExists(Material material) {
        return materialMultiInventory.existsByProductId(material.getId());
    }

    public InventoryItems<MaterialInventoryItem> findByMaterial(Material material) {
        return materialMultiInventory.findByProduct(material);
    }

    public List<MaterialInventoryItem> findAll() {
        return materialMultiInventory.findAll().stream().collect(Collectors.toList());
    }


}
