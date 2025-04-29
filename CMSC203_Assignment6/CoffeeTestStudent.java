import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * My JUnit test for Coffee class
 */
public class CoffeeTestStudent {
    Coffee c1, c2, c3, c4;

    @Before
    public void setUp() throws Exception {
        c1 = new Coffee("Regular Coffee", Size.SMALL, false, false);
        c2 = new Coffee("Espresso", Size.MEDIUM, true, false);
        c3 = new Coffee("Caramel Macchiato", Size.LARGE, true, true);
        c4 = new Coffee("Regular Coffee", Size.SMALL, false, false);
    }

    @After
    public void tearDown() throws Exception {
        c1 = c2 = c3 = c4 = null;
    }

    @Test
    public void testCoffee() {
        assertNotNull(c1);
        assertNotNull(c2);
        assertNotNull(c3);
        
        assertEquals("Regular Coffee", c1.getName());
        assertEquals(Size.SMALL, c1.getSize());
        assertEquals(Type.COFFEE, c1.getType());
        assertFalse(c1.isExtraShot());
        assertFalse(c1.isExtraSyrup());
        
        assertEquals("Espresso", c2.getName());
        assertEquals(Size.MEDIUM, c2.getSize());
        assertTrue(c2.isExtraShot());
        assertFalse(c2.isExtraSyrup());
    }

    @Test
    public void testCalcPrice() {
        // Small coffee, no extras: BASE_PRICE = 2.0
        assertEquals(2.0, c1.calcPrice(), 0.001);
        
        // Medium coffee with extra shot: BASE_PRICE + SIZE_PRICE + EXTRA_SHOT = 2.0 + 0.5 + 0.5 = 3.0
        assertEquals(3.0, c2.calcPrice(), 0.001);
        
        // Large coffee with extra shot and syrup: BASE_PRICE + 2*SIZE_PRICE + EXTRA_SHOT + EXTRA_SYRUP = 2.0 + 1.0 + 0.5 + 0.5 = 4.0
        assertEquals(4.0, c3.calcPrice(), 0.001);
    }

    @Test
    public void testToString() {
        assertTrue(c1.toString().contains("Regular Coffee"));
        assertTrue(c1.toString().contains("SMALL"));
        assertTrue(c1.toString().contains("No extra shot"));
        assertTrue(c1.toString().contains("No extra syrup"));
        
        assertTrue(c3.toString().contains("Caramel Macchiato"));
        assertTrue(c3.toString().contains("LARGE"));
        assertTrue(c3.toString().contains("Extra shot"));
        assertTrue(c3.toString().contains("Extra syrup"));
    }

    @Test
    public void testEquals() {
        assertTrue(c1.equals(c4)); // Same name, size, and extras
        assertFalse(c1.equals(c2)); // Different name, size, and extras
        
        Coffee c5 = new Coffee("Regular Coffee", Size.SMALL, true, false);
        assertFalse(c1.equals(c5)); // Same name and size, different extras
        
        assertFalse(c1.equals(null));
        assertFalse(c1.equals(new Alcohol("Wine", Size.SMALL, false)));
    }
}