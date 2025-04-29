/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: Class representing an alcohol beverage with weekend pricing
 * Due: 04/25/25
 * Platform/compiler: Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Abraham
*/
public class Alcohol extends Beverage {
    private boolean inWeekend;
    private final double WEEKEND_COST = 0.6;
    
    /**
     * Constructor for Alcohol
     * @param name beverage name
     * @param size beverage size
     * @param inWeekend true if offered in weekend
     */
    public Alcohol(String name, Size size, boolean inWeekend) {
        super(name, Type.ALCOHOL, size);
        this.inWeekend = inWeekend;
    }
    
    /**
     * Calculates the price of this alcohol
     * @return total price of the alcohol
     */
    @Override
    public double calcPrice() {
        double price = addSizePrice();
        
        if (inWeekend) {
            price += WEEKEND_COST;
        }
        
        return price;
    }
    
    /**
     * String representation of the alcohol
     * @return string with alcohol information
     */
    @Override
    public String toString() {
        return super.toString() + ", " + (inWeekend ? "Weekend" : "Weekday") + 
               ", $" + calcPrice();
    }
    
    /**
     * Checks if two alcohols are equal
     * @param obj object to compare with
     * @return true if alcohols are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        
        Alcohol other = (Alcohol) obj;
        return inWeekend == other.inWeekend;
    }
    
    /**
     * Checks if alcohol is offered in weekend
     * @return true if offered in weekend, false otherwise
     */
    public boolean isInWeekend() {
        return inWeekend;
    }
    
    /**
     * Sets if alcohol is offered in weekend
     * @param inWeekend true if offered in weekend, false otherwise
     */
    public void setInWeekend(boolean inWeekend) {
        this.inWeekend = inWeekend;
    }
}