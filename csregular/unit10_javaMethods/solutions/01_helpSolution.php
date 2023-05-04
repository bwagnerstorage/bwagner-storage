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
    <h1 style="text-align:center">Help Solution</h1>
<p>Create a java file named <strong>Help.java</strong>.</p>
<h2>Create Stub Program</h2>
<p>A <strong>stub program</strong> provides the structure of a program and order of execution while
   postponing the coding details of the problem for later. Add the following stub program to the <strong>Help.java</strong> file.</p>

   <img src="/csregular/unit10_javaMethods/solutions/images/help01.png"><br>

   <p>Run the program to verify that the stub program is working as expected.</p>

<h2>Step 1 - Create Variables </h2>
<p>In this program, do not declare the variables in the main method like you have done in the past, instead place them at the top of the class, just below the class's open curly brace "{". This gives the variables <strong>class scope</strong>. Variables that have class scope, not defined inside any method, can be used in any method within the class.
</p>
  <ol id="csList">
      <li>Create a Scanner object and assign it the name <strong>keyboard</strong>.</li>
      <li>Create a variable of type <strong>double</strong> named <strong>leslieAvg</strong> and assign it a value of zero.</li>
      <li>Create 10 variables of type <strong>double </strong> named <strong>s1Avg</strong> to <strong>s10Avg</strong> and assign each of the variables a value of zero.</li>
      <li>Create a variable of type <strong>double</strong> named <strong>extraPoints</strong> and assign it a value of zero.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit10_javaMethods/solutions/images/help02.png">
  </div>

  <h2>Step 2 - Get User Input by Completing Method getAverages()</h2>
  <p>All code goes inside <strong>getAverages</strong> method.</p>
  <ol>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"Enter Leslie's Avg -->"</span></li>
      <li>Use the Scanner class's <strong>nextDouble</strong> method to allow the user
          to input a floating-point number from the keyboard and store it in the variable <strong>leslieAvg</strong>.</li>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"Student 1 average -->"<span></li>
      <li>Use the Scanner class's <strong>nextDouble</strong> method to allow the user
          to input a floating-point number from the keyboard and store it in the variable <strong>s1Avg</strong>.</li>
      <li>Repeat steps 3 and 4 for each of other 9 students.</li>
  </ol>
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit10_javaMethods/solutions/images/help03.png">
  </div>

  <h2>Step 3 - Do Processing (Perform Calculations) by Completing Method calculatePoints()</h2>
  <p>All code goes inside <strong>calculatePoints</strong> method.</p>
  <ol <ol id="csList">
  <li><p>Use the Math class's <strong>floor</strong> method with the formula provided to extract the extra points from Leslie's classmates averages. Add the extra points to the <strong>extraPoints</strong> variable using the "+=" operator.</p>
<p>Formula:</p>
<div id="csCode">
    <pre>
extraPoints += s1Avg - Math.<font color="#FF0000">floor</font>(s1Avg);
</pre>
</div>

<p>You will need to use the formula 10 times, one for each student's average.</p>
</li>
<li><p>Add the extraPoints extracted from each of Leslie's classmates to Leslie's average by using "+=" operator".</p></li>
</ol>
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit10_javaMethods/solutions/images/help04.png">
  </div>
  <h2>Step 4 - Display Output (Results of Processing) by Completing Method printResults()</h2>
  <p>All code goes inside <strong>printResults</strong> method.</p>
  <ol>
      <li><p>Display the extra points collected from the Leslie's classmate with the following label "Extra Points = ".</p></li>
      <li><p>Display Leslie's new average with the label "New Average = "</p></li>
 
  </ol>
  
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
      <img id="completedCode4" src="/csregular/unit10_javaMethods/solutions/images/help05.png" style="width:50%">
  </div>
  <h2>Sample Run Stub Program</h2>
  <div id="csSampleRun"> 
    <pre>
-----------------
   getAverages
-----------------
     
-----------------
 calculatePoints
-----------------
     
-----------------
   printResults
-----------------
   </pre>
  </div>

  <br>
</div>

<h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre style="font-size:1.4em">
-----------------
    getAverages
-----------------
     
Leslie's average -->68.2
     
Student 1 average -->98.7
Student 2 average -->95.5
Student 3 average -->87.6
Student 4 average -->78.3
Student 5 average -->91.2
Student 6 average -->85.8
Student 7 average -->75.6
Student 8 average -->99.9
Student 9 average -->78.1
Student 10 average -->83.7
     
-----------------
 calculatePoints
-----------------
     
     
-----------------
   printResults
-----------------
    
Extra Points = 5.3999999999999915
New Average = 73.6
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
