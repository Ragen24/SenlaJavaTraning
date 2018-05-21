package com.senlatask.bookstore.control.interfaces;

/**
 * IAction interface for all actions
 */
public interface IAction{
    void execute();

    String getName();

    Integer getId();

    void setId(Integer id);
}
