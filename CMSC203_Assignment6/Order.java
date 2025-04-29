import java.util.ArrayList;
import java.util.Random;

/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: Class representing an order that contains beverages and customer information
 * Due: 04/25/25
 * Platform/compiler: Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Abraham
*/
public class Order implements OrderInterface, Comparable<Order> {
    private int orderNo;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;
    
    /**
     * Constructor for Order
     * @param orderTime time of the order
     * @param orderDay day of the order
     * @param customer customer placing the order
     */
    public Order(int orderTime, Day orderDay, Customer customer) {
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer); // Deep copy
        this.beverages = new ArrayList<>();
        this.orderNo = generateOrder();
    }
    
    /**
     * Generates a random order number
     * @return random number between 10000 and 90000
     */
    private int generateOrder() {
        Random rand = new Random();
        return rand.nextInt(80000) + 10000; // Range: 10000-89999
    }
    
    /**
     * Checks if the order day is a weekend
     * @return true if order is on weekend, false otherwise
     */
    @Override
    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }
    
    /**
     * Gets a beverage from the list
     * @param itemNo index of the beverage
     * @return beverage at the specified index
     */
    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo);
        }
        return null;
    }
    
    /**
     * Adds a new coffee to the order
     * @param bevName beverage name
     * @param size beverage size
     * @param extraShot true if extra shot is added
     * @param extraSyrup true if extra syrup is added
     */
    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }
    
    /**
     * Adds a new alcohol to the order
     * @param bevName beverage name
     * @param size beverage size
     */
    @Override
    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }
    
    /**
     * Adds a new smoothie to the order
     * @param bevName beverage name
     * @param size beverage size
     * @param numOfFruits number of fruits
     * @param addProtein true if protein is added
     */
    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }
    
    /**
     * Calculates the total price of the order
     * @return total price of all beverages
     */
    @Override
    public double calcOrderTotal() {
        double total = 0;
        
        for (Beverage beverage : beverages) {
            total += beverage.calcPrice();
        }
        
        return total;
    }
    
    /**
     * Counts beverages of a specific type
     * @param type type of beverage to count
     * @return number of beverages of specified type
     */
    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        
        for (Beverage beverage : beverages) {
            if (beverage.getType() == type) {
                count++;
            }
        }
        
        return count;
    }
    
    /**
     * Compares orders based on order number
     * @param other order to compare with
     * @return -1, 0, or 1 based on comparison
     */
    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNo, other.orderNo);
    }
    
    /**
     * String representation of the order
     * @return string with order information
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order No: ").append(orderNo)
          .append(", Time: ").append(orderTime)
          .append(", Day: ").append(orderDay)
          .append(", Customer: ").append(customer.getName())
          .append(", Age: ").append(customer.getAge())
          .append("\nBeverages:");
        
        for (Beverage beverage : beverages) {
            sb.append("\n").append(beverage.toString());
        }
        
        return sb.toString();
    }
    
    /**
     * Gets the order number
     * @return order number
     */
    public int getOrderNo() {
        return orderNo;
    }
    
    /**
     * Gets the order time
     * @return order time
     */
    public int getOrderTime() {
        return orderTime;
    }
    
    /**
     * Sets the order time
     * @param orderTime new order time
     */
    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }
    
    /**
     * Gets the order day
     * @return order day
     */
    public Day getOrderDay() {
        return orderDay;
    }
    
    /**
     * Sets the order day
     * @param orderDay new order day
     */
    public void setOrderDay(Day orderDay) {
        this.orderDay = orderDay;
    }
    
    /**
     * Gets the customer
     * @return deep copy of the customer
     */
    public Customer getCustomer() {
        return new Customer(customer);
    }
    
    /**
     * Sets the customer
     * @param customer new customer
     */
    public void setCustomer(Customer customer) {
        this.customer = new Customer(customer);
    }
    
    /**
     * Gets the total number of items
     * @return number of beverages in the order
     */
    public int getTotalItems() {
        return beverages.size();
    }
}