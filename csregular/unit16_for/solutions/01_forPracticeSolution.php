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
    <h1 style="text-align:center">forPractice Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>ForPractice.java</strong> file.</p>
<img src="/csregular/unit16_for/solutions/images/forPractice01.JPG" style="width:650px;"><br>


<h2>Create a for loop that counts from 0 to 25 by adding 1</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit16_for/solutions/images/forPractice02.JPG">
  </div>

  <h2>Create a for loop that counts down from 10 to 1 by subtracting 1</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit16_for/solutions/images/forPractice03.JPG">
  </div>

  <h2>Create a for loop that counts from 1 to 40 by adding 2</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit16_for/solutions/images/forPractice04.JPG">
  </div>

  <h2>Create a for loop that counts from 0 to 40 by adding 2</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
      <img id="completedCode4" src="/csregular/unit16_for/solutions/images/forPractice05.JPG">
  </div>

  <h2>Create a for loop that counts from 0 to 200 by adding 10</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode5')" id="completedCode5a">Show Code</a>
      <img id="completedCode5" src="/csregular/unit16_for/solutions/images/forPractice06.JPG">
  </div>

  <h2>Create a for loop that counts down from -10 to -20 by subtracting 1</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode6')" id="completedCode6a">Show Code</a>
      <img id="completedCode6" src="/csregular/unit16_for/solutions/images/forPractice07.JPG">
  </div>

  <h2>Create a for loop that counts from 1 to 10 by adding 1</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode7')" id="completedCode7a">Show Code</a>
      <img id="completedCode7" src="/csregular/unit16_for/solutions/images/forPractice08.JPG">
  </div>
 
  <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
10 9 8 7 6 5 4 3 2 1 

1 3 5 7 9 11 13 15 17 19 21 23 25 27 29 31 33 35 37 39 

2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 

0 10 20 30 40 50 60 70 80 90 100 110 120 130 140 150 160 170 180 190 200 

-10 -11 -12 -13 -14 -15 -16 -17 -18 -19 -20 

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
