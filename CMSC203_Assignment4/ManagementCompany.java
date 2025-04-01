/**
 * Class: CMSC203 30312
 * Instructor: Ahmed Tarek
 * Description: This class represents a Management Company that manages properties.
 * Due: 03/27/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Abraham Ouattara
 */

public class ManagementCompany {
    // Constants
    public final int MAX_PROPERTY = 5;
    public final int MGMT_WIDTH = 10;
    public final int MGMT_DEPTH = 10;
    
    // Instance variables
    private String name;
    private String taxID;
    private double mgmFee;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;
    
    /**
     * Default constructor - creates a ManagementCompany object with default values
     */
    public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.mgmFee = 0.0;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }
    
    /**
     * Parameterized constructor - creates a ManagementCompany object with given name, taxID, and 
     * management fee with default plot (0,0,10,10)
     * 
     * @param name the name of the management company
     * @param taxID the tax ID of the management company
     * @param mgmFee the management fee as a percentage
     */
    public ManagementCompany(String name, String taxID, double mgmFee) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }
    
    /**
     * Parameterized constructor - creates a ManagementCompany object with given name, taxID, and 
     * management fee with a custom plot
     * 
     * @param name the name of the management company
     * @param taxID the tax ID of the management company
     * @param mgmFee the management fee as a percentage
     * @param x the x-coordinate of the plot
     * @param y the y-coordinate of the plot
     * @param width the width of the plot
     * @param depth the depth of the plot
     */
    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(x, y, width, depth);
        this.numberOfProperties = 0;
    }
    
    /**
     * Copy constructor - creates a ManagementCompany object with the same information as the parameter
     * 
     * @param otherCompany the ManagementCompany object to copy
     */
    public ManagementCompany(ManagementCompany otherCompany) {
        this.name = otherCompany.name;
        this.taxID = otherCompany.taxID;
        this.mgmFee = otherCompany.mgmFee;
        this.plot = new Plot(otherCompany.plot);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = otherCompany.numberOfProperties;
        
        // Deep copy of the properties array
        for (int i = 0; i < otherCompany.numberOfProperties; i++) {
            if (otherCompany.properties[i] != null) {
                this.properties[i] = new Property(otherCompany.properties[i]);
            }
        }
    }
    
    /**
     * Adds a property to the properties array
     * 
     * @param property the Property object to be added to the properties array
     * @return -1 if the properties array is full, -2 if the property is null, 
     *         -3 if the management company does not encompass the property plot, 
     *         -4 if the property plot overlaps with any existing property's plot, 
     *         index in the array where the property was added if the property is successfully added
     */
    public int addProperty(Property property) {
        // Check if property is null
        if (property == null) {
            return -2;
        }
        
        // Check if the properties array is full
        if (numberOfProperties >= MAX_PROPERTY) {
            return -1;
        }
        
        // Check if the property's plot is encompassed by the management company's plot
        if (!plot.encompasses(property.getPlot())) {
            return -3;
        }
        
        // Check if the property's plot overlaps with any existing property's plot
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null && properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }
        
        // Add the property to the properties array (create a deep copy)
        properties[numberOfProperties] = new Property(property);
        
        // Increment the numberOfProperties counter and return the index
        return numberOfProperties++;
    }
    
    /**
     * Adds a property to the properties array with the given parameters
     * 
     * @param name the name of the property
     * @param city the city where the property is located
     * @param rent the rent amount
     * @param owner the owner's name
     * @return the result of calling addProperty with the created Property object
     */
    public int addProperty(String name, String city, double rent, String owner) {
        // Create a new Property object with the provided parameters and a default plot
        Property property = new Property(name, city, rent, owner);
        
        // Call the other addProperty method
        return addProperty(property);
    }
    
    /**
     * Adds a property to the properties array with the given parameters
     * 
     * @param name the name of the property
     * @param city the city where the property is located
     * @param rent the rent amount
     * @param owner the owner's name
     * @param x the x-coordinate of the property's plot
     * @param y the y-coordinate of the property's plot
     * @param width the width of the property's plot
     * @param depth the depth of the property's plot
     * @return the result of calling addProperty with the created Property object
     */
    public int addProperty(String name, String city, double rent, String owner, 
                           int x, int y, int width, int depth) {
        // Create a new Property object with the provided parameters
        Property property = new Property(name, city, rent, owner, x, y, width, depth);
        
        // Call the other addProperty method
        return addProperty(property);
    }
    
    /**
     * Removes the last property in the properties array
     */
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }
    
    /**
     * Checks if the properties array is full
     * 
     * @return true if the properties array is full, false otherwise
     */
    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }
    
    /**
     * Gets the number of properties in the properties array
     * 
     * @return the number of properties
     */
    public int getPropertiesCount() {
        return numberOfProperties;
    }
    
    /**
     * Calculates the total rent of all properties in the properties array
     * 
     * @return the total rent
     */
    public double getTotalRent() {
        double totalRent = 0.0;
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null) {
                totalRent += properties[i].getRentAmount();
            }
        }
        return totalRent;
    }
    
    /**
     * Finds the property with the highest rent amount
     * 
     * @return the property with the highest rent amount
     */
    public Property getHighestRentPropperty() {
        if (numberOfProperties == 0) {
            return null;
        }
        
        int maxIndex = 0;
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i] != null && 
                properties[i].getRentAmount() > properties[maxIndex].getRentAmount()) {
                maxIndex = i;
            }
        }
        return properties[maxIndex];
    }
    
    /**
     * Checks if the management fee is valid (between 0 and 100)
     * 
     * @return true if the management fee is valid, false otherwise
     */
    public boolean isManagementFeeValid() {
        return mgmFee >= 0.0 && mgmFee <= 100.0;
    }
    
    /**
     * Gets the name of the management company
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the tax ID of the management company
     * 
     * @return the tax ID
     */
    public String getTaxID() {
        return taxID;
    }
    
    /**
     * Gets the management fee of the management company
     * 
     * @return the management fee
     */
    public double getMgmFee() {
        return mgmFee;
    }
    
    /**
     * Gets the properties array
     * 
     * @return the properties array
     */
    public Property[] getProperties() {
        return properties;
    }
    
    /**
     * Gets the plot of the management company
     * 
     * @return the plot
     */
    public Plot getPlot() {
        return plot;
    }
    
    /**
     * Returns a string representation of the management company including all the properties
     * 
     * @return a string representation of the management company
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("List of the properties for ").append(name)
              .append(", taxID: ").append(taxID).append("\n");
        result.append("______________________________________________________\n");
        
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null) {
                result.append(properties[i].toString()).append("\n");
            }
        }
        
        result.append("______________________________________________________\n\n");
        
        // Calculate the total management fee as a percentage of the total rent
        double totalRent = getTotalRent();
        double totalManagementFee = totalRent * (mgmFee / 100);
        
        result.append(" total management Fee: ").append(String.format("%.2f", totalManagementFee));
        
        return result.toString();
    }
}