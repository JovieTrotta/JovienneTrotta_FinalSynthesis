// Import statements.
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This is a test class for the Sweets enum.
 */
public class SweetsTest {
    private Sweets cake;
    private Sweets cookie;
    private Sweets cupcake;
    private Sweets muffin;
    private Sweets pie;

    /**
     * Sets up enum variables to test.
     */
    @Before
    public void setup() {
        this.cake = Sweets.CAKE;
        this.cookie = Sweets.COOKIE;
        this.cupcake = Sweets.CUPCAKE;
        this.muffin = Sweets.MUFFIN;
        this.pie = Sweets.PIE;
    }

    /**
     * Tests each enum variables getPrice method.
     */
    @Test
    public void testGetPrice() {
        assertEquals(24.99, cake.getPrice(), 0.01);
        assertEquals(2.99, cookie.getPrice(), 0.01);
        assertEquals(4.99, cupcake.getPrice(), 0.01);
        assertEquals(2.99, muffin.getPrice(), 0.01);
        assertEquals(14.99, pie.getPrice(), 0.01);
    }

    /**
     * Tests each enum variables get toString method.
     */
    @Test
    public void testToString() {
        assertEquals("Cake 24.99", cake.toString());
        assertEquals("Cookie 2.99", cookie.toString());
        assertEquals("Cupcake 4.99", cupcake.toString());
        assertEquals("Muffin 2.99", muffin.toString());
        assertEquals("Pie 14.99", pie.toString());
    }

}
