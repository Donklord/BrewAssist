# BrewAssist #
### Introduction ###

  This project is a brewing assistance program.  Its is designed to assist beer homebrewers to create batch recipies, track brew day progress and track key brewing metrics over multiple batches.
  
### Code Examples ###

There is two main packages to this project.

<h5> com.Ingredients </h5>
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
