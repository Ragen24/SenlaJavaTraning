package com.senlatask.bookstore.control.actions.bookActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.control.exception.WrongInputException;
import com.senlatask.bookstore.model.models.Author;
import com.senlatask.bookstore.model.models.Book;
import com.senlatask.bookstore.util.ConsoleUtil;
import com.senlatask.bookstore.view.MenuController;
import com.senlatask.bookstore.view.enumerations.MenuConstants;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Add book action
 */
public class AddBookAction extends AbstractAction {
    private static Logger logger = LogManager.getLogger(AddBookAction.class);

    public AddBookAction(MenuConstants name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        while (true) {
            try {
                String title;
                double price;
                LocalDate publicationDate;
                Author author;
                String authorName;
                String authorSurname;
                Book book;
                System.out.print("Input book title: ");
                title = ConsoleUtil.readString();

                System.out.println("Input author name: ");
                authorName = ConsoleUtil.readString();

                System.out.println("Input author surname: ");
                authorSurname = ConsoleUtil.readString();

                author = new Author(authorName, authorSurname);

                System.out.println("Input book price: ");
                price = ConsoleUtil.readPrice();

                System.out.println("Input publication date(yyyy-mm-dd): ");
                publicationDate = ConsoleUtil.readDate();
                book = new Book(title, author, price, publicationDate);
                model.addBookToStock(book);
                System.out.println("Book: " + book + " added to stock.");
                break;
            } catch (WrongInputException e) {
                logger.log(Level.ERROR, e.getMessage());
            } catch (IOException | NumberFormatException e) {
                logger.log(Level.ERROR, e.getMessage());
                System.out.println("Invalid input, try again.");
            } catch (DateTimeParseException e) {
                logger.log(Level.ERROR, e.getMessage());
                System.out.println("Invalid date format, try again.");
            }
        }
    }
}
