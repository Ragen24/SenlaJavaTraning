package com.senlatask.bookstore.util;

public interface FileUtil<T> {
    /**
     * Read from file.
     *
     * @return the t[]
     */
    T[] readFromFile();

    /**
     * Write to file.
     *
     * @param values the values
     */
    void writeToFile(final T[] values);

    /**
     * To line.
     *
     * @param entity the entity
     * @return the string
     */
    String toLine(T entity);

    /**
     * From line.
     *
     * @param line the line
     * @return the t
     */
    T fromLine(String line);
}
