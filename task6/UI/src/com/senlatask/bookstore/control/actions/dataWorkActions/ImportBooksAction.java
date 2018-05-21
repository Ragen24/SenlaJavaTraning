package com.senlatask.bookstore.control.actions.dataWorkActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.view.enumerations.MenuConstants;

import java.io.IOException;

public class ImportBooksAction extends AbstractAction {

    public ImportBooksAction(MenuConstants name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        try {
            String fileName = reader.readLine();
            model.importBook(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
