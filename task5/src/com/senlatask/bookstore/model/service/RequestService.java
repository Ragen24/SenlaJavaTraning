package com.senlatask.bookstore.model.service;

import com.senlatask.bookstore.model.comparators.RequestAlphabetComparator;
import com.senlatask.bookstore.model.interfaces.IRequestService;
import com.senlatask.bookstore.model.models.Book;
import com.senlatask.bookstore.model.models.Request;
import com.senlatask.bookstore.model.stores.RequestStore;
import com.senlatask.bookstore.util.FileUtil;
import com.senlatask.bookstore.util.RequestFileUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Request service class with properties <b>requestStore</b> and <b>requestUtil</b>
 */
public class RequestService implements IRequestService {
    private RequestStore requestStore;
    private final FileUtil<Request> requestUtil = new RequestFileUtil();

    /**
     * Request service constructor
     * @param requestStore — request store
     */
    public RequestService(RequestStore requestStore) {
        this.requestStore = requestStore;
    }

    /**
     * Get all requests
     * @return requests
     */
    public List<Request> getAll() {
        return requestStore.getAll();
    }

    /**
     * Get requests on book
     * @param book — requested book
     * @return requests on book
     */
    @Override
    public List<Request> getRequestsOnBook(Book book) {
        List<Request> requestsOnBook = new ArrayList<>();
        for (Request request : requestStore.getAll()) {
            if (request.getBook().equals(book)) {
                requestsOnBook.add(request);
            }
        }
        return requestsOnBook;
    }

    /**
     * Get sorted request on book
     * @param book — requested book
     * @return sorted requests
     */
    @Override
    public List<Request> getSortedRequestsOnBook(Book book) {
        List<Request> sortedRequests = new ArrayList<>(getRequestsOnBook(book));
        Collections.sort(sortedRequests, RequestAlphabetComparator.getInstance());
        return sortedRequests;
    }

    /**
     * Add request on book
     * @param request — request on book
     */
    @Override
    public void addRequest(Request request) {
        requestStore.addNew(request);
    }

    /**
     * Delete request on book by book id
     * @param id — book id
     * @return book or null if book not found
     */
    @Override
    public Request deleteRequest(long id) {
        return requestStore.deleteById(id);
    }

    /**
     * Save requests
     */
    @Override
    public void save() {
        Request[] array = getAll().toArray(new Request[getAll().size()]);
        requestUtil.writeToFile(array);
    }

    /**
     * Load requests
     */
    @Override
    public void load() {
        requestStore.addAll(new ArrayList<Request>(Arrays.asList(requestUtil.readFromFile())));
    }
}
