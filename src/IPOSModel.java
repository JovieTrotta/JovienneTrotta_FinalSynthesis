// Import statements.
import java.util.ArrayList;

public interface IPOSModel {

    /**
     * Creates a new order in the system and adds it to the list of all orders.
     * @param N (string) is the name of the customer.
     * @param PN (string) is the phone number for the customer.
     * @param year (int) is year for the order pickup date.
     * @param month (int) is month for the order pickup date.
     * @param day (int) is day for the order pickup date.
     */
    void newOrder(String N, String PN, int year, int month, int day);

    /**
     * Removes an order from the list of all orders.
     * @param orderNumber (int) is the order to be removed.
     */
    void removeOrder(int orderNumber);

    /**
     * Returns the number of items in the list of all orders.
     * @return the number (int) of orders in the system.
     */
    int getOrderListSize();

    /**
     * Returns all the orders in the system.
     * @return all orders (string) in the system.
     */
    String streamAllOrders();

    /**
     * Returns the order with the matching order number.
     * Throws an exception if the order number is out of range.
     * @param orderNumber (int) is the order number to search for.
     * @return an order (Order) if it matches the given order number.
     */
    Order lookupOrderNumber(int orderNumber);

    /**
     * Returns the order with the matching order name.
     * @param name (String) is the order name to search for.
     * @return an order (Order) if it matches the given order name.
     */
    Order lookupOrderName(String name);

    /**
     * Returns the order with the matching order phone number.
     * @param phoneNumber (String) is the order phone number to search for.
     * @return an order (Order) if it matches the given order phone number.
     */
    Order lookupOrderPhoneNumber(String phoneNumber);

    /**
     * Returns the orders with the matching order pickup date.
     * @param year (int) is the order pickup date year.
     * @param month (int) is the order pickup date month.
     * @param day (int) is the order pickup date day.
     * @return an order (Order) if it matches the given date.
     */
    ArrayList lookupOrderDate(int year, int month, int day);

    /**
     * Returns the total profit for all the orders in the system.
     * @return profit (double) for all orders.
     */
    double getProfit();

    /**
     * Returns the average price for all the orders in the system.
     * @return average (double) for all orders.
     */
    double getAverageOrder();

    /**
     * Sorts all the orders in the system by pickup date (soonest to farthest).
     */
    void sortByDate();

    /**
     * Sorts all the orders in the system by order number (lowest to highest).
     */
    void sortByNumber();

    /**
     * Sorts all the orders in the system by customer name (first name, alphabetically).
     */
    void sortByName();

    /**
     * Sorts all the orders in the system by order cost (highest to lowest).
     */
    void sortByTotalCost();
}
