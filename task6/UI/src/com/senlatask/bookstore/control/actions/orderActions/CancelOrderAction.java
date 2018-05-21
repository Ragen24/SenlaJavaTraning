package com.senlatask.bookstore.control.actions.orderActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.control.actions.bookActions.ViewBookDescriptionAction;
import com.senlatask.bookstore.control.exception.ObjectNotFoundException;
import com.senlatask.bookstore.model.models.Order;
import com.senlatask.bookstore.view.enumerations.MenuConstants;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Cancel order action
 */
public class CancelOrderAction extends AbstractAction {
    private static Logger logger = LogManager.getLogger(CancelOrderAction.class);

    public CancelOrderAction(MenuConstants name, Integer id) {
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
                logger.log(Level.ERROR, e.getMessage());
                System.out.println(e.getMessage());
            } catch (IOException e) {
                logger.log(Level.ERROR, e.getMessage());
            }
        }
    }
}
