package com.senlatask.bookstore.control.actions.orderActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.control.actions.bookActions.AddBookAction;
import com.senlatask.bookstore.control.exception.WrongInputException;
import com.senlatask.bookstore.model.models.Client;
import com.senlatask.bookstore.model.models.Order;
import com.senlatask.bookstore.util.ConsoleUtil;
import com.senlatask.bookstore.view.enumerations.MenuConstants;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Add order action
 */
public class AddOrderAction extends AbstractAction {
    private static Logger logger = LogManager.getLogger(AddOrderAction.class);

    public AddOrderAction(MenuConstants name, Integer id) {
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
                clientName = ConsoleUtil.readString();

                System.out.println("Enter client surname: ");
                clientSurname = ConsoleUtil.readString();

                client = new Client(clientName, clientSurname);
                System.out.println("Input execution date(yyyy-mm-dd): ");
                executionDate = ConsoleUtil.readDate();
                order = new Order(client, executionDate);
                model.addOrder(order);
                break;
            } catch (WrongInputException e) {
                logger.log(Level.ERROR, e.getMessage());
                System.out.println(e.getMessage());
            } catch (IOException e) {
                logger.log(Level.ERROR, e.getMessage());
            } catch (DateTimeParseException e) {
                logger.log(Level.ERROR, e.getMessage());
                System.out.println("Invalid date format, try again.");
            }
        }

    }
}
