package com.senlatask.bookstore.view;

import com.senlatask.bookstore.control.BookStore;
import com.senlatask.bookstore.model.Book;
import com.senlatask.bookstore.model.Order;
import com.senlatask.bookstore.model.Request;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class View {
    private BookStore bookStore;

    public void setBookStore(BookStore bookStore) {
        this.bookStore = bookStore;
    }

    public ArrayList<Book> getSortedBooks(int orderType) {
        ArrayList<Book> sortedBooks = (ArrayList<Book>)bookStore.getBooks().clone();
        switch (orderType) {
            case 1 :
                Collections.sort(sortedBooks, Book.ComparatorFactory.getAlphabetComparator());
                break;
            case 2 :
                Collections.sort(sortedBooks, Book.ComparatorFactory.getPublicationDateComparator());
                break;
            case 3 :
                Collections.sort(sortedBooks, Book.ComparatorFactory.getStockAvailabilityComparator());
                break;
        }
        return sortedBooks;
    }

    public ArrayList<Order> getSortedOrders(int orderType) {
        ArrayList<Order> sortedOrders = (ArrayList<Order>)bookStore.getOrders().clone();
        switch (orderType) {
            case 1 :
                Collections.sort(sortedOrders, Order.ComparatorFactory.getExecutionDateComparator());
                break;
            case 2 :
                Collections.sort(sortedOrders, Order.ComparatorFactory.getPriceComparator());
                break;
            case 3 :
                Collections.sort(sortedOrders, Order.ComparatorFactory.getStatusComparator());
                break;
        }
        return sortedOrders;
    }

    public ArrayList<Request> getRequestsOnBook(Book book, int orderType) {
        ArrayList<Request> sortedRequests = new ArrayList<>();
        Collections.copy(sortedRequests, bookStore.getRequestsOnBook(book));
        switch (orderType) {
            case 1 :
                Collections.sort(sortedRequests, Request.ComparatorFactory.getAlphabetComparator());
                break;
        }
        return sortedRequests;
    }

    public ArrayList<Order> getCompletedOrdersForPeriodOfTime(LocalDate from, LocalDate to, int orderType) {
        ArrayList<Order> sortedOrders = (ArrayList<Order>)bookStore.getCompletedOrdersForPeriodOfTime(from, to).clone();
        switch (orderType) {
            case 1 :
                Collections.sort(sortedOrders, Order.ComparatorFactory.getExecutionDateComparator());
                break;
            case 2 :
                Collections.sort(sortedOrders, Order.ComparatorFactory.getPriceComparator());
                break;
        }
        return sortedOrders;
    }

    public double getProfitForPeriodOfTime(LocalDate from, LocalDate to) {
        return bookStore.getProfitForPeriodOfTime(from, to);
    }

    public int getCompletedOrdersAmountForPeriodOfTime(LocalDate from, LocalDate to) {
        return bookStore.getCompletedOrdersAmountForPeriodOfTime(from, to);
    }

    public ArrayList<Book> getStaleBooks(int orderType) {
        ArrayList<Book> sortedBooks = (ArrayList<Book>)bookStore.getStaleBooks().clone();
        switch (orderType) {
            case 1 :
                Collections.sort(sortedBooks, Book.ComparatorFactory.getRecieptDateComparator());
                break;
            case 2 :
                Collections.sort(sortedBooks, Book.ComparatorFactory.getPriceComparator());
                break;
        }
        return sortedBooks;
    }

    public void viewOrderDetails(Order order) {
        bookStore.viewOrderDetails(order);
    }

    public void viewBookDescription(Book book) {
        bookStore.viewBookDescription(book);
    }

    public void addBookToStock(Book book) {
       bookStore.addBookToStock(book);
    }

    public void removeBookFromStock(Book book) {
        bookStore.removeBookFromStock(book);
    }

    public void addOrder(Order order) {
        bookStore.addOrder(order);
    }

    public void completeOrder(Order order) {
        bookStore.completeOrder(order);
    }

    public void cancelOrder(Order order) {
        bookStore.cancelOrder(order);
    }

    public void makeRequest(Request request) {
        bookStore.makeRequest(request);
    }
}
