/**
 * Class: CMSC203 30312
 * Instructor:
 * Description: JUnit test class for the ManagementCompany class
 * Due: 03/27/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Abraham Ouattara
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
    private Property p1, p2, p3, p4, p5, p6;
    private ManagementCompany mgmtCompany;
    private ManagementCompany mgmtCompany2;
    private ManagementCompany mgmtCompany3;
    private ManagementCompany mgmtCompany4;

    @Before
    public void setUp() throws Exception {
        // Create Management Companies
        mgmtCompany = new ManagementCompany("Alliance Property Management", "123456789", 8);
        mgmtCompany2 = new ManagementCompany(); // default constructor
        mgmtCompany3 = new ManagementCompany("Railey", "555555555", 6, 2, 2, 6, 6); // custom plot
        mgmtCompany4 = new ManagementCompany(mgmtCompany3); // copy constructor
        
        // Create properties to use for testing
        p1 = new Property("Belmar", "Silver Spring", 1200, "John Smith", 2, 3, 2, 2);
        p2 = new Property("Camden Lakeway", "Rockville", 2450, "Ann Taylor", 4, 5, 2, 2);
        p3 = new Property("Hamptons", "Rockville", 1250, "Rick Steves", 6, 7, 2, 2);
        p4 = new Property("Mallory Square", "Silver Spring", 1780, "Abbey McDonald", 8, 9, 2, 2);
        p5 = new Property("Lakewood", "Rockville", 3000, "Alex Tan", 5, 3, 6, 6); // This one overlaps with others
        p6 = new Property("Sunset Plaza", "Bethesda", 2780, "Taylor Swift", 11, 11, 3, 3); // This one is outside the mgmt plot
    }

    @After
    public void tearDown() throws Exception {
        mgmtCompany = mgmtCompany2 = mgmtCompany3 = mgmtCompany4 = null;
        p1 = p2 = p3 = p4 = p5 = p6 = null;
    }

    @Test
    public void testAddPropertyDefaultPlot() {
        // Test adding property with default constructor (plot 0,0,1,1)
        Property defaultProperty = new Property("Default Property", "Default City", 1000, "Default Owner");
        assertEquals(0, mgmtCompany.addProperty(defaultProperty));
    }

    @Test
    public void testAddPropertyString() {
        // Test the addProperty method with string parameters
        assertEquals(0, mgmtCompany.addProperty("Test Property", "Test City", 1000, "Test Owner"));
    }

    @Test
    public void testAddPropertyStringWithPlot() {
        // Test the addProperty method with string parameters and plot coordinates
        assertEquals(0, mgmtCompany.addProperty("Test Property", "Test City", 1000, "Test Owner", 1, 1, 2, 2));
    }

    @Test
    public void testMaximumProperties() {
        // Test adding maximum number of properties (5)
        assertEquals(0, mgmtCompany.addProperty(p1));
        assertEquals(1, mgmtCompany.addProperty(p2));
        assertEquals(2, mgmtCompany.addProperty(p3));
        assertEquals(3, mgmtCompany.addProperty(p4));
        assertEquals(4, mgmtCompany.addProperty(new Property("Last Property", "Last City", 999, "Last Owner", 9, 9, 1, 1)));
        
        // Try to add one more should return -1 (array full)
        assertEquals(-1, mgmtCompany.addProperty(new Property("Extra Property", "Extra City", 888, "Extra Owner")));
    }

    @Test
    public void testAddSameProperty() {
        // Test adding the same property multiple times
        assertEquals(0, mgmtCompany.addProperty(p1));
        
        // Adding the same property should be allowed (it's a copy)
        // But make sure it's a deep copy
        Property p1Copy = new Property(p1);
        assertEquals(1, mgmtCompany.addProperty(p1Copy));
        
        // Change the original property
        p1.setRentAmount(9999);
        
        // The properties in the management company should not be affected
        assertEquals(1200, mgmtCompany.getProperties()[0].getRentAmount());
    }

    @Test
    public void testAddNullProperty() {
        // Test adding a null property
        assertEquals(-2, mgmtCompany.addProperty((Property)null));
    }

    @Test
    public void testAddPropertyOutsidePlot() {
        // Test adding a property outside the management company's plot
        assertEquals(-3, mgmtCompany.addProperty(p6));
    }

    @Test
    public void testAddPropertyOverlap() {
        // Test adding properties that overlap
        assertEquals(0, mgmtCompany.addProperty(p1));
        assertEquals(-4, mgmtCompany.addProperty(p5)); // p5 overlaps with p1
    }

    @Test
    public void testRemoveLastProperty() {
        // Add properties
        mgmtCompany.addProperty(p1);
        mgmtCompany.addProperty(p2);
        assertEquals(2, mgmtCompany.getPropertiesCount());
        
        // Remove the last one
        mgmtCompany.removeLastProperty();
        assertEquals(1, mgmtCompany.getPropertiesCount());
        
        // Make sure the first one is still there
        assertEquals("Belmar", mgmtCompany.getProperties()[0].getPropertyName());
    }

    @Test
    public void testIsPropertiesFull() {
        assertFalse(mgmtCompany.isPropertiesFull());
        
        // Add maximum properties
        mgmtCompany.addProperty(p1);
        mgmtCompany.addProperty(p2);
        mgmtCompany.addProperty(p3);
        mgmtCompany.addProperty(p4);
        mgmtCompany.addProperty(new Property("Last Property", "Last City", 999, "Last Owner", 9, 9, 1, 1));
        
        assertTrue(mgmtCompany.isPropertiesFull());
    }

    @Test
    public void testGetPropertiesCount() {
        assertEquals(0, mgmtCompany.getPropertiesCount());
        
        mgmtCompany.addProperty(p1);
        assertEquals(1, mgmtCompany.getPropertiesCount());
        
        mgmtCompany.addProperty(p2);
        assertEquals(2, mgmtCompany.getPropertiesCount());
    }

    @Test
    public void testGetTotalRent() {
        // Add properties
        mgmtCompany.addProperty(p1); // 1200
        mgmtCompany.addProperty(p2); // 2450
        mgmtCompany.addProperty(p3); // 1250
        
        // Total should be 1200 + 2450 + 1250 = 4900
        assertEquals(4900.0, mgmtCompany.getTotalRent(), 0.001);
    }

    @Test
    public void testGetHighestRentProperty() {
        // Add properties
        mgmtCompany.addProperty(p1); // 1200
        mgmtCompany.addProperty(p2); // 2450
        mgmtCompany.addProperty(p3); // 1250
        
        // p2 has the highest rent
        Property highestRent = mgmtCompany.getHighestRentPropperty();
        assertEquals("Camden Lakeway", highestRent.getPropertyName());
        assertEquals(2450.0, highestRent.getRentAmount(), 0.001);
    }

    @Test
    public void testIsManagementFeeValid() {
        assertTrue(mgmtCompany.isManagementFeeValid()); // 8% is valid
        
        // Create a company with invalid fee
        ManagementCompany invalidCompany = new ManagementCompany("Invalid", "12345", 101); // 101% is invalid
        assertFalse(invalidCompany.isManagementFeeValid());
        
        ManagementCompany negativeCompany = new ManagementCompany("Negative", "12345", -1); // -1% is invalid
        assertFalse(negativeCompany.isManagementFeeValid());
    }

    @Test
    public void testGetName() {
        assertEquals("Alliance Property Management", mgmtCompany.getName());
        assertEquals("Railey", mgmtCompany3.getName());
    }

    @Test
    public void testGetTaxID() {
        assertEquals("123456789", mgmtCompany.getTaxID());
        assertEquals("555555555", mgmtCompany3.getTaxID());
    }

    @Test
    public void testGetMgmFee() {
        assertEquals(8.0, mgmtCompany.getMgmFee(), 0.001);
        assertEquals(6.0, mgmtCompany3.getMgmFee(), 0.001);
    }

    @Test
    public void testGetProperties() {
        // Add a property
        mgmtCompany.addProperty(p1);
        
        // Get the properties array
        Property[] properties = mgmtCompany.getProperties();
        assertNotNull(properties);
        assertEquals("Belmar", properties[0].getPropertyName());
    }

    @Test
    public void testGetPlot() {
        // Default management company has plot at 0,0,10,10
        Plot plot = mgmtCompany.getPlot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(10, plot.getWidth());
        assertEquals(10, plot.getDepth());
        
        // Custom plot for mgmtCompany3
        Plot customPlot = mgmtCompany3.getPlot();
        assertEquals(2, customPlot.getX());
        assertEquals(2, customPlot.getY());
        assertEquals(6, customPlot.getWidth());
        assertEquals(6, customPlot.getDepth());
    }
    
    @Test
    public void testCopyConstructor() {
        // Add a property to mgmtCompany3
        mgmtCompany3.addProperty(p1);
        
        // Check that mgmtCompany4 (copy of mgmtCompany3) has the same property
        assertEquals(1, mgmtCompany4.getPropertiesCount());
        assertEquals("Belmar", mgmtCompany4.getProperties()[0].getPropertyName());
        
        // Verify deep copy: changing one doesn't affect the other
        mgmtCompany3.addProperty(p2);
        assertEquals(2, mgmtCompany3.getPropertiesCount());
        assertEquals(1, mgmtCompany4.getPropertiesCount());
    }

    @Test
    public void testToString() {
        // Add properties to mgmtCompany
        mgmtCompany.addProperty(p1);
        mgmtCompany.addProperty(p2);
        
        // Check the toString output
        String expected = "List of the properties for Alliance Property Management, taxID: 123456789\n" +
                          "______________________________________________________\n" +
                          "Belmar,Silver Spring,John Smith,1200.0\n" +
                          "Camden Lakeway,Rockville,Ann Taylor,2450.0\n" +
                          "______________________________________________________\n\n" +
                          " total management Fee: 292.00";
        
        assertEquals(expected, mgmtCompany.toString());
    }
}