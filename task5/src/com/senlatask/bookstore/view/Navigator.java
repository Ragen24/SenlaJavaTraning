package com.senlatask.bookstore.view;

import com.senlatask.bookstore.control.interfaces.IAction;
import com.senlatask.bookstore.view.interfaces.IMenu;
import com.senlatask.bookstore.view.interfaces.IMenuItem;
import com.senlatask.bookstore.view.menuBuilder.MenuBuilder;

/**
 * Menu navigator
 */
public class Navigator {
    private static final String SPLITER = "=================================================";
    private static Navigator instance;
    private IMenu rootMenu;
    private IMenu currentMenu;

    /**
     * Navigator constructor
     */
    private Navigator() {
        MenuBuilder menuBuilder = new MenuBuilder();
        currentMenu = menuBuilder.buildMenu();
        printMenu(currentMenu);
    }

    /**
     * Get navigator instance
     * @return instance
     */
    public static Navigator getInstance() {
        if (instance == null) {
            instance = new Navigator();
        }
        return instance;
    }

    /**
     * Navigate thru menu
     * @param index — index of menu item
     */
    public void navigate(Integer index) {
        IMenuItem menuItem = currentMenu.getMenu().get(index - 1);
        if (menuItem instanceof IMenu) {
            currentMenu = (IMenu) menuItem;
            printMenu(currentMenu);
        } else if (menuItem instanceof IAction) {
            IAction action = (IAction) menuItem;
            action.execute();
            printMenu(currentMenu);
        }
    }

    /**
     * Print menu to console
     * @param menu — printed menu
     */
    public void printMenu(IMenu menu) {
        Integer j = 1;
        System.out.println("---" + menu.getName() + "---");
        System.out.println(SPLITER);
        for (IMenuItem menuItem : menu.getMenu()) {
            System.out.println(j + ". " + menuItem.getName());
            j++;
        }
        System.out.println(SPLITER);
    }

    /**
     * Get current menu
     * @return current menu
     */
    public IMenu getCurrentMenu() {
        return currentMenu;
    }
}
