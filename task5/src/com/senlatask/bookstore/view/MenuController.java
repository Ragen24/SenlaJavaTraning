package com.senlatask.bookstore.view;

import com.senlatask.bookstore.model.Main;
import com.senlatask.bookstore.util.ExceptionLogger;
import org.apache.logging.log4j.Level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Menu controller
 */
public class MenuController {
    private static Navigator navigator;

    /**
     * Start program
     */
    public static void main(String[] args){
        navigator = Navigator.getInstance();
        Main.init();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do {
            try {
                Integer choice = Integer.parseInt(reader.readLine());
                if (choice > (navigator.getCurrentMenu().getMenu().size())) {
                    System.out.println("Wrong option");
                    continue;
                }
                navigator.navigate(choice);
            } catch (IOException e) {
                ExceptionLogger.log(Level.ERROR, e.getMessage());
            }
        }
        while (true);
    }
}
