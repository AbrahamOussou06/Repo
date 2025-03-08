import java.util.Scanner;

/**
 * CMSC203 Lab 1
 * Professor: Ahmed Tarek
 * Abraham Ouattara
 * MovieDriver class to test the Movie class functionality
 * This version implements Task 2 - processing multiple movies
 */
public class MovieDriver_Task2 {

    public static void main(String[] args) {
        // Create a new object of type Scanner that reads from the keyboard
        Scanner keyboard = new Scanner(System.in);
        
        char continueChoice = 'y';
        
        while (continueChoice == 'y' || continueChoice == 'Y') {
            // Create a new movie object
            Movie movie = new Movie();
            
            // Prompt the user to enter the title of a movie
            System.out.println("Enter the name of a movie");
            
            // Read in the line that the user types
            String title = keyboard.nextLine();
            
            // Set the title in the movie object
            movie.setTitle(title);
            
            // Prompt the user to enter the movie's rating
            System.out.println("Enter the rating of the movie");
            
            // Read in the line that the user types
            String rating = keyboard.nextLine();
            
            // Set the rating in the movie object
            movie.setRating(rating);
            
            // Prompt the user to enter the number of tickets sold
            System.out.println("Enter the number of tickets sold for this movie");
            
            // Read in the integer that the user types
            int ticketsSold = keyboard.nextInt();
            
            // Set the number of tickets sold in the movie object
            movie.setSoldTickets(ticketsSold);
            
            // Print out the information using the movie's toString method
            System.out.println(movie.toString());
            
            // Consume the newline character after reading the integer
            keyboard.nextLine();
            
            // Ask if the user wants to continue
            System.out.println("Do you want to enter another? (y or n)");
            String answer = keyboard.nextLine();
            continueChoice = answer.charAt(0);
        }
        
        System.out.println("Goodbye");
        
        // Close the scanner
        keyboard.close();
    }
}