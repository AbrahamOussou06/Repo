/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: Abstract class representing a beverage with common attributes and methods
 * Due: 04/25/25
 * Platform/compiler: Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Abraham
*/
public abstract class Beverage {
    private String name;
    private Type type;
    private Size size;
    protected final double BASE_PRICE = 2.0;
    protected final double SIZE_PRICE = 0.5;
    
    /**
     * Constructor for Beverage
     * @param name beverage name
     * @param type beverage type
     * @param size beverage size
     */
    public Beverage(String name, Type type, Size size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }
    
    /**
     * Calculates the price based on size
     * @return total price with size adjustment
     */
    public double addSizePrice() {
        double price = BASE_PRICE;
        
        if (size == Size.MEDIUM) {
            price += SIZE_PRICE;
        } else if (size == Size.LARGE) {
            price += 2 * SIZE_PRICE;
        }
        
        return price;
    }
    
    /**
     * Abstract method to calculate total price
     * @return total price of the beverage
     */
    public abstract double calcPrice();
    
    /**
     * String representation of the beverage
     * @return string with beverage information
     */
    @Override
    public String toString() {
        return name + ", " + size;
    }
    
    /**
     * Checks if two beverages are equal
     * @param obj object to compare with
     * @return true if beverages are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Beverage other = (Beverage) obj;
        return name.equals(other.name) && 
               type == other.type && 
               size == other.size;
    }
    
    /**
     * Gets the beverage name
     * @return name of the beverage
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the beverage name
     * @param name new name for the beverage
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets the beverage type
     * @return type of the beverage
     */
    public Type getType() {
        return type;
    }
    
    /**
     * Sets the beverage type
     * @param type new type for the beverage
     */
    public void setType(Type type) {
        this.type = type;
    }
    
    /**
     * Gets the beverage size
     * @return size of the beverage
     */
    public Size getSize() {
        return size;
    }
    
    /**
     * Sets the beverage size
     * @param size new size for the beverage
     */
    public void setSize(Size size) {
        this.size = size;
    }
}