/*
 * Class: CMSC203 CRN 30312
 * Instructor: Ahmed Tarek
 * Description: Procedure class that represents a medical procedure performed on a patient
 * Due: 02/24/25
 * Platform/compiler: Java/Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Abraham Ouattara
 */

public class Procedure {
    // Procedure attributes
    private String name;
    private String date;
    private String practitioner;
    private double charges;

    // No-arg constructor
    public Procedure() {
        name = date = practitioner = "";
        charges = 0.0;
    }

    // Constructor with name and date
    public Procedure(String name, String date) {
        this.name = name;
        this.date = date;
        practitioner = "";
        charges = 0.0;
    }

    // Constructor with all parameters
    public Procedure(String name, String date, String practitioner, double charges) {
        this.name = name;
        this.date = date;
        this.practitioner = practitioner;
        this.charges = charges;
    }

    // Getters
    public String getName() { return name; }
    public String getDate() { return date; }
    public String getPractitioner() { return practitioner; }
    public double getCharges() { return charges; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setDate(String date) { this.date = date; }
    public void setPractitioner(String practitioner) { this.practitioner = practitioner; }
    public void setCharges(double charges) { this.charges = charges; }

    // toString method
    @Override
    public String toString() {
        return "\n   Procedure: " + name + "\n" +
               "   ProcedureDate=" + date + "\n" +
               "   Practitioner=" + practitioner + "\n" +
               "   Charge=" + charges;
    }
}