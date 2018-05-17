package com.senlatask.bookstore.model.stores;

import com.senlatask.bookstore.model.interfaces.IStore;
import com.senlatask.bookstore.model.models.Request;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Store of requests on books class with properties <b>requests[]</b>
 * Implements IStore<Request>
 */
public class RequestStore implements IStore<Request> {
    private List<Request> requests;

    /**
     * Requests store constructor
     */
    public RequestStore() {
        requests = new ArrayList<>();
    }

    /**
     * Get all requests
     * @return requests
     */
    @Override
    public List<Request> getAll() {
        return requests;
    }

    /**
     * Get request by request id
     * @param id — request id
     * @return <b>request</b> or <b>null</b> if request not founded
     */
    @Override
    public Request getById(long id) {
        for (Request request : getAll()) {
            if (request.getId() == id) {
                return request;
            }
        }
        return null;
    }

    /**
     * Add new request
     * @param request — request
     */
    @Override
    public void addNew(Request request) {
        requests.add(request);
    }

    /**
     * Add list of requests
     * @param requests — list of requests
     */
    public void addAll(Collection<? extends Request> requests) {
        this.requests.addAll(requests);
    }

    /**
     * Delete request
     * @param request — deleted request
     */
    @Override
    public void delete(Request request) {
        requests.remove(request);
    }

    /**
     * Delete request by id
     * @param id — request id
     * @return <b>request</b> or <b>null</b> if request not founded
     */
    @Override
    public Request deleteById(long id) {
        for (Request request : getAll()) {
            if (request.getId() == id) {
                delete(request);
                return request;
            }
        }
        return null;
    }
}
