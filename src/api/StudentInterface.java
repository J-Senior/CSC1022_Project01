/**
 * Filename:        StudentInterface.java
 * Date:            2018/05/06
 * Name:            Senior J.J.
 * Student number:  160474257
 * -------------------------------------------------------
 * By submitting this file electronically, I declare that
 * it is my own original work, and that I have not copied
 * any part of it from another source.
 * -------------------------------------------------------
 * This interface defines the methods required by every
 * student.
 * -------------------------------------------------------
 */

package api;

import java.util.Date;

public interface StudentInterface {
    
    Name getName();
    
    Date getBirthDate();
    
    String getTypeOfStudent();
    
    StudentID getStudentID();
    
    int getMinAge();
    
    boolean isRegistered();
}
