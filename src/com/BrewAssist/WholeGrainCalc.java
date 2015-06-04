package com.BrewAssist;

import com.Ingredients.*;
import java.util.*;
import java.text.*;

public class WholeGrainCalc {
    
    BrewAssistUI gui;
    WholeGrain grain = new WholeGrain();
    Hops hopApp = new Hops();
    Styles styleApp = new Styles();
    String[] styleNames = styleApp.styleList;
  //  String[] yeastNames = file.getYeastNames();
    String[] hopNames = hopApp.hopList;
    String[] grainNames = grain.grainList;
    String matches = "None";
    double BrewhouseEff = 0.72;
    double brewTime = 60;
    
    DecimalFormat shortDf = new DecimalFormat("#.##");
    DecimalFormat longDf = new DecimalFormat("#.###");
    DecimalFormat wholeDf = new DecimalFormat("#");
    DecimalFormat oneDf = new DecimalFormat("#.#");
    
    public WholeGrainCalc(BrewAssistUI in) {
        gui = in;
    }
    
    public void calculate() {
        //Calculate SRM
        double srmCalc = getSrmTotal();
        String srmRes = String.valueOf(shortDf.format(srmCalc));
        gui.cSrmT.setText(srmRes);
        
        //Calculate OG
        double ppgCalc = getTotalPoints();
        double finalOg = (ppgCalc / 1000) + 1;
        String ppgRes = String.valueOf(longDf.format(finalOg));
        gui.cOgT.setText(ppgRes);
        
        //Calculate FG
        double fgCalc = getFg(finalOg);
        gui.cFgT.setText(String.valueOf(longDf.format(fgCalc)));
        
        //Calculate ABV
        double abvCalc = getAbv(finalOg, fgCalc);
        gui.cAbvT.setText(String.valueOf(oneDf.format(abvCalc)));
        
        //Calculate IBU
        double ibuCalc = getIbuTotal(finalOg);
        gui.cIbuT.setText(String.valueOf(oneDf.format(ibuCalc)));
        
    }
    
    public double getSrmTotal() {
        double result = 0.0;
        double total = 0.0;
        
        //Pull 1st grain row
        String item = gui.grainData[0][1].toString();
        String item1 = gui.grainData[0][3].toString();
        String volume = gui.size.getText();
        double volumeD = 0.0;
        double weightD = 0.0;
        double lovD = 0.0;
        volumeD = setDouble(volume);
        weightD = setDouble(item);
        lovD = setDouble(item1);
        result = getSrm(weightD, lovD, volumeD);
        total = result;
        
        //Pull 2nd grain row
        item = gui.grainData[1][1].toString();
        item1 = gui.grainData[1][3].toString();
        weightD = 0.0;
        lovD = 0.0;
        weightD = setDouble(item);
        lovD = setDouble(item1);
        result = getSrm(weightD, lovD, volumeD);
        total += result;
        
        //Pull 3rd grain row
        item = gui.grainData[2][1].toString();
        item1 = gui.grainData[2][3].toString();
        weightD = 0.0;
        lovD = 0.0;
        weightD = setDouble(item);
        lovD = setDouble(item1);
        result = getSrm(weightD, lovD, volumeD);
        total += result;
        
        //Pull 4th grain row
        item = gui.grainData[3][1].toString();
        item1 = gui.grainData[3][3].toString();
        weightD = 0.0;
        lovD = 0.0;
        weightD = setDouble(item);
        lovD = setDouble(item1);
        result = getSrm(weightD, lovD, volumeD);
        total += result;
        
        //Pull 5th grain row
        item = gui.grainData[4][1].toString();
        item1 = gui.grainData[4][3].toString();
        weightD = 0.0;
        lovD = 0.0;
        weightD = setDouble(item);
        lovD = setDouble(item1);
        result = getSrm(weightD, lovD, volumeD);
        total += result;
        
        //Pull 6th grain row
        item = gui.grainData[5][1].toString();
        item1 = gui.grainData[5][3].toString();
        weightD = 0.0;
        lovD = 0.0;
        weightD = setDouble(item);
        lovD = setDouble(item1);
        result = getSrm(weightD, lovD, volumeD);
        total += result;
        
        return total;
    }
    
