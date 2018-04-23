package com.senlatask.bookstore.model;

import com.senlatask.bookstore.model.enumerations.BookStatus;

import java.time.LocalDate;
import java.util.Comparator;

public class Book {
    private String title;
    private Author author;
    private double price;
    private LocalDate publicationDate;
    private LocalDate recieptDate;
    private BookStatus status;
    private String description;

    public Book(String title, Author author, double price, LocalDate publicationDate, BookStatus status) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publicationDate = publicationDate;
        this.status = status;
        this.description = "Empty";
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public LocalDate getRecieptDate() {
        return recieptDate;
    }

    public void setRecieptDate(LocalDate recieptDate) {
        this.recieptDate = recieptDate;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return title +
                " by " + author;
    }

    public static abstract class ComparatorFactory {
        public static Comparator<Book> getAlphabetComparator() {
            return new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return o1.title.compareTo(o2.title);
                }
            };
        }

        public static Comparator<Book> getPublicationDateComparator() {
            return new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    if (o1.publicationDate == null || o2.publicationDate == null) {
                        return 0;
                    }
                    return o1.publicationDate.compareTo(o2.publicationDate);
                }
            };
        }

        public static Comparator<Book> getStockAvailabilityComparator() {
            return new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return o1.getStatus().ordinal() - o2.getStatus().ordinal();
                }
            };
        }

        public static Comparator<Book> getRecieptDateComparator() {
            return new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    if (o1.recieptDate == null || o2.recieptDate == null) {
                        return 0;
                    }
                    return o1.recieptDate.compareTo(o2.recieptDate);
                }
            };
        }

        public static Comparator<Book> getPriceComparator() {
            return new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return Double.compare(o1.price, o2.price);
                }
            };
        }
    }
}
