package com.senlatask.bookstore.control.actions.orderActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.util.ExceptionLogger;
import org.apache.logging.log4j.Level;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Count executed orders action
 */
public class CountExecutedOrdersByPeriodAction extends AbstractAction {

    public CountExecutedOrdersByPeriodAction(String name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        LocalDate from;
        LocalDate to;
        int completedOrdersAmount;
        while (true) {
            try {
                System.out.print("Input from date(yyyy-mm-dd): ");
                from = LocalDate.parse(reader.readLine());
                System.out.print("Input to date(yyyy-mm-dd): ");
                to = LocalDate.parse(reader.readLine());
                completedOrdersAmount = model.getCompletedOrdersAmountForPeriod(from, to);
                System.out.println("The number of completed orders for a period of time is: " + completedOrdersAmount);
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
