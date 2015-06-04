package com.BrewAssist;

import java.io.*;
import java.util.*;

public class CsvLoader {
    public CsvLoader() {
        //Empty constructor
    }
    
    public String[] getIngredient(String itemName, String type) {
       String[] information;
       String[] match = new String[9];
       
       String path = type + ".csv";
       File target = new File(path);
       path = target.getAbsolutePath();
       //System.out.println(path);
       
       try (BufferedReader read = new BufferedReader(new FileReader(path))) {
           String currentLine;
    
           while ((currentLine = read.readLine()) != null) {
               information = currentLine.split(",");
               match[0] = information[0];
               match[1] = information[1];
               match[2] = information[2];
               match[3] = information[3];
               if (type.equals("yeast") || type.equals("wholeGrain") || type.equals("beerStyles")) {
                   match[4] = information[4];
                   match[5] = information[5];
                   match[6] = information[6];
               }
               if (type.equals("yeast") || type.equals("beerStyles")) {
                   match[7] = information[7];
               }
               if (type.equals("beerStyles")) {
                   match[8] = information[8];
               }
               
               
               if (itemName.equals(match[1])) {
                   return match;
               }
            }
        } catch (IOException exc) {
           System.out.println("An error has occured: " + exc.getMessage());
        }
        return null;
    }
    
    public String[] getHopNames() {
        String[] names = new String[32];
        String[] response = new String[32];
        response = getName("hops" , names);
        return response;
    }
    
    public String[] getGrainNames() {
        String[] names = new String[48];
        String[] response = new String[48];
        response = getName("wholeGrain", names);
        return response;
    }
    
    public String[] getYeastNames() {
        String[] names = new String[29];
        String[] response = new String[29];
        response = getName("yeast", names);
        return response;
    }

    public String[] getBeerNames() {
        String[] names = new String[28];
        String[] response = new String[28];
        response = getName("beerStyles", names);
        return response;
    }
    
    public String[] getExtractNames() {
        //To do
        return null;
    }
    
    private String[] getName(String type, String[] array) {
        String[] information;
        
        String path = type + ".csv";
        File target = new File(path);
        path = target.getAbsolutePath();
        //System.out.println(path);
        
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
           String currentLine;
           int count = 0;
    
           while ((currentLine = read.readLine()) != null) {
               information = currentLine.split(",");
               array[count] = information[1];
               count++;
            }
           return array;
        } catch (IOException exc) {
           System.out.println("An error has occured: " + exc.getMessage());
        }
        return null;
    }
    
    
   /* public static void main(String[] arguments) {
        CsvLoader app = new CsvLoader();
        String[] result = new String[28];
        result = app.getIngredient("fuggle", "hops");
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        System.out.println(result[4]);
        System.out.println(result[5]);
        System.out.println(result[6]);
        System.out.println(result[7]); 
       // result = app.getBeerStyleNames();
      //  System.out.println(result[7]);
        //result = getBeerNames();
       // for (int i = 0; i < 28; i++) {
       //     if (i != 0 ) {
    //            System.out.println(result[i]);
     //       }
      //  }
    } */
}