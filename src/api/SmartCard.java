/**
 * Filename:        SmartCard.java
 * Date:            2018/05/06
 * Name:            Senior J.J.
 * Student number:  160474257
 * -------------------------------------------------------
 * By submitting this file electronically, I declare that
 * it is my own original work, and that I have not copied
 * any part of it from another source.
 * -------------------------------------------------------
 * This class generates a smart card for a student and
 * provides methods to access the student's data using
 * a smart card number.
 * -------------------------------------------------------
 */

package api;

import java.util.*;

public class SmartCard {
    
    private Name            name;
    private Date            birthDate;
    private SmartCardNumber cardNumber;
    private Date            dateOfIssue;
    private StudentID       studentID;
    
    SmartCard(Student student, SmartCardNumber newSmartCardNumber) {
        
        this.name = student.getName();
        this.birthDate = student.getBirthDate();
        this.cardNumber = newSmartCardNumber.getSmartCardNumber(student.getName());
        this.dateOfIssue = currentDate();
        this.studentID = student.getStudentID();
    }
    
    Date currentDate() {
        Date date = new Date();
        return date;
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
    
    public SmartCardNumber getCardNumber() {
        return cardNumber;
    }
    
    void setCardNumber(SmartCardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    public StudentID getStudentID() {
        return studentID;
    }
    
    void setStudentID(StudentID studentID) {
        this.studentID = studentID;
    }
    
    public Date getDateOfIssue() {
        return dateOfIssue;
    }
    
    void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }
    
    @Override
    public String toString() {
        return cardNumber.toString();
    }
}
