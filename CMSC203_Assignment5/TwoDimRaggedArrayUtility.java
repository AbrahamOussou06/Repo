/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: A utility class to manipulate a 2D ragged array of doubles
 * Due: 04/10/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Abraham Ouattara
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This utility class manipulates a two-dimensional ragged array of doubles.
 * It provides various methods to read, write, and analyze data for retail sales reports.
 */
public class TwoDimRaggedArrayUtility {
    
    /**
     * Reads from a file and returns a two-dimensional ragged array of doubles
     * @param file - the file to read from
     * @return - the two-dimensional ragged array of doubles
     * @throws FileNotFoundException if file is not found
     */
    public static double[][] readFile(File file) throws FileNotFoundException {
        // Count the number of rows
        int rowCount = 0;
        Scanner rowCounter = new Scanner(file);
        while (rowCounter.hasNextLine()) {
            rowCounter.nextLine();
            rowCount++;
        }
        rowCounter.close();
        
        // Create the array with the correct number of rows
        double[][] array = new double[rowCount][];
        
        // Fill the array with data from the file
        Scanner scanner = new Scanner(file);
        for (int i = 0; i < rowCount; i++) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.trim().split("\\s+");
                array[i] = new double[values.length];
                
                for (int j = 0; j < values.length; j++) {
                    array[i][j] = Double.parseDouble(values[j]);
                }
            }
        }
        scanner.close();
        
        return array;
    }
    
    /**
     * Writes a two-dimensional ragged array of doubles to a file
     * @param array - the two-dimensional ragged array of doubles
     * @param file - the file to write to
     * @throws FileNotFoundException if file cannot be created
     */
    public static void writeToFile(double[][] array, File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                writer.print(array[i][j] + " ");
            }
            writer.println();
        }
        
        writer.close();
    }
    
    /**
     * Calculates the total of all elements in the two-dimensional array
     * @param array - the two-dimensional ragged array of doubles
     * @return the total of all elements
     */
    public static double getTotal(double[][] array) {
        double total = 0;
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                total += array[i][j];
            }
        }
        
        return total;
    }
    
    /**
     * Calculates the average of all elements in the two-dimensional array
     * @param array - the two-dimensional ragged array of doubles
     * @return the average of all elements
     */
    public static double getAverage(double[][] array) {
        double total = 0;
        int count = 0;
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                total += array[i][j];
                count++;
            }
        }
        
        if (count == 0) {
            return 0;
        }
        
        return total / count;
    }
    
    /**
     * Calculates the total of elements in a specified row
     * @param array - the two-dimensional ragged array of doubles
     * @param rowIndex - the index of the row to calculate total
     * @return the total of the row's elements
     */
    public static double getRowTotal(double[][] array, int rowIndex) {
        double rowTotal = 0;
        
        for (int j = 0; j < array[rowIndex].length; j++) {
            rowTotal += array[rowIndex][j];
        }
        
        return rowTotal;
    }
    
    /**
     * Calculates the total of elements in a specified column
     * @param array - the two-dimensional ragged array of doubles
     * @param colIndex - the index of the column to calculate total
     * @return the total of the column's elements
     */
    public static double getColumnTotal(double[][] array, int colIndex) {
        double colTotal = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (colIndex < array[i].length) {
                colTotal += array[i][colIndex];
            }
        }
        
        return colTotal;
    }
    
    /**
     * Finds the highest value in a specified row
     * @param array - the two-dimensional ragged array of doubles
     * @param rowIndex - the index of the row to search
     * @return the highest value in the row
     */
    public static double getHighestInRow(double[][] array, int rowIndex) {
        if (array[rowIndex].length == 0) {
            return 0;
        }
        
        double highest = array[rowIndex][0];
        
        for (int j = 1; j < array[rowIndex].length; j++) {
            if (array[rowIndex][j] > highest) {
                highest = array[rowIndex][j];
            }
        }
        
        return highest;
    }
    
    /**
     * Finds the index of the highest value in a specified row
     * @param array - the two-dimensional ragged array of doubles
     * @param rowIndex - the index of the row to search
     * @return the index of the highest value in the row
     */
    public static int getHighestInRowIndex(double[][] array, int rowIndex) {
        if (array[rowIndex].length == 0) {
            return 0;
        }
        
        double highest = array[rowIndex][0];
        int highestIndex = 0;
        
        for (int j = 1; j < array[rowIndex].length; j++) {
            if (array[rowIndex][j] > highest) {
                highest = array[rowIndex][j];
                highestIndex = j;
            }
        }
        
        return highestIndex;
    }
    
    /**
     * Finds the lowest value in a specified row
     * @param array - the two-dimensional ragged array of doubles
     * @param rowIndex - the index of the row to search
     * @return the lowest value in the row
     */
    public static double getLowestInRow(double[][] array, int rowIndex) {
        if (array[rowIndex].length == 0) {
            return 0;
        }
        
        double lowest = array[rowIndex][0];
        
        for (int j = 1; j < array[rowIndex].length; j++) {
            if (array[rowIndex][j] < lowest) {
                lowest = array[rowIndex][j];
            }
        }
        
        return lowest;
    }
    
    /**
     * Finds the index of the lowest value in a specified row
     * @param array - the two-dimensional ragged array of doubles
     * @param rowIndex - the index of the row to search
     * @return the index of the lowest value in the row
     */
    public static int getLowestInRowIndex(double[][] array, int rowIndex) {
        if (array[rowIndex].length == 0) {
            return 0;
        }
        
        double lowest = array[rowIndex][0];
        int lowestIndex = 0;
        
        for (int j = 1; j < array[rowIndex].length; j++) {
            if (array[rowIndex][j] < lowest) {
                lowest = array[rowIndex][j];
                lowestIndex = j;
            }
        }
        
        return lowestIndex;
    }
    
    /**
     * Finds the highest value in a specified column
     * @param array - the two-dimensional ragged array of doubles
     * @param colIndex - the index of the column to search
     * @return the highest value in the column
     */
    public static double getHighestInColumn(double[][] array, int colIndex) {
        double highest = Double.NEGATIVE_INFINITY;
        boolean foundValue = false;
        
        for (int i = 0; i < array.length; i++) {
            if (colIndex < array[i].length) {
                if (!foundValue || array[i][colIndex] > highest) {
                    highest = array[i][colIndex];
                    foundValue = true;
                }
            }
        }
        
        if (!foundValue) {
            return 0;
        }
        
        return highest;
    }
    
    /**
     * Finds the index of the highest value in a specified column
     * @param array - the two-dimensional ragged array of doubles
     * @param colIndex - the index of the column to search
     * @return the index of the highest value in the column
     */
    public static int getHighestInColumnIndex(double[][] array, int colIndex) {
        double highest = Double.NEGATIVE_INFINITY;
        int highestIndex = 0;
        boolean foundValue = false;
        
        for (int i = 0; i < array.length; i++) {
            if (colIndex < array[i].length) {
                if (!foundValue || array[i][colIndex] > highest) {
                    highest = array[i][colIndex];
                    highestIndex = i;
                    foundValue = true;
                }
            }
        }
        
        if (!foundValue) {
            return 0;
        }
        
        return highestIndex;
    }
    
    /**
     * Finds the lowest value in a specified column
     * @param array - the two-dimensional ragged array of doubles
     * @param colIndex - the index of the column to search
     * @return the lowest value in the column
     */
    public static double getLowestInColumn(double[][] array, int colIndex) {
        double lowest = Double.POSITIVE_INFINITY;
        boolean foundValue = false;
        
        for (int i = 0; i < array.length; i++) {
            if (colIndex < array[i].length) {
                if (!foundValue || array[i][colIndex] < lowest) {
                    lowest = array[i][colIndex];
                    foundValue = true;
                }
            }
        }
        
        if (!foundValue) {
            return 0;
        }
        
        return lowest;
    }
    
    /**
     * Finds the index of the lowest value in a specified column
     * @param array - the two-dimensional ragged array of doubles
     * @param colIndex - the index of the column to search
     * @return the index of the lowest value in the column
     */
    public static int getLowestInColumnIndex(double[][] array, int colIndex) {
        double lowest = Double.POSITIVE_INFINITY;
        int lowestIndex = 0;
        boolean foundValue = false;
        
        for (int i = 0; i < array.length; i++) {
            if (colIndex < array[i].length) {
                if (!foundValue || array[i][colIndex] < lowest) {
                    lowest = array[i][colIndex];
                    lowestIndex = i;
                    foundValue = true;
                }
            }
        }
        
        if (!foundValue) {
            return 0;
        }
        
        return lowestIndex;
    }
    
    /**
     * Finds the highest value in the two-dimensional array
     * @param array - the two-dimensional ragged array of doubles
     * @return the highest value in the array
     */
    public static double getHighestInArray(double[][] array) {
        double highest = Double.NEGATIVE_INFINITY;
        boolean foundValue = false;
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (!foundValue || array[i][j] > highest) {
                    highest = array[i][j];
                    foundValue = true;
                }
            }
        }
        
        if (!foundValue) {
            return 0;
        }
        
        return highest;
    }
    
    /**
     * Finds the lowest value in the two-dimensional array
     * @param array - the two-dimensional ragged array of doubles
     * @return the lowest value in the array
     */
    public static double getLowestInArray(double[][] array) {
        double lowest = Double.POSITIVE_INFINITY;
        boolean foundValue = false;
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (!foundValue || array[i][j] < lowest) {
                    lowest = array[i][j];
                    foundValue = true;
                }
            }
        }
        
        if (!foundValue) {
            return 0;
        }
        
        return lowest;
    }
}