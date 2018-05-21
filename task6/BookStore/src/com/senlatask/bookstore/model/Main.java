package com.senlatask.bookstore.model;

import com.senlatask.bookstore.PropertyController;
import com.senlatask.bookstore.model.enumerations.BookStatus;
import com.senlatask.bookstore.model.enumerations.OrderStatus;
import com.senlatask.bookstore.model.models.Author;
import com.senlatask.bookstore.model.models.Book;
import com.senlatask.bookstore.model.models.Client;
import com.senlatask.bookstore.model.models.Order;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void init() {
        //TextFileWorker textFileWorker = new TextFileWorker()
        //final FileUtil<Book> bookUtil = new BookFileUtil(args[0]);

        /*Client client1 = new Client("name1", "surname1");
        Client client2 = new Client("name2", "surname2");
        Client client3 = new Client("name3", "surname3");
        Client client4 = new Client("name4", "surname4");

        Book book1 = new Book("wtitle1", new Author("name1", "surname1"), 1200,
                     LocalDate.of(2015, Month.JULY, 20));
        book1.setRecieptDate(LocalDate.of(2018, Month.MARCH, 20));
        book1.setDescription("BOOK DESCRIPTION");
        book1.setStatus(BookStatus.ABSENT);
        Book book2 = new Book("atitle2", new Author("name2", "surname2"), 800,
                     LocalDate.of(2015, Month.AUGUST, 15));
        book2.setRecieptDate(LocalDate.of(2017, Month.MARCH, 20));
        book2.setStatus(BookStatus.ABSENT);
        Book book3 = new Book("gtitle3", new Author("name3", "surname3"), 1300,
                     LocalDate.of(2015, Month.JUNE, 20));
        book3.setRecieptDate(LocalDate.of(2017, Month.MARCH, 20));
        book3.setStatus(BookStatus.EXPECTS_DELIVERY);
        Book book4 = new Book("ctitle4", new Author("name4", "surname4"), 500,
                     LocalDate.of(2015, Month.AUGUST, 17));
        book4.setRecieptDate(LocalDate.of(2018, Month.MARCH, 20));*/
        PropertyController.loadPropertiesFromFile();
        Model model = Model.getInstance();

        model.load();

        /*model.addBookToStock(book1);
        model.addBookToStock(book2);
        model.addBookToStock(book3);
        model.addBookToStock(book4);

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

        model.addOrder(order1);
        model.addOrder(order2);
        model.addOrder(order3);

        model.addRequest(2);
        model.addRequest(3);
        model.addRequest(4);
        model.addRequest(2);*/
    }

}
