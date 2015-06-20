package com.Ingredients;

public class yeast {
    
    //Global variables
    public String name;
    public String displayName;
    public String type;
    public String flocculation;
    public String attenuation;
    public String tempRange;
    public String alcoholTolerance;
    public String notes;
    public String[] yeastList = new String[28];
    
    /**
    * Only constructor, enables a String array that contains all of
    * the usable yeast ingredients.
    * 
    */
    public yeast() {
        //set grainList array values
        yeastList[0] = "Wyeast 1007 German Ale";
        yeastList[1] = "Wyeast 1010 American Wheat";
        yeastList[2] = "Wyeast 1056 American Ale";
        yeastList[3] = "Wyeast 1084 Irish Ale";
        yeastList[4] = "Wyeast 1098 British Ale";
        yeastList[5] = "Wyeast 1099 Whitbread Ale";
        yeastList[6] = "Wyeast 1187 Ringwood Ale";
        yeastList[7] = "Wyeast 1272 American Ale II";
        yeastList[8] = "Wyeast 1275 Thames Valley Ale";
        yeastList[9] = "Wyeast 1318 London Ale III";
        yeastList[10] = "Wyeast 1332 Northwest Ale";
        yeastList[11] = "Wyeast 1335 British Ale II";
        yeastList[12] = "Wyeast 1450 Danny's Favorate 50";
        yeastList[13] = "Wyeast 1469 West yorkshire Ale";
        yeastList[14] = "Wyeast 1728 Scottish Ale";
        yeastList[15] = "Wyeast 1968 London ESB Ale";
        yeastList[16] = "Wyeast 2565 Kolsch";
        yeastList[17] = "Wyeast 2000 Budvar Lager";
        yeastList[18] = "Wyeast 2001 Urquel Lager";
        yeastList[19] = "Wyeast 2007 Pilsen Lager";
        yeastList[20] = "Wyeast 2035 American Lager";
        yeastList[21] = "Wyeast 2042 Danish Lager";
        yeastList[22] = "Wyeast 2112 California Lager";
        yeastList[23] = "Wyeast 2124 Bohemain Lager";
        yeastList[24] = "Wyeast 2206 Bavarian Lager";
        yeastList[25] = "Wyeast 2278 Czech Pils";
        yeastList[26] = "Wyeast 2308 Munich Lager";
        yeastList[27] = "Wyeast 2633 Octoberfest Lager";
    }
    
  /**
    * Returns true if the ingredient exists, returns false if the
    * ingredient doesn't exist.
    * <p>
    * This method is intended to check the existence of an ingredient 
    * before calling the getIngredeints method.
    *
    * @param  in   a string name of the desired ingredient.
    * @return      Boolean status of the existence of the input. 
    */
    public boolean isIngredients(String in) {
        for (int i = 0; i < 28; i++) {
            if (in.equals(yeastList[i])) {
                return true;
            }
        }
        return false;
    }
    
