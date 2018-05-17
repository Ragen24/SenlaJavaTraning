package com.senlatask.bookstore.model.models;

import com.senlatask.bookstore.model.enumerations.OrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Order model with properties <b>id</b>, <b>client</b>, <b>books[]</b>, <b>price</b>,
 * <b>status</b> and <b>executionDate</b>
 */
public class Order {
    private static long ID = 0;
    private long id;
    private Client client;
    private ArrayList<Book> books = new ArrayList<>();
    private double price;
    private OrderStatus status;
    private LocalDate executionDate;

    /**
     * Order constructor
     * @param client — commissioned customer
     * @param executionDate — date of order execution
     */
    public Order(Client client, LocalDate executionDate) {
        this.client = client;
        this.executionDate = executionDate;
        this.status = OrderStatus.PROCESSED;
        this.price = 0;
        id = ++ID;
    }

    /**
     * id getter
     * @return order id
     */
    public long getId() {
        return id;
    }

    /**
     * id setter
     * @param id — order id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Client getter
     * @return — client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Get all books in this order
     * @return ordered books
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * Get ids of ordered books
     * @return string contains book's id separated with " "
     */
    public String getBooksIds() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Book book : books) {
            stringBuilder.append(book.getId() + " ");
        }
        return stringBuilder.toString();
    }

    /**
     * Add book to the order
     * @param book
     */
    public void addBook(Book book) {
        this.books.add(book);
        // Increases price of an order for the cost of a book
        this.price += book.getPrice();
    }

    /**
     * Remove book from order
     * @param book
     */
    public void removeBook(Book book) {
        this.books.remove(book);
        // Decreases price of an order for the cost of a book
        this.price -= book.getPrice();
    }

    /**
     * Set list of ordered books
     * @param books — books to order
     */
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    /**
     * Get order price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set order price
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get order status
     * @return order status
     */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * Set order status
     * @param status
     */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    /**
     * Get date of order execution
     * @return
     */
    public LocalDate getExecutionDate() {
        return executionDate;
    }

    /**
     * Set date of order execution
     * @param executionDate
     */
    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }

    /**
     * Order to  string
     * @return order description
     */
    @Override
    public String toString() {
        return "Order{" +
                "client=" + client +
                ", books=" + books +
                ", price=" + price +
                ", status=" + status +
                ", executionDate=" + executionDate +
                '}';
    }
}
