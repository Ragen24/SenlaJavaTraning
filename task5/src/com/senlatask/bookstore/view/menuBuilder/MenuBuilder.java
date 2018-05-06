package com.senlatask.bookstore.view.menuBuilder;

import com.senlatask.bookstore.control.actions.ExitAction;
import com.senlatask.bookstore.control.actions.bookActions.*;
import com.senlatask.bookstore.control.actions.orderActions.*;
import com.senlatask.bookstore.control.actions.requestActions.AddRequestAction;
import com.senlatask.bookstore.control.actions.requestActions.RequestsOnBookAction;
import com.senlatask.bookstore.control.actions.requestActions.SortedRequestsAction;
import com.senlatask.bookstore.view.interfaces.IMenuItem;
import com.senlatask.bookstore.view.menu.Menu;
import static com.senlatask.bookstore.view.enumerations.MenuConstants.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Menu builder class
 */
public class MenuBuilder {
    private List<IMenuItem> mainMenuItems = new ArrayList<>();
    private List<IMenuItem> booksMenuItems = new ArrayList<>();
    private List<IMenuItem> showBooksMenuItems = new ArrayList<>();
    private List<IMenuItem> showStaleBooksMenuItems = new ArrayList<>();
    private List<IMenuItem> ordersMenuItems = new ArrayList<>();
    private List<IMenuItem> showOrdersMenuItems = new ArrayList<>();
    private List<IMenuItem> showExecutedOrdersMenuItems = new ArrayList<>();
    private List<IMenuItem> requestsMenuItems = new ArrayList<>();
    private List<IMenuItem> showRequestsMenuItems = new ArrayList<>();

    private Menu mainMenu = new Menu(MAIN_MENU.toString(), 1);
    private Menu booksMenu = new Menu(BOOKS_MENU.toString(), 2);
    private Menu ordersMenu = new Menu(ORDERS_MENU.toString(), 3);
    private Menu requestMenu = new Menu(REQUESTS_MENU.toString(), 4);
    private Menu exit = new Menu(EXIT.toString(), 4);

    private Menu showAllBooks = new Menu(SHOW_ALL_BOOKS.toString(), 1);
    private Menu showStaleBooks = new Menu(SHOW_STALE_BOOKS.toString(), 2);
    private Menu booksBack = new Menu(BACK.toString(), 6);

    private Menu showAllBooksBack = new Menu(BACK.toString(), 5);
    private Menu showStaleBooksBack = new Menu(BACK.toString(), 3);

    private Menu showAllOrders = new Menu(SHOW_ALL_ORDERS.toString(), 1);
    private Menu showExecutedOrdersByPeriodOfTime = new Menu(SHOW_ORDERS_BY_PERIOD.toString(), 2);
    private Menu ordersBack = new Menu(BACK.toString(), 7);
    private Menu showOrdersBack = new Menu(BACK.toString(), 4);
    private Menu showExecutedOrdersBack = new Menu(BACK.toString(), 3);

    private Menu showRequestOnBook = new Menu(SHOW_REQUESTS.toString(), 1);
    private Menu requestsBack = new Menu(BACK.toString(), 4);
    private Menu showRequestsBack = new Menu(BACK.toString(), 4);

