/**
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: A utility class that implements encryption and decryption using two approaches: 
 *              Caesar Cipher and Bellaso Cipher.
 * Due: 03/08/2025
 * Platform/compiler: Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Abraham Ouattara
 */
public class CryptoManager {
    
    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

    /**
     * Determines if a string is within the allowable ASCII bounds.
     * @param plainText the string to be checked.
     * @return true if all characters are within bounds, false otherwise.
     */
    public static boolean isStringInBounds(String plainText) {
        for (char c : plainText.toCharArray()) {
            if (c < LOWER_RANGE || c > UPPER_RANGE) {
                return false;
            }
        }
        return true;
    }

    /**
     * Encrypts a string using the Caesar Cipher.
     * @param plainText an uppercase string to be encrypted.
     * @param key an integer specifying the offset for each character.
     * @return the encrypted string, or an error message if the input is out of bounds.
     */
    public static String caesarEncryption(String plainText, int key) {
        if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }
        
        StringBuilder encryptedText = new StringBuilder();
        
        // Normalize key to ensure it's within a reasonable range
        while (key > RANGE) {
            key -= RANGE;
        }
        
        for (char c : plainText.toCharArray()) {
            int charValue = c;
            int encryptedValue = charValue + key;
            
            // Wrap around if needed
            while (encryptedValue > UPPER_RANGE) {
                encryptedValue -= RANGE;
            }
            
            encryptedText.append((char) encryptedValue);
        }
        
        return encryptedText.toString();
    }

    /**
     * Decrypts a string encrypted using the Caesar Cipher.
     * @param encryptedText the encrypted string.
     * @param key the integer offset used for encryption.
     * @return the decrypted string, or an error message if the input is out of bounds.
     */
    public static String caesarDecryption(String encryptedText, int key) {
        if (!isStringInBounds(encryptedText)) {
            return "The selected string is not in bounds, Try again.";
        }
        
        StringBuilder decryptedText = new StringBuilder();
        
        // Normalize key to ensure it's within a reasonable range
        while (key > RANGE) {
            key -= RANGE;
        }
        
        for (char c : encryptedText.toCharArray()) {
            int charValue = c;
            int decryptedValue = charValue - key;
            
            // Wrap around if needed
            while (decryptedValue < LOWER_RANGE) {
                decryptedValue += RANGE;
            }
            
            decryptedText.append((char) decryptedValue);
        }
        
        return decryptedText.toString();
    }

    /**
     * Encrypts a string using the Bellaso Cipher.
     * @param plainText an uppercase string to be encrypted.
     * @param bellasoStr a string specifying the encryption key, repeated as needed.
     * @return the encrypted string, or an error message if the input is out of bounds.
     */
    public static String bellasoEncryption(String plainText, String bellasoStr) {
        if (!isStringInBounds(plainText)) {
            return "The selected string is not in bounds, Try again.";
        }
        
        StringBuilder encryptedText = new StringBuilder();
        
        for (int i = 0; i < plainText.length(); i++) {
            char plainChar = plainText.charAt(i);
            char keyChar = bellasoStr.charAt(i % bellasoStr.length());
            
            // Calculate the shift value based on the key character
            int shift = keyChar - LOWER_RANGE;
            
            // Calculate the new encrypted value
            int encryptedValue = plainChar + shift;
            
            // Wrap around if needed
            while (encryptedValue > UPPER_RANGE) {
                encryptedValue -= RANGE;
            }
            
            encryptedText.append((char) encryptedValue);
        }
        
        return encryptedText.toString();
    }

    /**
     * Decrypts a string encrypted using the Bellaso Cipher.
     * @param encryptedText the encrypted string.
     * @param bellasoStr the string key used for encryption.
     * @return the decrypted string, or an error message if the input is out of bounds.
     */
    public static String bellasoDecryption(String encryptedText, String bellasoStr) {
        if (!isStringInBounds(encryptedText)) {
            return "The selected string is not in bounds, Try again.";
        }
        
        StringBuilder decryptedText = new StringBuilder();
        
        for (int i = 0; i < encryptedText.length(); i++) {
            char encryptedChar = encryptedText.charAt(i);
            char keyChar = bellasoStr.charAt(i % bellasoStr.length());
            
            // Calculate the shift value based on the key character
            int shift = keyChar - LOWER_RANGE;
            
            // Calculate the new decrypted value
            int decryptedValue = encryptedChar - shift;
            
            // Wrap around if needed
            while (decryptedValue < LOWER_RANGE) {
                decryptedValue += RANGE;
            }
            
            decryptedText.append((char) decryptedValue);
        }
        
        return decryptedText.toString();
    }
}