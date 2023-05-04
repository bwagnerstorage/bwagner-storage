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
    <h1 style="text-align:center">MadLib Solution</h1>
<h2>Add Starter Code</h2>
<p>Add the following starter code to the <strong>MadLib.java</strong> file.</p>
<img src="/csregular/unit08_string/solutions/images/madlib01.png"><br>
<h2>Step 1 - Create Variables</h2>
  <ol>
      <li>Create a Scanner object and assign it the name <strong>keyboard</strong>.</li>
      <li>Create 12 variables of type <strong>String</strong> named <strong>s1 - s12</strong> and assign each variable the empty string "".</li>
</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit08_string/solutions/images/madlib02.png">
  </div>
  <h2>Step 2 - Get User Input</h2>
  <ol>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"[1] Enter a NOUN -->"</span></li>
      <li>Use the Scanner class's <strong>nextLine</strong> method to allow the user
          to input a string from the keyboard and store the input value in the variable <strong>s1</strong>.</li>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"[2] Enter a type of VEHICLE -->"</span></li>
      <li>Use the Scanner class's <strong>nextLine</strong> method to allow the user
          to input a string from the keyboard and store the input value in the variable <strong>s2</strong>.</li>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"[3] Enter an ADJECTIVE -->"</span></li>
      <li>Use the Scanner class's <strong>nextLine</strong> method to allow the user
          to input a string from the keyboard and store the input value in the variable <strong>s3</strong>.</li>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"[4] Enter an ADJECTIVE -->"</span></li>
      <li>Use the Scanner class's <strong>nextLine</strong> method to allow the user
          to input a string from the keyboard and store the input value in the variable <strong>s4</strong>.</li>  
      <li>Display a user prompt that says: <span style="font-family: Consolas">"[5] Enter a NOUN -->"</span></li>
      <li>Use the Scanner class's <strong>nextLine</strong> method to allow the user
          to input a string from the keyboard and store the input value in the variable <strong>s5</strong>.</li>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"[6] Enter a NOUN -->"</span></li>
      <li>Use the Scanner class's <strong>nextLine</strong> method to allow the user
          to input a string from the keyboard and store the input value in the variable <strong>s6</strong>.</li>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"[7] Enter an ADJECTIVE -->"</span></li>
      <li>Use the Scanner class's <strong>nextLine</strong> method to allow the user
          to input a string from the keyboard and store the input value in the variable <strong>s7</strong>.</li>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"[8] Enter a VERB ending in 'ed' -->"</span></li>
      <li>Use the Scanner class's <strong>nextLine</strong> method to allow the user
          to input a string from the keyboard and store the input value in the variable <strong>s8</strong>.</li>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"[9] Enter a NOUN -->"</span></li>
      <li>Use the Scanner class's <strong>nextLine</strong> method to allow the user
          to input a string from the keyboard and store the input value in the variable <strong>s9</strong>.</li>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"[10] Enter a NOUN -->"</span></li>
      <li>Use the Scanner class's <strong>nextLine</strong> method to allow the user
          to input a string from the keyboard and store the input value in the variable <strong>s10</strong>.</li>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"[11] Enter a NOUN -->"</span></li>
      <li>Use the Scanner class's <strong>nextLine</strong> method to allow the user
          to input a string from the keyboard and store the input value in the variable <strong>s11</strong>.</li>
      <li>Display a user prompt that says: <span style="font-family: Consolas">"[12] Enter a NOUN -->"</span></li>
      <li>Use the Scanner class's <strong>nextLine</strong> method to allow the user
         to input a string from the keyboard and store the input value in the variable <strong>s12</strong>.</li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit08_string/solutions/images/madlib03.png">
  </div>
  <h2>Step 3 - Do Processing (Perform Calculations)</h2>
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit08_string/solutions/images/madlib04.png">
  </div>
  <h2>Step 4 - Display Output (Results of Processing)</h2>
  <div id="csCode" style="width: 680px">
      <pre>
System.out.println("Just sit right back and you`ll hear a tale,");
System.out.println("A tale of a fateful [1],");
System.out.println("That started from this tropic port,");
System.out.println("Aboard this tiny [2].");
System.out.println();
System.out.println("The mate was a [3] sailor man,");
System.out.println("The skipper [4] and sure.");
System.out.println("Five [5] set sail that day,");
System.out.println("For a three hour [6], a three hour [6].");
System.out.println();
System.out.println("The weather started getting [7],");
System.out.println("The tiny [2] was [8],");
System.out.println("If not for the [9] of the fearless crew,");
System.out.println("The [10] would be lost, the [10] would be lost.");
System.out.println();
System.out.println("The [2] set ground on the shore of this uncharted desert isle,");
System.out.println("With Gilligan, The Skipper too,");
System.out.println("The millionaire and his [11] , The movie [12],"); 
System.out.println("And The Rest, Here on Gilligan`s Isle.");
</pre>
</div>

<p>Replace each placeholder, such as [1], with its corresponding variable <strong>s1</strong>.
Add additional quotes where necessary.</p>
      
  
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
      <img id="completedCode4" style= "width:1000px" src="/csregular/unit08_string/solutions/images/madlib05.png">
  </div>
  <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
[1] Enter a NOUN --> toothbrush
[2] Enter a type of VEHICLE --> skateboard
[3] Enter an ADJECTIVE --> scary
[4] Enter an ADJECTIVE --> large
[5] Enter a NOUN --> polish sausages
[6] Enter a NOUN --> adventure
[7] Enter an ADJECTIVE -->immense
[8] Enter a VERB ending in 'ed' --> scared
[9] Enter a NOUN --> monkey
[10] Enter a NOUN --> elephant
[11] Enter a NOUN --> guitar 
[12] Enter a NOUN --> trash can 
         
      GILLIGAN`S ISLAND THEME
        
Just sit right back and you`ll hear a tale,
A tale of a fateful toothbrush,
That started from this tropic port,
Aboard this tiny skateboard.
        
The mate was a scary sailor man,
The skipper large and sure.
Five polish sausages set sail that day,
For a 3 hour adventure, a 3 hour adventure.
        
The weather started getting immense,
The tiny skateboard was scared,
If not for the monkey of the fearless crew,
The elephant would be lost, the elephant would be lost.
        
The skateboard set ground on the shore of this uncharted desert isle,
With Gilligan, The Skipper too,
The millionaire and his guitar, The movie trash can, 
And The Rest, Here on Gilligan`s Isle.
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
