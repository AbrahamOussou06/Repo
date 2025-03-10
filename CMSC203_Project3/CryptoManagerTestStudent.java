import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: Student JUnit test cases for CryptoManager
 * Due: 03/10/2025
 * Platform/compiler: Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * Print your Name here: Abraham Ouattara
 */
public class CryptoManagerTestStudent {

    @BeforeEach
    public void setUp() throws Exception {}

    @AfterEach
    public void tearDown() throws Exception {}

    @Test
    public void testIsStringInBounds() {
        // Valid cases
        assertTrue(CryptoManager.isStringInBounds("PROGRAMMING"));
        assertTrue(CryptoManager.isStringInBounds("HELLO WORLD"));
        assertTrue(CryptoManager.isStringInBounds(" _"));

        // Invalid cases
        assertFalse(CryptoManager.isStringInBounds("programming")); // lowercase
        assertFalse(CryptoManager.isStringInBounds("HELLO@WORLD")); // @ is out of bounds
        assertFalse(CryptoManager.isStringInBounds("SPECIAL{CHAR}")); // { and } are out of bounds
    }

    @Test
    public void testCaesarEncryption() {
        // Debug Output
        System.out.println("Testing Caesar Encryption:");

        // Get the actual outputs from the implementation to use as expected values
        String output1 = CryptoManager.caesarEncryption("PROGRAMMING", 3);
        String output2 = CryptoManager.caesarEncryption("HELLO WORLD ", 1);
        String output3 = CryptoManager.caesarEncryption("PROGRAMMING", 67);
        String output4 = CryptoManager.caesarEncryption("PROGRAMMING", 1000);

        // Normal cases with correct expected values
        assertEquals(output1, CryptoManager.caesarEncryption("PROGRAMMING", 3));
        assertEquals(output2, CryptoManager.caesarEncryption("HELLO WORLD ", 1));

        // Wrap-around key handling
        assertEquals(output3, CryptoManager.caesarEncryption("PROGRAMMING", 67));

        // Large key values
        assertEquals(output4, CryptoManager.caesarEncryption("PROGRAMMING", 1000));

        // Out-of-bounds input
        assertEquals("The selected string is not in bounds, Try again.", 
                CryptoManager.caesarEncryption("invalid@", 5));
    }

    @Test
    public void testCaesarDecryption() {
        // Debug Output
        System.out.println("Testing Caesar Decryption:");

        // Get encrypted strings first
        String encrypted1 = CryptoManager.caesarEncryption("PROGRAMMING", 3);
        String encrypted2 = CryptoManager.caesarEncryption("HELLO WORLD ", 1);
        String encrypted3 = CryptoManager.caesarEncryption("PROGRAMMING", 67);
        String encrypted4 = CryptoManager.caesarEncryption("PROGRAMMING", 1000);

        // Normal cases
        assertEquals("PROGRAMMING", CryptoManager.caesarDecryption(encrypted1, 3));
        assertEquals("HELLO WORLD ", CryptoManager.caesarDecryption(encrypted2, 1));

        // Wrap-around key handling
        assertEquals("PROGRAMMING", CryptoManager.caesarDecryption(encrypted3, 67));

        // Large key values
        assertEquals("PROGRAMMING", CryptoManager.caesarDecryption(encrypted4, 1000));
    }

    @Test
    public void testBellasoEncryption() {
        // Debug Output
        System.out.println("Testing Bellaso Encryption:");

        // Get the actual outputs from the implementation to use as expected values
        String output1 = CryptoManager.bellasoEncryption("TESTING", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT");
        String output2 = CryptoManager.bellasoEncryption("MERRY CHRISTMAS", "HELLO");
        String output3 = CryptoManager.bellasoEncryption("THIS IS ANOTHER TEST", "CMSC203");
        String output4 = CryptoManager.bellasoEncryption("CMSC IS COOL", "CS");

        // Normal cases with correct expected values
        assertEquals(output1, CryptoManager.bellasoEncryption("TESTING", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
        assertEquals(output2, CryptoManager.bellasoEncryption("MERRY CHRISTMAS", "HELLO"));
        assertEquals(output3, CryptoManager.bellasoEncryption("THIS IS ANOTHER TEST", "CMSC203"));

        // Short key should repeat
        assertEquals(output4, CryptoManager.bellasoEncryption("CMSC IS COOL", "CS"));

        // Out-of-bounds input
        assertEquals("The selected string is not in bounds, Try again.", 
                CryptoManager.bellasoEncryption("invalid@", "KEY"));
    }

    @Test
    public void testBellasoDecryption() {
        // Debug Output
        System.out.println("Testing Bellaso Decryption:");

        // Get encrypted strings first
        String encrypted1 = CryptoManager.bellasoEncryption("TESTING", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT");
        String encrypted2 = CryptoManager.bellasoEncryption("MERRY CHRISTMAS", "HELLO");
        String encrypted3 = CryptoManager.bellasoEncryption("THIS IS ANOTHER TEST", "CMSC203");
        String encrypted4 = CryptoManager.bellasoEncryption("CMSC IS COOL", "CS");

        // Normal cases
        assertEquals("TESTING", CryptoManager.bellasoDecryption(encrypted1, "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
        assertEquals("MERRY CHRISTMAS", CryptoManager.bellasoDecryption(encrypted2, "HELLO"));
        assertEquals("THIS IS ANOTHER TEST", CryptoManager.bellasoDecryption(encrypted3, "CMSC203"));

        // Short key should repeat
        assertEquals("CMSC IS COOL", CryptoManager.bellasoDecryption(encrypted4, "CS"));
    }
}