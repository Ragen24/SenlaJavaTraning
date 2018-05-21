package com.senlatask.bookstore.control.actions.orderActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.model.models.Order;
import com.senlatask.bookstore.util.TableUtil;
import com.senlatask.bookstore.view.enumerations.MenuConstants;

import java.util.List;

/**
 * Sort orders by date action
 */
public class OrdersSortedByDateAction extends AbstractAction {

    public OrdersSortedByDateAction(MenuConstants name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        List<Order> orders = model.getSortedOrders(1);
        TableUtil.printOrderTable(orders);
    }
}
