/**
 * Class: CMSC203 30312
 * Instructor:
 * Description: This class represents a property with its name, city, rental amount, owner, and a plot.
 * Due: 03/27/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Abraham Ouattara
 */

public class Property {
    // Instance variables
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;
    
    /**
     * Default constructor - creates a default Property object
     */
    public Property() {
        propertyName = "";
        city = "";
        rentAmount = 0.0;
        owner = "";
        plot = new Plot();
    }
    
    /**
     * Parameterized constructor - creates a property with the specified property name, city, 
     * rent amount, and owner and a default plot with x, y location of 0, 0 and width and depth of 1.
     * 
     * @param propertyName the property name
     * @param city the city where the property is located
     * @param rentAmount the rent amount
     * @param owner the owner's name
     */
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot();
    }
    
    /**
     * Parameterized constructor - creates a property with the specified property name, city, 
     * rent amount, owner, x, y, width and depth.
     * 
     * @param propertyName the property name
     * @param city the city where the property is located
     * @param rentAmount the rent amount
     * @param owner the owner's name
     * @param x the x-coordinate of the upper-left corner of the property's plot
     * @param y the y-coordinate of the upper-left corner of the property's plot
     * @param width the width of the property's plot
     * @param depth the depth of the property's plot
     */
    public Property(String propertyName, String city, double rentAmount, String owner, 
                    int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }
    
    /**
     * Copy constructor - creates a property with the same information as the parameter
     * 
     * @param otherProperty the property to copy
     */
    public Property(Property otherProperty) {
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentAmount = otherProperty.rentAmount;
        this.owner = otherProperty.owner;
        this.plot = new Plot(otherProperty.plot);
    }
    
    /**
     * Gets the property name
     * 
     * @return the property name
     */
    public String getPropertyName() {
        return propertyName;
    }
    
    /**
     * Gets the city
     * 
     * @return the city
     */
    public String getCity() {
        return city;
    }
    
    /**
     * Gets the rent amount
     * 
     * @return the rent amount
     */
    public double getRentAmount() {
        return rentAmount;
    }
    
    /**
     * Gets the owner
     * 
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }
    
    /**
     * Gets the plot
     * 
     * @return the plot
     */
    public Plot getPlot() {
        return plot;
    }
    
    /**
     * Sets the property name
     * 
     * @param propertyName the property name to set
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
    
    /**
     * Sets the city
     * 
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     * Sets the rent amount
     * 
     * @param rentAmount the rent amount to set
     */
    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }
    
    /**
     * Sets the owner
     * 
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    /**
     * Sets the plot with the given values
     * 
     * @param x the x-coordinate of the upper-left corner of the plot
     * @param y the y-coordinate of the upper-left corner of the plot
     * @param width the width of the plot
     * @param depth the depth of the plot
     */
    public void setPlot(int x, int y, int width, int depth) {
        this.plot = new Plot(x, y, width, depth);
    }
    
    /**
     * Returns a string representation of the property in the format:
     * property name,city,owner,rent amount
     * 
     * @return the string representation of the property
     */
    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}