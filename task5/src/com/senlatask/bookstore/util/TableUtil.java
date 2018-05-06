package com.senlatask.bookstore.util;

import com.senlatask.bookstore.model.models.Book;
import com.senlatask.bookstore.model.models.Order;
import com.senlatask.bookstore.model.models.Request;

import java.util.List;

/**
 * Table printer util
 */
public abstract class TableUtil {
    /**
     * Print table of books
     * @param books — printed books
     */
    public static void printBookTable(List<Book> books) {
        System.out.printf("\n| %6s | %14s | %20s | %9s | %20s | %16s |\n", "ID", "Title", "Author", "Price", "Publication date", "Status");
        for (Book book : books) {
            System.out.printf("| %6s | %14s | %20s | %9.2f | %20s | %16s |\n", book.getId(), book.getTitle(), book.getAuthor().getName() + " " +
                    book.getAuthor().getSurname(), book.getPrice(), book.getPublicationDate(), book.getStatus());
        }
    }

    /**
     * Print table of orders
     * @param orders — printed orders
     */
    public static void printOrderTable(List<Order> orders) {
        System.out.printf("\n| %6s | %20s | %9s | %20s | %16s |\n", "ID", "Client", "Price", "Execution date", "Status");
        for (Order order : orders) {
            System.out.printf("| %6s | %20s | %9.2f | %20s | %16s |\n", order.getId(), order.getClient().getName() + " " +
                    order.getClient().getSurname(), order.getPrice(), order.getExecutionDate(), order.getStatus());
        }
    }

    /**
     * Print table of requests
     * @param requests — printed requests
     */
    public static void printRequestTable(List<Request> requests) {
        System.out.printf("\n| %6s | %20s | %20s | %16s |\n", "ID", "Title", "Author",  "Status");
        for (Request request : requests) {
            System.out.printf("| %6s | %20s | %20s | %16s |\n", request.getId(), request.getBook().getTitle(),
                    request.getBook().getAuthor().getName() + " " + request.getBook().getAuthor().getSurname(),
                    request.getStatus());
        }
    }
}
