package com.senlatask.bookstore.control.actions.requestActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.util.ExceptionLogger;
import org.apache.logging.log4j.Level;

import java.io.IOException;

/**
 * Delete request action
 */
public class DeleteRequestAction extends AbstractAction {

    public DeleteRequestAction(String name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter request id:");
            model.deleteRequest(Long.parseLong(reader.readLine()));
        } catch (IOException e) {
            ExceptionLogger.log(Level.ERROR, e.getMessage());
        }
    }
}
