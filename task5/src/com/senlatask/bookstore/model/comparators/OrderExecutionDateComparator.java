package com.senlatask.bookstore.model.comparators;

import com.senlatask.bookstore.model.models.Order;

import java.util.Comparator;

/**
 * Order execution date singleton comparator
 */
public class OrderExecutionDateComparator implements Comparator<Order> {
    private static OrderExecutionDateComparator instance;

    private OrderExecutionDateComparator() {}

    public static OrderExecutionDateComparator getInstance() {
        if (instance == null) {
            instance = new OrderExecutionDateComparator();
        }
        return instance;
    }

    /**
     * Compare by execution date
     */
    @Override
    public int compare(Order o1, Order o2) {
        if (o1.getExecutionDate() == null || o2.getExecutionDate() == null) {
            return 0;
        }
        return o1.getExecutionDate().compareTo(o2.getExecutionDate());
    }
}
