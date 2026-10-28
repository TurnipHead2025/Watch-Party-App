package com.watchparty.importer;

import java.nio.file.Path;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.watchparty.production.Production;
import com.watchparty.production.ProductionService;



@RestController
public class ImportController {
    private final MarkdownProductionImporter markdownProductionImporter;
    private final ProductionService productionService;

    public ImportController(MarkdownProductionImporter markdownProductionImporter, ProductionService productionService) {
        this.markdownProductionImporter = markdownProductionImporter;
        this.productionService = productionService;
    }

    @PostMapping("/imports/{productionName}")
    public Production importProduction(@PathVariable String productionName) {
        Production production = markdownProductionImporter.importProduction(
                Path.of("MarkdownProductions"),
                productionName);

        return productionService.saveProduction(production);
    }
}
