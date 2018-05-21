package com.senlatask.bookstore.util;

import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;
import com.senlatask.bookstore.model.enumerations.BookStatus;
import com.senlatask.bookstore.model.models.Author;
import com.senlatask.bookstore.model.models.Book;

import java.time.LocalDate;

/**
 * Books save util class with properties
 * <b>FILE</b> — file path
 */
public class BookFileUtil implements FileUtil<Book> {
    private static final String FILE = "resources/book.csv";

    private final FileWorker fileWorker;

    public BookFileUtil() {
        fileWorker = new TextFileWorker(FILE);
    }

    public BookFileUtil(String string) {
        fileWorker = new TextFileWorker(string);
    }

    /**
     * Read books from file
     * @return books
     */
    @Override
    public Book[] readFromFile() {
        final String[] lines = fileWorker.readFromFile();

        if (lines == null || lines.length == 0) {
            throw new IllegalArgumentException();
        }

        final Book[] result = new Book[lines.length];

        for (int i = 0; i < lines.length; i++) {
            result[i] = fromLine(lines[i]);
        }

        return result;
    }

    /**
     * Write books to file
     * @param values the values
     */
    @Override
    public void writeToFile(Book[] values) {
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
    public String toLine(Book entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        final String[] array = new String[] {
                String.valueOf(entity.getId()),
                entity.getTitle(),
                String.valueOf(entity.getAuthor()),
                String.valueOf(entity.getPrice()),
                String.valueOf(entity.getPublicationDate()),
                String.valueOf(entity.getRecieptDate()),
                String.valueOf(entity.getStatus()),
                entity.getDescription()
        };
        return String.join(",", array);
    }

    /**
     * Transform string to entities
     * @param line the line
     * @return book
     */
    @Override
    public Book fromLine(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final String[] parts = line.split(",");

        final Book result = new Book(
                String.valueOf(parts[1]),
                new Author(parts[2].split(" ")[0], parts[2].split(" ")[1]),
                Double.valueOf(parts[3]),
                LocalDate.parse(parts[4])
        );
        result.setId(Long.parseLong(parts[0]));
        result.setRecieptDate(LocalDate.parse(parts[5]));
        result.setStatus(BookStatus.valueOf(parts[6]));
        result.setDescription(parts[7]);
        return result;
    }
}
