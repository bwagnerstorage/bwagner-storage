<?php 
   session_start();
?>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Scoring</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<BASE href="http://bwagner.org">

<script>
function sendData()
{
   document.data.name.value = name;
   document.data.answers.value = answers;
   document.data.key.value = key;
   document.data.score.value = score;
   document.data.submit();  
} 
</script>

<?php
function readKeyFile($testName)
{
    $file=fopen("data/".$testName." key.txt","r") or exit("Unable to open file!");
	
	while(!feof($file))
    { 
	   $temp = fgets($file);                  // read line
	   $trimmed = rtrim($temp);               // trim whitespace from end
	   $keyString = $keyString . $trimmed;    // append to key string
    }	
	fclose($file);
	
	$keyString = str_replace("\n", "", $keyString);  // remove returns from string
	
	return $keyString;
}
function calculateScore()
{
   global $skips;
   global $correct;
   global $incorrect;
   global $answers;
   global $key;
   
   for($i=0; $i < strlen($answers); $i++)
   {
       if(substr($answers, $i, 1) === "S")
	       $skips++;
	   else if (substr($answers, $i, 1) === substr($key, $i, 1))
	       $correct++;
	   else
	       $incorrect++;
   }
   
   return round(($correct / strlen($answers)) * 100);

}

function projectedScore($correct)
{
	if($correct >= 31)
	   return 5;
	if($correct >= 24 && $correct <= 30)
	   return 4;
	if($correct >= 18 && $correct <= 23)
	   return 3;
	if($correct >= 13 && $correct <= 17)
	   return 2;
	
	return 1;
}

function convertStrings($testname, $answers, $key, $score, $prScore)
{
   $key = str_replace("\n", "", $key);  // remove returns from string
   
   echo("<script>");
   echo("var name = new String(\"$testname\");");
   echo("var answers = new String(\"$answers\");");
   echo("var key = new String(\"$key\");");
   echo("var score = new String(\"$score\");");
   echo("var prScore = new String(\"$prScore\");");
   echo("</script>");
}

function addRecord($userName, $testName, $testType, $correct, $incorrect, $skips, $score, $answers, $timeRemaining, $prScore)
{
    $db_name = "bnwagner_APTester";
    $table_name = "table_tests";
    $connection = @mysqli_connect("localhost", "bnwagner_ap", "Kolty0624") or die(mysqli_error());
    $dbl = @mysqli_select_db($connection, $db_name) or die(mysqli_error());
	
	$testStatus = "complete";
	$numQuestions = 40;
	$timeRemaining = 0;
	$completeDate = date("Y-m-d");
	
	$sql = "SELECT * FROM $table_name WHERE UserName = '$userName' && TestName='$testName'";
	$row = @mysqli_query($sql, $connection) or die(mysqli_error());
	$numRows = mysqli_num_rows($row);

	if($numRows == 0)
	{
         $sql = "INSERT INTO $table_name (UserName, TestName, Type, Status, NumQuestions, NumCorrect, NumIncorrect, NumSkips, Score, Answers, TimeRemaining)
                 VALUES ('$userName', '$testName', '$testType', '$testStatus', $numQuestions, $correct, $incorrect, $skips, $score, '$answers', $timeRemaining, $prScore)";
    }
	else
	{
	     $sql = "UPDATE $table_name SET Status = '$testStatus', NumCorrect = $correct, NumIncorrect = $incorrect, NumSkips = $skips, Score = $score, Answers = '$answers', TimeRemaining = '$timeRemaining', CompleteDate = '$completeDate', ProjectedScore = '$prScore'
		         WHERE UserName = '$userName' && TestName='$testName'"; 	
	}
    $result = @mysqli_query($sql, $connection) or die(mysqli_error());
}

?>


</head>

<body>
<?php
   $userName = $_SESSION['username'];
   $testName = $_POST['name'];
   $testType = $_POST['type'];
   $answers = $_POST['answers'];
   $timeRemaining = $_POST['timeRemaining'];

   $key = readKeyFile($testName);
   $skips=0;
   $correct=0;
   $incorrect=0;
   $score=calculateScore($answers, $key);
   $prScore = projectedScore($correct);
   addRecord($userName, $testName, $testType, $correct, $incorrect, $skips, $score, $answers, $timeRemaining, $prScore);
   convertStrings($testName, $answers, $key, $score, $prScore);
?>
<table align="center">
  <tr><td><h2 align="center">Scoring Summary</h2></td></tr></table>
