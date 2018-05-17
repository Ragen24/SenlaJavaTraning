package com.senlatask.bookstore.control.actions.orderActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.view.enumerations.MenuConstants;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * View orders details action
 */
public class ViewOrderDetailsAction extends AbstractAction {
    private static Logger logger = LogManager.getLogger(ViewOrderDetailsAction.class);

    public ViewOrderDetailsAction(MenuConstants name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter the order id:");
            String description = model.getOrderDetails(Long.parseLong(reader.readLine()));
            System.out.println(description);
        } catch (IOException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }
}
