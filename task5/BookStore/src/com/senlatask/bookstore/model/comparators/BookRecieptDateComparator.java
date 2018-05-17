package com.senlatask.bookstore.model.comparators;

import com.senlatask.bookstore.model.models.Book;

import java.util.Comparator;

/**
 * Books reciept date singleton comparator
 */
public class BookRecieptDateComparator implements Comparator<Book> {
    private static BookRecieptDateComparator instance;

    private BookRecieptDateComparator() {}

    public static BookRecieptDateComparator getInstance() {
        if (instance == null) {
            instance = new BookRecieptDateComparator();
        }
        return instance;
    }

    /**
     * Compare by reciept date
     */
    @Override
    public int compare(Book o1, Book o2) {
        if (o1.getRecieptDate() == null || o2.getRecieptDate() == null) {
            return 0;
        }
        return o1.getRecieptDate().compareTo(o2.getRecieptDate());
    }
}
