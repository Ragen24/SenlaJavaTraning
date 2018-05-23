package com.senlatask.bookstore.model.serialization;

import com.senlatask.bookstore.model.stores.BookStore;
import com.senlatask.bookstore.model.stores.OrderStore;
import com.senlatask.bookstore.model.stores.RequestStore;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class BookStoreDto implements Serializable {
    private BookStore bookStore;
    private OrderStore orderStore;
    private RequestStore requestStore;

    private final static transient Logger logger = LogManager.getLogger(BookStoreDto.class);

    private final String fileName;

    public BookStore getBookStore() {
        return bookStore;
    }

    public void setBookStore(BookStore bookStore) {
        this.bookStore = bookStore;
    }

    public OrderStore getOrderStore() {
        return orderStore;
    }

    public void setOrderStore(OrderStore orderStore) {
        this.orderStore = orderStore;
    }

    public RequestStore getRequestStore() {
        return requestStore;
    }

    public void setRequestStore(RequestStore requestStore) {
        this.requestStore = requestStore;
    }

    public BookStoreDto(String fileName, BookStore bookStore, OrderStore orderStore, RequestStore requestStore) {
        this.fileName = fileName;
        this.bookStore = bookStore;
        this.orderStore = orderStore;
        this.requestStore = requestStore;
    }

    public BookStoreDto(String fileName) {
        this.fileName = fileName;
    }

    public boolean save() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(this);
            return true;
        } catch (IOException e) {
            logger.log(Level.ERROR, e.getMessage());
            return false;
        }
    }

    public boolean load() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            BookStoreDto bookStoreDto = (BookStoreDto)objectInputStream.readObject();
            this.bookStore = bookStoreDto.getBookStore();
            this.orderStore = bookStoreDto.getOrderStore();
            this.requestStore = bookStoreDto.getRequestStore();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            logger.log(Level.ERROR, e.getMessage());
            return false;
        }
    }
}
