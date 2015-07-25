package BrewAssist.Core;

import java.awt.FileDialog;
import BrewAssist.RecipeTrack.*;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Batch_Load {
    RecipeTrackUI gui;
    public Batch_Load(RecipeTrackUI in) {
        gui = in;
    }
    
    public Boolean loadRecipe() {
        String fileName = RunRecipeLoadFrame();
        if (!fileName.equals("Empty")) {
            wgRecipeLoad_PostProcess(fileName);
            gui.tableRefresh();
            System.out.println("Recipe Load Result: " + fileName + "has been loaded");
            return true;
        }
        return false;
    }
    
    public Boolean loadBatch() {
        String fileName = RunBatchLoadFrame();
        if (!fileName.equals("Empty")) {
            wgTrackLoad_PostProcess(fileName);
            gui.tableRefresh();
            System.out.println("Batch Load Result: " + fileName + "has been loaded");
            return true;
        }
        return false;
    }
    
    //To do: crate loadSeries functionality
    public Boolean loadSeries() {
        String fileName = RunSeriesLoadFrame();
        if (!fileName.equals("Empty")) {
            int x = fileName.length() - 11;
            gui.series_field.setText(fileName.substring(0, x));
        }
        return false;
    }
    
    public String RunSeriesLoadFrame() {
        String filename = "Empty";
        Frame f = new Frame();
        f.setLocationRelativeTo(null);
        FileDialog fd = new FileDialog(f, "Select a batch series", FileDialog.LOAD);
        fd.setDirectory("C:\\BrewAssist\\Saves\\.Index\\");
        fd.setFile("*.properties");
        fd.setVisible(true);
        filename = fd.getFile();
        //Logging
        if (filename.contains("Empty"))
            System.out.println("Series Load: No file chosen");
        else
            System.out.println("Series Load: File " + filename + " was loaded");
        
        return filename;
    }
    
    /**
    * Whole Grain Batch File Selector
    * <p>
    * This method is called from the RecipeTrackUI class when the "Load a Batch" button is 
    * pressed.  The user selects the desired batch and this method returns the name 
    * of that batch for post processing.
    *
    * @return String containing the selected file name.
    */
    public String RunRecipeLoadFrame() {
        String filename = "Empty";
        Frame f = new Frame();
        String series = gui.series_field.getText();
        f.setLocationRelativeTo(null);
        FileDialog fd = new FileDialog(f, "Select a recipe", FileDialog.LOAD);
        fd.setDirectory("C:\\BrewAssist\\Saves\\" + series + "\\recipes");
        fd.setFile("*.properties");
        fd.setVisible(true);
        filename = fd.getFile();
        //Logging
        if (filename.contains("Empty"))
            System.out.println("WG Load: No file chosen");
        else
            System.out.println("WG Load: File " + filename + " was loaded");
        
        return filename;
    }
    
    public String RunBatchLoadFrame() {
        String filename = "Empty";
        Frame f = new Frame();
        String series = gui.series_field.getText();
        f.setLocationRelativeTo(null);
        FileDialog fd = new FileDialog(f, "Select a batch", FileDialog.LOAD);
        fd.setDirectory("C:\\BrewAssist\\Saves\\" + series + "\\batches");
        fd.setFile("*.properties");
        fd.setVisible(true);
        filename = fd.getFile();
        //Logging
        if (filename.contains("Empty"))
            System.out.println("WG Load: No file chosen");
        else
            System.out.println("WG Load: File " + filename + " was loaded");
        
        return filename;
    }
    
    /**
    * Whole Grain File Loader
    * <p>
    * This method takes the name of a file, loads all of its properties and sets the appropriate UI elements.
    *
    * @param filename (String) The name of the file to be loaded.
    */
    public void wgRecipeLoad_PostProcess(String filename) {
        try {
            String series = gui.series_field.getText();
            String path = "C:\\BrewAssist\\Saves\\" + series + "\\recipes\\" + filename;
            //Load the properites file
            File configFile = new File (path);
            FileInputStream inStream = new FileInputStream(configFile);
            Properties config = new Properties();
            config.load(inStream);
            
            //Load default propreties from file and set UI elements.
            gui.title_field.setText(config.getProperty("name"));
            gui.batchSize_field.setText(config.getProperty("batchSize"));
            gui.ibu_field.setText(config.getProperty("ibu"));
            gui.srm_field.setText(config.getProperty("srm"));
            gui.og_field.setText(config.getProperty("og"));
            gui.fg_field.setText(config.getProperty("fg"));
            gui.abv_field.setText(config.getProperty("abv"));
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
            gui.yeastCombo.setSelectedItem(config.getProperty("yeast"));
            inStream.close();
        } catch (IOException ioe) {
            System.out.println("IO error " + ioe.getMessage());  
        }
    } 
    
    public void wgTrackLoad_PostProcess(String filename) {
        try {
            String series = gui.series_field.getText();
            String path = "C:\\BrewAssist\\Saves\\" + series + "\\batches\\" + filename;
            //Load the properites file
            File configFile = new File (path);
            FileInputStream inStream = new FileInputStream(configFile);
            Properties config = new Properties();
            config.load(inStream);
            
            //Load default propreties from file and set UI elements.
            gui.title_field.setText(config.getProperty("name"));
            gui.ibu_field.setText(config.getProperty("ibu"));
            gui.srm_field.setText(config.getProperty("srm"));
            gui.og_field.setText(config.getProperty("og"));
            gui.fg_field.setText(config.getProperty("fg"));
            gui.abv_field.setText(config.getProperty("abv"));
            
            gui.brewDate_field.setText(config.getProperty("brewDate"));
            gui.startTime_field.setText(config.getProperty("startTime"));
            gui.endTime_field.setText(config.getProperty("endTime"));
            gui.endPrim_field.setText(config.getProperty("endPrim"));
            gui.endSec_field.setText(config.getProperty("endSec"));
            gui.kegDate_field.setText(config.getProperty("kegDate"));
            gui.botDate_field.setText(config.getProperty("botDate"));
            gui.starterCombo.setSelectedItem(config.getProperty("starter"));
            gui.tempPitch_field.setText(config.getProperty("tempPitch"));
            
            gui.mashDuration_field.setText(config.getProperty("mashDuration"));
            gui.waterMashRatio_field.setText(config.getProperty("waterMashRatio"));
            gui.mashVolume_field.setText(config.getProperty("mashVolume"));
            gui.targetMashTemp_field.setText(config.getProperty("targetMashTemp"));
            gui.strikeWaterTemp_field.setText(config.getProperty("strikeWaterTemp"));
            gui.mashTempActual_field.setText(config.getProperty("mashTempActual"));
            gui.finalMashTemp_field.setText(config.getProperty("finalMashTemp"));
            gui.preboilGrav_field.setText(config.getProperty("preboilGrav"));
            gui.mashEff_field.setText(config.getProperty("mashEff"));
            
            gui.mashData[0][1] = config.getProperty("infVol1");
            gui.mashData[1][1] = config.getProperty("infVol2");
            gui.mashData[2][1] = config.getProperty("infVol3");
            gui.mashData[0][2] = config.getProperty("infTemp1");
            gui.mashData[1][2] = config.getProperty("infTemp2");
            gui.mashData[2][2] = config.getProperty("infTemp3");
            gui.mashData[0][3] = config.getProperty("mashTemp1");
            gui.mashData[1][3] = config.getProperty("mashTemp2");
            gui.mashData[2][3] = config.getProperty("mashTemp3");
            gui.mashData[0][4] = config.getProperty("runVol1");
            gui.mashData[1][4] = config.getProperty("runVol2");
            gui.mashData[2][4] = config.getProperty("runVol3");
            gui.mashData[0][5] = config.getProperty("runGrav1");
            gui.mashData[1][5] = config.getProperty("runGrav2");
            gui.mashData[2][5] = config.getProperty("runGrav3");
            
            gui.boilDuration_field.setText(config.getProperty("boilDuration"));
            gui.postBoilGravity_field.setText(config.getProperty("postBoilGravity"));
            gui.volumnPreBoil_field.setText(config.getProperty("volumnPreBoil"));
            gui.volumnPostBoil_field.setText(config.getProperty("volumnPostBoil"));
            gui.volumnInPrim_field.setText(config.getProperty("volumnInPrim"));
            gui.tempCheck1_field.setText(config.getProperty("tempCheck1"));
            gui.tempCheck2_field.setText(config.getProperty("tempCheck2"));
            gui.tempCheck3_field.setText(config.getProperty("tempCheck3"));
            gui.tempCheck4_field.setText(config.getProperty("tempCheck4"));
            gui.finalGrav_field.setText(config.getProperty("finalGrav"));
            
            gui.batchSize_field.setText(config.getProperty("batchSize"));
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
            gui.yeastCombo.setSelectedItem(config.getProperty("yeast"));
            inStream.close();
        } catch (IOException ioe) {
            System.out.println("IO error " + ioe.getMessage());  
        }
    }
    
    /**
    * Whole Grain File Loader
    * <p>
    * This method takes the name of a file, loads all of its properties and sets the appropriate UI elements.
    *
    * @param filename (String) The name of the file to be loaded.
    */
    public void wgSeriesLoad_PostProcess(String filename) {
        try {
            String series = gui.series_field.getText();
            String path = "C:\\BrewAssist\\Saves\\" + filename;   //To do: fix this later
            //Load the properites file
            File configFile = new File (path);
            FileInputStream inStream = new FileInputStream(configFile);
            Properties config = new Properties();
            config.load(inStream);
            
            //Load default propreties from file and set UI elements.
            gui.series_field.setText(config.getProperty("series"));
            inStream.close();
        } catch (IOException ioe) {
            System.out.println("IO error " + ioe.getMessage());  
        }
    } 
    
    
}
    