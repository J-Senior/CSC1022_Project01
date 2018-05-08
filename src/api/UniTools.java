/**
 * Filename:        UniTools.java
 * Date:            2018/05/06
 * Name:            Senior J.J.
 * Student number:  160474257
 * -------------------------------------------------------
 * By submitting this file electronically, I declare that
 * it is my own original work, and that I have not copied
 * any part of it from another source.
 * -------------------------------------------------------
 * This class provides the methods to be used when
 * managing students.
 * -------------------------------------------------------
 */

package api;

import java.util.*;

public class UniTools {
    
    static Map<StudentID, Student>   studentMap         = new HashMap<StudentID, Student>();        // A map linking student IDs to their data
    static Map<StudentID, SmartCard> smartCardMap       = new HashMap<StudentID, SmartCard>();      // A map linking student IDs to their smart card
    StudentID                        newID              = new StudentID();                          // Creates a new ID, allowing use of StudentID methods
    SmartCardNumber                  newSmartCardNumber = new SmartCardNumber();                    // Creates a new SmartCardNumber, allowing use of SmartCardNumber methods
    static int                       supervisorCounter  = 0;                                        // Counts the number of supervisors allocated to research students
    
    public int noOfStudents(String typeOfStudent) {                                                 // Returns the number of a type of student
        
        int counter = 0;
        
        for (Student currentStudent : studentMap.values()) {                                        // Loops through studentMap inserting Student objects to currentStudent
            if (currentStudent.getTypeOfStudent().equalsIgnoreCase(typeOfStudent)) {                // Compares type of current student to requested type
                counter++;
            }
        }
        return counter;
    }
    
    public SmartCard registerStudent(Student newStudent) {                                          // Receives Name, DoB, typeOfStudent and assigns an ID and smart card
        
        int age = checkAge(newStudent);                                                             // Calculates age of newStudent
        
        if (age < newStudent.getMinAge()) {                                                         // If student is too young, throw exception
            throw new IllegalArgumentException();
        }
        
        newStudent.setStudentID(newID.generateNewID());                                             // Generates unique and allocates it to newStudent
        SmartCard newCard = new SmartCard(newStudent, newSmartCardNumber);                          // Creates smart card for newStudent
        newStudent.setStudentSmartCardNumber(newCard.getCardNumber());                              // Generates unique smart card number for newStudent
        
        studentMap.put(newStudent.getStudentID(), newStudent);                                      // Inserts student ID and student data into map
        smartCardMap.put(newStudent.getStudentID(), newCard);                                       // Inserts student ID and student smart card into map
        return newCard;                                                                             // Returns smart card. Can be used to print smartCardNumber
    }
    
    private int checkAge(Student newStudent) {                                                      // Calculates student age. Credit to
                                                                                                    // https://www.quickprogrammingtips.com/java/how-to-calculate-age-from-date-of-birth-in-java.html
        
        Calendar dob = Calendar.getInstance();                                                      // Gets instance of calendar to use day, month, year
        dob.setTime(newStudent.getBirthDate());                                                     // Sets calendar to student birth date
        Calendar currentDate = Calendar.getInstance();                                              // Gets current date
        int studentAge = currentDate.get(Calendar.YEAR) - dob.get(Calendar.YEAR);                   // Gets student age to nearest year
        
        if (dob.get(Calendar.MONTH) > (currentDate.get(Calendar.MONTH))) {                          // Checks current month against student birth month
            studentAge--;
        } else if (dob.get(Calendar.MONTH) == (currentDate.get(Calendar.MONTH))) {                  // Checks current month against student birth month
            if (dob.get(Calendar.DAY_OF_MONTH) > (currentDate.get(Calendar.DAY_OF_MONTH))) {        // Checks current day against student birth day
                studentAge--;
            }
        }
        return studentAge;
    }
    
    public void amendStudentData(StudentID studentID, Student student) {                            // Edits student data attached to an ID
        
        if (!studentMap.containsKey(studentID)) {                                                   // Throws exception if ID does not exist
            throw new IllegalArgumentException();
        }
        studentMap.put(studentID, student);                                                         // Replaces student data attached to current ID
    }
    
    public void terminateStudent(StudentID studentID) {                                             // Removes the student attached to an ID
        
        if (!studentMap.containsKey(studentID)) {                                                   // Throws exception if ID does not exist
            throw new IllegalArgumentException();
        }
        studentMap.remove(studentID);                                                               // Removes student from studentMap
        smartCardMap.remove(studentID);                                                             // Removes smart card from smartCardMap
    }
    
    public Student getStudent(StudentID studentID) {                                                // Not in spec, used for testing. Displays student data
        /*
         * if(!studentMap.containsKey(studentID)) { throw new
         * IllegalArgumentException(); }
         */
        return studentMap.get(studentID);
    }
    
    public SmartCard getSmartCard(StudentID studentID) {                                            // Not in spec, used for testing. Displays smart card number
        /*
         * if(!studentMap.containsKey(studentID)) { throw new
         * IllegalArgumentException(); }
         */
        return smartCardMap.get(studentID);
    }
}
