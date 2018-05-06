package com.senlatask.bookstore.model.comparators;

import com.senlatask.bookstore.model.models.Order;

import java.util.Comparator;

/**
 * Order status singleton comparator
 */
public class OrderStatusComparator implements Comparator<Order> {
    private static OrderStatusComparator instance;

    private OrderStatusComparator() {}

    public static OrderStatusComparator getInstance() {
        if (instance == null) {
            instance = new OrderStatusComparator();
        }
        return instance;
    }

    /**
     * Compare by order status
     */
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getStatus().ordinal() - o2.getStatus().ordinal();
    }
}
