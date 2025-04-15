/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: A utility class that calculates holiday bonuses for retail stores
 * Due: 04/14/25
 * Platform/compiler: Eclipse/Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Abraham Ouattara
 */

/**
 * This class calculates holiday bonuses for stores based on their sales data.
 */
public class HolidayBonus {
    // Constants for bonus amounts
    private static final double HIGHEST_BONUS = 5000.0;
    private static final double LOWEST_BONUS = 1000.0;
    private static final double OTHER_BONUS = 2000.0;
    
    /**
     * Calculates the holiday bonus for each store
     * @param data - the two-dimensional ragged array of doubles representing sales data
     * @return an array of doubles representing the holiday bonuses for each store
     */
    public static double[] calculateHolidayBonus(double[][] data) {
        return calculateHolidayBonus(data, HIGHEST_BONUS, LOWEST_BONUS, OTHER_BONUS);
    }
    
    /**
     * Calculates the holiday bonus for each store with specified bonus amounts
     * @param data - the two-dimensional ragged array of doubles representing sales data
     * @param highBonusAmount - bonus for the store with the highest sales in a category
     * @param lowBonusAmount - bonus for the store with the lowest sales in a category
     * @param otherBonusAmount - bonus for all other stores
     * @return an array of doubles representing the holiday bonuses for each store
     */
    public static double[] calculateHolidayBonus(double[][] data, double highBonusAmount, 
                                           double lowBonusAmount, double otherBonusAmount) {
        // Create array to hold bonuses for each store
        double[] bonuses = new double[data.length];
        
        // Find the maximum number of columns in any row
        int maxCols = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i].length > maxCols) {
                maxCols = data[i].length;
            }
        }
        
        // Process each column
        for (int col = 0; col < maxCols; col++) {
            // Get relevant indices and values for this column
            int highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
            double highestValue = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
            int lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);
            double lowestValue = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);
            
            // Count stores with sales in this category
            int storesWithSales = 0;
            for (int i = 0; i < data.length; i++) {
                if (col < data[i].length && data[i][col] > 0) {
                    storesWithSales++;
                }
            }
            
            // Assign bonuses for each store in this column
            for (int row = 0; row < data.length; row++) {
                if (col < data[row].length && data[row][col] > 0) {
                    // Only positive sales are eligible for bonus
                    if (row == highestIndex && data[row][col] == highestValue && storesWithSales > 1) {
                        bonuses[row] += highBonusAmount;
                    } else if (row == lowestIndex && data[row][col] == lowestValue && 
                              lowestValue != highestValue && storesWithSales > 1) {
                        bonuses[row] += lowBonusAmount;
                    } else if (storesWithSales == 1) {
                        // If only one store has sales, it gets highest bonus
                        bonuses[row] += highBonusAmount;
                    } else {
                        bonuses[row] += otherBonusAmount;
                    }
                }
            }
        }
        
        return bonuses;
    }
    
    /**
     * Calculates the total holiday bonus for all stores
     * @param data - the two-dimensional ragged array of doubles representing sales data
     * @return the total holiday bonus amount for all stores
     */
    public static double calculateTotalHolidayBonus(double[][] data) {
        return calculateTotalHolidayBonus(data, HIGHEST_BONUS, LOWEST_BONUS, OTHER_BONUS);
    }
    
    /**
     * Calculates the total holiday bonus for all stores with specified bonus amounts
     * @param data - the two-dimensional ragged array of doubles representing sales data
     * @param highBonusAmount - bonus for the store with the highest sales in a category
     * @param lowBonusAmount - bonus for the store with the lowest sales in a category
     * @param otherBonusAmount - bonus for all other stores
     * @return the total holiday bonus amount for all stores
     */
    public static double calculateTotalHolidayBonus(double[][] data, double highBonusAmount, 
                                              double lowBonusAmount, double otherBonusAmount) {
        double[] bonuses = calculateHolidayBonus(data, highBonusAmount, lowBonusAmount, otherBonusAmount);
        
        double totalBonus = 0;
        for (double bonus : bonuses) {
            totalBonus += bonus;
        }
        
        return totalBonus;
    }
}