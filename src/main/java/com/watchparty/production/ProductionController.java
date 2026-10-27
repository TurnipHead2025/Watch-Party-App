package com.watchparty.production;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductionController {
    final private ProductionService productionService;

    public ProductionController(ProductionService productionService) {
        this.productionService = productionService;
    }

    //methods

    @GetMapping("/productions")
    public List<Production> getAllProductions() {
        return productionService.getAllProductions();
    }

    @GetMapping("/productions/{id}")
    public Production getProductionById(@PathVariable Long id) {
        return productionService.getProductionById(id);
    }

    @PostMapping("/productions")
    public Production saveProduction(@RequestBody Production production) {
        return productionService.saveProduction(production);
    }  
    
    @DeleteMapping("/productions/{id}")
    public void deleteProduction(@PathVariable Long id) {
        productionService.deleteProduction(id);
    }  
     
    

    
}
