package com.senlatask.bookstore.control.actions.requestActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.control.actions.orderActions.CancelOrderAction;
import com.senlatask.bookstore.view.enumerations.MenuConstants;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Add request on a book action
 */
public class AddRequestAction extends AbstractAction {
    private static Logger logger = LogManager.getLogger(AddRequestAction.class);

    public AddRequestAction(MenuConstants name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter book id:");
            model.addRequest(Long.parseLong(reader.readLine()));
        } catch (IOException e) {
            logger.log(Level.ERROR, e.getMessage());
        }

    }
}
