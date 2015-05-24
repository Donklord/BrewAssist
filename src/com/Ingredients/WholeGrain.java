package com.Ingredients;

public class WholeGrain {
    
    //Global variables
    public String name;
    public String displayName;
    public double yield;
    public double colorLov;
    public double colorSrm;
    public double maxInBatch;
    public String notes;
    public String[] grainList = new String[47];
    
    
    public WholeGrain() {
        //set grainList array values
        grainList[0] = "Acid Malt";
        grainList[1] = "Amber malt";
        grainList[2] = "Aromatic Malt";
        grainList[3] = "Barley - Flaked";
        grainList[4] = "Barley - Raw";
        grainList[5] = "Barley - Torrefied";
        grainList[6] = "Brown Malt";
        grainList[7] = "Brumalt";
        grainList[8] = "Crystal Malt - 10";
        grainList[9] = "Crystal Malt - 20";
        grainList[10] = "Crystal Malt - 30";
        grainList[11] = "Crystal Malt - 40";
        grainList[12] = "Crystal Malt - 60";
        grainList[13] = "Crystal Malt - 80";
        grainList[14] = "Crystal Malt - 120";
        grainList[15] = "Caramunich";
        grainList[16] = "Carared";
        grainList[17] = "Caravienne";
        grainList[18] = "Chocolate Malt - US";
        grainList[19] = "Chocolate Malt - UK";
        grainList[20] = "Mild malt";
        grainList[21] = "Munich Malt";
        grainList[22] = "Munich Malt - 10";
        grainList[23] = "Munich Malt - 20";
        grainList[24] = "Pale Malt (2 row) Belgium";
        grainList[25] = "Pale Malt (2 row) UK";
        grainList[26] = "Pale Malt (2 row) US";
        grainList[27] = "Pale Malt (6 row) US";
        grainList[28] = "Peat Smoked Malt";
        grainList[29] = "Pilsner (2 row) Belgium";
        grainList[30] = "Pilsner (2 row) German";
        grainList[31] = "Pilsner (2 row) UK";
        grainList[32] = "Roasted Barley";
        grainList[33] = "Rye Malt";
        grainList[34] = "Rye Malt - Falked";
        grainList[35] = "Smoked Malt";
        grainList[36] = "Special B Malt";
        grainList[37] = "Special Roast";
        grainList[38] = "Toasted Malt";
        grainList[39] = "Victory Malt";
        grainList[40] = "Vienna Malt";
        grainList[41] = "Wheat Malt Belgium";
        grainList[42] = "Wheat Malt Dark";
        grainList[43] = "Wheat Malt Germain";
        grainList[44] = "Wheat Malt - Flaked";
        grainList[45] = "Wheat Malt - Roasted";
        grainList[46] = "White Wheat Malt";
    }
    
    public boolean isIngredients(String in) {
        for (int i = 0; i < 47; i++) {
            if (in.equals(grainList[i])) {
                return true;
            }
        }
        return false;
    }
    
