
package BrewAssist.RecipeBuilder;

import BrewAssist.Ingredients.yeast;
import BrewAssist.Ingredients.Hops;
import BrewAssist.Ingredients.WholeGrain;
import BrewAssist.Ingredients.Styles;
import BrewAssist.Core.*;
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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;

public class BrewAssistUI extends JFrame implements ActionListener, ItemListener {
    NewWholeGrainEvent wholeGrainEvent = new NewWholeGrainEvent(this);
    WholeGrainCalc wholeGrainCalc = new WholeGrainCalc(this);
    Core file = new Core();
    //public SaveWholeGrain saveGrain = new SaveWholeGrain(this);
    Recipe saveGrain = new Recipe(this);
    //FileLoader fileLoad = new FileLoader(this);
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
    JLabel wgMessage = new JLabel("");
    
    JTextField ibuText = new JTextField(5);
    JTextField srmText = new JTextField(5);
    JTextField ogText = new JTextField(6);
    JTextField fgText = new JTextField(6);
    JTextField abvText = new JTextField(5);
    public JTextField grainName = new JTextField(15);
    JTextArea specialTextField = new JTextArea(2,50);
    JComboBox<String> grainCombo = new JComboBox<>();
    public Object[][] grainData = {
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
    public Object[][] hopData = {
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        {"", "", "", "", ""},
        };
    JTable hopTable = new JTable(hopData, hopColNames);
    public JComboBox<String> beerStyles = new JComboBox<>();
    public JComboBox<String> yeast = new JComboBox<>();
    
    JTextField test = new JTextField();
    private JLabel calcIbu = new JLabel("IBU's:");
    private JLabel calcSrm = new JLabel("SRM:");
    private JLabel calcOg = new JLabel("O.G.:");
    private JLabel calcFg = new JLabel("F.G.:");
    private JLabel calcAbv = new JLabel("% ABV:");
    public JTextField size = new JTextField("5", 2);
    public JTextField cIbuT = new JTextField(5);
    public JTextField cSrmT = new JTextField(5);
    public JTextField cOgT = new JTextField(5);
    public JTextField cFgT = new JTextField(5);
    public JTextField cAbvT = new JTextField(5);
    JFrame wgLoadFrame = new JFrame();
    public JTextArea charac = new JTextArea(10,50);
    public JTextField series_field = new JTextField(10);
    
  /**
    * Only constructor, sets up and configures main frame.  Calls helper function to paint tabs.
    * 
    */
    public BrewAssistUI() {
     
        super("Brewing Assistant - Recipe Builder");
        createNewBrew_WholeGrain();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1080,900);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
  /**
    * Item (Combo box) action method.  Validate and repaints frame when run.
    * If combo box state has changed, runs helper function itemChanged (which 
    * passes the combo box contents) which performs an action.
    * <p>
    * This method is the main tie in between the BrewAssistUI and 
    * NewWholeGrainEvent classes.
    *
    * @param  item   An item event
    */
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
    
  /**
    * Action (button) action method.  Performs button action based on button pressed.
    * Save batch, load batch, new batch, calculate.
    *
    * @param  event   An action event
    */
    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        File t = new File("C:\\BrewAssist\\Saves\\" + series_field.getText());
        int answer = -1;
        if (command.equals("New Batch")) {
            if (savedWg == false) {
                answer = throwNewBatchWarning();
                if (answer == 0) {
                    savedWg = false;
                    wgMessage.setText("A new batch has been started!");
                    wholeGrainEvent.newGrain();
                }
            } else if (savedWg == true) {
                savedWg = false;
                wgMessage.setText("A new batch has been started!");
                wholeGrainEvent.newGrain();
            }
        } else if (command.equals("Load Batch")) {
            System.out.println("Test" + series_field.getText());
            if (savedWg == false) {
                answer = throwNewBatchWarning();
                if (answer == 0) {
                    savedWg = false;
                    if (!t.exists() || series_field.getText().equals("")) {
                        wgMessage.setText("You must select a valid series!");
                    } else {
                        Boolean x = saveGrain.loadRecipe();
                        if (x == true)
                            wgMessage.setText("A new batch has been loaded!");
                    }
                }
            } else if (savedWg == true) {
                savedWg = false;
                if (!t.exists() || series_field.getText().equals("")) {
                    wgMessage.setText("You must select a valid series!");
                } else {
                    Boolean x = saveGrain.loadRecipe();
                    if (x == true)
                        wgMessage.setText("A new batch has been loaded!");
                }
            } 
        } else if (command.equals("Save Batch")) {
            savedWg = true;
            if (!t.exists() || series_field.getText().equals("")) {
                if (series_field.getText().equals("")) {
                    wgMessage.setText("Series can not be empty!");
                } else {
                    file.createNewIndex(series_field.getText());
                    file.createNewSeriesDirectory(series_field.getText());
                    saveGrain.saveRecipe();
                }
            } else {
                if (!series_field.getText().equals("") && t.exists()) {
                    saveGrain.saveRecipe();
                }
            }
        } else if (command.equals("Calculate")) {
            wholeGrainCalc.calculate();
        } else if (command.equals("...")) {
            System.out.println("This is a test");
            saveGrain.loadSeries();
        }
        
    }
    
