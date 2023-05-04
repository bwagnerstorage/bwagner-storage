<?php
   session_start();
   if($_SESSION['username'] != 'CompSci_Student') 
       header("Location: /index.html");
?>

<!DOCTYPE html>
<html>
  <head>
    <style>
      #container {
        font-size: 1.3em;
      }
      ol li {
        padding-bottom: 5px;
      }
      h2 {
        background-color: lightgray;
      }

      #completedCode1 {
        display: none;
      }

      #completedCode2 {
        display: none;
      }

      #completedCode3 {
        display: none;
      }

      #completedCode4 {
        display: none;
      }

      #completedCode5 {
        display: none;
      }

      #completedCode6 {
        display: none;
      }

      #completedCode7 {
        display: none;
      }

      #completedCode8 {
        display: none;
      }

      img {
        width: 550px;
      }
      #csSampleRun
      {
        color: white;
        background-color: black;
        width: 600px;
        padding: 10px;
        margin: 5px;
      }

      a
      {
        text-decoration: none;
        text-align: center;
        background-color: lightgray;
        color: black;
        border: 2px solid darkgray;
        border-radius: 25px;
        width: 143px;
        height: 35px;
        font-size: 1.3rem;
        padding-left: 10px;
        padding-right: 10px;
        padding-top: 7px;
        margin-bottom: 10px;
      }
      a:link {
        text-decoration: none;
      }
      a:visited {
        text-decoration: none;
      }
      a:hover {
        text-decoration: none;
        background-color: black;
        color: white;
      }

      .solutionContainer {
        display:flex;
        flex-direction: column;
      }
    </style>
  </head>

<body>
<div id = "container"> 
    <h1 style="text-align:center">Favorites Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>Favorites.java</strong> file.</p>
<img src="/csregular/unit20_classesSpecial/solutions/images/favorites1.jpg" style="width:650px;"><br>


<h2>Add Instance Variable </h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit20_classesSpecial/solutions/images/favorites2.jpg" style="width:50%">
  </div>

  <h2>Implement Constructor</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit20_classesSpecial/solutions/images/favorites3.jpg" style="width:60%">
  </div>

  <h2>Implement toString Method</h2>

<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
    <img id="completedCode3" src="/csregular/unit20_classesSpecial/solutions/images/favorites4.jpg" style="width:50%">
</div>

<h2>FavoritesManager Class</h2>
<br>
<p>Add the following code to the file <strong>FavoritesManager.java</strong>.</p>
<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
    <img id="completedCode4" src="/csregular/unit20_classesSpecial/solutions/images/favorites5.jpg" style="width:50%">
</div>

<h2>Add instance variable myRectangle</h2>

<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode5')" id="completedCode5a">Show Code</a>
    <img id="completedCode5" src="/csregular/unit20_classesSpecial/solutions/images/favorites6.jpg" style="width:50%">
</div>

<h2>Method inputFavorites</h2>

<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode6')" id="completedCode6a">Show Code</a>
    <img id="completedCode6" src="/csregular/unit20_classesSpecial/solutions/images/favorites7.jpg" style="width:60%">
</div>

<h2>Method printFavorites</h2>

<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode7')" id="completedCode7a">Show Code</a>
    <img id="completedCode7" src="/csregular/unit20_classesSpecial/solutions/images/favorites8.jpg" style="width:60%">
</div>

  <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
Enter person's name --> John Wayne
Enter favorite food --> Chinese
Enter favorite color --> Purple
Enter favorite music --> Classical
Enter favorite automobile --> Ford Truck
Enter favorite sport --> Football


       My Favorites
----------------------------
Name       : John Wayne
Food       : Chinese
Color      : Purple
Music      : Classical
Automobile : Ford Truck
Sport      : Football
   </pre>
  </div>

  <br>
</div>
<script>
function makeVisible(id)
{
    let element = document.getElementById(id);
    let display = element.currentStyle ? element.currentStyle.display :
        getComputedStyle(element, null).display;

    if(display === "none")
    {
      element.style.display = "block";
      let anchor = id+"a";
      document.getElementById(anchor).innerHTML = "Hide Code";
    }
    else
    {
      element.style.display = "none";
      let anchor = id+"a";
      document.getElementById(anchor).innerHTML = "Show Code";
    }
}
</script>
</body>	
</html>
