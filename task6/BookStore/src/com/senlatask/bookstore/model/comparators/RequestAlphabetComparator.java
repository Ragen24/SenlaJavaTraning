package com.senlatask.bookstore.model.comparators;

import com.senlatask.bookstore.model.models.Request;

import java.util.Comparator;

/**
 * Request alphabet singleton comparator
 */
public class RequestAlphabetComparator implements Comparator<Request> {
    private static RequestAlphabetComparator instance;

    private RequestAlphabetComparator() {}

    public static RequestAlphabetComparator getInstance() {
        if (instance == null) {
            instance =new RequestAlphabetComparator();
        }
        return instance;
    }

    /**
     * Compare by requested book title
     */
    @Override
    public int compare(Request o1, Request o2) {
        return o1.getBook().getTitle().compareTo(o2.getBook().getTitle());
    }
}
