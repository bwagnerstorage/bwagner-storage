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
    <h1 style="text-align:center">States Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>State.java</strong> file.</p>
<img src="/csregular/unit20_classesSpecial/solutions/images/State1.jpg" style="width:650px;"><br>


<h2>Add Instance Variables</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit20_classesSpecial/solutions/images/State2.jpg" style="width:50%">
  </div>

  <h2>Implement Two Constructors</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit20_classesSpecial/solutions/images/State3.jpg" style="width:50%">
  </div>

  <h2>Implement toString</h2>

<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
    <img id="completedCode3" src="/csregular/unit20_classesSpecial/solutions/images/State4.jpg" style="width:50%">
</div>

<h2>UnitedStates Class - add the starter code and then create three State objects using the appropriate constructor.</h2>
<br>
<p>Add the following code to the file <strong>UnitedStates.java</strong>.</p>
<p><Strong>Notice:</Strong> If you are using Replit the UnitedStates.java file should be renamed to Main.java and the UnitedStates class should be renamed to Main.</p>


<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
    <img id="completedCode4" src="/csregular/unit20_classesSpecial/solutions/images/State5.jpg" style="width:60%">
</div>

<h2>Call toString method for each Object</h2>

<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode5')" id="completedCode5a">Show Code</a>
    <img id="completedCode5" src="/csregular/unit20_classesSpecial/solutions/images/State6.jpg" style="width:50%">
</div>

  <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
    ****************************
  Test Default Constructor
****************************
State Name   : 
State Bird   : 
State Flower : 
State Song   : 
State Motto  : 
State Tree   : 

****************************
    Test 2nd Constructor
****************************
State Name   : Texas
State Bird   : mockingbird
State Flower : bluebonnet
State Song   : Texas, Our Texas
State Motto  : friendship
State Tree   : pecan

****************************
    Test 2nd Constructor
****************************
State Name   : Oklahoma
State Bird   : scissor-tailed flycatcher
State Flower : Oklahoma Rose
State Song   : Oklahoma
State Motto  : labor omnia vincit
State Tree   : redbud
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
