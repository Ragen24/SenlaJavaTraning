package com.senlatask.bookstore.control.actions.orderActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.model.models.Order;
import com.senlatask.bookstore.util.ExceptionLogger;
import com.senlatask.bookstore.util.TableUtil;
import org.apache.logging.log4j.Level;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * Sort executed orders by date action
 */
public class ExecutedOrdersSortedByDateAction extends AbstractAction {

    public ExecutedOrdersSortedByDateAction(String name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        LocalDate from;
        LocalDate to;
        while (true) {
            try {
                System.out.print("Input from date(yyyy-mm-dd): ");
                from = LocalDate.parse(reader.readLine());
                System.out.print("Input to date(yyyy-mm-dd): ");
                to = LocalDate.parse(reader.readLine());
                List<Order> orders = model.getSortedCompletedOrdersForPeriod(from, to, 1);
                TableUtil.printOrderTable(orders);
                break;
            } catch (IOException e) {
                ExceptionLogger.log(Level.ERROR, e.getMessage());
            } catch (DateTimeParseException e) {
                ExceptionLogger.log(Level.ERROR, e.getMessage());
                System.out.println("Invalid date format, try again.");
            }
        }
    }
}
