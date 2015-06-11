# BrewAssist #
### Introduction ###

This project is a brewing assistance program.  Its is designed to assist beer homebrewers to create batch recipies, track brew day progress and track key brewing metrics over multiple batches.
  
### Motivation ###
This is a learning project for me to help bridge two of my interests; brewing beer and programming.  My background in programming is based on C / Assembly, so this is my first time learning an object oriented program.  I have no dought that this program is really inefficient and I am probably doing a lot of things the hard way.

I took insparation from other comercially available options (Like BrewSmith or Beertarget) but I wanted to create something tailored to exacly what I wanted.  I also wanted to learn how to design my own batch of beer from scratch.

### Installation and Use ###
<h5><i> Installation </i></h5>
There isnt any special installation instructions, the program, by default, is designed to work as is from  any location you copy it to.  All you need to do is navigate to BrewAssist\dist and open the executable jar file.

<h5><i> Program Use </i></h5>
Using the program requires some knowldege about what recipie you want to build.  But in general you can follow this procedure below.

Please note: there is a known bug with the table (Hops and grains table) not populating the ingredient characteristics afer selecting them.  All you have to do is click on any cell in the first column.  I am currently looking into alternatives.

<ol>
  <li>Choose what beer style you are trying to create from the style selector</li>
  <li>Choose your gain bill, batch size, yeast type, and hop additions in the tables.  Make sure to fillout the amounts.</li>
  <li>Hit calculate, your metrics are shown at the bottom of the program</li>
  <li>Compare your calculated metrics with the target metrics at the top of the page.  Alter your recipie as needed.</li>
</ol>
  
### Code Overview ###

There is two main packages in this project; com.Ingredients and com.BrewAsist.

<h4><b> com.Ingredients </b></h4>
This package contains five classes, one for each ingredient type and one for beer styles.; Extract Ingredients (Liquid and Dry Malt Extract), Whole Grain (Malted barley), hops, yeast and beer styles.  Each class contains the following methods.

<h5><i> isIngredients </i></h5>
```
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
```

<h5><i> getIngredients </i></h5>
```
/**
  * Given a beer name as a String, calls a helper function that
  * sets the characteristics in the UI.
  * <p>
  * This method is the main means to set beer style characteristics.  It
  * pulls the String information via a combo box in the main UI.
  *
  * @param  in   a string name of the desired ingredient.
  */  
```

<h5><i> Ingredient Storage Methods </i></h5>
```
/**
  * Sets the global variables to the given style.
  *
  */
```

<h4><b> com.BrewAssist </b></h4>
This package contains four classes; BrewAssistUI, NewWholeGrainEvent, SaveWholeGrain and WholeGrainCalc.  A high level summary of each class is below.

<h5><i>  BrewAssistUI </i></h5>
This class contains all of the UI elements, using Java swing.  This class also contains all of the popup warnings and action events.  This class is the main method.

<h5><i> NewWholeGrainEvent </i></h5>
This class ties into the BrewAssistUI class and imports ingredients information from the com.Ingredients package.  When an event occurs in BrewAssistUI it passes the information to NewWholeGrainEvent and pulls the information from the com.Ingredients package.

<h5><i> SaveWholeGrain </i></h5>
This class ties into the BrewAssistUI class and saves all data to a file located in C:\BrewAsist\wg\.  It also contains a method that checks the existinace of the file structure in c:\BrewAssist\, if that directly does not exist it creates it.  Creadted brewing recipies are saved in properties files.

<h5><i> WholeGainCalc </i></h5>
This class ties into BrewAssistUI and pulls ingredient information from the com.Ingredients package.  It contains all of the methods needed to calculate the key merics for brewing beer; IBU, SRM, Degrees Lovibond, Orignal Gravity, Final Gravity and ABV.  Once the "Calculate" button is selected, a method in the BrewAsssistUI class calls the calculate class in the WholeGrainClass.  This method then runs though a handful of helper methods that pull the required information form BrewAssistUI, calculates the target meric, and saves the final result in BrewAssistUI.
