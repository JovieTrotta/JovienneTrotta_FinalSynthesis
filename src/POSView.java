// Import statements.
import java.time.LocalDate;
import java.util.ArrayList;

// Point of Sale System view.
public class POSView {

    /**
     * Prints a user message for the first user choice.
     */
    public void printUserMessage() {
        System.out.println("What would you like to do?");
        System.out.println("..Enter '1' to place an order.");
        System.out.println("..Enter '2' to remove an order.");
        System.out.println("..Enter '3' to search.");
        System.out.println("..Enter '4' to sort and display all orders.");
        System.out.println("..Enter '5' for an order summary.");
        System.out.println("..Enter '0' to quit.");
    }

    /**
     * Prints a user message for the search choice.
     */
    public void printSearchMessage() {
        System.out.println("What would you like to do?");
        System.out.println("....Enter '1' to search by order number.");
        System.out.println("....Enter '2' to search by customer name.");
        System.out.println("....Enter '3' to search by customer phone number.");
        System.out.println("....Enter '4' to search by pickup date.");
        System.out.println("....Enter '0' to go back.");
    }

    /**
     * Prints a user message for the sort choice.
     */
    public void printSortMessage() {
        System.out.println("What would you like to do?");
        System.out.println("....Enter '1' to display by order number.");
        System.out.println("....Enter '2' to display by customer name.");
        System.out.println("....Enter '3' to display by order cost.");
        System.out.println("....Enter '4' to display by pickup date.");
        System.out.println("....Enter '0' to go back.");
    }

    /**
     * Prints a stream (String) of all the orders in the system
     * @param orders (String) to be printed.
     */
    public void printAllOrders(String orders) {System.out.print(orders);}

    /**
     * Prints a confirmation message when an order is removed.
     * @param orderNumber (int) to be removed.
     */
    public void printRemoveOrder(int orderNumber) {System.out.print("Order removed: " + orderNumber +  "\n");}

    /**
     * Prints an order (Order) if the order number can be found.
     * @param order (Order) to be printed.
     * @param orderNumber (int) to be searched.
     */
    public void printLookupNumber(Order order, int orderNumber) {
        System.out.println("Order number searched: " + orderNumber);
        if (order != null) {
            System.out.println(order);
        } else System.out.println("Order number not found.");
    }

    /**
     * Prints an order (Order) if the customer name can be found.
     * @param order (Order) to be printed.
     * @param name (String) to be searched.
     */
    public void printLookupName(Order order, String name) {
        System.out.println("Customer name searched: " + name);
        if (order != null) {
            System.out.println(order);
        } else System.out.println("Customer name not found.");
    }

    /**
     * Prints an order (Order) if the customer phone number can be found.
     * @param order (Order) to be printed.
     * @param phoneNumber (String) to be searched.
     */
    public void printLookupPhoneNumber(Order order, String phoneNumber) {
        System.out.println("Phone number searched: " + phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3"));
        if (order != null) {
            System.out.println(order);
        } else System.out.println("Customer phone number not found.");
    }

    /**
     * Prints a list of orders due for pickup on a certain date.
     * @param orderList (ArrayList) to be printed.
     * @param year (int) to be searched.
     * @param month (int) to be searched.
     * @param day (int) to be searched.
     */
    public void printLookupDate(ArrayList<Order> orderList, int year, int month, int day) {
        System.out.println("Orders due on " + LocalDate.of(year, month, day) + ": ");
        for (int i = 0; i < orderList.size(); i++) {
            System.out.print(orderList.get(i).toString());
        }
    }

    /**
     * Prints the total profit for all orders in the system.
     * @param profit (double) to be printed.
     */
    public void printTotalProfit(Double profit) {
        String stringProfit = String.format("%.2f",profit);
        System.out.print("Total profit: $" + stringProfit + "\n");
    }

    /**
     * Prints the average cost for all orders in the system.
     * @param average (double) to be printed.
     */
    public void printOrderAverage(Double average) {
        String stringAverage = String.format("%.2f",average);
        System.out.print("Average Order Cost: $" + stringAverage + "\n");
    }

}