    public void getIngredients(String in) {
        if (in.equals("Acid Malt")) {
            acidMalt();
        } else if (in.equals("Amber malt")) {
            amberMalt();
        } else if (in.equals("Aromatic Malt")) {
            aromaticMalt();
        } else if (in.equals("Barley - Flaked")) {
            barleyFlaked();
        } else if (in.equals("Barley - Raw")) {
            barleyRaw();
        } else if (in.equals("Barley - Torrefied")) {
            barleyTorrefied();
        } else if (in.equals("Brown Malt")) {
            brownMalt();
        } else if (in.equals("Brumalt")) {
            brumalt();
        } else if (in.equals("Crystal Malt - 10")) {
            crystalMalt10();
        } else if (in.equals("Crystal Malt - 20")) {
            crystalMalt20();
        } else if (in.equals("Crystal Malt - 30")) {
            crystalMalt30();
        } else if (in.equals("Crystal Malt - 40")) {
            crystalMalt40();
        } else if (in.equals("Crystal Malt - 60")) {
            crystalMalt60();
        } else if (in.equals("Crystal Malt - 80")) {
            crystalMalt80();
        } else if (in.equals("Crystal Malt - 120")) {
            crystalMalt120();
        } else if (in.equals("Caramunich")) {
            caramunich();
        } else if (in.equals("Carared")) {
            carared();
        } else if (in.equals("Caravienne")) {
            caravienne();
        } else if (in.equals("Chocolate Malt - US")) {
            chocolateUS();
        } else if (in.equals("Chocolate Malt - UK")) {
            chocolateUK();
        } else if (in.equals("Mild malt")) {
            mildMalt();
        } else if (in.equals("Munich Malt")) {
            munichMalt();
        } else if (in.equals("Munich Malt - 10")) {
            munichMalt10();
        } else if (in.equals("Munich Malt - 20")) {
            munichMalt20();
        } else if (in.equals("Pale Malt (2 row) Belgium")) {
            pale2RowBel();
        } else if (in.equals("Pale Malt (2 row) UK")) {
            pale2RowUK();
        } else if (in.equals("Pale Malt (2 row) US")) {
            pale2RowUS();
        } else if (in.equals("Pale Malt (6 row) US")) {
            pale6RowUS();
        } else if (in.equals("Peat Smoked Malt")) {
            peatSmoked();
        } else if (in.equals("Pilsner (2 row) Belgium")) {
            pilsner2RowBel();
        } else if (in.equals("Pilsner (2 row) German")) {
            pilsner2RowGer();
        } else if (in.equals("Pilsner (2 row) UK")) {
            pilsner2RowUK();
        } else if (in.equals("Roasted Barley")) {
            roastedBarley();
        } else if (in.equals("Rye Malt")) {
            ryeMalt();
        } else if (in.equals("Rye Malt - Falked")) {
            ryeFlaked();
        } else if (in.equals("Smoked Malt")) {
            smokedMalt();
        } else if (in.equals("Special B Malt")) {
            specialB();
        } else if (in.equals("Special Roast")) {
            specialRoast();
        } else if (in.equals("Toasted Malt")) {
            toastedMalt();
        } else if (in.equals("Victory Malt")) {
            victoryMalt();
        } else if (in.equals("Vienna Malt")) {
            viennaMalt();
        } else if (in.equals("Wheat Malt Belgium")) {
            wheatBel();
        } else if (in.equals("Wheat Malt Dark")) {
            wheatDark();
        } else if (in.equals("Wheat Malt Germain")) {
            wheatGer();
        } else if (in.equals("Wheat Malt - Flaked")) {
            wheatFlaked();
        } else if (in.equals("Wheat Malt - Roasted")) {
            wheatRoasted();
        } else if (in.equals("White Wheat Malt")) {
            whiteWheat();
        }
    }
    
    //Whole Grain Types Helper Methods
    
    private void acidMalt() {
        name = "acidMalt";
        displayName= "Acid malt";
        colorLov = 2.6;
        colorSrm = 3;
        yield = 58.7;
        maxInBatch = 10;
        notes = "Used to adjust PH without chemicals.  Enhances head retention.";
    }
    
    private void amberMalt() {
        name = "amberMalt";
        displayName= "Amber Malt";
        colorLov = 16.74;
        colorSrm = 22;
        yield = 75;
        maxInBatch = 20;
        notes = "Used in english browns adds color and biscuit taste.  Intense flavor - limit use";
    }
    
    private void aromaticMalt() {
        name = "aromaticMalt";
        displayName= "Aromatic Malt";
        colorLov = 19.7;
        colorSrm = 26;
        yield = 78;
        maxInBatch = 10;
        notes = "Provides strong malt flavor and aroma";
    }
    
    private void barleyFlaked() {
        name = "barleyFlaked";
        displayName= "Barley - Flaked";
        colorLov = 1.9;
        colorSrm = 2;
        yield = 70;
        maxInBatch = 20;
        notes = "Adds significant body to Porters and Stouts. ";
    }
    
    private void barleyRaw() {
        name = "barleyRaw";
        displayName= "Barley - Raw";
        colorLov = 1.9;
        colorSrm = 2;
        yield = 60.9;
        maxInBatch = 15;
        notes = "Raw and unmalted can be used to add body to beer.  Requires fine milling and multi stage mash.";
    }
    
    private void barleyTorrefied() {
        name = "barleyTorrefied";
        displayName= "Barley - Torrefied";
        colorLov = 1.92;
        colorSrm = 2;
        yield = 79;
        maxInBatch = 40;
        notes = "Raw that has been cracked open.  Faster conversion when compared to raw, higher yeild.";
    }
    
    private void brownMalt() {
        name = "brownMalt";
        displayName= "Brown Malt";
        colorLov = 48.6;
        colorSrm = 65;
        yield = 70;
        maxInBatch = 10;
        notes = "Adds dry biscuit flavor.  Used in nut brown ales, porters and some belgian.";
    }
    
