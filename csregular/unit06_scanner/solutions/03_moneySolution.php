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
        width: 800px;
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
    <h1 style="text-align:center">Money Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>Money.java</strong> file.</p>
<img src="/csregular/unit06_scanner/solutions/images/money01.png"><br>
<h2>Step 1 - Create Variables</h2>
  <ol>
      <li>Create a Scanner object and assign it the name <strong>keyboard</strong>.</li>
      <li>Copy and paste the variables show in the green code box and add them below the
         Scanner object.
      </li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit06_scanner/solutions/images/money02.png">
  </div>
  <h2>Step 2 - Get User Input</h2>
  <ol>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"How many pennies do you have -->"</span></li>
      <li>Use the Scanner class's <strong>nextInt</strong> method to allow the user
          to input an integer value from the keyboard. Store the input value in the variable <strong>pennies</strong>.</li>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"How many nickels do you have -->"</span></li>
      <li>Use the Scanner class's <strong>nextInt</strong> method to allow the user
          to input an integer value from the keyboard. Store the input value in the variable <strong>nickels</strong>.</li>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"How many dimes do you have -->"</span></li>
      <li>Use the Scanner class's <strong>nextInt</strong> method to allow the user
          to input an integer value from the keyboard. Store the input value in the variable <strong>dimes</strong>.</li>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"How many quarters do you have -->"</span></li>
      <li>Use the Scanner class's <strong>nextInt</strong> method to allow the user
          to input an integer value from the keyboard. Store the input value in the variable <strong>quarters</strong>.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit06_scanner/solutions/images/money03.png">
  </div>
  <h2>Step 3 - Do Processing (Perform Calculations)</h2>
  <ol>
        <li>Use the following formula to calculate the total cents and store the result in the variable <strong>totalCents</strong>.<br>
          <span style="font-family: Consolas">Total Cents = Number of Quarters x 25 + Number of Dimes x 10 + Number of Nickels x 5 + Number of Pennies</span></li>
        <li>Use the following formula to determine the number of dollars from the total cents and store the
          result in the variable <strong>dollars</strong>.<br>
          <span style="font-family: Consolas">Dollars = Total Cents / 100</span></li>
        </li>
        <li>Use the following formula to determine the number of cents left over after the number of dollars are removed.            result in the variable <strong>dollars</strong>.<br>
            <span style="font-family: Consolas">Cents = Total Cents % 100</span></li>
        </li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit06_scanner/solutions/images/money04.png">
  </div>
  <h2>Step 4 - Display Output (Results of Processing)</h2>
  <ol>
      <li>Display the values of the variables <strong>dollars</strong> and <strong>cents</strong> in the
          format shown below.<br>
      <span style="font-family: Consolas">Total value = 2 dollars and 46 cents</span>
       </li>
  </ol>
  
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
      <img id="completedCode4" src="/csregular/unit06_scanner/solutions/images/money05.png">
  </div>
  <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
How many pennies do you have --> 6
How many nickels do you have --> 3
How many dimes do you have --> 10
How many quarters do you have --> 5
        
Total value = 2 dollars and 46 cents
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
