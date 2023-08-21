// Import statements.
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

/**
 * Creates a mock for the model that logs the input.
 */
class Mock implements IPOSModel {
    private StringBuilder log;

    // Log is where the input will be stored.
    public Mock() {
        log = new StringBuilder();
    }

    // Returns the log as a string.
    public String getLog() {
        return log.toString();
    }

    // Logs input from placeOrder.
    @Override
    public void newOrder(String N, String PN, int year, int month, int day) {
        log.append(N + " ");
        log.append(PN + " ");
        log.append(year + " ");
        log.append(month + " ");
        log.append(day + " ");
    }

    @Override
    public void removeOrder(int orderNumber) {
        log.append(orderNumber);
    }

    // No parameter input from controller so not tested here.
    @Override
    public int getOrderListSize() {
        return 0;
    }

    // No parameter input from controller so not tested here.
    @Override
    public String streamAllOrders() {
        return null;
    }

    // Logs input from findOrderByNumber.
    @Override
    public Order lookupOrderNumber(int orderNumber) {
        log.append(orderNumber);

        return new Order("TEST", "0000000000", 2023, 1, 1);
    }

    // Logs input from findOrderByName.
    @Override
    public Order lookupOrderName(String name) {
        log.append(name);

        return new Order("TEST", "0000000000", 2023, 1, 1);
    }

    // Logs input from findOrderByPhoneNumber.
    @Override
    public Order lookupOrderPhoneNumber(String phoneNumber) {
        log.append(phoneNumber);

        return new Order("TEST", "0000000000", 2023, 1, 1);
    }

    // Logs input from findOrderByDate.
    @Override
    public ArrayList lookupOrderDate(int year, int month, int day) {
        log.append(year);
        log.append(month);
        log.append(day);

        return new ArrayList();
    }

    // No parameter input from controller so not tested here.
    @Override
    public double getProfit() {
        return 0.0;
    }

    // No parameter input from controller so not tested here.
    @Override
    public double getAverageOrder() {
        return 0.0;
    }

    // No parameter input from controller so not tested here.
    @Override
    public void sortByDate() {}

    // No parameter input from controller so not tested here.
    @Override
    public void sortByNumber() {}

    // No parameter input from controller so not tested here.
    @Override
    public void sortByName() {}

    // No parameter input from controller so not tested here.
    @Override
    public void sortByTotalCost() {}
}

/**
 * This is a test class for the POSController class.
 */
public class POSControllerTest {

    /**
     * Tests placeOrder method.
     */
    @Test
    public void testPlaceOrder() {
        Mock model = new Mock();
        POSView view = new POSView();
        POSController controller = new POSController(model, view);
        controller.placeOrder("Jovienne Trotta", "9148390603",2023, 10, 31, 1, 1, 1, 1, 1);
        assertEquals("Jovienne Trotta 9148390603 2023 10 31 11111", model.getLog());
    }

    /**
     * Tests removeOrder method.
     */
    @Test
    public void testRemoveOrder() {
        Mock model = new Mock();
        POSView view = new POSView();
        POSController controller = new POSController(model, view);
        controller.removeOrder(1);
        assertEquals("1", model.getLog());
    }

    /**
     * Tests findOrderByNumber method.
     */
    @Test
    public void testFindOrderByNumber() {
        Mock model = new Mock();
        POSView view = new POSView();
        POSController controller = new POSController(model, view);
        controller.findOrderByNumber(10);
        assertEquals("10", model.getLog());
        assertEquals("Order Number: 2" + "\n" +
                "Customer Name: TEST" + "\n" +
                "Customer Phone Number: (000)-000-0000" + "\n" +
                "Pickup Date: 2023-01-01" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", model.lookupOrderNumber(10).toString());
    }

    /**
     * Tests findOrderByName method.
     */
    @Test
    public void testFindOrderByName() {
        Mock model = new Mock();
        POSView view = new POSView();
        POSController controller = new POSController(model, view);
        controller.findOrderByName("TEST STRING");
        assertEquals("TEST STRING", model.getLog());
        assertEquals("Order Number: 2" + "\n" +
                "Customer Name: TEST" + "\n" +
                "Customer Phone Number: (000)-000-0000" + "\n" +
                "Pickup Date: 2023-01-01" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", model.lookupOrderName("-").toString());
    }

    /**
     * Tests findOrderByPhoneNumber method.
     */
    @Test
    public void testFindOrderByPhoneNumber() {
        Mock model = new Mock();
        POSView view = new POSView();
        POSController controller = new POSController(model, view);
        controller.findOrderByPhoneNumber("123456");
        assertEquals("123456", model.getLog());
        assertEquals("Order Number: 2" + "\n" +
                "Customer Name: TEST" + "\n" +
                "Customer Phone Number: (000)-000-0000" + "\n" +
                "Pickup Date: 2023-01-01" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", model.lookupOrderPhoneNumber("-").toString());
    }

    /**
     * Tests findOrderByDate method.
     */
    @Test
    public void testFindOrderByDate() {
        Mock model = new Mock();
        POSView view = new POSView();
        POSController controller = new POSController(model, view);
        controller.findOrderByDate(2023, 8, 13);
        assertEquals("2023813", model.getLog());
        assertEquals(new ArrayList<>().toString(), model.lookupOrderDate(2023, 8, 13).toString());
    }
}
