package com.BrewAssist;

import com.Ingredients.*;

public class NewWholeGrainEvent {
    BrewAssistUI gui;
    WholeGrain grain = new WholeGrain();
    Hops hopApp = new Hops();
    Styles styleApp = new Styles();
    String[] styleNames = styleApp.styleList;
  //  String[] yeastNames = file.getYeastNames();
    String[] hopNames = hopApp.hopList;
    String[] grainNames = grain.grainList;
    String matches = "None";
    
    public NewWholeGrainEvent(BrewAssistUI in) {
        gui = in;
    }
    
    public void itemChanged(String in) {
        matches = in;
        
        //Search for beer names matches
        for (int i = 0; i < 27; i++) {
            if ((i != 0) && (matches.equals(styleNames[i])) ) {
                styleApp.getIngredients(matches);
                gui.ibuText.setText(styleApp.ibu);
                gui.srmText.setText(styleApp.srm);
                gui.ogText.setText(styleApp.og);
                gui.fgText.setText(styleApp.fg);
                gui.abvText.setText(styleApp.abv);
                gui.specialTextField.setText(styleApp.notes);
            }
        } 
        
        //Search for grain name matches
        for (int i = 0; i < 31; i++) {
            if ((i !=0) && (matches.equals(hopNames[i]))) {
                String[] response = hopApp.hopList;
            }
        }
        
        
        
        //Pair up grain rows
        //Row 1
        String name1 = gui.grainData[0][0].toString();
        setGrain(0,name1);
        //Row 2
        String name2 = gui.grainData[1][0].toString();
        setGrain(1,name2);
        //Row 3
        String name3 = gui.grainData[2][0].toString();
        setGrain(2,name3);
        //Row 4
        String name4 = gui.grainData[3][0].toString();
        setGrain(3,name4);
        //Row 5
        String name5 = gui.grainData[4][0].toString();
        setGrain(4,name5);
        //Row 6
        String name6 = gui.grainData[5][0].toString();
        setGrain(5,name6);
       
       //Pair up hop rows
        //Row 1
        String hop1 = gui.hopData[0][0].toString();
        setHop(0, hop1);
        //Row 2
        String hop2 = gui.hopData[1][0].toString();
        setHop(1, hop2);
        //Row 3
        String hop3 = gui.hopData[2][0].toString();
        setHop(2, hop3);
        //Row 4
        String hop4 = gui.hopData[3][0].toString();
        setHop(3, hop4);
        //Row 5
        String hop5 = gui.hopData[4][0].toString();
        setHop(4, hop5);
        //Row 6
        String hop6 = gui.hopData[5][0].toString();
        setHop(5, hop6);
        
        
        String[] grainResponse = new String[6];
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j < 4; j++) {
                grainResponse[i] = gui.grainData[i][j].toString();
               // System.out.println(grainResponse[i]);
            }
        }
        
    }
   
    private void setGrain(int c, String name) {
        if (name.equals("")) {
            gui.grainData[c][2] = "";
            gui.grainData[c][3] = "";
            gui.grainData[c][4] = "";
            gui.grainData[c][5] = "";
        } else {
            grain.getIngredients(name);
            gui.grainData[c][2] = grain.yield;
            gui.grainData[c][3] = grain.colorLov;
            gui.grainData[c][4] = grain.colorSrm;
            gui.grainData[c][5] = grain.maxInBatch;
        }
    } 
    
    private void setHop(int c, String name) {
        if (name.equals("")) {
            gui.hopData[c][3] = "";
            gui.hopData[c][4] = "";
        } else {
            hopApp.getIngredients(name);
            gui.hopData[c][3] = hopApp.alphaAcid;
            gui.hopData[c][4] = hopApp.betaAcid;
        }
    }  
}