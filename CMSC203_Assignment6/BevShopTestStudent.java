import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * My JUnit test for BevShop class
 */
public class BevShopTestStudent {
    BevShop shop;

    @Before
    public void setUp() throws Exception {
        shop = new BevShop();
    }

    @After
    public void tearDown() throws Exception {
        shop = null;
    }

    @Test
    public void testIsValidTime() {
        // Valid times
        assertTrue(shop.isValidTime(8));
        assertTrue(shop.isValidTime(15));
        assertTrue(shop.isValidTime(23));
        
        // Invalid times
        assertFalse(shop.isValidTime(7));
        assertFalse(shop.isValidTime(24));
    }

    @Test
    public void testGetMaxNumOfFruits() {
        assertEquals(5, shop.getMaxNumOfFruits());
    }

    @Test
    public void testGetMinAgeForAlcohol() {
        assertEquals(21, shop.getMinAgeForAlcohol());
    }

    @Test
    public void testIsMaxFruit() {
        // Not exceeding max
        assertFalse(shop.isMaxFruit(3));
        assertFalse(shop.isMaxFruit(5));
        
        // Exceeding max
        assertTrue(shop.isMaxFruit(6));
        assertTrue(shop.isMaxFruit(10));
    }

    @Test
    public void testGetMaxOrderForAlcohol() {
        assertEquals(3, shop.getMaxOrderForAlcohol());
    }

    @Test
    public void testAlcoholOrderCount() {
        // Start with zero
        assertEquals(0, shop.getNumOfAlcoholDrink());
        assertTrue(shop.isEligibleForMore());
        
        // Create a new order
        shop.startNewOrder(10, Day.MONDAY, "John", 25);
        
        // Add alcohol drinks
        shop.processAlcoholOrder("Wine", Size.SMALL);
        assertEquals(1, shop.getNumOfAlcoholDrink());
        assertTrue(shop.isEligibleForMore());
        
        shop.processAlcoholOrder("Beer", Size.MEDIUM);
        assertEquals(2, shop.getNumOfAlcoholDrink());
        assertTrue(shop.isEligibleForMore());
        
        shop.processAlcoholOrder("Whiskey", Size.LARGE);
        assertEquals(3, shop.getNumOfAlcoholDrink());
        assertFalse(shop.isEligibleForMore());
    }

    @Test
    public void testIsValidAge() {
        // Valid age
        assertTrue(shop.isValidAge(21));
        assertTrue(shop.isValidAge(30));
        
        // Invalid age
        assertFalse(shop.isValidAge(20));
        assertFalse(shop.isValidAge(15));
    }

    @Test
    public void testStartNewOrder() {
        // Create a new order
        shop.startNewOrder(10, Day.MONDAY, "John", 25);
        
        Order currentOrder = shop.getCurrentOrder();
        assertNotNull(currentOrder);
        assertEquals(10, currentOrder.getOrderTime());
        assertEquals(Day.MONDAY, currentOrder.getOrderDay());
        assertEquals("John", currentOrder.getCustomer().getName());
        assertEquals(25, currentOrder.getCustomer().getAge());
        
        // Create another order
        shop.startNewOrder(15, Day.SATURDAY, "Mary", 22);
        
        // Check that the current order has changed
        assertNotSame(currentOrder, shop.getCurrentOrder());
        
        // Alcohol count should reset
        assertEquals(0, shop.getNumOfAlcoholDrink());
        assertTrue(shop.isEligibleForMore());
    }

    @Test
    public void testProcessOrders() {
        // Create a new order
        shop.startNewOrder(10, Day.MONDAY, "John", 25);
        
        // Process different types of beverages
        shop.processCoffeeOrder("Regular Coffee", Size.SMALL, false, false);
        shop.processAlcoholOrder("Wine", Size.MEDIUM);
        shop.processSmoothieOrder("Berry Blast", Size.LARGE, 3, true);
        
        Order currentOrder = shop.getCurrentOrder();
        assertEquals(3, currentOrder.getTotalItems());
        assertEquals(Type.COFFEE, currentOrder.getBeverage(0).getType());
        assertEquals(Type.ALCOHOL, currentOrder.getBeverage(1).getType());
        assertEquals(Type.SMOOTHIE, currentOrder.getBeverage(2).getType());
    }

