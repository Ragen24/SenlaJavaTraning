package com.senlatask.bookstore.model.service;

import com.senlatask.bookstore.model.comparators.OrderExecutionDateComparator;
import com.senlatask.bookstore.model.comparators.OrderPriceComparator;
import com.senlatask.bookstore.model.comparators.OrderStatusComparator;
import com.senlatask.bookstore.model.enumerations.OrderStatus;
import com.senlatask.bookstore.model.interfaces.IOrderService;
import com.senlatask.bookstore.model.models.Book;
import com.senlatask.bookstore.model.models.Order;
import com.senlatask.bookstore.model.stores.BookStore;
import com.senlatask.bookstore.model.stores.OrderStore;
import com.senlatask.bookstore.util.FileUtil;
import com.senlatask.bookstore.util.OrderFileUtil;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Order service class with properties <b>orderstore</b>, <b>bookstore</b> and <b>orderUtil</b>
 */
public class OrderService implements IOrderService {
    private OrderStore orderStore;
    private BookStore bookStore;
    private final FileUtil<Order> orderUtil = new OrderFileUtil();

    /**
     * Order service constuctor
     * @param orderStore — orders store
     * @param bookStore — books store
     */
    public OrderService(OrderStore orderStore, BookStore bookStore) {
        this.orderStore = orderStore;
        this.bookStore = bookStore;
    }

    /**
     * Get orders
     * @return orders
     */
    @Override
    public List<Order> getOrders() {
        return orderStore.getAll();
    }

    /**
     * Get order by order id
     * @param id — order id
     * @return order
     */
    public Order getById(long id) {
        return orderStore.getById(id);
    }

    /**
     * Get sorted completed order for period of time
     * @param from — first date of period
     * @param to — last date of period
     * @param orderType — order type 1 - date order, 2 - price order
     * @return list of completed orders(with status DONE)
     */
    @Override
    public List<Order> getSortedCompletedOrdersForPeriod(LocalDate from, LocalDate to, int orderType) {
        List<Order> completedOrders = new ArrayList<>();
        for (Order order : orderStore.getAll()) {
            if (order.getStatus() == OrderStatus.DONE && order.getExecutionDate().compareTo(from) >= 0 &&
                    order.getExecutionDate().compareTo(to) <= 0) {
                completedOrders.add(order);
            }
        }
        switch (orderType) {
            case 1 :
                Collections.sort(completedOrders, OrderExecutionDateComparator.getInstance());
                break;
            case 2 :
                Collections.sort(completedOrders, OrderPriceComparator.getInstance());
                break;
        }
        return completedOrders;
    }

    /**
     * Get total profit for period of time
     * @param from — first date of period
     * @param to — last date of period
     * @return total profit
     */
    @Override
    public double getProfitForPeriod(LocalDate from, LocalDate to) {
        double totalProfit = 0;
        List<Order> completedOrders = getSortedCompletedOrdersForPeriod(from, to, 1);
        for (Order order : completedOrders) {
            totalProfit += order.getPrice();
        }
        return totalProfit;
    }

    /**
     * Get amount of completed orders for period of time
     * @param from — first date of period
     * @param to — last date of period
     * @return amount of completed orders
     */
    @Override
    public int getCompletedOrdersAmountForPeriod(LocalDate from, LocalDate to) {
        int completedOrdersAmount = 0;
        for (Order order : orderStore.getAll()) {
            if (order.getStatus() == OrderStatus.DONE && order.getExecutionDate().compareTo(from) >= 0 &&
                    order.getExecutionDate().compareTo(to) <= 0) {
                completedOrdersAmount++;
            }
        }
        return completedOrdersAmount;
    }

    /**
     * Get sorted orders
     * @param orderType — order type 1 - execution date order, 2 - price order, 3 - status comparator
     * @return sorted orders
     */
    @Override
    public List<Order> getSortedOrders(int orderType) {
        List<Order> sortedOrders = new ArrayList<>(getOrders());
        switch (orderType) {
            case 1 :
                Collections.sort(sortedOrders, OrderExecutionDateComparator.getInstance());
                break;
            case 2 :
                Collections.sort(sortedOrders, OrderPriceComparator.getInstance());
                break;
            case 3 :
                Collections.sort(sortedOrders, OrderStatusComparator.getInstance());
                break;
        }
        return sortedOrders;
    }

    /**
     * Get order description by id
     * @param id — order id
     * @return order details or "Order not found."
     */
    @Override
    public String getOrderDetails(long id) {
        Order order = getById(id);
        if (order != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Order by ");
            stringBuilder.append(order.getClient());
            stringBuilder.append(order.getClient());
            if (order.getBooks().size() == 1) {
                stringBuilder.append("\nContains book ").append(order.getBooks());
            } else if (order.getBooks().size() > 1) {
                stringBuilder.append("\nContains books: ");
                for (Book book : bookStore.getAll()) {
                    stringBuilder.append("\n ").append(book).append(" costs").append(book.getPrice());
                }
            } //TODO: else
            stringBuilder.append("\nExecutionDate: ").append(order.getExecutionDate());
            stringBuilder.append("\nStatus: ").append(order.getStatus().name());
            return stringBuilder.toString();
        } else {
            return "Order not found.";
        }
    }

    /**
     * Add order
     * @param order — added order
     */
    @Override
    public void addOrder(Order order) {
        orderStore.addNew(order);
    }

    /**
     * Assemble order and change order status by id
     * @param id — order id
     * @return <b>order</b> or <b>null</b> if order not found
     */
    @Override
    public Order completeOrder(long id) {
        Order order = getById(id);
        if (order != null) {
            order.setStatus(OrderStatus.PACKAGING);
            for (Book book : order.getBooks()) {
                bookStore.delete(book);
            }
            order.setStatus(OrderStatus.DELIVERING);
            return order;
        }
        return null;
    }

    /**
     * Cancel order by id
     * @param id — order id
     * @return <b>order</b> or <b>null</b> if order not found
     */
    @Override
    public Order cancelOrder(long id) {
        Order order = getById(id);
        if (order != null) {
            if (order.getStatus() == OrderStatus.DELIVERING) {
                bookStore.addAll(order.getBooks());
            }
            order.setStatus(OrderStatus.CANCELED);
            return order;
        }
        return null;
    }

    /**
     * Remove order by id
     * @param id — order id
     * @return <b>order</b> or <b>null</b> if order not found
     */
    @Override
    public Order removeOrder(long id) {
        return orderStore.deleteById(id);
    }

    /**
     * Get order store
     * @return orderStore
     */
    @Override
    public OrderStore getStore() {
        return orderStore;
    }

    /**
     * Save orders
     */
    @Override
    public void save() {
        /*Order[] array = getOrders().toArray(new Order[getOrders().size()]);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("resources/orders.ser"))) {
            objectOutputStream.writeObject(array);

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    /**
     * Load orders
     */
    @Override
    public void load() {
        /*try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("resources/orders.ser"))) {
            Order[] array = (Order[])objectInputStream.readObject();
            orderStore.addAll(new ArrayList<Order>(Arrays.asList(array)));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public Order duplicateOrder(long id) {
        Order sourceOrder = getById(id);
        if (sourceOrder == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

            objectOutputStream.writeObject(sourceOrder);
            objectOutputStream.close();

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

            return (Order)objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
