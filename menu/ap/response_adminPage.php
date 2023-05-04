<?php
class Person
{
   var $name;
   var $numTests;
   var $average;
   
   function Person($n, $t, $a)
   {
       $this->name = $n;
	   $this->numTests = $t;
	   $this->average = $a;
   }   
   
   function compDesc($obj1, $obj2) 
   {
		if ($obj1->average == $obj2->average) 
		{
			return 0;
		}
		return ($obj1->average > $obj2->average) ? -1 : 1;
   }
   
   function getName()
   {
       return $this->name;
   }
}

function readUsersDB()
{
	$db_name = "bnwagner_APTester";
	$table_name = "table_users";
	$connection = @mysqli_connect("localhost", "bnwagner_ap", "Kolty0624") or die(mysqli_error());
	$db = @mysqli_select_db($connection, $db_name) or die(mysqli_error());
	$sql = "SELECT * FROM $table_name ORDER BY LastName";
	$result = @mysqli_query($sql, $connection) or die(mysqli_error());
	
	return $result;
}

function readUserNameDB($userName)
{
	$db_name = "bnwagner_APTester";
	$table_name = "table_users";
    $connection = @mysqli_connect("localhost", "bnwagner_ap", "Kolty0624") or die(mysqli_error());
	$db = @mysqli_select_db($connection, $db_name) or die(mysqli_error());
	$sql = "SELECT * FROM $table_name WHERE UserName = '$userName' ORDER BY LastName";
	$result = @mysqli_query($sql, $connection) or die(mysqli_error());
	
	return $result;
}

function readTestDB($userName)
{
	$db_name = "bnwagner_APTester";
	$table_name = "table_tests";
	$$connection = @mysqli_connect("localhost", "bnwagner_ap", "Kolty0624") or die(mysqli_error());
	$db = @mysqli_select_db($connection, $db_name) or die(mysqli_error());
	$sql = "SELECT * FROM $table_name WHERE UserName = '$userName' ORDER BY Score DESC";
	$result = @mysqli_query($sql, $connection) or die(mysqli_error());
	
	return $result;
}

function readTestListDB()
{
	$db_name = "bnwagner_APTester";
	$table_name = "table_tests";
	$connection = @mysqli_connect("localhost", "bnwagner_ap", "Kolty0624") or die(mysqli_error());
	$db = @mysqli_select_db($connection, $db_name) or die(mysqli_error());
	$sql = "SELECT DISTINCT TestName FROM $table_name ORDER BY TestName ASC";
	$result = @mysqli_query($sql, $connection) or die(mysqli_error());
	
	return $result;
}

function readAllTestDB($userTest)
{
	$db_name = "bnwagner_APTester";
	$table_name = "table_tests";
	$connection = @mysqli_connect("localhost", "bnwagner_ap", "Kolty0624") or die(mysqli_error());
	$db = @mysqli_select_db($connection, $db_name) or die(mysqli_error());
	$sql = "SELECT * FROM $table_name WHERE TestName = '$userTest' ORDER BY Score DESC";
	$result = @mysqli_query($sql, $connection) or die(mysqli_error());
	
	return $result;
}

function readTestsDB()
{
	$db_name = "bnwagner_APTester";
	$table_name = "table_tests";
	$connection = @mysqli_connect("localhost", "bnwagner_ap", "Kolty0624") or die(mysqli_error());
	$db = @mysqli_select_db($connection, $db_name) or die(mysqli_error());
	$sql = "SELECT * FROM $table_name";
	$result = @mysqli_query($sql, $connection) or die(mysqli_error());
	
	return $result;
}



$userName = $_POST['userName'];
$testName = $_POST['testName'];

