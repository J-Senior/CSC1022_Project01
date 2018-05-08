/**
 * Filename:        StudentID.java
 * Date:            2018/05/06
 * Name:            Senior J.J.
 * Student number:  160474257
 * -------------------------------------------------------
 * By submitting this file electronically, I declare that
 * it is my own original work, and that I have not copied
 * any part of it from another source.
 * -------------------------------------------------------
 * This class is used to generate a unique student ID.
 * IDs are in the format a0000.
 * -------------------------------------------------------
 */

package api;

public class StudentID {
    
    private String letter;
    private int    number      = 0;
    private int    letterCount = 0;
    private int    numberCount = 0;
    
    public StudentID(String letter, int number) {
        this.letter = letter;
        this.number = number;
    }
    
    StudentID() {
        
    }
    
    String getLetter() {
        return letter;
    }
    
    public void setLetter(String letter) {
        this.letter = letter;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    StudentID generateNewID() {
        
        numberCount++;
        if (numberCount >= 10000) {
            numberCount = 0;
            letterCount++;
        }
        
        return new StudentID(("" + (char) ('a' + letterCount)), numberCount);   // ("" +) needed to convert char to String
    }
    
    @Override
    public String toString() {
        return String.format("%s%04d", letter, number);
    }
}
