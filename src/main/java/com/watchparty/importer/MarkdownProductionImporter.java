package com.watchparty.importer;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.watchparty.beat.Beat;
import com.watchparty.production.Production;
import com.watchparty.scene.Scene;


//This importer was built by AI. 

// The MarkdownProductionImporter class is responsible for importing a production from a directory containing markdown files. It reads the markdown files, parses them, and creates a Production object that represents the production.


@Service
public class MarkdownProductionImporter {
    // Import every production folder found inside the parent productions directory.
    public List<Production> importProductions(Path productionsDirectory) {
        if (!Files.isDirectory(productionsDirectory)) {
            throw new IllegalArgumentException("Production directory does not exist.");
        }

        List<Production> productions = new ArrayList<>();

        try (Stream<Path> productionDirectories = Files.list(productionsDirectory)) {
            productionDirectories
                    .filter(Files::isDirectory)
                    .sorted()
                    .forEach(directory -> {
                        try {
                            productions.add(importProduction(directory));
                        } catch (IOException exception) {
                            throw new UncheckedIOException(exception);
                        }
                    });
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }

        return productions;
    }

    // Import one named production folder from the parent productions directory.
    public Production importProduction(Path productionsDirectory, String productionName) {
        Path productionDirectory = productionsDirectory.resolve(productionName);

        if (!Files.isDirectory(productionDirectory)) {
            throw new IllegalArgumentException("Production directory does not exist.");
        }

        try {
            return importProduction(productionDirectory);
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

    // Build one Production object from its Act folders and Markdown files.
    private Production importProduction(Path productionDirectory) throws IOException {
        List<Scene> scenes = new ArrayList<>();
        Production production = new Production(
                productionDirectory.getFileName().toString(),
                "Unknown",
                scenes,
                "");

        try (Stream<Path> actDirectories = Files.list(productionDirectory)) {
            List<Path> acts = actDirectories
                    .filter(Files::isDirectory)
                    .sorted()
                    .toList();

            int sceneNumber = 1;
            for (Path actDirectory : acts) {
                Scene scene = new Scene(
                        sceneNumber++,
                        actDirectory.getFileName().toString(),
                        new ArrayList<>(),
                        production);

                try (Stream<Path> markdownFiles = Files.list(actDirectory)) {
                    markdownFiles
                            .filter(path -> path.toString().endsWith(".md"))
                            .sorted(Comparator.comparingInt(this::fileNumber))
                            .forEach(path -> {
                                try {
                                    ParsedBeat parsedBeat = parseBeat(path);
                                    Beat beat = new Beat(
                                            parsedBeat.content(),
                                            parsedBeat.setLayout(),
                                            parsedBeat.lighting(),
                                            parsedBeat.blocking());
                                    beat.setScene(scene);
                                    scene.getBeats().add(beat);
                                } catch (IOException exception) {
                                    throw new UncheckedIOException(exception);
                                }
                            });
                }

                scenes.add(scene);
            }
        }

        return production;
    }

    // Extract the numeric song/beat order from filenames such as S1_Title.md or S10_Title.md.
    private int fileNumber(Path markdownFile) {
        Pattern pattern = Pattern.compile("^S(\\d+)_.*\\.md$");
        Matcher matcher = pattern.matcher(markdownFile.getFileName().toString());

        if (matcher.matches()) {
            return Integer.parseInt(matcher.group(1));
        }

        return Integer.MAX_VALUE;
    }

    // Read one Markdown file and extract the values needed to create a Beat.
    private ParsedBeat parseBeat(Path markdownFile) throws IOException {
        List<String> lines = Files.readAllLines(markdownFile);
        int frontMatterEnd = findFrontMatterEnd(lines);

        String setLayout = metadataValue(lines, "Set Layout:", frontMatterEnd);
        String lighting = metadataValue(lines, "Lighting:", frontMatterEnd);
        String blocking = metadataList(lines, "Blocking Elements:", frontMatterEnd);
        String content = contentSection(lines, frontMatterEnd);

        return new ParsedBeat(content, setLayout, lighting, blocking);
    }

    // Find the closing --- marker for the file's metadata section.
    private int findFrontMatterEnd(List<String> lines) {
        for (int lineNumber = 1; lineNumber < lines.size(); lineNumber++) {
            if (lines.get(lineNumber).trim().equals("---")) {
                return lineNumber;
            }
        }
        throw new IllegalArgumentException("Markdown file is missing front matter closing marker.");
    }

    // Read one text value, such as Set Layout or Lighting, from the metadata.
    private String metadataValue(List<String> lines, String key, int frontMatterEnd) {
        for (int lineNumber = 1; lineNumber < frontMatterEnd; lineNumber++) {
            if (lines.get(lineNumber).startsWith(key)) {
                return lines.get(lineNumber).substring(key.length()).trim();
            }
        }
        return "";
    }

    // Read a list of metadata lines, such as the Blocking Elements list.
    private String metadataList(List<String> lines, String key, int frontMatterEnd) {
        List<String> values = new ArrayList<>();
        boolean readingValues = false;

        for (int lineNumber = 1; lineNumber < frontMatterEnd; lineNumber++) {
            String line = lines.get(lineNumber);
            if (line.startsWith(key)) {
                readingValues = true;
            } else if (readingValues && line.trim().startsWith("-")) {
                values.add(line.trim().substring(1).trim());
            } else if (readingValues && !line.trim().isEmpty()) {
                break;
            }
        }

        return String.join(System.lineSeparator(), values);
    }

    // Read the text between the ## Content heading and the next section heading.
    private String contentSection(List<String> lines, int frontMatterEnd) {
        int contentStart = -1;
        for (int lineNumber = frontMatterEnd + 1; lineNumber < lines.size(); lineNumber++) {
            if (lines.get(lineNumber).trim().equals("## Content")) {
                contentStart = lineNumber + 1;
                break;
            }
        }

        if (contentStart < 0) {
            return "";
        }

        int contentEnd = lines.size();
        for (int lineNumber = contentStart; lineNumber < lines.size(); lineNumber++) {
            if (lines.get(lineNumber).startsWith("## ")) {
                contentEnd = lineNumber;
                break;
            }
        }

        return String.join(System.lineSeparator(), lines.subList(contentStart, contentEnd)).trim();
    }

    private record ParsedBeat(String content, String setLayout, String lighting, String blocking) {
    }

}
