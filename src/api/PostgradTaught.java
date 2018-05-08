/**
 * Filename:        PostgraduateTaught.java
 * Date:            2018/05/06
 * Name:            Senior J.J.
 * Student number:  160474257
 * -------------------------------------------------------
 * By submitting this file electronically, I declare that
 * it is my own original work, and that I have not copied
 * any part of it from another source.
 * -------------------------------------------------------
 * This class defines variables for a postgraduate taught
 * student. This student is registered for modules as
 * defined in the Taught class.
 * -------------------------------------------------------
 */

package api;

import java.util.Date;

public class PostgradTaught extends Taught {
    
    public PostgradTaught(Name name, Date birthDate) {
        super(name, birthDate);
        this.typeOfStudent = "Postgraduate Taught";
    }
    
    @Override
    final public String getTypeOfStudent() {
        return ("Postgraduate Taught");
    }
    
    @Override
    final public int getRequiredCredits() {
        return 180;
    }
    
    @Override
    final int getPassPercentage() {
        return 50;
    }
    
    @Override
    public final int getMinAge() {
        return 20;
    }
}
