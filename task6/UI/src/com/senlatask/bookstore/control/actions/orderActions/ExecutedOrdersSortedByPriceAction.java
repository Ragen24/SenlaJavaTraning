package com.senlatask.bookstore.control.actions.orderActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.model.models.Order;
import com.senlatask.bookstore.util.ConsoleUtil;
import com.senlatask.bookstore.util.TableUtil;
import com.senlatask.bookstore.view.enumerations.MenuConstants;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * Sort executed orders by price action
 */
public class ExecutedOrdersSortedByPriceAction extends AbstractAction {
    private static Logger logger = LogManager.getLogger(ExecutedOrdersSortedByPriceAction.class);

    public ExecutedOrdersSortedByPriceAction(MenuConstants name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        LocalDate from;
        LocalDate to;
        while (true) {
            try {
                System.out.print("Input from date(yyyy-mm-dd): ");
                from = ConsoleUtil.readDate();
                System.out.print("Input to date(yyyy-mm-dd): ");
                to = ConsoleUtil.readDate();
                List<Order> orders = model.getSortedCompletedOrdersForPeriod(from, to, 2);
                TableUtil.printOrderTable(orders);
                break;
            } catch (IOException e) {
                logger.log(Level.ERROR, e.getMessage());
            } catch (DateTimeParseException e) {
                logger.log(Level.ERROR, e.getMessage());
                System.out.println("Invalid date format, try again.");
            }
        }

    }
}
