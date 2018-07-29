/**
 * Filename:        Test.java
 * Date:            2018/05/06
 * Name:            Senior J.J.
 * Student number:  160474257
 * -------------------------------------------------------
 * By submitting this file electronically, I declare that
 * it is my own original work, and that I have not copied
 * any part of it from another source.
 * -------------------------------------------------------
 * This class is used to test the classes and methods
 * of the student support system.
 * Please note that Dr Speirs has excused the ECE
 * students from JUnit testing as we are not registered
 * for that module.
 * -------------------------------------------------------
 */

package testing;

import java.util.Date;

import api.*;
import api.Module;

public class Test {
    
    public static void main(String[] args) {
        
        UniTools tools = new UniTools();
        
        Name name1 = new Name("James", "Bond");
        Date birthDate1 = BirthDate.readDate("1995-11-05");
        Student newStudent1 = new PostgradTaught(name1, birthDate1);
        
        System.out.println("\nUnregistered student:\n" + newStudent1);
        
        tools.registerStudent(newStudent1);
        
        System.out.println("\nIncorrectly registered student:\n" + newStudent1);
        
        ((Taught) newStudent1).addStudentModule("CSC2024");
        ((Taught) newStudent1).addStudentModule("ENG2001");
        ((Taught) newStudent1).addStudentModule("EEE3007");
        ((Taught) newStudent1).addStudentModule("EEE3015");
        ((Taught) newStudent1).addStudentModule("EEE3096");
        ((Taught) newStudent1).addStudentModule("CSC3124");
        
        System.out.println("\nRequires more credits:\n" + newStudent1);
        
        ((Taught) newStudent1).addStudentModule("EEE3097");
        ((Taught) newStudent1).addStudentModule("EEE3095");
        
        System.out.println("\nCorrectly registered student:\n" + newStudent1);
        
        ((Taught) newStudent1).removeStudentModule("EEE3096");
        
        System.out.println("\nRequires more credits:\n" + newStudent1);
        
        System.out.println("\nStudent ID public access test: " + newStudent1.getStudentID());
        System.out.println("\n---------------------------------------------------------------------------------");
        
        // ---------------------------------------------------------------------------------
        
        Name name3 = new Name("Josiah", "Senior");
        Date birthDate3 = BirthDate.readDate("1996-09-05");
        Student newStudent3 = new Undergrad(name3, birthDate3);
        
        tools.registerStudent(newStudent3);         // Comment out to check registration status for unassigned smart card
        
        System.out.println("\nUndergraduate registration test:\n" + newStudent3);
        System.out.println("\n---------------------------------------------------------------------------------");
        
        // ---------------------------------------------------------------------------------
        
        ((Taught) newStudent3).addStudentModule("CSC1021");
        ((Taught) newStudent3).addStudentModule("CSC1022");
        ((Taught) newStudent3).addStudentModule("ENG1001");
        ((Taught) newStudent3).addStudentModule("EEE1005");
        ((Taught) newStudent3).addStudentModule("EEE1003");
        ((Taught) newStudent3).addStudentModule("EEE1010");
        System.out.println("\nUndergraduate registration test:\n" + newStudent3);
        System.out.println("\nStudent modules public access test: ");
        for (Module module : ((Taught) newStudent3).getStudentModules().values()) {
            System.out.println(module);
        }
        System.out.println("\n---------------------------------------------------------------------------------");
        
        // ---------------------------------------------------------------------------------
        
        Name name2 = new Name("Jack", "Brown");
        Date birthDate2 = BirthDate.readDate("1997-08-03");
        Student newStudent2 = new PostgradResearch(name2, birthDate2);
        
        SmartCard sc2 = tools.registerStudent(newStudent2);
        
        System.out.println("\nPostgraduate research registration test (note card number serial):\n" + newStudent2);
        System.out.println("\nSupervisor public access test: " + ((PostgradResearch) newStudent2).getSupervisor());
        System.out.println("\n---------------------------------------------------------------------------------");
        
        // ---------------------------------------------------------------------------------
        
        Name name4 = new Name("Stevie", "Wonder");
        Date birthDate4 = BirthDate.readDate("1950-05-13");
        Student newStudent4 = new PostgradTaught(name4, birthDate4);
        
        SmartCard sc4 = tools.registerStudent(newStudent4);
        
        System.out.println("\nPostgraduate taught registration test:\n" + newStudent4);
        
        System.out.println("\nSmartCard access test:");
        System.out.println("Card Number: " + sc4);                      // Expect JB-2018-01
        System.out.println("Name: " + sc4.getName());                   // Expect Stevie Wonder
        System.out.println("Birth Date: " + sc4.getBirthDate());        // Expect 3 Aug 1997
        System.out.println("Student ID: " + sc4.getStudentID());        // Expect a0002
        System.out.println("Date of Issue: " + sc4.getDateOfIssue());   // Expect current date
        System.out.println("\n---------------------------------------------------------------------------------");
        
        // ---------------------------------------------------------------------------------
        
        System.out.println("\nNumber of undergraduate students (expect 1): " + tools.noOfStudents("Undergraduate"));
        System.out.println("Number of postgraduate taught students (expect 2): " + tools.noOfStudents("Postgraduate Taught"));
        System.out.println("Number of postgraduate research students (expect 1): " + tools.noOfStudents("Postgraduate Research"));
        
        StudentID id = sc2.getStudentID();
        System.out.println("\nConfirm student is stored:" + tools.getStudent(id));
        System.out.println("\nConfirm student card is stored:\n" + tools.getSmartCard(id));
        
        System.out.println("\nTerminate student");
        tools.terminateStudent(id);
        
        System.out.println("\nConfirm student is removed: " + tools.getStudent(id));
        System.out.println("Confirm student card is removed: " + tools.getSmartCard(id));
        
        System.out.println("\nNumber of undergraduate students (expect 1): " + tools.noOfStudents("Undergraduate"));
        System.out.println("Number of postgraduate taught students (expect 2): " + tools.noOfStudents("Postgraduate Taught"));
        System.out.println("Number of postgraduate research students (expect 0): " + tools.noOfStudents("Postgraduate Research"));
        
        System.out.println("\n---------------------------------------------------------------------------------");
        
        // ---------------------------------------------------------------------------------
        
        Name name5 = new Name("Lizz", "Martins");
        Date birthDate5 = BirthDate.readDate("1996-12-12");
        Student newStudent5 = new PostgradResearch(name5, birthDate5);
        
        System.out.println("\nUnregistered research student test:\n" + newStudent5);
        System.out.println("\n---------------------------------------------------------------------------------");
        
        // ---------------------------------------------------------------------------------
        
    }
}
