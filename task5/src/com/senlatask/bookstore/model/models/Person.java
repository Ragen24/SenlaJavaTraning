package com.senlatask.bookstore.model.models;

/**
 * Abstract Person class with properties <b>id</b>, <b>name</b> and <b>surname</b>
 */
public abstract class Person {
    protected long id;
    private String name;
    private String surname;

    /**
     * Perosn constructor
     * @param name — persons name
     * @param surname — persons surname
     */
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /**
     * Name getter
     * @return person name
     */
    public String getName() {
        return name;
    }

    /**
     *  Name setter
     * @param name — peron name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Surname getter
     * @return person surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Surname setter
     * @param surname — person surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Person to string
     * @return person description
     */
    @Override
    public String toString() {
        return getName() + " " + getSurname();
    }
}
