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
    <h1 style="text-align:center">NonVoid1 Solution</h1>
<p>Create a java file named <strong>NonVoid1.java</strong>.</p>
<p>Copy the starter code at the top of the exercise to your source file.</p>

<h2>Step 1 - Call Method randomInt</h2>
  <p> The randomInt methods header is defined as<br>
      <div id="apCode"><pre>public int randomInt(int range)</pre></div>
      where the parameter <strong>range</strong> represents the upper bounds of a randomly generated number thats range of possible values is from 1 to <strong>range</strong>. Therefore, to create a random number in the range of 1 to 3 you need to call the method using the following code:
      <div id="apCode"><pre>app.randomInt(3)</pre></div>
      </p>
      <p>Since randomInt is a non-void method and returns a value to the location from where it was called. You need to place the call inside another Java statement, in this case, a Java println statement like shown below
      <div id="apCode"><pre>System.out.println("An integer random number in range of [1..3] = " + app.randomInt(3));</pre></div>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit13_javaMethods2/solutions/images/nonVoid1_1.png" style="width:80%">
  </div>

  <h2>Step 2 - Call Method isVowel</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit13_javaMethods2/solutions/images/nonVoid1_2.png" style="width:60%">
  </div>
 
  <h2>Step 3 - Call Method weather</h2>
  <p>This method call is different from the previous ones because the call to the method weather needs to be made at the beginning of the print statement as opposed to the end.</p>
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit13_javaMethods2/solutions/images/nonVoid1_3.png" style="width:70%">
  </div>
  <h2>Step 4 - Call Method getLetterGrade</h2>
  
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
      <img id="completedCode4" src="/csregular/unit13_javaMethods2/solutions/images/nonVoid1_4.png" style="width:60%">
  </div>

  <h2>Step 5 - Call Method isWholeNumber</h2>
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode5')" id="completedCode5a">Show Code</a>
      <img id="completedCode5" src="/csregular/unit13_javaMethods2/solutions/images/nonVoid1_5.png" style="width:80%">
  </div>

<h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre style="font-size:1.4em">
Test average method
===================
The average of 50 and 100 is 75.0
The average of 1271 and 5446 is 3358.5

Test randomInt method
=====================
An integer random number in range of [1..3] = 1
An integer random number in range of [1..50] = 22

Test isVowel method
===================
The letter e is a vowel = true
The letter k is a vowel = false
The letter A is a vowel = true

Test weather method
==========================
It's cold when the temperature is 32 degrees
It's warm when the temperature is 78 degrees

Test getLetterGrade method
==========================
A score of 75 = C
A score of 89 = B

Test isWholeNumber method
=========================
The number 100 is a whole number = true
The number -25 is a whole number = false
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
