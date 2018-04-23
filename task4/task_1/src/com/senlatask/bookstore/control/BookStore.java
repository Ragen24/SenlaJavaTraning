package com.senlatask.bookstore.control;

import com.senlatask.bookstore.model.*;
import com.senlatask.bookstore.model.enumerations.OrderStatus;
import com.senlatask.bookstore.model.enumerations.RequestStatus;
import com.senlatask.bookstore.view.View;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class BookStore {
    private ArrayList<Book> books; //TODO Количество книг
    private ArrayList<Order> orders;
    private ArrayList<Request> requests;
    private View view;

    public BookStore() {
        this.books = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.requests = new ArrayList<>();
    }

    public BookStore(ArrayList<Book> books, ArrayList<Order> orders, ArrayList<Request> requests) {
        this.books = books;
        this.orders = orders;
        this.requests = requests;
    }

    public void setView(View view) {
        this.view = view;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public ArrayList<Request> getRequestsOnBook(Book book) {
        ArrayList<Request> requestsOnBook = new ArrayList<>();
        for (Request request : requests) {
            if (request.getBook().equals(book)) {
                requestsOnBook.add(request);
            }
        }
        return requestsOnBook;
    }

    public ArrayList<Order> getCompletedOrdersForPeriodOfTime(LocalDate from, LocalDate to) {
        ArrayList<Order> completedOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getStatus() == OrderStatus.DONE && order.getExecutionDate().compareTo(from) >= 0 &&
                    order.getExecutionDate().compareTo(to) <= 0) {
                completedOrders.add(order);
            }
        }
        return completedOrders;
    }

    public double getProfitForPeriodOfTime(LocalDate from, LocalDate to) {
        double totalProfit = 0;
        ArrayList<Order> completedOrders = getCompletedOrdersForPeriodOfTime(from, to);
        for (Order order : completedOrders) {
            totalProfit += order.getPrice();
        }
        return totalProfit;
    }

    public int getCompletedOrdersAmountForPeriodOfTime(LocalDate from, LocalDate to) {
        int completedOrdersAmount = 0;
        for (Order order : orders) {
            if (order.getStatus() == OrderStatus.DONE && order.getExecutionDate().compareTo(from) >= 0 &&
                    order.getExecutionDate().compareTo(to) <= 0) {
                completedOrdersAmount++;
            }
        }
        return completedOrdersAmount;
    }

    public ArrayList<Book> getStaleBooks() {
        ArrayList<Book> staleBooks = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        for (Book book : books) {
            if ((currentDate.getYear() * 12 + currentDate.getMonthValue()) -
                    (book.getRecieptDate().getYear() * 12 + book.getRecieptDate().getMonthValue()) >= 6) {
                staleBooks.add(book);
            }
        }
        return staleBooks;
    }

    public void viewOrderDetails(Order order) {
        System.out.println("Order by " + order.getClient());
        if (order.getBooks().size() == 1) {
            System.out.println("Contains book " + order.getBooks());
        } else if (order.getBooks().size() > 1) {
            System.out.println("Contains books: ");
            for (Book book : books) {
                System.out.println(" " + book + " costs" + book.getPrice());
            }
        } //TODO: else
        System.out.println("ExecutionDate: " + order.getExecutionDate());
        System.out.println("Status: " + order.getStatus().name());
    }

    public void viewBookDescription(Book book) {
        System.out.println(book);
        System.out.println("\n " + book.getDescription());
    }

    public void addBookToStock(Book book) {
        books.add(book);
        for (Request request : getRequestsOnBook(book)) {
            request.setStatus(RequestStatus.DONE);
        }
    }

    public void removeBookFromStock(Book book) {
        books.remove(book);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void completeOrder(Order order) {
        order.setStatus(OrderStatus.PACKAGING);
        for (Book book : order.getBooks()) {
            books.remove(book);
        }
        order.setStatus(OrderStatus.DELIVERING);
    }

    public void cancelOrder(Order order) {
        if (order.getStatus() == OrderStatus.DELIVERING) {
            books.addAll(order.getBooks());
        }
        order.setStatus(OrderStatus.CANCELED);
    }

    public void makeRequest(Request request) {
        requests.add(request);
    }
}
