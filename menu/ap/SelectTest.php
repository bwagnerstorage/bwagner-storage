<?php 
   session_start();
?>

<html>
<head>
<BASE href="http://bwagner.org">
<link rel="stylesheet" href="menu/ap/css/SelectTest.css">

<script type="text/javascript" language="javascript">
function sendData(testName, testType, testStatus, testTimeRemaining, testScore, testAnswers)
{
   if(testStatus == "complete")
   {
	   document.reviewTest.name.value = testName;
	   document.reviewTest.score.value = testScore;
	   document.reviewTest.answers.value = testAnswers;
	   document.reviewTest.submit();
   }
   else
   {
       document.takeTest.testName.value = testName;
	   document.takeTest.testType.value = testType;
	   document.takeTest.testStatus.value = testStatus;
	   document.takeTest.testTimeRemaining.value = testTimeRemaining;
	   document.takeTest.submit();
   }

} 
</script>

<?php
function readTestList($testListArray)
{
    $file=fopen("data/TestList.txt","r") or exit("Unable to open file!");
	
	$r = 0;
	while(!feof($file))
    {
       $testName = fgets($file);
	   $testType = fgets($file);
	   $testStatus = fgets($file);
	   $testCorrect = fgets($file);
	   $testIncorrect = fgets($file);
	   $testSkips = fgets($file);
	   $testScore = fgets($file);
	   $testTimeRemaining = fgets($file);
	   $dateCompleted = 0;
	   $projectedScore = 0;
	   $row = array($testName, $testType, $testStatus, $dateCompleted, $testCorrect,
					$testIncorrect, $testSkips, $testScore, $projectedScore, $testTimeRemaining);
					
		$testListArray[] = $row;
    }
	
	fclose($file);
}

function insertDBIntoArray(&$testListArray, $result)
{
    $i = 0;
    while($row = mysqli_fetch_array($result))
	{
	   $dbArray[$i] = $row;
	   $i++;
	}

    for($r=0; $r < count($testListArray); $r++)
	{
	     $testName = rtrim($testListArray[$r][0]);
		 for($c=0; $c < count($dbArray); $c++)
		 {
		     $testNameDB = $dbArray[$c]['TestName'];
			 
			 if($testName === $testNameDB)
			 {
			    $testListArray[$r][1] = $dbArray[$c]['Type'];
			    $testListArray[$r][2] = $dbArray[$c]['Status'];
				$testListArray[$r][3] = $dbArray[$c]['CompleteDate'];
				$testListArray[$r][4] = $dbArray[$c]['NumCorrect'];
				$testListArray[$r][5] = $dbArray[$c]['NumIncorrect'];
				$testListArray[$r][6] = $dbArray[$c]['NumSkips'];
				$testListArray[$r][7] = $dbArray[$c]['Score'];
				$testListArray[$r][8] = $dbArray[$c]['ProjectedScore'];
				$testListArray[$r][9] = $dbArray[$c]['Answers'];
			 }
		 }
    }
}

