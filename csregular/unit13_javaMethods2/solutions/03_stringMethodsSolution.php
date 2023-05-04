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
    <h1 style="text-align:center">StringMethods Solution</h1>
<p>Create a java file named <strong>StringMethods.java</strong>.</p>
<p>Add the starter code at the top of the exercise to your source file.</p>


<h2>Step 1 - Complete the Method greeting</h2>
<p>The greeting method is actually a void method. It was placed here as a review. Since greeting is
   a void method and does not return a value, you are simply going to combine the parameter name with the phrase " have a nice day." in a println statement.
</p>

<div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit13_javaMethods2/solutions/images/stringMethods_1.png" style="width:60%">
</div>

  <h2>Step 2 - Complete the Method firstLetter</h2>
  <p></p>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit13_javaMethods2/solutions/images/stringMethods_2.png" style="width:45%">
</div>

  <h2>Step 3 - Complete the Method merge</h2>
  <p></p>

<div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit13_javaMethods2/solutions/images/stringMethods_3.png" style="width:70%">
</div>
  <h2>Step 4 - Complete the Method repeatFirst</h2>
  <p></p>
  
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
      <img id="completedCode4" src="/csregular/unit13_javaMethods2/solutions/images/stringMethods_4.png" style="width:75%">
</div>

<h2>Step 5 - Complete the Method sameLength</h2>
  <p></p>
  
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode5')" id="completedCode5a">Show Code</a>
      <img id="completedCode5" src="/csregular/unit13_javaMethods2/solutions/images/stringMethods_5.png" style="width:60%">
</div>

<h2>Sample Run</h2>
<div id="csSampleRun">
<pre>
Test greeting method
====================
John have a nice day!
Sarah have a nice day!

Test firstLetter method
=======================
The first letter of honor is h
The first letter of courage is c

Test merge method
=================
The merge of faith, hope, love is faithhopelove
The merge of forgiveness, compassion, mercy is forgivenesscompassionmercy

Test repeatFirst method
=======================
Repeat first letter of sacrifice is sss
Repeat first letter of commitment is ccc

Test sameLength method
======================
Charity and selfless are same length - false
Liberty and freedom are same length - true
</pre>

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
