package com.senlatask.bookstore.view;

import com.senlatask.bookstore.control.exception.WrongInputException;
import com.senlatask.bookstore.model.Main;
import com.senlatask.bookstore.util.ConsoleUtil;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Menu controller
 */
public class MenuController {
    private static Navigator navigator;
    private static Logger logger = LogManager.getLogger(MenuController.class);

    /**
     * Start program
     */
    public void run() {
        navigator = Navigator.getInstance();
        Main.init();

        while (true) {
            try {
                Integer index = ConsoleUtil.readMenuItemIndex();
                if (index == -1) { break; }
                else {
                    navigator.navigate(index);
                }
            } catch (IOException | WrongInputException e) {
                logger.log(Level.ERROR, e.getMessage());
                System.out.println("Wrong option. Try Again");
            }
        }
    }
}
