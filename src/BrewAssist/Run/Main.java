package BrewAssist.Run;

import BrewAssist.RecipeBuilder.BrewAssistUI;
import BrewAssist.Core.*;
import BrewAssist.RecipeTrack.RecipeTrackUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

public class Main extends JFrame implements ActionListener {
    public Main () {
        
        //Configure JFrame, all Panels and associated layouts.
        JFrame startup = new JFrame("Brewing Assistant");
        JPanel batchPan = new JPanel();
        JPanel personalPan = new JPanel();
        JPanel settingsPan = new JPanel();
        SpringLayout batchLayout = new SpringLayout();
        SpringLayout personalLayout = new SpringLayout();
        SpringLayout settingLayout = new SpringLayout();
        GridLayout startupLayout = new GridLayout(3,1,5,5);
        
        //Setting default properties for JFrame
        startup.setLayout(startupLayout);
        startup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startup.setSize(275,425);
        startup.setLocationRelativeTo(null);
        startup.getContentPane().setBackground(Color.WHITE);
        
        //Batch layout section
        batchPan.setLayout(batchLayout);
        batchPan.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.DARK_GRAY), "Batch Creation & Tracking"));
        batchPan.setBackground(Color.WHITE);
        JButton recipeBuild = new JButton("Recipe Builder!");
        recipeBuild.addActionListener(this);
        recipeBuild.setPreferredSize(new Dimension(150, 20));
        recipeBuild.setToolTipText("Batch creating tool!");
        JButton recipeTrack = new JButton("Recipe Tracker");
        recipeTrack.addActionListener(this);
        recipeTrack.setPreferredSize(new Dimension(150, 20));
        recipeTrack.setToolTipText("Brew day notes and batch tracking!");
        JButton ingredientPick = new JButton("Ingredient Picker");
        ingredientPick.setEnabled(false);
        ingredientPick.setPreferredSize(new Dimension(150, 20));
        ingredientPick.setToolTipText("Ingredient lookup tool!");
        
        batchLayout.putConstraint(SpringLayout.WEST, recipeBuild, 52, SpringLayout.WEST, batchPan);
        batchLayout.putConstraint(SpringLayout.NORTH, recipeBuild, 10, SpringLayout.NORTH, batchPan);
        batchLayout.putConstraint(SpringLayout.WEST, recipeTrack, 52, SpringLayout.WEST, batchPan);
        batchLayout.putConstraint(SpringLayout.NORTH, recipeTrack, 10, SpringLayout.SOUTH, recipeBuild);
        batchLayout.putConstraint(SpringLayout.WEST, ingredientPick, 52, SpringLayout.WEST, batchPan);
        batchLayout.putConstraint(SpringLayout.NORTH, ingredientPick, 10, SpringLayout.SOUTH, recipeTrack);
        
        batchPan.add(recipeBuild);
        batchPan.add(recipeTrack);
        batchPan.add(ingredientPick);
        
        startup.add(batchPan);
        
        //Personalization Section
        personalPan.setLayout(personalLayout);
        personalPan.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.DARK_GRAY), "Batch Personalization"));
        personalPan.setBackground(Color.WHITE);
        
        JButton ingredientEdit = new JButton("Ingredient Editor");
        ingredientEdit.setEnabled(false);
        ingredientEdit.setPreferredSize(new Dimension(150, 20));
        ingredientEdit.setToolTipText("Add / edit main ingredients and beer styles!");
        
        JButton styleEdit = new JButton("Beer Style Editor");
        styleEdit.setEnabled(false);
        styleEdit.setPreferredSize(new Dimension(150, 20));
        
        personalLayout.putConstraint(SpringLayout.WEST, ingredientEdit, 52, SpringLayout.WEST, personalPan);
        personalLayout.putConstraint(SpringLayout.NORTH, ingredientEdit, 10, SpringLayout.NORTH, personalPan);
        personalLayout.putConstraint(SpringLayout.WEST, styleEdit, 52, SpringLayout.WEST, personalPan);
        personalLayout.putConstraint(SpringLayout.NORTH, styleEdit, 10, SpringLayout.SOUTH, ingredientEdit);
        
        personalPan.add(ingredientEdit);
        personalPan.add(styleEdit);
        
        startup.add(personalPan);
        
        //Settings Section
        settingsPan.setLayout(settingLayout);
        settingsPan.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.DARK_GRAY), "Settings"));
        settingsPan.setBackground(Color.WHITE);
        
        JButton settingB = new JButton("Settings");
        settingB.setEnabled(false);
        settingB.setPreferredSize(new Dimension(150, 20));
        JButton helpB = new JButton("Help");
        helpB.setEnabled(false);
        helpB.setPreferredSize(new Dimension(150, 20));
        
        settingLayout.putConstraint(SpringLayout.WEST, settingB, 52, SpringLayout.WEST, settingsPan);
        settingLayout.putConstraint(SpringLayout.NORTH, settingB, 10, SpringLayout.NORTH, settingsPan);
        settingLayout.putConstraint(SpringLayout.WEST, helpB, 52, SpringLayout.WEST, settingsPan);
        settingLayout.putConstraint(SpringLayout.NORTH, helpB, 10, SpringLayout.SOUTH, settingB);
        
        settingsPan.add(settingB);
        settingsPan.add(helpB);
        
        startup.add(settingsPan);
        
        //startup.pack();
        startup.setVisible(true);
    }
    
  /**
    * Action (button) action method.  Performs button action based on button pressed.
    * Save batch, load batch, new batch, calculate.
    *
    * @param  event   An action event
    */
    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        
        if (command.equals("Recipe Builder!")) {
            BrewAssistUI app = new BrewAssistUI();
        } else if (command.equals("Recipe Tracker")) {
            RecipeTrackUI app1 = new RecipeTrackUI();
        }
    }
    
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.basic");  //com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel
        } catch (Exception exc) {
            //do nothing
        }
    }
    
    public static void main(String[] arguments) {
        Core file = new Core();
        file.createDirectory();
        Main app = new Main();
    }
    
}