package com.senlatask.bookstore.control.actions.orderActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.control.exception.ObjectNotFoundException;
import com.senlatask.bookstore.model.models.Order;
import com.senlatask.bookstore.view.enumerations.MenuConstants;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class ExecuteOrderAction extends AbstractAction {
    private static Logger logger = LogManager.getLogger(ExecuteOrderAction.class);

    public ExecuteOrderAction(MenuConstants name, Integer id) {
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
            logger.log(Level.ERROR, e.getMessage());
            System.out.println("Invalid input, try again.");
        } catch (ObjectNotFoundException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }
}
