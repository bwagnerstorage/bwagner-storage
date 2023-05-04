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
    <h1 style="text-align:center">RepeatWords Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>RepeatWords.java</strong> file.</p>
<img src="/csregular/unit14_while/solutions/images/repeatWords01.JPG" style="width:480px;"><br>


<h2>Create three variables inside the main method.</h2>
  <ol>
      <li>Instantiate a Scanner object and store its reference a variable named keyboard.</li>
      <li>Create a String variable named word and initialize it with the empty string "".
      <li>Create a loop control variable named count and initialize it with a value of zero.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit14_while/solutions/images/repeatWords02.JPG">
  </div>

  <h2>Add a while loop to the main method that loops until the user types the words "stop" or "exit"</h2>
  <ol>
      <li>Add a user prompt before entering the while loop.</li>
      <li>Create the condition section of the while loop.</li>
      <li>Use the Scanner object to allow the user to type a word.</li>
      <li>Increment the loop control variable count by 1.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit14_while/solutions/images/repeatWords03.JPG">
  </div>

  <h2>Display the variable count below the while loop</h2>
  <ol>
      <li>Decrement the variable count by 1 so that the sentinel values "stop" and "exit" are not part of the word count.</li>
      <li>Display the count variable.</li>
      <li>Display the contents of the variable count and a blank space.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit14_while/solutions/images/repeatWords04.JPG">
  </div>

  
  
  <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
Enter words, type (stop or exit) to stop:
red
green
blue
yellow
orange
exit
You entered 5 words.
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
