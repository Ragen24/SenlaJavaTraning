package com.senlatask.bookstore.model.service;

import com.senlatask.bookstore.model.comparators.*;
import com.senlatask.bookstore.model.interfaces.IBookService;
import com.senlatask.bookstore.model.models.Book;
import com.senlatask.bookstore.model.stores.BookStore;
import com.senlatask.bookstore.util.BookFileUtil;
import com.senlatask.bookstore.util.FileUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Book service class with properties <b>bookstore</b> and <b>bookUtil</b>
 */
public class BookService implements IBookService {
    private BookStore bookStore;
    private final FileUtil<Book> bookUtil = new BookFileUtil();

    /**
     * Book service constructor
     * @param bookStore — book store
     */
    public BookService(BookStore bookStore) {
        this.bookStore = bookStore;
    }

    /**
     * Get all books
     * @return books
     */
    @Override
    public List<Book> getBooks() {
        return bookStore.getAll();
    }

    /**
     * Get book by id
     * @param id — book id
     * @return book
     */
    public Book getById(long id) {
        return bookStore.getById(id);
    }

    /**
     * Get books get books that are in stock for more than 6 months(Stale books)
     * @return list of a stale books
     */
    @Override
    public List<Book> getStaleBooks() {
        List<Book> staleBooks = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        for (Book book : bookStore.getAll()) {
            if ((currentDate.getYear() * 12 + currentDate.getMonthValue()) -
                    (book.getRecieptDate().getYear() * 12 + book.getRecieptDate().getMonthValue()) >= 6) {
                staleBooks.add(book);
            }
        }
        return staleBooks;
    }

    /**
     * Get sorted stale books
     * @param orderType — type of order 1 - date order, 2 - price order
     * @return sorted stale books
     */
    @Override
    public List<Book> getSortedStaleBooks(int orderType) {
        ArrayList<Book> sortedBooks = new ArrayList<>(getStaleBooks());
        switch (orderType) {
            case 1 :
                Collections.sort(sortedBooks, BookRecieptDateComparator.getInstance());
                break;
            case 2 :
                Collections.sort(sortedBooks, BookPriceComparator.getInstance());
                break;
        }
        return sortedBooks;
    }

    /**
     * Get sorted books
     * @param orderType — type of order 1 - alphabet order, 2 - publication date order,
     *                     3 - stock availability order, 4 - price order
     * @return sorted books
     */
    @Override
    public List<Book> getSortedBooks(int orderType) {
        List<Book> sortedBooks = new ArrayList<>(getBooks());
        switch (orderType) {
            case 1 :
                Collections.sort(sortedBooks, BookAlphabetComparator.getInstance());
                break;
            case 2 :
                Collections.sort(sortedBooks, BookPublicationDateComparator.getInstance());
                break;
            case 3 :
                Collections.sort(sortedBooks, BookStockAvailabilityComparator.getInstance());
                break;
            case 4 :
                Collections.sort(sortedBooks, BookPriceComparator.getInstance());
                break;
        }
        return sortedBooks;
    }

    /**
     * Get book description by book id
     * @param id — book id
     * @return bok description or "Book not found."
     */
    @Override
    public String getBookDescription(long id) {
        Book book = getById(id);
        if (book != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(book);
            stringBuilder.append("\n\n");
            stringBuilder.append(book.getDescription());
            return stringBuilder.toString();
        } else {
            return "Book not found.";
        }
    }

    /**
     * Add book to stock
     * @param book — added book
     */
    @Override
    public void addBookToStock(Book book) {
        bookStore.addNew(book);
    }

    /**
     * Remove book by id
     * @param id — book id
     * @return book
     */
    @Override
    public Book removeBookFromStock(long id) {
        return bookStore.deleteById(id);
    }

    /**
     * Save books to file
     */
    @Override
    public void save() {
        Book[] array = getBooks().toArray(new Book[getBooks().size()]);
        bookUtil.writeToFile(array);
    }

    /**
     * Load books from file
     */
    @Override
    public void load() {
        bookStore.addAll(new ArrayList<Book>(Arrays.asList(bookUtil.readFromFile())));
    }
}
