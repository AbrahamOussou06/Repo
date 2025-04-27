/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: The testing class for the GradeBook.java
 * Due: 3/27/25
 * Platform/compiler: Eclipse/Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Abraham Ouattara
 */

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradebookTester
{
   private GradeBook g1;
   private GradeBook g2;

   @Before
   public void setUp() throws Exception
   {
      // Create at least two objects of Gradebook to hold 5 scores
      g1 = new GradeBook(5);
      g2 = new GradeBook(5);
      
      // Add scores to g1
      g1.addScore(50.0);
      g1.addScore(75.0);
      
      // Add scores to g2
      g2.addScore(90.0);
      g2.addScore(85.0);
      g2.addScore(95.0);
   }

   @After
   public void tearDown() throws Exception
   {
      // Set the objects to null
      g1 = null;
      g2 = null;
   }

   @Test
   public void testAddScore()
   {
      // Test toString method to compare contents of scores array
      assertTrue(g1.toString().equals("50.0 75.0 "));
      assertTrue(g2.toString().equals("90.0 85.0 95.0 "));
      
      // Test scoreSize using assertEquals
      assertEquals(2, g1.getScoreSize());
      assertEquals(3, g2.getScoreSize());
      
      // Test adding more scores
      assertTrue(g1.addScore(100.0));
      assertEquals(3, g1.getScoreSize());
      assertTrue(g1.toString().equals("50.0 75.0 100.0 "));
   }

   @Test
   public void testSum()
   {
      // Compare what is returned by sum() to the expected sum
      assertEquals(125.0, g1.sum(), 0.0001);
      assertEquals(270.0, g2.sum(), 0.0001);
   }

   @Test
   public void testMinimum()
   {
      // Compare what is returned by minimum() to the expected minimum
      assertEquals(50.0, g1.minimum(), 0.0001);
      assertEquals(85.0, g2.minimum(), 0.0001);
   }

   @Test
   public void testFinalScore()
   {
      // Compare what is returned by finalScore() to the expected finalScore
      // For g1: sum(50 + 75) - minimum(50) = 125 - 50 = 75
      assertEquals(75.0, g1.finalScore(), 0.0001);
      
      // For g2: sum(90 + 85 + 95) - minimum(85) = 270 - 85 = 185
      assertEquals(185.0, g2.finalScore(), 0.0001);
   }
}