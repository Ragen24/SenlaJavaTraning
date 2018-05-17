package com.senlatask.bookstore.model.comparators;

import com.senlatask.bookstore.model.models.Book;

import java.util.Comparator;

/**
 * Books stock availability singleton comparator
 */
public class BookStockAvailabilityComparator implements Comparator<Book> {
    private static BookStockAvailabilityComparator instance;

    private BookStockAvailabilityComparator() {}

    public static BookStockAvailabilityComparator getInstance() {
        if (instance == null) {
            instance = new BookStockAvailabilityComparator();
        }
        return instance;
    }

    /**
     * Compare by book status
     */
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getStatus().ordinal() - o2.getStatus().ordinal();
    }
}
