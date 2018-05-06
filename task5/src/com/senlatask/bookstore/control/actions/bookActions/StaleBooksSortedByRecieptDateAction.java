package com.senlatask.bookstore.control.actions.bookActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.model.models.Book;
import com.senlatask.bookstore.util.TableUtil;

import java.util.List;

/**
 * Sort stale books by reciept date action
 */
public class StaleBooksSortedByRecieptDateAction extends AbstractAction {

    public StaleBooksSortedByRecieptDateAction(String name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        List<Book> books = model.getSortedStaleBooks(1);
        TableUtil.printBookTable(books);
    }
}
