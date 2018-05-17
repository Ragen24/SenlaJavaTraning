package com.senlatask.bookstore.model.interfaces;

import com.senlatask.bookstore.model.models.Order;
import java.time.LocalDate;
import java.util.List;

/**
 * IOrderService interface for order service
 */
public interface IOrderService extends IService {
    List<Order> getOrders();

    List<Order> getSortedCompletedOrdersForPeriod(LocalDate from, LocalDate to, int orderType);

    double getProfitForPeriod(LocalDate from, LocalDate to);

    int getCompletedOrdersAmountForPeriod(LocalDate from, LocalDate to);

    List<Order> getSortedOrders(int orderType);

    String getOrderDetails(long id);

    void addOrder(Order order);

    Order completeOrder(long id);

    Order cancelOrder(long id);

    Order removeOrder(long id);
}
