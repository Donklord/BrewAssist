package com.BrewAssist;

import java.awt.event.*;
import javax.swing.*;

public class NewWholeGrainEvent {
    BrewAssistUI gui;
    CsvLoader file = new CsvLoader();
    String[] styleNames = file.getBeerNames();
    String[] yeastNames = file.getYeastNames();
    String[] hopNames = file.getHopNames();
    String[] grainNames = file.getGrainNames();
    String matches = "None";
    
    public NewWholeGrainEvent(BrewAssistUI in) {
        gui = in;
    }
    
    public void itemChanged(String in) {
        matches = in;
        
        //Search for beer names matches
        for (int i = 0; i < 28; i++) {
            if ((i != 0) && (matches.equals(styleNames[i])) ) {
                String[] response = file.getIngredient(matches, "beerStyles");
                gui.ibuText.setText(response[2]);
                gui.srmText.setText(response[3]);
                gui.ogText.setText(response[4]);
                gui.fgText.setText(response[5]);
                gui.abvText.setText(response[6]);
                gui.specialTextField.setText(response[8]);
            }
        }
        
        //Search for grain name matches
        for (int i = 0; i < 32; i++) {
            if ((i !=0) && (matches.equals(hopNames[i]))) {
                String[] response = file.getIngredient(matches, "hops");
            }
        }
        
        
        
        //Pair up by row
        //Row 1
        String name1 = gui.grainData[0][0].toString();
        
        String lbs1 = gui.grainData[0][1].toString();
        String lob1 = gui.grainData[0][2].toString();
        String eff1 = gui.grainData[0][3].toString();
        
        //Row 2
        String name2 = gui.grainData[0][0].toString();
        String lbs2 = gui.grainData[0][1].toString();
        String lob2 = gui.grainData[0][2].toString();
        String eff2 = gui.grainData[0][3].toString();
        
        //Row 3
        String name3 = gui.grainData[0][0].toString();
        String lbs3 = gui.grainData[0][1].toString();
        String lob3 = gui.grainData[0][2].toString();
        String eff3 = gui.grainData[0][3].toString();
        
        //Row 4
        String name4 = gui.grainData[0][0].toString();
        String lbs4 = gui.grainData[0][1].toString();
        String lob4 = gui.grainData[0][2].toString();
        String eff4= gui.grainData[0][3].toString();
        
        //Row 5
        String name5 = gui.grainData[0][0].toString();
        String lbs5 = gui.grainData[0][1].toString();
        String lob5 = gui.grainData[0][2].toString();
        String eff5 = gui.grainData[0][3].toString();
        
        //Row 6
        String name6 = gui.grainData[0][0].toString();
        String lbs6 = gui.grainData[0][1].toString();
        String lob6 = gui.grainData[0][2].toString();
        String eff6 = gui.grainData[0][3].toString();
        
        
        
        
        System.out.println(gui.grainData[0][0]);
        gui.grainData[0][3] = "5";
        
        String[] grainResponse = new String[6];
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j < 4; j++) {
                grainResponse[i] = gui.grainData[i][j].toString();
                System.out.println(grainResponse[i]);
            }
        }
        
    }
    
    private boolean grainMatch(String in) {
        for (int i = 0; i < 32; i++) {
            if ( (i != 0) && (in.equals(""))) {
                return true;
            }
        }
        return false;
    }
}