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
        width: 600px;
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
    <h1 style="text-align:center">VerticalString Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>VerticalString.java</strong> file.</p>
<img src="/csregular/unit16_for/solutions/images/verticalString01.JPG" style="width:750px;"><br>


<h2>Add two local variables to the main method</h2>
  <ol>
      <li>Create a Scanner object and store its reference in a variable named keyboard.</li>
      <li>Create a variable of type String named str and assign it the empty string "".
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit16_for/solutions/images/verticalString02.JPG">
  </div>

  <h2>Prompt the user to enter a string</h2>
  <ol>
      <li>Use System.out.print to create a user prompt that says "Enter a string -->".</li>
      <li>Use the Scanner class's nextLine method to read the string typed by the user and store
          it in the variable str.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit16_for/solutions/images/verticalString03.JPG">
  </div>

  <h2>Create a for loop that counts from 0 to str.length-1</h2>
  <ol>
      <li>Create a for loop that counts from 0 to str.length-1.</li>
      <li>Display each character in the input string using the String class's substring method.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit16_for/solutions/images/verticalString04.JPG">
  </div>

 <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
Enter a string -->Airplane
A
i
r
p
l
a
n
e
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