    /**
     * Build menu hierarchy
     * @return main menu
     */
    public Menu buildMenu() {
        // Main menu
        mainMenuItems.add(booksMenu);
        mainMenuItems.add(ordersMenu);
        mainMenuItems.add(requestMenu);
        mainMenuItems.add(new ExitAction(EXIT.toString(), 4));
        mainMenu.setMenu(mainMenuItems);

        // Books menu
        booksMenuItems.add(showAllBooks);
        booksMenuItems.add(showStaleBooks);
        booksMenuItems.add(new AddBookAction(ADD_BOOK.toString(), 3));
        booksMenuItems.add(new RemoveBookAction(REMOVE_BOOK.toString(), 4));
        booksMenuItems.add(new ViewBookDescriptionAction(VIEW_BOOK_DESCRIPTION.toString(), 5));
        booksBack.setMenu(mainMenuItems);
        booksMenuItems.add(booksBack);
        booksMenu.setMenu(booksMenuItems);

        // Show books menu
        showBooksMenuItems.add(new BooksSortedByTitleAction(SORT_BY_TITLE.toString(), 1));
        showBooksMenuItems.add(new BooksSortedByPublicationDateAction(SORT_BY_PUBL_DATE.toString(), 2));
        showBooksMenuItems.add(new BooksSortedByPriceAction(SORT_BY_PRICE.toString(), 3));
        showBooksMenuItems.add(new BooksSortedByStockAvailabilityAction(SORT_BY_STOCK_AVAILABILITY.toString(), 4));
        showAllBooksBack.setMenu(booksMenuItems);
        showBooksMenuItems.add(showAllBooksBack);
        showAllBooks.setMenu(showBooksMenuItems);

        // Show stale books menu
        showStaleBooksMenuItems.add(new StaleBooksSortedByRecieptDateAction(SORT_STALE_BY_RECIPITNT_DATE.toString(), 1));
        showStaleBooksMenuItems.add(new StaleBooksSortedByPriceAction(SORT_STALE_BY_PRICE.toString(), 2));
        showStaleBooksBack.setMenu(booksMenuItems);
        showStaleBooksMenuItems.add(showStaleBooksBack);
        showStaleBooks.setMenu(showStaleBooksMenuItems);

        // Orders menu
        ordersMenuItems.add(showAllOrders);
        ordersMenuItems.add(showExecutedOrdersByPeriodOfTime);
        ordersMenuItems.add(new AddOrderAction(ADD_ORDER.toString(), 3));
        ordersMenuItems.add(new ExecuteOrderAction(EXECUTE_ORDER.toString(), 4));
        ordersMenuItems.add(new CancelOrderAction(CANCEL_ORDER.toString(), 5));
        ordersMenuItems.add(new ViewOrderDetailsAction(VIEW_ORDER_DETAILS.toString(), 6));
        ordersBack.setMenu(mainMenuItems);
        ordersMenuItems.add(ordersBack);
        ordersMenu.setMenu(ordersMenuItems);

        // Show orders menu
        showOrdersMenuItems.add(new OrdersSortedByDateAction(SORT_ORDERS_BY_DATE.toString(), 1));
        showOrdersMenuItems.add(new OrdersSortedByPriceAction(SORT_ORDERS_BY_PRICE.toString(), 2));
        showOrdersMenuItems.add(new OrdersSortedByStatusAction(SORT_ORDERS_BY_STATUS.toString(), 3));
        showOrdersBack.setMenu(ordersMenuItems);// Back
        showOrdersMenuItems.add(showOrdersBack);
        showAllOrders.setMenu(showOrdersMenuItems);

        // Show executed orders menu
        showExecutedOrdersMenuItems.add(new CountExecutedOrdersByPeriodAction(COUNT_EXEC_ORDERS_BY_PERIOD.toString(), 1));
        showExecutedOrdersMenuItems.add(new CountTotalProfitByPeriodAction(COUNT_TOTAL_PROFIT_BY_PERIOD.toString(), 2));
        showExecutedOrdersMenuItems.add(new ExecutedOrdersSortedByDateAction(SORT_EXEC_ORDERS_BY_DATE.toString(), 3));
        showExecutedOrdersMenuItems.add(new ExecutedOrdersSortedByPriceAction(SORT_EXEC_ORDERS_BY_PRICE.toString(), 4));
        showExecutedOrdersBack.setMenu(ordersMenuItems);// Back
        showExecutedOrdersMenuItems.add(showExecutedOrdersBack);
        showExecutedOrdersByPeriodOfTime.setMenu(showExecutedOrdersMenuItems);

        // Requests menu
        requestsMenuItems.add(showRequestOnBook);
        requestsMenuItems.add(new AddRequestAction(ADD_REQUEST.toString(), 2));
        requestsBack.setMenu(mainMenuItems);// Back
        requestsMenuItems.add(requestsBack);
        requestMenu.setMenu(requestsMenuItems);

        // Show request menu
        showRequestsMenuItems.add(new RequestsOnBookAction(GET_REQUEST_ON_BOOK.toString(), 1));
        showRequestsMenuItems.add(new SortedRequestsAction(GET_SORTED_REQUEST_ON_BOOK.toString(), 2));
        showRequestsBack.setMenu(requestsMenuItems);// Back
        showRequestsMenuItems.add(showRequestsBack);
        showRequestOnBook.setMenu(showRequestsMenuItems);

        return mainMenu;
    }
}
