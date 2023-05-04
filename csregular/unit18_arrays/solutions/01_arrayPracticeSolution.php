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
    <h1 style="text-align:center">ArrayPractice Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>ArrayPractice.java</strong> file.</p>
<img src="/csregular/unit18_arrays/solutions/images/arrayPractice01.JPG" style="width:650px;"><br>


<h2>Method1</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit18_arrays/solutions/images/arrayPractice02.JPG">
  </div>

  <h2>Method2</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit18_arrays/solutions/images/arrayPractice03.JPG">
  </div>

  <h2>Method3</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit18_arrays/solutions/images/arrayPractice04.JPG">
  </div>

  <h2>Method4</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
      <img id="completedCode4" src="/csregular/unit18_arrays/solutions/images/arrayPractice05.JPG">
  </div>

  <h2>Method5</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode5')" id="completedCode5a">Show Code</a>
      <img id="completedCode5" src="/csregular/unit18_arrays/solutions/images/arrayPractice06.JPG">
  </div>

  <h2>Method6</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode6')" id="completedCode6a">Show Code</a>
      <img id="completedCode6" src="/csregular/unit18_arrays/solutions/images/arrayPractice07.JPG">
  </div>
 
  <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
2
4
6
8
10

2
4
6
8
10

1
3
5
7
9

1
3
5
7
9
11

3.14159
98.6
8.75
0.625

3.14159
98.6
8.75
0.625

1.2
2.3
3.4

1.2
2.3
3.4

red
white
blue
green
yellow
orange

red
white
blue
green
yellow
orange

Texas
Oklahoma
Louisiana
Arkansas
New Mexico

Texas
Oklahoma
Louisiana
Arkansas
New Mexico
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
