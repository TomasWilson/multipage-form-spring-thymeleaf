package com.example.testing.demo.material;

import org.salespointframework.catalog.ProductIdentifier;
import org.salespointframework.inventory.MultiInventory;
import org.springframework.data.jpa.repository.Query;


public interface MaterialMultiInventory extends MultiInventory<MaterialInventoryItem> {

    default boolean existsByProductId(ProductIdentifier productIdentifier) {
        return !findByProductIdentifier(productIdentifier).isEmpty();
    }

}
