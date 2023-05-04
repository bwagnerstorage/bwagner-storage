<?php
   session_start();
   if($_SESSION['username'] != 'CompSci_Student') 
       header("Location: index.html");
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
    <h1 style="text-align:center">Compare Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>Compare.java</strong> file.</p>
<img src="/csregular/unit12_selection/solutions/images/compare01.png" style="width:480px;"><br>
<h2>Step 1 - Create Variables</h2>
  <ol>
      <li>Create a Scanner object and assign it the name <strong>keyboard</strong>.</li>
      <li>Create a variable of type <strong>int</strong> named <strong>num1</strong> and assign it a value of 0.</li>
      <li>Create a variable of type <strong>int</strong> named <strong>num2</strong> and assign it a value of 0.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit12_selection/solutions/images/compare02.png">
  </div>
  <h2>Step 2 - Get User Input</h2>
  <li>Display a user prompt that says: <span style="font-family: Consolas">"Enter Number 1 --> "</span>.</li>
  <li>Use the Scanner class's <strong>nextInt</strong> method to allow the user
      to input a number and store it in the variable <strong>num1</strong>.</li>
   <li>Display a user prompt that says: <span style="font-family: Consolas">"Enter Number 2 --> "</span>.</li>
  <li>Use the Scanner class's <strong>nextInt</strong> method to allow the user
      to input a number and store it in the variable <strong>num2</strong>.</li>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit12_selection/solutions/images/compare03.png">
  </div>
  <h2>Step 3 - Do Processing and Output</h2>
  <ol>
    <li>Create an if statement that compares the value in the variable <strong>num1</strong> with the value of the variable in <strong>num2</strong> to determine if num1 is <strong>less than</strong> num2. If this condition is true then display the statement: <span style="color:green">(num1) is less than (num2)</span>where (num1) is the value stored in the variable num1 and (num2) is the value stored in the variable num2.</li>
    <li>Create an if statement that compares the value in the variable <strong>num1</strong> with the value of the variable in <strong>num2</strong> to determine if num1 is <strong>greater than</strong> num2. If this condition is true then display the statement: <span style="color:green">(num1) is greater than (num2)</span> where (num1) is the value stored in the variable num1 and (num2) is the value stored in the variable num2.</li>
    <li>Create an if statement that compares the value in the variable <strong>num1</strong> with the value of the variable in <strong>num2</strong> to determine if num1 is <strong>equal to</strong> num2. If this condition is true then display the statement: <span style="color:green">(num1) is equal to (num2)</span> where (num1) is the value stored in the variable num1 and (num2) is the value stored in the variable num2.</li>
    </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" style="width:560px;" src="/csregular/unit12_selection/solutions/images/compare04.png">
  </div>

  <h2>Sample Run 1</h2>
  <div id="csSampleRun"> 
    <pre>
Enter Number 1 --> 5
Enter Number 2 --> 9

5 is less than 9

   </pre>
  </div>
  <h2>Sample Run 2</h2>
  <div id="csSampleRun"> 
    <pre>
Enter Number 1 --> 12
Enter Number 2 --> 3

12 is greater than 3
   </pre>
</div>
<h2>Sample Run 2</h2>
  <div id="csSampleRun"> 
    <pre>
Enter Number 1 --> 7
Enter Number 2 --> 7

7 is equal to 7
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