  /**
    * Given a yeast name as a String, calls a helper function that
    * sets the characteristics in the UI.
    * <p>
    * This method is the main means to set yeast characteristics.  It
    * pulls the String information via a combo box in the main UI.
    *
    * @param  in   a string name of the desired ingredient.
    */
    public void getIngredients(String in) {
        if (in.equals("Wyeast 1007 German Ale")) {
            wyeast1007GermanAle();
        } else if (in.equals("Wyeast 1010 American Wheat")) {
            wyeast1010AmericanWheat();
        } else if (in.equals("Wyeast 1056 American Ale")) {
            wyeast1056AmericanAle();
        } else if (in.equals("Wyeast 1084 Irish Ale")) {
            wyeast1084IrishAle();
        } else if (in.equals("Wyeast 1098 British Ale")) {
            wyeast1098BritishAle();
        } else if (in.equals("Wyeast 1099 Whitbread Ale")) {
            wyeast1099WhitbreadAle();
        } else if (in.equals("Wyeast 1187 Ringwood Ale")) {
            wyeast1187RingwoodAle();
        } else if (in.equals("Wyeast 1272 American Ale II")) {
            wyeast1272AmericanAleII();
        } else if (in.equals("Wyeast 1275 Thames Valley Ale")) {
            wyeast1275ThamesValleyAle();
        } else if (in.equals("Wyeast 1318 London Ale III")) {
            wyeast1318LondonAleIII();
        } else if (in.equals("Wyeast 1332 Northwest Ale")) {
            wyeast1332NorthwestAle();
        } else if (in.equals("Wyeast 1335 British Ale II")) {
            wyeast1335BritishAleII();
        } else if (in.equals("Wyeast 1450 Danny's Favorate 50")) {
            wyeast1450DannysFavorate50();
        } else if (in.equals("Wyeast 1469 West yorkshire Ale")) {
            wyeast1469WestYorkshireAle();
        } else if (in.equals("Wyeast 1728 Scottish Ale")) {
            wyeast1728ScottishAle();
        } else if (in.equals("Wyeast 1968 London ESB Ale")) {
            wyeast1968LondonESBAle();
        } else if (in.equals("Wyeast 2565 Kolsch")) {
            wyeast2565Kolsch();
        } else if (in.equals("Wyeast 2000 Budvar Lager")) {
            wyeast200BudvarLager();
        } else if (in.equals("Wyeast 2001 Urquel Lager")) {
            wyeast2001UrquellLager();
        } else if (in.equals("Wyeast 2007 Pilsen Lager")) {
            wyeast2007PilsenLager();
        } else if (in.equals("Wyeast 2035 American Lager")) {
            wyeast2035AmericanLager();
        } else if (in.equals("Wyeast 2042 Danish Lager")) {
            wyeast2042DanishLager();
        } else if (in.equals("Wyeast 2112 California Lager")) {
            wyeast2112CaliforniaLager();
        } else if (in.equals("Wyeast 2124 Bohemain Lager")) {
            wyeast2124BohemainLager();
        } else if (in.equals("Wyeast 2206 Bavarian Lager")) {
            wyeast2206BavarianLager();
        } else if (in.equals("Wyeast 2278 Czech Pils")) {
            wyeast2278CzechPils();
        } else if (in.equals("Wyeast 2308 Munich Lager")) {
            wyeast2308MunichLager();
        } else if (in.equals("Wyeast 2633 Octoberfest Lager")) {
            wyeast2633OctoberfestLager();
        } 
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast1007GermanAle() {
        name = "wyeast1007GermanAle";
        displayName= "Wyeast 1007 German Ale";
        type = "Ale";
        flocculation = "Low";
        attenuation = "73-77";
        tempRange = "55-68";
        alcoholTolerance = "11";
        notes = "Higher temp ferminatation may produce mild fruitiness.  Beers mature rapidly.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast1010AmericanWheat() {
        name = "Wyeast 1010 American Wheat";
        displayName= "Wyeast 1010 American Wheat";
        type = "Ale";
        flocculation = "Low";
        attenuation = "74-78";
        tempRange = "58-74";
        alcoholTolerance = "10";
        notes = "Strong fermenating, produces dry slighty tart crisp beer.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast1056AmericanAle() {
        name = "wyeast1056AmericanAle";
        displayName= "Wyeast 1056 American Ale";
        type = "Ale";
        flocculation = "Low-Med";
        attenuation = "73-77";
        tempRange = "60-72";
        alcoholTolerance = "11";
        notes = "Crisp clean flavor, low fruitness.  Mild citrus notes develop with cooler (60-66) fermentations.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast1084IrishAle() {
        name = "wyeast1084IrishAle";
        displayName= "Wyeast 1084 Irish Ale";
        type = "Ale";
        flocculation = "Medium";
        attenuation = "71-75";
        tempRange = "62-72";
        alcoholTolerance = "12";
        notes = "When fermented in lower temps produces a dry, crisp profile with subtle fruitness.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast1098BritishAle() {
        name = "wyeast1098BritishAle";
        displayName= "Wyeast 1098 British Ale";
        type = "Ale";
        flocculation = "Medium";
        attenuation = "73-75";
        tempRange = "64-72";
        alcoholTolerance = "10";
        notes = "Allows malt and hop characteristics to dominate profile.  Dry and crisp, well balanced with a clean neutral finish.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast1099WhitbreadAle() {
        name = "wyeast1099WhitbreadAle";
        displayName= "Wyeast 1099 Whitbread Ale";
        type = "Ale";
        flocculation = "Med-High";
        attenuation = "68-72";
        tempRange = "64-75";
        alcoholTolerance = "10";
        notes = "Mild malty and slighty fruity profile.  Low fermentation temps will produce a clean finish.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast1187RingwoodAle() {
        name = "wyeast1187RingwoodAle";
        displayName= "Wyeast 1187 Ringwood Ale";
        type = "Ale";
        flocculation = "High";
        attenuation = "68-72";
        tempRange = "64-74";
        alcoholTolerance = "10";
        notes = "Distinc fruit esters with a malty, comples profile.  Strain can be a slow starter and fermenter.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast1272AmericanAleII() {
        name = "wyeast1272AmericanAleII";
        displayName= "Wyeast 1272 American Ale II";
        type = "Ale";
        flocculation = "Medium";
        attenuation = "72-76";
        tempRange = "60-72";
        alcoholTolerance = "10";
        notes = "Soft clean profile with hints of nut and slightly tart finish.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast1275ThamesValleyAle() {
        name = "wyeast1275ThamesValleyAle";
        displayName= "Wyeast 1275 Thames Valley Ale";
        type = "Ale";
        flocculation = "Low-Med";
        attenuation = "72-76";
        tempRange = "62-72";
        alcoholTolerance = "10";
        notes = "Produces classic brittish bitters with a rich complete flavor profile.  Light malt character, low fruitness, clean and well balanced.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast1318LondonAleIII() {
        name = "wyeast1318LondonAleIII";
        displayName= "Wyeast 1318 London Ale III";
        type = "Ale";
        flocculation = "High";
        attenuation = "71-75";
        tempRange = "64-74";
        alcoholTolerance = "10";
        notes = "Produces a wonderful malt and hop profile.  Fruity, very light and softly balanced palate.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast1332NorthwestAle() {
        name = "wyeast1332NorthwestAle";
        displayName= "Wyeast 1332 Northwest Ale";
        type = "High";
        flocculation = "High";
        attenuation = "67-71";
        tempRange = "65-75";
        alcoholTolerance = "10";
        notes = "Produces a malty and mildy fruty ale with good depth and complexity.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast1335BritishAleII() {
        name = "wyeast1335BritishAleII";
        displayName= "Wyeast 1335 British Ale II";
        type = "Ale";
        flocculation = "High";
        attenuation = "73-76";
        tempRange = "63-75";
        alcoholTolerance = "10";
        notes = "Malty flavor characteristics.  Finishes clean, crisp and fairly dry.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast1450DannysFavorate50() {
        name = "wyeast1450DannysFavorate50";
        displayName= "Wyeast 1450 Danny's Favorate 50";
        type = "Ale";
        flocculation = "Low";
        attenuation = "74-76";
        tempRange = "60-70";
        alcoholTolerance = "10";
        notes = "Produces a big mouthfeel and accentuates the malt, carmel or fruit character of a beer without being sweet.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast1469WestYorkshireAle() {
        name = "wyeast1469WestYorkshireAle";
        displayName= "Wyeast 1469 West yorkshire Ale";
        type = "Ale";
        flocculation = "High";
        attenuation = "67-71";
        tempRange = "64-72";
        alcoholTolerance = "9";
        notes = "Full chewy malt flavor and character but finishes dry.  Best used for cask-conditioned beers.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast1728ScottishAle() {
        name = "wyeast1728ScottishAle";
        displayName= "Wyeast 1728 Scottish Ale";
        type = "Ale";
        flocculation = "High";
        attenuation = "63-73";
        tempRange = "55-75";
        alcoholTolerance = "12";
        notes = "Unique suited for strong, malty ales.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast1968LondonESBAle() {
        name = "wyeast1968LondonESBAle";
        displayName= "Wyeast 1968 London ESB Ale";
        type = "Ale";
        flocculation = "Very High";
        attenuation = "67-71";
        tempRange = "64-72";
        alcoholTolerance = "9";
        notes = "Good cask conditioned ale strain.   Produces malty beers.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast2565Kolsch() {
        name = "wyeast2565Kolsch";
        displayName= "Wyeast 2565 Kolsch";
        type = "Ale";
        flocculation = "Low";
        attenuation = "73-77";
        tempRange = "56-70";
        alcoholTolerance = "10";
        notes = "Exhibit some friut character with a clean like profile.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast200BudvarLager() {
        name = "wyeast200BudvarLager";
        displayName= "Wyeast 2000 Budvar Lager";
        type = "Lager";
        flocculation = "Med-High";
        attenuation = "71-75";
        tempRange = "48-56";
        alcoholTolerance = "9";
        notes = "Malty nose subtle fruit tones and rich malt profile.  Finishes malty but dry.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast2001UrquellLager() {
        name = "wyeast2001UrquellLager";
        displayName= "Wyeast 2001 Urquel Lager";
        type = "Lager";
        flocculation = "Med-High";
        attenuation = "72-76";
        tempRange = "48-56";
        alcoholTolerance = "9";
        notes = "Mild friiut and floral aroma.  Very dry and clean palate.  Clean and neutral finish";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast2007PilsenLager() {
        name = "wyeast2007PilsenLager";
        displayName= "Wyeast 2007 Pilsen Lager";
        type = "Lager";
        flocculation = "Medium";
        attenuation = "71-75";
        tempRange = "48-56";
        alcoholTolerance = "9";
        notes = "Classic american lager.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast2035AmericanLager() {
        name = "wyeast2035AmericanLager";
        displayName= "Wyeast 2035 American Lager";
        type = "Lager";
        flocculation = "Medium";
        attenuation = "73-77";
        tempRange = "48-58";
        alcoholTolerance = "9";
        notes = "Complex and aromatic strain used for a variety of lager beers.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast2042DanishLager() {
        name = "wyeast2042DanishLager";
        displayName= "Wyeast 2042 Danish Lager";
        type = "Lager";
        flocculation = "Low";
        attenuation = "73-77";
        tempRange = "46-56";
        alcoholTolerance = "9";
        notes = "Good choice for Dortmund-style lagers.  Ferment crisp and dry.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast2112CaliforniaLager() {
        name = "wyeast2112CaliforniaLager";
        displayName= "Wyeast 2112 California Lager";
        type = "Lager";
        flocculation = "High";
        attenuation = "67-71";
        tempRange = "58-68";
        alcoholTolerance = "9";
        notes = "Produces lager characteristics up to 65 degrees with malty, and clear beers.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast2124BohemainLager() {
        name = "wyeast2124BohemainLager";
        displayName= "Wyeast 2124 Bohemain Lager";
        type = "Lager";
        flocculation = "Low-Med";
        attenuation = "73-77";
        tempRange = "45-68";
        alcoholTolerance = "9";
        notes = "Distinct malty profile with a clean finish.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast2206BavarianLager() {
        name = "wyeast2206BavarianLager";
        displayName= "Wyeast 2206 Bavarian Lager";
        type = "Lager";
        flocculation = "Med-High";
        attenuation = "73-77";
        tempRange = "46-58";
        alcoholTolerance = "9";
        notes = "Rich, full bodied, malty beers.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast2278CzechPils() {
        name = "wyeast2278CzechPils";
        displayName= "Wyeast 2278 Czech Pils";
        type = "Lager";
        flocculation = "Med-High";
        attenuation = "70-74";
        tempRange = "50-58";
        alcoholTolerance = "9";
        notes = "Finish dry and malty. ";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast2308MunichLager() {
        name = "wyeast2308MunichLager";
        displayName= "Wyeast 2308 Munich Lager";
        type = "Lager";
        flocculation = "Medium";
        attenuation = "70-74";
        tempRange = "48-56";
        alcoholTolerance = "9";
        notes = "Smooth, well rounded and full-bodied.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void wyeast2633OctoberfestLager() {
        name = "wyeast2633OctoberfestLager";
        displayName= "Wyeast 2633 Octoberfest Lager";
        type = "Lager";
        flocculation = "Low-Med";
        attenuation = "73-77";
        tempRange = "48-58";
        alcoholTolerance = "9";
        notes = "Rich, malty complex and full boided octoberfest.";
    }
    
    /*  public static void main(String[] arguments) {
        yeast app = new yeast();
        boolean check;
        check = app.isIngredients("Wyeast 1099 Whitbread Ale");
        if (check == true) {
            app.getIngredients("Wyeast 1099 Whitbread Ale");
            System.out.println("Name: " + app.displayName);
            System.out.println("Type: " + app.type);
            System.out.println("Flocculation: " + app.flocculation);
            System.out.println("Attenuation (%): " + app.attenuation);
            System.out.println("Temp Range: " + app.tempRange);
            System.out.println("Alcohol Tolerance: " + app.alcoholTolerance);
            System.out.println("Notes: " + app.notes);
        }
    }  */
}