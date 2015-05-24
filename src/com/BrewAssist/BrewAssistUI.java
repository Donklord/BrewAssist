package com.BrewAssist;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import com.Ingredients.*;

public class BrewAssistUI extends JFrame implements ActionListener, ItemListener {
    NewWholeGrainEvent wholeGrainEvent = new NewWholeGrainEvent(this);
   // CsvLoader file = new CsvLoader();
    WholeGrain grain = new WholeGrain();
    Hops hopApp = new Hops();
    yeast yeast1 = new yeast();
    Styles styleApp = new Styles();
    
    //Global variables
    boolean savedWg = true;
    boolean savedEx = true;
    String currentPage = "Main";
    boolean bypass = false;
    
    JPanel newBrew_WholeGrain = new JPanel();
    JPanel newBrew_Extract = new JPanel();
    JLabel wgMessage = new JLabel("");
    
    JTextField ibuText = new JTextField(5);
    JTextField srmText = new JTextField(5);
    JTextField ogText = new JTextField(6);
    JTextField fgText = new JTextField(6);
    JTextField abvText = new JTextField(5);
    JTextArea specialTextField = new JTextArea(2,50);
    JComboBox<String> grainCombo = new JComboBox<>();
    Object[][] grainData = {
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
        };
    String[] grainColNames = {"Grain", "Lbs", "% Yield", "Lovibond", "SRM", "% Max"};
    JTable grainTable = new JTable(grainData, grainColNames);
    
    String[] hopColNames = {"Hop", "Amount", "Time", "Alpha Acid", "Beta Acid"};
        Object[][] hopData = {
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
        };
        JTable hopTable = new JTable(hopData, hopColNames);
    
    JTextField test = new JTextField();
    
   // String[] styleNames = file.getBeerNames();
    
    
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
        setSize(1080,700);
        add(tabbedPane);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    @Override
    public void itemStateChanged(ItemEvent item) {
        validate();
        repaint();
        Object which = item.getItem();
        String answer = which.toString();
        int state = item.getStateChange();
        if (state == item.SELECTED) {
            wholeGrainEvent.itemChanged(answer);
        }
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
        
    }
    
    public int throwNewBatchWarning() {
        Object[] options = { "OK", "CANCEL" };
        Object selectedValue = JOptionPane.showOptionDialog(null, "You have not saved your work, do you want to continue?", "Warning",
            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
            null, options, options[0]);
        int newSelectedValue = (int)selectedValue;
        return newSelectedValue;    
    }
        
    
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
        JComboBox<String> beerStyles = new JComboBox<>();
        beerStyles.addItemListener(this);
        String[] beerResponse = styleApp.styleList;
        for (int i = 0; i < 27; i++) {
            if (i != 0 ) {
                beerStyles.addItem(beerResponse[i]);
            }
        } 
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
        //JTextField ibuText = new JTextField(5);
        Font ibuFont = ibuText.getFont().deriveFont(Font.PLAIN, 12f);
        ibuText.setFont(ibuFont);
        ibuText.setEditable(false);
        ibuText.setText("0");
        
        srmText.setFont(ibuFont);
        srmText.setEditable(false);
        srmText.setText("0");
        
        ogText.setFont(ibuFont);
        ogText.setEditable(false);
        ogText.setText("0");
        
        fgText.setFont(ibuFont);
        fgText.setEditable(false);
        fgText.setText("0");
        
        abvText.setFont(ibuFont);
        abvText.setEditable(false);
        abvText.setText("0");
        
