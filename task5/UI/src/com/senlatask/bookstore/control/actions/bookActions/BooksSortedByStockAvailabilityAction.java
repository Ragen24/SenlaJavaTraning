package com.senlatask.bookstore.control.actions.bookActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.model.models.Book;
import com.senlatask.bookstore.util.TableUtil;
import com.senlatask.bookstore.view.enumerations.MenuConstants;

import java.util.List;

/**
 * Sort books by stock availability action
 */
public class BooksSortedByStockAvailabilityAction extends AbstractAction {

    public BooksSortedByStockAvailabilityAction(MenuConstants name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        List<Book> books = model.getSortedBooks(3);
        TableUtil.printBookTable(books);
    }
}
