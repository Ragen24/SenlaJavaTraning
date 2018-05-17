package com.senlatask.bookstore.model;

import com.senlatask.bookstore.model.enumerations.RequestStatus;
import com.senlatask.bookstore.model.interfaces.IBookService;
import com.senlatask.bookstore.model.interfaces.IOrderService;
import com.senlatask.bookstore.model.interfaces.IRequestService;
import com.senlatask.bookstore.model.models.Book;
import com.senlatask.bookstore.model.models.Order;
import com.senlatask.bookstore.model.models.Request;
import com.senlatask.bookstore.model.service.BookService;
import com.senlatask.bookstore.model.service.OrderService;
import com.senlatask.bookstore.model.service.RequestService;
import com.senlatask.bookstore.model.stores.BookStore;
import com.senlatask.bookstore.model.stores.OrderStore;
import com.senlatask.bookstore.model.stores.RequestStore;

import java.time.LocalDate;
import java.util.List;

/**
 * Model faced singleton class aggregates services methods
 */
public class Model {
    private static Model instance;
    private IBookService bookService;
    private IOrderService orderService;
    private IRequestService requestService;

    /**
     * Model constructor
     */
    private Model() {
        BookStore bookStore = new BookStore();
        this.bookService = new BookService(bookStore);
        this.orderService = new OrderService(new OrderStore(), bookStore);
        this.requestService = new RequestService(new RequestStore());
    }

    /**
     * Get model instance
     * @return model instance
     */
    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    /**
     * Get all books
     * @return books
     */
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    /**
     * Get book by id
     * @param id — book id
     * @return book or null
     */
    public Book getById(long id) {
        return bookService.getById(id);
    }

    /**
     * Get stale books
     * @return stale books
     */
    public List<Book> getStaleBooks() {
        return bookService.getStaleBooks();
    }

    /**
     * Get sorted stale books
     * @param orderType — order type
     * @return sorted stale books
     */
    public List<Book> getSortedStaleBooks(int orderType) {
        return bookService.getSortedStaleBooks(orderType);
    }

    /**
     * Get sorted books
     * @param orderType — order type
     * @return sorted books
     */
    public List<Book> getSortedBooks(int orderType) {
        return bookService.getSortedBooks(orderType);
    }

    /**
     * Get book description by book id
     * @param id — book id
     * @return book description
     */
    public String getBookDescription(long id) {
        return bookService.getBookDescription(id);
    }

    /**
     * Add book to stock
     * @param book — added book
     */
    public void addBookToStock(Book book) {
        bookService.addBookToStock(book);
        for (Request request : requestService.getRequestsOnBook(book)) {
            request.setStatus(RequestStatus.DONE);
        }
    }

    /**
     * Remove book from stock by book id
     * @param id — book id
     * @return book or null
     */
    public Book removeBookFromStock(long id) {
        return bookService.removeBookFromStock(id);
    }

    /**
     * Get orders
     * @return orders
     */
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    /**
     * Get sorted completed order for period of time
     * @param from — first date of period
     * @param to — last date of period
     * @param orderType — order type
     * @return orders
     */
    public List<Order> getSortedCompletedOrdersForPeriod(LocalDate from, LocalDate to, int orderType) {
        return orderService.getSortedCompletedOrdersForPeriod(from, to, orderType);
    }

    /**
     * Get profit for period of time
     * @param from — first date of period
     * @param to — last date of period
     * @return orders
     */
    public double getProfitForPeriod(LocalDate from, LocalDate to) {
        return orderService.getProfitForPeriod(from, to);
    }

    /**
     * Get amount completed orders  for period of time
     * @param from — first date of period
     * @param to — last date of period
     * @return amount of completed orders
     */
    public int getCompletedOrdersAmountForPeriod(LocalDate from, LocalDate to) {
        return orderService.getCompletedOrdersAmountForPeriod(from, to);
    }

    /**
     * Get sorted orders
     * @param orderType — order type
     * @return sorted orders
     */
    public List<Order> getSortedOrders(int orderType) {
        return orderService.getSortedOrders(orderType);
    }

    /**
     * Get details of orders by order id
     * @param id — order id
     * @return order details
     */
    public String getOrderDetails(long id) {
        return orderService.getOrderDetails(id);
    }

    /**
     * Add order
     * @param order
     */
    public void addOrder(Order order) {
        orderService.addOrder(order);
    }

    /**
     * Complete order by order id
     * @param id — order id
     * @return order or null
     */
    public Order completeOrder(long id) {
        return orderService.completeOrder(id);
    }

    /**
     * Cancel order by order id
     * @param id — order id
     * @return order or null
     */
    public Order cancelOrder(long id) {
        return orderService.cancelOrder(id);
    }

    /**
     * Remove order by order id
     * @param id — order id
     * @return order or null
     */
    public Order removeOrder(long id) {
        return orderService.removeOrder(id);
    }

    /**
     * Get requests on book by book id
     * @param id — book id
     * @return requests
     */
    public List<Request> getRequestsOnBook(long id) {
        Book book = getById(id);
        return requestService.getRequestsOnBook(book);
    }

    /**
     * Get sorted requests on book by book id
     * @param id — book id
     * @return requests
     */
    public List<Request> getSortedRequestsOnBook(long id) {
        Book book = getById(id);
        return requestService.getSortedRequestsOnBook(book);
    }

    /**
     * Add request on book by book id
     * @param bookId — book id
     */
    public void addRequest(long bookId) {
        Book book = getById(bookId);
        if (book != null) {
            Request request = new Request(book);
            requestService.addRequest(request);
        }
    }

    /**
     * Delete request on book by book id
     * @param id — book id
     * @return request or null
     */
    public Request deleteRequest(long id) {
        return requestService.deleteRequest(id);
    }

    /**
     * Save books, orders and requests to file
     */
    public void save() {
        bookService.save();
        orderService.save();
        requestService.save();
    }

    /**
     * Load books, orders and requests from file
     */
    public void load() {
        bookService.load();
        orderService.load();
        requestService.load();
    }
}
