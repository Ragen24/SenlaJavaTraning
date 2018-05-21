package com.senlatask.bookstore.model.models;

import java.io.Serializable;

/**
 * Author model
 */
public class Author extends Person implements Serializable{
    private static long ID = 0;

    public Author() {
    }

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
