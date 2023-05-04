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
    <h1 style="text-align:center">Powers Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>Powers.java</strong> file.</p>
<img src="/csregular/unit06_scanner/solutions/images/powers01.png"><br>
<h2>Step 1 - Create Variables</h2>
  <ol>
      <li>Create a Scanner object and assign it the name <strong>keyboard</strong>.</li>
      <li>Create a variable of type <strong>int</strong> named <strong>num</strong> and assign it a value of zero.</li>
      <li>Create a variable of type <strong>int</strong> named <strong>square</strong> and assign it a value of zero.</li>
      <li>Create a variable of type <strong>int</strong> named <strong>cube</strong> and assign it a value of zero.</li>
      <li>Create a variable of type <strong>int</strong> named <strong>power4</strong> and assign it a value of zero.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit06_scanner/solutions/images/powers02.png">
  </div>
  <h2>Step 2 - Get User Input</h2>
  <ol>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"Enter an integer -->"</span></li>
      <li>Use the Scanner class's <strong>nextInt</strong> method to allow the user
          to input an integer value from the keyboard.</li>
      <li>Store the input value in the variable <strong>num</strong>.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit06_scanner/solutions/images/powers03.png">
  </div>
  <h2>Step 3 - Do Processing (Perform Calculations)</h2>
  <ol>
        <li>Calculate the square of the value stored in the variable <strong>num</strong> by
         multiplying num times itself (num * num). Store the result of the calculation in the variable 
        <strong>square</strong>.</li>
        <li>Calculate the cube of the value stored in the variable <strong>num</strong> by
          multiplying num times itself 3 times (num * num * num). Store the result of the calculation in the variable 
         <strong>cube</strong>.</li>
         <li>Calculate the fourth power of the value stored in the variable <strong>num</strong> by
          multiplying num times cube (num * cube). Store the result of the calculation in the variable 
         <strong>power4</strong>.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit06_scanner/solutions/images/powers04.png">
  </div>
  <h2>Step 4 - Display Output (Results of Processing)</h2>
  <ol>
      <li>Display the value stored in the variable <strong>square</strong>. Include the following label at the
          beginning of the output: "The Square = ".</li>
      <li>Display the value stored in the variable <strong>cube</strong>. Include the following label at the
          beginning of the output: "The Cube = ".</li>
      <li>Display the value stored in the variable <strong>power4</strong>. Include the following label at the
          beginning of the output: "The Fourth Power = ".</li>
  </ol>
  
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
      <img id="completedCode4" src="/csregular/unit06_scanner/solutions/images/powers05.png">
  </div>
  <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
Please enter an integer--> 2
 
The Square = 4
The Cube = 8
The Fourth Power = 16
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
