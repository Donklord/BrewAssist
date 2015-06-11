# BrewAssist #
### Introduction ###

  This project is a brewing assistance program.  Its is designed to assist beer homebrewers to create batch recipies, track brew day progress and track key brewing metrics over multiple batches.
  
### Code Examples ###

There is two main packages to this project.

<h4> com.Ingredients </h4>
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

<h4> com.BrewAssist </h4>
This package contains four classes; BrewAssistUI, NewWholeGrainEvent, SaveWholeGrain and WholeGrainCalc.  A high level summary of each class is below.

<h5>  BrewAssistUI </h5>
This class contains all of the UI elements, using Java swing.  This class also contains all of the popup warnings and action events.  This class is the main method.

<h5> NewWholeGrainEvent </h5>
This class ties into the BrewAssistUI class and imports ingredients information from the com.Ingredients package.  When an event occurs in BrewAssistUI it passes the information to NewWholeGrainEvent and pulls the information from the com.Ingredients package.

<h5> SaveWholeGrain </h5>
