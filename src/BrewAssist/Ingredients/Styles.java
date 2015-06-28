package BrewAssist.Ingredients;

public class Styles {
    
    //Global variables
    public String displayName;
    public String ibu;
    public String srm;
    public String og;
    public String fg;
    public String abv;
    public String type;
    public String notes;
    public String[] styleList = new String[27];
    
  /**
    * Only constructor, enables a String array that contains all of
    * the usable beer styles.
    * 
    */
    public Styles() {
        //set grainList array values
        styleList[0] = "American Light Lager";
        styleList[1] = "American Lager";
        styleList[2] = "Cream Ale";
        styleList[3] = "American Wheat Ale";
        styleList[4] = "International Pale Lager";
        styleList[5] = "International Amber Lager";
        styleList[6] = "International Dark Lager";
        styleList[7] = "Czech Pale Lager";
        styleList[8] = "Czech Premium Pale Lager";
        styleList[9] = "Czech Amber Lager";
        styleList[10] = "Czech Dark Lager";
        styleList[11] = "Munich Helles";
        styleList[12] = "Festbier";
        styleList[13] = "Helles Bock";
        styleList[14] = "German Leichtbier";
        styleList[15] = "Kolsch";
        styleList[16] = "German Helles Exportbier";
        styleList[17] = "German Pils";
        styleList[18] = "ViennaLager";
        styleList[19] = "Munich Dunkel";
        styleList[20] = "Doppelbock";
        styleList[21] = "Weissbier";
        styleList[22] = "Irish Red Ale";
        styleList[23] = "Blonde Ale";
        styleList[24] = "American Pale Ale";
        styleList[25] = "American Amber Ale";
        styleList[26] = "American Brown Ale";
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
        for (int i = 0; i < 27; i++) {
            if (in.equals(styleList[i])) {
                return true;
            }
        }
        return false;
    }
    