function populateTable($testListArray)
{
    echo ("<table cellpadding = '5' cellspacing = '0' align = 'center'>");  // main table
	
	   // begin title section   
	   echo ("<tr class='head'>");
	        echo ("<td><h1> Practice Tests&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Release Tests </h1> </td>");
	   echo ("</tr>");
	   // end title section
	   
	   // begin data section
	   echo ("<tr class='main'> ");
	      echo ("<td>");
		  
		      // begin main data table
		      echo("<table><tr><td>");   
			  
			      // begin data  table 1
				  echo("<table>");
				  // begin header section
				       echo("<tr><td>");
			              echo ("<table width='450'> <tr>");
                          echo ("<td id='header' width = '280' >Test</td><td width = '70' id='header'>Status</td><td id='header'>Completed</td><td id='header' width = '20'>&nbsp;&nbsp;&nbsp;C</td><td id='header' width = '20' >&nbsp;&nbsp;&nbsp;I</td><td id='header' width = '20'>&nbsp;&nbsp;&nbsp;S</td><td id='header' width = '40'>Sc</td><td id='header'>Pr&nbsp;&nbsp;&nbsp;</td>");
	                      echo ("</tr></table>"); 
					   echo ("</td></tr>");
				  // end header section	  
				  // begin data section
                       echo ("<tr class='main'> <td class='main'>");
                          echo ("<div id='scrollbar'>");
	                      echo ("<table class='chart'>");
						  //for($r=0; $r < count($testListArray); $r++)
						  for($r=count($testListArray)-1; $r >=0 ; $r--)
						  {
								 $s = rtrim($testListArray[$r][1]);
								 if(strcmp($s, "practice") == 0)
								 {
									   echo("<tr class='chart'>");
									   
									   $testName = rtrim($testListArray[$r][0]);
									   $testType = rtrim($testListArray[$r][1]);
									   $testStatus = rtrim($testListArray[$r][2]);
									   $testScore = $testListArray[$r][7];
									   $testAnswers = rtrim($testListArray[$r][9]);
									   
									   echo("<td class='chart' >");
									   echo("<a href='javascript:sendData(\"$testName\",\"$testType\",\"$testStatus\",\"$testTimeRemaining\", \"$testScore\", \"$testAnswers\");'>$testName</a>");
									   for($c=2; $c <= 8; $c++)
									   {
											   if($c == 2)
											   {
												   if($testListArray[$r][$c] == "complete")
												   {
													   echo("<td class='complete' width = '65' align='center'>");
													   echo($testListArray[$r][$c]);
													   echo("</td>");
												   }
												   else if($testListArray[$r][$c] == "incomplete")
												   {
													   echo("<td class='incomplete' width = '65' align='center'>");
													   echo($testListArray[$r][$c]);
													   echo("</td>");
												   }
												   else
												   {
													   echo("<td class='available' width = '65' align='center'>");
													   echo($testListArray[$r][$c]);
													   echo("</td>");
												   }
											   
											   }
											   else if ($c == 3)
											   {
											       echo("<td class='chart' width = '90' align='center'>");
												   echo($testListArray[$r][$c]);
												   echo("</td>");
											   }
											   else if ($c >= 4 && $c <= 6)
											   {
											       echo("<td class='chart' width = '25' align='center'>");
												   echo($testListArray[$r][$c]);
												   echo("</td>");
											   }
											   else if ($c == 7)
											   {
												   echo("<td class='chart' width = '25' align='center'>");
												   echo($testListArray[$r][$c]);
												   echo("</td>");
											   }
											   else if ($c == 8)
											   {
												   echo("<td class='chart' width = '25' align='center'>");
												   echo($testListArray[$r][$c]);
												   echo("</td>");
											   }
									   }
									   echo("</tr>");
								 }
							}
					 echo("</table></div></td></tr>");
					 // end data section
				echo("</table>");
				// end data table 1
			echo("</td>");
			echo("<td>");
			    // begin data table 2
				echo("<table>");
				   // begin header section
				       echo("<tr><td>");
			              echo ("<table width='450'> <tr>");
                           echo ("<td id='header' width = '280' >Test</td><td width = '70' id='header'>Status</td><td id='header'>Completed</td><td id='header' width = '20'>&nbsp;&nbsp;&nbsp;C</td><td id='header' width = '20' >&nbsp;&nbsp;&nbsp;I</td><td id='header' width = '20'>&nbsp;&nbsp;&nbsp;S</td><td id='header' width = '40'>Sc</td><td id='header'>Pr&nbsp;&nbsp;&nbsp;</td>");
	                      echo ("</tr></table>"); 
					   echo ("</td></tr>");
				  // end header section	  
				  // begin data section
				     echo ("<tr class='main'> <td class='main'>");
                          echo ("<div id='scrollbar'>");
	                      echo ("<table class='chart'>");
							for($r=count($testListArray)-1; $r >=0 ; $r--)
							{
								 $s = rtrim($testListArray[$r][1]);
								 if(strcmp($s, "state") == 0)
								 {
									   echo("<tr class='chart'>");
									   
									   $testName = rtrim($testListArray[$r][0]);
									   $testType = rtrim($testListArray[$r][1]);
									   $testStatus = rtrim($testListArray[$r][2]);
									   $testScore = $testListArray[$r][7];
									   $testAnswers = rtrim($testListArray[$r][9]);
									   
									   echo("<td class='chart'>");
									   echo("<a href='javascript:sendData(\"$testName\",\"$testType\",\"$testStatus\",\"$testTimeRemaining\", \"$testScore\", \"$testAnswers\");'>$testName</a>");
									   for($c=2; $c <= 8; $c++)
									   {
											   if($c == 2)
											   {
												   if($testListArray[$r][$c] == "complete")
												   {
													   echo("<td class='complete' width = '65' align='center'>");
													   echo($testListArray[$r][$c]);
													   echo("</td>");
												   }
												   else if($testListArray[$r][$c] == "incomplete")
												   {
													   echo("<td class='incomplete' width = '65' align='center'>");
													   echo($testListArray[$r][$c]);
													   echo("</td>");
												   }
												   else
												   {
													   echo("<td class='available' width = '65' align='center'>");
													   echo($testListArray[$r][$c]);
													   echo("</td>");
												   }
											   
											   }
											   else if ($c == 3)
											   {
											       echo("<td class='chart' width = '90' align='center'>");
												   echo($testListArray[$r][$c]);
												   echo("</td>");
											   }
											   else if ($c >= 4 && $c <= 6)
											   {
											       echo("<td class='chart' width = '25' align='center'>");
												   echo($testListArray[$r][$c]);
												   echo("</td>");
											   }
											   else if ($c == 7)
											   {
												   echo("<td class='chart' width = '25' align='center'>");
												   echo($testListArray[$r][$c]);
												   echo("</td>");
											   }
											   else if ($c == 8)
											   {
												   echo("<td class='chart' width = '25' align='center'>");
												   echo($testListArray[$r][$c]);
												   echo("</td>");
											   }									  
									   }
									   echo("</tr>");
								 }
							}
				      echo("</table></div></td></tr>");
					 // end data section
				echo("</table>");
				// end data table 2
			echo("</td>");
	
	     // end main data table					
	     echo("</td></tr></table>");
	// end data section
	echo("</td></tr>");
	
	echo("</table>");	
}

