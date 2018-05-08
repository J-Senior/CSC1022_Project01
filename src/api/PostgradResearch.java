/**
 * Filename: PostgradResearch.java
 * Date: 2018/05/06
 * Name: Senior J.J.
 * Student number: 160474257
 * -------------------------------------------------------
 * By submitting this file electronically, I declare that
 * it is my own original work, and that I have not copied
 * any part of it from another source.
 * -------------------------------------------------------
 * This class defines postgraduate research students.
 * These students are not registered to modules but do
 * have a personal supervisor assigned. Supervisors are
 * read from a csv file using format:
 * first name, last name
 * -------------------------------------------------------
 */

package api;

import java.io.FileReader;
import java.util.Date;
import java.util.Scanner;

public class PostgradResearch extends Student {
    
    private Name supervisor = null;
    
    public PostgradResearch(Name name, Date birthDate) {
        super(name, birthDate);
        this.typeOfStudent = "Postgraduate Research";
        this.supervisor = assignSupervisor();
    }
    
    Name assignSupervisor() {                                           // Assigns a supervisor to a postgraduate research student
        
        Name newSupervisor = null;
        
        try {
            
            Scanner fileReader = new Scanner(new FileReader("src/api/supervisors.csv"));
            
            for (int i = 0; i < UniTools.supervisorCounter; i++) {      // Scrolls to line in supervisor file
                fileReader.nextLine();
            }
            newSupervisor = Name.fromFile(fileReader.nextLine());       // Reads Name of supervisor using method in Name class
            fileReader.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (UniTools.supervisorCounter < 5) {                           // Increments supervisorCount to evenly spread students
            UniTools.supervisorCounter++;
        } else {
            UniTools.supervisorCounter = 0;
        }
        
        return newSupervisor;
    }
    
    public Name getSupervisor() {
        return supervisor;
    }
    
    void setSupervisor(Name supervisor) {
        this.supervisor = supervisor;
    }
    
    @Override
    public final String getTypeOfStudent() {
        return ("Postgraduate Research");
    }
    
    @Override
    public final int getMinAge() {
        return 20;
    }
    
    @Override
    public boolean isRegistered() {
        if (this.getStudentSmartCardNumber() != null) {
            return (supervisor != null);
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {                                          // Adds supervisor name to Student print output
        
        StringBuilder sbuf = new StringBuilder(super.toString());
        String supervisorCheck;
        
        if (supervisor == null) {
            supervisorCheck = "No Supervisor Assigned";
        } else {
            supervisorCheck = supervisor.toString();
        }
        
        sbuf.append("\nSupervisor:             ").append(supervisorCheck);
        
        return sbuf.toString();
    }
    
}
