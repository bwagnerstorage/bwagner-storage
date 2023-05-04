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
        width: 600px;
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
    <h1 style="text-align:center">Largest Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>Table.java</strong> file.</p>
<img src="/csregular/unit15_doWhile/solutions/images/largest01.JPG" style="width:750px;"><br>


<h2>Complete the method compare.</h2>
  <ol>
      <li>Add an if/else state that compares the two parameters num1 and num2. If num1 is greater than num2 then its value is returned; otherwise num2's value is returned.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit15_doWhile/solutions/images/largest02.JPG">
  </div>

  <h2>Complete the method findLargest</h2>
  <ol>
      <li>Add a user prompt that instructs the user to enter 10 numbers.</li>
      <li>Create a local variable named count and assign it a value of zero.</li>
      <li>Create a do_while loop that loops 10 times.</li>
      <li>Use the Scanner class's nextInt method to read a integer value from the keyboard.</li>
      <li>Call the compare method using the value of the variable largest and the number just entered 
          from the keyboard. Store the return value of the compare method in the variable largest.</li>
      <li>Increment the variable count by 1.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit15_doWhile/solutions/images/largest03.JPG">
  </div>

  <h2>Complete the method printLargest</h2>
  <ol>
      <li>Display the value contained in the variable largest.</li>
      <li>For spacing, add a println statement before and after the displaying of largest.

  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit15_doWhile/solutions/images/largest04.JPG">
  </div>

 <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
Enter 10 numbers
5
12
65
28
9
44
62
99
17
1

The Largest number is 99
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
