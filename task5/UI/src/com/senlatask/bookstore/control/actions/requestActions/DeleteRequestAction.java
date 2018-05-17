package com.senlatask.bookstore.control.actions.requestActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.control.actions.orderActions.CancelOrderAction;
import com.senlatask.bookstore.view.enumerations.MenuConstants;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Delete request action
 */
public class DeleteRequestAction extends AbstractAction {
    private static Logger logger = LogManager.getLogger(DeleteRequestAction.class);

    public DeleteRequestAction(MenuConstants name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter request id:");
            model.deleteRequest(Long.parseLong(reader.readLine()));
        } catch (IOException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }
}
