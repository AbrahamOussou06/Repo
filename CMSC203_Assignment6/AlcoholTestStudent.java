import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * My JUnit test for Alcohol class
 */
public class AlcoholTestStudent {
    Alcohol a1, a2, a3, a4;

    @Before
    public void setUp() throws Exception {
        a1 = new Alcohol("Wine", Size.SMALL, false);
        a2 = new Alcohol("Beer", Size.MEDIUM, true);
        a3 = new Alcohol("Whiskey", Size.LARGE, true);
        a4 = new Alcohol("Wine", Size.SMALL, false);
    }

    @After
    public void tearDown() throws Exception {
        a1 = a2 = a3 = a4 = null;
    }

    @Test
    public void testAlcohol() {
        assertNotNull(a1);
        assertNotNull(a2);
        assertNotNull(a3);
        
        assertEquals("Wine", a1.getName());
        assertEquals(Size.SMALL, a1.getSize());
        assertEquals(Type.ALCOHOL, a1.getType());
        assertFalse(a1.isInWeekend());
        
        assertEquals("Beer", a2.getName());
        assertEquals(Size.MEDIUM, a2.getSize());
        assertTrue(a2.isInWeekend());
    }

    @Test
    public void testCalcPrice() {
        // Small alcohol on weekday: BASE_PRICE = 2.0
        assertEquals(2.0, a1.calcPrice(), 0.001);
        
        // Medium alcohol on weekend: BASE_PRICE + SIZE_PRICE + WEEKEND_COST = 2.0 + 0.5 + 0.6 = 3.1
        assertEquals(3.1, a2.calcPrice(), 0.001);
        
        // Large alcohol on weekend: BASE_PRICE + 2*SIZE_PRICE + WEEKEND_COST = 2.0 + 1.0 + 0.6 = 3.6
        assertEquals(3.6, a3.calcPrice(), 0.001);
    }

    @Test
    public void testToString() {
        assertTrue(a1.toString().contains("Wine"));
        assertTrue(a1.toString().contains("SMALL"));
        assertTrue(a1.toString().contains("Weekday"));
        
        assertTrue(a2.toString().contains("Beer"));
        assertTrue(a2.toString().contains("MEDIUM"));
        assertTrue(a2.toString().contains("Weekend"));
    }

    @Test
    public void testEquals() {
        assertTrue(a1.equals(a4)); // Same name, size, and weekend status
        assertFalse(a1.equals(a2)); // Different name, size, and weekend status
        
        Alcohol a5 = new Alcohol("Wine", Size.SMALL, true);
        assertFalse(a1.equals(a5)); // Same name and size, different weekend status
        
        assertFalse(a1.equals(null));
        assertFalse(a1.equals(new Coffee("Coffee", Size.SMALL, false, false)));
    }
}