// Import statements.
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

// Point of Sale System model.
public class POSModel implements IPOSModel{

    // The POS system has a single attribute, and that is the list of all orders in the system.
    private ArrayList<Order> allOrders = new ArrayList<>();

    /**
     * Creates a new order in the system and adds it to the list of all orders.
     * @param N (string) is the name of the customer.
     * @param PN (string) is the phone number for the customer.
     * @param year (int) is year for the order pickup date.
     * @param month (int) is month for the order pickup date.
     * @param day (int) is day for the order pickup date.
     */
    @Override
    public void newOrder(String N, String PN, int year, int month, int day) {allOrders.add(new Order(N, PN, year, month, day));}

    /**
     * Removes an order from the list of all orders.
     * @param orderNumber (int) is the order to be removed.
     */
    public void removeOrder(int orderNumber) {
        int index = allOrders.indexOf(lookupOrderNumber(orderNumber));
        this.allOrders.remove(index);
    }

    /**
     * Returns the number of items in the list of all orders.
     * @return the number (int) of orders currently in the system.
     */
    @Override
    public int getOrderListSize() {return allOrders.size();}

    /**
     * Returns all the orders in the system.
     * @return all orders (string) in the system.
     */
    @Override
    public String streamAllOrders() {
        return allOrders.stream().map(e -> e.toString()).collect(Collectors.joining());
    }

    /**
     * Returns the order with the matching order number.
     * Throws an exception if the order number is out of range.
     * @param orderNumber (int) is the order number to search for.
     * @return an order (Order) if it matches the given order number.
     */
    @Override
    public Order lookupOrderNumber(int orderNumber) {
        if (orderNumber == 0) {
            throw new IndexOutOfBoundsException("Invalid order number.");
        }
        for (int i = 0; i < allOrders.size(); i++) {
            if (orderNumber == allOrders.get(i).getOrderNumber()) {
                return allOrders.get(i);
            }
        }
        return null;
    }

    /**
     * Returns the order with the matching order name.
     * @param name (String) is the order name to search for.
     * @return an order (Order) if it matches the given order name.
     */
    @Override
    public Order lookupOrderName(String name) {
        for (int i = 0; i < allOrders.size(); i++) {
            if (Objects.equals(name, allOrders.get(i).getName())) {
                return allOrders.get(i);
            }
        }
        return null;
    }

    /**
     * Returns the order with the matching order phone number.
     * @param phoneNumber (String) is the order phone number to search for.
     * @return an order (Order) if it matches the given order phone number.
     */
    @Override
    public Order lookupOrderPhoneNumber(String phoneNumber) {
        for (int i = 0; i < allOrders.size(); i++) {
            if (Objects.equals(phoneNumber, allOrders.get(i).getPhoneNumber())) {
                return allOrders.get(i);
            }
        }
        return null;
    }

    /**
     * Returns the orders with the matching order pickup date.
     * @param year (int) is the order pickup date year.
     * @param month (int) is the order pickup date month.
     * @param day (int) is the order pickup date day.
     * @return an order (Order) if it matches the given date.
     */
    @Override
    public ArrayList lookupOrderDate(int year, int month, int day) {
        LocalDate compareDate = LocalDate.of(year, month, day);
        ArrayList<Order> dateList = new ArrayList<>();
        for (int i = 0; i < allOrders.size(); i++) {
            if (compareDate.compareTo(allOrders.get(i).getPickupDate()) == 0) {
                dateList.add(allOrders.get(i));
            }
        }
        return dateList;
    }

    /**
     * Returns the total profit for all the orders in the system.
     * @return profit (double) for all orders.
     */
    @Override
    public double getProfit() {
        Double profit = 0.0;
        for (int i = 0; i < allOrders.size(); i++) {
            profit += allOrders.get(i).getTotalCost();
        }
        return profit;
    }

    /**
     * Returns the average price for all the orders in the system.
     * @return average (double) for all orders.
     */
    @Override
    public double getAverageOrder() {
        Double sum = 0.0;
        if (allOrders.size() == 0) {
            return 0.0;
        }
        for (int i = 0; i < allOrders.size(); i++) {
            sum += allOrders.get(i).getTotalCost();
        }
        return sum / allOrders.size();
    }

    /**
     * Sorts all the orders in the system by pickup date (soonest to farthest).
     */
    @Override
    public void sortByDate() {
        Collections.sort(allOrders, Comparator.comparing(Order::getPickupDate));
    }

    /**
     * Sorts all the orders in the system by order number (lowest to highest).
     */
    @Override
    public void sortByNumber() {
        Collections.sort(allOrders, Comparator.comparing(Order::getOrderNumber));
    }

    /**
     * Sorts all the orders in the system by customer name (first name, alphabetically).
     */
    @Override
    public void sortByName() {
        Collections.sort(allOrders, Comparator.comparing(Order::getName));
    }

    /**
     * Sorts all the orders in the system by order cost (highest to lowest).
     */
    @Override
    public void sortByTotalCost() {
        Collections.sort(allOrders, Collections.reverseOrder(Comparator.comparing(Order::getTotalCost)));
    }

}

