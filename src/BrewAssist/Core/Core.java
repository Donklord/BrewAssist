package BrewAssist.Core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;


public class Core {
    public Core() {
        //Empty constructor
    }
    
    public void createNewSeriesDirectory(String seriesName) {
        File series = new File("C:\\BrewAssist\\Saves\\" + seriesName);
        File batch = new File("C:\\BrewAssist\\Saves\\" + seriesName + "\\batches");
        File recipe = new File("C:\\BrewAssist\\Saves\\" + seriesName + "\\recipes");
        
        if (!series.exists())
            new File("C:\\BrewAssist\\Saves\\" + seriesName).mkdir();
        if (!batch.exists())
            new File("C:\\BrewAssist\\Saves\\" + seriesName + "\\batches").mkdir();
        if (!recipe.exists())
            new File("C:\\BrewAssist\\Saves\\" + seriesName + "\\recipes").mkdir();
    }
    
    public void createNewIndex(String seriesName) {
        //Configure a new properties class
        Properties prop = new Properties();
        
        //Create new file contents
        prop.setProperty("seriesName", seriesName);
        prop.setProperty("seriesCreated", "Some date here");
        prop.setProperty("recipes", "");
        prop.setProperty("batches", "");
        
        //Create the save file
        FileWriter writer = null;
        String path = "C:\\BrewAssist\\Saves\\.Index\\" + seriesName + ".properties";
        try {
            writer = new FileWriter(path);
            prop.store(writer, "Author: PVB");
            System.out.println("File Created!");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
  /**
    * Checks to see if the base BrewAssist directory exists.  If it doesn't exist
    * it creates it.
    *
    */
    public static void createDirectory() {
        File root = new File("C:\\BrewAssist");
        File saves = new File("C:\\BrewAssist\\Saves");
        File index = new File("C:\\BrewAssist\\Saves\\.Index");
        File recipe = new File("C:\\BrewAssist\\Saves\\Recipe");
        File wg = new File("C:\\BrewAssist\\Saves\\Recipe\\wg");
        File series = new File("C:\\BrewAssist\\Saves\\Recipe\\series");    
        File tracking = new File("C:\\BrewAssist\\Saves\\Tracking");
        File trackingWg = new File("C:\\BrewAssist\\Saves\\Tracking\\wg");
        File trackingSeries = new File("C:\\BrewAssist\\Saves\\Tracking\\series");
        
        if (!root.exists()) {
            new File("C:\\BrewAssist").mkdir();
        }
        if (!saves.exists()) {
            new File("C:\\BrewAssist\\Saves").mkdir();
        }
        if (!index.exists())
            new File("C:\\BrewAssist\\Saves\\.Index").mkdir();
        /*
        if (!recipe.exists()) {
            new File("C:\\BrewAssist\\Saves\\Recipe").mkdir();
        } 
        if (!wg.exists()) {
            new File("C:\\BrewAssist\\Saves\\Recipe\\wg").mkdir();
        }
        if (!series.exists()) {
            new File("C:\\BrewAssist\\Saves\\Recipe\\series").mkdir();
        } 
        if (!tracking.exists()) {
            new File("C:\\BrewAssist\\Saves\\Tracking").mkdir();
        } 
        if (!trackingWg.exists()) {
            new File("C:\\BrewAssist\\Saves\\Tracking\\wg").mkdir();
        } 
        if (!trackingSeries.exists()) {
            new File("C:\\BrewAssist\\Saves\\Tracking\\series").mkdir();
        }  */
    }
    
}