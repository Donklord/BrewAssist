package BrewAssist.RecipeTrack;

import BrewAssist.Ingredients.Hops;
import BrewAssist.Ingredients.WholeGrain;
import BrewAssist.Ingredients.yeast;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EtchedBorder;

public class RecipeTrackUI extends JFrame {
    
    ///////////////////////////////
    //Configure global parameters//
    ///////////////////////////////
    
    WholeGrain grain = new WholeGrain();
    Hops hopApp = new Hops();
    yeast yeast1 = new yeast();
    
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
    
    
    public RecipeTrackUI() {
        
        super("Brewing Assistant - Recipe Tracking");
        JTabbedPane track = new JTabbedPane();
        
        createWgTrack();
        track.addTab("Batch Tracking - Whole Grain", null, wgTrack, "Track a Whole Grain Batch");
        
        //Call exract method here
        track.addTab("Batch Tracking - Extract", null, extTrack, "Track an Extract Batch");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,900);
        add(track);
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
        
        
        recipeSouth.add(yeast);
        recipeSouth.add(yeastCombo);
        recipeSouth.add(starter);
        recipeSouth.add(starterCombo);
        
        recipe.add(recipeSouth);
        recipe.add(recipeNorth);
        
        wgTrack.add(recipe);
        
        //Mash portion
        JLabel temp2 = new JLabel("Mash under construction");
        mash.add(temp2);
        wgTrack.add(mash);
        
        //Fermentation portion
        JLabel temp3 = new JLabel("Ferm under construction");
        fermentation.add(temp3);
        wgTrack.add(fermentation);
        wgTrack.setVisible(true);
        
    } 
    
    public Boolean isOptimizedDrawingEnabled() {
        return false;
    }
}