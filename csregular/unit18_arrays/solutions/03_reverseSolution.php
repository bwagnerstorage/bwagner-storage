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
    <h1 style="text-align:center">Reverse Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>Reverse.java</strong> file.</p>
<img src="/csregular/unit18_arrays/solutions/images/reverse01.JPG" style="width:650px;"><br>


<h2>Define array nums.</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit18_arrays/solutions/images/reverse02.JPG">
  </div>

  <h2>Input 20 numbers and add them to the array.</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit18_arrays/solutions/images/reverse03.JPG">
  </div>

  <h2>Display contents of the array one number at a time.</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit18_arrays/solutions/images/reverse04.JPG">
  </div>

  <h2>Display contents of the array one number at a time in reverse order.</h2>

<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
    <img id="completedCode4" src="/csregular/unit18_arrays/solutions/images/reverse05.JPG">
</div>
 
  <h2>Sample Run</h2>
  <div id="csSampleRun"><pre>Num 1 --> 56
Num 2 --> 84
Num 3 --> 52
Num 4 --> 32
Num 5 --> 2
Num 6 --> 24
Num 7 --> 7
Num 8 --> 66
Num 9 --> 42
Num 10 --> 11
Num 11 --> 35
Num 12 --> 72
Num 13 --> 89
Num 14 --> 6
Num 15 --> 19
Num 16 --> 90
Num 17 --> 52
Num 18 --> 38
Num 19 --> 44
Num 20 --> 17

56 84 52 32 2 24 7 66 42 11 35 72 89 6 19 90 52 38 44 17 
17 44 38 52 90 19 6 89 72 35 11 42 66 7 24 2 32 52 84 56
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
