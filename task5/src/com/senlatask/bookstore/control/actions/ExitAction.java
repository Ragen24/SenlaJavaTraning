package com.senlatask.bookstore.control.actions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;

/**
 * Exit from program action
 */
public class ExitAction extends AbstractAction {
    public ExitAction(String name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        model.save();
        System.exit(0);
    }
}
