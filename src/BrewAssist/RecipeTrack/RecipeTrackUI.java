package BrewAssist.RecipeTrack;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class RecipeTrackUI extends JFrame {
    
    JPanel wgTrack = new JPanel();
    JPanel extTrack = new JPanel();
    
    public RecipeTrackUI() {
        
        super("Brewing Assistant - Recipe Tracking");
        JTabbedPane track = new JTabbedPane();
        
        createWgTrack();
        track.addTab("Batch Tracking - Whole Grain", null, wgTrack, "Track a Whole Grain Batch");
        
        //Call exract method here
        track.addTab("Batch Tracking - Extract", null, extTrack, "Track an Extract Batch");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1080,900);
        add(track);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    private void createWgTrack() {
        JPanel overview = new JPanel();
        JPanel recipe = new JPanel();
        JPanel mash = new JPanel();
        JPanel fermentation = new JPanel();
        
        wgTrack.setLayout(new BoxLayout(wgTrack, BoxLayout.Y_AXIS));
        wgTrack.add(overview);
        wgTrack.add(recipe);
        wgTrack.add(mash);
        wgTrack.add(fermentation);
        
        //Overview
        SpringLayout overviewLayout = new SpringLayout();
        overview.setLayout(overviewLayout);
        JLabel title = new JLabel("Batch Name:");
        JTextField titleField = new JTextField();
    } 
}