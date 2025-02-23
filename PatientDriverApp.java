/*
 * Class: CMSC203 CRN 30312
 * Instructor: Ahmed Tarek
 * Description: Driver class that demonstrates the functionality of Patient and Procedure classes
 * Due: 02/24/25
 * Platform/compiler: Java/Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Abraham Ouattara
 */

import java.util.Scanner;

public class PatientDriverApp {
    
    public static void displayPatient(Patient patient) {
        System.out.print(patient.toString());
    }

    public static void displayProcedure(Procedure procedure) {
        System.out.print(procedure.toString());
    }

    public static double calculateTotalCharges(Procedure proc1, Procedure proc2, Procedure proc3) {
        return proc1.getCharges() + proc2.getCharges() + proc3.getCharges();
    }

    public static Patient getPatientInformation(Scanner input) {
        System.out.println("Enter Patient Information:");
        
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        
        System.out.print("Enter middle name: ");
        String middleName = input.nextLine();
        
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        
        System.out.print("Enter street address: ");
        String streetAddress = input.nextLine();
        
        System.out.print("Enter city: ");
        String city = input.nextLine();
        
        System.out.print("Enter state (e.g., MD): ");
        String state = input.nextLine();
        
        System.out.print("Enter ZIP code: ");
        String zipCode = input.nextLine();
        
        System.out.print("Enter phone number (XXX-XXX-XXXX): ");
        String phoneNumber = input.nextLine();
        
        System.out.print("Enter emergency contact name: ");
        String emergencyName = input.nextLine();
        
        System.out.print("Enter emergency contact phone (XXX-XXX-XXXX): ");
        String emergencyPhone = input.nextLine();
        
        return new Patient(firstName, middleName, lastName, streetAddress, city, 
                         state, zipCode, phoneNumber, emergencyName, emergencyPhone);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Get patient information from keyboard
        Patient patient = getPatientInformation(input);

        // Create procedures using different constructors
        Procedure proc1 = new Procedure();  // Using no-arg constructor
        proc1.setName("Physical Exam");
        proc1.setDate("7/20/2019");
        proc1.setPractitioner("Dr. Irvine");
        proc1.setCharges(3250.0);

        Procedure proc2 = new Procedure("X-ray", "7/20/2019");  // Using name/date constructor
        proc2.setPractitioner("Dr. Jamison");
        proc2.setCharges(5500.43);

        Procedure proc3 = new Procedure("Blood Test", "7/20/2019", "Dr. Smith", 1400.75);  // Using all-parameter constructor

        // Display all information
        displayPatient(patient);
        displayProcedure(proc1);
        displayProcedure(proc2);
        displayProcedure(proc3);

        // Calculate and display total charges
        double totalCharges = calculateTotalCharges(proc1, proc2, proc3);
        System.out.printf("\nTotal Charges: $%,.2f\n", totalCharges);

        // Display student information
        System.out.println("\nStudent Name: Abraham Ouattara");
        System.out.println("MC#: [Your MC number]");
        System.out.println("Due Date: 02/24/25");
        
        input.close();
    }
}