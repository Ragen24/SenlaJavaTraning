package com.senlatask.bookstore.view.interfaces;

import java.util.List;

/**
 * IMenu interface for menu
 * Implements IMenuItem, because menu can be menu item
 */
public interface IMenu extends IMenuItem {
    List<IMenuItem> getMenu();

    void setMenu(List<IMenuItem> menu);

    String getName();

    Integer getId();
}
