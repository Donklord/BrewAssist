# BrewAssist #
### Introduction ###

This project is a brewing assistance program.  Its is designed to assist beer homebrewers to create recipies, track brew day progress and track key brewing metrics over multiple batches.  In order to facilitate this, I organize the types of beers you are trying to brew into what I call "series".  

A series is a way to organize multiple batches, and recipes into one core beer style you are trying to perfect.  Lets say you are attempting to make an IPA (Indian Pale Ale) called "Phil's Pale Ale".  In this case, the series will be called "Phil's Pale Ale", and you would start by making the first recipe iteration and attempting to brew it a couple of times to see how it turns out, called "Batches".  If you need to tweak the recipe a bit, you would simply create a new recipe iteration under the same series, and brew a few more batches with this recipe.  All of this information is tracked and stored in the Brew Assist software.  

With all of this information stored, you now have the ability to track your progress.  I want to accomplish this by providing an easy to use graphing tool, that will display all of the key metircs in one screeen.  It is my goal to allow the user to glean any helpful information to help them imporove their recipe.  I have a handful of ideas on how I want this to work. 

<ol>
  <li>Track all of the batches associated with a single recipe.</li>
  <li>Track all of your recipe iterations and how it evolved.</li>
  <li>Track everything, your recipe interations and batches in one screen.</li>
</ol>


### Motivation ###
<hr>
This is a learning project for me to help bridge two of my interests; brewing beer and programming.  My background in programming is based on C / Assembly, so this is my first time learning an object oriented programing language.  I have no dought that this program is really inefficient and I am probably doing a lot of things the hard way.

I took insparation from other comercially available options (Like BrewSmith or Beertarget) but I wanted to create something tailored to exacly what I wanted.  I also wanted to learn how to design my own batch of beer from scratch.

### Installation and Use ###
<h5><i> Installation </i></h5>
There isnt any special installation instructions, the program is designed to work as is from  any location you copy it to.  All you need to do is navigate to BrewAssist\dist and open the executable jar file.

<h5><i> Program Use </i></h5>
Using the program requires some knowldege about what recipie you want to build.  This program is designed around a series of tools that all work together.  You can easily load all of these tools from the main loading menu.  A brief description of each tool, and its status is below.

<ul>
  <li>Recipe Builder: Create a new Recipe and choose the associated series.  Status: First version complete</li>
  <li>Batch Tracker: Select the desired series and recipe and track your brew day progress.  Status: First version complete</li>
  <li>Series Analytics:  Track key recipe and batch metrics over multiple iterations.  Status: Not Started</li>
  <li>Ingredient Picker: Helpful lookup program that allows you to view all avaialble ingredients (Hops, Grains, Yeast, Beer Styles).  Status: Not Started</li>
  <li>Ingredient Editor:  Allows the user to add any ingredient that is not currently available.  Status: Not Started</li>
  <li>Settings:  Program settings.  Status: Not Started</li>
  <li>Help:  Getting started guide, general help topics.  Status: Not Started</li>
</ul>

To start you need to create a new batch and series in the Recipe Builder tool.  When in the recipe builder follow the procedure below.

<ol>
  <li>Fill in the name of the beer series you are creating (I.E. Phil's Pale Ale).</li>
  <li>Fill in the name of the current recipe iteration (I.E. Recipe #1).</li>
  <li>Fill out all of the recipe information; batch style, size, yeast type, grain bill, and hop additions.</li>
  <li>Click calculated to view your target metrics.</li>
  <li>Alter your recipe until your calcualted charactaristics match the batch characteristics.</li>
  <li>Save your recipe when you are happy with it.</li>
</ol>

Please note:  This is a known bug with the Tables for this tool, when selecting the grain or hop type in the first column the the associated characteristics to the left may not populate right away.  To fix this you need to simply click on any of the other cells in the first column.  I am looking into ways to fix this.


  
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
This class contains all of the UI elements, using Java swing.  This class also contains all of the popup warnings and action events.  This class contains the main method.

<h5><i> NewWholeGrainEvent </i></h5>
This class ties into the BrewAssistUI class and imports ingredients information from the com.Ingredients package.  When an event occurs in BrewAssistUI it passes the information to NewWholeGrainEvent and pulls the information from the com.Ingredients package.

<h5><i> SaveWholeGrain </i></h5>
This class ties into the BrewAssistUI class and saves all data to a file located in C:\BrewAsist\wg\.  It also contains a method that checks the existinace of the file structure in c:\BrewAssist\, if that directly does not exist it creates it.  Creadted brewing recipies are saved in properties files.

<h5><i> WholeGainCalc </i></h5>
This class ties into BrewAssistUI and pulls ingredient information from the com.Ingredients package.  It contains all of the methods needed to calculate the key merics for brewing beer; IBU, SRM, Degrees Lovibond, Orignal Gravity, Final Gravity and ABV.  Once the "Calculate" button is selected, a method in the BrewAsssistUI class calls the calculate class in the WholeGrainClass.  This method then runs though a handful of helper methods that pull the required information form BrewAssistUI, calculates the target meric, and saves the final result in BrewAssistUI.

### To Do ###

<h5><i> To Do List </i></h5>
<ul style="list-style-type:square">
  <li>Create Extract UI</li>
  <li>Create Extract Events</li>
  <li>Add Extract ingredients</li>
  <li>Create "Load Batch" popup</li>
  <li>Create batch loading functionality</li>
  <li>Create batch calculation pop up window (will show you what calculations were used)</li>
  <li>Create settings menu</li>
  <li>Add swtiching between metric and english units</li>
  <li>Add ingredient picker (Allows you to navigate all available ingredients and see more information about them)</li>
  <li>Create a brew day tracking tab.  Allows user to load the target batch and track the brewday progress</li>
  <li>Create batch tracking functionality, track a recipie across multiple batches and display how the target metrics varied over time.</li>
  <li>Create "Post-mortem" functionality.  Program will try to identify flaws when creating a recipie.  (Beer Analytics!)</li>
</ul>

<h5><i> Wish List </i></h5>
Items that I want to do, but are a little out of reach given my current skill level.
<ul style="list-style-type:square">
  <li>Update UI (Make it pretty)</li>
  <li>Allow user the ability to add custom ingredients and beer styles</li>
  <li>Allow user to display batch in a prettier format for printing.</li>
</ul>

<h5><i> Known Bugs </i></h5>
<ul style="list-style-type:square">
  <li>When selecting an ingredient type (for hops or grain table), the table appears to "lag" behind to populate the characteristics.  You need to click any other cell in the first column to list them.</li>
</ul>
