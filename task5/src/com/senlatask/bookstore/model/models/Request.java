package com.senlatask.bookstore.model.models;

import com.senlatask.bookstore.model.enumerations.RequestStatus;

/**
 * Request model with properties <b>id</b>, <b>name</b>, <b>book</b>, <b>status</b>
 */
public class Request {
    private static long ID = 0;
    private long id;
    private String name;
    private Book book;
    private RequestStatus status;

    /**
     * Request constructor
     * @param book — requested book
     */
    public Request(Book book) {
        this.book = book;
        this.name = book.getTitle();
        id = ++ID;
    }

    /**
     * id getter
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * id setter
     * @param id — id of order
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Name getter
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Book getter
     * @return requested book
     */
    public Book getBook() {
        return book;
    }

    /**
     * Get request status
     * @return status
     */
    public RequestStatus getStatus() {
        return status;
    }

    /**
     * Set request status
     * @param status — status of request
     */
    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}
