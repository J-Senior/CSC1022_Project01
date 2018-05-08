/**
 * Filename:        Module.java
 * Date:            2018/05/06
 * Name:            Senior J.J.
 * Student number:  160474257
 * -------------------------------------------------------
 * By submitting this file electronically, I declare that
 * it is my own original work, and that I have not copied
 * any part of it from another source.
 * -------------------------------------------------------
 * This class is used to read module data from a csv file.
 * The file must be formatted as:
 * module code, module name, module credits
 * For example:
 * CSC1021, Programming 1, 20
 * -------------------------------------------------------
 */

package api;

import java.io.FileReader;
import java.util.Scanner;

public class Module {
    
    private String moduleCode;
    private String moduleName;
    private int    moduleCredits = 0;
    
    Module(String moduleCode, String moduleName, int moduleCredits) {       // Constructor for Module objects
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.moduleCredits = moduleCredits;
    }
    
    Module(String searchCode) {                                             // Reads Module from csv file when given module code in String form
        
        String currentModule;
        
        try {
            Scanner fileReader = new Scanner(
                    new FileReader("src/api/Modules.csv"));
            
            while ((currentModule = fileReader.nextLine()) != null) {               // Loops through list while until module code is found
                String[] moduleSort = currentModule.split(",");                     // Places current line in array, separating by comma
                if (moduleSort[0].trim().equalsIgnoreCase(searchCode)) {            // Searches for required module code
                    int creditsToInt = Integer.parseInt(moduleSort[2].trim());      // Removes whitespace from credit value and converts to int
                    this.moduleCode = moduleSort[0].trim();
                    this.moduleName = moduleSort[1].trim();
                    this.moduleCredits = creditsToInt;
                    break;
                }
            }
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    String getModuleCode() {
        return moduleCode;
    }
    
    void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }
    
    String getModuleName() {
        return moduleName;
    }
    
    void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    
    int getModuleCredits() {
        return moduleCredits;
    }
    
    void setModuleCredits(int moduleCredits) {
        this.moduleCredits = moduleCredits;
    }
    
    @Override
    public String toString() {                                              // Defines Module print format as "moduleCode : numberOf credits, moduleName"
        return String.format("%-8s: %-2d credits, %-50s", moduleCode, moduleCredits, moduleName);
    }
}
