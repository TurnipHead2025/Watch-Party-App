package com.watchparty.production;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductionService {
    private final ProductionRepository productionRepository;

    public ProductionService(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    // methods

    public List<Production> getAllProductions() {
        return productionRepository.findAll();
    }

    public Production getProductionById(Long id) {
        return productionRepository.findById(id).orElse(null);
    }

    public Production saveProduction(Production production) {
        return productionRepository.save(production);
    }

    public void deleteProduction(Long id) {
        productionRepository.deleteById(id);
    }

    public Production updateProduction(Long id, Production updatedProduction) {
        Production existingProduction = productionRepository.findById(id).orElse(null);
        if (existingProduction != null) {
            existingProduction.setTitle(updatedProduction.getTitle());
            existingProduction.setMediaType(updatedProduction.getMediaType());
            existingProduction.setDescription(updatedProduction.getDescription());
            return productionRepository.save(existingProduction);
        }
        return null;
    }
}
