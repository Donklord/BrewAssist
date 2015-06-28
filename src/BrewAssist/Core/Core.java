package BrewAssist.Core;

import java.io.File;


public class Core {
    public Core() {
        //Empty constructor
    }
    
  /**
    * Checks to see if the base BrewAssist directory exists.  If it doesn't exist
    * it creates it.
    *
    */
    public static void createDirectory() {
        File f = new File("C:\\BrewAssist");
        if (!f.exists()) {
            new File("C:\\BrewAssist\\Saves\\wg").mkdirs();
            new File("C:\\BrewAssist\\Saves\\extract").mkdir();
            System.out.println("Saves Directory Created!");
        }
    }
}