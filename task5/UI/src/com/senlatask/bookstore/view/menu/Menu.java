package com.senlatask.bookstore.view.menu;

import com.senlatask.bookstore.view.interfaces.IMenu;
import com.senlatask.bookstore.view.interfaces.IMenuItem;

import java.util.List;

/**
 * Menu class with properties <b>id</b>, <b>name</b> and <b>menuItem[]</b>
 */
public class Menu implements IMenu {
    private String name;
    private Integer id;
    private List<IMenuItem> menu;

    /**
     * Menu constructor
     * @param name — menu name
     * @param id — menu id
     */
    public Menu(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Set menu
     * @param menu — list of menu items
     */
    public void setMenu(List<IMenuItem> menu) {
        this.menu = menu;
    }

    /**
     * Get menu
     * @return list of menu items
     */
    public List<IMenuItem> getMenu() {
        return menu;
    }

    /**
     * Get menu name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get menu id
     * @return id
     */
    public Integer getId() {
        return id;
    }
}
