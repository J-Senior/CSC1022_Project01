/**
 * Filename:        Taught.java
 * Date:            2018/05/06
 * Name:            Senior J.J.
 * Student number:  160474257
 * -------------------------------------------------------
 * By submitting this file electronically, I declare that
 * it is my own original work, and that I have not copied
 * any part of it from another source.
 * -------------------------------------------------------
 * The taught class extends student to create a taught
 * student, aka a student who is registered for modules.
 * -------------------------------------------------------
 */

package api;

import java.util.*;

public class Taught extends Student {
    
    private int                     requiredCredits = 0;
    private int                     passPercentage  = 0;
    private HashMap<String, Module> studentModules  = new HashMap<String, Module>();
    
    Taught(Name name, Date birthDate) {
        super(name, birthDate);
    }
    
    int getStudentCredits() {                                       // Calculates the total credits of a student's registered modules
        int studentCredits = 0;
        for (Module currentModule : studentModules.values()) {
            studentCredits += currentModule.getModuleCredits();
        }
        return studentCredits;
    }
    
    int getRequiredCredits() {
        return requiredCredits;
    }
    
    public void setRequiredCredits(int requiredCredits) {
        this.requiredCredits = requiredCredits;
    }
    
    int getPassPercentage() {
        return passPercentage;
    }
    
    void setPassPercentage(int passPercentage) {
        this.passPercentage = passPercentage;
    }
    
    public HashMap<String, Module> getStudentModules() {
        return studentModules;
    }
    
    public void addStudentModule(String moduleCode) {               // Given a module code as a String, adds module to Student
        Module module = new Module(moduleCode);
        this.studentModules.put(moduleCode, module);
    }
    
    public void removeStudentModule(String moduleCode) {            // Given a module code as a String, removes module from Student
        this.studentModules.remove(moduleCode);
    }
    
    @Override
    public boolean isRegistered() {                                 // Checks that Student has required credit amount and a smart card
        int studentCredits = 0;
        
        if (this.getStudentSmartCardNumber() != null) {
            for (Module module : studentModules.values()) {
                studentCredits += module.getModuleCredits();
            }
            return studentCredits == getRequiredCredits();
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {                                      // Adds module details to Student print output
        
        StringBuilder sbuf = new StringBuilder(super.toString());
        
        sbuf.append("\nRequired Credits:       ").append(getRequiredCredits());
        sbuf.append("\nStudent Credits:        ").append(getStudentCredits());
        sbuf.append("\nPass Percentage:        ").append(getPassPercentage());
        sbuf.append("\nModules:                ");
        
        if (studentModules.isEmpty()) {
            sbuf.append("\n  -Student Has No Modules");
        } else {
            for (Module currentModule : studentModules.values()) {
                sbuf.append("\n  -").append(currentModule);
            }
        }
        
        return sbuf.toString();
    }
}
