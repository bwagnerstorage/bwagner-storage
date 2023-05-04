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
    <h1 style="text-align:center">FullName Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>FullName.java</strong> file.</p>
<img src="/csregular/unit08_string/solutions/images/fullName01.png"><br>
<h2>Step 1 - Create Variables</h2>
  <ol>
      <li>Create a Scanner object and assign it the name <strong>keyboard</strong>.</li>
      <li>Create a variable of type <strong>String</strong> named <strong>firstName</strong> and assign it the empty string "".</li>
      <li>Create a variable of type <strong>int</strong> named <strong>lastName</strong> and assign it the empty string "".</li>
      <li>Create a variable of type <strong>double</strong> named <strong>fullName</strong> and assign it the empty string "".</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit08_string/solutions/images/fullName02.png">
  </div>
  <h2>Step 2 - Get User Input</h2>
  <ol>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"Enter first name -->"</span></li>
      <li>Use the Scanner class's <strong>nextLine</strong> method to allow the user
          to input a string from the keyboard and store it in the variable <strong>firstName</strong>.</li>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"Enter last name -->"</span></li>
      <li>Use the Scanner class's <strong>nextLine</strong> method to allow the user
          to input a string from the keyboard and store it in the variable <strong>lastName</strong>.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit08_string/solutions/images/fullName03.png">
  </div>
  <h2>Step 3 - Do Processing (Perform Calculations)</h2>
  <ol>
        <li>Use the concatenation "+" operator to merge the variable <strong>lastName</strong>, a comma and a space, and the
            variable <strong>firstName</strong> together.</li>
        <li>Assign the merged string to the variable <strong>fullname</strong>.</li>  
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit08_string/solutions/images/fullName04.png">
  </div>
  <h2>Step 4 - Display Output (Results of Processing)</h2>
  <ol>
      <li>Display the <strong>fullName</strong> variable.</li>
 
  </ol>
  
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
      <img id="completedCode4" src="/csregular/unit08_string/solutions/images/fullName05.png">
  </div>
  <h2>Sample Run 1</h2>
  <div id="csSampleRun"> 
    <pre>
Enter first name--> John
Enter last name--> Wayne
        
Wayne, John
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