    private void brumalt() {
        name = "brumalt";
        displayName= "Brumalt";
        colorLov = 17.4;
        colorSrm = 23;
        yield = 71.7;
        maxInBatch = 10;
        notes = "Dark german.  Add malt flavor of Alt Marzen and Oktoberfest beers.";
    }
    
    private void crystalMalt10() {
        name = "crystalMalt10";
        displayName= "Crystal Malt - 10";
        colorLov = 7.9;
        colorSrm = 10;
        yield = 75;
        maxInBatch = 20;
        notes = "Adds body, color.  Improves head retention.";
    }
    
    private void crystalMalt20() {
        name = "crystalMalt10";
        displayName= "Crystal Malt - 10";
        colorLov = 15.2;
        colorSrm = 20;
        yield = 75;
        maxInBatch = 20;
        notes = "Adds body, color.  Improves head retention.";
    }
    
    private void crystalMalt30() {
        name = "crystalMalt10";
        displayName= "Crystal Malt - 10";
        colorLov = 22.6;
        colorSrm = 30;
        yield = 75;
        maxInBatch = 20;
        notes = "Adds body, color.  Improves head retention.";
    }
    
    private void crystalMalt40() {
        name = "crystalMalt10";
        displayName= "Crystal Malt - 10";
        colorLov = 30.1;
        colorSrm = 40;
        yield = 74;
        maxInBatch = 20;
        notes = "Adds body, color.  Improves head retention.";
    }
    
    private void crystalMalt60() {
        name = "crystalMalt10";
        displayName= "Crystal Malt - 10";
        colorLov = 44.9;
        colorSrm = 60;
        yield = 74;
        maxInBatch = 20;
        notes = "Adds body, color.  Improves head retention.";
    }
    
    private void crystalMalt80() {
        name = "crystalMalt10";
        displayName= "Crystal Malt - 10";
        colorLov = 59.7;
        colorSrm = 80;
        yield = 74;
        maxInBatch = 20;
        notes = "Adds body, color.  Improves head retention.";
    }
    
    private void crystalMalt120() {
        name = "crystalMalt10";
        displayName= "Crystal Malt - 10";
        colorLov = 89.3;
        colorSrm = 120;
        yield = 72;
        maxInBatch = 20;
        notes = "Adds body, color.  Improves head retention.";
    }
    
    private void caramunich() {
        name = "caramunich";
        displayName= "Caramunich";
        colorLov = 41.9;
        colorSrm = 56;
        yield = 71.7;
        maxInBatch = 10;
        notes = "Carmel, copper colored malt.  Used in belgian ales and German bocks.";
    }
    
    private void carared() {
        name = "carared";
        displayName= "Carared";
        colorLov = 15.3;
        colorSrm = 20;
        yield = 75;
        maxInBatch = 20;
        notes = "Adds body, color.  Improves head retention.";
    }
    
    private void caravienne() {
        name = "caravienne";
        displayName= "Caravienne";
        colorLov = 16.7;
        colorSrm = 22;
        yield = 73.9;
        maxInBatch = 10;
        notes = "Light Belgian crystal malt.  Used in light trappist and abbey style Belgian ales.";
    }
    
    private void chocolateUS() {
        name = "chocolateUS";
        displayName= "Chocolate Malt - US";
        colorLov = 259.7;
        colorSrm = 350;
        yield = 60;
        maxInBatch = 10;
        notes = "Dark malt.  Provides righ red or brown color and nutty flavor.  Used for Brown ales, porters and some stouts.";
    }
    
    private void chocolateUK() {
        name = "chocolateUK";
        displayName= "Chocolate Malt - UK";
        colorLov = 333.8;
        colorSrm = 450;
        yield = 73;
        maxInBatch = 10;
        notes = "Dark malt.  Provides righ red or brown color and nutty flavor.  Used for Brown ales, porters and some stouts.";
    }
    
    private void mildMalt() {
        name = "mildMalt";
        displayName= "Mild Malt";
        colorLov = 3.4;
        colorSrm = 4;
        yield = 80;
        maxInBatch = 100;
        notes = "English Mild A light specialty malt used in Brown Ales";
    }
    
    private void munichMalt() {
        name = "munichMalt";
        displayName= "Munich Malt";
        colorLov = 7.1;
        colorSrm = 9;
        yield = 80;
        maxInBatch = 80;
        notes = "Malty - sweet flavor, adds reddish amber color.  Does not contribute signficantly to body or head retention.  Used for Bock, porter, marzen, oktoberfest beers.";
    }
    
