package com.watchparty.importer;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import com.watchparty.beat.Beat;
import com.watchparty.production.Production;
import com.watchparty.scene.Scene;

public class MarkdownProductionImporterTest {

    @Test
    public void importsHamiltonProductionStructure() {
        MarkdownProductionImporter importer = new MarkdownProductionImporter();

        Production production = importer.importProduction(
                Path.of("MarkdownProductions"),
                "Hamilton");

        assertNotNull(production);
        assertEquals("Hamilton", production.getTitle());
        assertEquals(2, production.getScenes().size());

        List<Scene> scenes = production.getScenes();
        assertFalse(scenes.get(0).getBeats().isEmpty());
        assertFalse(scenes.get(1).getBeats().isEmpty());

        Beat firstBeat = scenes.get(0).getBeats().get(0);
        assertNotNull(firstBeat.getContent());
        assertFalse(firstBeat.getContent().isBlank());
        assertEquals(scenes.get(0), firstBeat.getScene());
    }
}
