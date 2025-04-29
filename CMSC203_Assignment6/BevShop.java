import java.util.ArrayList;
import java.util.Collections;

/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: Class representing a beverage shop that manages orders and transactions
 * Due: 04/25/25
 * Platform/compiler: Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Abraham
*/
public class BevShop implements BevShopInterface {
    private int alcoholCount;
    private ArrayList<Order> orders;
    private Order currentOrder;
    
    /**
     * Constructor for BevShop
     */
    public BevShop() {
        orders = new ArrayList<>();
        alcoholCount = 0;
    }
    
    /**
     * Checks if the time is valid
     * @param time time to check
     * @return true if time is valid, false otherwise
     */
    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }
    
    /**
     * Gets maximum number of fruits
     * @return maximum number of fruits
     */
    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }
    
    /**
     * Gets minimum age for alcohol
     * @return minimum age for alcohol
     */
    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }
    
    /**
     * Checks if number of fruits exceeds maximum
     * @param numOfFruits number of fruits to check
     * @return true if exceeds maximum, false otherwise
     */
    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }
    
    /**
     * Gets maximum number of alcohol drinks per order
     * @return maximum alcohol per order
     */
    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }
    
    /**
     * Checks if current order can have more alcohol
     * @return true if eligible for more, false otherwise
     */
    @Override
    public boolean isEligibleForMore() {
        return alcoholCount < MAX_ORDER_FOR_ALCOHOL;
    }
    
    /**
     * Gets number of alcohol drinks in current order
     * @return number of alcohol drinks
     */
    @Override
    public int getNumOfAlcoholDrink() {
        return alcoholCount;
    }
    
    /**
     * Checks if age is valid for alcohol
     * @param age age to check
     * @return true if age is valid, false otherwise
     */
    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }
    
    /**
     * Starts a new order
     * @param time time of order
     * @param day day of order
     * @param customerName customer name
     * @param customerAge customer age
     */
    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Customer customer = new Customer(customerName, customerAge);
        currentOrder = new Order(time, day, customer);
        orders.add(currentOrder);
        alcoholCount = 0;
    }
    
    /**
     * Processes a coffee order
     * @param bevName beverage name
     * @param size beverage size
     * @param extraShot true if extra shot
     * @param extraSyrup true if extra syrup
     */
    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }
    
    /**
     * Processes an alcohol order
     * @param bevName beverage name
     * @param size beverage size
     */
    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        currentOrder.addNewBeverage(bevName, size);
        alcoholCount++;
    }
    
    /**
     * Processes a smoothie order
     * @param bevName beverage name
     * @param size beverage size
     * @param numOfFruits number of fruits
     * @param addProtein true if protein added
     */
    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }
    
    /**
     * Finds an order by number
     * @param orderNo order number to find
     * @return index of the order or -1 if not found
     */
    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Calculates total price of an order
     * @param orderNo order number
     * @return total price of the order
     */
    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        
        return 0;
    }
    
    /**
     * Calculates total sale of all orders
     * @return total monthly sale
     */
    @Override
    public double totalMonthlySale() {
        double total = 0;
        
        for (Order order : orders) {
            total += order.calcOrderTotal();
        }
        
        return total;
    }
    
    /**
     * Gets total number of monthly orders
     * @return number of orders
     */
    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }
    
    /**
     * Gets the current order
     * @return current order
     */
    @Override
    public Order getCurrentOrder() {
        return currentOrder;
    }
    
    /**
     * Gets an order at a specific index
     * @param index index of the order
     * @return order at the index
     */
    @Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
    }
    
    /**
     * Sorts the orders by order number
     */
    @Override
    public void sortOrders() {
        Collections.sort(orders);
    }
    
    /**
     * String representation of the beverage shop
     * @return string with shop information
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Beverage Shop Monthly Orders\n");
        
        for (Order order : orders) {
            sb.append("\n").append(order.toString()).append("\n");
        }
        
        sb.append("\nTotal Monthly Sale: $").append(String.format("%.2f", totalMonthlySale()));
        
        return sb.toString();
    }
}