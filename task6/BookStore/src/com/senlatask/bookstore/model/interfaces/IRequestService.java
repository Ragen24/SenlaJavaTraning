package com.senlatask.bookstore.model.interfaces;

import com.senlatask.bookstore.model.models.Book;
import com.senlatask.bookstore.model.models.Request;

import java.util.List;

/**
 * IRequestService interface for request service
 */
public interface IRequestService extends IService {
    List<Request> getRequestsOnBook(Book book);

    List<Request> getSortedRequestsOnBook(Book book);

    void addRequest(Request request);

    Request deleteRequest(long id);
}
