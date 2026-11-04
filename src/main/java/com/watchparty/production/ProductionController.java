package com.watchparty.production;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public Page<Production> getAllProductions(Pageable pageable) {
        return productionService.getAllProductions(pageable);
    }

    @GetMapping("/productions/{id}")
    public Production getProductionById(@PathVariable("id") Long id) {
        return productionService.getProductionById(id);
    }

    @PostMapping("/productions")
    public Production saveProduction(@RequestBody Production production) {
        return productionService.saveProduction(production);
    }  
    
    @DeleteMapping("/productions/{id}")
    public void deleteProduction(@PathVariable("id") Long id) {
        productionService.deleteProduction(id);
    }  

    @PutMapping("/productions/{id}")
    public Production updateProduction(@PathVariable("id") Long id,
        @RequestBody Production updatedProduction) {
        return productionService.updateProduction(id, updatedProduction);
    }
     
    

    
}
