package com.senlatask.bookstore.model.comparators;

import com.senlatask.bookstore.model.models.Book;

import java.util.Comparator;

/**
 * Books publication date singleton comparator
 */
public class BookPublicationDateComparator implements Comparator<Book> {
    private static BookPublicationDateComparator instance;

    private BookPublicationDateComparator() {}

    public static BookPublicationDateComparator getInstance() {
        if (instance == null) {
            instance = new BookPublicationDateComparator();
        }
        return instance;
    }

    /**
     * Compare by publication date
     */
    @Override
    public int compare(Book o1, Book o2) {
        if (o1.getPublicationDate() == null || o2.getPublicationDate() == null) {
            return 0;
        }
        return o1.getPublicationDate().compareTo(o2.getPublicationDate());
    }
}
