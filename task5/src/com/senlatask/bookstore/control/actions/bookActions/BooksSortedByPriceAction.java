package com.senlatask.bookstore.control.actions.bookActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.model.models.Book;
import com.senlatask.bookstore.util.TableUtil;

import java.util.List;

/**
 * Sort books by price action
 */
public class BooksSortedByPriceAction extends AbstractAction {

    public BooksSortedByPriceAction(String name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        List<Book> books = model.getSortedBooks(4);
        TableUtil.printBookTable(books);
    }
}
