// Import statements.
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;

/**
 * This is a test class for the Sweets enum.
 */
public class OrderTest {
    private Order testOrder1;
    private Order testOrder2;

    /**
     * Sets up enum variables to test.
     */
    @Before
    public void setup() {
        this.testOrder1 = new Order("Test One", "8907654321", 2000, 1, 1);
        this.testOrder2 = new Order("Test Two", "1234567890", 2000, 12, 31);
    }

    /**
     * Tests each orders getOrderNumber method.
     */
    @Test
    public void testGetOrderNumber() {
        assertEquals(1, testOrder1.getOrderNumber());
        assertEquals(2, testOrder2.getOrderNumber());
    }

    /**
     * Tests each orders getPhoneNumber method.
     */
    @Test
    public void testGetPhoneNumber() {
        assertEquals("8907654321", testOrder1.getPhoneNumber());
        assertEquals("1234567890", testOrder2.getPhoneNumber());
    }

    /**
     * Tests each orders getPickupDate method.
     */
    @Test
    public void testGetPickupDate() {
        assertEquals(LocalDate.of(2000,01, 01), testOrder1.getPickupDate());
        assertEquals(LocalDate.of(2000,12, 31), testOrder2.getPickupDate());
    }

    /**
     * Tests each orders getTotalCost method.
     */
    @Test
    public void testGetTotalCost() {
        assertEquals(0.0, testOrder1.getTotalCost(), 0.01);
        assertEquals(0.0, testOrder2.getTotalCost(), 0.01);
    }

    /**
     * Tests each orders toString method.
     */
    @Test
    public void testToString() {
        assertEquals("Order Number: 1" + "\n" +
                "Customer Name: Test One" + "\n" +
                "Customer Phone Number: (890)-765-4321" + "\n" +
                "Pickup Date: 2000-01-01" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", testOrder1.toString());
        assertEquals("Order Number: 2" + "\n" +
                "Customer Name: Test Two" + "\n" +
                "Customer Phone Number: (123)-456-7890" + "\n" +
                "Pickup Date: 2000-12-31" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", testOrder2.toString());
    }

    /**
     * Tests each orders addCake method.
     */
    @Test
    public void testAddCake() {
        assertEquals("Order Number: 1" + "\n" +
                "Customer Name: Test One" + "\n" +
                "Customer Phone Number: (890)-765-4321" + "\n" +
                "Pickup Date: 2000-01-01" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", testOrder1.toString());
        testOrder1.addCake(1);
        assertEquals("Order Number: 1" + "\n" +
                "Customer Name: Test One" + "\n" +
                "Customer Phone Number: (890)-765-4321" + "\n" +
                "Pickup Date: 2000-01-01" + "\n" +
                "Detail: [Cake 24.99]" + "\n" +
                "Total Cost: $24.99" + "\n", testOrder1.toString());
        assertEquals(24.99, testOrder1.getTotalCost(), 0.01);
    }

    /**
     * Tests each orders addCookie method.
     */
    @Test
    public void testAddCookie() {
        assertEquals("Order Number: 2" + "\n" +
                "Customer Name: Test Two" + "\n" +
                "Customer Phone Number: (123)-456-7890" + "\n" +
                "Pickup Date: 2000-12-31" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", testOrder2.toString());
        testOrder2.addCookie(4);
        assertEquals("Order Number: 2" + "\n" +
                "Customer Name: Test Two" + "\n" +
                "Customer Phone Number: (123)-456-7890" + "\n" +
                "Pickup Date: 2000-12-31" + "\n" +
                "Detail: [Cookie 2.99, Cookie 2.99, Cookie 2.99, Cookie 2.99]" + "\n" +
                "Total Cost: $11.96" + "\n", testOrder2.toString());
        assertEquals(11.96, testOrder2.getTotalCost(), 0.01);
        }

    /**
     * Tests each orders addCupcake method.
     */
    @Test
    public void testAddCupcake() {
        assertEquals("Order Number: 1" + "\n" +
                "Customer Name: Test One" + "\n" +
                "Customer Phone Number: (890)-765-4321" + "\n" +
                "Pickup Date: 2000-01-01" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", testOrder1.toString());
        testOrder1.addCupcake(5);
        assertEquals("Order Number: 1" + "\n" +
                "Customer Name: Test One" + "\n" +
                "Customer Phone Number: (890)-765-4321" + "\n" +
                "Pickup Date: 2000-01-01" + "\n" +
                "Detail: [Cupcake 4.99, Cupcake 4.99, Cupcake 4.99, Cupcake 4.99, Cupcake 4.99]" + "\n" +
                "Total Cost: $24.95" + "\n", testOrder1.toString());
        assertEquals(24.95, testOrder1.getTotalCost(), 0.01);
    }

    /**
     * Tests each orders addMuffin method.
     */
    @Test
    public void testAddMuffin() {
        assertEquals("Order Number: 2" + "\n" +
                "Customer Name: Test Two" + "\n" +
                "Customer Phone Number: (123)-456-7890" + "\n" +
                "Pickup Date: 2000-12-31" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", testOrder2.toString());
        testOrder2.addMuffin(2);
        assertEquals("Order Number: 2" + "\n" +
                "Customer Name: Test Two" + "\n" +
                "Customer Phone Number: (123)-456-7890" + "\n" +
                "Pickup Date: 2000-12-31" + "\n" +
                "Detail: [Muffin 2.99, Muffin 2.99]" + "\n" +
                "Total Cost: $5.98" + "\n", testOrder2.toString());
        assertEquals(5.98, testOrder2.getTotalCost(), 0.01);
    }

    /**
     * Tests each orders addPie method.
     */
    @Test
    public void testAddPie() {
        assertEquals("Order Number: 1" + "\n" +
                "Customer Name: Test One" + "\n" +
                "Customer Phone Number: (890)-765-4321" + "\n" +
                "Pickup Date: 2000-01-01" + "\n" +
                "Detail: []" + "\n" +
                "Total Cost: $0.00" + "\n", testOrder1.toString());
        testOrder1.addPie(1);
        assertEquals("Order Number: 1" + "\n" +
                "Customer Name: Test One" + "\n" +
                "Customer Phone Number: (890)-765-4321" + "\n" +
                "Pickup Date: 2000-01-01" + "\n" +
                "Detail: [Pie 14.99]" + "\n" +
                "Total Cost: $14.99" + "\n", testOrder1.toString());
        assertEquals(14.99, testOrder1.getTotalCost(), 0.01);
    }

}
