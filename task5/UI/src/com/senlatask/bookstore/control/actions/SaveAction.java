package com.senlatask.bookstore.control.actions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;

/**
 * Exit from program action
 */
public class SaveAction extends AbstractAction {
    public SaveAction() {
        super("Save", 1);
    }

    @Override
    public void execute() {
        model.save();
    }
}
