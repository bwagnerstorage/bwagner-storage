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

      #completedCode9 {
        display: none;
      }

      #completedCode10 {
        display: none;
      }

      img {
        width: 550px;
        border: 2px solid black; padding:10px;
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
    <h1 style="text-align:center">Jeroo TwoFriendsMeet Solution</h1>
<p>I'm going to show you two versions of the program. The first version uses three while loops and the second version
   uses one while loop with an if statement inside. Version 2 is the more advanced of the two versions and should be the level of coding you should be striving to achieve.
</p>
<h1>Version 1</h1>
<h2>Create method main</h2>
<p>Click the <strong>Save</strong> button and create a Jeroo source code file (.jsc) with the name <strong>TwoFriendsMeet.jsc</strong><p>
<p>Add the following code to the file under the Main Method section.</p>
<img style="width:15%" src="/csregular/unit11_jerooControlStructures/solutions/images/twoFriendsMeetv1_00.png"><br>
<h2>Step 1 - Create Jeroo Objects</h2>
  <ol>
      <li>Create a Jeroo object named <strong>bugs</strong> with 100 flowers in his pouch.</li>
      <li>Create a Jeroo object named <strong>daffy</strong> at location (0, 23), facing WEST, and 100 flowers in his pouch.</li>
  </ol>
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode1')" id="completedCode1a">Show Code</a>
      <img id="completedCode1" src="/csregular/unit11_jerooControlStructures/solutions/images/twoFriendsMeetv1_02.png">
  </div>

  <h2>Step 2 - Add a User-Defined Method</h2>

      <p>To simplify the code, create a method named <strong>plantAndHop</strong> that instructs
          a Jeroo to plant and hop.
      </p>
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode2')" id="completedCode2a">Show Code</a>
      <img id="completedCode2" src="/csregular/unit11_jerooControlStructures/solutions/images/twoFriendsMeetv1_01.png" style="width:18%">
  </div>

  <h2>Step 3 - Construct First while Loop</h2>
  <ol>
      <li>Construct a while loop that will continue until bugs reaches daffy. To do this, use the method call <strong>isJeroo(AHEAD)</strong>. Since daffy is just mirroring the movements of bugs there is no need to check his status. A
          <strong>not(!)</strong>logic operator needs to be placed at the beginning of the condition statement because the while loop is suppose to continue "while there is <strong>not</strong> another Jeroo directly in front of bugs.</li>
      <li>When bugs and daffy are directly in front of each other the loop will stop. The next step is to 
          turn bugs and daffy so they are both facing down. This means bugs will need to turn to his RIGHT and daffy will need to turn to his LEFT.</li>
  </ol>
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode3')" id="completedCode3a">Show Code</a>
      <img id="completedCode3" src="/csregular/unit11_jerooControlStructures/solutions/images/twoFriendsMeetv1_03.png">
  </div>

  <h2>Step 4 - Construct Second while Loop</h2>
  <ol>
      <li>Construct a while loop that will continue until bugs reaches the water. To do this, use the        method <strong>isWater(AHEAD)</strong>. Once again, include the not(!) operator in front of the condition statement.</li>
      <li>When bugs and daffy are directly in front of water the loop will stop. The next step is to turn bugs and daffy so they are both facing away from each other.</li>
  </ol>
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode4')" id="completedCode4a">Show Code</a>
      <img id="completedCode4" src="/csregular/unit11_jerooControlStructures/solutions/images/twoFriendsMeetv1_04.png">
  </div>

  <h2>Step 5 - Construct Third while Loop</h2>

      <p>The third while loop is identical to the second while loop. The loop should stop when bugs reaches the water.
      <strong>Note:</strong> Typically when you have code that is being repeated in a program you create a method and place the repeating code within the method. Then to execute the code you call the method by name. However, in this situation,
      because the code contains a while loop, it is not a good idea to put this code in a user-defined method. User-defined Jeroo methods are a simplified version of Java methods and do not have all of the
      features, therefore there are limitations to what code will work in the Jeroo methods.
      </p>
 
  <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode5')" id="completedCode5a">Show Code</a>
      <img id="completedCode5" src="/csregular/unit11_jerooControlStructures/solutions/images/twoFriendsMeetv1_05.png">
  </div>
  <br>
  <h1>Version 2</h1>
  <h2>Create method main</h2>
  <p>Click the <strong>Save</strong> button and create a Jeroo source code file (.jsc) with the name <strong>TwoFriendsMeet.jsc</strong><p>
  <p>Add the following code to the file under the Main Method section.</p>
  <img style="width:15%" src="/csregular/unit11_jerooControlStructures/solutions/images/twoFriendsMeetv1_00.png"><br>
  <h2>Step 1 - Create Jeroo Objects</h2>
    <ol>
        <li>Create a Jeroo object named <strong>bugs</strong> with 100 flowers in his pouch.</li>
        <li>Create a Jeroo object named <strong>daffy</strong> at location (0, 23), facing WEST, and 100 flowers in his pouch.</li>
    </ol>
    <div class="solutionContainer">
        <a href="#!" onclick="makeVisible('completedCode6')" id="completedCode6a">Show Code</a>
        <img id="completedCode6" src="/csregular/unit11_jerooControlStructures/solutions/images/twoFriendsMeetv1_02.png">
    </div>
  
    <h2>Step 2 - Add a User-Defined Method</h2>
        <p>To simplify the code, create a method named <strong>plantAndHop</strong> that instructs
            a Jeroo to plant and hop.
        </p>
 
    <div class="solutionContainer">
        <a href="#!" onclick="makeVisible('completedCode7')" id="completedCode7a">Show Code</a>
        <img id="completedCode7" src="/csregular/unit11_jerooControlStructures/solutions/images/twoFriendsMeetv1_01.png" style="width:18%">
    </div>
  
    <h2>Step 3 - Construct while Loop</h2>
        <p>Construct a while loop that will continue looping as long as bugs has not reached the
            bottom left corner of the island. No need to test for daffy's location. He will stop when 
            bugs stops.<br><br>
            When trying to decide what condition to test for in the while loop, you need to ask yourself the following question: "Is the location where the Jeroo should be when the while 
            loop stops execution unique?" In other words, is there some condition or conditions that make 
            this location different from all other spots the Jeroo will visit as it travels around the island? Look at the following island diagram.<br>
            <img style="width:25%" src="/csregular/unit11_jerooControlStructures/solutions/images/twoFriendsMeetv2_01.PNG"><br>
            Assume there is a Jeroo named bugs that is positioned on the island at coordinates (0,0) facing EAST. The yellow line shows the path bugs takes on his journey from start to finish. The red square is the location where
            bugs is suppose to stop. To stop on this square the while loop's condition statement must become false. In order for this to happen, there must be a unique feature or features about this red square that can be tested using one or more of Jeroo's boolean methods to determine bug's current state or condition (isWater, isFacing, isNet, isFlower, isJeroo, isClear, hasFlower).<br><br>
            The first possible unique feature is that when bugs is positioned on the red square there is water directly in front of him. This is a condition, however it is not unique only to the red square.
            When bugs reaches the location marked in black there is also water directly in front of him.
            It turns out there is not a single feature about the red square that identifies it uniquely.
            So what can we do? The answer is to look for two or more features that when tested can be used to in combination to identify the red square.<br><br>
            If you study the island you will see there are two conditions, that combined with the water AHEAD condition, can be used to identify the red square uniquely. The first is the direction bug's is facing. As he 
            moves along the bottom of the island from the black square to the red square he is facing WEST.
            Second, as he is moves along the bottom of the island there is always water to his LEFT. Both of these conditions, facing WEST and water LEFT, only occur while bugs is moving from the black square to the red. By combining either one of these with the water AHEAD condition you can create a compound condition that is only true at one location, the red square. The only time bugs has water directly in front of him <strong>and</strong> he is facing WEST <strong>or</strong> there is water to his LEFT is when he is standing on the red square. <br<br>
            Using the methods water AHEAD <strong>and</strong> is facing WEST forms the compound expression or condition: <br> <div style="font-family: Consolas, 'Courier New', Courier, monospace; text-align:center"> (bugs.isWater(AHEAD) && bugs.isFacing(WEST)</div> <br> 
            
            However, this is condition is not quite right. Remember a while statement keeps repeating or looping as long as its conditional statement remains true; it stops repeating when it becomes false. The way the conditional statement is written above, it is only true when bugs is positioned on the red square. What is needed is a condition statement that is true when bugs is <strong>not</strong> on the red square. So the condition statement needs to change so it does the complete opposite of what it does currently. This is achieved by adding a not(!) operator around the condition statement like shown below:<br><br> <div  style="font-family: Consolas, 'Courier New', Courier, monospace; text-align:center"><span style="color:red">!(</span>(bugs.isWater(AHEAD) && bugs.isFacing(WEST)<span style="color:red">)</div></span>.<br>
            <br>
            There is a rule in Algebra called DeMorgan's Law that allows the above condition to be written another way, but still evaluate the same. In other words, they are equivalent. You might like this version better, but it does not matter they are the same. Notice the use of the or( || ) operator.<br><br>
            <div style="font-family: Consolas, 'Courier New', Courier, monospace; text-align:center">(<span style="color:red">!</span>bugs.isWater(AHEAD)<span style="color:red">||</span><span style="color:red">!</span>bugs.isFacing(WEST))</div>
        </p>

    <div class="solutionContainer">
      <a href="#!" onclick="makeVisible('completedCode8')" id="completedCode8a">Show Code</a>
      <img id="completedCode8" src="/csregular/unit11_jerooControlStructures/solutions/images/twoFriendsMeetv2_02.png">
  </div>

  
    <h2>Step 4 - Call plantAndHop Method </h2>
        <p>Both bugs and daffy need to plant a flower and hop once each time the while is executed. To do this a call is made by each Jeroo to the plantAndHop method within the body of the while statement. </p>
    <div class="solutionContainer">
        <a href="#!" onclick="makeVisible('completedCode9')" id="completedCode9a">Show Code</a>
        <img id="completedCode9" src="/csregular/unit11_jerooControlStructures/solutions/images/twoFriendsMeetv2_03.png">
    </div>
  
    <h2>Step 5 - Construct if Statement</h2>
        <p>In order to turn the Jeroos at the appropriate an if statement is needed in the body of the while loop. Notice that the if statement is placed before the calls to plantAndHop. As a general rule, you should do tests (if statements) before the Jeroo moves, otherwise the while loop may end to soon. Looking at where bugs needs to turn there seems to be only two condition statements that will work. The first one uses two
        boolean methods and requires the use of an or ( || ) operator to form a compound statement:<br><br> 

        <div style="font-family: Consolas, 'Courier New', Courier, monospace; text-align:center">(bugs.isJeroo(AHEAD) || bugs.isWater(AHEAD))</div><br><br>
        However, the second one only requires one boolean method:<br><br> 
        <div style="font-family: Consolas, 'Courier New', Courier, monospace; text-align:center">(!bugs.isClear(AHEAD))</div><br><br>
        </p>
    <div class="solutionContainer">
        <a href="#!" onclick="makeVisible('completedCode10')" id="completedCode10a">Show Code</a>
        <img id="completedCode10" src="/csregular/unit11_jerooControlStructures/solutions/images/twoFriendsMeetv2_04.png">
    </div>
    <br>
  
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
