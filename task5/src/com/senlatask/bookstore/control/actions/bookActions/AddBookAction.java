package com.senlatask.bookstore.control.actions.bookActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.control.exception.WrongInputException;
import com.senlatask.bookstore.model.models.Author;
import com.senlatask.bookstore.model.models.Book;
import com.senlatask.bookstore.util.ExceptionLogger;
import org.apache.logging.log4j.Level;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Add book action
 */
public class AddBookAction extends AbstractAction {

    public AddBookAction(String name, Integer id) {
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
                title = reader.readLine();
                if (title.equals("")) {
                    throw new WrongInputException("Title can not be empty.");
                }
                System.out.println("Input author name: ");
                authorName = reader.readLine();
                if (authorName.equals("")) {
                    throw new WrongInputException("Author name can not be empty.");
                }
                System.out.println("Input author surname: ");
                authorSurname = reader.readLine();
                if (authorSurname.equals("")) {
                    throw new WrongInputException("Author surname can not be empty.");
                }
                author = new Author(authorName, authorSurname);
                System.out.println("Input book price: ");
                price = Double.parseDouble(reader.readLine());
                System.out.println("Input publication date(yyyy-mm-dd): ");
                publicationDate = LocalDate.parse(reader.readLine());
                book = new Book(title, author, price, publicationDate);
                model.addBookToStock(book);
                System.out.println("Book: " + book + " added to stock.");
                break;
            } catch (WrongInputException e) {
                ExceptionLogger.log(Level.ERROR, e.getMessage());
            } catch (IOException | NumberFormatException e) {
                ExceptionLogger.log(Level.ERROR, e.getMessage());
                System.out.println("Invalid input, try again.");
            } catch (DateTimeParseException e) {
                ExceptionLogger.log(Level.ERROR, e.getMessage());
                System.out.println("Invalid date format, try again.");
            }
        }
    }
}
