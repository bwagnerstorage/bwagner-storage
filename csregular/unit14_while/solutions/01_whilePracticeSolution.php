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
    <h1 style="text-align:center">WhilePractice Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>WhilePractice.java</strong> file.</p>
<img src="/csregular/unit14_while/solutions/images/whilePractice01.JPG" style="width:480px;"><br>


<h2>Create a while loop that counts from 1 to 25 by adding 1.</h2>
  <ol>
      <li>Create a loop control variable named count and assign and initialize it with  a value of zero.</li>
      <li>Create the condition section of the while loop.</li>
      <li>Display the contents of the variable count and a blank space.</li>
      <li>Increment the loop control variable count by 1.</li>
      <li>Add a println after the while loop to move cursor to beginning of next line.
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit14_while/solutions/images/whilePractice02.JPG">
  </div>

  <h2>Create a while loop that counts from 50 to 70 by adding 1.</h2>
  <ol>
      <li>Set the value of the variable count to 50.</li>
      <li>Create the condition section of the while loop.</li>
      <li>Display the contents of the variable count and a blank space.</li>
      <li>Increment the loop control variable count by 1.</li>
      <li>Add a println after the while loop to move cursor to beginning of next line.
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit14_while/solutions/images/whilePractice03.JPG">
  </div>

  <h2>Create a while loop that counts from 0 to 100 by adding 10.</h2>
  <ol>
      <li>Set the value of the variable count to 0.</li></li>
      <li>Create the condition section of the while loop.</li>
      <li>Display the contents of the variable count and a blank space.</li>
      <li>Increment the loop control variable count by 10.</li>
      <li>Add a println after the while loop to move cursor to beginning of next line.
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit14_while/solutions/images/whilePractice04.JPG">
  </div>

  <h2>Create a while loop that counts from 20 down to 1 by subtracting 1.</h2>
  <ol>
      <li>Set the value of the variable count to 20.</li></li>
      <li>Create the condition section of the while loop.</li>
      <li>Display the contents of the variable count and a blank space.</li>
      <li>Decrement the loop control variable count by 1.</li>
      <li>Add a println after the while loop to move cursor to beginning of next line.
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
      <img id="completedCode4" src="/csregular/unit14_while/solutions/images/whilePractice05.JPG">
  </div>

  <h2>Create a while loop that counts from 1 to 15 by adding 1.</h2>
  <ol>
      <li>Set the value of the variable count to 1.</li></li>
      <li>Create the condition section of the while loop.</li>
      <li>Display the the string "computer".</li>
      <li>Increment the loop control variable count by 1.</li>
      <li>Add a println.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode5')" id="completedCode5a">Show Code</a>
      <img id="completedCode5" src="/csregular/unit14_while/solutions/images/whilePractice06.JPG">
  </div>

  
  <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 

50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 

0 5 10 15 20 25 30 35 40 45 50 55 60 65 70 75 80 85 90 95 100 

20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 

computer
computer
computer
computer
computer
computer
computer
computer
computer
computer
computer
computer
computer
computer
computer
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
