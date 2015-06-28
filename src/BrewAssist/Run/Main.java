package BrewAssist.Run;

import BrewAssist.RecipeBuilder.BrewAssistUI;
import BrewAssist.Core.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

public class Main extends JFrame implements ActionListener {
    public Main () {
        JFrame startup = new JFrame("Brewing Assistant");
        SpringLayout layout = new SpringLayout();
        startup.setLayout(layout);
        startup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startup.setSize(400,500);
        
        startup.setLocationRelativeTo(null);
        JButton recipeBuild = new JButton("Recipe Builder");
        recipeBuild.addActionListener(this);
        JButton recipeTrack = new JButton("Recipe Tracker");
        recipeTrack.setEnabled(false);
        JButton ingredientPick = new JButton("Ingredient Picker");
        ingredientPick.setEnabled(false);
        
        layout.putConstraint(SpringLayout.WEST, recipeBuild, 10, SpringLayout.WEST, startup);
        layout.putConstraint(SpringLayout.NORTH, recipeBuild, 10, SpringLayout.NORTH, startup);
        layout.putConstraint(SpringLayout.WEST, recipeTrack, 10, SpringLayout.WEST, startup);
        layout.putConstraint(SpringLayout.NORTH, recipeTrack, 10, SpringLayout.SOUTH, recipeBuild);
        layout.putConstraint(SpringLayout.WEST, ingredientPick, 10, SpringLayout.WEST, startup);
        layout.putConstraint(SpringLayout.NORTH, ingredientPick, 10, SpringLayout.SOUTH, recipeTrack);
        startup.getContentPane().setBackground(Color.WHITE);
        startup.add(recipeBuild);
        startup.add(recipeTrack);
        startup.add(ingredientPick);
        
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
        
        if (command.equals("Recipe Builder")) {
            BrewAssistUI app = new BrewAssistUI();
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