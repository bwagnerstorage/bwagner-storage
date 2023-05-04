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
    <h1 style="text-align:center">ExamScores Solution</h1>
<h2>Copy Starter Code from website</h2>
<p>Copy the starter code from website into the <strong>ExamScores.java</strong> file.</p>
<img src="/csregular/unit14_while/solutions/images/examScores01.JPG" style="width:750px;"><br>


<h2>Add the following code to the method inputAndTally</h2>
  <ol>
      <li>Add a user prompt telling user to enter exam scores.</li>
      <li>In the body of while loop use the scanner object to allow the user to enter an integer and store its value in the variable score.</li>
      <li>Create a loop control variable named count and initialize it with a value of zero.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit14_while/solutions/images/examScores02.JPG" style="width:750px;">
  </div>

  <h2>Add the following code to the method inputAndTally</h2>
  <ol>
      <li>Add a series to if statements inside the while loop that determine the letter grade of an input score and increment the corresponding tally variable.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit14_while/solutions/images/examScores03.JPG">
  </div>

  <h2>Complete the method getTotalScores</h2>
  <ol>
      <li>return the sum of the tally variable a, b, c, d, and f.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit14_while/solutions/images/examScores04.JPG">
  </div>

  <h2>Complete the method printSummary</h2>
  <ol>
      <li>Display a banner</li>
      <li>Display the total number of scores by calling the method getTotalScores.</li>
      <li>Display each of the variables used to store the number of a, b, c, d, and fs.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
      <img id="completedCode4" src="/csregular/unit14_while/solutions/images/examScores05.JPG" style="width:750px">
  </div>

  
  
  <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
    Enter Scores:
98
85
90
77
72
65
99
83
50
-1
============================
       Summary Report
============================
Total number of grades = 9
Number of A's = 3
Number of B's = 2
Number of C's = 2
Number of D's = 1
Number of F's = 1
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
