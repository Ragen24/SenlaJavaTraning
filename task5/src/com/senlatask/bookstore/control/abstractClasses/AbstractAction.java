package com.senlatask.bookstore.control.abstractClasses;

import com.senlatask.bookstore.control.interfaces.IAction;
import com.senlatask.bookstore.model.Model;
import com.senlatask.bookstore.view.interfaces.IMenuItem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Abstract action class with properties <b>id</b>, <b>name/b>, <b>model</b> and <b>reader</b>
 * Implements IAction and IMenuItem
 */
public abstract class AbstractAction implements IAction, IMenuItem {
    protected Integer id;
    protected String name;
    protected Model model;
    protected static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Abstract action constructor
     * @param name — action name
     * @param id — action id
     */
    public AbstractAction(String name, Integer id) {
        this.name = name;
        this.id = id;
        this.model = Model.getInstance();
    }

    /**
     * Get action name
     * @return action name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Get action id
     * @return id
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * Set action id
     * @param id — id
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
