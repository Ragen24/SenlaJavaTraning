package com.senlatask.bookstore.control.actions.orderActions;

import com.senlatask.bookstore.control.abstractClasses.AbstractAction;
import com.senlatask.bookstore.model.models.Order;
import com.senlatask.bookstore.util.TableUtil;

import java.util.List;

/**
 * Sort orders by status action
 */
public class OrdersSortedByStatusAction extends AbstractAction {

    public OrdersSortedByStatusAction(String name, Integer id) {
        super(name, id);
    }

    @Override
    public void execute() {
        List<Order> orders = model.getSortedOrders(3);
        TableUtil.printOrderTable(orders);
    }
}