    public double getTotalPoints() {
        //Define variables
        double result = 0.0;
        double total = 0.0;
        String rawW = "";
        String raw = "";
        String volume = gui.size.getText();
        Double temp = 0.0;
        Double ppg = 0.0;
        Double weightD = 0.0;
        Double volumeD = 0.0;
        
        volumeD = setDouble(volume);
        System.out.println("getTotalPoints synopsis: ");
        
        //If the grain column has data
        //   Get row 1 data 
        if (!gui.grainData[0][0].toString().equals("")) {
            rawW = gui.grainData[0][1].toString();
            raw = gui.grainData[0][2].toString();
            temp = 0.0;
            ppg = 0.0;
            weightD = 0.0;
            ppg = setDouble(raw);
            weightD = setDouble(rawW);
            temp = (ppg / 100) * 46;
            result = getOg(weightD, temp, volumeD);
            total = result;
            System.out.println(ppg + " " + weightD + " " + volumeD + " " + temp + " " + result);
        }
        
        //If the grain column has data
        //  Get row 2 data
        if (!gui.grainData[1][0].toString().equals("")) {
            rawW = gui.grainData[1][1].toString();
            raw = gui.grainData[1][2].toString();
            ppg = 0.0;
            temp = 0.0;
            weightD = 0.0;
            ppg = setDouble(raw);
            weightD = setDouble(rawW);
            temp = (ppg / 100) * 46;
            total += getOg(weightD, temp, volumeD);
            System.out.println(ppg + " " + weightD + " " + volumeD + " " + temp + " " + result);
        }
        
        //If the grain column has data
        //  Get row 3 data
        if (!gui.grainData[2][0].toString().equals("")) {
            rawW = gui.grainData[2][1].toString();
            raw = gui.grainData[2][2].toString();
            ppg = 0.0;
            temp = 0.0;
            weightD = 0.0;
            ppg = setDouble(raw);
            weightD = setDouble(rawW);
            temp = (ppg / 100) * 46;
            total += getOg(weightD, temp, volumeD);
            System.out.println(ppg + " " + weightD + " " + volumeD + " " + temp + " " + result);
        }
        
        //If the grain column has data
        //  Get row 4 data
        if (!gui.grainData[3][0].toString().equals("")) {
            rawW = gui.grainData[3][1].toString();
            raw = gui.grainData[3][2].toString();
            ppg = 0.0;
            temp = 0.0;
            weightD = 0.0;
            ppg = setDouble(raw);
            weightD = setDouble(rawW);
            temp = (ppg / 100) * 46;
            total += getOg(weightD, temp, volumeD);
            System.out.println(ppg + " " + weightD + " " + volumeD + " " + temp + " " + result);
        }
        
        //If the grain column has data
        //  Get row 5 data
        if (!gui.grainData[4][0].toString().equals("")) {
            rawW = gui.grainData[4][1].toString();
            raw = gui.grainData[4][2].toString();
            ppg = 0.0;
            temp = 0.0;
            weightD = 0.0;
            ppg = setDouble(raw);
            weightD = setDouble(rawW);
            temp = (ppg / 100) * 46;
            total += getOg(weightD, temp, volumeD);
            System.out.println(ppg + " " + weightD + " " + volumeD + " " + temp + " " + result);
        }
        
        //If the grain column has data
        //  Get row 6 data
        if (!gui.grainData[5][0].toString().equals("")) {
            rawW = gui.grainData[5][1].toString();
            raw = gui.grainData[5][2].toString();
            ppg = 0.0;
            temp = 0.0;
            weightD = 0.0;
            ppg = setDouble(raw);
            weightD = setDouble(rawW);
            temp = (ppg / 100) * 46;
            total += getOg(weightD, temp, volumeD);
            System.out.println(ppg + " " + weightD + " " + volumeD + " " + temp + " " + result);
        }
        
        System.out.println(total);
        System.out.println("End synopsis: ");
        return total;
    }
    
    public double getWeightTotal() {
        //double result = 0.0;
        double total = 0.0;
        
        //Row 1
        String item = gui.grainData[0][1].toString();
        double weightD = 0.0;
        weightD = setDouble(item);
        total = weightD;
        
        //Row 2
        item = gui.grainData[1][1].toString();
        weightD = 0.0;
        weightD = setDouble(item);
        total += weightD;
        
        //Row 3
        item = gui.grainData[2][1].toString();
        weightD = 0.0;
        weightD = setDouble(item);
        total += weightD;
        
        //Row 4
        item = gui.grainData[3][1].toString();
        weightD = 0.0;
        weightD = setDouble(item);
        total += weightD;
        
        //Row 5
        item = gui.grainData[4][1].toString();
        weightD = 0.0;
        weightD = setDouble(item);
        total += weightD;
        
        //Row 6
        item = gui.grainData[5][1].toString();
        weightD = 0.0;
        weightD = setDouble(item);
        total += weightD;
        
        return total;
    }
    
