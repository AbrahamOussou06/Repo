/**
 * Class: CMSC203 30312
 * Instructor:
 * Description: JUnit test class for the Plot class
 * Due: 03/27/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Abraham Ouattara
 */

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlotTestStudent {
    private Plot plot1, plot2, plot3, plot4, plot5, plot6, plot7;

    @Before
    public void setUp() throws Exception {
        // Create different plot configurations for testing
        plot1 = new Plot(2, 2, 6, 6);         // Base plot for comparison
        plot2 = new Plot(3, 4, 4, 3);         // Plot completely inside plot1
        plot3 = new Plot(10, 10, 3, 2);       // Plot completely outside plot1
        plot4 = new Plot(1, 1, 2, 2);         // Plot overlapping with plot1
        plot5 = new Plot(2, 2, 6, 6);         // Plot exactly the same as plot1
        plot6 = new Plot(8, 2, 2, 2);         // Plot outside plot1
        plot7 = new Plot();                   // Default plot
    }

    @After
    public void tearDown() throws Exception {
        plot1 = plot2 = plot3 = plot4 = plot5 = plot6 = plot7 = null;
    }

    @Test
    public void testDefaultConstructor() {
        // Check if default constructor sets values correctly
        assertEquals(0, plot7.getX());
        assertEquals(0, plot7.getY());
        assertEquals(1, plot7.getWidth());
        assertEquals(1, plot7.getDepth());
    }

    @Test
    public void testParameterizedConstructor() {
        // Check if parameterized constructor sets values correctly
        assertEquals(2, plot1.getX());
        assertEquals(2, plot1.getY());
        assertEquals(6, plot1.getWidth());
        assertEquals(6, plot1.getDepth());
    }

    @Test
    public void testCopyConstructor() {
        // Create a new plot as a copy of an existing plot
        Plot copyPlot = new Plot(plot1);
        
        // Check if the values are correctly copied
        assertEquals(plot1.getX(), copyPlot.getX());
        assertEquals(plot1.getY(), copyPlot.getY());
        assertEquals(plot1.getWidth(), copyPlot.getWidth());
        assertEquals(plot1.getDepth(), copyPlot.getDepth());
        
        // Ensure that changing one plot doesn't affect the other
        copyPlot.setX(99);
        assertNotEquals(plot1.getX(), copyPlot.getX());
    }

    @Test
    public void testGetters() {
        // Test getter methods
        assertEquals(3, plot2.getX());
        assertEquals(4, plot2.getY());
        assertEquals(4, plot2.getWidth());
        assertEquals(3, plot2.getDepth());
    }

    @Test
    public void testSetters() {
        // Create a new plot
        Plot testPlot = new Plot();
        
        // Set new values
        testPlot.setX(5);
        testPlot.setY(10);
        testPlot.setWidth(15);
        testPlot.setDepth(20);
        
        // Check if the values were set correctly
        assertEquals(5, testPlot.getX());
        assertEquals(10, testPlot.getY());
        assertEquals(15, testPlot.getWidth());
        assertEquals(20, testPlot.getDepth());
    }

    @Test
    public void testOverlaps() {
        // Test overlapping scenarios
        assertTrue(plot1.overlaps(plot2));    // plot2 is entirely inside plot1
        assertTrue(plot2.overlaps(plot1));    // plot1 contains plot2
        assertFalse(plot1.overlaps(plot3));   // plot3 is completely outside plot1
        assertFalse(plot3.overlaps(plot1));   // plot1 and plot3 don't overlap
        assertTrue(plot1.overlaps(plot4));    // plot4 partially overlaps plot1
        assertTrue(plot1.overlaps(plot5));    // plot5 is exactly the same as plot1
        assertFalse(plot1.overlaps(plot6));   // plot6 is outside plot1
    }

    @Test
    public void testEncompasses() {
        // Test encompassing scenarios
        assertTrue(plot1.encompasses(plot2));    // plot1 completely encompasses plot2
        assertFalse(plot2.encompasses(plot1));   // plot2 does not encompass plot1
        assertFalse(plot1.encompasses(plot3));   // plot1 does not encompass plot3
        assertFalse(plot1.encompasses(plot4));   // plot1 does not encompass plot4 (only partial overlap)
        assertTrue(plot1.encompasses(plot5));    // plot1 encompasses plot5 (they are the same)
        assertTrue(plot5.encompasses(plot1));    // plot5 encompasses plot1 (they are the same)
        assertFalse(plot1.encompasses(plot6));   // plot1 does not encompass plot6
    }

    @Test
    public void testToString() {
        // Test the toString method for format "x,y,width,depth"
        assertEquals("2,2,6,6", plot1.toString());
        assertEquals("3,4,4,3", plot2.toString());
        assertEquals("0,0,1,1", plot7.toString());
    }
}