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
    <h1 style="text-align:center">Triangle Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>Triangle.java</strong> file.</p>
<img src="/csregular/unit12_selection/solutions/images/triangle01.png" style="width:480px;"><br>
<h2>Step 1 - Create Variables</h2>
  <ol>
      <li>Create a Scanner object and assign it the name <strong>keyboard</strong>.</li>
      <li>Create a variable of type <strong>int</strong> named <strong>side1</strong> and assign it a value of 0.</li> 
      <li>Create a variable of type <strong>int</strong> named <strong>side2</strong> and assign it a value of 0.</li>
      <li>Create a variable of type <strong>int</strong> named <strong>side3</strong> and assign it a value of 0.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit12_selection/solutions/images/triangle02.png">
  </div>
  <h2>Step 2 - Get User Input</h2>
  <li>Display a user prompt that says: <span style="font-family: Consolas">"Enter Side 1 --> "</span>.</li>
  <li>Use the Scanner class's <strong>nextInt</strong> method to allow the user
      to input a number and store it in the variable <strong>side1</strong>.</li>
   <li>Display a user prompt that says: <span style="font-family: Consolas">"Enter Side 2 --> "</span>.</li>
  <li>Use the Scanner class's <strong>nextInt</strong> method to allow the user
      to input a number and store it in the variable <strong>side2</strong>.</li>
   <li>Display a user prompt that says: <span style="font-family: Consolas">"Enter Side 3 --> "</span>.</li>
  <li>Use the Scanner class's <strong>nextInt</strong> method to allow the user
      to input a number and store it in the variable <strong>side3</strong>.</li>


  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit12_selection/solutions/images/triangle03.png">
  </div>
  <h2>Step 3 - Do Processing and Output</h2>
  <ol id="csList">
      <li>Add an if statement that has a compound condition that compares side1 to side2 and side1 to side3 to determine if both pairings are equal. If the condition is true, then output the phrase "The triangle is an equilateral".</li>
      <li>Add an if statement that has a compound condition that compares side1 to side2 or side1 to side3 or side2 to side3 to determine if one of the pairing is equal. If the condition is true, then output the phrase "The triangle is an isosceles".</li>
      <li>Add an if statement that has a compound condition that compares side1 to side2 and side1 to side3 and side1 to side3 to determine if all three pairings are not equal. If the the condition is true, then</li>
      <li> output the phrase "The triangle is a scalene".</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" style="width:650px;" src="/csregular/unit12_selection/solutions/images/triangle04_1.png">
  </div>

  <h2>Step 3 - Alternate Solution</h2>
  <ol id="csList">
      <li>Add an if/else statement that has a compound condition that compares side1 to side2 and side1 to side3 to determine if both pairings are equal. If the condition is true, then output the phrase "The triangle is an equilateral". If the condition is false, then</li> 
      <li>Add an another if/else statement that has a compound condition that compares side1 to side2 and side1 to side3 and side1 to side3 to determine if all three pairings are not equal. If the condition is true, then output the phrase "The triangle is a scalene". If the condition is false, then</li>
      <li>output the phrase "The triangle is an isosceles".</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
      <img id="completedCode4" style="width:650px;" src="/csregular/unit12_selection/solutions/images/triangle04_2.png">
  </div>

  <h2>Sample Run 1</h2>
  <div id="csSampleRun"> 
    <pre>
Enter side 1 -->5
Enter side 2 -->5
Enter side 3 -->5

This triangle is an equilateral
   </pre>
  </div>
  <h2>Sample Run 2</h2>
  <div id="csSampleRun"> 
    <pre>
Enter side 1 -->2
Enter side 2 -->1
Enter side 3 -->2

This triangle is a isosceles
   </pre>
</div>
<h2>Sample Run 3</h2>
  <div id="csSampleRun"> 
    <pre>
Enter side 1 -->1
Enter side 2 -->2
Enter side 3 -->3

This triangle is an scalene
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
