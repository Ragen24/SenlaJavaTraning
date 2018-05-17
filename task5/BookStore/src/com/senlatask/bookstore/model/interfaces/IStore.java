package com.senlatask.bookstore.model.interfaces;

import java.util.List;

/**
 * IStore interface for stores
 * @param <T>
 */
public interface IStore<T> {
    List<T> getAll();
    T getById(long id);
    void addNew(T t);
    void delete(T t);
    T deleteById(long id);
}
