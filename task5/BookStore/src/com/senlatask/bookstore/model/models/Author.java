package com.senlatask.bookstore.model.models;

/**
 * Author model
 */
public class Author extends Person {
    private static long ID = 0;

    /**
     * Author constructor
     * @param name
     * @param surname
     */
    public Author(String name, String surname) {
        super(name, surname);
        id = ++ID;
    }
}
