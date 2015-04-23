package com.BrewAssist;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class BrewAssistUI extends JFrame implements ActionListener, ItemListener {
    
    
    //Global variables
    boolean savedWg = true;
    boolean savedEx = true;
    String currentPage = "Main";
    boolean bypass = false;
    
    JPanel newBrew_WholeGrain = new JPanel();
    JPanel newBrew_Extract = new JPanel();
    JLabel wgMessage = new JLabel("");
    
    
    public BrewAssistUI() {
     
        super("Brewing Assistant v1.0");
        JTabbedPane tabbedPane = new JTabbedPane();
        createNewBrew_WholeGrain();
        tabbedPane.addTab("Create New - Whole Grain", null, newBrew_WholeGrain, "Create new whole grain batch");
        
        createNewBrew_Extract();
        tabbedPane.addTab("Create New - Extract", null, newBrew_Extract, "Create new extract batch");
        
        add(tabbedPane);
        
       // JFrame frame = new JFrame("Brewing Assistant v1.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,900);
        add(tabbedPane);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    @Override
    public void itemStateChanged(ItemEvent item) {
        validate();
        repaint();
    }
    
    public Boolean isOptimizedDrawingEnabled() {
        return false;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        int answer = -1;
        if (command.equals("New Batch")) {
            if (savedWg == false) {
                answer = throwNewBatchWarning();
                if (answer == 0) {
                    savedWg = false;
                    wgMessage.setText("A new batch has been started!");
                    //Create a new batch here
                }
            } else if (savedWg == true) {
                savedWg = false;
                wgMessage.setText("A new batch has been started!");
                //Create a new batch here
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
        } else if (command.equals("Load Batch")) {
            if (savedWg == false) {
                answer = throwNewBatchWarning();
                if (answer == 0) {
                    savedWg = false;
                    wgMessage.setText("A new batch has been loaded!");
                    //Load batch here
                }
            } else if (savedWg == true) {
                savedWg = false;
                wgMessage.setText("A new batch has been loaded!");
                //Load batch here
            } else if (savedEx == false) {
                answer = throwNewBatchWarning();
                if (answer == 0) {
                    savedEx = false;
                    //Load batch here
                }
            } else if (savedEx == true) {
                savedEx = false;
                //Load batch here
            }
        } else if (command.equals("Save Batch")) {
            savedWg = true;
            wgMessage.setText("Your batch has been saved!");
            //Save the new batch here
        } else {
            //Do something
        }
        
        /*
        if (currentPage.equals("Main")) {
            bypass = true;
        }
        if ((saved == false) && (!currentPage.equals("Main"))) {
            Object selectedValue = JOptionPane.showOptionDialog(null, "You have not saved your work, do you want to continue?", "Warning",
            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
            null, options, options[0]);
            int newSelectedValue = (int)selectedValue;
            System.out.println(newSelectedValue);
            if (newSelectedValue == 0) {
           //     mid.setVisible(false);
          //      createNewBrew();
            }
        }
        if ((saved == true) || (bypass == true)) {
            if (command.equals("New Batch")) {
              //  mid.setVisible(false);
             //   createNewBrew();
            }
        } else {
            //Do nothing
        }  */
    }
    
    public int throwNewBatchWarning() {
        Object[] options = { "OK", "CANCEL" };
        Object selectedValue = JOptionPane.showOptionDialog(null, "You have not saved your work, do you want to continue?", "Warning",
            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
            null, options, options[0]);
        int newSelectedValue = (int)selectedValue;
        return newSelectedValue;    
    }
    /*
    public void createNewBrew() {
        Object[] possibleValues = { "Extract", "Whole Grain" };
            Object selectedValue = JOptionPane.showInputDialog(null,
            "Choose your batch style", "Input",
            JOptionPane.INFORMATION_MESSAGE, null,
            possibleValues, possibleValues[0]);

            if (selectedValue.equals("Extract")) {
                newBrew_WholeGrain.setVisible(false);
                newBrew_Extract.setVisible(true);
                createNewBrew_Extract();
            } else if (selectedValue.equals("Whole Grain")) {
                newBrew_Extract.setVisible(false);
                newBrew_WholeGrain.setVisible(true);
                createNewBrew_WholeGrain();
            }
    }*/
        
    
    private void createNewBrew_Extract() {
        currentPage = "Extract";
        bypass = false;
      //  JPanel newBrew = new JPanel();
        JLabel newBrewLabel = new JLabel("Extract Under Construction...", JLabel.CENTER);
        FlowLayout newBrewLayout = new FlowLayout();
        newBrew_Extract.setLayout(newBrewLayout);
        newBrew_Extract.add(newBrewLabel);
        add(newBrew_Extract, BorderLayout.CENTER);
     //   setVisible(true);
    }
    
    public void createNewBrew_WholeGrain() {
        currentPage = "Whole Grain";
        bypass = false;
        
        JPanel inner = new JPanel();
        BorderLayout newBoard = new BorderLayout();
        GridLayout newBrewLayout = new GridLayout(3,1,10,10);
        newBrew_WholeGrain.setLayout(newBoard);
        newBrew_WholeGrain.setBackground(Color.WHITE);
        inner.setLayout(newBrewLayout);
        inner.setBackground(Color.WHITE);
        
        //Top grid (1,1)
        JPanel selectStyle = new JPanel();
        GridLayout newLayout1 = new GridLayout(2,1,5,5); //Was 3,1,5,5
        selectStyle.setLayout(newLayout1);
        selectStyle.setBorder(BorderFactory.createTitledBorder("Select Style"));
        selectStyle.setBackground(Color.WHITE);
        //JLabel newBrewLabel = new JLabel("Drop down under construction", JLabel.CENTER);
        JPanel subPanel3 = new JPanel();
        FlowLayout subLayout3 = new FlowLayout(FlowLayout.CENTER);
        subPanel3.setLayout(subLayout3);
        subPanel3.setBackground(Color.WHITE);
        JComboBox beerStyles = new JComboBox();
        beerStyles.addItem("Amber");
        beerStyles.addItem("IPA");
        beerStyles.addItem("Stout");
        beerStyles.setBackground(Color.WHITE);
        subPanel3.setPreferredSize(new Dimension(50,50));
        subPanel3.add(beerStyles);
        selectStyle.add(subPanel3);
        
        JPanel SubPanel1 = new JPanel();
        SubPanel1.setBackground(Color.WHITE);
       // GridLayout SubLayout1 = new GridLayout(1,10,20,30);
        FlowLayout SubLayout1 = new FlowLayout(FlowLayout.CENTER);
        SubPanel1.setLayout(SubLayout1);
        SubPanel1.setPreferredSize(new Dimension(400,50));
        
        JLabel ibu = new JLabel("IBU's:", JLabel.RIGHT);
        JLabel srm = new JLabel("SRM:", JLabel.RIGHT);
        JLabel og = new JLabel("O.G.:", JLabel.RIGHT);
        JLabel fg = new JLabel("F.G.:", JLabel.RIGHT);
        JLabel abv = new JLabel("%ABV:", JLabel.RIGHT);
        JTextField ibuText = new JTextField(5);
        Font ibuFont = ibuText.getFont().deriveFont(Font.PLAIN, 12f);
        ibuText.setFont(ibuFont);
        ibuText.setEditable(false);
        ibuText.setText("0");
        JTextField srmText = new JTextField(5);
        srmText.setFont(ibuFont);
        srmText.setEditable(false);
        srmText.setText("0");
        JTextField ogText = new JTextField(5);
        ogText.setFont(ibuFont);
        ogText.setEditable(false);
        ogText.setText("0");
        JTextField fgText = new JTextField(5);
        fgText.setFont(ibuFont);
        fgText.setEditable(false);
        fgText.setText("0");
        JTextField abvText = new JTextField(5);
        abvText.setFont(ibuFont);
        abvText.setEditable(false);
        abvText.setText("0");
        JTextArea specialTextField = new JTextArea(2,50);
        specialTextField.setEditable(false);
        specialTextField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.DARK_GRAY), "Special Ingredients"));
        SubPanel1.add(ibu);
        SubPanel1.add(ibuText);
        SubPanel1.add(srm);
        SubPanel1.add(srmText);
        SubPanel1.add(og);
        SubPanel1.add(ogText);
        SubPanel1.add(fg);
        SubPanel1.add(fgText);
        SubPanel1.add(abv);
        SubPanel1.add(abvText);
        SubPanel1.add(specialTextField);
        selectStyle.add(SubPanel1);
        
        inner.add(selectStyle);
        
        
        //Mid grid (1,2)
        JPanel recipie = new JPanel();
        JLabel recipieText = new JLabel("Recipie section under construction");
        recipie.setBorder(BorderFactory.createTitledBorder("Grain Bill, Hops & Yeast"));
        recipie.add(recipieText);
        recipie.setBackground(Color.WHITE);
        inner.add(recipie);
        
        //Bottom grid (1,3)
        JPanel calcualted = new JPanel();
        JLabel calcText = new JLabel("Calculated section is under construction");
        calcualted.setBorder(BorderFactory.createTitledBorder("Calculated Characteristics"));
        calcualted.add(calcText);
        calcualted.setBackground(Color.WHITE);
        inner.add(calcualted);
        
        //Top bar
        JPanel topBar = new JPanel();
        topBar.setBackground(Color.WHITE);
        FlowLayout topLayout = new FlowLayout(FlowLayout.RIGHT);
        JButton newButton = new JButton("New Batch");
        JButton loadButton = new JButton("Load Batch");
        JButton saveButton = new JButton("Save Batch");
        newButton.addActionListener(this);
        loadButton.addActionListener(this);
        saveButton.addActionListener(this);
        topBar.setLayout(topLayout);
        topBar.add(wgMessage);
        topBar.add(newButton);
        topBar.add(loadButton);
        topBar.add(saveButton);
        newBrew_WholeGrain.add(topBar,BorderLayout.NORTH);
        newBrew_WholeGrain.add(inner,BorderLayout.CENTER);
        add(newBrew_WholeGrain,BorderLayout.CENTER);
    }
    
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.basic");  //com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel
        } catch (Exception exc) {
            //do nothing
        }
    }
    
    public static void main(String[] arguments) {
        BrewAssistUI app = new BrewAssistUI();
    }
}