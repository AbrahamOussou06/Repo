/*
 * Class: CMSC203 CRN 30312
 * Instructor: Ahmed Tarek
 * Description: Patient class that stores and manages patient information
 * Due: 02/24/25
 * Platform/compiler: Java/Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Abraham Ouattara
 */

public class Patient {
    // Patient attributes
    private String firstName;
    private String middleName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String emergencyName;
    private String emergencyPhone;

    // No-arg constructor
    public Patient() {
        firstName = middleName = lastName = "";
        streetAddress = city = state = zipCode = "";
        phoneNumber = "";
        emergencyName = emergencyPhone = "";
    }

    // Constructor with name parameters
    public Patient(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        streetAddress = city = state = zipCode = "";
        phoneNumber = "";
        emergencyName = emergencyPhone = "";
    }

    // Constructor with all parameters
    public Patient(String firstName, String middleName, String lastName,
                  String streetAddress, String city, String state, String zipCode,
                  String phoneNumber, String emergencyName, String emergencyPhone) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.emergencyName = emergencyName;
        this.emergencyPhone = emergencyPhone;
    }

    // Getters and setters
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }
    public String getStreetAddress() { return streetAddress; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZipCode() { return zipCode; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmergencyName() { return emergencyName; }
    public String getEmergencyPhone() { return emergencyPhone; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmergencyName(String emergencyName) { this.emergencyName = emergencyName; }
    public void setEmergencyPhone(String emergencyPhone) { this.emergencyPhone = emergencyPhone; }

    // Build methods
    public String buildFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    public String buildAddress() {
        return streetAddress + " " + city + " " + state + " " + zipCode;
    }

    public String buildEmergencyContact() {
        return emergencyName + " " + emergencyPhone;
    }

    // toString method
    @Override
    public String toString() {
        return "Patient info:\n" +
               "   Name: " + buildFullName() + "\n" +
               "   Address: " + buildAddress() + "\n" +
               "   EmergencyContact: " + buildEmergencyContact() + "\n";
    }
}