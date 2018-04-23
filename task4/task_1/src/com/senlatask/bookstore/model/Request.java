package com.senlatask.bookstore.model;

import com.senlatask.bookstore.model.enumerations.RequestStatus;

import java.util.Comparator;

public class Request {
    private String name;
    private Book book;
    private RequestStatus status;

    public Request(Book book) {
        this.book = book;
        this.name = book.getTitle();
    }

    public String getName() {
        return name;
    }

    public Book getBook() {
        return book;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public static abstract class ComparatorFactory {
        public static Comparator<Request> getAlphabetComparator() {
            return new Comparator<Request>() {
                @Override
                public int compare(Request o1, Request o2) {
                    return o1.getBook().getTitle().compareTo(o2.getBook().getTitle());
                }
            };
        }
    }
}
