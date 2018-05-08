/**
 * Filename:        BirthDate.java
 * Date:            2018/05/06
 * Name:            Senior J.J.
 * Student number:  160474257
 * -------------------------------------------------------
 * By submitting this file electronically, I declare that
 * it is my own original work, and that I have not copied
 * any part of it from another source.
 * -------------------------------------------------------
 * This class stores and manages student birth dates
 * using the java Date class. It is also used to calculate
 * the age of students.
 * -------------------------------------------------------
 */

package api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BirthDate {
    
    private Date birthDate;
    
    BirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    Date getBirthDate() {
        return birthDate;
    }
    
    void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    int calculateAge(Date birthDate) {              // Duplicate of checkAge in UniTools. Use when getting age for Date
        
        Calendar dob = Calendar.getInstance();
        dob.setTime(birthDate);
        Calendar currentDate = Calendar.getInstance();
        int studentAge = currentDate.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        
        if (dob.get(Calendar.MONTH) > (currentDate.get(Calendar.MONTH))) {
            studentAge--;
        } else if (dob.get(Calendar.MONTH) == (currentDate.get(Calendar.MONTH))) {
            if (dob.get(Calendar.DAY_OF_MONTH) > (currentDate.get(Calendar.DAY_OF_MONTH))) {
                studentAge--;
            }
        }
        return studentAge;
    }
    
    public static Date readDate(String date) {      // Converts a String to a Date
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
    
    @Override
    public String toString() {                      // Defines format of Date print output in format "dd/MM/yyyy"
        Calendar dob = Calendar.getInstance();
        dob.setTime(birthDate);
        
        return String.format("%d/%02d/%02d", dob.get(Calendar.YEAR), dob.get(Calendar.MONTH) + 1,
                dob.get(Calendar.DAY_OF_MONTH));
    }
}
