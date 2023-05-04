<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<BASE href="http://bwagner.org">
<link rel="stylesheet" href="menu/ap/css/Admin.css">
<title>Admin Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<script type="text/javascript" language="javascript">
function sendDataUser(userName)
{ 
	   if (window.XMLHttpRequest)
	   {   // code for IE7+, Firefox, Chrome, Opera, Safari
		   xmlhttp=new XMLHttpRequest();
	   }  
	   else
	   {   // code for IE6, IE5
		   xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	   }
	   
	   xmlhttp.open("POST","http://bwagner.org/menu/ap/response_adminPage.php",true);
	   xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 
	   
	   xmlhttp.onreadystatechange = function() 
	   {     //Call a function when the state changes.
	         if(xmlhttp.readyState == 4 && xmlhttp.status == 200) 
			 {
		         var response = xmlhttp.responseText;
				 if(response)
				 {
					handleAjaxResponse(response);
	             }
		     }
       }
	    
	   var data = "userName=" + userName;
	   xmlhttp.send(data); 
}

function sendDataTest(testName)
{
	   if (window.XMLHttpRequest)
	   {   // code for IE7+, Firefox, Chrome, Opera, Safari
		   xmlhttp=new XMLHttpRequest();
	   }  
	   else
	   {   // code for IE6, IE5
		   xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	   }
	   
	   xmlhttp.open("POST","http://bwagner.org/menu/ap/response_adminPage.php",true);
	   xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 
	   
	   xmlhttp.onreadystatechange = function() 
	   {     //Call a function when the state changes.
	         if(xmlhttp.readyState == 4 && xmlhttp.status == 200) 
			 {
		         var response = xmlhttp.responseText;
				 if(response)
				 {
					handleAjaxResponse(response);
	             }
		     }
       }	    
	    
	   var data = "testName=" + testName;
	   xmlhttp.send(data); 
}

function sendDataAllTests()
{
    if (window.XMLHttpRequest)
	   {   // code for IE7+, Firefox, Chrome, Opera, Safari
		   xmlhttp=new XMLHttpRequest();
	   }  
	   else
	   {   // code for IE6, IE5
		   xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	   }
	   
	   xmlhttp.open("POST","http://bwagner.org/menu/ap/response_adminPage.php",true);
	   xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 
	   
	   xmlhttp.onreadystatechange = function() 
	   {     //Call a function when the state changes.
	         if(xmlhttp.readyState == 4 && xmlhttp.status == 200) 
			 {
		         var response = xmlhttp.responseText;
				 if(response)
				 {
					handleAjaxResponse(response);
	             }
		     }
       }	    
	    
	   var data = " ";
	   xmlhttp.send(data);
}

function handleAjaxResponse(response)
{
  start = false;
  document.getElementById('ajaxResponse').innerHTML = response;  
}
</script>

<?php
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

function readDateDB()
{
	$db_name = "bnwagner_APTester";
	$table_name = "table_tests";
	$connection = @mysqli_connect("localhost", "bnwagner_ap", "Kolty0624") or die(mysqli_error());
	$db = @mysqli_select_db($connection, $db_name) or die(mysqli_error());
	
	$sql = "SELECT * FROM $table_name WHERE DATE_SUB(CURDATE(),INTERVAL 10 DAY) <= CompleteDate
	        ORDER BY CompleteDate DESC, USERNAME ";
	$result = @mysqli_query($sql, $connection) or die(mysqli_error());
	
	return $result;
}
?>
<script type="text/javascript">
  var start = true;
</script>
</head>

<body bgcolor="#EAEAEA">

<table cellpadding="3">
   <tr>
      <td width="100" align="center"><button type="button" onClick="location.href='menu/ap/show_Accounts.php'">&nbsp;&nbsp;&nbsp;Accounts&nbsp;&nbsp;&nbsp;</button></td>
	  <td width="100" align="center"><button type="button" onClick="location.href='menu/ap/show_Tests.php'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tests&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button></td>
	  <td width="120" align="center"><button type="button" onClick="sendDataAllTests()">View Averages</button></td>
   </tr>
</table>
<div id = "main">
	<div id = "left" >
		    <div>
			<table class="header">
				<tr>
					<td class="header"><b>Accounts</b></td>
				</tr>
			</table>
		</div>
		<div id = "users">
			<table class = "users">		
			<?php
			  $result = readUsersDB();
			   while($row = mysqli_fetch_array($result))
			   {
				   $name = $row['UserName'];
				   if($name != "admin")
				   {
					   echo("<tr class='users'>");
					   echo("<td class='users'>");
					   echo("<a href='javascript:sendDataUser(\"$name\");'>".$row['LastName'].",".$row['FirstName']."</a>");
					   echo("</td>");
					   echo("</tr>");
				   }
			   }
			 ?>
			</table>
		</div>
		
		<div id="spacer">
		</div>
		
		<div>
			<table class="header">
				<tr>
					<td class="header"><b>Tests</b></td>
				</tr>
			</table>
		</div>
		<div id = "users">
			<table class = "users">
			<?php
			   $result = readTestListDB();
			   while($row = mysqli_fetch_array($result))
			   {
					  $testName = $row['TestName'];
					   echo("<tr class='users'>");
					   echo("<td class='users'>");
					   echo("<a href='javascript:sendDataTest(\"$testName\");'>".$row['TestName']."</a>");
					   echo("</td>");
					   echo("</tr>");
			   }
			 ?>
			 </table>
        </div>
	</div>		
	    <div>
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
		   <td>&nbsp;&nbsp;&nbsp;
		   </td>
		   <td>
	    <div id="top">
		     <div id="ajaxResponse">
			     <script type="text/javascript">
                   if(start == true)
				   { 
			      </script>
					     <?php
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
								
								$result = readDateDB();	    							
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
						 ?>
				  <script type="text/javascript">
				   }
                  </script>
			 
			 </div>
        </div>

</body>
</html>