  /**
    * Given a beer name as a String, calls a helper function that
    * sets the characteristics in the UI.
    * <p>
    * This method is the main means to set beer style characteristics.  It
    * pulls the String information via a combo box in the main UI.
    *
    * @param  in   a string name of the desired ingredient.
    */
    public void getIngredients(String in) {
        if (in.equals("American Light Lager")) {
            americanLightLager();
        } else if (in.equals("American Lager")) {
            americanLager();
        } else if (in.equals("Cream Ale")) {
            creamAle();
        } else if (in.equals("American Wheat Ale")) {
            americanWheatAle();
        } else if (in.equals("International Pale Lager")) {
            intPaleLager();
        } else if (in.equals("International Amber Lager")) {
            intAmberLager();
        } else if (in.equals("International Dark Lager")) {
            intDarkLager();
        } else if (in.equals("Czech Pale Lager")) {
            czechPaleLager();
        } else if (in.equals("Czech Premium Pale Lager")) {
            czechPremiumPaleLager();
        } else if (in.equals("Czech Amber Lager")) {
            czechAmberLager();
        } else if (in.equals("Czech Dark Lager")) {
            czechDarkLager();
        } else if (in.equals("Munich Helles")) {
            munichHelles();
        } else if (in.equals("Festbier")) {
            festbier();
        } else if (in.equals("Helles Bock")) {
            hellesBock();
        } else if (in.equals("German Leichtbier")) {
            germanLeichtbier();
        } else if (in.equals("Kolsch")) {
            kolsch();
        } else if (in.equals("German Helles Exportbier")) {
            germanHellesExportbier();
        } else if (in.equals("German Pils")) {
            germanPils();
        } else if (in.equals("ViennaLager")) {
            viennaLager();
        } else if (in.equals("Munich Dunkel")) {
            munichDunkel();
        } else if (in.equals("Doppelbock")) {
            doppelbock();
        } else if (in.equals("Weissbier")) {
            weissbier();
        } else if (in.equals("Irish Red Ale")) {
            irishRedAle();
        } else if (in.equals("Blonde Ale")) {
            blondeAle();
        } else if (in.equals("American Pale Ale")) {
            americanPaleAle();
        } else if (in.equals("American Amber Ale")) {
            americanAmberAle();
        } else if (in.equals("American Brown Ale")) {
            americanBrownAle();
        }
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void americanLightLager() {
        displayName= "American Light Lager";
        ibu = "8-12";
        srm = "2-3";
        og = "1.028-1.040";
        fg = "0.998-1.008";
        abv = "2.4-4.2";
        type = "Lager";
        notes = "2 or 6 row barley with high percentage of corn or rice adjunts (up to 40%).";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void americanLager() {
        displayName= "American Lager";
        ibu = "8-18";
        srm = "2-4";
        og = "1.040-1.050";
        fg = "1.004-1.010";
        abv = "4.2-5.3";
        type = "lager";
        notes = "2 or 6 row barley with high percentage of corn or rice adjunts (up to 40%).";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void creamAle() {
        displayName= "Cream Ale";
        ibu = "8-20";
        srm = "2.5-5";
        og = "1.042-1.055";
        fg = "1.006-1.012";
        abv = "4.2-506";
        type = "Ale";
        notes = "American ingredients.  2 and 6 row barley common  Any variety of hops.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void americanWheatAle() {
        displayName= "American Wheat Ale";
        ibu = "15-30";
        srm = "3-6";
        og = "1.040-1,055";
        fg = "1.008-1.013";
        abv = "4-5.5";
        type = "Ale";
        notes = "German weissbeir yeast is inappropriate.  Large proportion of wheat malt (often 30-50%).  American german or new owrld hops are typical.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void intPaleLager() {
        displayName= "International Pale Lager";
        ibu = "18-25";
        srm = "2-6";
        og = "1.042-1.050";
        fg = "1.008-1.013";
        abv = "4.6-6";
        type = "Lager";
        notes = "2 or 6 row barley generaly more bitter and filling than american lager.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void intAmberLager() {
        displayName= "International Amber Lager";
        ibu = "8-25";
        srm = "7-14";
        og = "1.042-1.055";
        fg = "1.008-1.014";
        abv = "4.6-6";
        type = "Lager";
        notes = "2 or 6 row barley color malts such as victory or amber… ect.   Carmal malts as well.  European or American hops .";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void intDarkLager() {
        displayName= "International Dark Lager";
        ibu = "8-20";
        srm = "14-22";
        og = "1.044-1.056";
        fg = "1.008-1.012";
        abv = "4.2-6";
        type = "Lager";
        notes = "2 or 6 row barley.  Light use of carmel and darker malts.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void czechPaleLager() {
        displayName= "Czech Pale Lager";
        ibu = "20-35";
        srm = "3-6";
        og = "1.028-1.044";
        fg = "1.008-1.014";
        abv = "3-4.1";
        type = "Lager";
        notes = "Soft water with low sulfate and carbon content.  Saazer-type hops.  Czech pilsner malt and czech lager yeast.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void czechPremiumPaleLager() {
        displayName= "Czech Premium Pale Lager";
        ibu = "30-45";
        srm = "3.5-6";
        og = "1.044-1.060";
        fg = "1.013-1.017";
        abv = "4.2-5.8";
        type = "Lager";
        notes = "Soft water with low sulfate and carbon content.  Saazer-type hops.  Czech pilsner malt and czech lager yeast.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void czechAmberLager() {
        displayName= "Czech Amber Lager";
        ibu = "20-35";
        srm = "10-16";
        og = "1.044-1.060";
        fg = "1.013-1.017";
        abv = "4.4-5.8";
        type = "Lager";
        notes = "Pilsner and carmel malts.  Vienna and Muncih malts may also be used.  Low mineral content water and Saazer type hops.  Czech lager yeast.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void czechDarkLager() {
        displayName= "Czech Dark Lager";
        ibu = "18-34";
        srm = "14-35";
        og = "1.044-1.060";
        fg = "1.013-1.017";
        abv = "4.4-5.8";
        type = "Lager";
        notes = "Pilsner and dark carmel malts with addition of roasted malts.  Low mineral content water and saazer type hops.  Czech lager yeast.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void munichHelles() {
        displayName= "Munich Helles";
        ibu = "16-22";
        srm = "3-5";
        og = "1.044-1.048";
        fg = "1.006-1.012";
        abv = "4.7-5.4";
        type = "Lager";
        notes = "Contiental pilsner malt and traditional german saazer type hops.  Clean german lager yeast.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void festbier() {
        displayName= "Festbier";
        ibu = "18-25";
        srm = "4-7";
        og = "1.054-1.057";
        fg = "1.011-1.012";
        abv = "5.8-6.3";
        type = "Lager";
        notes = "Majority pils malt with some Vienna and/or Munich malt.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void hellesBock() {
        displayName= "Helles Bock";
        ibu = "23-35";
        srm = "6-11";
        og = "1.064-1.072";
        fg = "1.011-1.018";
        abv = "6.3-7.4";
        type = "Lager";
        notes = "Base of pils and or vienna malt with some Munich malt.  Saazer type hops and clean lager yeast.";
    }
    
    /**
    * Sets the global variables to the given style.
    *
    */
    private void germanLeichtbier() {
        displayName= "German Leichtbier";
        ibu = "15-28";
        srm = "2-5";
        og = "1.026-1.034";
        fg = "1.006-1.010";
        abv = "2.4-3.6";
        type = "";
        notes = "Similar to a german pils or hells.  Cotinental pils malt with german lager yeast and saazer type hops.";
    }
    
    /**
    * Sets the global variables to the given style.
    *
    */
    private void kolsch() {
        displayName= "Kolsch";
        ibu = "18-30";
        srm = "3.5-5";
        og = "1.044-1.050";
        fg = "1.007-1.011";
        abv = "4.4-5.2";
        type = "Lager";
        notes = "German hops and german pils or pale malts.  Clean yeast and up to 20% wheat malt may be used.  (this is rare in the authentic version.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void germanHellesExportbier() {
        displayName= "German Helles Exportbier";
        ibu = "20-30";
        srm = "4-7";
        og = "1.048-1.056";
        fg = "1.010-1.015";
        abv = "4.8-6";
        type = "Lager";
        notes = "German or Czech hops.  Pilsner malt with german lager yeast.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void germanPils() {
        displayName= "German Pils";
        ibu = "22-40";
        srm = "2-5";
        og = "1.044-1.050";
        fg = "1.008-1.013";
        abv = "4.4-5.2";
        type = "";
        notes = "Continental pilser malt with german hop varieties.  German lager yeast.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void viennaLager() {
        displayName= "ViennaLager";
        ibu = "18-30";
        srm = "9-15";
        og = "1.048-1.055";
        fg = "1.010-1.014";
        abv = "4.7-5.5";
        type = "Lager";
        notes = "Vienna malt continental hops. Can use some carmel and / or darker malts.  Only finest quality ingredients.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void munichDunkel() {
        displayName= "Munich Dunkel";
        ibu = "18-28";
        srm = "14-28";
        og = "1.048-1.056";
        fg = "1.010-1.016";
        abv = "4.5-5.6";
        type = "Lager";
        notes = "Munich malt with the remainder in german pils.  Smallamounts of crystal malt (small amount).  Traditional german hop varities and german lager yeast.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void doppelbock() {
        displayName= "Doppelbock";
        ibu = "16-26";
        srm = "6-25";
        og = "1.072-1.112";
        fg = "1.016-1.024";
        abv = "7-10";
        type = "Lager";
        notes = "Pils and / or vienna malt.  Muncih and vienna malts for daker versions.  Saazer type hops and clean lager yeast.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void weissbier() {
        displayName= "Weissbier";
        ibu = "5-15";
        srm = "2-6";
        og = "1.044-1.052";
        fg = "1.010-1.014";
        abv = "4.3-5.6";
        type = "Both";
        notes = "At least 50% malted wheat (traditionally) raminder is pilsner malt  Weizen ale yeast.";
    }
    
    private void irishRedAle() {
        displayName= "Irish Red Ale";
        ibu = "18-28";
        srm = "9-14";
        og = "1.036-1.046";
        fg = "1.010-,1014";
        abv = "3.8-5";
        type = "Ale";
        notes = "Bit of roasted or black malt.  Pale base malt.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void blondeAle() {
        displayName= "Blonde Ale";
        ibu = "15-28";
        srm = "3-6";
        og = "1.038-1.054";
        fg = "1.008-1.013";
        abv = "3.8-5.5";
        type = "Ale";
        notes = "Can include up to 25% wheat malt.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void americanPaleAle() {
        displayName= "American Pale Ale";
        ibu = "30-50";
        srm = "5-10";
        og = "1.045-1.060";
        fg = "1.010-1.015";
        abv = "4.5-6.2";
        type = "Ale";
        notes = "Pale ale malt typically US 2 row.  American or new world hops.  American or English ale yeast.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void americanAmberAle() {
        displayName= "American Amber Ale";
        ibu = "25-40";
        srm = "10-17";
        og = "1.045-1.060";
        fg = "1.010-1.015";
        abv = "4.5-6.2";
        type = "Ale";
        notes = "Pale ale malt typically US 2 row.  American or new world hops.  American or English ale yeast.  Medium to dark crystal malts.";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void americanBrownAle() {
        displayName= "American Brown Ale";
        ibu = "20-30";
        srm = "18-35";
        og = "1.045-1.060";
        fg = "1.010-1.016";
        abv = "4.5-6.2";
        type = "Ale";
        notes = "Pale malt plus crystal and darker malts.  American hops are typical.";
    }
    
      /*public static void main(String[] arguments) {
        Styles app = new Styles();
        boolean check;
        check = app.isIngredients(null)
        if (check == true) {
            app.getIngredients("Helles Bock");
            System.out.println("Name: " + app.displayName);
            System.out.println("IBU: " + app.ibu);
            System.out.println("SRM: " + app.srm);
            System.out.println("OG: " + app.og);
            System.out.println("FG: " + app.fg);
            System.out.println("ABV: " + app.abv);
            System.out.println("Type: " + app.type);
            System.out.println("Notes: " + app.notes);
        }
    }  */
}