    public double getIbuTotal(double og) {
        //Setup variables
        double result = 0.0;
        double total = 0.0;
        String amount_s = "";
        String time_s = "";
        String acid_s = "";
        String volume_s = gui.size.getText();
        double amount_d = 0.0;
        double time_d = 0.0;
        double acid_d = 0.0;
        double volume_d = setDouble(volume_s);
        
        //If the hop column has data
        //   Get row 1 data
        if (!gui.hopData[0][0].toString().equals("")) {
            amount_s = gui.hopData[0][1].toString();
            time_s = gui.hopData[0][2].toString();
            acid_s = gui.hopData[0][3].toString();
            amount_d = setDouble(amount_s);
            time_d = setDouble(time_s);
            acid_d = setDouble(acid_s);
            result = getIbu(og, time_d, amount_d, acid_d, volume_d);
            System.out.println(amount_d + " " +  time_d + " " + acid_d + " " + result);
            total += result;
        }
        
        //If the hop column has data
        //   Get row 2 data
        if (!gui.hopData[1][0].toString().equals("")) {
            amount_s = gui.hopData[1][1].toString();
            time_s = gui.hopData[1][2].toString();
            acid_s = gui.hopData[1][3].toString();
            amount_d = 0.0;
            time_d = 0.0;
            acid_d = 0.0;
            amount_d = setDouble(amount_s);
            time_d = setDouble(time_s);
            acid_d = setDouble(acid_s);
            result = getIbu(og, time_d, amount_d, acid_d, volume_d);
            System.out.println(amount_d + " " +  time_d + " " + acid_d + " " + result);
            total += result;
        }
        
        //If the hop column has data
        //   Get row 3 data
        if (!gui.hopData[2][0].toString().equals("")) {
            amount_s = gui.hopData[2][1].toString();
            time_s = gui.hopData[2][2].toString();
            acid_s = gui.hopData[2][3].toString();
            amount_d = 0.0;
            time_d = 0.0;
            acid_d = 0.0;
            amount_d = setDouble(amount_s);
            time_d = setDouble(time_s);
            acid_d = setDouble(acid_s);
            result = getIbu(og, time_d, amount_d, acid_d, volume_d);
            System.out.println(amount_d + " " +  time_d + " " + acid_d + " " + result);
            total += result;
        }
        
        //If the hop column has data
        //   Get row 4 data
        if (!gui.hopData[3][0].toString().equals("")) {
            amount_s = gui.hopData[3][1].toString();
            time_s = gui.hopData[3][2].toString();
            acid_s = gui.hopData[3][3].toString();
            amount_d = 0.0;
            time_d = 0.0;
            acid_d = 0.0;
            amount_d = setDouble(amount_s);
            time_d = setDouble(time_s);
            acid_d = setDouble(acid_s);
            result = getIbu(og, time_d, amount_d, acid_d, volume_d);
            System.out.println(amount_d + " " +  time_d + " " + acid_d + " " + result);
            total += result;
        }
        
        //If the hop column has data
        //   Get row 5 data
        if (!gui.hopData[4][0].toString().equals("")) {
            amount_s = gui.hopData[4][1].toString();
            time_s = gui.hopData[4][2].toString();
            acid_s = gui.hopData[4][3].toString();
            amount_d = 0.0;
            time_d = 0.0;
            acid_d = 0.0;
            amount_d = setDouble(amount_s);
            time_d = setDouble(time_s);
            acid_d = setDouble(acid_s);
            result = getIbu(og, time_d, amount_d, acid_d, volume_d);
            System.out.println(amount_d + " " +  time_d + " " + acid_d + " " + result);
            total += result;
        }
        
        //If the hop column has data
        //   Get row 6 data
        if (!gui.hopData[5][0].toString().equals("")) {
            amount_s = gui.hopData[5][1].toString();
            time_s = gui.hopData[5][2].toString();
            acid_s = gui.hopData[5][3].toString();
            amount_d = 0.0;
            time_d = 0.0;
            acid_d = 0.0;
            amount_d = setDouble(amount_s);
            time_d = setDouble(time_s);
            acid_d = setDouble(acid_s);
            result = getIbu(og, time_d, amount_d, acid_d, volume_d);
            System.out.println(amount_d + " " +  time_d + " " + acid_d + " " + result);
            total += result;
        }
        
        return total;
    }
    
    private double setDouble(String in) {
        if (in.equals("")) {
            return 0.0;
        } else {
            return Double.parseDouble(in);
        }
    }
        
    public double getSrm(double weight, double lovibond, double volume) {
        return (weight * lovibond) / volume;
    }
    
    public double getOg(double weight, double ppg, double volume) {
        return (weight * ppg * BrewhouseEff) / volume;
    }
    
    public double getFg(double og) {
        return ((og - 1)*0.25) + 1;
    }
    
    public double getAbv(double og, double fg) {
        return (og - fg) * 131;
    }
    
    public double getWater(double batchVolume, double grainWeight) {
        return (batchVolume + (grainWeight * 0.1318) + (brewTime * 0.555) + 0.264);
    }
    
    public double getIbu(double gravity, double time, double weight, double alphaAcid, double batchVolume) {
        double aau = 0.0;
        double util = 0.0;
        aau = weight * (alphaAcid / 100);
        util = getUtilization(gravity, time);
        System.out.println("***Utilization***: " + util);
        //If the gravity is below 1.050 use the traditional formula
        //  If the gravity is above 1.050 a gravity adjustment is accounted for
        
        return (aau * util * 7462) / batchVolume;
        
        
    }
    
    private double getUtilization(double gravity, double time) {
        double exp = Math.pow(0.000125, (gravity - 1));
        double fg = 1.65 * exp;
        exp = Math.exp(-0.04 * time);
        double ft = (1 - exp) / 4.15;
        return fg * ft;
    }
}