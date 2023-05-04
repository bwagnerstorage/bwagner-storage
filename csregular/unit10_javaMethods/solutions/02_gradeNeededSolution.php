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
    <h1 style="text-align:center">GradeNeeded Solution</h1>
<p>Create a java file named <strong>gradeNeeded.java</strong>.</p>
<h2>Create Stub Program</h2>
<p>A <strong>stub program</strong> provides the structure of a program and order of execution while
   postponing the coding details of the problem for later. Add the following stub program to the <strong>GradeNeeded.java</strong> file.</p>

   <img src="/csregular/unit10_javaMethods/solutions/images/gradeNeeded01.png" style="width:40%"><br>

   <p>Run the program to verify that the stub program is working as expected.</p>

<h2>Step 1 - Create Variables </h2>
<p>All variables should have class scope. Since these are instance variables they do not need to be initialized.</p>
  <ol id="csList">
      <li>Create a Scanner object and assign it the name <strong>keyboard</strong>.</li>
      <li>Create a variable of type <strong>int</strong> named <strong>semesterAvgGoal</strong>.</li>
      <li>Create 3 variables of type <strong>int </strong> named <strong>sixWeeks1</strong>, <strong>sixWeeks2</strong>, and <strong>sixWeeks3</strong>.</li>
      <li>Create a variable of type <strong>double</strong> named <strong>gradeNeeded</strong>.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit10_javaMethods/solutions/images/gradeNeeded02.png" style="width:50%">
  </div>

  <h2>Step 2 - Get User Input by Completing Method getData()</h2>
  <p>All code goes inside <strong>getData</strong> method.</p>
  <ol>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"Enter desired semester average -->"</span></li>
      <li>Use the Scanner class's <strong>nextInt</strong> method to allow the user
          to input an integer from the keyboard and store it in the variable <strong>semesterAvgGoal</strong>.</li>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"Enter 1st six weeks average -->"<span></li>
      <li>Use the Scanner class's <strong>nextInt</strong> method to allow the user
          to input an integer from the keyboard and store it in the variable <strong>sixWeeks1</strong>.</li>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"Enter 2nd six weeks average -->"<span></li>
      <li>Use the Scanner class's <strong>nextInt</strong> method to allow the user
          to input an integer from the keyboard and store it in the variable <strong>sixWeeks2</strong>.</li>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"Enter 3rd six weeks average -->"<span></li>
      <li>Use the Scanner class's <strong>nextInt</strong> method to allow the user
          to input an integer from the keyboard and store it in the variable <strong>sixWeeks3</strong>.</li>
  </ol>
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" style="width:45%" src="/csregular/unit10_javaMethods/solutions/images/gradeNeeded03.png">
  </div>

  <h2>Step 3 - Do Processing (Perform Calculations) by Completing Method calculateGradeNeeded()</h2>
  <p>All code goes inside <strong>calculateGradeNeeded</strong> method.</p>
  <ol <ol id="csList">
  <li><p>Use the formula provided to calculate the grade needed in order to achieve the desired semester average.</p>
<p>Formula:</p>
<div id="csCode">
    <pre>
gradeNeeded = (semesterAvgGoal - (0.8 * (sixWeeks1 + sixWeeks2 + sixWeeks3) / 3)) / 0.2
</pre>
</div>
</li>
</ol>
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" style="width:75%" src="/csregular/unit10_javaMethods/solutions/images/gradeNeeded04.png">
  </div>
  <h2>Step 4 - Display Output (Results of Processing) by Completing Method printResults()</h2>
  <p>All code goes inside <strong>printResults</strong> method.</p>
  <ol>
      <li><p>Display the Semester Grade you would like to achieve with the label
       "Semester Average Goal = ".</p></li>
      <li><p>Display the grade needed to achieve your goal with the label
         "Grade Needed to Achieve Goal = ".</p></li>
 
  </ol>
  
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
      <img id="completedCode4" src="/csregular/unit10_javaMethods/solutions/images/gradeNeeded05.png" style="width:60%">
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
