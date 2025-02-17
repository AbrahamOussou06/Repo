/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: A program that tests ESP (extrasensory perception) by having users
 *              guess colors randomly selected by the computer
 * Due: 02/17/25
 * Platform/compiler: Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Abraham Ouattara
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class ESPGame {
    public static void main(String[] args) {
        // Create scanner for user input
        Scanner keyboard = new Scanner(System.in);
        
        // Variables we'll need
        String userName = "";
        String userDescription = "";
        String dueDate = "";
        int score = 0;
        String keepPlaying = "yes";
        
        // Print welcome message
        System.out.println("CMSC203 Assignment1: Test your ESP skills!");
        System.out.println("Welcome to ESP - extrasensory perception!");
        
        // Main game loop
        while(keepPlaying.equalsIgnoreCase("yes")) {
            // Show menu
            System.out.println("\nWould you please choose one of the 4 options from the menu:");
            System.out.println("1. read and display on the screen first 16 names of colors");
            System.out.println("2. read and display on the screen first 10 names of colors");
            System.out.println("3. read and display on the screen first 5 names of colors");
            System.out.println("4. Exit from a program");
            
            System.out.print("Enter the option: ");
            int choice = keyboard.nextInt();
            keyboard.nextLine(); // clear the newline
            
            // Handle menu choice
            if(choice == 4) {
                // Get user info before exiting
                System.out.print("Enter your name: ");
                userName = keyboard.nextLine();
                
                System.out.print("Describe yourself: ");
                userDescription = keyboard.nextLine();
                
                System.out.print("Due Date: ");
                dueDate = keyboard.nextLine();
                
                // Print final info
                System.out.println("\nUsername: " + userName);
                System.out.println("User Description: " + userDescription);
                System.out.println("Date: " + dueDate);
                
                // Save to file
                try {
                    FileWriter writer = new FileWriter("EspGameResults.txt");
                    writer.write("Game Over\n");
                    writer.write("Due Date: " + dueDate + "\n");
                    writer.write("Username: " + userName + "\n");
                    writer.write("User Description: " + userDescription + "\n");
                    writer.write("Date: " + dueDate + "\n");
                    writer.close();
                } catch(Exception e) {
                    System.out.println("Error writing to file");
                }
                break;
            }
            
            // Get number of colors based on choice
            int numColors = 16;
            if(choice == 2) {
                numColors = 10;
            }
            if(choice == 3) {
                numColors = 5;
            }
            
            // Read and show colors
            try {
                Scanner fileScanner = new Scanner(new File("colors.txt"));
                System.out.println("\nThere are " + numColors + " colors from a file:");
                
                // Print colors with numbers
                for(int i = 1; i <= numColors; i++) {
                    if(fileScanner.hasNextLine()) {
                        System.out.println(i + " " + fileScanner.nextLine());
                    }
                }
                fileScanner.close();
                
                // Play 3 rounds
                score = 0;
                Random rand = new Random();
                
                for(int round = 1; round <= 3; round++) {
                    System.out.println("\nRound " + round);
                    System.out.println("I am thinking of a color.");
                    System.out.println("Is it one of list of colors above?");
                    
                    // Pick random color
                    fileScanner = new Scanner(new File("colors.txt"));
                    int randomNum = rand.nextInt(numColors) + 1;
                    String computerColor = "";
                    for(int i = 1; i <= randomNum; i++) {
                        computerColor = fileScanner.nextLine();
                    }
                    fileScanner.close();
                    
                    // Get user guess
                    System.out.print("Enter your guess: ");
                    String userGuess = keyboard.nextLine();
                    
                    System.out.println("I was thinking of " + computerColor);
                    
                    // Check if correct
                    if(userGuess.equalsIgnoreCase(computerColor)) {
                        score++;
                    }
                }
                
                // Show results
                System.out.println("Game Over");
                System.out.println("You guessed " + score + " out of 3 colors correctly.");
                
                // Ask to play again
                System.out.println("Would you like to continue a Game? Type Yes/No");
                keepPlaying = keyboard.nextLine();
                
            } catch(Exception e) {
                System.out.println("Error reading file");
            }
        }
        
        keyboard.close();
    }
}