function saveDB($userName, $testName, $testType, $testAnswers, $timeRemaining)
{
    $db_name = "bnwagner_APTester";
    $table_name = "table_tests";
    $connection = @mysqli_connect("localhost", "bnwagner_ap", "Kolty0624") or die(mysqli_error());
    $dbl = @mysqli_select_db($connection, $db_name) or die(mysqli_error());
	
	$testStatus = "incomplete";
	$numQuestions = 40;
	$correct = 0;
	$incorrect = 0;
	$skips = 0;
	$score = 0;
	$completeDate = 0;
	
	$sql = "SELECT * FROM $table_name WHERE UserName = '$userName' && TestName='$testName'";
	$row = @mysqli_query($sql, $connection) or die(mysqli_error());
	$numRows = mysqli_num_rows($row);
	
	if($numRows == 0)
	{
	 	$sql = "INSERT INTO $table_name (UserName, TestName, Type, Status, CompleteDate, NumQuestions, NumCorrect, NumIncorrect, NumSkips, Score, Answers, TimeRemaining)
       		    VALUES ('$userName', '$testName', '$testType', '$testStatus', '$completeDate', '$numQuestions', '$correct', '$incorrect', '$skips', '$score', '$testAnswers', '$timeRemaining')";
	}
	else
	{
	     $sql = "UPDATE $table_name SET Answers='$testAnswers', TimeRemaining='$timeRemaining'
		         WHERE UserName = '$userName' && TestName='$testName'";  	
	}
    $result = @mysqli_query($sql, $connection) or die(mysqli_error());
}

function readDB($userName)
{
	$db_name = "bnwagner_APTester";
	$table_name = "table_tests";
	$connection = @mysqli_connect("localhost", "bnwagner_ap", "Kolty0624") or die(mysqli_error());
	$db = @mysqli_select_db($connection, $db_name) or die(mysqli_error());
	
	$sql = "SELECT * FROM $table_name WHERE UserName='$userName'";
	$result = @mysqli_query($sql, $connection) or die(mysqli_error());
	
	return $result;
}

?>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"></head>
<body bgcolor="#F2F2F2">
<form name='takeTest' method='POST' action='menu/ap/APTester/TakeTest.php'>
    <input type='hidden' name='testName'>
	<input type='hidden' name='testType'>
	<input type='hidden' name='testStatus'>
	<input type='hidden' name='testTimeRemaining'>
</form>
<form name='reviewTest' method='POST' action='menu/ap/APTester/ReviewTest.php'>
    <input type='hidden' name='name'>
	<input type='hidden' name='score'>
	<input type='hidden' name='answers'>
</form>

<?php   
  $userName = $_SESSION['username'];
         
   if(isset($_POST['answers']))
   {
      $testName = $_POST['name'];
	  $testType = $_POST['type'];
	  $testAnswers = $_POST['answers'];
	  $testTimeRemaining = $_POST['timeRemaining'];
	  
      saveDB($userName, $testName, $testType, $testAnswers, $testTimeRemaining);
	  

   }

  $testListArray = array();    // Array of Test data
  
  readTestList(&$testListArray);
  $result = readDB($userName);
  insertDBIntoArray(&$testListArray, $result);
  populateTable($testListArray);
?>
<br>
<div align="center">
<FORM METHOD="LINK" ACTION="http://bwagner.org">
<INPUT TYPE="submit" VALUE=" Home ">
</FORM>
</div>
</body>
</html>
