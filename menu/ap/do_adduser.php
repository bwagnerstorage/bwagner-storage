<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<?

if((!$_POST[username]) || (!$_POST[password]) || (!$_POST[l_name]) || (!$_POST[f_name]))
{
  header("Location: http://bwagner.org/menu/ap/show_adduser.html");
  exit;
}

$db_name = "bnwagner_APTester";
$table_name = "table_users";
$connection = @mysqli_connect("localhost", "bnwagner_ap", "Kolty0624") or die(mysqli_error());
$db = @mysqli_select_db($connection, $db_name) or die(mysqli_error());
$sql = "INSERT INTO $table_name (UserName, Password, LastName, FirstName)
        VALUES ('$_POST[username]', '$_POST[password]', '$_POST[l_name]',
		password('$_POST[f_name]'))";
		
$result = @mysqli_query($sql, $connection) or die(mysqli_error());

?>

<html>
<head>
<title>Add a User</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
<body>
<h1>Added to auth_users:</h1>
<p><STRONG>First Name:</STRONG><br>
   <? echo "$_POST[f_name]"; ?>
</p>
<p><STRONG>Last Name:</STRONG><br>
   <? echo "$_POST[l_name]"; ?>
</p>
<p><STRONG>Username:</STRONG><br>
   <? echo "$_POST[username]"; ?>
</p>
<p><STRONG>Password:</STRONG><br>
   <? echo "$_POST[password]"; ?>
</p>
<p><a href="http://bwagner.org/menu/ap/show_adduser.html">Add Another</a></p>
</body>
</html>
