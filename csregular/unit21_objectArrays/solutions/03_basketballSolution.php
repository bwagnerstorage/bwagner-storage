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
    <h1 style="text-align:center">Basketball Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>Player.java</strong> file.</p>
<img src="/csregular/unit21_objectArrays/solutions/images/basketball01.jpg" style="width:550px;"><br>


<h2>Add Instance Variables</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit21_objectArrays/solutions/images/basketball02.jpg">
  </div>

  <h2>Implement Constructor</h2>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit21_objectArrays/solutions/images/basketball03.jpg">
  </div>

  <h2>Implement Accessor Methods</h2>

<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
    <img id="completedCode3" src="/csregular/unit21_objectArrays/solutions/images/basketball04.jpg">
</div>

<h2>Implement Other Methods</h2>

<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
    <img id="completedCode4" src="/csregular/unit21_objectArrays/solutions/images/basketball05.jpg">
</div>

<h2>Team Class</h2>
<p>Add the following starter code to the <strong>Team.java</strong> file.</p>
<img src="/csregular/unit21_objectArrays/solutions/images/basketball06.jpg" style="width:550px;"><br>

<h2>Add Instance Variables</h2>
<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode5')" id="completedCode5a">Show Code</a>
    <img id="completedCode5" src="/csregular/unit21_objectArrays/solutions/images/basketball07.jpg" style="width:50%">
</div>

<h2>Implement Constructors</h2>
<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode6')" id="completedCode6a">Show Code</a>
    <img id="completedCode6" src="/csregular/unit21_objectArrays/solutions/images/basketball08.jpg" style="width:50%">
</div>

<h2>Implement addPlayers Method</h2>
<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode7')" id="completedCode7a">Show Code</a>
    <img id="completedCode7" src="/csregular/unit21_objectArrays/solutions/images/basketball09.jpg" style="width:50%">
</div>

<h2>Implement printPlayers Method</h2>
<div class="solutionContainer">
    <a href="#!" onclick="makeVisible('completedCode8')" id="completedCode8a">Show Code</a>
    <img id="completedCode8" src="/csregular/unit21_objectArrays/solutions/images/basketball10.jpg" style="width:50%">
</div>

  <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
Enter player name-->Michael Jordan
Enter free throws made -->5
Enter free throws attempted -->6
Enter 2 pt field goals made -->12
Enter 2 pt field goals attempted -->24
Enter 3 pt fields goals made --3
Enter 3 pt field goals attempted -->4

Enter another player [y/n]:y

Enter player name-->Magic Johnson
Enter free throws made -->1
Enter free throws attempted -->3
Enter 2 pt field goals made -->8
Enter 2 pt field goals attempted -->10
Enter 3 pt fields goals made --1
Enter 3 pt field goals attempted -->1

Enter another player [y/n]:y

Enter player name-->Dirk Nowitzki
Enter free throws made -->10
Enter free throws attempted -->10
Enter 2 pt field goals made -->15
Enter 2 pt field goals attempted -->28
Enter 3 pt fields goals made --4
Enter 3 pt field goals attempted -->5

Enter another player [y/n]:n

************************
*     printPlayers     *
************************
Name = Michael Jordan
Free Throws % = 83.33333333333334
2 pt Field Goal % = 50.0
3 pt Field Goal % = 75.0
Total Points Scored = 38

Name = Magic Johnson
Free Throws % = 33.33333333333333
2 pt Field Goal % = 80.0
3 pt Field Goal % = 100.0
Total Points Scored = 20

Name = Dirk Nowitzki
Free Throws % = 100.0
2 pt Field Goal % = 53.57142857142857
3 pt Field Goal % = 80.0
Total Points Scored = 52
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