    @Test
    public void testFindOrder() {
        // No orders yet
        assertEquals(-1, shop.findOrder(12345));
        
        // Create orders
        shop.startNewOrder(10, Day.MONDAY, "John", 25);
        int orderNo1 = shop.getCurrentOrder().getOrderNo();
        
        shop.startNewOrder(15, Day.SATURDAY, "Mary", 22);
        int orderNo2 = shop.getCurrentOrder().getOrderNo();
        
        // Find orders
        int index1 = shop.findOrder(orderNo1);
        int index2 = shop.findOrder(orderNo2);
        
        assertTrue(index1 >= 0);
        assertTrue(index2 >= 0);
        assertNotEquals(index1, index2);
        
        // Try to find nonexistent order
        assertEquals(-1, shop.findOrder(99999));
    }

    @Test
    public void testTotalOrderPrice() {
        // Create orders
        shop.startNewOrder(10, Day.MONDAY, "John", 25);
        shop.processCoffeeOrder("Regular Coffee", Size.SMALL, false, false); // 2.0
        int orderNo1 = shop.getCurrentOrder().getOrderNo();
        
        shop.startNewOrder(15, Day.SATURDAY, "Mary", 22);
        shop.processSmoothieOrder("Berry Blast", Size.LARGE, 3, true); // 6.0
        int orderNo2 = shop.getCurrentOrder().getOrderNo();
        
        // Check total prices
        assertEquals(2.0, shop.totalOrderPrice(orderNo1), 0.001);
        assertEquals(6.0, shop.totalOrderPrice(orderNo2), 0.001);
        
        // Nonexistent order
        assertEquals(0.0, shop.totalOrderPrice(99999), 0.001);
    }

    @Test
    public void testTotalMonthlySale() {
        // No orders yet
        assertEquals(0.0, shop.totalMonthlySale(), 0.001);
        
        // Create orders
        shop.startNewOrder(10, Day.MONDAY, "John", 25);
        shop.processCoffeeOrder("Regular Coffee", Size.SMALL, false, false); // 2.0
        
        shop.startNewOrder(15, Day.SATURDAY, "Mary", 22);
        shop.processSmoothieOrder("Berry Blast", Size.LARGE, 3, true); // 6.0
        
        // Total: 2.0 + 6.0 = 8.0
        assertEquals(8.0, shop.totalMonthlySale(), 0.001);
    }

    @Test
    public void testTotalNumOfMonthlyOrders() {
        // No orders yet
        assertEquals(0, shop.totalNumOfMonthlyOrders());
        
        // Create orders
        shop.startNewOrder(10, Day.MONDAY, "John", 25);
        assertEquals(1, shop.totalNumOfMonthlyOrders());
        
        shop.startNewOrder(15, Day.SATURDAY, "Mary", 22);
        assertEquals(2, shop.totalNumOfMonthlyOrders());
    }

    @Test
    public void testSortOrders() {
        // Create orders in random order
        shop.startNewOrder(10, Day.MONDAY, "John", 25);
        Order order1 = shop.getCurrentOrder();
        
        shop.startNewOrder(15, Day.SATURDAY, "Mary", 22);
        Order order2 = shop.getCurrentOrder();
        
        shop.startNewOrder(12, Day.SUNDAY, "Bob", 30);
        Order order3 = shop.getCurrentOrder();
        
        // Sort orders
        shop.sortOrders();
        
        // Check order at indices
        int minOrderNo = Math.min(Math.min(order1.getOrderNo(), order2.getOrderNo()), order3.getOrderNo());
        int maxOrderNo = Math.max(Math.max(order1.getOrderNo(), order2.getOrderNo()), order3.getOrderNo());
        
        assertEquals(minOrderNo, shop.getOrderAtIndex(0).getOrderNo());
        assertEquals(maxOrderNo, shop.getOrderAtIndex(2).getOrderNo());
    }
}