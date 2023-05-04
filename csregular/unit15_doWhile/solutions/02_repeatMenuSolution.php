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
    <h1 style="text-align:center">RepeatMenu Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>RepeatMenu.java</strong> file.</p>
<img src="/csregular/unit15_doWhile/solutions/images/repeatMenu01.JPG" style="width:750px;"><br>


<h2>Complete the method displayMenu.</h2>
  <ol>
      <li>Create a local variable named sel.</li>
      <li>Create a do_while loop that will continue as long as sel's value is not between 1 and 5 inclusive.
      <li>Display the menu inside the do_while.</li>
      <li>Use Scanner class's nextInt method to input the user's menu selection and store it in the variable sel.
      <li>Return sel.
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit15_doWhile/solutions/images/repeatMenu02.JPG">
  </div>

  <h2>Complete the method printSelection</h2>
  <ol>
      <li>Call the method displayMenu and the return value in variable named ans.</li>
      <li>Write a series of if statements that determines which number the user selected from the menu.</li>
      <li>Add code to each if statement that displays a message showing which menuItem (soft drink) the user
      selected</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit15_doWhile/solutions/images/repeatMenu03.JPG">
  </div>

 <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
    Menu
 ==========
 1.  Dr. Pepper
 2.  Coke
 3.  Sprite
 4.  7-UP
 5.  Diet Coke

Selection:6
    Menu
 ==========
 1.  Dr. Pepper
 2.  Coke
 3.  Sprite
 4.  7-UP
 5.  Diet Coke

Selection:0
    Menu
 ==========
 1.  Dr. Pepper
 2.  Coke
 3.  Sprite
 4.  7-UP
 5.  Diet Coke

Selection:9
    Menu
 ==========
 1.  Dr. Pepper
 2.  Coke
 3.  Sprite
 4.  7-UP
 5.  Diet Coke

Selection:4

You have chosen 7-UP
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
