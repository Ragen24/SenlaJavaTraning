package com.senlatask.bookstore.view.menuBuilder;

import com.senlatask.bookstore.control.actions.SaveAction;
import com.senlatask.bookstore.control.actions.bookActions.*;
import com.senlatask.bookstore.control.actions.dataWorkActions.ExportBooksAction;
import com.senlatask.bookstore.control.actions.dataWorkActions.ImportBooksAction;
import com.senlatask.bookstore.control.actions.orderActions.*;
import com.senlatask.bookstore.control.actions.requestActions.AddRequestAction;
import com.senlatask.bookstore.control.actions.requestActions.RequestsOnBookAction;
import com.senlatask.bookstore.control.actions.requestActions.SortedRequestsAction;
import com.senlatask.bookstore.view.interfaces.IMenuItem;
import com.senlatask.bookstore.view.menu.Menu;

import java.util.ArrayList;
import java.util.List;

import static com.senlatask.bookstore.view.enumerations.MenuConstants.*;

/**
 * Menu builder class
 */
public class MenuBuilder {


    /**
     * Build menu hierarchy
     * @return main menu
     */
    public Menu buildMenu() {
        List<IMenuItem> mainMenuItems = new ArrayList<>();
        List<IMenuItem> booksMenuItems = new ArrayList<>();
        List<IMenuItem> showBooksMenuItems = new ArrayList<>();
        List<IMenuItem> showStaleBooksMenuItems = new ArrayList<>();
        List<IMenuItem> ordersMenuItems = new ArrayList<>();
        List<IMenuItem> showOrdersMenuItems = new ArrayList<>();
        List<IMenuItem> showExecutedOrdersMenuItems = new ArrayList<>();
        List<IMenuItem> requestsMenuItems = new ArrayList<>();
        List<IMenuItem> showRequestsMenuItems = new ArrayList<>();
        List<IMenuItem> workWithDataMenuItems = new ArrayList<>();
        List<IMenuItem> importMenuItems = new ArrayList<>();
        List<IMenuItem> exportMenuItems = new ArrayList<>();

        Menu mainMenu = new Menu(MAIN_MENU, 1);
        Menu booksMenu = new Menu(BOOKS_MENU, 2);
        Menu ordersMenu = new Menu(ORDERS_MENU, 3);
        Menu requestMenu = new Menu(REQUESTS_MENU, 4);
        Menu workWithDataMenu = new Menu(WORK_WITH_DATA_MENU, 5);

        Menu showAllBooks = new Menu(SHOW_ALL_BOOKS, 1);
        Menu showStaleBooks = new Menu(SHOW_STALE_BOOKS, 2);
        Menu booksBack = new Menu(BACK, 6);

        Menu showAllBooksBack = new Menu(BACK, 5);
        Menu showStaleBooksBack = new Menu(BACK, 3);

        Menu showAllOrders = new Menu(SHOW_ALL_ORDERS, 1);
        Menu showExecutedOrdersByPeriodOfTime = new Menu(SHOW_ORDERS_BY_PERIOD, 2);
        Menu ordersBack = new Menu(BACK, 7);
        Menu showOrdersBack = new Menu(BACK, 4);
        Menu showExecutedOrdersBack = new Menu(BACK, 3);

        Menu showRequestOnBook = new Menu(SHOW_REQUESTS, 1);
        Menu requestsBack = new Menu(BACK, 4);
        Menu showRequestsBack = new Menu(BACK, 4);

        Menu importMenu = new Menu(IMPORT_MENU, 1);
        Menu exportMenu = new Menu(EXPORT_MENU, 2);
        Menu dataWorkMenuBack = new Menu(BACK, 3);

        Menu importMenuBack = new Menu(BACK, 2);
        Menu exportMenuBack = new Menu(BACK, 2);

        // Main menu
        mainMenuItems.add(booksMenu);
        mainMenuItems.add(ordersMenu);
        mainMenuItems.add(requestMenu);
        mainMenuItems.add(workWithDataMenu);
        mainMenu.setMenu(mainMenuItems);

        // Books menu
        booksMenuItems.add(showAllBooks);
        booksMenuItems.add(showStaleBooks);
        booksMenuItems.add(new AddBookAction(ADD_BOOK, 3));
        booksMenuItems.add(new RemoveBookAction(REMOVE_BOOK, 4));
        booksMenuItems.add(new ViewBookDescriptionAction(VIEW_BOOK_DESCRIPTION, 5));
        booksBack.setMenu(mainMenuItems);
        booksMenuItems.add(booksBack);
        booksMenu.setMenu(booksMenuItems);

        // Show books menu
        showBooksMenuItems.add(new BooksSortedByTitleAction(SORT_BY_TITLE, 1));
        showBooksMenuItems.add(new BooksSortedByPublicationDateAction(SORT_BY_PUBL_DATE, 2));
        showBooksMenuItems.add(new BooksSortedByPriceAction(SORT_BY_PRICE, 3));
        showBooksMenuItems.add(new BooksSortedByStockAvailabilityAction(SORT_BY_STOCK_AVAILABILITY, 4));
        showAllBooksBack.setMenu(booksMenuItems);
        showBooksMenuItems.add(showAllBooksBack);
        showAllBooks.setMenu(showBooksMenuItems);

        // Show stale books menu
        showStaleBooksMenuItems.add(new StaleBooksSortedByRecieptDateAction(SORT_STALE_BY_RECIPITNT_DATE, 1));
        showStaleBooksMenuItems.add(new StaleBooksSortedByPriceAction(SORT_STALE_BY_PRICE, 2));
        showStaleBooksBack.setMenu(booksMenuItems);
        showStaleBooksMenuItems.add(showStaleBooksBack);
        showStaleBooks.setMenu(showStaleBooksMenuItems);

        // Orders menu
        ordersMenuItems.add(showAllOrders);
        ordersMenuItems.add(showExecutedOrdersByPeriodOfTime);
        ordersMenuItems.add(new AddOrderAction(ADD_ORDER, 3));
        ordersMenuItems.add(new ExecuteOrderAction(EXECUTE_ORDER, 4));
        ordersMenuItems.add(new CancelOrderAction(CANCEL_ORDER, 5));
        ordersMenuItems.add(new DuplicateOrderAction(DUPLICATE_ORDER,6));
        ordersMenuItems.add(new ViewOrderDetailsAction(VIEW_ORDER_DETAILS, 7));
        ordersBack.setMenu(mainMenuItems);
        ordersMenuItems.add(ordersBack);
        ordersMenu.setMenu(ordersMenuItems);

        // Show orders menu
        showOrdersMenuItems.add(new OrdersSortedByDateAction(SORT_ORDERS_BY_DATE, 1));
        showOrdersMenuItems.add(new OrdersSortedByPriceAction(SORT_ORDERS_BY_PRICE, 2));
        showOrdersMenuItems.add(new OrdersSortedByStatusAction(SORT_ORDERS_BY_STATUS, 3));
        showOrdersBack.setMenu(ordersMenuItems);// Back
        showOrdersMenuItems.add(showOrdersBack);
        showAllOrders.setMenu(showOrdersMenuItems);

        // Show executed orders menu
        showExecutedOrdersMenuItems.add(new CountExecutedOrdersByPeriodAction(COUNT_EXEC_ORDERS_BY_PERIOD, 1));
        showExecutedOrdersMenuItems.add(new CountTotalProfitByPeriodAction(COUNT_TOTAL_PROFIT_BY_PERIOD, 2));
        showExecutedOrdersMenuItems.add(new ExecutedOrdersSortedByDateAction(SORT_EXEC_ORDERS_BY_DATE, 3));
        showExecutedOrdersMenuItems.add(new ExecutedOrdersSortedByPriceAction(SORT_EXEC_ORDERS_BY_PRICE, 4));
        showExecutedOrdersBack.setMenu(ordersMenuItems);// Back
        showExecutedOrdersMenuItems.add(showExecutedOrdersBack);
        showExecutedOrdersByPeriodOfTime.setMenu(showExecutedOrdersMenuItems);

        // Requests menu
        requestsMenuItems.add(showRequestOnBook);
        requestsMenuItems.add(new AddRequestAction(ADD_REQUEST, 2));
        requestsBack.setMenu(mainMenuItems);// Back
        requestsMenuItems.add(requestsBack);
        requestMenu.setMenu(requestsMenuItems);

        // Show request menu
        showRequestsMenuItems.add(new RequestsOnBookAction(GET_REQUEST_ON_BOOK, 1));
        showRequestsMenuItems.add(new SortedRequestsAction(GET_SORTED_REQUEST_ON_BOOK, 2));
        showRequestsBack.setMenu(requestsMenuItems);// Back
        showRequestsMenuItems.add(showRequestsBack);
        showRequestOnBook.setMenu(showRequestsMenuItems);

        // Work with data menu
        workWithDataMenuItems.add(importMenu);
        workWithDataMenuItems.add(exportMenu);
        dataWorkMenuBack.setMenu(mainMenuItems);
        workWithDataMenuItems.add(dataWorkMenuBack);
        workWithDataMenu.setMenu(workWithDataMenuItems);

        exportMenuItems.add(new ExportBooksAction(EXPORT_BOOKS, 1));
        exportMenuBack.setMenu(workWithDataMenuItems);
        exportMenuItems.add(exportMenuBack);
        exportMenu.setMenu(exportMenuItems);

        importMenuItems.add(new ImportBooksAction(IMPORT_BOOKS, 1));
        importMenuBack.setMenu(workWithDataMenuItems);
        importMenuItems.add(importMenuBack);
        importMenu.setMenu(importMenuItems);

        return mainMenu;
    }
}
