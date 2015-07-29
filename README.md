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
<hr>
<h5><i> Installation </i></h5>
There isnt any special installation instructions, the program is designed to work as is from  any location you copy it to.  All you need to do is navigate to BrewAssist\dist and open the executable jar file.

<h5><i> Program Use </i></h5>
Using the program requires some knowldege about what recipie you want to build.  This program is designed around a series of tools that all work together.  You can easily load all of these tools from the main loading menu.  A brief description of each tool, and its completion status is below.

<ul>
  <li>Recipe Builder: Create a new Recipe and choose the associated series.  Status: V1.0 complete</li>
  <li>Batch Tracker: Select the desired series and recipe and track your brew day progress.  Status: V1.0 complete</li>
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

Please note:  This is a known bug with the Tables for this tool, when selecting the grain or hop type in the first column the the associated characteristics to the right may not populate right away.  To fix this you need to simply click on any of the other cells in the first column.  I am looking into ways to fix this.

Your recipe is now ready to be tracked using the Recipe Tracker tool.  With that program open, follow the procedure below.

<ol>
  <li>Select your series.</li>
  <li>Select your recipe.</li>
  <li>Fill out the tracking form as your brew day commences.</li>
  <li>Save your tracking sheet once everything is complete.</li>
</ol>
  
### Code Overview ###
<hr>

There are five packages in this project; BrewAssist.Run, BrewAssist.Core, BrewAssist.Ingredients, BrewAssist.RecipeBuilder and BrewAssist.RecipeTrack.  These packages can be split into two categories, Backbone (BrewAssist.Core and BrewAssist.Ingredients) and UI (BrewAssist.Run, BrewAssist.RecipeBuilder and BrewAssist.RecipeTrack).

<h4><b> BrewAssist.Run </b></h4>
This package contains the UI elements for the main loading screen.  It also contains the main class.

<h4><b> BrewAssist.Core </b></h4>
This package contains all of the file management methods which includes; directory checking and creation, series creation and loading, recipe loading and saving and batch loading and saving.  It also contains any other methods that cant be categorized in any other package.

<h4><b> BrewAssist.Ingredients </b></h4>
This package stores and provides the mehod for retrieval of all ingredients (hops, grains, yeast) and beer syles.

<h4><b> BrewAssist.RecipeBuilder </b></h4>
This package conains all of the UI elements, event handling, and recipe calculations for the recipe builder tool.

<h4><b> BrewAssist.RecipeTrack </b></h4>
This package contains all of the UI elements and event handling for the recipe tracking tool.

### To Do ###
<hr>

<h5><i> To Do List </i></h5>
<ul style="list-style-type:square">
  <li>Update Recipe Builder UI</li>
  <li>Add text filters to all editable fields in Recipe Builder</li>
  <li>Enhance recipe calculations to handle the usage of steeping grains</li>
  <li>Update recipe builder UI to handle steeping grains</li>
  <li>Add text filters to all editable fields in Recipe Track</li>
  <li>Create series analyics tool</li>
  <li>Create ingredient picker tool</li>
  <li>Create ingredient editor tool</li>
  <li>Create settings tool</li>
  <li>Create help tool</li>
</ul>

<h5><i> Known Bugs </i></h5>
<ul style="list-style-type:square">
  <li>When selecting an ingredient type (for hops or grain table), the table appears to "lag" behind to populate the characteristics.  You need to click any other cell in the first column to list them.</li>
</ul>
