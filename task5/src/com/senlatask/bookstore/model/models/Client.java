package com.senlatask.bookstore.model.models;

/**
 * Client model
 */
public class Client extends Person {
    private static long ID;

    /**
     * Client constructor
     * @param name — name of client
     * @param surname — surname of client
     */
    public Client(String name, String surname) {
        super(name, surname);
        id = ++ID;
    }
}
