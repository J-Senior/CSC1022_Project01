/**
 * Filename:        Student.java
 * Date:            2018/05/06
 * Name:            Senior J.J.
 * Student number:  160474257
 * -------------------------------------------------------
 * By submitting this file electronically, I declare that
 * it is my own original work, and that I have not copied
 * any part of it from another source.
 * -------------------------------------------------------
 * This class defines students and provides methods to
 * access and edit their data. It is the base student
 * type and provides the base of outputting students as
 * a string.
 * -------------------------------------------------------
 */

package api;

import java.text.SimpleDateFormat;
import java.util.*;

public abstract class Student implements StudentInterface {
    
    private Name            name;
    private Date            birthDate;
    protected String        typeOfStudent;
    private StudentID       studentID;
    private int             minAge = 0;
    private SmartCardNumber studentSmartCardNumber;
    
    Student(Name name, Date birthDate) {
        this.setName(name);
        this.setBirthDate(birthDate);
    }
    
    Student(Name name, Date birthDate, String typeOfStudent, StudentID studentID) {
        this.setName(name);
        this.setBirthDate(birthDate);
        this.setTypeOfStudent(typeOfStudent);
        this.setStudentID(studentID);
    }
    
    public Name getName() {
        return name;
    }
    
    void setName(Name name) {
        this.name = name;
    }
    
    public Date getBirthDate() {
        return birthDate;
    }
    
    void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    public String getTypeOfStudent() {
        return typeOfStudent;
    }
    
    void setTypeOfStudent(String typeOfStudent) {
        this.typeOfStudent = typeOfStudent;
    }
    
    public StudentID getStudentID() {
        return studentID;
    }
    
    void setStudentID(StudentID studentID) {
        this.studentID = studentID;
    }
    
    public int getMinAge() {
        return minAge;
    }
    
    SmartCardNumber getStudentSmartCardNumber() {
        return studentSmartCardNumber;
    }
    
    void setStudentSmartCardNumber(SmartCardNumber studentSmartCardNumber) {
        this.studentSmartCardNumber = studentSmartCardNumber;
    }
    
    @Override
    public String toString() {                                      // Base of formatted print for students. Added to by various classes
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // Used to format dates
        StringBuilder sbuf = new StringBuilder();                   // https://dzone.com/articles/java-string-format-examples
        String idCheck, registeredCheck, cardNumberCheck;
        
        if (studentID == null) {
            idCheck = "No ID Assigned";
        } else {
            idCheck = studentID.toString();
        }
        
        if (isRegistered()) {
            registeredCheck = "Correctly Registered";
        } else {
            registeredCheck = "Incorrectly Registered";
        }
        
        if (studentSmartCardNumber == null) {
            cardNumberCheck = "Student Has Not Been Assigned A Card";
        } else {
            cardNumberCheck = studentSmartCardNumber.toString();
        }
        
        sbuf.append("\nStudent Name:           ").append(name);
        sbuf.append("\nStudent Birth Date:     ").append(sdf.format(birthDate));
        sbuf.append("\nStudent Type:           ").append(typeOfStudent);
        sbuf.append("\nStudent ID:             ").append(idCheck);
        sbuf.append("\nStudent Card Number:    ").append(cardNumberCheck);
        sbuf.append("\nRegistration Status:    ").append(registeredCheck);
        
        return sbuf.toString();
    }
}
