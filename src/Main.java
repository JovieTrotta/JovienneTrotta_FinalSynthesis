/**
 This is the Driver file.
 Here I demonstrate how the program works.
 */
public class Main {
    public static void main(String[] args) {

        // Creates a controller which operates the POS system.
        POSController controller = new POSController(new POSModel(), new POSView());

        /**
         * Run the program with text based UI.
         * Orders are created one at a time in the UI.
         * This is the data set we will be working with.
         */
        controller.runProgram();

        /**
         * Run the program manually.
         * Creates a bunch of orders.
         * This is the data set we will be working with.
         */
        //controller.placeOrder("Jovienne Trotta", "9148390603",2023, 10, 31, 0, 10, 4, 0, 0);
        //controller.placeOrder("Anthony Licari", "2074782148", 2023,12, 8, 1, 0, 0, 0, 1);
        //controller.placeOrder("Lauren Turner", "5108566025", 2023, 11, 26, 0, 0, 0, 12, 0);
        //controller.placeOrder("Vedika Bandhi", "7328501540",2023, 9, 16, 0, 1, 0, 0, 3);
        //controller.placeOrder("Allie Young", "9144799919", 2023,10, 31, 0, 0, 24, 0, 0);
        //controller.placeOrder("Matt Lombardi", "9144060584", 2023,9, 1, 0, 2, 0, 0, 0);
        //controller.placeOrder("Jamie Jeppson", "2078379810", 2023,9, 1, 0, 0, 5, 0, 0);
        //controller.placeOrder("Katie Goodwin", "9785022961", 2023,11, 26, 0, 0, 6, 6, 0);
        //controller.placeOrder("Chloe Minagawa", "2063873523", 2023,9, 1, 1, 0, 0, 0, 0);
        //controller.placeOrder("Rory Mallow", "7742770605", 2023,11, 20, 0, 0, 0, 0, 1);

        // Shows orders by pickup date.
        //controller.updateOrderByDate();

        // Shows orders by order cost.
        //controller.updateOrderByCost();

        // Shows orders by customer name.
        //controller.updateOrderByName();

        // Shows orders by order number.
        //controller.updateOrderByNumber();

        // Searches for an order number.
        //controller.findOrderByNumber(5);

        // Searches for a customer name.
        //controller.findOrderByName("Anthony Licari");

        // Searches for a customer phone number.
        //controller.findOrderByPhoneNumber("9148390603");

        // Searches for orders with a specific pickup date.
        //controller.findOrderByDate(2023, 9, 1);

        // Gets the total profit for all orders in the system.
        //controller.updateTotalProfit();

        // Gets the average order cost for all orders in the system.
        //controller.updateOrderAverage();

        // Removes order number five.
        //controller.removeOrder(5);

        // Reprints the total list of orders.
        //controller.updateOrderByNumber();

        // Gets the total profit for all orders in the system.
        //controller.updateTotalProfit();

        // Gets the average order cost for all orders in the system.
        //controller.updateOrderAverage();

        // Removes order number eight.
        //controller.removeOrder(8);

        // Reprints the total list of orders.
        //controller.updateOrderByNumber();

        // Gets the total profit for all orders in the system.
        //controller.updateTotalProfit();

        // Gets the average order cost for all orders in the system.
        //controller.updateOrderAverage();

        // Creates another new order.
        //controller.placeOrder("JJ Brennan", "9143307288",2023, 11, 2, 1, 0, 0, 1, 0);

        // Reprints the total list of orders.
        //controller.updateOrderByNumber();

        // Gets the total profit for all orders in the system.
        //controller.updateTotalProfit();

        // Gets the average order cost for all orders in the system.
        //controller.updateOrderAverage();
    }
}