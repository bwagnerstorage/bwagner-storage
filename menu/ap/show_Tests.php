<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<BASE href="http://bwagner.org">
<link rel="stylesheet" href="menu/ap/css/Admin.css">
<title>Tests Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<script type="text/javascript" language="javascript">

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

function handleAjaxResponse(response)
{
  document.getElementById('ajaxResponse').innerHTML = response;
}
</script>

<?php
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

?>
</head>

<body bgcolor="#EAEAEA">
<table>
<tr>
<td>
<div id="tests">
<?php
echo("<table class='test' width='100%'>");
	echo("<tr>");
	    echo("<td class='header'><b>User Name</b></td>");
		echo("<td class='header'><b>Test Name</b></td>");
		echo("<td class='header'><b>Type</b></td>");
		echo("<td class='header'><b>Status</b></td>");
		echo("<td class='header'><b>Completed</b></td>");
		echo("<td class='header'><b>Score</b></td>");
	echo("</tr>");
	
	   $result = readTestsDB();
	   while($row = mysqli_fetch_array($result))
	   { 
		   echo("<tr class='test'>");
		      echo("<td class='test'>"."&nbsp;&nbsp;&nbsp;".$row['UserName']."</td>");
			  echo("<td class='test'>"."&nbsp;&nbsp;&nbsp;".$row['TestName']."</td>");
			  echo("<td class='test' align='center'>".$row['Type']."</td>"); 
			  echo("<td class='test' align='center'>".$row['Status']."</td>");
			  echo("<td class='test' align='center'>".$row['CompleteDate']."</td>");
			  echo("<td class='test' align='center'>".$row['Score']."</td>");
		   echo("</tr>");
	   } 
	   echo("</table>");
?>
</div>
</td>
<td valign="top">
	    <form method="post" name="submit" action="menu/ap/do_removeTest.php">
		<table>
		   <tr>
		      <td>TestName</td>
		   </tr>
		   <tr>
		      <td><input name="testName" type="text"></td>
		   </tr>
		   <tr>
		      <td><input name="submit" type="submit" value="Remove All Tests"></td>
		   </tr>
		   <tr>
		      <td>UserName</td>
		   </tr>
		   <tr>
		      <td><input name="userName" type="text"></td>
		   </tr>
		   <tr>
		      <td><input name="submit" type="submit" value="Remove User Test"></td>
		   </tr>
		</table>
		</form>
	</td>
</tr>
</table>
<br>
<div align="left">
<FORM METHOD="LINK" ACTION="menu/ap/show_adminPage.php">
<INPUT TYPE="submit" VALUE=" Return to Admin ">
</FORM>
</div>
</body>
</html>
