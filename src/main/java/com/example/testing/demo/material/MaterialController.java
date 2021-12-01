package com.example.testing.demo.material;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MaterialController {

    private MaterialManager materialManager;

    private final Logger LOG = LoggerFactory.getLogger(MaterialController.class);

    public MaterialController(MaterialManager materialManager) {
        this.materialManager = materialManager;
    }

    @GetMapping("/material")
    public String test() {

        LOG.error("Hehexd!");
        LOG.error(materialManager.findAll().toString());


        return "material_overview";

    }

}
