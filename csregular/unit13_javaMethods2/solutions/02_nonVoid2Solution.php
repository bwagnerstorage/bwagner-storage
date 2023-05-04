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
    <h1 style="text-align:center">NonVoid2 Solution</h1>
    <p>Create a java file named <strong>NonVoid2.java</strong>.</p>
    <p>Add the starter code at the top of the exercise to your source file.</p>

<h2>Step 1 - Complete the Method square</h2>
  <ol id="csList">
      <li>A square is the result of multiplying an integer by itself.<br>
          For example, the square of 4 is equivalent to 4 * 4.
      </li>
      <li>The header for the square method is <br>
      <div id="apCode"><pre>public int square(int num)</pre></div>
      The variable, num, in the parentheses is called a <strong>parameter</strong>. 
      Its value is the integer that the method is squaring. The squaring calculation can be done on the return line for the method like the following<br>
      <div id="apCode"><pre>return num * num;</pre></div></li>
  </ol>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit13_javaMethods2/solutions/images/nonVoid2_1.png" style="width:40%">
  </div>

  <h2>Step 2 - Complete the Method sumThree</h2>
  <p></p>
  <ol>
     <p>To calculate the sum of the three parameters num1, num2, num3 simply add them together on a return line.
  </ol>
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit13_javaMethods2/solutions/images/nonVoid2_2.png" style="width:60%">
  </div>

  <h2>Step 3 - Complete the Method smaller</h2>
   <p>To determine which of the two parameters, num1 and num2, contains the smaller value, use an if statement. If the num1 is less than num2 then return num1, otherwise return num2.
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id = "completedCode3" src="/csregular/unit13_javaMethods2/solutions/images/nonVoid2_3.png" style="width:50%">
  </div>
  <h2>Step 4 - Complete the Method fortuneCookie</h2>
  <p>The local variable, num, can only contain the values 1, 2, 3, or 4. Use a series of four if statements to compare the variable num to with each of the these values. If num is equal to 1 then return the phrase "Your future looks bright". If num is equal to 2  then return the phrase "I see love in your future", and so forth. Actually you need to remove the last if statement leaving only the return line with the phrase "Happiness you will have", otherwise you will get a syntax error.</p>

  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
      <img id = "completedCode4" src="/csregular/unit13_javaMethods2/solutions/images/nonVoid2_4.png" style="width:50%">
  </div>

  <h2>Step 5 - Complete the Method season</h2>
  <p>Use the parameter month in a series of compound if statements to determine if its value is between  1 and 3 inclusive, 4 and 6 inclusive, 7 and 9 inclusive, or 10 and 12 inclusive. If the value of month is between 1 and 3 return the string "winter", if it is between 4 and 6 return the string "spring", if it is between 7 and 9 return the string summer, otherwise return the string "fall".</p>
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode5')" id="completedCode5a">Show Code</a>
      <img id = "completedCode5" src="/csregular/unit13_javaMethods2/solutions/images/nonVoid2_5.png" style="width:40%">
  </div>

  <h2>Step 6 - Complete the Method oddEven</h2>
  <p>To determine if a number is odd or even divide the number by 2. If the remainder is 0 then the number is even, otherwise it is odd. To determine the remainder use the modulus operator "%".</p>
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode6')" id="completedCode6a">Show Code</a>
      <img id = "completedCode6" src="/csregular/unit13_javaMethods2/solutions/images/nonVoid2_6.png" style="width:40%">
  </div>

  <h2>Sample Run</h2>
  <div id="csSampleRun"> 
    <pre>
Test square method
==================
The square of 5 is 25
The square of 12 is 144

Test sumThree method
====================
The sum of 10, 20, 30 is 60
The sum of 15, 100, 75 is 190

Test smaller method
====================
Which is smaller 10 or 35? 10
Which is smaller 100 or 50? 50

Test fortuneCookie method
=========================
Your fortune cookie says - Maybe you better stay home today
Your fortune cookie says - Your future looks bright

Test season method
===================
The month of March is in the winter
The month of July is in the summer

Test evenOdd method
===================
The number 84 is even
The number 27 is odd
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
