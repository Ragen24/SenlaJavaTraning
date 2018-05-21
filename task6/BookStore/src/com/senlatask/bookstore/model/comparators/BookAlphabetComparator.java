package com.senlatask.bookstore.model.comparators;

import com.senlatask.bookstore.model.models.Book;

import java.util.Comparator;

/**
 * Book alphabet singleton comparator
 */
public class BookAlphabetComparator implements Comparator<Book> {
    private static BookAlphabetComparator instance;

    private BookAlphabetComparator() {}

    public static BookAlphabetComparator getInstance() {
        if (instance == null) {
            instance = new BookAlphabetComparator();
        }
        return instance;
    }

    /**
     * Compare books by title
     */
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
