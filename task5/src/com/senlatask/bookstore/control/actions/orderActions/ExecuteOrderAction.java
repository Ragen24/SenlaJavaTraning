package com.senlatask.bookstore.control.actions.orderActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.control.exception.ObjectNotFoundException;
import com.senlatask.bookstore.model.Model;
import com.senlatask.bookstore.model.models.Order;
import com.senlatask.bookstore.util.ExceptionLogger;
import org.apache.logging.log4j.Level;

import java.io.IOException;

public class ExecuteOrderAction extends AbstractAction {

    public ExecuteOrderAction(String name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter the order id:");
            Order order = model.completeOrder(Long.parseLong(reader.readLine()));
            if (order != null) {
                System.out.println("Order: " + order + " completed.");
            } else {
                throw new ObjectNotFoundException("Order not found");
            }
        } catch (IOException | NumberFormatException e) {
            ExceptionLogger.log(Level.ERROR, e.getMessage());
            System.out.println("Invalid input, try again.");
        } catch (ObjectNotFoundException e) {
            ExceptionLogger.log(Level.ERROR, e.getMessage());
        }
    }
}
