/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: Class representing a coffee beverage with options for extra shot and syrup
 * Due: 04/25/25
 * Platform/compiler: Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Abraham
*/
public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;
    private final double EXTRA_SHOT_COST = 0.5;
    private final double EXTRA_SYRUP_COST = 0.5;
    
    /**
     * Constructor for Coffee
     * @param name beverage name
     * @param size beverage size
     * @param extraShot true if extra shot is added
     * @param extraSyrup true if extra syrup is added
     */
    public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
        super(name, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }
    
    /**
     * Calculates the price of this coffee
     * @return total price of the coffee
     */
    @Override
    public double calcPrice() {
        double price = addSizePrice();
        
        if (extraShot) {
            price += EXTRA_SHOT_COST;
        }
        
        if (extraSyrup) {
            price += EXTRA_SYRUP_COST;
        }
        
        return price;
    }
    
    /**
     * String representation of the coffee
     * @return string with coffee information
     */
    @Override
    public String toString() {
        return super.toString() + ", " + (extraShot ? "Extra shot" : "No extra shot") + 
               ", " + (extraSyrup ? "Extra syrup" : "No extra syrup") + ", $" + calcPrice();
    }
    
    /**
     * Checks if two coffees are equal
     * @param obj object to compare with
     * @return true if coffees are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        
        Coffee other = (Coffee) obj;
        return extraShot == other.extraShot && extraSyrup == other.extraSyrup;
    }
    
    /**
     * Checks if coffee has extra shot
     * @return true if it has extra shot, false otherwise
     */
    public boolean isExtraShot() {
        return extraShot;
    }
    
    /**
     * Sets if coffee has extra shot
     * @param extraShot true if it has extra shot, false otherwise
     */
    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }
    
    /**
     * Checks if coffee has extra syrup
     * @return true if it has extra syrup, false otherwise
     */
    public boolean isExtraSyrup() {
        return extraSyrup;
    }
    
    /**
     * Sets if coffee has extra syrup
     * @param extraSyrup true if it has extra syrup, false otherwise
     */
    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }
}