    private void munichMalt10() {
        name = "munichMalt10";
        displayName= "Munich Malt - 10";
        colorLov = 7.9;
        colorSrm = 10;
        yield = 77;
        maxInBatch = 80;
        notes = "Malty - sweet flavor, adds slight orange color.  Does not contribute signficantly to body or head retention.  Used for Bock, porter, marzen, oktoberfest beers.";
    }
    
    private void munichMalt20() {
        name = "munichMalt20";
        displayName= "Munich Malt - 20";
        colorLov = 15.3;
        colorSrm = 20;
        yield = 75;
        maxInBatch = 80;
        notes = "Malty -  sweet flavor, adds orange color.  Does not contribute signficantly to body or head retention.  Used for Bock, porter, marzen, oktoberfest beers.";
    }
    
    private void pale2RowBel() {
        name = "pale2RowBel";
        displayName= "Pale Malt (2 row) Belgium";
        colorLov = 2.7;
        colorSrm = 3;
        yield = 80;
        maxInBatch = 100;
        notes = "Base malt for all styles.";
    }
    
    private void pale2RowUK() {
        name = "pale2RowUK";
        displayName= "Pale Malt (2 row) UK";
        colorLov = 2.7;
        colorSrm = 3;
        yield = 78;
        maxInBatch = 100;
        notes = "Base malt for all English styles.";
    }
    
    private void pale2RowUS() {
        name = "pale2RowUS";
        displayName= "Pale Malt (2 row) US";
        colorLov = 1.9;
        colorSrm = 2;
        yield = 79;
        maxInBatch = 100;
        notes = "Base malt for all styles.";
    }
    
    private void pale6RowUS() {
        name = "pale6RowUS";
        displayName= "Pale Malt (6 row) US";
        colorLov = 1.9;
        colorSrm = 2;
        yield = 76;
        maxInBatch = 100;
        notes = "Base malt for all styles.";
    }
    
    private void peatSmoked() {
        name = "peatSmoked";
        displayName= "Peat Smoked";
        colorLov = 2.7;
        colorSrm = 3;
        yield = 74;
        maxInBatch = 20;
        notes = "Robust smokey malt, provides smoky flavor.  Used in scottish ales.";
    }
    
    private void pilsner2RowBel() {
        name = "pilsner2RowBel";
        displayName= "Pilsner (2 row) Belgium";
        colorLov = 1.9;
        colorSrm = 2;
        yield = 79;
        maxInBatch = 100;
        notes = "Base malt for Continental lagers.";
    }
    
    private void pilsner2RowGer() {
        name = "pilsner2RowGer";
        displayName= "Pilsner (2 row) German";
        colorLov = 1.9;
        colorSrm = 2;
        yield = 81;
        maxInBatch = 100;
        notes = "Base malt for Pilsners and Bohemian Lagers.";
    }
    
    private void pilsner2RowUK() {
        name = "pilsner2RowUK";
        displayName= "Pilsner (2 row) UK";
        colorLov = 1.2;
        colorSrm = 1;
        yield = 78;
        maxInBatch = 100;
        notes = "Pilsner base malt.";
    }
    
    private void roastedBarley() {
        name = "roastedBarley";
        displayName= "Roasted Barley";
        colorLov = 222.7;
        colorSrm = 300;
        yield = 55;
        maxInBatch = 10;
        notes = "Roasted to create a burnt, grainy, coffee like flavor.  Imparts red to deep brown color.  Adds very strong roasted flavor.  Used in 2-4 % in Brown ales for nutty flavor.  3-10% in porters for coffee flavor";
    }
    
    private void ryeMalt() {
        name = "ryeMalt";
        displayName= "Rye Malt";
        colorLov = 4.1;
        colorSrm = 5;
        yield = 63;
        maxInBatch = 15;
        notes = "Adds a dry, crisp characteristic to beer.  Imparts deep red color and distincive rye flavor.";
    }
    
    private void ryeFlaked() {
        name = "ryeFlaked";
        displayName= "Rye Malt - Flaked";
        colorLov = 1.9;
        colorSrm = 2;
        yield = 78.3;
        maxInBatch = 10;
        notes = "Adds a dry, crisp favor to rye beers.  Can be easier to mash than raw rye.";
    }
    
