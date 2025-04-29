import java.util.Scanner;

/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: Driver class that demonstrates the functionality of the Beverage Shop application
 * Due: 04/25/25
 * Platform/compiler: Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Abraham
*/
public class BevShopDriverApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop bevShop = new BevShop();
        
        System.out.println("Welcome to Bradley Beverage Shop!");
        System.out.println("The current order in process can have at most " + 
                          bevShop.getMaxOrderForAlcohol() + " alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is " + 
                          bevShop.getMinAgeForAlcohol());
        
        // First Order
        System.out.println("\nStart please a new order:");
        
        System.out.print("Would you please enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Would you please enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        bevShop.startNewOrder(10, Day.MONDAY, name, age);
        System.out.println("Your Total Order for now is " + 
                          bevShop.getCurrentOrder().calcOrderTotal());
        
        if (age >= bevShop.getMinAgeForAlcohol()) {
            System.out.println("Your age is above 20 and you are eligible to order alcohol");
            
            // First alcohol
            System.out.println("Would you please add an alcohol drink");
            bevShop.processAlcoholOrder("Mohito", Size.SMALL);
            System.out.println("The current order of drinks is " + 
                              bevShop.getCurrentOrder().getTotalItems());
            System.out.println("The Total price on the Order is " + 
                              bevShop.getCurrentOrder().calcOrderTotal());
            
            if (bevShop.isEligibleForMore()) {
                System.out.println("Your current alcohol drink order is less than 4");
                
                // Second alcohol
                System.out.println("Would you please add a second alcohol drink");
                bevShop.processAlcoholOrder("Wine", Size.MEDIUM);
                System.out.println("The current order of drinks is " + 
                                  bevShop.getCurrentOrder().getTotalItems());
                System.out.println("The Total Price on the Order: " + 
                                  bevShop.getCurrentOrder().calcOrderTotal());
                
                if (bevShop.isEligibleForMore()) {
                    System.out.println("Your current alcohol drink order is less than 4");
                    
                    // Third alcohol
                    System.out.println("Add third alcohol drink");
                    bevShop.processAlcoholOrder("Beer", Size.LARGE);
                    System.out.println("The current order of drinks is " + 
                                      bevShop.getCurrentOrder().getTotalItems());
                    System.out.println("The Total Price on the Order: " + 
                                      bevShop.getCurrentOrder().calcOrderTotal());
                    
                    if (!bevShop.isEligibleForMore()) {
                        System.out.println("You have a maximum alcohol drinks for this order");
                    }
                }
            }
        }
        
        // Add coffee to first order
        System.out.println("Would you please add a COFFEE to your order: ");
        bevShop.processCoffeeOrder("Regular Coffee", Size.MEDIUM, true, false);
        System.out.println("Total items on your order is " + 
                          bevShop.getCurrentOrder().getTotalItems());
        System.out.println("The Total Price on the Order: " + 
                          bevShop.getCurrentOrder().calcOrderTotal());
        
        // Second Order
        System.out.println("\n#------------------------------------#");
        System.out.println("Would you please start a new order");
        
        System.out.print("Would you please enter your name: ");
        name = scanner.nextLine();
        
        System.out.print("Would you please enter your age: ");
        age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        bevShop.startNewOrder(14, Day.SATURDAY, name, age);
        System.out.println("The Total Price on the Order: " + 
                          bevShop.getCurrentOrder().calcOrderTotal());
        
        // Add smoothie to second order
        System.out.println("Would you please add a SMOOTHIE to order");
        bevShop.processSmoothieOrder("Detox", Size.MEDIUM, 2, true);
        System.out.println("The Total Price on the Order: " + 
                          bevShop.getCurrentOrder().calcOrderTotal());
        
        // Add another smoothie
        System.out.println("Would you please add a SMOOTHIE to order");
        bevShop.processSmoothieOrder("Mango Smoothie", Size.LARGE, 3, false);
        
        // Add coffee
        System.out.println("Would you please add a COFFEE to order");
        bevShop.processCoffeeOrder("Cappuccino", Size.SMALL, true, true);
        System.out.println("The Total Price on the Order: " + 
                          bevShop.getCurrentOrder().calcOrderTotal());
        
        // Try to add alcohol for underage customer
        System.out.println("Would you please add a drink");
        if (!bevShop.isValidAge(age)) {
            System.out.println("Your Age is not appropriate for alcohol drink!!");
        } else {
            bevShop.processAlcoholOrder("Wine", Size.SMALL);
        }
        
        System.out.println("The current order of drinks is " + 
                          bevShop.getCurrentOrder().getTotalItems());
        System.out.println("The Total price on the Order: " + 
                          bevShop.getCurrentOrder().calcOrderTotal());
        
        // Check maximum fruits
        System.out.println("The total number of fruits is " + bevShop.getMaxNumOfFruits());
        if (bevShop.isMaxFruit(6)) {
            System.out.println("You reached a Maximum number of fruits");
        }
        
        // Final order information
        System.out.println("Total price on the second Order: " + 
                          bevShop.getCurrentOrder().calcOrderTotal());
        System.out.println("Total amount for all Orders: " + bevShop.totalMonthlySale());
        
        // Display all orders
        System.out.println("\nAll orders:");
        System.out.println(bevShop.toString());
        
        scanner.close();
        
        System.out.println("\nProgrammed by: [Your Name]");
    }
}