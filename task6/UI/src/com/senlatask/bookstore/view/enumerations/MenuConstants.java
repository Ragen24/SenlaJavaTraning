package com.senlatask.bookstore.view.enumerations;

/**
 * Enumeration for menu literal constants
 */
public enum MenuConstants {
    MAIN_MENU("Main menu"),
    BOOKS_MENU("Books menu"),
    ORDERS_MENU("Orders menu"),
    REQUESTS_MENU("Requests menu"),
    WORK_WITH_DATA_MENU("Work with data"),
    IMPORT_MENU("Import"),
    EXPORT_MENU("Export"),
    EXPORT_BOOKS("Export books"),
    IMPORT_BOOKS("Import books"),
    SHOW_ALL_BOOKS("Show all books"),
    SHOW_STALE_BOOKS("Show stale boks"),
    BACK("Back"),
    SHOW_ALL_ORDERS("Show all orders"),
    SHOW_ORDERS_BY_PERIOD("Show orders by period of time"),
    SHOW_REQUESTS("Show requests"),
    ADD_BOOK("Add book"),
    REMOVE_BOOK("Remove book"),
    VIEW_BOOK_DESCRIPTION("View book description"),
    SORT_BY_TITLE("Sort books by title"),
    SORT_BY_PUBL_DATE("Sort books by publication date"),
    SORT_BY_PRICE("Sort books by price"),
    SORT_BY_STOCK_AVAILABILITY("Sort books by stock availability"),
    SORT_STALE_BY_RECIPITNT_DATE("Sort stale books by recipient date"),
    SORT_STALE_BY_PRICE("Sort stale books by price"),
    ADD_ORDER("Add oder"),
    EXECUTE_ORDER("Execute order"),
    CANCEL_ORDER("Cancel order"),
    DUPLICATE_ORDER("Duplicate order"),
    VIEW_ORDER_DETAILS("View order details"),
    SORT_ORDERS_BY_DATE("Sort orders by date"),
    SORT_ORDERS_BY_PRICE("Sort orders by price"),
    SORT_ORDERS_BY_STATUS("Sort order by status"),
    COUNT_EXEC_ORDERS_BY_PERIOD("Show executed orders amount by period of time"),
    COUNT_TOTAL_PROFIT_BY_PERIOD("Show total profit by period of time"),
    SORT_EXEC_ORDERS_BY_DATE("Sort executed order by date"),
    SORT_EXEC_ORDERS_BY_PRICE("Sort executed order by price"),
    ADD_REQUEST("Add request"),
    GET_REQUEST_ON_BOOK("Show requests on book"),
    GET_SORTED_REQUEST_ON_BOOK("Show sorted requests on book");


    private String text;

    MenuConstants(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
