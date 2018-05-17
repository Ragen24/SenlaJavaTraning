package com.senlatask.bookstore.control.actions.bookActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.view.enumerations.MenuConstants;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * View book description action
 */
public class ViewBookDescriptionAction extends AbstractAction {
    private static Logger logger = LogManager.getLogger(ViewBookDescriptionAction.class);

    public ViewBookDescriptionAction(MenuConstants name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter the book id:");
            String description = model.getBookDescription(Long.parseLong(reader.readLine()));
            System.out.println(description);
        } catch (IOException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }
}
