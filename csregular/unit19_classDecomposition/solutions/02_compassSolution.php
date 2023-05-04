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
    <h1 style="text-align:center">Compass Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>Compass.java</strong> file.</p>
<img src="/csregular/unit19_classDecomposition/solutions/images/compass01a.JPG" style="width:650px;"><br>
<img src="/csregular/unit19_classDecomposition/solutions/images/compass01b.JPG" style="width:650px;"><br>
<p>Add the following starter code to the <strong>CompassManager.java</strong> file.</p>
<img src="/csregular/unit19_classDecomposition/solutions/images/compass01c.JPG" style="width:650px;"><br>
<img src="/csregular/unit19_classDecomposition/solutions/images/compass01d.JPG" style="width:650px;"><br>


<h2>Method turnRight</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit19_classDecomposition/solutions/images/compass02.JPG" style="width:60%">
  </div>

  <h2>Method turnLeft</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit19_classDecomposition/solutions/images/compass03.JPG" style="width:60%">
  </div>

  <h2>Method turnDegrees</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit19_classDecomposition/solutions/images/compass04.JPG" style="width:60%">
  </div>

  <h2>Method getHeading</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
      <img id="completedCode4" src="/csregular/unit19_classDecomposition/solutions/images/compass05.JPG" style="width:60%">
  </div>

  <h2>Method getDirection</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode5')" id="completedCode5a">Show Code</a>
      <img id="completedCode5" src="/csregular/unit19_classDecomposition/solutions/images/compass06.JPG" style="width:60%">
  </div>
 
  <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
**********************
*    Compass Test    *
**********************

================================
 Current Heading   = 0
 Current Direction = North
================================

1. Turn Right One Degree
2. Turn Left One Degree
3. Turn (degrees)
4. Quit

Make selection -->1
================================
 Current Heading   = 1
 Current Direction = North
================================

1. Turn Right One Degree
2. Turn Left One Degree
3. Turn (degrees)
4. Quit

Make selection -->1
================================
 Current Heading   = 2
 Current Direction = North
================================

1. Turn Right One Degree
2. Turn Left One Degree
3. Turn (degrees)
4. Quit

Make selection -->2
================================
 Current Heading   = 1
 Current Direction = North
================================

1. Turn Right One Degree
2. Turn Left One Degree
3. Turn (degrees)
4. Quit

Make selection -->2
================================
 Current Heading   = 0
 Current Direction = North
================================

1. Turn Right One Degree
2. Turn Left One Degree
3. Turn (degrees)
4. Quit

Make selection -->2
================================
 Current Heading   = 359
 Current Direction = North
================================

1. Turn Right One Degree
2. Turn Left One Degree
3. Turn (degrees)
4. Quit

Make selection -->2
================================
 Current Heading   = 358
 Current Direction = North
================================

1. Turn Right One Degree
2. Turn Left One Degree
3. Turn (degrees)
4. Quit

Make selection -->1
================================
 Current Heading   = 359
 Current Direction = North
================================

1. Turn Right One Degree
2. Turn Left One Degree
3. Turn (degrees)
4. Quit

Make selection -->1
================================
 Current Heading   = 0
 Current Direction = North
================================

1. Turn Right One Degree
2. Turn Left One Degree
3. Turn (degrees)
4. Quit

Make selection -->3

Enter degrees (- turns left, + turns right) -->90
================================
 Current Heading   = 90
 Current Direction = East
================================

1. Turn Right One Degree
2. Turn Left One Degree
3. Turn (degrees)
4. Quit

Make selection -->3

Enter degrees (- turns left, + turns right) -->90
================================
 Current Heading   = 180
 Current Direction = South
================================

1. Turn Right One Degree
2. Turn Left One Degree
3. Turn (degrees)
4. Quit

Make selection -->3

Enter degrees (- turns left, + turns right) -->-185
================================
 Current Heading   = 355
 Current Direction = North
================================

1. Turn Right One Degree
2. Turn Left One Degree
3. Turn (degrees)
4. Quit

Make selection -->4
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
