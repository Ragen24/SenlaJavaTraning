package com.senlatask.bookstore.view;

import com.senlatask.bookstore.control.BookStore;
import com.senlatask.bookstore.model.Author;
import com.senlatask.bookstore.model.Book;
import com.senlatask.bookstore.model.Client;
import com.senlatask.bookstore.model.Order;
import com.senlatask.bookstore.model.enumerations.BookStatus;
import com.senlatask.bookstore.model.enumerations.OrderStatus;
import com.senlatask.bookstore.util.BookFileUtil;
import com.senlatask.bookstore.util.FileUtil;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        //TextFileWorker textFileWorker = new TextFileWorker()
        final FileUtil<Book> bookUtil = new BookFileUtil();

        Client client1 = new Client("name1", "surname1");
        Client client2 = new Client("name2", "surname2");
        Client client3 = new Client("name3", "surname3");
        Client client4 = new Client("name4", "surname4");

        Book book1 = new Book("wtitle1", new Author("name1", "surname1"), 1200,
                     LocalDate.of(2015, Month.JULY, 20), BookStatus.ABSENT);
        book1.setRecieptDate(LocalDate.of(2018, Month.MARCH, 20));
        book1.setDescription("BOOK DESCRIPTION");
        Book book2 = new Book("atitle2", new Author("name2", "surname2"), 800,
                     LocalDate.of(2015, Month.AUGUST, 15), BookStatus.ABSENT);
        book2.setRecieptDate(LocalDate.of(2017, Month.MARCH, 20));
        Book book3 = new Book("gtitle3", new Author("name3", "surname3"), 1300,
                     LocalDate.of(2015, Month.JUNE, 20), BookStatus.AVAILABLE);
        book3.setRecieptDate(LocalDate.of(2017, Month.MARCH, 20));
        Book book4 = new Book("ctitle4", new Author("name4", "surname4"), 500,
                     LocalDate.of(2015, Month.AUGUST, 17), BookStatus.AVAILABLE);
        book4.setRecieptDate(LocalDate.of(2018, Month.MARCH, 20));
        final Book[] books = new Book[]{book1, book2, book3, book4};
        bookUtil.writeToFile(books);

        System.out.println("initial array");
        for (int i = 0; i < books.length; i++ ){
            System.out.println(books[i]);
        }

        final Book[] readedValues = bookUtil.readFromFile();

        System.out.println("readed array");
        for (int i = 0; i < readedValues.length; i++ ){
            System.out.println(readedValues[i]);
        }

        View view = new View();
        BookStore bookStore = new BookStore();
        bookStore.setView(view);
        view.setBookStore(bookStore);

        bookStore.addBookToStock(book1);
        bookStore.addBookToStock(book2);
        bookStore.addBookToStock(book3);
        bookStore.addBookToStock(book4);

        Order order1 = new Order(client1,  LocalDate.of(2018, Month.MARCH, 20));
        order1.addBook(book1);
        order1.addBook(book3);
        order1.setStatus(OrderStatus.DELIVERING);
        Order order2 = new Order(client1,  LocalDate.of(2015, Month.AUGUST, 20));
        order2.addBook(book2);
        order2.setStatus(OrderStatus.CANCELED);
        Order order3 = new Order(client2,  LocalDate.of(2017, Month.AUGUST, 20));
        order3.addBook(book2);
        order3.addBook(book3);
        order3.setStatus(OrderStatus.DONE);

        bookStore.addOrder(order1);
        bookStore.addOrder(order2);
        bookStore.addOrder(order3);

        System.out.println("Sorted books");
        System.out.println(view.getSortedBooks(1));
        System.out.println(view.getSortedBooks(2));
        System.out.println(view.getSortedBooks(3));

        System.out.println("Sorted orders");
        System.out.println(view.getSortedOrders(1));
        System.out.println(view.getSortedOrders(2));
        System.out.println(view.getSortedOrders(3));

        System.out.println("Completed orders for period of time");
        System.out.println(view.getCompletedOrdersForPeriodOfTime(LocalDate.of(2016, Month.AUGUST, 20),
                LocalDate.of(2019, Month.AUGUST, 20), 1));
        System.out.println(view.getCompletedOrdersForPeriodOfTime(LocalDate.of(2016, Month.AUGUST, 20),
                LocalDate.of(2019, Month.AUGUST, 20), 2));
        System.out.println(view.getCompletedOrdersForPeriodOfTime(LocalDate.of(2016, Month.AUGUST, 20),
                LocalDate.of(2019, Month.AUGUST, 20), 3));

        System.out.println("Total profit for period of time");
        System.out.println(view.getProfitForPeriodOfTime(LocalDate.of(2016, Month.AUGUST, 20),
                LocalDate.of(2019, Month.AUGUST, 20)));

        System.out.println("List of StaleBooks");
        System.out.println(view.getStaleBooks(1));
        System.out.println(view.getStaleBooks(2));

        System.out.println("Order details");
        view.viewOrderDetails(order1);

        System.out.println("Book description");
        view.viewBookDescription(book1);
    }
}
