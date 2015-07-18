package BrewAssist.RecipeTrack;

import BrewAssist.Ingredients.Hops;
import BrewAssist.Ingredients.WholeGrain;
import BrewAssist.Ingredients.yeast;
import BrewAssist.RecipeTrack.FileLoader.*;
import BrewAssist.RecipeTrack.SaveWholeGrain.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EtchedBorder;

public class RecipeTrackUI extends JFrame implements ActionListener {
    
    ///////////////////////////////
    //Configure global parameters//
    ///////////////////////////////
    
    WholeGrain grain = new WholeGrain();
    Hops hopApp = new Hops();
    yeast yeast1 = new yeast();
    FileLoader loadWgTracker = new FileLoader(this);
    SaveWholeGrain saveWgTracker = new SaveWholeGrain(this);
    
    JLabel wgMessage = new JLabel("");
    
    boolean savedWg = true;
    boolean savedEx = true;
    
    //Configure panel in tabs
    JPanel wgTrack = new JPanel();
    JPanel extTrack = new JPanel();
    
    //Configure whole grain tab variables
    
    //Overview parameters
    JTextField title_field = new JTextField(25);
    JTextField brewDate_field = new JTextField(15);
    JTextField startTime_field = new JTextField(15);
    JTextField endTime_field = new JTextField(15);
    JTextField endPrim_field = new JTextField(15);
    JTextField endSec_field = new JTextField(15);
    JTextField kegDate_field = new JTextField(15);
    JTextField botDate_field = new JTextField(15);
    JTextField batchSize_field = new JTextField(4);
    JTextField ibu_field = new JTextField(4);
    JTextField srm_field = new JTextField(4);
    JTextField og_field = new JTextField(4);
    JTextField fg_field = new JTextField(4);
    JTextField abv_field = new JTextField(4);
    
    //Recipe parameters
    JComboBox<String> grainCombo = new JComboBox<>();
    JComboBox<String> hopCombo = new JComboBox<>();
    JComboBox<String> yeastCombo = new JComboBox<>();
    JComboBox<String> starterCombo = new JComboBox<>();
    String[] grainColNames = {"Name", "Lbs"};
    Object[][] grainData = {
            {"", ""},
            {"", ""},
            {"", ""},
            {"", ""},
            {"", ""},
            {"", ""},
        };
    
    JTable grainTable = new JTable(grainData, grainColNames);
    
    String[] hopColNames = {"Name", "Amount", "Time"};
    Object[][] hopData = {
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
        };
    
    JTable hopTable = new JTable(hopData, hopColNames);
    
    JTextField tempPitch_field = new JTextField(4);
    
    //Mash parameters
    JTextField mashDuration_field = new JTextField(4);
    JTextField waterMashRatio_field = new JTextField(4);
    JTextField mashVolume_field = new JTextField(4);
    JTextField targetMashTemp_field = new JTextField(4);
    JTextField strikeWaterTemp_field = new JTextField(4);
    JTextField mashTempActual_field = new JTextField(4);
    JTextField finalMashTemp_field = new JTextField(4);
    JTextField preboilGrav_field = new JTextField(4);
    JTextField mashEff_field = new JTextField(4);
    
    String[] mashColNames = {"Sparge Step", "<html>Infusion<br>Volume</html>", "<html>Infusion<br>Temp</html>", "<html>Mash<br>Temp</html>", "<html>Volume of<br>Runnings</html>", "<html>Gravity of<br>Runnings</html>"};
    Object[][] mashData = {
        {"First", "", "", "", "", ""},
        {"Second", "", "", "", "", ""},
        {"Third", "", "", "", "", ""},
    };
    JTable mashTable = new JTable(mashData, mashColNames);
    
    //Ferm / boil parameters
    JTextField boilDuration_field = new JTextField(4);
    JTextField postBoilGravity_field = new JTextField(4);
    JTextField volumnPreBoil_field = new JTextField(4);
    JTextField volumnPostBoil_field = new JTextField(4);
    JTextField volumnInPrim_field = new JTextField(4);
    JTextField tempCheck1_field = new JTextField(4);
    JTextField tempCheck2_field = new JTextField(4);
    JTextField tempCheck3_field = new JTextField(4);
    JTextField tempCheck4_field = new JTextField(4);
    JTextField finalGrav_field = new JTextField(4);
    
