package com.senlatask.bookstore.model;

import com.senlatask.bookstore.model.enumerations.OrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Order {
    private Client client;
    private ArrayList<Book> books = new ArrayList<>();
    private double price;
    private OrderStatus status;
    private LocalDate executionDate;

    public Order(Client client, LocalDate executionDate) {
        this.client = client;
        this.executionDate = executionDate;
        this.status = OrderStatus.PROCESSED;
        this.price = 0;
    }

    public Client getClient() {
        return client;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        this.books.add(book);
        this.price += book.getPrice();
    }

    public void removeBook(Book book) {
        this.books.remove(book);
        this.price -= book.getPrice();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }

    private void calculatePrice() {

    }

    public static abstract class ComparatorFactory {
        public static Comparator<Order> getExecutionDateComparator() {
            return new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    if (o1.executionDate == null || o2.executionDate == null) {
                        return 0;
                    }
                    return o1.executionDate.compareTo(o2.executionDate);
                }
            };
        }

        public static Comparator<Order> getPriceComparator() {
            return new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {

                    return Double.compare(o1.price, o2.price);
                }
            };
        }

        public static Comparator<Order> getStatusComparator() {
            return new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    return o1.getStatus().ordinal() - o2.getStatus().ordinal();
                }
            };
        }
    }

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
