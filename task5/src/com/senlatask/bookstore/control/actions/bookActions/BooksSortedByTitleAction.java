package com.senlatask.bookstore.control.actions.bookActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.model.models.Book;
import com.senlatask.bookstore.util.TableUtil;

import java.util.List;

/**
 * Sort books by title action
 */
public class BooksSortedByTitleAction extends AbstractAction {

    public BooksSortedByTitleAction(String name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        List<Book> books = model.getSortedBooks(1);
        TableUtil.printBookTable(books);
    }
}
