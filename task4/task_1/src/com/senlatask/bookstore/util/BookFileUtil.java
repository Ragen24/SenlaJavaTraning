package com.senlatask.bookstore.util;

import com.senla.training.FileWorker;
import com.senla.training.TextFileWorker;
import com.senlatask.bookstore.model.Author;
import com.senlatask.bookstore.model.Book;
import com.senlatask.bookstore.model.enumerations.BookStatus;

import java.time.LocalDate;

public class BookFileUtil implements FileUtil<Book> {
    private static final String FILE = "saves/Book.txt";

    private final FileWorker fileWorker;

    public BookFileUtil() {
        fileWorker = new TextFileWorker(FILE);
    }

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

    @Override
    public String toLine(Book entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        final String[] array = new String[] {
                entity.getTitle(),
                String.valueOf(entity.getAuthor()),
                String.valueOf(entity.getPrice()),
                String.valueOf(entity.getPublicationDate()),
                String.valueOf(entity.getStatus())
        };
        return String.join(";", array);
    }

    @Override
    public Book fromLine(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final String[] parts = line.split(";");

        final Book result = new Book(
                String.valueOf(parts[0]),
                new Author(parts[1].split(" ")[0], parts[1].split(" ")[1]),
                Double.valueOf(parts[2]),
                LocalDate.now(),
                BookStatus.valueOf(parts[4])
        );
        return result;
    }
}