    private void smokedMalt() {
        name = "smokedMalt";
        displayName= "Smoked Malt";
        colorLov = 7.1;
        colorSrm = 9;
        yield = 80;
        maxInBatch = 100;
        notes = "Smoked over open fire, creates smoked flavor and aroma.  Used for German Rauchbier but can be added to Brown Ales and Porters.";
    }
    
    private void specialB() {
        name = "specialB";
        displayName= "Special B";
        colorLov = 133.8;
        colorSrm = 180;
        yield = 65.2;
        maxInBatch = 10;
        notes = "Extreme carmel aroma and flavord malt.  Used in dark Belgian abbey and Trappist ales.";
    }
    
    private void specialRoast() {
        name = "specialRoast";
        displayName= "Special Roast";
        colorLov = 37.5;
        colorSrm = 50;
        yield = 72;
        maxInBatch = 10;
        notes = "Used for English ales, nut brown ales, and porters.  Adds toasted, biscuit like flavor and aroma.";
    }
    
    private void toastedMalt() {
        name = "toastedMalt";
        displayName= "Toasted Malt";
        colorLov = 20.4;
        colorSrm = 27;
        yield = 71.7;
        maxInBatch = 10;
        notes = "Adds reddish / orange color.  Improves body with sweetnesss.  Tasted flavor.  Similar to biscuit or victory malt.";
    }
    
    private void victoryMalt() {
        name = "victoryMalt";
        displayName= "Victory Malt";
        colorLov = 19;
        colorSrm = 25;
        yield = 73;
        maxInBatch = 15;
        notes = "Adds \"Biscuit\" or tosted flavor to English ales.  Used for Nut brown ales and porters.";
    }
    
    private void viennaMalt() {
        name = "viennaMalt";
        displayName= "Vienna Malt";
        colorLov = 3.4;
        colorSrm = 4;
        yield = 78;
        maxInBatch = 90;
        notes = "Imparts golden to orange color to the beer.";
    }
    
    private void wheatBel() {
        name = "wheatBel";
        displayName= "Wheat Malt Belgium";
        colorLov = 1.9;
        colorSrm = 2;
        yield = 81;
        maxInBatch = 60;
        notes = "Malted wheat for use in Wheat Beers";
    }
    
    private void wheatDark() {
        name = "wheatDark";
        displayName= "Wheat Malt Dark";
        colorLov = 7.1;
        colorSrm = 9;
        yield = 84;
        maxInBatch = 20;
        notes = "Dark malted wheat for use in dark what styles such as Dunkeweizen.";
    }
    
    private void wheatGer() {
        name = "wheatGer";
        displayName= "Wheat Malt German";
        colorLov = 1.9;
        colorSrm = 2;
        yield = 84;
        maxInBatch = 60;
        notes = "Malted wheat base for use in all wheat styles.";
    }
    
    private void wheatFlaked() {
        name = "wheatFlaked";
        displayName= "Wheat Malt - Flaked";
        colorLov = 1.9;
        colorSrm = 2;
        yield = 77;
        maxInBatch = 40;
        notes = "Increase body and foam retention. Used for faster conversion and better yeild.  Used in Belgian white and wit.";
    }
    
    private void wheatRoasted() {
        name = "wheatRoasted";
        displayName= "Wheat Malt - Roasted";
        colorLov = 315.3;
        colorSrm = 425;
        yield = 54.3;
        maxInBatch = 10;
        notes = "AKA Chocolate Wheat Malt.  Adds deep dark brown color.  Used in Dunkelweizens and other dark styles.  Roasted, woody, charcoal or burnt toast flavor (depends on degree of roasting)";
    }
    
    private void whiteWheat() {
        name = "whiteWheat";
        displayName= "White Wheat Malt";
        colorLov = 1.9;
        colorSrm = 2;
        yield = 86;
        maxInBatch = 60;
        notes = "Gives malty flavor from raw wheat.  Used in Weiss, Wit and White beers.";
    }
    
     /* public static void main(String[] arguments) {
        WholeGrain app = new WholeGrain();
        boolean check;
        check = app.isIngredients("caramunich");
        if (check == true) {
            app.getIngredients("caramunich");
            System.out.println("Name: " + app.displayName);
            System.out.println("Color Lovibond: " + app.colorLov);
            System.out.println("Color SRM: " + app.colorSrm);
            System.out.println("% Yield: " + app.yield);
            System.out.println("% Max In Batch: " + app.maxInBatch);
            System.out.println("Notes: " + app.notes);
        }
    } */
}