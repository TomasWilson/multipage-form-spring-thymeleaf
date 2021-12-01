package com.example.testing.demo.material;


import org.javamoney.moneta.Money;
import org.salespointframework.core.DataInitializer;
import org.springframework.stereotype.Component;

@Component
public class MaterialDataInitializer implements DataInitializer {

    MaterialManager materialManager;

    public MaterialDataInitializer(MaterialManager materialManager) {
        this.materialManager = materialManager;
    }

    @Override
    public void initialize() {

        Material testMat1 = new Material(
                "Holzsarg",
                "Ein einfacher Sarg",
                Money.of(300, "EUR"),
                Money.of(500, "EUR"),
                MaterialType.CASKET);

        materialManager.registerMaterial(testMat1);

    }

}
