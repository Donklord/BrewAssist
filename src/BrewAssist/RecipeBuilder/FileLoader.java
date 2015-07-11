package BrewAssist.RecipeBuilder;

import java.awt.FileDialog;
import java.awt.Frame;

public class FileLoader {
    BrewAssistUI gui;
    public FileLoader(BrewAssistUI in) {
        gui = in;
    }
    
  /**
    * Whole Grain Batch File Selector
    * <p>
    * This method is called from the BrewAssitUI class when a "Load File" button is 
    * pressed.  The user selects the desired batch and this method returns the name 
    * of that batch for post processing.
    *
    * @return String containing the selected file name.
    */
    public String wgLoad() {
        String filename = "Empty";
        Frame f = new Frame();
        f.setLocationRelativeTo(null);
        FileDialog fd = new FileDialog(f, "Select a batch", FileDialog.LOAD);
        fd.setDirectory("C:\\BrewAssist\\Saves\\Recipe\\wg");
        fd.setFile("*.properties");
        fd.setVisible(true);
        filename = fd.getFile();
        //Logging
        if (filename.contains("Empty"))
            System.out.println("WG Load: No file chosen");
        else
            System.out.println("WG Load: File " + filename + " was loaded");
        
        return filename;
    }
}
    