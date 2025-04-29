/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: Class representing a smoothie beverage with options for fruits and protein
 * Due: 04/25/25
 * Platform/compiler: Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Abraham
*/
public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean addProtein;
    private final double PROTEIN_COST = 1.5;
    private final double FRUIT_COST = 0.5;
    
    /**
     * Constructor for Smoothie
     * @param name beverage name
     * @param size beverage size
     * @param numOfFruits number of fruits added
     * @param addProtein true if protein is added
     */
    public Smoothie(String name, Size size, int numOfFruits, boolean addProtein) {
        super(name, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }
    
    /**
     * Calculates the price of this smoothie
     * @return total price of the smoothie
     */
    @Override
    public double calcPrice() {
        double price = addSizePrice();
        
        price += numOfFruits * FRUIT_COST;
        
        if (addProtein) {
            price += PROTEIN_COST;
        }
        
        return price;
    }
    
    /**
     * String representation of the smoothie
     * @return string with smoothie information
     */
    @Override
    public String toString() {
        return super.toString() + ", " + numOfFruits + " fruits, " + 
               (addProtein ? "Protein" : "No protein") + ", $" + calcPrice();
    }
    
    /**
     * Checks if two smoothies are equal
     * @param obj object to compare with
     * @return true if smoothies are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        
        Smoothie other = (Smoothie) obj;
        return numOfFruits == other.numOfFruits && addProtein == other.addProtein;
    }
    
    /**
     * Gets the number of fruits
     * @return number of fruits
     */
    public int getNumOfFruits() {
        return numOfFruits;
    }
    
    /**
     * Sets the number of fruits
     * @param numOfFruits new number of fruits
     */
    public void setNumOfFruits(int numOfFruits) {
        this.numOfFruits = numOfFruits;
    }
    
    /**
     * Checks if protein is added
     * @return true if protein is added, false otherwise
     */
    public boolean isAddProtein() {
        return addProtein;
    }
    
    /**
     * Sets if protein is added
     * @param addProtein true if protein is added, false otherwise
     */
    public void setAddProtein(boolean addProtein) {
        this.addProtein = addProtein;
    }
}