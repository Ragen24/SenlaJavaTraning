package com.senlatask.bookstore.control.actions.orderActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.control.exception.WrongInputException;
import com.senlatask.bookstore.model.models.Client;
import com.senlatask.bookstore.model.models.Order;
import com.senlatask.bookstore.util.ExceptionLogger;
import org.apache.logging.log4j.Level;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Add order action
 */
public class AddOrderAction extends AbstractAction {

    public AddOrderAction(String name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        Client client;
        Order order;
        String clientName;
        String clientSurname;
        LocalDate executionDate;
        while (true) {
            try {
                System.out.println("Enter client name: ");
                clientName = reader.readLine();
                if (clientName.equals("")) {
                    throw new WrongInputException("Empty client name");
                }
                System.out.println("Enter client surname: ");
                clientSurname = reader.readLine();
                if (clientName.equals("")) {
                    throw new WrongInputException("Empty client surname");
                }
                client = new Client(clientName, clientSurname);
                System.out.println("Input execution date(yyyy-mm-dd): ");
                executionDate = LocalDate.parse(reader.readLine());
                order = new Order(client, executionDate);
                model.addOrder(order);
                break;
            } catch (WrongInputException e) {
                ExceptionLogger.log(Level.ERROR, e.getMessage());
                System.out.println(e.getMessage());
            } catch (IOException e) {
                ExceptionLogger.log(Level.ERROR, e.getMessage());
            } catch (DateTimeParseException e) {
                ExceptionLogger.log(Level.ERROR, e.getMessage());
                System.out.println("Invalid date format, try again.");
            }
        }

    }
}
