package com.senlatask.bookstore.control.actions.bookActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.control.exception.ObjectNotFoundException;
import com.senlatask.bookstore.model.models.Book;
import com.senlatask.bookstore.view.enumerations.MenuConstants;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Remove book action
 */
public class RemoveBookAction extends AbstractAction {
    private static Logger logger = LogManager.getLogger(RemoveBookAction.class);

    public RemoveBookAction(MenuConstants name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter the book id:");
            Book book = model.removeBookFromStock(Long.parseLong(reader.readLine()));
            if (book != null) {
                System.out.println("Book: " + book + " remove from stock.");
            } else {
                throw new ObjectNotFoundException("Book not found.");
            }
        } catch (IOException | NumberFormatException e) {
            logger.log(Level.ERROR, e.getMessage());
            System.out.println("Invalid input, try again.");
        } catch (ObjectNotFoundException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }
}
