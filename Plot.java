/**
 * Class: CMSC203 30312
 * Instructor: Ahmed Tarek
 * Description: This class represents a plot of land for a property, defined by upper-left x,y coordinates, width, and depth.
 * Due: 03/27/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Abraham Ouattara
 */

public class Plot {
    // Instance variables
    private int x;
    private int y;
    private int width;
    private int depth;
    
    /**
     * Default constructor, creates a Plot with x,y coordinates at (0,0) with a width and depth of 1
     */
    public Plot() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }
    
    /**
     * Parameterized constructor to create a plot with specific values
     * @param x x-coordinate of the upper-left corner
     * @param y y-coordinate of the upper-left corner
     * @param width width of the plot
     * @param depth depth of the plot
     */
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }
    
    /**
     * Copy constructor to create a plot from another plot
     * @param otherPlot the Plot object to copy
     */
    public Plot(Plot otherPlot) {
        this.x = otherPlot.x;
        this.y = otherPlot.y;
        this.width = otherPlot.width;
        this.depth = otherPlot.depth;
    }
    
    /**
     * Sets the x-coordinate of the upper-left corner of the plot
     * @param x the x-coordinate
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * Sets the y-coordinate of the upper-left corner of the plot
     * @param y the y-coordinate
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Sets the width of the plot
     * @param width the width of the plot
     */
    public void setWidth(int width) {
        this.width = width;
    }
    
    /**
     * Sets the depth of the plot
     * @param depth the depth of the plot
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }
    
    /**
     * Gets the x-coordinate of the upper-left corner of the plot
     * @return the x-coordinate
     */
    public int getX() {
        return x;
    }
    
    /**
     * Gets the y-coordinate of the upper-left corner of the plot
     * @return the y-coordinate
     */
    public int getY() {
        return y;
    }
    
    /**
     * Gets the width of the plot
     * @return the width
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Gets the depth of the plot
     * @return the depth
     */
    public int getDepth() {
        return depth;
    }
    
    /**
     * Determines if this plot overlaps the parameterized plot
     * @param plot the plot to check for overlap with
     * @return true if the two plots overlap, false otherwise
     */
    public boolean overlaps(Plot plot) {
        // Calculate the coordinates of the bottom-right corner of both plots
        int thisRight = this.x + this.width;
        int thisBottom = this.y + this.depth;
        int otherRight = plot.x + plot.width;
        int otherBottom = plot.y + plot.depth;
        
        // Check for no overlap conditions
        if (this.x >= otherRight) return false;    // This plot is to the right of the other plot
        if (thisRight <= plot.x) return false;     // This plot is to the left of the other plot
        if (this.y >= otherBottom) return false;   // This plot is below the other plot
        if (thisBottom <= plot.y) return false;    // This plot is above the other plot
        
        // If none of the no-overlap conditions are met, the plots overlap
        return true;
    }
    
    /**
     * Determines if this plot encompasses the parameterized plot
     * This is inclusive, meaning that if the plot is on the edge of this plot, this method returns true
     * @param plot the plot to check if it is encompassed by this plot
     * @return true if this plot encompasses the other plot, false otherwise
     */
    public boolean encompasses(Plot plot) {
        // Check if all corners of the parameterized plot are within this plot
        return plot.x >= this.x && 
               plot.y >= this.y && 
               (plot.x + plot.width) <= (this.x + this.width) && 
               (plot.y + plot.depth) <= (this.y + this.depth);
    }
    
    /**
     * Returns a string representation of the plot with format "x,y,width,depth"
     * @return a string representation of the plot
     */
    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}