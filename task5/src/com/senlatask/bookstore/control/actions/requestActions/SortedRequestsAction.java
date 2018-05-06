package com.senlatask.bookstore.control.actions.requestActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;

import com.senlatask.bookstore.model.models.Request;
import com.senlatask.bookstore.util.ExceptionLogger;
import com.senlatask.bookstore.util.TableUtil;
import org.apache.logging.log4j.Level;

import java.io.IOException;
import java.util.List;

/**
 * Sort request on a book action
 */
public class SortedRequestsAction extends AbstractAction{

    public SortedRequestsAction(String name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        try {
            System.out.print("Enter book id:");
            List<Request> requests =  model.getSortedRequestsOnBook(Long.parseLong(reader.readLine()));
            TableUtil.printRequestTable(requests);
        } catch (IOException e) {
            ExceptionLogger.log(Level.ERROR, e.getMessage());
        }
    }
}
