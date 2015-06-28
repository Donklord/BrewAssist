 package BrewAssist.RecipeBuilder;

import java.io.*;
import java.util.*;

public class SaveWholeGrain {
    BrewAssistUI gui;
    
  /**
    * Only constructor.
    * 
    */
    public SaveWholeGrain(BrewAssistUI in) {
        gui = in;
    }
    
  /**
    * Save data from the WholeGrain tab and populate it in a new property
    * file located in `C:/BrewAssist/wg/fileName.properties`.  Ties into
    * BrewAssistUI class and pulls all necessary information.
    * <p>
    * Saves grain recipe data into a property file.
    *
    * @param  fileName   String name of the file.
    */
    public void saveGrain(String fileName) {
        Properties prop = new Properties();
        
        //Save properties
        prop.setProperty("name", gui.grainName.getText());
        prop.setProperty("style", gui.beerStyles.getSelectedItem().toString());
        prop.setProperty("batchSize", gui.size.getText());
        prop.setProperty("grain1Name", gui.grainData[0][0].toString());
        prop.setProperty("grain1Lb", gui.grainData[0][1].toString());
        prop.setProperty("grain2Name", gui.grainData[1][0].toString());
        prop.setProperty("grain2Lb", gui.grainData[1][1].toString());
        prop.setProperty("grain3Name", gui.grainData[2][0].toString());
        prop.setProperty("grain3Lb", gui.grainData[2][1].toString());
        prop.setProperty("grain4Name", gui.grainData[3][0].toString());
        prop.setProperty("grain4Lb", gui.grainData[3][1].toString());
        prop.setProperty("grain5Name", gui.grainData[4][0].toString());
        prop.setProperty("grain5Lb", gui.grainData[4][1].toString());
        prop.setProperty("grain6Name", gui.grainData[5][0].toString());
        prop.setProperty("grain6Lb", gui.grainData[5][1].toString());
        prop.setProperty("hop1Name", gui.hopData[0][0].toString());
        prop.setProperty("hop1Amount", gui.hopData[0][1].toString());
        prop.setProperty("hop1Time", gui.hopData[0][2].toString());
        prop.setProperty("hop2Name", gui.hopData[1][0].toString());
        prop.setProperty("hop2Amount", gui.hopData[1][1].toString());
        prop.setProperty("hop2Time", gui.hopData[1][2].toString());
        prop.setProperty("hop3Name", gui.hopData[2][0].toString());
        prop.setProperty("hop3Amount", gui.hopData[2][1].toString());
        prop.setProperty("hop3Time", gui.hopData[2][2].toString());
        prop.setProperty("hop4Name", gui.hopData[3][0].toString());
        prop.setProperty("hop4Amount", gui.hopData[3][1].toString());
        prop.setProperty("hop4Time", gui.hopData[3][2].toString());
        prop.setProperty("hop5Name", gui.hopData[4][0].toString());
        prop.setProperty("hop5Amount", gui.hopData[4][1].toString());
        prop.setProperty("hop5Time", gui.hopData[4][2].toString());
        prop.setProperty("hop6Name", gui.hopData[5][0].toString());
        prop.setProperty("hop6Amount", gui.hopData[5][1].toString());
        prop.setProperty("hop6Time", gui.hopData[5][2].toString());
        prop.setProperty("yeast", gui.yeast.getSelectedItem().toString());
        
        //Create the save file
        FileWriter writer = null;
        String path = "C:\\BrewAssist\\Saves\\wg\\" + fileName + ".properties";
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
    * Whole Grain File Loader
    * <p>
    * This method takes the name of a file, loads all of its properties and sets the appropriate UI elements.
    *
    * @param filename (String) The name of the file to be loaded.
    */
    public void wgLoader(String filename) {
        try {
            String path = "C:\\BrewAssist\\Saves\\WG\\" + filename;
            //Load the properites file
            File configFile = new File (path);
            FileInputStream inStream = new FileInputStream(configFile);
            Properties config = new Properties();
            config.load(inStream);
            
            //Load default propreties from file and set UI elements.
            gui.grainName.setText(config.getProperty("name"));
            gui.beerStyles.setSelectedItem(config.getProperty("style"));
            gui.size.setText(config.getProperty("batchSize"));
            gui.grainData[0][0] = config.getProperty("grain1Name");
            gui.grainData[0][1] = config.getProperty("grain1Lb");
            gui.grainData[1][0] = config.getProperty("grain2Name");
            gui.grainData[1][1] = config.getProperty("grain2Lb");
            gui.grainData[2][0] = config.getProperty("grain3Name");
            gui.grainData[2][1] = config.getProperty("grain3Lb");
            gui.grainData[3][0] = config.getProperty("grain4Name");
            gui.grainData[3][1] = config.getProperty("grain4Lb");
            gui.grainData[4][0] = config.getProperty("grain5Name");
            gui.grainData[4][1] = config.getProperty("grain5Lb");
            gui.grainData[5][0] = config.getProperty("grain6Name");
            gui.grainData[5][1] = config.getProperty("grain6Lb");
            gui.hopData[0][0] = config.getProperty("hop1Name");
            gui.hopData[0][1] = config.getProperty("hop1Amount");
            gui.hopData[0][2] = config.getProperty("hop1Time");
            gui.hopData[1][0] = config.getProperty("hop2Name");
            gui.hopData[1][1] = config.getProperty("hop2Amount");
            gui.hopData[1][2] = config.getProperty("hop2Time");
            gui.hopData[2][0] = config.getProperty("hop3Name");
            gui.hopData[2][1] = config.getProperty("hop3Amount");
            gui.hopData[2][2] = config.getProperty("hop3Time");
            gui.hopData[3][0] = config.getProperty("hop4Name");
            gui.hopData[3][1] = config.getProperty("hop4Amount");
            gui.hopData[3][2] = config.getProperty("hop4Time");
            gui.hopData[4][0] = config.getProperty("hop5Name");
            gui.hopData[4][1] = config.getProperty("hop5Amount");
            gui.hopData[4][2] = config.getProperty("hop5Time");
            gui.hopData[5][0] = config.getProperty("hop6Name");
            gui.hopData[5][1] = config.getProperty("hop6Amount");
            gui.hopData[5][2] = config.getProperty("hop6Time");
            gui.yeast.setSelectedItem(config.getProperty("yeast"));
            inStream.close();
        } catch (IOException ioe) {
            System.out.println("IO error " + ioe.getMessage());  
        }
    } 
    
  
}