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
    <h1 style="text-align:center">doWhilePractice Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>DoWhilePractice.java</strong> file.</p>
<img src="/csregular/unit15_doWhile/solutions/images/doWhilePractice01.JPG" style="width:650px;"><br>


<h2>Create a do_while loop that counts from 0 to 20 by adding 1.</h2>
  <ol>
      <li>Create a loop control variable named count and assign and initialize it a value of zero.</li>
      
      <li>Display the contents of the variable count and a blank space.</li>
      <li>Increment the loop control variable count by 1.</li>
      <li>Add a println after the while loop to move cursor to beginning of next line.
      <li>Create the condition section of the do_while loop.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit15_doWhile/solutions/images/doWhilePractice02.JPG">
  </div>

  <h2>Create a while loop that counts from 1 to 50 by adding 1.</h2>
  <ol>
      <li>Set the value of the variable count to 1.</li>
      <li>Display the contents of the variable count and a blank space.</li>
      <li>Create the condition section of the do_while loop.</li>
      <li>Increment the loop control variable count by 2.</li>
      <li>Add a println after the do_while loop to move cursor to beginning of next line.
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit15_doWhile/solutions/images/doWhilePractice03.JPG">
  </div>

  <h2>Create a while loop that counts from 0 to 200 by adding 10.</h2>
  <ol>
      <li>Set the value of the variable count to 0.</li></li>
      <li>Display the contents of the variable count and a blank space.</li>
      <li>Increment the loop control variable count by 10.</li>
      <li>Create the condition section of the do_while loop.</li>
      <li>Add a println after the while loop to move cursor to beginning
       of next line.
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit15_doWhile/solutions/images/doWhilePractice04.JPG">
  </div>

  <h2>Create a do_while loop the letters from a to z.  The do_while loop should count from 97 to 122 by 1.</h2>
  <ol>
      <li>Set the value of the variable count to 97.</li></li>
      <li>Display the variable count cast to a char and then a blank space.</li>
      <li>Increment the loop control variable count by 1.</li>
      <li>Create the condition section of the do_while loop.</li>
      <li>Add a println after the do_while loop to move cursor to beginning of next line.
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
      <img id="completedCode4" src="/csregular/unit15_doWhile/solutions/images/doWhilePractice05.JPG">
  </div>
 
  <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 

1 3 5 7 9 11 13 15 17 19 21 23 25 27 29 31 33 35 37 39 41 43 45 47 49 

0 10 20 30 40 50 60 70 80 90 100 110 120 130 140 150 160 170 180 190 200 

a b c d e f g h i j k l m n o p q r s t u v w x y z
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
