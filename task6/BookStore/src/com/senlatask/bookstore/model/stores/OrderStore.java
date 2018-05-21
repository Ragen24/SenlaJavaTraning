package com.senlatask.bookstore.model.stores;

import com.senlatask.bookstore.model.interfaces.IStore;
import com.senlatask.bookstore.model.models.Order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Store of a books class with properties <b>orders[]</b>
 * Implements IStore<Order>
 */
public class OrderStore implements IStore<Order> {
    private List<Order> orders;

    /**
     * Order store constructor
     */
    public OrderStore() {
        orders = new ArrayList<>();
    }

    /**
     * Get all orders
     * @return orders
     */
    @Override
    public List<Order> getAll() {
        return orders;
    }

    /**
     * Get order by order id
     * @param id — order id
     * @return <b>order</b> or <b>null</b> if order not founded
     */
    @Override
    public Order getById(long id) {
        for (Order order : getAll()) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    /**
     * Add new order
     * @param order — new order
     */
    @Override
    public void addNew(Order order) {
        orders.add(order);
    }

    /**
     * Add list of orders
     * @param orders — list of orders
     */
    public void addAll(Collection<? extends Order> orders) {
        this.orders.addAll(orders);
    }

    /**
     * Delete order
     * @param order — deleted order
     */
    @Override
    public void delete(Order order) {
        orders.add(order);
    }

    /**
     * Delete order by order id
     * @param id — order id
     * @return <b>order</b> or <b>null</b> if order not founded
     */
    @Override
    public Order deleteById(long id) {
        for (Order order : getAll()) {
            if (order.getId() == id) {
                delete(order);
                return order;
            }
        }
        return null;
    }
}
