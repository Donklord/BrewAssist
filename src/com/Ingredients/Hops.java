package com.Ingredients;

public class Hops {
    
    //Global variables
    public String name;
    public String displayName;
    public double alphaAcid;
    public String betaAcid;
    public String[] hopList = new String[31];
    
    /**
    * Only constructor, enables a String array that contains all of
    * the usable hop ingredients.
    * 
    */
    public Hops() {
        //set grainList array values
        hopList[0] = "Ahtanum";
        hopList[1] = "Amarillo";
        hopList[2] = "Cascade";
        hopList[3] = "Centennial";
        hopList[4] = "Chinook";
        hopList[5] = "Columbus";
        hopList[6] = "Cluster";
        hopList[7] = "Crystal";
        hopList[8] = "Fuggle";
        hopList[9] = "Galena";
        hopList[10] = "Golding";
        hopList[11] = "Hallertau mf";
        hopList[12] = "Horizon";
        hopList[13] = "Liberty";
        hopList[14] = "Magnum";
        hopList[15] = "Mount Hood";
        hopList[16] = "Northern Brewer";
        hopList[17] = "Nugget";
        hopList[18] = "Perle";
        hopList[19] = "Saaz";
        hopList[20] = "Satus";
        hopList[21] = "Simcoe";
        hopList[22] = "Spalt Select";
        hopList[23] = "Sterling";
        hopList[24] = "Tettnang";
        hopList[25] = "Tomahawk";
        hopList[26] = "Ultra";
        hopList[27] = "US Fuggle";
        hopList[28] = "Vanguard";
        hopList[29] = "Warrior";
        hopList[30] = "Willamette";
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
        for (int i = 0; i < 31; i++) {
            if (in.equals(hopList[i])) {
                return true;
            }
        }
        return false;
    }
    
