package com.senlatask.bookstore.model.comparators;

import com.senlatask.bookstore.model.models.Book;

import java.util.Comparator;

/**
 * Book price singleton comparator
 */
public class BookPriceComparator implements Comparator<Book> {
    private static BookPriceComparator instance;

    private BookPriceComparator() {}

    public static BookPriceComparator getInstance() {
        if (instance == null) {
            instance = new BookPriceComparator();
        }
        return instance;
    }

    /**
     * Compare books by price
     */
    @Override
    public int compare(Book o1, Book o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
