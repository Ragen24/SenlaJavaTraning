package com.senlatask.bookstore.util;

import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;
import com.senlatask.bookstore.model.Model;
import com.senlatask.bookstore.model.models.Request;

/**
 * Requests save util class with properties
 * <b>FILE</b> — file path
 */
public class RequestFileUtil implements FileUtil<Request> {
    private static final String FILE = "Saves/Request.txt";

    private final FileWorker fileWorker;

    public RequestFileUtil() {
        fileWorker = new TextFileWorker(FILE);
    }

    /**
     * Read requests from file
     * @return requests
     */
    @Override
    public Request[] readFromFile() {
        final String[] lines = fileWorker.readFromFile();

        if (lines == null || lines.length == 0) {
            throw new IllegalArgumentException();
        }

        final Request[] result = new Request[lines.length];

        for (int i = 0; i < lines.length; i++) {
            result[i] = fromLine(lines[i]);
        }

        return result;
    }

    /**
     * Write requests to file
     * @param values the values
     */
    @Override
    public void writeToFile(Request[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException();
        }
        final String[] lines = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            lines[i] = toLine(values[i]);
        }
        fileWorker.writeToFile(lines);
    }

    /**
     * Transform entities to string
     * @param entity the entity
     * @return string
     */
    @Override
    public String toLine(Request entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        final String[] array = new String[] {
                String.valueOf(entity.getId()),
                String.valueOf(entity.getBook().getId())
        };
        return String.join(";", array);
    }

    /**
     * Transform string to entities
     * @param line the line
     * @return book
     */
    @Override
    public Request fromLine(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final String[] parts = line.split(";");

        final Request result = new Request(
                Model.getInstance().getById(Long.parseLong(parts[1]))
        );
        result.setId(Long.parseLong(parts[0]));
        return result;
    }
}