    /**
    * Given a hop name as a String, calls a helper function that
    * sets the characteristics in the UI.
    * <p>
    * This method is the main means to set hop characteristics.  It
    * pulls the String information via a combo box in the main UI.
    *
    * @param  in   a string name of the desired ingredient.
    */
    public void getIngredients(String in) {
        if (in.equals("Ahtanum")) {
            ahtanum();
        } else if (in.equals("Amarillo")) {
            amarillo();
        } else if (in.equals("Cascade")) {
            cascade();
        } else if (in.equals("Centennial")) {
            centennial();
        } else if (in.equals("Chinook")) {
            chinook();
        } else if (in.equals("Columbus")) {
            columbus();
        } else if (in.equals("Cluster")) {
            cluster();
        } else if (in.equals("Crystal")) {
            crystal();
        } else if (in.equals("Fuggle")) {
            fuggle();
        } else if (in.equals("Galena")) {
            galena();
        } else if (in.equals("Golding")) {
            golding();
        } else if (in.equals("Hallertau mf")) {
            hallertauMf();
        } else if (in.equals("Horizon")) {
            horizon();
        } else if (in.equals("Liberty")) {
            liberty();
        } else if (in.equals("Magnum")) {
            magnum();
        } else if (in.equals("Mount Hood")) {
            mountHood();
        } else if (in.equals("Northern Brewer")) {
            northernBrewer();
        } else if (in.equals("Nugget")) {
            nugget();
        } else if (in.equals("Perle")) {
            perle();
        } else if (in.equals("Saaz")) {
            saaz();
        } else if (in.equals("Satus")) {
            satus();
        } else if (in.equals("Simcoe")) {
            simcoe();
        } else if (in.equals("Spalt Select")) {
            spaltSelect();
        } else if (in.equals("Sterling")) {
            sterling();
        } else if (in.equals("Tettnang")) {
            tettnang();
        } else if (in.equals("Tomahawk")) {
            tomahawk();
        } else if (in.equals("Ultra")) {
            ultra();
        } else if (in.equals("US Fuggle")) {
            usFuggle();
        } else if (in.equals("Vanguard")) {
            vanguard();
        } else if (in.equals("Warrior")) {
            warrior();
        } else if (in.equals("Willamette")) {
            willamette();
        } 
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void ahtanum() {
        name = "ahtanum";
        displayName= "Ahtanum";
        alphaAcid = 6;
        betaAcid = "5-6.5";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void amarillo() {
        name = "amarillo";
        displayName= "Amarillo";
        alphaAcid = 9;
        betaAcid = "5-6.5";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void cascade() {
        name = "cascade";
        displayName= "Cascade";
        alphaAcid = 5.25;
        betaAcid = "5-7";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void centennial() {
        name = "centennial";
        displayName= "Centennial";
        alphaAcid = 10.5;
        betaAcid = "4-5";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void chinook() {
        name = "chinook";
        displayName= "Chinook";
        alphaAcid = 13;
        betaAcid = "3-4";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void columbus() {
        name = "columbus";
        displayName= "Columbus";
        alphaAcid = 12;
        betaAcid = "";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void cluster() {
        name = "cluster";
        displayName= "Cluster";
        alphaAcid = 7;
        betaAcid = "4.5-5.5";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void crystal() {
        name = "crystal";
        displayName= "Crystal";
        alphaAcid = 4.5;
        betaAcid = "5-6.7";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void fuggle() {
        name = "fuggle";
        displayName= "Fuggle";
        alphaAcid = 4.5;
        betaAcid = "1.5-2";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void galena() {
        name = "galena";
        displayName= "Galena";
        alphaAcid = 13.25;
        betaAcid = "7.5-9";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void golding() {
        name = "golding";
        displayName= "Golding";
        alphaAcid = 5;
        betaAcid = "2-3";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void hallertauMf() {
        name = "hallertauMf";
        displayName= "Hallertau Mf";
        alphaAcid = 4.5;
        betaAcid = "3.5-5.5";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void horizon() {
        name = "horizon";
        displayName= "Horizon";
        alphaAcid = 13.35;
        betaAcid = "6.5-8.5";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void liberty() {
        name = "liberty";
        displayName= "Liberty";
        alphaAcid = 4;
        betaAcid = "3-3.5";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void magnum() {
        name = "magnum";
        displayName= "Magnum";
        alphaAcid = 0;
        betaAcid = "";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void mountHood() {
        name = "mountHood";
        displayName= "Mount Hood";
        alphaAcid = 5;
        betaAcid = "5-7.5";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void northernBrewer() {
        name = "northernBrewer";
        displayName= "Northern Brewer";
        alphaAcid = 9;
        betaAcid = "3-5";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void nugget() {
        name = "nugget";
        displayName= "Nugget";
        alphaAcid = 13.5;
        betaAcid = "4-6";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void perle() {
        name = "perle";
        displayName= "Perle";
        alphaAcid = 8.25;
        betaAcid = "4-5";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void saaz() {
        name = "saaz";
        displayName= "Saaz";
        alphaAcid = 3;
        betaAcid = "";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void satus() {
        name = "satus";
        displayName= "Satus";
        alphaAcid = 13.25;
        betaAcid = "8.5-9";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void simcoe() {
        name = "simcoe";
        displayName= "Simcoe";
        alphaAcid = 13;
        betaAcid = "4-5";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void spaltSelect() {
        name = "spaltSelect";
        displayName= "Spalt Select";
        alphaAcid = 4.5;
        betaAcid = "3-4.5";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void sterling() {
        name = "sterling";
        displayName= "Sterling";
        alphaAcid = 4.75;
        betaAcid = "5-6";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void tettnang() {
        name = "tettnang";
        displayName= "Tettnang";
        alphaAcid = 4.5;
        betaAcid = "3.5-4.5";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void tomahawk() {
        name = "tomahawk";
        displayName= "Tomahawk";
        alphaAcid = 16;
        betaAcid = "4.5-5.8";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void ultra() {
        name = "ultra";
        displayName= "Ultra";
        alphaAcid = 4.75;
        betaAcid = "3.6-4.7";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void usFuggle() {
        name = "usFuggle";
        displayName= "US Fuggle";
        alphaAcid = 3.9;
        betaAcid = "";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void vanguard() {
        name = "vanguard";
        displayName= "Vanguard";
        alphaAcid = 5.5;
        betaAcid = "5-7";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void warrior() {
        name = "warrior";
        displayName= "Warrior";
        alphaAcid = 16;
        betaAcid = "4.5-5.5";
    }
    
  /**
    * Sets the global variables to the given style.
    *
    */
    private void willamette() {
        name = "willamette";
        displayName= "Willamette";
        alphaAcid = 5;
        betaAcid = "3.5-4.5";
    }
    
    /*  public static void main(String[] arguments) {
        Hops app = new Hops();
        boolean check;
        check = app.isIngredients("Chinook");
        if (check == true) {
            app.getIngredients("Chinook");
            System.out.println("Name: " + app.displayName);
            System.out.println("Alpha Acid: " + app.alphaAcid);
            System.out.println("Beta Acid: " + app.betaAcid);
        }
    }  */
}