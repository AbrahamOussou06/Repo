/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: Class representing a customer with name and age attributes
 * Due: 04/25/25
 * Platform/compiler: Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Abraham
*/
public class Customer {
    private String name;
    private int age;
    
    /**
     * Constructor for Customer
     * @param name customer name
     * @param age customer age
     */
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    /**
     * Copy constructor for Customer
     * @param customer customer to copy
     */
    public Customer(Customer customer) {
        this.name = customer.getName();
        this.age = customer.getAge();
    }
    
    /**
     * String representation of the customer
     * @return string with customer information
     */
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
    
    /**
     * Gets the customer name
     * @return name of the customer
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the customer name
     * @param name new name for the customer
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets the customer age
     * @return age of the customer
     */
    public int getAge() {
        return age;
    }
    
    /**
     * Sets the customer age
     * @param age new age for the customer
     */
    public void setAge(int age) {
        this.age = age;
    }
}