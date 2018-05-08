/**
 * Filename:        Name.java
 * Date:            2018/05/06
 * Name:            Senior J.J.
 * Student number:  160474257
 * -------------------------------------------------------
 * By submitting this file electronically, I declare that
 * it is my own original work, and that I have not copied
 * any part of it from another source.
 * -------------------------------------------------------
 * This class simply manages names, combining first name
 * and last name into a single entity while allowing them
 * to be separately managed.
 * -------------------------------------------------------
 */

package api;

public class Name {
    
    private String firstName;
    private String lastName;
    
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    String getFirstName() {
        return firstName;
    }
    
    void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    String getLastName() {
        return lastName;
    }
    
    void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
    
    static Name fromFile(String line) {                             // Creates Name from single String. Used to read supervisors from file
        String[] splitName = line.split(",");                       // Splits String at comma
        return new Name(splitName[0].trim(), splitName[1].trim());  // Removes whitespace and returns properly formatted Name
    }
}
