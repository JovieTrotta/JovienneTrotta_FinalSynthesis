// Import statements.
import org.junit.Before;
import org.junit.Test;
import java.util.stream.Collectors;
import static org.junit.Assert.assertEquals;

/**
 * This is a test class for the POSModel class.
 */
public class POSModelTest {
    private final POSModel model = new POSModel();

    /**
     * Adds some orders to the model to test.
     */
    @Before
    public void setup(){
        model.newOrder("Zamboni Jones", "8907654321", 2000, 12, 31);
        model.newOrder("Pepe Silvia", "1234567890", 2000, 1, 1);
    }

    /**
     * Tests getOrderListSize method.
     */
    @Test
    public void testGetOrderListSize() {
        assertEquals(2, model.getOrderListSize());
    }

    /**
     * Tests newOrder method.
     */
    @Test
    public void testNewOrder() {
        assertEquals(2, model.getOrderListSize());
        model.newOrder("Test Three", "0000000000", 1993, 6, 26);
        assertEquals(3, model.getOrderListSize());
    }

    /**
     * Tests removeOrder method.
     */
    @Test
    public void testRemoveOrder() {
        assertEquals(2, model.getOrderListSize());
        model.removeOrder(2);
        assertEquals(1, model.getOrderListSize());
    }

    /**
     * Tests streamAllOrders method.
     */
    @Test
    public void testStreamAllOrders() {
        assertEquals("Order Number: 1" + "\n" +
                "Customer Name: Zamboni Jones" + "\n" +
                "Customer Phone Number: (890)-765-4321" + "\n" +
                "Pickup Date: 2000-12-31" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n" +
                "Order Number: 2" + "\n" +
                "Customer Name: Pepe Silvia" + "\n" +
                "Customer Phone Number: (123)-456-7890" + "\n" +
                "Pickup Date: 2000-01-01" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", model.streamAllOrders());
    }

    /**
     * Tests lookupOrderNumber method.
     */
    @Test
    public void testLookupOrderNumber() {
        assertEquals("Order Number: 1" + "\n" +
                "Customer Name: Zamboni Jones" + "\n" +
                "Customer Phone Number: (890)-765-4321" + "\n" +
                "Pickup Date: 2000-12-31" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", model.lookupOrderNumber(1).toString());
        assertEquals("Order Number: 2" + "\n" +
                "Customer Name: Pepe Silvia" + "\n" +
                "Customer Phone Number: (123)-456-7890" + "\n" +
                "Pickup Date: 2000-01-01" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", model.lookupOrderNumber(2).toString());
    }

    /**
     * Tests lookupOrderName method.
     */
    @Test
    public void testLookupOrderName() {
        assertEquals("Order Number: 1" + "\n" +
                "Customer Name: Zamboni Jones" + "\n" +
                "Customer Phone Number: (890)-765-4321" + "\n" +
                "Pickup Date: 2000-12-31" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", model.lookupOrderName("Zamboni Jones").toString());
        assertEquals("Order Number: 2" + "\n" +
                "Customer Name: Pepe Silvia" + "\n" +
                "Customer Phone Number: (123)-456-7890" + "\n" +
                "Pickup Date: 2000-01-01" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", model.lookupOrderName("Pepe Silvia").toString());
    }

    /**
     * Tests lookupOrderPhoneNumber method.
     */
    @Test
    public void testLookupOrderPhoneNumber() {
        assertEquals("Order Number: 1" + "\n" +
                "Customer Name: Zamboni Jones" + "\n" +
                "Customer Phone Number: (890)-765-4321" + "\n" +
                "Pickup Date: 2000-12-31" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", model.lookupOrderPhoneNumber("8907654321").toString());
        assertEquals("Order Number: 2" + "\n" +
                "Customer Name: Pepe Silvia" + "\n" +
                "Customer Phone Number: (123)-456-7890" + "\n" +
                "Pickup Date: 2000-01-01" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", model.lookupOrderPhoneNumber("1234567890").toString());
    }

    /**
     * Tests lookupOrderDate method.
     */
    @Test
    public void testLookupOrderDate() {
        assertEquals("Order Number: 1" + "\n" +
                "Customer Name: Zamboni Jones" + "\n" +
                "Customer Phone Number: (890)-765-4321" + "\n" +
                "Pickup Date: 2000-12-31" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", model.lookupOrderDate(2000, 12, 31).stream().map(e -> e.toString()).collect(Collectors.joining()));
        assertEquals("Order Number: 2" + "\n" +
                "Customer Name: Pepe Silvia" + "\n" +
                "Customer Phone Number: (123)-456-7890" + "\n" +
                "Pickup Date: 2000-01-01" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", model.lookupOrderDate(2000, 1, 1).stream().map(e -> e.toString()).collect(Collectors.joining()));
    }

    /**
     * Tests getProfit method.
     */
    @Test
    public void testGetProfit() {
        assertEquals(0.0, model.getProfit(), 0.01);
    }

    /**
     * Tests getAverageOrder method.
     */
    @Test
    public void testGetAverageOrder() {
        assertEquals(0.0, model.getAverageOrder(), 0.01);
    }

    /**
     * Tests sortByDate method.
     */
    @Test
    public void testSortByDate() {
        model.sortByDate();
        assertEquals("Order Number: 2" + "\n" +
                "Customer Name: Pepe Silvia" + "\n" +
                "Customer Phone Number: (123)-456-7890" + "\n" +
                "Pickup Date: 2000-01-01" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n" +
                "Order Number: 1" + "\n" +
                "Customer Name: Zamboni Jones" + "\n" +
                "Customer Phone Number: (890)-765-4321" + "\n" +
                "Pickup Date: 2000-12-31" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", model.streamAllOrders());
    }

    /**
     * Tests sortByNumber method.
     */
    @Test
    public void testSortByNumber() {
        model.sortByNumber();
        assertEquals("Order Number: 1" + "\n" +
                "Customer Name: Zamboni Jones" + "\n" +
                "Customer Phone Number: (890)-765-4321" + "\n" +
                "Pickup Date: 2000-12-31" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n" +
                "Order Number: 2" + "\n" +
                "Customer Name: Pepe Silvia" + "\n" +
                "Customer Phone Number: (123)-456-7890" + "\n" +
                "Pickup Date: 2000-01-01" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", model.streamAllOrders());
    }

    /**
     * Tests sortByName method.
     */
    @Test
    public void testSortByName() {
        model.sortByName();
        assertEquals("Order Number: 2" + "\n" +
                 "Customer Name: Pepe Silvia" + "\n" +
                 "Customer Phone Number: (123)-456-7890" + "\n" +
                 "Pickup Date: 2000-01-01" + "\n" +
                 "Detail: []" + "\n" +
                 "Total Cost: $0.00" + "\n" +
                "Order Number: 1" + "\n" +
                "Customer Name: Zamboni Jones" + "\n" +
                "Customer Phone Number: (890)-765-4321" + "\n" +
                "Pickup Date: 2000-12-31" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", model.streamAllOrders());
    }

    /**
     * Tests sortByTotalCost method.
     */
    @Test
    public void testSortByTotalCost() {
        model.sortByName();
        assertEquals("Order Number: 2" + "\n" +
                "Customer Name: Pepe Silvia" + "\n" +
                "Customer Phone Number: (123)-456-7890" + "\n" +
                "Pickup Date: 2000-01-01" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n" +
                "Order Number: 1" + "\n" +
                "Customer Name: Zamboni Jones" + "\n" +
                "Customer Phone Number: (890)-765-4321" + "\n" +
                "Pickup Date: 2000-12-31" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", model.streamAllOrders());
    }
}
