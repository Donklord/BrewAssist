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
        File root = new File("C:\\BrewAssist");
        File saves = new File("C:\\BrewAssist\\Saves");
        File recipe = new File("C:\\BrewAssist\\Saves\\Recipe");
        File wg = new File("C:\\BrewAssist\\Saves\\Recipe\\wg");
        File ext = new File("C:\\BrewAssist\\Saves\\Recipe\\extract");
        File tracking = new File("C:\\BrewAssist\\Saves\\Tracking");
        File trackingWg = new File("C:\\BrewAssist\\Saves\\Tracking\\wg");
        File trackingExt = new File("C:\\BrewAssist\\Saves\\Tracking\\extract");
        
        if (!root.exists()) {
            new File("C:\\BrewAssist").mkdir();
        } 
        if (!saves.exists()) {
            new File("C:\\BrewAssist\\Saves").mkdir();
        } 
        if (!recipe.exists()) {
            new File("C:\\BrewAssist\\Saves\\Recipe").mkdir();
        } 
        if (!wg.exists()) {
            new File("C:\\BrewAssist\\Saves\\Recipe\\wg").mkdir();
        } 
        if (!ext.exists()) {
            new File("C:\\BrewAssist\\Saves\\Recipe\\extract").mkdir();
        } 
        if (!tracking.exists()) {
            new File("C:\\BrewAssist\\Saves\\Tracking").mkdir();
        } 
        if (!trackingWg.exists()) {
            new File("C:\\BrewAssist\\Saves\\Tracking\\wg").mkdir();
        } 
        if (!trackingExt.exists()) {
            new File("C:\\BrewAssist\\Saves\\Tracking\\extract").mkdir();
        } 
    }
    
}