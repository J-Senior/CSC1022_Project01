/**
 * Filename:        SmartCardNumber.java
 * Date:            2018/05/06
 * Name:            Senior J.J.
 * Student number:  160474257
 * -------------------------------------------------------
 * By submitting this file electronically, I declare that
 * it is my own original work, and that I have not copied
 * any part of it from another source.
 * -------------------------------------------------------
 * This class generates a unique card number when called.
 * The number is made up of the student's initials, the
 * year of registration, and a serial number to guarantee
 * uniqueness.
 * -------------------------------------------------------
 */

package api;

import java.util.*;

public class SmartCardNumber {
    
    private String       smartCardNumber;
    private List<String> cardPrefixList = new ArrayList<String>();                  // Stores used prefixes to prevent duplicates
    
    private SmartCardNumber(String smartCardNumber) {
        this.smartCardNumber = smartCardNumber;
    }
    
    SmartCardNumber() {
        
    }
    
    SmartCardNumber getSmartCardNumber(Name name) {                                 // Generates a unique card number when given a name
        
        String initials = getInitials(name);
        Calendar currentDate = Calendar.getInstance();
        int year = currentDate.get(Calendar.YEAR);
        
        String prefix = initials + "-" + year + "-";
        cardPrefixList.add(prefix);
        String serialNumber = String.format("%02d", setSerialNumber(prefix));       // Saves the serial number as a two digit string
        String newCardNumber = prefix + serialNumber;
        
        return new SmartCardNumber(newCardNumber);
    }
    
    String getInitials(Name name) {                                                 // Returns String of initials from Name
        return (name.getFirstName().substring(0, 1) + name.getLastName().substring(0, 1));
    }
    
    int setSerialNumber(String prefix) {                                            // Counts number of identical prefixes already used
        int serialNumber = Collections.frequency(cardPrefixList, prefix) - 1;
        return serialNumber;
    }
    
    @Override
    public String toString() {
        return smartCardNumber;
    }
}
