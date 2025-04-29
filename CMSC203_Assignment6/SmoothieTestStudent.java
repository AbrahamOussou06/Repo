import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * My JUnit test for Smoothie class
 */
public class SmoothieTestStudent {
    Smoothie s1, s2, s3, s4;

    @Before
    public void setUp() throws Exception {
        s1 = new Smoothie("Strawberry", Size.SMALL, 1, false);
        s2 = new Smoothie("Mango", Size.MEDIUM, 2, true);
        s3 = new Smoothie("Berry Blast", Size.LARGE, 5, true);
        s4 = new Smoothie("Strawberry", Size.SMALL, 1, false);
    }

    @After
    public void tearDown() throws Exception {
        s1 = s2 = s3 = s4 = null;
    }

    @Test
    public void testSmoothie() {
        assertNotNull(s1);
        assertNotNull(s2);
        assertNotNull(s3);
        
        assertEquals("Strawberry", s1.getName());
        assertEquals(Size.SMALL, s1.getSize());
        assertEquals(Type.SMOOTHIE, s1.getType());
        assertEquals(1, s1.getNumOfFruits());
        assertFalse(s1.isAddProtein());
        
        assertEquals("Mango", s2.getName());
        assertEquals(Size.MEDIUM, s2.getSize());
        assertEquals(2, s2.getNumOfFruits());
        assertTrue(s2.isAddProtein());
    }

    @Test
    public void testCalcPrice() {
        // Small smoothie, 1 fruit, no protein: BASE_PRICE + FRUIT_COST = 2.0 + 0.5 = 2.5
        assertEquals(2.5, s1.calcPrice(), 0.001);
        
        // Medium smoothie, 2 fruits, with protein: BASE_PRICE + SIZE_PRICE + 2*FRUIT_COST + PROTEIN_COST = 2.0 + 0.5 + 1.0 + 1.5 = 5.0
        assertEquals(5.0, s2.calcPrice(), 0.001);
        
        // Large smoothie, 5 fruits, with protein: BASE_PRICE + 2*SIZE_PRICE + 5*FRUIT_COST + PROTEIN_COST = 2.0 + 1.0 + 2.5 + 1.5 = 7.0
        assertEquals(7.0, s3.calcPrice(), 0.001);
    }

    @Test
    public void testToString() {
        assertTrue(s1.toString().contains("Strawberry"));
        assertTrue(s1.toString().contains("SMALL"));
        assertTrue(s1.toString().contains("1 fruits"));
        assertTrue(s1.toString().contains("No protein"));
        
        assertTrue(s3.toString().contains("Berry Blast"));
        assertTrue(s3.toString().contains("LARGE"));
        assertTrue(s3.toString().contains("5 fruits"));
        assertTrue(s3.toString().contains("Protein"));
    }

    @Test
    public void testEquals() {
        assertTrue(s1.equals(s4)); // Same name, size, fruits, and protein
        assertFalse(s1.equals(s2)); // Different name, size, fruits, and protein
        
        Smoothie s5 = new Smoothie("Strawberry", Size.SMALL, 1, true);
        assertFalse(s1.equals(s5)); // Same name, size, and fruits, different protein
        
        assertFalse(s1.equals(null));
        assertFalse(s1.equals(new Coffee("Coffee", Size.SMALL, false, false)));
    }
}