        specialTextField.setEditable(false);
        specialTextField.setLineWrap(true);
        specialTextField.setWrapStyleWord(true);
        specialTextField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.DARK_GRAY), "Characteristic Ingredients"));
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
        BorderLayout midSub1 = new BorderLayout();
        recipie.setLayout(midSub1);
        
        //Mid panel 1 - Batch size & yeast type top bar
        JPanel midPan1 = new JPanel();
        FlowLayout yeastnBatch = new FlowLayout(FlowLayout.CENTER);
        midPan1.setLayout(yeastnBatch);
        midPan1.setBackground(Color.WHITE);
        JButton calc = new JButton("Calculate");
        JLabel calcSpace = new JLabel("      ");
        JTextField size = new JTextField("5", 2);
        JLabel sizeLabel = new JLabel("Batch Size (Gallons): ");
        JLabel yeastLabel = new JLabel("      Yeast Type: ");
        JComboBox<String> yeast = new JComboBox<>();
        String[] yeastResponse = yeast1.yeastList;
        for (int i = 0; i < 28; i++) {
            if (i != 0 ) {
                yeast.addItem(yeastResponse[i]);
            }
        }
        midPan1.add(sizeLabel);
        midPan1.add(size);
        midPan1.add(yeastLabel);
        midPan1.add(yeast);
        midPan1.add(calcSpace);
        midPan1.add(calc);
        midPan1.setBorder(new EmptyBorder(0, 10, 0, 0) );
        recipie.add(midPan1, BorderLayout.NORTH);
        beerStyles.setBackground(Color.WHITE);
        
            //Mid panel 2 - Hops & Grain
        JPanel midPan2 = new JPanel();
        FlowLayout midSub2 = new FlowLayout();
        midPan2.setLayout(midSub2);
        midPan2.setBackground(Color.WHITE);
        
                //Mid panel 2 - Grains
        JPanel grains = new JPanel();
        FlowLayout grainsLayout = new FlowLayout(FlowLayout.LEFT);
        grains.setLayout(grainsLayout);
        
        
        grainCombo.addItemListener(this);
        String[] grainResponse = grain.grainList;
        for (int i = 0; i < 47; i++) {
            if (i != 0 ) {
                grainCombo.addItem(grainResponse[i]);
            }
        }
        grainCombo.addItem("");
        
        
        grainTable.setBackground(Color.WHITE);
        grainTable.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(grainCombo));
        grainTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        grains.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.WHITE, Color.WHITE), "Grains"));
        //grains.setBorder(new EmptyBorder(10, 10, 10, 10));
        grains.setBackground(Color.WHITE);
        grains.add(new JScrollPane(grainTable));
        grains.setPreferredSize(new Dimension(500, 150));
        midPan2.add(grains);
        
                //Mid panel 2 - Hops
        JPanel hops = new JPanel();
        hops.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        JComboBox<String> hopCombo = new JComboBox<>();
        hopCombo.addItemListener(this);
        String[] hopResponse = hopApp.hopList;
        for (int i = 0; i < 31; i++) {
            if (i != 0 ) {
                hopCombo.addItem(hopResponse[i]);
            }
        }
        hopCombo.addItem("");
        
        
        hopTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        hopTable.setBackground(Color.WHITE);
        hopTable.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(hopCombo));
        hops.setBackground(Color.WHITE);
        hops.add(new JScrollPane(hopTable));
        hops.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.WHITE, Color.WHITE), "Hops"));
        hops.setPreferredSize(new Dimension(500, 150));
        midPan2.add(hops);
        
        recipie.add(midPan2, BorderLayout.CENTER);
        
      //  JLabel recipieText = new JLabel("Recipie section under construction");
        recipie.setBorder(BorderFactory.createTitledBorder("Grain Bill, Hops & Yeast"));;
       // recipie.add(recipieText);
        recipie.setBackground(Color.WHITE);
        inner.add(recipie);
        
        //Bottom grid (1,3)
        JPanel calcualted = new JPanel();
        JLabel calcIbu = new JLabel("IBU's:");
        JLabel calcSrm = new JLabel("SRM:");
        JLabel calcOg = new JLabel("O.G.:");
        JLabel calcFg = new JLabel("F.G.:");
        JLabel calcAbv = new JLabel("% ABV:");
        
        JTextField cIbuT = new JTextField(5);
        cIbuT.setEditable(false);
        cIbuT.setFont(ibuFont);
        cIbuT.setText("0");
        JTextField cSrmT = new JTextField(5);
        cSrmT.setEditable(false);
        cSrmT.setFont(ibuFont);
        cSrmT.setText("0");
        JTextField cOgT = new JTextField(5);
        cOgT.setEditable(false);
        cOgT.setFont(ibuFont);
        cOgT.setText("0");
        JTextField cFgT = new JTextField(5);
        cFgT.setEditable(false);
        cFgT.setFont(ibuFont);
        cFgT.setText("0");
        JTextField cAbvT = new JTextField(5);
        cAbvT.setEditable(false);
        cAbvT.setFont(ibuFont);
        cAbvT.setText("0");
        
        JTextArea charac = new JTextArea(2,50);
        charac.setEditable(false);
        charac.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.DARK_GRAY), "Characteristics"));
        //JLabel calcText = new JLabel("Calculated section is under construction");
        calcualted.setBorder(BorderFactory.createTitledBorder("Calculated Characteristics"));
        //calcualted.add(calcText);
        calcualted.add(calcIbu);
        calcualted.add(cIbuT);
        calcualted.add(calcSrm);
        calcualted.add(cSrmT);
        calcualted.add(calcOg);
        calcualted.add(cOgT);
        calcualted.add(calcFg);
        calcualted.add(cFgT);
        calcualted.add(calcAbv);
        calcualted.add(cAbvT);
        calcualted.add(charac);
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