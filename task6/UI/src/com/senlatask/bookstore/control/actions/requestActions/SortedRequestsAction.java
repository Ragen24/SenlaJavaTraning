package com.senlatask.bookstore.control.actions.requestActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.control.actions.orderActions.CancelOrderAction;
import com.senlatask.bookstore.model.models.Request;
import com.senlatask.bookstore.util.TableUtil;
import com.senlatask.bookstore.view.enumerations.MenuConstants;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * Sort request on a book action
 */
public class SortedRequestsAction extends AbstractAction {
    private static Logger logger = LogManager.getLogger(SortedRequestsAction.class);

    public SortedRequestsAction(MenuConstants name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter book id:");
            List<Request> requests =  model.getSortedRequestsOnBook(Long.parseLong(reader.readLine()));
            TableUtil.printRequestTable(requests);
        } catch (IOException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }
}
