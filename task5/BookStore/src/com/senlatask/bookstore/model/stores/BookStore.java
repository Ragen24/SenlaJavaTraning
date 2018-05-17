package com.senlatask.bookstore.model.stores;

import com.senlatask.bookstore.model.interfaces.IStore;
import com.senlatask.bookstore.model.models.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Store of a books class with properties <b>books[]</b>
 * Implements IStore<Book>
 */
public class BookStore implements IStore<Book> {
    private List<Book> books;

    /**
     * Book store constructor
     */
    public BookStore() {
        books = new ArrayList<>();
    }

    /**
     * Get all books
     * @return books
     */
    @Override
    public List<Book> getAll() {
        return books;
    }

    /**
     * Get book by book id
     * @param id — book id
     * @return <b>book</b> or <b>null</b> if book not founded
     */
    @Override
    public Book getById(long id) {
        for (Book book : getAll()) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    /**
     * Add new book to the stock
     * @param book — added book
     */
    @Override
    public void addNew(Book book) {
        books.add(book);
        book.setRecieptDate(LocalDate.now());
    }

    /**
     * Add list of books to the stock
     * @param books — list of books
     */
    public void addAll(Collection<? extends Book> books) {
        this.books.addAll(books);
    }

    /**
     * Delete book by book id
     * @param id — book id
     * @return <b>book</b> or <b>null</b> if book not founded
     */
    @Override
    public Book deleteById(long id) {
        for (Book book : getAll()) {
            if (book.getId() == id) {
                delete(book);
                return book;
            }
        }
        return null;
    }

    /**
     * Delete book
     * @param book — deleted book
     */
    @Override
    public void delete(Book book) {
        books.remove(book);
    }
}
