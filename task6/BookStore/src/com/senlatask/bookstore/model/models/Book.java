package com.senlatask.bookstore.model.models;

import com.senlatask.bookstore.model.enumerations.BookStatus;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Book model with properties <b>id</b>, <b>title</b>, <b>author</b>, <b>price</b>,
 * <b>publicationDate</b>, <b>recieptDate</b>, <b>status</b> and <b>description</b>
 */
public class Book implements Serializable {
    private long id;
    private String title;
    private Author author;
    private double price;
    private LocalDate publicationDate;
    private LocalDate recieptDate;
    private BookStatus status;
    private String description;

    /**
     * Book constructor
     * @param title — title of book
     * @param author — book author
     * @param price — book price
     * @param publicationDate — date of book publication
     */
    public Book(String title, Author author, double price, LocalDate publicationDate) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publicationDate = publicationDate;

        this.status = BookStatus.AVAILABLE;
        this.description = "Empty";
    }

    /**
     * Get book id
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Set book id
     * @param id — book id
     */
    public void setId(long id) { this.id = id; }

    /**
     * Get book title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get book author
     * @return author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Get book price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set book price
     * @param price — book price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get publication date
     * @return publication date
     */
    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    /**
     * Get date of reciept to the stock
     * @return recieptDate
     */
    public LocalDate getRecieptDate() {
        return recieptDate;
    }

    /**
     * Set date of reciept to the stock
     * @param recieptDate — reciept date
     */
    public void setRecieptDate(LocalDate recieptDate) {
        this.recieptDate = recieptDate;
    }

    /**
     * Get book status
     * @return book status
     */
    public BookStatus getStatus() {
        return status;
    }

    /**
     * Set book status
     * @param status — book status
     */
    public void setStatus(BookStatus status) {
        this.status = status;
    }

    /**
     * Get book description
     * @return book description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set book description
     * @param description — book description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Book to string
     * @return — short book description
     */
    @Override
    public String toString() {
        return title +
                " by " + author;
    }
}
