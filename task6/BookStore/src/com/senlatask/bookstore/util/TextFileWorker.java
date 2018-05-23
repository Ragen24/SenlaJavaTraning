package com.senlatask.bookstore.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

/**
 * Util class for reading/writing text files
 */
public final class TextFileWorker {

    private final static Charset FILE_ENCODING = StandardCharsets.UTF_8;
    private final static String FILE_PATH_IS_EMPTY = "File path cannot be empty or null";

    // Path to file
    private final Path path;

    /**
     * Constructor of TextFileWorker. Check file path and initialize class instance.
     *
     * @param filePath the file path
     */
    public TextFileWorker(final String filePath) {

        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException(FILE_PATH_IS_EMPTY);
        }

        this.path = Paths.get(filePath);

        try {
            if (!Files.exists(this.path)) {
                Files.createFile(this.path);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Read all lines from a file and return String array. This method ensures that the
     * file is closed when all bytes have been read.
     *
     * @return the string[]
     */
    public String[] readFromFile() {
        try {
            List<String> lines = Files.readAllLines(path, FILE_ENCODING);

            if (lines != null) {
                return lines.toArray(new String[lines.size()]);
            } else {
                return new String[0];
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Write lines of text to a file. Each line is a char sequence and is written to
     * the file in sequence with each line terminated by the platform's line separator,
     * as defined by the system property line.separator.
     *
     * @param values the values
     */
    public void writeToFile(final String[] values) {

        if (values != null && values.length > 0) {
            List<String> lines = Arrays.asList(values);
            try {
                Files.write(path, lines, FILE_ENCODING, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}