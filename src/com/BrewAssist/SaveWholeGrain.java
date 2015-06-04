package com.BrewAssist;

import java.io.*;
import java.util.*;

public class SaveWholeGrain {
    public SaveWholeGrain() {
        //Empty contstructor
    }
    
    public void saveGrain(String fileName) {
        Properties prop = new Properties();
        prop.setProperty("testProp", "This is a test");
        FileWriter writer = null;
        String path = "C:\\BrewAssist\\Saves\\" + fileName + ".properties";
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
    
    public void configExample() {
        try {
            //Load the properites file
            File configFile = new File ("program.properties");
            FileInputStream inStream = new FileInputStream(configFile);
            Properties config = new Properties();
            config.load(inStream);
            //Create a new property
            Date current = new Date();
            config.setProperty("runtime", current.toString());
            //Save Properties file
            FileOutputStream outStream = new FileOutputStream(configFile);
            config.store(outStream, "Properties settings");
            inStream.close();
            config.list(System.out);
        } catch (IOException ioe) {
            System.out.println("IO error " + ioe.getMessage());  
        }
    }
    
    public void createDirectory() {
        File f = new File("C:\\BrewAssist");
        if (!f.exists()) {
            new File("C:\\BrewAssist\\Saves").mkdirs();
            System.out.println("Saves Directory Created!");
        }
    }
    
    public static void main(String[] arguments) {
        SaveWholeGrain app = new SaveWholeGrain();
        app.createDirectory();
        app.saveGrain("testFile");
    }
}