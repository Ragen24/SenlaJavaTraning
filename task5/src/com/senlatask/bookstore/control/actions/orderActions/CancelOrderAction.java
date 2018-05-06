package com.senlatask.bookstore.control.actions.orderActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.control.exception.ObjectNotFoundException;
import com.senlatask.bookstore.model.models.Order;
import com.senlatask.bookstore.util.ExceptionLogger;
import org.apache.logging.log4j.Level;

import java.io.IOException;

/**
 * Cancel order action
 */
public class CancelOrderAction extends AbstractAction {

    public CancelOrderAction(String name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        while (true) {
            try {
                System.out.print("Enter the order id:");
                Order order = model.cancelOrder(Long.parseLong(reader.readLine()));
                if (order != null) {
                    System.out.println("Order: " + order + " canceled.");
                } else {
                    throw new ObjectNotFoundException("Order not found.");
                }
                break;
            } catch (ObjectNotFoundException e) {
                ExceptionLogger.log(Level.ERROR, e.getMessage());
                System.out.println(e.getMessage());
            } catch (IOException e) {
                ExceptionLogger.log(Level.ERROR, e.getMessage());
            }
        }
    }
}
