package com.senlatask.bookstore.control.actions.orderActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.util.ExceptionLogger;
import org.apache.logging.log4j.Level;

import java.io.IOException;

/**
 * View orders details action
 */
public class ViewOrderDetailsAction extends AbstractAction {

    public ViewOrderDetailsAction(String name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter the order id:");
            String description = model.getOrderDetails(Long.parseLong(reader.readLine()));
            System.out.println(description);
        } catch (IOException e) {
            ExceptionLogger.log(Level.ERROR, e.getMessage());
        }
    }
}
