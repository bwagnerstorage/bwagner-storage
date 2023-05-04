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

      #completedCode9 {
        display: none;
      }

      #completedCode10 {
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
    <h1 style="text-align:center">MyRectangle Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>MyRectangle.java</strong> file.</p>
<img src="/csregular/unit20_classesSpecial/solutions/images/rectangle1.jpg" style="width:650px;"><br>



<h2>Add Instance Variables</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit20_classesSpecial/solutions/images/rectangle2.jpg" style="width:50%">
  </div>

  <h2>Implement a Constructor</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit20_classesSpecial/solutions/images/rectangle3.jpg" style="width:50%">
  </div>

  <h2>Implement Accessor Methods</h2>

<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
    <img id="completedCode3" src="/csregular/unit20_classesSpecial/solutions/images/rectangle4.jpg" style="width:50%">
</div>

<h2>Add Mutator Methods</h2>

<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
    <img id="completedCode4" src="/csregular/unit20_classesSpecial/solutions/images/rectangle5.jpg" style="width:50%">
</div>

<h2>Implement getPerimeter and getArea Methods</h2>

<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode5')" id="completedCode5a">Show Code</a>
    <img id="completedCode5" src="/csregular/unit20_classesSpecial/solutions/images/rectangle6.jpg" style="width:50%">
</div>

<h2>Implement toString Method</h2>

<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode6')" id="completedCode6a">Show Code</a>
    <img id="completedCode6" src="/csregular/unit20_classesSpecial/solutions/images/rectangle7.jpg" style="width:50%">
</div>

<h2>Rectangle Manager Class</h2>

<p>Add the following starter code to the file <strong>RectangleManager.java</strong>.</p>

    <img id="completedCode7_1" src="/csregular/unit20_classesSpecial/solutions/images/rectangle8a.jpg" style="width:60%"><br>
    <img id="completedCode7_2" src="/csregular/unit20_classesSpecial/solutions/images/rectangle8b.jpg" style="width:60%"><br>


<h2>inputDimensions Method</h2>

<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode8')" id="completedCode8a">Show Code</a>
    <img id="completedCode8" src="/csregular/unit20_classesSpecial/solutions/images/rectangle9.jpg" style="width:50%">
</div>

<h2>changeDimensions Method</h2>

<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode9')" id="completedCode9a">Show Code</a>
    <img id="completedCode9" src="/csregular/unit20_classesSpecial/solutions/images/rectangle10.jpg" style="width:50%">
</div>

<h2>print Method</h2>

<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode10')" id="completedCode10a">Show Code</a>
    <img id="completedCode10" src="/csregular/unit20_classesSpecial/solutions/images/rectangle11.jpg" style="width:50%">
</div>



  <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
    *************************************
  Test Constructor and Input Method
*************************************
Enter length -->10
Enter width -->20

Length = 10
Width  = 20
Perimeter = 60
Area = 200

************************
  Test Mutator Method
************************

Enter new length -->5
Enter new width -->7

Length = 5
Width  = 7
Perimeter = 24
Area = 35
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
