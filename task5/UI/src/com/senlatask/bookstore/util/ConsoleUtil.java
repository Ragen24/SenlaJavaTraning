package com.senlatask.bookstore.util;

import com.senlatask.bookstore.control.actions.SaveAction;
import com.senlatask.bookstore.control.exception.WrongInputException;
import com.senlatask.bookstore.view.Navigator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public abstract class ConsoleUtil {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Navigator navigator = Navigator.getInstance();

    private static final String EXIT = "exit";

    public static Integer readMenuItemIndex() throws IOException, WrongInputException{
        String choice = reader.readLine();
        if (choice.equalsIgnoreCase(EXIT)) {
            new SaveAction().execute();
            return -1;
        }
        Integer index = Integer.parseInt(choice);
        if (index > navigator.getCurrentMenu().getMenu().size() || index <= 0) {
            throw new WrongInputException("Wrong option");
        }
        return index;

    }

    public static String readString() throws IOException, WrongInputException  {
        String string = reader.readLine();
        if (string.equals("")) {
            throw new WrongInputException("String can not be empty.");
        }
        return string;
    }

    public static Double readPrice() throws IOException, NumberFormatException, WrongInputException {
        Double price = Double.parseDouble(reader.readLine());
        if (price <= 0) {
            throw new WrongInputException("Price cannot be zero or negative");
        }
        return price;
    }

    public static LocalDate readDate() throws IOException, DateTimeParseException {
        LocalDate date = LocalDate.parse(reader.readLine());
        return date;
    }
}