    public RecipeTrackUI() {
        
        super("Brewing Assistant - Recipe Tracking");
        //JTabbedPane track = new JTabbedPane();
        
        createWgTrack();
        //track.addTab("Batch Tracking - Whole Grain", null, wgTrack, "Track a Whole Grain Batch");
        
        //Call exract method here
        //track.addTab("Batch Tracking - Extract", null, extTrack, "Track an Extract Batch");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,900);
        //add(track);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    private void createWgTrack() {
        JPanel overview = new JPanel();
        JPanel recipe = new JPanel();
        JPanel mash = new JPanel();
        JPanel fermentation = new JPanel();
        
        //wgTrack.setLayout(new BoxLayout(wgTrack, BoxLayout.Y_AXIS));
        wgTrack.setLayout(new GridLayout(4,1));
        wgTrack.setBackground(Color.WHITE);
        
        //Overview
        SpringLayout overviewLayout = new SpringLayout();
        overview.setLayout(overviewLayout);
        overview.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.DARK_GRAY), "Overview"));
        overview.setBackground(Color.WHITE);
        
        //  Local variables
        JLabel title = new JLabel("Batch Name:  ");
        JLabel brewDate = new JLabel("Brew Date: ");
        JLabel startTime = new JLabel("Start Time: ");
        JLabel endTime = new JLabel("End Time: ");
        JLabel endPrim = new JLabel("End of Primary: ");
        JLabel endSec = new JLabel("End of Secondary: ");
        JLabel kegDate = new JLabel("Kegging Date: ");
        JLabel botDate = new JLabel("Bottling Date: ");
        JLabel batchSize = new JLabel("Batch Size: ");
        JLabel ibu = new JLabel("IBU: ");
        JLabel srm = new JLabel("SRM: ");
        JLabel og = new JLabel("OG: ");
        JLabel fg = new JLabel("FG: ");
        JLabel abv = new JLabel("ABV: ");
        
        //  Setting contstraints
        overviewLayout.putConstraint(SpringLayout.WEST, title, 150, SpringLayout.WEST, overview);
        overviewLayout.putConstraint(SpringLayout.NORTH, title, 5, SpringLayout.NORTH, overview);
        overviewLayout.putConstraint(SpringLayout.WEST, title_field, 3, SpringLayout.EAST, title);
        overviewLayout.putConstraint(SpringLayout.NORTH, title_field, 5, SpringLayout.NORTH, overview);
        overviewLayout.putConstraint(SpringLayout.WEST, brewDate, 75, SpringLayout.WEST, overview);
        overviewLayout.putConstraint(SpringLayout.NORTH, brewDate, 35, SpringLayout.NORTH, overview);
        overviewLayout.putConstraint(SpringLayout.WEST, brewDate_field, 15, SpringLayout.EAST, brewDate);
        overviewLayout.putConstraint(SpringLayout.NORTH, brewDate_field, 35, SpringLayout.NORTH, overview);
        overviewLayout.putConstraint(SpringLayout.WEST, startTime, 75, SpringLayout.WEST, overview);
        overviewLayout.putConstraint(SpringLayout.NORTH, startTime, 10, SpringLayout.SOUTH, brewDate);
        overviewLayout.putConstraint(SpringLayout.WEST, startTime_field, 15, SpringLayout.EAST, startTime);
        overviewLayout.putConstraint(SpringLayout.NORTH, startTime_field, 5, SpringLayout.SOUTH, brewDate_field);
        overviewLayout.putConstraint(SpringLayout.WEST, endTime, 75, SpringLayout.WEST, overview);
        overviewLayout.putConstraint(SpringLayout.NORTH, endTime, 8, SpringLayout.SOUTH, startTime);
        overviewLayout.putConstraint(SpringLayout.WEST, endTime_field, 22, SpringLayout.EAST, endTime);
        overviewLayout.putConstraint(SpringLayout.NORTH, endTime_field, 5, SpringLayout.SOUTH, startTime_field);
        overviewLayout.putConstraint(SpringLayout.WEST, endPrim, 30, SpringLayout.EAST, brewDate_field);
        overviewLayout.putConstraint(SpringLayout.NORTH, endPrim, 35, SpringLayout.NORTH, overview);
        overviewLayout.putConstraint(SpringLayout.WEST, endPrim_field, 25, SpringLayout.EAST, endPrim);
        overviewLayout.putConstraint(SpringLayout.NORTH, endPrim_field, 35, SpringLayout.NORTH, overview);
        overviewLayout.putConstraint(SpringLayout.WEST, endSec, 30, SpringLayout.EAST, startTime_field);
        overviewLayout.putConstraint(SpringLayout.NORTH, endSec, 10, SpringLayout.SOUTH, endPrim);
        overviewLayout.putConstraint(SpringLayout.WEST, endSec_field, 9, SpringLayout.EAST, endSec);
        overviewLayout.putConstraint(SpringLayout.NORTH, endSec_field, 5, SpringLayout.SOUTH, endPrim_field);
        overviewLayout.putConstraint(SpringLayout.WEST, kegDate, 30, SpringLayout.EAST, endTime_field);
        overviewLayout.putConstraint(SpringLayout.NORTH, kegDate, 8, SpringLayout.SOUTH, endSec);
        overviewLayout.putConstraint(SpringLayout.WEST, kegDate_field, 33, SpringLayout.EAST, kegDate);  
        overviewLayout.putConstraint(SpringLayout.NORTH, kegDate_field, 5, SpringLayout.SOUTH, endSec_field);
        overviewLayout.putConstraint(SpringLayout.WEST, botDate, 355, SpringLayout.WEST, overview);
        overviewLayout.putConstraint(SpringLayout.NORTH, botDate, 8, SpringLayout.SOUTH, kegDate);
        overviewLayout.putConstraint(SpringLayout.WEST, botDate_field, 35, SpringLayout.EAST, botDate);
        overviewLayout.putConstraint(SpringLayout.NORTH, botDate_field, 5, SpringLayout.SOUTH, kegDate_field);
        overviewLayout.putConstraint(SpringLayout.WEST, batchSize, 40, SpringLayout.WEST, overview);
        overviewLayout.putConstraint(SpringLayout.SOUTH, batchSize, -8, SpringLayout.SOUTH, overview);
        overviewLayout.putConstraint(SpringLayout.WEST, batchSize_field, 5, SpringLayout.EAST, batchSize);
        overviewLayout.putConstraint(SpringLayout.SOUTH, batchSize_field, -5, SpringLayout.SOUTH, overview);
        overviewLayout.putConstraint(SpringLayout.WEST, ibu, 10, SpringLayout.EAST, batchSize_field);
        overviewLayout.putConstraint(SpringLayout.SOUTH, ibu, -8, SpringLayout.SOUTH, overview);
        overviewLayout.putConstraint(SpringLayout.WEST, ibu_field, 5, SpringLayout.EAST, ibu);
        overviewLayout.putConstraint(SpringLayout.SOUTH, ibu_field, -5, SpringLayout.SOUTH, overview);
        overviewLayout.putConstraint(SpringLayout.WEST, srm, 10, SpringLayout.EAST, ibu_field);
        overviewLayout.putConstraint(SpringLayout.SOUTH, srm, -8, SpringLayout.SOUTH, overview);
        overviewLayout.putConstraint(SpringLayout.WEST, srm_field, 5, SpringLayout.EAST, srm);
        overviewLayout.putConstraint(SpringLayout.SOUTH, srm_field, -5, SpringLayout.SOUTH, overview);
        overviewLayout.putConstraint(SpringLayout.WEST, og, 10, SpringLayout.EAST, srm_field);
        overviewLayout.putConstraint(SpringLayout.SOUTH, og, -8, SpringLayout.SOUTH, overview);
        overviewLayout.putConstraint(SpringLayout.WEST, og_field, 5, SpringLayout.EAST, og);
        overviewLayout.putConstraint(SpringLayout.SOUTH, og_field, -5, SpringLayout.SOUTH, overview);
        overviewLayout.putConstraint(SpringLayout.WEST, fg, 10, SpringLayout.EAST, og_field);
        overviewLayout.putConstraint(SpringLayout.SOUTH, fg, -8, SpringLayout.SOUTH, overview);
        overviewLayout.putConstraint(SpringLayout.WEST, fg_field, 5, SpringLayout.EAST, fg);
        overviewLayout.putConstraint(SpringLayout.SOUTH, fg_field, -5, SpringLayout.SOUTH, overview);
        overviewLayout.putConstraint(SpringLayout.WEST, abv, 10, SpringLayout.EAST, fg_field);
        overviewLayout.putConstraint(SpringLayout.SOUTH, abv, -8, SpringLayout.SOUTH, overview);
        overviewLayout.putConstraint(SpringLayout.WEST, abv_field, 5, SpringLayout.EAST, abv);
        overviewLayout.putConstraint(SpringLayout.SOUTH, abv_field, -5, SpringLayout.SOUTH, overview);
        
        //  Adding components
        overview.add(title);
        overview.add(title_field);
        overview.add(brewDate);
        overview.add(brewDate_field);
        overview.add(startTime);
        overview.add(startTime_field);
        overview.add(endTime);
        overview.add(endTime_field);
        overview.add(endPrim);
        overview.add(endPrim_field);
        overview.add(endSec);
        overview.add(endSec_field);
        overview.add(kegDate);
        overview.add(kegDate_field);
        overview.add(botDate);
        overview.add(botDate_field);
        overview.add(batchSize);
        overview.add(batchSize_field);
        overview.add(ibu);
        overview.add(ibu_field);
        overview.add(srm);
        overview.add(srm_field);
        overview.add(og);
        overview.add(og_field);
        overview.add(fg);
        overview.add(fg_field);
        overview.add(abv);
        overview.add(abv_field);
        
        wgTrack.add(overview);
        
        //////////////////
        //Recipe portion//
        //////////////////
        
        //SpringLayout recipeLayout = new SpringLayout();
        //recipe.setLayout(recipeLayout);
        recipe.setLayout(new BoxLayout(recipe, BoxLayout.Y_AXIS));
        recipe.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.DARK_GRAY), "Recipe"));
        recipe.setBackground(Color.WHITE);
        JPanel recipeNorth = new JPanel();
        JPanel recipeSouth = new JPanel();
        
        /////////////////////
        //recipeNorth panel//
        /////////////////////
        recipeNorth.setLayout(new GridLayout(1,2,5,5));
        recipeNorth.setBackground(Color.WHITE);
        
        //Setup grain and hop table
        String[] grainResponse = grain.grainList;
        for (int i = 0; i < 47; i++) {
            if (i != 0)
                grainCombo.addItem(grainResponse[i]);
        }
        grainCombo.addItem("");
        grainTable.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(grainCombo));
        grainTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        grainTable.setPreferredScrollableViewportSize(grainTable.getPreferredSize());
        grainTable.setFillsViewportHeight(true);
        
        String[] hopResponse = hopApp.hopList;
        for (int i = 0; i < 31; i++) {
            if (i != 0)
                hopCombo.addItem(hopResponse[i]);
        }
        hopCombo.addItem("");
        hopTable.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(hopCombo));
        hopTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        hopTable.setPreferredScrollableViewportSize(hopTable.getPreferredSize());
        hopTable.setFillsViewportHeight(true);
        
        //Adding components
        recipeNorth.add(new JScrollPane(grainTable));
        recipeNorth.add(new JScrollPane(hopTable));
        
        /////////////////////
        //recipeSouth panel//
        /////////////////////
        recipeSouth.setBackground(Color.WHITE);
        SpringLayout southLayout = new SpringLayout();
        recipeSouth.setLayout(southLayout);
        
        //Local variables
        JLabel yeast = new JLabel("Yeast: ");
        JLabel tempPitch = new JLabel("Temp @ Pitch: ");
        JLabel starter = new JLabel("Starter: ");
        JLabel grains = new JLabel("Grain Bill: ");
        JLabel hops = new JLabel("Hop Schedule: ");
        
        String[] yeastResponse = yeast1.yeastList;
        for (int i = 0; i < 28; i++) {
            if (i != 0 ) {
                yeastCombo.addItem(yeastResponse[i]);
            }
        }
        
        starterCombo.addItem("Yes");
        starterCombo.addItem("No");
        
        //Set constraints
        southLayout.putConstraint(SpringLayout.WEST, yeast, 5, SpringLayout.WEST, recipeSouth);
        southLayout.putConstraint(SpringLayout.NORTH, yeast, 8, SpringLayout.NORTH, recipeSouth);
        southLayout.putConstraint(SpringLayout.WEST, yeastCombo, 15, SpringLayout.EAST, yeast);
        southLayout.putConstraint(SpringLayout.NORTH, yeastCombo, 5, SpringLayout.NORTH, recipeSouth);
        southLayout.putConstraint(SpringLayout.WEST, starter, 20, SpringLayout.EAST, yeastCombo);
        southLayout.putConstraint(SpringLayout.NORTH, starter, 8, SpringLayout.NORTH, recipeSouth);
        southLayout.putConstraint(SpringLayout.WEST, starterCombo, 5, SpringLayout.EAST, starter);
        southLayout.putConstraint(SpringLayout.NORTH, starterCombo, 5, SpringLayout.NORTH, recipeSouth);
        southLayout.putConstraint(SpringLayout.WEST, tempPitch, 15, SpringLayout.EAST, starterCombo);
        southLayout.putConstraint(SpringLayout.NORTH, tempPitch, 7, SpringLayout.NORTH, recipeSouth);
        southLayout.putConstraint(SpringLayout.WEST, tempPitch_field, 5, SpringLayout.EAST, tempPitch);
        southLayout.putConstraint(SpringLayout.NORTH, tempPitch_field, 5, SpringLayout.NORTH, recipeSouth);
        southLayout.putConstraint(SpringLayout.WEST, grains, 5, SpringLayout.WEST, recipeSouth);
        southLayout.putConstraint(SpringLayout.SOUTH, grains, -5, SpringLayout.SOUTH, recipeSouth);
        southLayout.putConstraint(SpringLayout.WEST, hops, 350, SpringLayout.WEST, recipeSouth);
        southLayout.putConstraint(SpringLayout.SOUTH, hops, -5, SpringLayout.SOUTH, recipeSouth);

        
        recipeSouth.add(yeast);
        recipeSouth.add(yeastCombo);
        recipeSouth.add(starter);
        recipeSouth.add(starterCombo);
        recipeSouth.add(tempPitch);
        recipeSouth.add(tempPitch_field);
        recipeSouth.add(grains);
        recipeSouth.add(hops);
        
        recipe.add(recipeSouth);
        recipe.add(recipeNorth);
        
        wgTrack.add(recipe);
        
        ////////////////
        //Mash portion//
        ////////////////
        mash.setLayout(new BoxLayout(mash, BoxLayout.Y_AXIS));
        mash.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.DARK_GRAY), "Mash Procedure"));
        mash.setBackground(Color.WHITE);
        JPanel mashNorth = new JPanel();
        JPanel mashSouth = new JPanel();
        
        //////////////
        //Mash North//
        //////////////
        SpringLayout mashNorthLayout = new SpringLayout();
        mashNorth.setLayout(mashNorthLayout);
        mashNorth.setBackground(Color.WHITE);
        
        //Setting up components
        JLabel mashDuration = new JLabel("Mash Duration: ");
        JLabel waterMashRatio = new JLabel("Water-Mash Ratio: ");
        JLabel mashVolume = new JLabel("Mash Volume: ");
        JLabel targetMashTemp = new JLabel("Target Mash Temp: ");
        JLabel strikeWaterTemp = new JLabel("Strike Water Temp: ");
        JLabel mashTempActual = new JLabel("Mash Temp Actual: ");
        JLabel finalMashTemp = new JLabel("Final Mash Temp: ");
        JLabel preboilGrav = new JLabel("Preboil Gravity: ");
        JLabel mashEff = new JLabel("Mash Efficiency: ");
        
        //Set constraints
        mashNorthLayout.putConstraint(SpringLayout.WEST, mashDuration, 45, SpringLayout.WEST, recipeSouth);
        mashNorthLayout.putConstraint(SpringLayout.NORTH, mashDuration, 7, SpringLayout.NORTH, recipeSouth);
        mashNorthLayout.putConstraint(SpringLayout.WEST, mashDuration_field, 25, SpringLayout.EAST, mashDuration);
        mashNorthLayout.putConstraint(SpringLayout.NORTH, mashDuration_field, 5, SpringLayout.NORTH, recipeSouth);
        mashNorthLayout.putConstraint(SpringLayout.WEST, waterMashRatio, 45, SpringLayout.WEST, recipeSouth);
        mashNorthLayout.putConstraint(SpringLayout.NORTH, waterMashRatio, 7, SpringLayout.SOUTH, mashDuration);
        mashNorthLayout.putConstraint(SpringLayout.WEST, waterMashRatio_field, 5, SpringLayout.EAST, waterMashRatio);
        mashNorthLayout.putConstraint(SpringLayout.NORTH, waterMashRatio_field, 5, SpringLayout.SOUTH, mashDuration_field);
        mashNorthLayout.putConstraint(SpringLayout.WEST, mashVolume, 45, SpringLayout.WEST, recipeSouth);
        mashNorthLayout.putConstraint(SpringLayout.NORTH, mashVolume, 8, SpringLayout.SOUTH, waterMashRatio);
        mashNorthLayout.putConstraint(SpringLayout.WEST, mashVolume_field, 30, SpringLayout.EAST, mashVolume);
        mashNorthLayout.putConstraint(SpringLayout.NORTH, mashVolume_field, 5, SpringLayout.SOUTH, waterMashRatio_field);
        mashNorthLayout.putConstraint(SpringLayout.WEST, targetMashTemp, 35, SpringLayout.EAST, mashDuration_field);
        mashNorthLayout.putConstraint(SpringLayout.NORTH, targetMashTemp, 6, SpringLayout.NORTH, recipeSouth);
        mashNorthLayout.putConstraint(SpringLayout.WEST, targetMashTemp_field, 5, SpringLayout.EAST, targetMashTemp);
        mashNorthLayout.putConstraint(SpringLayout.NORTH, targetMashTemp_field, 5, SpringLayout.NORTH, recipeSouth);
        mashNorthLayout.putConstraint(SpringLayout.WEST, strikeWaterTemp, 35, SpringLayout.EAST, waterMashRatio_field);
        mashNorthLayout.putConstraint(SpringLayout.NORTH, strikeWaterTemp, 7, SpringLayout.SOUTH, targetMashTemp);
        mashNorthLayout.putConstraint(SpringLayout.WEST, strikeWaterTemp_field, 5, SpringLayout.EAST, strikeWaterTemp);
        mashNorthLayout.putConstraint(SpringLayout.NORTH, strikeWaterTemp_field, 5, SpringLayout.SOUTH, targetMashTemp_field);
        mashNorthLayout.putConstraint(SpringLayout.WEST, mashTempActual, 35, SpringLayout.EAST, mashVolume_field);
        mashNorthLayout.putConstraint(SpringLayout.NORTH, mashTempActual, 7, SpringLayout.SOUTH, strikeWaterTemp);
        mashNorthLayout.putConstraint(SpringLayout.WEST, mashTempActual_field, 6, SpringLayout.EAST, mashTempActual);
        mashNorthLayout.putConstraint(SpringLayout.NORTH, mashTempActual_field, 5, SpringLayout.SOUTH, strikeWaterTemp_field);
        mashNorthLayout.putConstraint(SpringLayout.WEST, finalMashTemp, 35, SpringLayout.EAST, targetMashTemp_field);
        mashNorthLayout.putConstraint(SpringLayout.NORTH, finalMashTemp, 6, SpringLayout.NORTH, recipeSouth);
        mashNorthLayout.putConstraint(SpringLayout.WEST, finalMashTemp_field, 5, SpringLayout.EAST, finalMashTemp);
        mashNorthLayout.putConstraint(SpringLayout.NORTH, finalMashTemp_field, 5, SpringLayout.NORTH, recipeSouth);
        mashNorthLayout.putConstraint(SpringLayout.WEST, preboilGrav, 35, SpringLayout.EAST, strikeWaterTemp_field);
        mashNorthLayout.putConstraint(SpringLayout.NORTH, preboilGrav, 7, SpringLayout.SOUTH, finalMashTemp);
        mashNorthLayout.putConstraint(SpringLayout.WEST, preboilGrav_field, 18, SpringLayout.EAST, preboilGrav);
        mashNorthLayout.putConstraint(SpringLayout.NORTH, preboilGrav_field, 5, SpringLayout.SOUTH, finalMashTemp_field);
        mashNorthLayout.putConstraint(SpringLayout.WEST, mashEff, 35, SpringLayout.EAST, mashTempActual_field);
        mashNorthLayout.putConstraint(SpringLayout.NORTH, mashEff, 7, SpringLayout.SOUTH, preboilGrav);
        mashNorthLayout.putConstraint(SpringLayout.WEST, mashEff_field, 12, SpringLayout.EAST, mashEff);
        mashNorthLayout.putConstraint(SpringLayout.NORTH, mashEff_field, 5, SpringLayout.SOUTH, preboilGrav_field);
        
        //Adding components
        mashNorth.add(mashDuration);
        mashNorth.add(mashDuration_field);
        mashNorth.add(waterMashRatio);
        mashNorth.add(waterMashRatio_field);
        mashNorth.add(mashVolume);
        mashNorth.add(mashVolume_field);
        mashNorth.add(targetMashTemp);
        mashNorth.add(targetMashTemp_field);
        mashNorth.add(strikeWaterTemp);
        mashNorth.add(strikeWaterTemp_field);
        mashNorth.add(mashTempActual);
        mashNorth.add(mashTempActual_field);
        mashNorth.add(finalMashTemp);
        mashNorth.add(finalMashTemp_field);
        mashNorth.add(preboilGrav);
        mashNorth.add(preboilGrav_field);
        mashNorth.add(mashEff);
        mashNorth.add(mashEff_field);
        
        mash.add(mashNorth);
        
        //////////////
        //Mash South//
        //////////////
        mashSouth.setBackground(Color.WHITE);
        mash.add(mashSouth);
        
        //Setting up components
        mashTable.getTableHeader().setPreferredSize(new Dimension(100,35));
        mashTable.setPreferredScrollableViewportSize(mashTable.getPreferredSize());
        mashTable.setFillsViewportHeight(true);
        
        //Adding components
        mashSouth.add(new JScrollPane(mashTable));
        
        wgTrack.add(mash);
        
        ///////////////////////
        //Boil & Fermentation//
        ///////////////////////
        SpringLayout fermentationLayout = new SpringLayout();
        fermentation.setLayout(fermentationLayout);
        fermentation.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.DARK_GRAY), "Boil & Fermentation"));
        fermentation.setBackground(Color.WHITE);
        
        //Setup local components
        JLabel boilDuration = new JLabel("Boil Duration: ");
        JLabel postBoilGravity = new JLabel("Post Boil Gravity: ");
        JLabel volumnPreBoil = new JLabel("Volumn Pre-Boil: ");
        JLabel volumnPostBoil = new JLabel("Volumn Post-Boil: ");
        JLabel volumnInPrim = new JLabel("Volumn In Primary: ");
        JLabel tempCheck1 = new JLabel("Ferm. Temp. Check 1: ");
        JLabel tempCheck2 = new JLabel("Ferm. Temp. Check 2: ");
        JLabel tempCheck3 = new JLabel("Ferm. Temp. Check 3: ");    
        JLabel tempCheck4 = new JLabel("Ferm. Temp. Check 4: ");
        JLabel finalGrav = new JLabel("Final Gravity: ");
        JLabel fermentationL = new JLabel("Fermentation");
        JLabel boil = new JLabel("Boil");
        JButton wgNew = new JButton("New Tracking");
        JButton wgLoad = new JButton("Load Tracking");
        JButton wgSave = new JButton("Save Tracking");
        wgNew.addActionListener(this);
        wgLoad.addActionListener(this);
        wgSave.addActionListener(this);
        
        //Set constraints
        fermentationLayout.putConstraint(SpringLayout.WEST, boil, 150, SpringLayout.WEST, fermentation);
        fermentationLayout.putConstraint(SpringLayout.NORTH, boil, 2, SpringLayout.NORTH, fermentation);
        fermentationLayout.putConstraint(SpringLayout.WEST, boilDuration, 5, SpringLayout.WEST, fermentation);
        fermentationLayout.putConstraint(SpringLayout.NORTH, boilDuration, 6, SpringLayout.SOUTH, boil);
        fermentationLayout.putConstraint(SpringLayout.WEST, boilDuration_field, 34, SpringLayout.EAST, boilDuration);
        fermentationLayout.putConstraint(SpringLayout.NORTH, boilDuration_field, 25, SpringLayout.NORTH, fermentation);  //Edit this field
        fermentationLayout.putConstraint(SpringLayout.WEST, postBoilGravity, 5, SpringLayout.WEST, fermentation);
        fermentationLayout.putConstraint(SpringLayout.NORTH, postBoilGravity, 7, SpringLayout.SOUTH, boilDuration);
        fermentationLayout.putConstraint(SpringLayout.WEST, postBoilGravity_field, 15, SpringLayout.EAST, postBoilGravity);
        fermentationLayout.putConstraint(SpringLayout.NORTH, postBoilGravity_field, 5, SpringLayout.SOUTH, boilDuration_field);
        fermentationLayout.putConstraint(SpringLayout.WEST, volumnPreBoil, 15, SpringLayout.EAST, boilDuration_field);
        fermentationLayout.putConstraint(SpringLayout.NORTH, volumnPreBoil, 25, SpringLayout.NORTH, fermentation);
        fermentationLayout.putConstraint(SpringLayout.WEST, volumnPreBoil_field, 15, SpringLayout.EAST, volumnPreBoil);
        fermentationLayout.putConstraint(SpringLayout.NORTH, volumnPreBoil_field, 25, SpringLayout.NORTH, fermentation);
        fermentationLayout.putConstraint(SpringLayout.WEST, volumnPostBoil, 15, SpringLayout.EAST, postBoilGravity_field);
        fermentationLayout.putConstraint(SpringLayout.NORTH, volumnPostBoil, 8, SpringLayout.SOUTH, volumnPreBoil);
        fermentationLayout.putConstraint(SpringLayout.WEST, volumnPostBoil_field, 10, SpringLayout.EAST, volumnPostBoil);
        fermentationLayout.putConstraint(SpringLayout.NORTH, volumnPostBoil_field, 5, SpringLayout.SOUTH, volumnPreBoil_field);
        fermentationLayout.putConstraint(SpringLayout.WEST, volumnInPrim, 179, SpringLayout.WEST, fermentation);
        fermentationLayout.putConstraint(SpringLayout.NORTH, volumnInPrim, 7, SpringLayout.SOUTH, volumnPostBoil);
        fermentationLayout.putConstraint(SpringLayout.WEST, volumnInPrim_field, 5, SpringLayout.EAST, volumnInPrim);
        fermentationLayout.putConstraint(SpringLayout.NORTH, volumnInPrim_field, 5, SpringLayout.SOUTH, volumnPostBoil_field);
        fermentationLayout.putConstraint(SpringLayout.WEST, fermentationL, 285, SpringLayout.EAST, boil);
        fermentationLayout.putConstraint(SpringLayout.NORTH, fermentationL, 2, SpringLayout.NORTH, fermentation);
        fermentationLayout.putConstraint(SpringLayout.WEST, tempCheck1, 66, SpringLayout.EAST, volumnPreBoil_field);
        fermentationLayout.putConstraint(SpringLayout.NORTH, tempCheck1, 6, SpringLayout.SOUTH, fermentationL);
        fermentationLayout.putConstraint(SpringLayout.WEST, tempCheck1_field, 15, SpringLayout.EAST, tempCheck1);
        fermentationLayout.putConstraint(SpringLayout.NORTH, tempCheck1_field, 5, SpringLayout.SOUTH, fermentationL);
        fermentationLayout.putConstraint(SpringLayout.WEST, tempCheck2, 65, SpringLayout.EAST, volumnPostBoil_field);
        fermentationLayout.putConstraint(SpringLayout.NORTH, tempCheck2, 9, SpringLayout.SOUTH, tempCheck1);
        fermentationLayout.putConstraint(SpringLayout.WEST, tempCheck2_field, 15, SpringLayout.EAST, tempCheck2);
        fermentationLayout.putConstraint(SpringLayout.NORTH, tempCheck2_field, 5, SpringLayout.SOUTH, tempCheck1_field);
        fermentationLayout.putConstraint(SpringLayout.WEST, tempCheck3, 65, SpringLayout.EAST, volumnInPrim_field);
        fermentationLayout.putConstraint(SpringLayout.NORTH, tempCheck3, 9, SpringLayout.SOUTH, tempCheck2);
        fermentationLayout.putConstraint(SpringLayout.WEST, tempCheck3_field, 15, SpringLayout.EAST, tempCheck2);
        fermentationLayout.putConstraint(SpringLayout.NORTH, tempCheck3_field, 5, SpringLayout.SOUTH, tempCheck2_field);
        fermentationLayout.putConstraint(SpringLayout.WEST, tempCheck4, 407, SpringLayout.WEST, fermentation);
        fermentationLayout.putConstraint(SpringLayout.NORTH, tempCheck4, 9, SpringLayout.SOUTH, tempCheck3);
        fermentationLayout.putConstraint(SpringLayout.WEST, tempCheck4_field, 15, SpringLayout.EAST, tempCheck4);
        fermentationLayout.putConstraint(SpringLayout.NORTH, tempCheck4_field, 5, SpringLayout.SOUTH, tempCheck3_field);
        fermentationLayout.putConstraint(SpringLayout.WEST, finalGrav, 407, SpringLayout.WEST, fermentation);
        fermentationLayout.putConstraint(SpringLayout.NORTH, finalGrav, 8, SpringLayout.SOUTH, tempCheck4);
        fermentationLayout.putConstraint(SpringLayout.WEST, finalGrav_field, 66, SpringLayout.EAST, finalGrav);
        fermentationLayout.putConstraint(SpringLayout.NORTH, finalGrav_field, 5, SpringLayout.SOUTH, tempCheck4_field);
        fermentationLayout.putConstraint(SpringLayout.WEST, wgNew, 5, SpringLayout.WEST, fermentation);
        fermentationLayout.putConstraint(SpringLayout.SOUTH, wgNew, -5, SpringLayout.SOUTH, fermentation);
        fermentationLayout.putConstraint(SpringLayout.WEST, wgLoad, 5, SpringLayout.EAST, wgNew);
        fermentationLayout.putConstraint(SpringLayout.SOUTH, wgLoad, -5, SpringLayout.SOUTH, fermentation);
        fermentationLayout.putConstraint(SpringLayout.WEST, wgSave, 5, SpringLayout.EAST, wgLoad);
        fermentationLayout.putConstraint(SpringLayout.SOUTH, wgSave, -5, SpringLayout.SOUTH, fermentation);
        fermentationLayout.putConstraint(SpringLayout.WEST, wgMessage, 5, SpringLayout.WEST, fermentation);
        fermentationLayout.putConstraint(SpringLayout.SOUTH, wgMessage, -5, SpringLayout.NORTH, wgNew);
        
        //Adding components
        fermentation.add(fermentationL);
        fermentation.add(boilDuration);
        fermentation.add(boilDuration_field);
        fermentation.add(postBoilGravity);
        fermentation.add(postBoilGravity_field);
        fermentation.add(volumnPreBoil);
        fermentation.add(volumnPreBoil_field);
        fermentation.add(volumnPostBoil);
        fermentation.add(volumnPostBoil_field);
        fermentation.add(volumnInPrim);
        fermentation.add(volumnInPrim_field);
        fermentation.add(boil);
        fermentation.add(tempCheck1);
        fermentation.add(tempCheck1_field);
        fermentation.add(tempCheck2);
        fermentation.add(tempCheck2_field);
        fermentation.add(tempCheck3);
        fermentation.add(tempCheck3_field);
        fermentation.add(tempCheck4);
        fermentation.add(tempCheck4_field);
        fermentation.add(finalGrav);
        fermentation.add(finalGrav_field);
        fermentation.add(wgNew);
        fermentation.add(wgLoad);
        fermentation.add(wgSave);
        fermentation.add(wgMessage);
        
        wgTrack.add(fermentation);
        wgTrack.setVisible(true);
        add(wgTrack);
        
    } 
    
    public Boolean isOptimizedDrawingEnabled() {
        return false;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        String fileName;
        int answer = -1;
        if (command.equals("New Tracking")) {
            if (savedWg == false) {
                answer = throwNewBatchWarning();
                if (answer == 0) {
                    savedWg = false;
                    fileName = loadWgTracker.wgRecipeLoad();
                    if (!fileName.equals("Empty")) {
                        loadWgTracker.wgRecipeLoad_PostProcess(fileName);
                        tableRefresh();
                    }
                }
            } else if (savedWg == true) {
                savedWg = false;
                fileName = loadWgTracker.wgRecipeLoad();
                    if (!fileName.equals("Empty")) {
                        loadWgTracker.wgRecipeLoad_PostProcess(fileName);
                        tableRefresh();
                    }
            } else if (savedEx == false) {
                answer = throwNewBatchWarning();
                if (answer == 0) {
                    savedEx = false;
                    //Create a new batch here
                }
            } else if (savedEx == true) {
                savedEx = false;
                //Create a new batch here
            }
        } else if (command.equals("Load Tracking")) {
            if (savedWg == false) {
                answer = throwNewBatchWarning();
                if (answer == 0) {
                    savedWg = false;
                    fileName = loadWgTracker.wgTrackLoad();
                    System.out.println("UI Result: " + fileName);
                    if (!fileName.equals("Empty")) {
                        loadWgTracker.wgTrackLoad_PostProcess(fileName);
                        tableRefresh();
                        wgMessage.setText("Your tracking has been loaded!");
                    }
                }
            } else if (savedWg == true) {
                savedWg = false;
                fileName = loadWgTracker.wgTrackLoad();
                    System.out.println("UI Result: " + fileName);
                    if (!fileName.equals("Empty")) {
                        loadWgTracker.wgTrackLoad_PostProcess(fileName);
                        tableRefresh();
                        wgMessage.setText("Your tracking has been loaded!");
                    }
            } else if (savedEx == false) {
                answer = throwNewBatchWarning();
                if (answer == 0) {
                    savedEx = false;
                    //Load tracking here
                }
            } else if (savedEx == true) {
                savedEx = false;
                //Load tracking here
                
            }
        } else if (command.equals("Save Tracking")) {
            savedWg = true;
            File f = new File("C:\\BrewAssist\\Saves\\Tracking\\wg\\" + title_field.getText() + ".properties");
            if (!f.exists()) {
                saveWgTracker.saveGrainTracking(title_field.getText());
                wgMessage.setText("Your tracking has been saved!");
            } else {
                answer = throwSaveOverrideWarning();
                if (answer == 0) {
                    saveWgTracker.saveGrainTracking(title_field.getText());
                    wgMessage.setText("Your tracking has been saved!");
                }
            }
        }
    }
    
    public int throwNewBatchWarning() {
        Object[] options = { "OK", "CANCEL" };
        Object selectedValue = JOptionPane.showOptionDialog(null, "You have not saved your work, do you want to continue?", "Warning",
            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
            null, options, options[0]);
        int newSelectedValue = (int)selectedValue;
        return newSelectedValue;    
    }
    
  /**
    * Pop up box that asks the user if they want to override a previously saved file 
    * when "Save Batch" is pressed and the batch name matches.
    * <p>
    * This method is called from the actionPerformed method above.
    *
    * @return   Integer response (0 is OK, 1 is cancel)
    */
    public int throwSaveOverrideWarning() {
        Object[] options = { "OK", "CANCEL" };
        Object selectedValue = JOptionPane.showOptionDialog(null, "This file already exists, do you want to overwrite it?", "Warning",
            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
            null, options, options[0]);
        int newSelectedValue = (int)selectedValue;
        return newSelectedValue;    
    }
    
    private void tableRefresh() {
       grainTable.revalidate();
       grainTable.repaint();
       hopTable.revalidate();
       hopTable.repaint();
       mashTable.revalidate();
       mashTable.repaint();
    }
}