package com.BrewAssist;

import java.io.*;
import java.util.*;

public class CsvLoader {
    public CsvLoader() {
        //Empty constructor
    }
    
    public String[] getIngredient(String itemName, String type) {
       String[] information;
       String[] match = new String[8];
       
       try (BufferedReader read = new BufferedReader(new FileReader("res/data/" + type + ".csv"))) {
           String currentLine;
    
           while ((currentLine = read.readLine()) != null) {
               information = currentLine.split(",");
               match[0] = information[0];
               match[1] = information[1];
               match[2] = information[2];
               match[3] = information[3];
               if (type.equals("yeast") || type.equals("wholeGrain")) {
                   match[4] = information[4];
                   match[5] = information[5];
                   match[6] = information[6];
               }
               if (type.equals("yeast")) {
                   match[7] = information[7];
               }
               
               
               if (itemName.equals(match[0])) {
                   return match;
               }
            }
        } catch (IOException exc) {
           System.out.println("An error has occured: " + exc.getMessage());
        }
        return null;
    }
    
 /*   public static void main(String[] arguments) {
        CsvLoader app = new CsvLoader();
        String[] result = new String[8];
        result = app.getIngredient("fuggle", "hops");
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
        System.out.println(result[3]);
        System.out.println(result[4]);
        System.out.println(result[5]);
        System.out.println(result[6]);
        System.out.println(result[7]);
    }*/
}