package com.senlatask.bookstore.control.actions.bookActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.model.models.Book;
import com.senlatask.bookstore.util.TableUtil;

import java.util.List;

/**
 * Sort book by publication date action
 */
public class BooksSortedByPublicationDateAction extends AbstractAction {

    public BooksSortedByPublicationDateAction(String name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        List<Book> books = model.getSortedBooks(2);
        TableUtil.printBookTable(books);
    }
}
