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
    <h1 style="text-align:center">SlotMachine Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>SlotMachine.java</strong> file.</p>
<img src="/csregular/unit19_classDecomposition/solutions/images/slots01.JPG" style="width:650px;"><br>
<p>Add the following starter code to the <strong>PlaySlots.java</strong> file.</p>


<h2>Add instance variables and constants</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit19_classDecomposition/solutions/images/slots02.JPG" style="width:50%">
  </div>

  <h2>Add methods</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit19_classDecomposition/solutions/images/slots03.JPG" style="width:50%">
  </div>

  <h2>Method pullLever</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit19_classDecomposition/solutions/images/slots04.JPG" style="width:50%">
  </div>

  <h2>Method displayRollers</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
      <img id="completedCode4" src="/csregular/unit19_classDecomposition/solutions/images/slots05.JPG" style="width:50%"><br>
  </div>

  <h2>Method getPayOff</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode5')" id="completedCode5a">Show Code</a>
      <img id="completedCode5" src="/csregular/unit19_classDecomposition/solutions/images/slots06.JPG" style="width:50%">
  </div>

  <h2>Method displayResults</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode6')" id="completedCode6a">Show Code</a>
      <img id="completedCode6" src="/csregular/unit19_classDecomposition/solutions/images/slots07.JPG" style="width:50%">
  </div>

  <h2>Method playSlots</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode7')" id="completedCode7a">Show Code</a>
      <img id="completedCode7" src="/csregular/unit19_classDecomposition/solutions/images/slots08.JPG" style="width:50%">
  </div>
 
  <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
1. Pull Lever 2. Quit -->1
Lemon Apple Lemon

No winner. Please try again.
cash = $49

1. Pull Lever 2. Quit -->1
Orange Cherries Lemon

No winner. Please try again.
cash = $48

1. Pull Lever 2. Quit -->1
Banana Apple Lemon

No winner. Please try again.
cash = $47

1. Pull Lever 2. Quit -->1
Apple Apple Banana

No winner. Please try again.
cash = $46

1. Pull Lever 2. Quit -->1
Banana Banana Banana

************************
         Winner
************************

You won $5
cash = $50

************************

1. Pull Lever 2. Quit -->1
Apple Apple Lemon

No winner. Please try again.
cash = $49

1. Pull Lever 2. Quit -->1
Apple Banana Lemon

No winner. Please try again.
cash = $48

1. Pull Lever 2. Quit -->1
Banana Orange Apple

No winner. Please try again.
cash = $47

1. Pull Lever 2. Quit -->1
Cherries Lemon Lemon

No winner. Please try again.
cash = $46

1. Pull Lever 2. Quit -->1
Banana Cherries Banana

No winner. Please try again.
cash = $45

1. Pull Lever 2. Quit -->1
Banana Apple Banana

No winner. Please try again.
cash = $44

1. Pull Lever 2. Quit -->1
Orange Apple Orange

No winner. Please try again.
cash = $43

1. Pull Lever 2. Quit -->1
Apple Lemon Apple

No winner. Please try again.
cash = $42

1. Pull Lever 2. Quit -->1
Orange Banana Orange

No winner. Please try again.
cash = $41

1. Pull Lever 2. Quit -->1
Lemon Lemon Orange

No winner. Please try again.
cash = $40

1. Pull Lever 2. Quit -->1
Cherries Banana Banana

No winner. Please try again.
cash = $39

1. Pull Lever 2. Quit -->1
Apple Cherries Apple

No winner. Please try again.
cash = $38

1. Pull Lever 2. Quit -->1
Apple Cherries Cherries

No winner. Please try again.
cash = $37

1. Pull Lever 2. Quit -->1
Lemon Lemon Lemon

************************
         Winner
************************

You won $8
cash = $44

************************

1. Pull Lever 2. Quit -->2
Orange Cherries Banana

No winner. Please try again.
cash = $43


Thanks for playing. Come back soon
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
