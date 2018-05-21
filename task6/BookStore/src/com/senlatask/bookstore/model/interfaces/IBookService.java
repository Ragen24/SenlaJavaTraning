package com.senlatask.bookstore.model.interfaces;

import com.senlatask.bookstore.model.models.Book;

import java.util.List;

/**
 * IBookService interface for book service
 */
public interface IBookService extends IService {
    List<Book> getBooks();

    Book getById(long id);

    List<Book> getStaleBooks();

    List<Book> getSortedStaleBooks(int orderType);

    List<Book> getSortedBooks(int orderType);

    String getBookDescription(long id);

    void addBookToStock(Book book);

    Book removeBookFromStock(long id);

    void exportToFile();

    void exportToFile(String string);

    void importFromFile();

    void importFromFile(String string);
}
