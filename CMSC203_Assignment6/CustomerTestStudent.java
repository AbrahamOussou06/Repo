import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Student JUnit test for Customer class
 */
public class CustomerTestStudent {
    Customer c1, c2, c3;

    @Before
    public void setUp() throws Exception {
        c1 = new Customer("John", 25);
        c2 = new Customer("Mary", 17);
        c3 = new Customer(c1); // Copy constructor
    }

    @After
    public void tearDown() throws Exception {
        c1 = c2 = c3 = null;
    }

    @Test
    public void testCustomer() {
        assertNotNull(c1);
        assertNotNull(c2);
        
        assertEquals("John", c1.getName());
        assertEquals(25, c1.getAge());
        
        assertEquals("Mary", c2.getName());
        assertEquals(17, c2.getAge());
    }

    @Test
    public void testCopyConstructor() {
        assertNotNull(c3);
        
        // Check that values match
        assertEquals("John", c3.getName());
        assertEquals(25, c3.getAge());
        
        // Verify it's a deep copy
        c1.setName("Jonathan");
        c1.setAge(26);
        
        assertEquals("Jonathan", c1.getName());
        assertEquals(26, c1.getAge());
        
        // Original values should be preserved in copy
        assertEquals("John", c3.getName());
        assertEquals(25, c3.getAge());
    }

    @Test
    public void testToString() {
        assertTrue(c1.toString().contains("John"));
        assertTrue(c1.toString().contains("25"));
        
        assertTrue(c2.toString().contains("Mary"));
        assertTrue(c2.toString().contains("17"));
    }

    @Test
    public void testSetters() {
        c1.setName("Bob");
        c1.setAge(30);
        
        assertEquals("Bob", c1.getName());
        assertEquals(30, c1.getAge());
    }
}