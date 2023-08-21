// Import statements
import java.util.InputMismatchException;
import java.util.Scanner;

// Point of Sale System controller.
public class POSController {

    // Attributes for every controller.
    // POSModel is the controller's model.
    // POSView is the controller's view.
    private IPOSModel model;
    private POSView view;
    private int count;

    // Constructor for a controller.
    // Must have a model and view upon initiation.
    public POSController(IPOSModel model, POSView view){
        this.model = model;
        this.view = view;
        this.count = 1;
    }

    /**
     * This is the text-based user interface for the program.
     */
    public void runProgram() {

        // "On switch" for the program.
        boolean programOn = true;

        // Creates buffer objects to hold the input while we decide if it's valid.
        String buffer1 = null;
        String buffer2 = null;
        String buffer3 = null;

        // While program is on, run this continuously.
        while (programOn) {

            // Prints the main screen user message.
            view.printUserMessage();

            // Creates a scanner object to take in input.
            Scanner input = new Scanner(System.in);

            // Try to take input from the user and turn it into an Integer.
            try {
                buffer1 = input.next();
                Integer choice1 = Integer.valueOf(buffer1);

                // If the input is an integer but out of range, print this message and start over.
                if  (choice1 > 5 || choice1 < 0) {
                    System.out.println("ERROR: You must enter an integer between 0 and 5.");
                    continue;
                }

                // If the input is valid, take their choice and perform their chosen action.
                switch (choice1) {

                    // Creates an order.
                    case 1:
                        try {
                            System.out.println("Enter customer name: ");
                            input.nextLine();
                            String name = input.next();
                            System.out.println("Enter customer phone number: ");
                            input.nextLine();
                            String phone = input.next();
                            System.out.println("Enter pickup year: ");
                            int year = input.nextInt();
                            System.out.println("Enter pickup month: ");
                            int month = input.nextInt();
                            System.out.println("Enter pickup day: ");
                            int day = input.nextInt();
                            System.out.println("Enter number of cakes to order: ");
                            int cakes = input.nextInt();
                            System.out.println("Enter number of cookies to order: ");
                            int cookies = input.nextInt();
                            System.out.println("Enter number of cupcakes to order: ");
                            int cupcakes = input.nextInt();
                            System.out.println("Enter number of muffins to order: ");
                            int muffins = input.nextInt();
                            System.out.println("Enter number of pies to order: ");
                            int pies = input.nextInt();
                            placeOrder(name, phone, year, month, day, cakes, cookies, cupcakes, muffins, pies);
                            System.out.println("Order placed.");
                            //findOrderByName(name);
                            System.out.print(model.lookupOrderName(name).toString());
                            continue;
                        }
                        catch (InputMismatchException ime) {
                            System.out.println("ERROR: Invalid order number.");
                            continue;
                        }

                    // Deletes and order.
                    case 2:
                        System.out.println("Enter order number: ");
                        int order = input.nextInt();
                        removeOrder(order);
                        continue;

                    // Open search menu.
                    case 3:

                        // Prints the search screen user message.
                        view.printSearchMessage();

                        // Try to take input from the user and turn it into an Integer.
                        try {
                            buffer2 = input.next();
                            Integer choice2 = Integer.valueOf(buffer2);

                            // If the input is an integer but out of range, print this message and start over.
                            if  (choice2 > 4 || choice2 < 0) {
                                System.out.println("ERROR: You must enter an integer between 0 and 5.");
                                continue;
                            }

                            // If the input is valid, take their choice and perform their chosen action.
                            switch (choice2) {

                                // Search by order number.
                                case 1:
                                    System.out.println("Enter order number: ");
                                    try {
                                        int order2 = input.nextInt();
                                        findOrderByNumber(order2);
                                        continue;
                                    }
                                    catch (InputMismatchException ime) {
                                        System.out.println("ERROR: Invalid order number.");
                                        continue;
                                    }

                                // Search by customer name.
                                case 2:
                                    System.out.println("Enter customer name: ");
                                    input.nextLine();
                                    String name2 = input.next();
                                    findOrderByName(name2);
                                    continue;

                                // Search by customer phone number.
                                case 3:
                                    System.out.println("Enter customer phone number: ");
                                    input.nextLine();
                                    String phone2 = input.next();
                                    findOrderByPhoneNumber(phone2);
                                    continue;

                                // Search by pickup date.
                                case 4:
                                    try {
                                        System.out.println("Enter pickup year: ");
                                        int year2 = input.nextInt();
                                        System.out.println("Enter pickup year: ");
                                        int month2 = input.nextInt();
                                        System.out.println("Enter pickup year: ");
                                        int day2 = input.nextInt();
                                        findOrderByDate(year2, month2, day2);
                                        continue;
                                    }
                                    catch (InputMismatchException ime) {
                                        System.out.println("ERROR: Invalid input.");
                                        continue;
                                    }

                                // Go back.
                                case 0:
                                    continue;
                            }
                        }

                        // If the number cannot be made into an integer, print this message and start over.
                        catch (NumberFormatException nfe) {
                            System.out.println("ERROR: Your input must be an integer.");
                            continue;
                        }

                    // Open sort menu.
                    case 4:

                        // Prints the sort screen user message.
                        view.printSortMessage();

                        // Try to take input from the user and turn it into an Integer.
                        try {
                            buffer3 = input.next();
                            Integer choice3 = Integer.valueOf(buffer3);

                            // If the input is an integer but out of range, print this message and start over.
                            if  (choice3 > 4 || choice3 < 0) {
                                System.out.println("ERROR: You must enter an integer between 0 and 5.");
                                continue;
                            }

                            // If the input is valid, take their choice and perform their chosen action.
                            switch (choice3) {

                                // Sort by order number.
                                case 1:
                                    updateOrderByNumber();
                                    continue;

                                // Sort by customer name.
                                case 2:
                                    updateOrderByName();
                                    continue;

                                // Sort by order cost.
                                case 3:
                                    updateOrderByCost();
                                    continue;

                                // Sort by pickup date.
                                case 4:
                                    updateOrderByDate();
                                    continue;

                                // Go back.
                                case 0:
                                    continue;
                            }
                        }

                        // If the number cannot be made into an integer, print this message and start over.
                        catch (NumberFormatException nfe) {
                            System.out.println("ERROR: Your input must be an integer.");
                            continue;
                        }

                    // Prints a summary of all the orders in the system.
                    case 5:
                        System.out.println("Summary of all orders:");
                        updateOrderAverage();
                        updateTotalProfit();
                        continue;

                    // Exits the program.
                    case 0:
                        System.out.println("Goodbye! Program closed.");
                        programOn = false;
                        break;
                }
            }

            // If the number cannot be made into an integer, print this message and start over.
            catch (NumberFormatException nfe) {
                System.out.println("ERROR: Your input must be an integer.");
            }
        }
    }

