import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * My JUnit test for Order class
 */
public class OrderTestStudent {
    Order o1, o2, o3;
    Customer c1, c2;

    @Before
    public void setUp() throws Exception {
        c1 = new Customer("John", 25);
        c2 = new Customer("Mary", 17);
        
        o1 = new Order(10, Day.MONDAY, c1);
        o2 = new Order(20, Day.SATURDAY, c2);
        o3 = new Order(15, Day.SUNDAY, c1);
    }

    @After
    public void tearDown() throws Exception {
        o1 = o2 = o3 = null;
        c1 = c2 = null;
    }

    @Test
    public void testOrder() {
        assertNotNull(o1);
        assertNotNull(o2);
        
        assertEquals(10, o1.getOrderTime());
        assertEquals(Day.MONDAY, o1.getOrderDay());
        assertEquals("John", o1.getCustomer().getName());
        assertEquals(25, o1.getCustomer().getAge());
        
        assertEquals(20, o2.getOrderTime());
        assertEquals(Day.SATURDAY, o2.getOrderDay());
        assertEquals("Mary", o2.getCustomer().getName());
        assertEquals(17, o2.getCustomer().getAge());
    }

    @Test
    public void testIsWeekend() {
        assertFalse(o1.isWeekend()); // Monday
        assertTrue(o2.isWeekend()); // Saturday
        assertTrue(o3.isWeekend()); // Sunday
    }

    @Test
    public void testAddNewBeverage() {
        // Initially empty
        assertEquals(0, o1.getTotalItems());
        
        // Add coffee
        o1.addNewBeverage("Regular Coffee", Size.SMALL, false, false);
        assertEquals(1, o1.getTotalItems());
        assertEquals(Type.COFFEE, o1.getBeverage(0).getType());
        
        // Add alcohol
        o1.addNewBeverage("Wine", Size.MEDIUM);
        assertEquals(2, o1.getTotalItems());
        assertEquals(Type.ALCOHOL, o1.getBeverage(1).getType());
        
        // Add smoothie
        o1.addNewBeverage("Berry Blast", Size.LARGE, 3, true);
        assertEquals(3, o1.getTotalItems());
        assertEquals(Type.SMOOTHIE, o1.getBeverage(2).getType());
    }

    @Test
    public void testGetBeverage() {
        o1.addNewBeverage("Regular Coffee", Size.SMALL, false, false);
        o1.addNewBeverage("Wine", Size.MEDIUM);
        
        assertNotNull(o1.getBeverage(0));
        assertNotNull(o1.getBeverage(1));
        assertNull(o1.getBeverage(2)); // Index out of bounds
        
        assertEquals("Regular Coffee", o1.getBeverage(0).getName());
        assertEquals(Size.SMALL, o1.getBeverage(0).getSize());
        
        assertEquals("Wine", o1.getBeverage(1).getName());
        assertEquals(Size.MEDIUM, o1.getBeverage(1).getSize());
    }

    @Test
    public void testCalcOrderTotal() {
        // Empty order
        assertEquals(0.0, o1.calcOrderTotal(), 0.001);
        
        // Add beverages
        o1.addNewBeverage("Regular Coffee", Size.SMALL, false, false); // 2.0
        o1.addNewBeverage("Wine", Size.MEDIUM); // 2.5 (weekday)
        o1.addNewBeverage("Berry Blast", Size.LARGE, 3, true); // 6.0
        
        // Total: 2.0 + 2.5 + 6.0 = 10.5
        assertEquals(10.5, o1.calcOrderTotal(), 0.001);
    }

    @Test
    public void testFindNumOfBeveType() {
        // Empty order
        assertEquals(0, o1.findNumOfBeveType(Type.COFFEE));
        
        // Add beverages
        o1.addNewBeverage("Regular Coffee", Size.SMALL, false, false);
        o1.addNewBeverage("Espresso", Size.MEDIUM, true, false);
        o1.addNewBeverage("Wine", Size.MEDIUM);
        o1.addNewBeverage("Berry Blast", Size.LARGE, 3, true);
        
        // Count by type
        assertEquals(2, o1.findNumOfBeveType(Type.COFFEE));
        assertEquals(1, o1.findNumOfBeveType(Type.ALCOHOL));
        assertEquals(1, o1.findNumOfBeveType(Type.SMOOTHIE));
    }

    @Test
    public void testCompareTo() {
        // Get the order numbers
        int o1No = o1.getOrderNo();
        int o2No = o2.getOrderNo();
        
        // Create a new order with same order number as o1
        int compareResult;
        if (o1No < o2No) {
            compareResult = -1;
        } else if (o1No > o2No) {
            compareResult = 1;
        } else {
            compareResult = 0;
        }
        
        assertEquals(compareResult, o1.compareTo(o2));
    }

    @Test
    public void testToString() {
        o1.addNewBeverage("Regular Coffee", Size.SMALL, false, false);
        
        String str = o1.toString();
        assertTrue(str.contains("Order No: " + o1.getOrderNo()));
        assertTrue(str.contains("Time: 10"));
        assertTrue(str.contains("Day: MONDAY"));
        assertTrue(str.contains("Customer: John"));
        assertTrue(str.contains("Age: 25"));
        assertTrue(str.contains("Regular Coffee"));
    }

    @Test
    public void testCustomerDeepCopy() {
        Customer originalCustomer = o1.getCustomer();
        assertEquals("John", originalCustomer.getName());
        
        // Modify the returned customer
        originalCustomer.setName("Changed Name");
        
        // The customer in the order should remain unchanged
        assertEquals("John", o1.getCustomer().getName());
    }
}