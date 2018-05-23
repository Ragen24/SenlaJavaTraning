package com.senlatask.bookstore.util;

import com.senlatask.bookstore.model.Model;
import com.senlatask.bookstore.model.enumerations.OrderStatus;
import com.senlatask.bookstore.model.models.Client;
import com.senlatask.bookstore.model.models.Order;

import java.time.LocalDate;

/**
 * Order save util class with properties
 * <b>FILE</b> — file path
 */
public class OrderFileUtil implements FileUtil<Order> {
    private static final String FILE = "resources/order.csv";

    private final TextFileWorker fileWorker;

    public OrderFileUtil() {
        fileWorker = new TextFileWorker(FILE);
    }

    public OrderFileUtil(String string) {
        fileWorker = new TextFileWorker(string);
    }
    /**
     * Read orders from file
     * @return orders
     */
    @Override
    public Order[] readFromFile() {
        final String[] lines = fileWorker.readFromFile();

        if (lines == null || lines.length == 0) {
            throw new IllegalArgumentException();
        }

        final Order[] result = new Order[lines.length];

        for (int i = 0; i < lines.length; i++) {
            result[i] = fromLine(lines[i]);
        }

        return result;
    }

    /**
     * Write orders to file
     * @param values the values
     */
    @Override
    public void writeToFile(Order[] values) {
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
    public String toLine(Order entity) {
        if (entity == null) {
            throw new IllegalArgumentException();
        }

        final String[] array = new String[] {
                String.valueOf(entity.getId()),
                entity.getBooksIds(),
                String.valueOf(entity.getClient()),
                String.valueOf(entity.getExecutionDate()),
                String.valueOf(entity.getPrice()),
                String.valueOf(entity.getStatus())
        };
        return String.join(",", array);
    }

    /**
     * Transform string to entities
     * @param line the line
     * @return book
     */
    @Override
    public Order fromLine(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final String[] parts = line.split(",");

        final Order result = new Order(
                new Client(parts[2].split(" ")[0], parts[2].split(" ")[1]),
                LocalDate.parse(parts[3])
        );
        for (String bookId : parts[1].split(" ")) {
            result.addBook(Model.getInstance().getById(Long.parseLong(bookId)));
        }
        result.setId(Long.parseLong(parts[0]));
        result.setPrice(Double.parseDouble(parts[4]));
        result.setStatus(OrderStatus.valueOf(parts[5]));
        return result;
    }
}
