<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<BASE href="http://bwagner.org">
<link rel="stylesheet" href="menu/ap/css/Admin.css">
<title>Admin Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

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
?>
</head>

<body bgcolor="#EAEAEA">
<?php
   $result = readUsersDB();
?>
<table>
   <tr>
	   <td>
			<div>
				<table class="header">
					<tr>
						<td class="header"><b>Accounts</b></td>
					</tr>
				</table>
			</div>
		</td>
		<td>
			<div>
				<table class="header">
					<tr>
						<td class="header"><b>Create Account</b></td>
					</tr>
				</table>
			</div>
		</td>
				<td>
			<div>
				<table class="header">
					<tr>
						<td class="header"><b>Remove Account</b></td>
					</tr>
				</table>
			</div>
		</td>
				<td>
			<div>
				<table class="header">
					<tr>
						<td class="header"><b>Edit Account</b></td>
					</tr>
				</table>
			</div>
		</td>
	</tr>
	<tr>
	   <td>
	    <div id = "accounts">
	    <table class = "users">
		<?php
		   while($row = mysqli_fetch_array($result))
           {
		       $name = $row['UserName'];
			   if($name != "admin")
			   {
				   echo("<tr class='users'>");
				   echo("<td class='users'>");
				   echo($row['LastName'].", ".$row['FirstName']." : ".$row['UserName']);
				   echo("</td>");
				   echo("</tr>");
			   }
		   }
		 ?>
		</table>
     </div>
  </td>
  <td valign="top">
	    <form method="post" name="submit" action="menu/ap/do_addAccount.php">
		<table>
		   <tr>
		      <td>LastName</td>
		   </tr>
		   <tr>
		      <td><input name="lastName" type="text"></td>
		   </tr>
		   <tr>
		      <td>FirstName</td>
		   </tr>
		   <tr>
		      <td><input name="firstName" type="text"></td>
		   </tr>
		   <tr>
		      <td>UserName</td>
		   </tr>
		   <tr>
		      <td><input name="userName" type="text"></td>
		   </tr>
		   <tr>
		      <td>Password</td>
		   </tr>
		   <tr>
		      <td><input name="password" type="text"></td>
		   </tr>
		   <tr>
		      <td><input name="submit" type="submit" value="Create Account"></td>
		   </tr>
		</table>
		</form>
	</td>
	<td valign="top">
	    <form method="post" name="submit" action="menu/ap/do_removeAccount.php">
		<table>
		   <tr>
		      <td>UserName</td>
		   </tr>
		   <tr>
		      <td><input name="userName" type="text"></td>
		   </tr>
		   <tr>
		      <td><input name="submit" type="submit" value="Remove Account"></td>
		   </tr>
		</table>
		</form>
	</td>
	 <td valign="top">
	    <form method="post" name="submit" action="menu/ap/do_editAccount.php">
		<table>
		   <tr>
		      <td>UserName</td>
		   </tr>
		   <tr>
		      <td><input name="userName" type="text"></td>
		   </tr>
		   <tr>
		      <td><hr></td>
		   </tr>
		   <tr>
		      <td>LastName</td>
		   </tr>
		   <tr>
		      <td><input name="lastName" type="text"></td>
		   </tr>
		   <tr>
		      <td>FirstName</td>
		   </tr>
		   <tr>
		      <td><input name="firstName" type="text"></td>
		   </tr>
		   <tr>
		      <td>Password</td>
		   </tr>
		   <tr>
		      <td><input name="password" type="text"></td>
		   </tr>
		   <tr>
		      <td><input name="submit" type="submit" value="Edit Account"></td>
		   </tr>
		</table>
		</form>
	</td>
	  </tr>
</tr></table>
<br>
<div align="left">
<FORM METHOD="LINK" ACTION="menu/ap/show_adminPage.php">
<INPUT TYPE="submit" VALUE=" Return to Admin ">
</FORM>
</div>
</body>
</html>