<table width="213" height="190" border="4" align="center" bordercolor="#0000FF" style="border-collapse:collapse; border-style: solid;">
  <tr bordercolor="#000000"> 
    <td valign="middle" border='1'><p><strong>&nbsp;&nbsp;Correct</strong></p></td>
    <td valign="middle" bgcolor="#E8E8E8" border='1'> 
      <div align="center"><?php echo("$correct"); ?></div></td>
  </tr>
  <tr bordercolor="#000000"> 
    <td valign="middle" border='1'> <p><strong>&nbsp;&nbsp;Incorrect</strong></p></td>
    <td valign="middle" bgcolor="#E8E8E8" border='1'> 
      <div align="center"><?php echo("$incorrect"); ?></div></td>
  </tr>
  <tr bordercolor="#000000"> 
    <td valign="middle" border='1'> <p><strong>&nbsp;&nbsp;Skips</strong></p></td>
    <td valign="middle" bgcolor="#E8E8E8" border='1'> 
      <div align="center"><?php echo("$skips"); ?></div></td>
  </tr>
  <tr bordercolor="#000000"> 
    <td valign="middle" border='1'> <p><strong>&nbsp;&nbsp;Percentage Score</strong></p></td>
    <td valign="middle" bgcolor="#FFCCCC" border='1'> 
	  <div align="center"><?php echo("$score"); ?></div></td>
  </tr>
    <tr bordercolor="#000000"> 
    <td valign="middle" bgcolor="#FFFFCC" border='1'> <p><strong>&nbsp;&nbsp;Projected AP Score</strong></p></td>
    <td valign="middle" bgcolor="#FFFFCC" border='1'> 
	  <div align="center"><?php echo("$prScore"); ?></div></td>
  </tr>
</table>
<br><br>
<table align="center">
  <tr><td><h2 align="center">AP Projected Scoring Chart</h2></td></tr></table>
<table width="213" height="190" border="4" align="center" bordercolor="#000000" style="border-collapse:collapse; border-style: solid;">
  <tr bordercolor="#000000"> 
    <td valign="middle" bgcolor = "#000000" border='1'><div align="center"><font color="#FFFFFF"><strong>Correct</strong></font></div></td>
    <td valign="middle" bgcolor = "#000000"border='1'><div align="center"><font color="#FFFFFF"><strong>Score</strong></font></div></td>
  </tr>
  <tr bordercolor="#000000"> 
    <td valign="middle" border='1'><div align="center"><strong>31 to 40</strong></div></td>
    <td valign="middle" border='1'><div align="center"><strong>5</strong></div></td>
  </tr>
  <tr bordercolor="#000000"> 
    <td valign="middle" border='1'><div align="center"><strong>24 to 30</strong></div></td>
    <td valign="middle" border='1'><div align="center"><strong>4</strong></div></td>
  </tr>
  <tr bordercolor="#000000"> 
    <td valign="middle" border='1'><div align="center"><strong>18 to 23</strong></div></td>
    <td valign="middle" border='1'><div align="center"><strong>3</strong></div></td>
  </tr>
  <tr bordercolor="#000000"> 
    <td valign="middle" border='1'><div align="center"><strong>13 to 17</strong></div></td>
    <td valign="middle" border='1'><div align="center"><strong>2</strong></div></td>
  </tr>
  <tr bordercolor="#000000"> 
    <td valign="middle" border='1'><div align="center"><strong>0 to 12</strong></div></td>
    <td valign="middle" border='1'><div align="center"><strong>1</strong></div></td>
  </tr>
</table>
<table align="center">
  <tr>
  <td height="20"></td>
  </tr>
  <tr>
     <td>
       <form action="http://bwagner.org/menu/ap/APTester/SelectTest.php" method="post" name="continue">
       <input name="submit" type="submit" method="link" value="Continue">
        </form>
    </td>
	<td>
		<form method="post" name="data" action="http://bwagner.org/menu/ap/APTester/ReviewTest.php">
		 <input name="data" type="button" value="Review Test" onClick="sendData()">
		 <script>document.write("<input type='hidden' name='name' >");</script>
		 <script>document.write("<input type='hidden' name='answers' >");</script>
		 <script>document.write("<input type='hidden' name='key' >");</script>
		 <script>document.write("<input type='hidden' name='score' >");</script>
		</form>
	</td>
  </tr>
</table>


</body>
</html>
