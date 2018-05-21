package com.senlatask.bookstore.model.comparators;

import com.senlatask.bookstore.model.models.Order;

import java.util.Comparator;

/**
 * Order price singleton comparator
 */
public class OrderPriceComparator implements Comparator<Order> {
    private static OrderPriceComparator instance;

    private OrderPriceComparator() {}

    public static OrderPriceComparator getInstance() {
        if (instance == null) {
            instance = new OrderPriceComparator();
        }
        return instance;
    }

    /**
     * Compare by price
     */
    @Override
    public int compare(Order o1, Order o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
