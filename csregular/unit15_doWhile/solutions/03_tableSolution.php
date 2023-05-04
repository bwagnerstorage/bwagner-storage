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
    <h1 style="text-align:center">Table Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>Table.java</strong> file.</p>
<img src="/csregular/unit15_doWhile/solutions/images/table01.JPG" style="width:750px;"><br>


<h2>Complete the method inputNumRows.</h2>
  <ol>
      <li>Add a user prompt that asks the user to enter the number of rows to be displayed in the table.</li>
      <li>Use Scanner class's nextInt method to allow the user to input their response to the prompt and store it in a local variable named num.
      <li>Return num.
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit15_doWhile/solutions/images/table02.JPG">
  </div>

  <h2>Complete the method displayTable</h2>
  <ol>
      <li>Create a local variable named n and assign it a value of 1.</li>
      <li>Display the table's header.</li>
      <li>Create a do_while loop that counts from 1 up to the value of the parameter rows.</li>
      <li>Display the variable n, n times 10, n times 100, and n times 1000.
      <li>increment n by 1.
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit15_doWhile/solutions/images/table03.JPG">
  </div>

 <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
Enter number of rows -->8

N  10*N   100*N   1000*N
-------------------------
1   10     100     1000
2   20     200     2000
3   30     300     3000
4   40     400     4000
5   50     500     5000
6   60     600     6000
7   70     700     7000
8   80     800     8000
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
