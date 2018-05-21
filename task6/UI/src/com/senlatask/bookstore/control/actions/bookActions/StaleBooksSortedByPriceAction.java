package com.senlatask.bookstore.control.actions.bookActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.model.models.Book;
import com.senlatask.bookstore.util.TableUtil;
import com.senlatask.bookstore.view.enumerations.MenuConstants;

import java.util.List;

/**
 * Sort stale book by price action
 */
public class StaleBooksSortedByPriceAction extends AbstractAction {

    public StaleBooksSortedByPriceAction(MenuConstants name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        List<Book> books = model.getSortedStaleBooks(2);
        TableUtil.printBookTable(books);
    }
}
