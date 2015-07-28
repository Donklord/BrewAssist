 package BrewAssist.Core;

import java.io.*;
import java.util.*;
import BrewAssist.RecipeTrack.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Batch_Save {
    RecipeTrackUI gui;
    
  /**
    * Only constructor.
    * 
    */
    public Batch_Save(RecipeTrackUI in) {
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
    public void saveBatch(String fileName) {
        //Configure a new properties class
        Properties prop = new Properties();
        String series = gui.series_field.getText();
        
        //Save properties
        prop.setProperty("fileType", "Track");
        prop.setProperty("name", gui.title_field.getText());
        
        prop.setProperty("ibu", gui.ibu_field.getText());
        prop.setProperty("srm", gui.srm_field.getText());
        prop.setProperty("og", gui.og_field.getText());
        prop.setProperty("fg", gui.fg_field.getText());
        prop.setProperty("abv", gui.abv_field.getText());
        
        prop.setProperty("brewDate", gui.brewDate_field.getText());
        prop.setProperty("startTime", gui.startTime_field.getText());
        prop.setProperty("endTime", gui.endTime_field.getText());
        prop.setProperty("endPrim", gui.endPrim_field.getText());
        prop.setProperty("endSec", gui.endSec_field.getText());
        prop.setProperty("kegDate", gui.kegDate_field.getText());
        prop.setProperty("botDate", gui.botDate_field.getText());
        String temp = gui.starterCombo.getSelectedItem().toString();
        prop.setProperty("starter", temp);
        prop.setProperty("tempPitch", gui.tempPitch_field.getText());
        
        prop.setProperty("mashDuration", gui.mashDuration_field.getText());
        prop.setProperty("waterMashRatio", gui.waterMashRatio_field.getText());
        prop.setProperty("mashVolume", gui.mashVolume_field.getText());
        prop.setProperty("targetMashTemp", gui.targetMashTemp_field.getText());
        prop.setProperty("strikeWaterTemp", gui.strikeWaterTemp_field.getText());
        prop.setProperty("mashTempActual", gui.mashTempActual_field.getText());
        prop.setProperty("finalMashTemp", gui.finalMashTemp_field.getText());
        prop.setProperty("preboilGrav", gui.preboilGrav_field.getText());
        prop.setProperty("mashEff", gui.mashEff_field.getText());
        
        temp = gui.mashData[0][1].toString();
        prop.setProperty("infVol1", temp);
        temp = gui.mashData[1][1].toString();
        prop.setProperty("infVol2", temp);
        temp = gui.mashData[2][1].toString();
        prop.setProperty("infVol3", temp);
        temp = gui.mashData[0][2].toString();
        prop.setProperty("infTemp1", temp);
        temp = gui.mashData[1][2].toString();
        prop.setProperty("infTemp2", temp);
        temp = gui.mashData[2][2].toString();
        prop.setProperty("infTemp3", temp);
        temp = gui.mashData[0][3].toString();
        prop.setProperty("mashTemp1", temp);
        temp = gui.mashData[1][3].toString();
        prop.setProperty("mashTemp2", temp);
        temp = gui.mashData[2][3].toString();
        prop.setProperty("mashTemp3", temp);
        temp = gui.mashData[0][4].toString();
        prop.setProperty("runVol1", temp);
        temp = gui.mashData[1][4].toString();
        prop.setProperty("runVol2", temp);
        temp = gui.mashData[2][4].toString();
        prop.setProperty("runVol3", temp);
        temp = gui.mashData[0][5].toString();
        prop.setProperty("runGrav1", temp);
        temp = gui.mashData[1][5].toString();
        prop.setProperty("runGrav2", temp);
        temp = gui.mashData[2][5].toString();
        prop.setProperty("runGrav3", temp);
        
        prop.setProperty("boilDuration", gui.boilDuration_field.getText());
        prop.setProperty("postBoilGravity", gui.postBoilGravity_field.getText());
        prop.setProperty("volumnPreBoil", gui.volumnPreBoil_field.getText());
        prop.setProperty("volumnPostBoil", gui.volumnPostBoil_field.getText());
        prop.setProperty("volumnInPrim", gui.volumnInPrim_field.getText());
        prop.setProperty("tempCheck1", gui.tempCheck1_field.getText());
        prop.setProperty("tempCheck2", gui.tempCheck2_field.getText());
        prop.setProperty("tempCheck3", gui.tempCheck3_field.getText());
        prop.setProperty("tempCheck4", gui.tempCheck4_field.getText());
        prop.setProperty("finalGrav", gui.finalGrav_field.getText());
        
        prop.setProperty("batchSize", gui.batchSize_field.getText());
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
        prop.setProperty("yeast", gui.yeastCombo.getSelectedItem().toString());
        
        //Create the save file
        FileWriter writer = null;
        DateFormat today = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = today.format(new Date());
        String recipe = gui.title_field.getText();
        String path = "C:\\BrewAssist\\Saves\\" + series + "\\batches\\" + recipe + " " + dateString + ".properties";
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
    
  
    
  
}