  /**
    * Pop up box that asks the user if they want to override unsaved work when 
    * pressing "New Batch" or "Load Batch" without saving first.
    * <p>
    * This method is called from the actionPerformed method above.
    *
    * @return   Integer response (0 is OK, 1 is cancel)
    */
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
    
    public void tableRefresh() {
       // grainTable.getModel().setValueAt(grain, WIDTH, WIDTH);
        //hopTable.repaint();
    }
    
   /**
    * Populates the "Whole" tab.
    * <p>
    * This method is called from the constructor and adds the UI elements for the Whole tab.
    *
    */
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
        selectStyle.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.DARK_GRAY), "Select Style"));
        selectStyle.setBackground(Color.WHITE);
        //JLabel newBrewLabel = new JLabel("Drop down under construction", JLabel.CENTER);
        JPanel subPanel3 = new JPanel();
        FlowLayout subLayout3 = new FlowLayout(FlowLayout.CENTER);
        subPanel3.setLayout(subLayout3);
        subPanel3.setBackground(Color.WHITE);
        
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
        calc.addActionListener(this);
        JLabel calcSpace = new JLabel("      ");
        
        JLabel sizeLabel = new JLabel("Batch Size (Gallons): ");
        JLabel yeastLabel = new JLabel("      Yeast Type: ");
        
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
        
        
        
        cIbuT.setEditable(false);
        cIbuT.setFont(ibuFont);
        cIbuT.setText("0");
        
        cSrmT.setEditable(false);
        cSrmT.setFont(ibuFont);
        cSrmT.setText("0");
        
        cOgT.setEditable(false);
        cOgT.setFont(ibuFont);
        cOgT.setText("0");
        
        cFgT.setEditable(false);
        cFgT.setFont(ibuFont);
        cFgT.setText("0");
        
        cAbvT.setEditable(false);
        cAbvT.setFont(ibuFont);
        cAbvT.setText("0");
        
        charac.setLineWrap(true);
        charac.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.DARK_GRAY), "Notes"));
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
        JLabel grainLabel = new JLabel("         Batch Name: ");
        JLabel series = new JLabel("     Series: ");
        JPanel topBar = new JPanel();
        topBar.setBackground(Color.WHITE);
        FlowLayout topLayout = new FlowLayout(FlowLayout.RIGHT);
        grainName.setFont(ibuFont);
        JButton newButton = new JButton("New Batch");
        JButton loadButton = new JButton("Load Batch");
        JButton saveButton = new JButton("Save Batch");
        JButton ect = new JButton("...");
        ect.setPreferredSize(new Dimension(20,20));
        newButton.addActionListener(this);
        loadButton.addActionListener(this);
        saveButton.addActionListener(this);
        ect.addActionListener(this);
        topBar.setLayout(topLayout);
        topBar.add(wgMessage);
        topBar.add(grainLabel);
        topBar.add(grainName);
        topBar.add(series);
        topBar.add(series_field);
        topBar.add(ect);
        topBar.add(newButton);
        topBar.add(loadButton);
        topBar.add(saveButton);
        newBrew_WholeGrain.add(topBar,BorderLayout.NORTH);
        newBrew_WholeGrain.add(inner,BorderLayout.CENTER);
        add(newBrew_WholeGrain,BorderLayout.CENTER);
    }
    
  /**
    * Set UI's Look and Feel
    * <p>
    * This method is called from the constructor.
    *
    */
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.basic");  //com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel
        } catch (Exception exc) {
            //do nothing
        }
    }
    
  /**
    * Main method, calls BrewAssistUI (Main UI elements) and createDirectory method in the SaveWholeGrain class.
    *
    * @param arguments 
    */
  //  public static void main(String[] arguments) {
   //     BrewAssistUI app = new BrewAssistUI();
  //     app.saveGrain.createDirectory();
   // }
}