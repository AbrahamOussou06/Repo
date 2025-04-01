/**
 * Class: CMSC203 30312
 * Instructor:
 * Description: JUnit test class for the Property class
 * Due: 03/27/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Abraham Ouattara
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTestStudent {
    private Property property1;      // Default constructor
    private Property property2;      // Constructor with property details (default plot)
    private Property property3;      // Constructor with property details and plot
    private Property property4;      // Copy constructor
    
    @BeforeEach
    void setUp() throws Exception {
        // Initialize properties with different constructors
        property1 = new Property();
        property2 = new Property("Lakewood Apartment", "Silver Spring", 2500.0, "John Smith");
        property3 = new Property("Downtown Condo", "Rockville", 1800.0, "Jane Doe", 2, 3, 4, 5);
        property4 = new Property(property3);  // Copy of property3
    }

    @AfterEach
    void tearDown() throws Exception {
        property1 = property2 = property3 = property4 = null;
    }

    @Test
    void testDefaultConstructor() {
        // Test default constructor values
        assertEquals("", property1.getPropertyName());
        assertEquals("", property1.getCity());
        assertEquals(0.0, property1.getRentAmount());
        assertEquals("", property1.getOwner());
        assertEquals(0, property1.getPlot().getX());
        assertEquals(0, property1.getPlot().getY());
        assertEquals(1, property1.getPlot().getWidth());
        assertEquals(1, property1.getPlot().getDepth());
    }

    @Test
    void testParameterizedConstructor1() {
        // Test constructor with property details (default plot)
        assertEquals("Lakewood Apartment", property2.getPropertyName());
        assertEquals("Silver Spring", property2.getCity());
        assertEquals(2500.0, property2.getRentAmount());
        assertEquals("John Smith", property2.getOwner());
        assertEquals(0, property2.getPlot().getX());
        assertEquals(0, property2.getPlot().getY());
        assertEquals(1, property2.getPlot().getWidth());
        assertEquals(1, property2.getPlot().getDepth());
    }

    @Test
    void testParameterizedConstructor2() {
        // Test constructor with property details and custom plot
        assertEquals("Downtown Condo", property3.getPropertyName());
        assertEquals("Rockville", property3.getCity());
        assertEquals(1800.0, property3.getRentAmount());
        assertEquals("Jane Doe", property3.getOwner());
        assertEquals(2, property3.getPlot().getX());
        assertEquals(3, property3.getPlot().getY());
        assertEquals(4, property3.getPlot().getWidth());
        assertEquals(5, property3.getPlot().getDepth());
    }

    @Test
    void testCopyConstructor() {
        // Test copy constructor
        assertEquals(property3.getPropertyName(), property4.getPropertyName());
        assertEquals(property3.getCity(), property4.getCity());
        assertEquals(property3.getRentAmount(), property4.getRentAmount());
        assertEquals(property3.getOwner(), property4.getOwner());
        assertEquals(property3.getPlot().getX(), property4.getPlot().getX());
        assertEquals(property3.getPlot().getY(), property4.getPlot().getY());
        assertEquals(property3.getPlot().getWidth(), property4.getPlot().getWidth());
        assertEquals(property3.getPlot().getDepth(), property4.getPlot().getDepth());
        
        // Verify that changing one property doesn't affect the other (deep copy)
        property4.setPropertyName("Changed Name");
        assertNotEquals(property3.getPropertyName(), property4.getPropertyName());
    }

    @Test
    void testGetters() {
        // Test getter methods
        assertEquals("Downtown Condo", property3.getPropertyName());
        assertEquals("Rockville", property3.getCity());
        assertEquals(1800.0, property3.getRentAmount());
        assertEquals("Jane Doe", property3.getOwner());
        assertNotNull(property3.getPlot());
    }

    @Test
    void testSetters() {
        // Test setter methods
        property1.setPropertyName("New Property");
        property1.setCity("New City");
        property1.setRentAmount(3000.0);
        property1.setOwner("New Owner");
        property1.setPlot(10, 11, 12, 13);
        
        assertEquals("New Property", property1.getPropertyName());
        assertEquals("New City", property1.getCity());
        assertEquals(3000.0, property1.getRentAmount());
        assertEquals("New Owner", property1.getOwner());
        assertEquals(10, property1.getPlot().getX());
        assertEquals(11, property1.getPlot().getY());
        assertEquals(12, property1.getPlot().getWidth());
        assertEquals(13, property1.getPlot().getDepth());
    }
    
    @Test
    void testToString() {
        // Test the toString method formatting
        assertEquals("Lakewood Apartment,Silver Spring,John Smith,2500.0", property2.toString());
        assertEquals("Downtown Condo,Rockville,Jane Doe,1800.0", property3.toString());
    }
}