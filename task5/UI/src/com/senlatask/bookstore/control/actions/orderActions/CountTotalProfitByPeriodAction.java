package com.senlatask.bookstore.control.actions.orderActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.util.ConsoleUtil;
import com.senlatask.bookstore.view.enumerations.MenuConstants;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Count total profit action
 */
public class CountTotalProfitByPeriodAction extends AbstractAction {
    private static Logger logger = LogManager.getLogger(CountTotalProfitByPeriodAction.class);

    public CountTotalProfitByPeriodAction(MenuConstants name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        LocalDate from;
        LocalDate to;
        double totalProfit;
        while (true) {
            try {
                System.out.print("Input from date(yyyy-mm-dd): ");
                from = ConsoleUtil.readDate();
                System.out.print("Input to date(yyyy-mm-dd): ");
                to = ConsoleUtil.readDate();
                totalProfit = model.getProfitForPeriod(from, to);
                System.out.println("Total profit for a period of time is: " + totalProfit);
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