if(isset($userName) || isset($testName))
{
    echo("<table class='test' width='100%'>");
	echo("<tr>");
		echo("<td class='header'><b>Account Name</b></td>");
		echo("<td class='header'><b>Test Name</b></td>");
		echo("<td class='header'><b>Type</b></td>");
		echo("<td class='header'><b>Status</b></td>");
		echo("<td class='header'><b>Completed</b></td>");
		echo("<td class='header'><b>Correct</b></td>");
		echo("<td class='header'><b>Incorrect</b></td>");
		echo("<td class='header'><b>Skips</b></td>");
		echo("<td class='header'><b>Score</b></td>");
	echo("</tr>");
  
   if(isset($userName))
   {
	   $result = readTestDB($userName);
	   $result2 = readUserNameDB($userName);
	   $row2 = mysqli_fetch_array($result2);
	   while($row = mysqli_fetch_array($result))
	   { 
		   echo("<tr class='test'>");
			  echo("<td class='test'>"."&nbsp;&nbsp;&nbsp;".$row2['LastName'].", ".$row2['FirstName']."</td>");
			  echo("<td class='test'>"."&nbsp;&nbsp;&nbsp;".$row['TestName']."</td>");
			  echo("<td class='test' align='center'>".$row['Type']."</td>"); 
			  echo("<td class='test' align='center'>".$row['Status']."</td>");
			  echo("<td class='test' align='center'>".$row['CompleteDate']."</td>");
			  echo("<td class='test' align='center'>".$row['NumCorrect']."</td>");
			  echo("<td class='test' align='center'>".$row['NumIncorrect']."</td>");
			  echo("<td class='test' align='center'>".$row['NumSkips']."</td>");
			  echo("<td class='test' align='center'>".$row['Score']."</td>");
		   echo("</tr>");
	   } 
   }
   if(isset($testName))
   {
	   $result = readAllTestDB($testName);
	   while($row = mysqli_fetch_array($result))
	   {
		   $userName = $row['UserName'];
		   $result2 = readUserNameDB($userName);
		   $row2 = mysqli_fetch_array($result2);
		   echo("<tr class='test'>");
			  echo("<td class='test'>"."&nbsp;&nbsp;&nbsp;".$row2['LastName'].", ".$row2['FirstName']."</td>");
			  echo("<td class='test'>"."&nbsp;&nbsp;&nbsp;".$row['TestName']."</td>");
			  echo("<td class='test' align='center'>".$row['Type']."</td>"); 
			  echo("<td class='test' align='center'>".$row['Status']."</td>");
			  echo("<td class='test' align='center'>".$row['CompleteDate']."</td>");
			  echo("<td class='test' align='center'>".$row['NumCorrect']."</td>");
			  echo("<td class='test' align='center'>".$row['NumIncorrect']."</td>");
			  echo("<td class='test' align='center'>".$row['NumSkips']."</td>");
			  echo("<td class='test' align='center'>".$row['Score']."</td>");
		   echo("</tr>");
	   } 
   }
   echo("</table>");
   }
   else
   {
     echo("<table class='test'>");
	 echo("<tr>");
		echo("<td class='header'><b>Account Name</b></td>");
		echo("<td class='header'><b>Number of Tests</b></td>");
		echo("<td class='header'><b>Average Score</b></td>");
	 echo("</tr>");
	
	 $userNames = readUsersDB();
	 $personArray = array(); 
	 while($row1 = mysqli_fetch_array($userNames))
	 {
        $userTests = readTestDB($row1['UserName']);
		$count = 0;
		$sum = 0;
		$avg = 0;
		while($row2 = mysqli_fetch_array($userTests))
		{ 
		    $sum += $row2['Score'];
		    $count++;
		}
		if($count > 0)
		   $avg = round($sum / $count);
		$name = $row1['LastName'].",".$row1['FirstName'];
		$person = new Person($name, $count, $avg);
		$personArray[] = $person;
	  }	
	
	  // sort array in descending order
      usort($personArray, array("Person", "compDesc"));
	  
	  foreach($personArray as $person)
	  { 
		echo("<tr>");
		echo("<td class='test'>".$person->name."</td>");
		echo("<td class='test' align='center'>".$person->numTests."</td>");
		echo("<td class='test' align='center'>".$person->average."</td>");
	    echo("</tr>");
	  }
	
	echo("<table>");
  }
?>