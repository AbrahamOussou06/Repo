import java.util.Scanner;

/**
 * CMSC203 Lab 1
 * Professor: Ahmed Tarek
 * Abraham Ouattara
 * MovieDriver class to test the Movie class functionality
 * This version implements Task 1 - processing a single movie
 */
public class MovieDriver_Task1 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        Movie movie = new Movie();
        
        System.out.println("Enter the name of a movie");
        String title = keyboard.nextLine();
        
        movie.setTitle(title);
        
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
        
        // Close the scanner
        keyboard.close();
    }
}