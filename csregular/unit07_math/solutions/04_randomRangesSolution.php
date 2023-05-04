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
    <h1 style="text-align:center">RandomRanges Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>RandomRanges.java</strong> file.</p>
<img src="/csregular/unit07_math/solutions/images/randomRanges01.png"><br>
<h2>Step 1 - Create Variables</h2>
  <ol>
      <li>Create a variable of type <strong>int</strong> named <strong>num1</strong> and assign it a value of zero.</li>
      <li>Create a variable of type <strong>int</strong> named <strong>num2</strong> and assign it a value of zero.</li>
      <li>Create a variable of type <strong>int</strong> named <strong>num3</strong> and assign it a value of zero.</li>
      <li>Create a variable of type <strong>int</strong> named <strong>num4</strong> and assign it a value of zero.</li>
      <li>Create a variable of type <strong>int</strong> named <strong>num5</strong> and assign it a value of zero.</li>
      <li>Create a variable of type <strong>int</strong> named <strong>num6</strong> and assign it a value of zero.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit07_math/solutions/images/randomRanges02.png">
  </div>
  <h2>Step 2 - Get User Input</h2>
This program does not use user input.
<br><br>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit07_math/solutions/images/randomRanges03.png">
  </div>
  <h2>Step 3 - Do Processing (Perform Calculations)</h2>
  <ol>
    <li>Use the Math class's <strong>random</strong> method to create a random number in the range of 0 to 25 inclusive 
      and store the number in the variable <strong>num1</strong>.</li>
    <li>Use the Math class's <strong>random</strong> method to create a random number in the range of 1 to 3 inclusive
      and store the number in the variable <strong>num2</strong>.</li>
    <li>Use the Math class's <strong>random</strong> method to create a random number in the range of 50 to 100 inclusive  
      and store the number in the variable <strong>num3</strong>.</li>
    <li>Use the Math class's <strong>random</strong> method to create a random number in the range of -1 to -10 inclusive
      and store the number in the variable <strong>num4</strong>.</li>
    <li>Use the Math class's <strong>random</strong> method to create a random number in the range of -100 to 100 inclusive 
      and store the number in the variable <strong>num5</strong>.</li>
    <li>Use the Math class's <strong>random</strong> method to create a random number in the range of 65 to 91 inclusive 
      and store the number in the variable <strong>num6</strong>.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit07_math/solutions/images/randomRanges04.png">
  </div>
  <h2>Step 4 - Display Output (Results of Processing)</h2>
  <ol>
    <li>Display the title "Random Ranges" using the format shown below.</li>
    <li>Display each of the random numbers on a separate line labelled like the example
        shown below.</li>
    <li>Use casting to display the random number stored in the variable <strong>num6</strong> in character format: <span style="font-family: Consolas">(char)num6</span>.
    </li>
</ol>
  
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
      <img id="completedCode4" style="width:800px;" src="/csregular/unit07_math/solutions/images/randomRanges05.png">
  </div>
  <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
Random Ranges
=============
1. Range: 0 to 25 = 3
2. Range: 1 to 3 = 3
3. Range: 50 to 100 = 52
4. Range: -1 to -10 = -4
5. Range: -100 to 100 = -37
6. Range: A to Z = W
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
