/**
 * Filename:        Undergrad.java
 * Date:            2018/05/06
 * Name:            Senior J.J.
 * Student number:  160474257
 * -------------------------------------------------------
 * By submitting this file electronically, I declare that
 * it is my own original work, and that I have not copied
 * any part of it from another source.
 * -------------------------------------------------------
 * This class defines an undergraduate student. An
 * undergratuate student is registered for modules but
 * has different minimum requirements to a postgraduate
 * taught student.
 * -------------------------------------------------------
 */

package api;

import java.util.Date;

public class Undergrad extends Taught {
    
    public Undergrad(Name name, Date birthDate) {
        super(name, birthDate);
        this.typeOfStudent = "Undergraduate";
    }
    
    @Override
    public String getTypeOfStudent() {
        return ("Undergraduate");
    }
    
    @Override
    public final int getRequiredCredits() {
        return 120;
    }
    
    @Override
    final int getPassPercentage() {
        return 40;
    }
    
    @Override
    public final int getMinAge() {
        return 17;
    }
}