    /**
     * Places an order in the POS system.
     * @param N (string) is the name of the customer.
     * @param PN (string) is the phone number for the customer.
     * @param year (int) is year for the order pickup date.
     * @param month (int) is month for the order pickup date.
     * @param day (int) is day for the order pickup date.
     * @param cakeNumber (int) is the number of cakes the customer ordered.
     * @param cookieNumber (int) is the number of cookies the customer ordered.
     * @param cupcakeNumber (int) is the number of cupcakes the customer ordered.
     * @param muffinNumber (int) is the number of muffins the customer ordered.
     * @param pieNumber (int) is the number of pies the customer ordered.
     */
    public void placeOrder(String N, String PN, int year, int month, int day, int cakeNumber, int cookieNumber, int cupcakeNumber, int muffinNumber, int pieNumber) {
        if (cakeNumber == 0 && cookieNumber == 0 && cupcakeNumber == 0 && muffinNumber == 0 && pieNumber == 0) {
            throw new IllegalArgumentException("Cannot place an empty order");
        }
        model.newOrder(N, PN, year, month, day);
        int size = count;
        model.lookupOrderNumber(size).addCake(cakeNumber);
        model.lookupOrderNumber(size).addCookie(cookieNumber);
        model.lookupOrderNumber(size).addCupcake(cupcakeNumber);
        model.lookupOrderNumber(size).addMuffin(muffinNumber);
        model.lookupOrderNumber(size).addPie(pieNumber);
        count++;
    }

    public void removeOrder(int orderNumber) {
        view.printRemoveOrder(orderNumber);
        model.removeOrder(orderNumber);
    }

    /**
     * Displays all orders in the system.
     */
    public void updateAllOrdersView() {
        view.printAllOrders(model.streamAllOrders());
    }

    /**
     * Displays an order that matches the given order number (if found).
     * @param number (int) to be searched.
     */
    public void findOrderByNumber(int number) {
        view.printLookupNumber(model.lookupOrderNumber(number), number);
    }

    /**
     * Displays an order that matches the given order name (if found).
     * @param name (String) to be searched.
     */
    public void findOrderByName(String name) {
        view.printLookupName(model.lookupOrderName(name), name);
    }

    /**
     * Displays an order that matches the given order phone number (if found).
     * @param phoneNumber (String) to be searched.
     */
    public void findOrderByPhoneNumber(String phoneNumber) {view.printLookupPhoneNumber(model.lookupOrderPhoneNumber(phoneNumber), phoneNumber);}

    /**
     * Displays any order(s) that matches the given pickup date.
     * @param year (int) to be searched.
     * @param month (int) to be searched.
     * @param day (int) to be searched.
     */
    public void findOrderByDate(int year, int month, int day) {
        view.printLookupDate(model.lookupOrderDate(year, month, day), year, month, day);
    }

    /**
     * Displays the total profit for all orders in the system.
     */
    public void updateTotalProfit() {
        view.printTotalProfit(model.getProfit());
    }

    /**
     * Displays the average cost for all orders in the system.
     */
    public void updateOrderAverage() {
        view.printOrderAverage(model.getAverageOrder());
    }

    /**
     * Displays the orders sorted by date.
     */
    public void updateOrderByDate() {
        model.sortByDate();
        view.printAllOrders(model.streamAllOrders());
    }

    /**
     * Displays the orders sorted by name.
     */
    public void updateOrderByName() {
        model.sortByName();
        view.printAllOrders(model.streamAllOrders());
    }

    /**
     * Displays the orders sorted by order number.
     */
    public void updateOrderByNumber() {
        model.sortByNumber();
        view.printAllOrders(model.streamAllOrders());
    }

    /**
     * Displays the orders sorted by cost.
     */
    public void updateOrderByCost() {
        model.sortByTotalCost();
        view.printAllOrders(model.streamAllOrders());
    }

}
