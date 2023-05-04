<?
if(!$_POST[userName])
{
   header("Location: http://bwagner.org/menu/ap/show_Accounts.php");
   exit;
}

$connection = @mysqli_connect("localhost", "bnwagner_ap", "Kolty0624") or die(mysqli_error());
$db_name = "bnwagner_APTester";
$table_name = "table_users";

$dbl = @mysqli_select_db($connection, $db_name) or die(mysqli_error());

$lastName = $_POST['lastName'];
$firstName = $_POST['firstName'];
$userName = $_POST['userName'];
$password = $_POST['password'];
		
if(isset($lastName) && isset($firstName) && isset($password))
{
    $sql = "UPDATE $table_name SET LastName = '$lastName', FirstName = '$firstName',  Password = '$password'
        WHERE UserName = '$userName'";
}
else if(isset($lastName) && isset($password))
{
    $sql = "UPDATE $table_name SET LastName = '$lastName',  Password = '$password'
        WHERE UserName = '$userName'";
}
else if(isset($firstName) && isset($password))
{
    $sql = "UPDATE $table_name SET FirstName = '$firstName',  Password = '$password'
        WHERE UserName = '$userName'";
}
else if(isset($lastName))
{
    $sql = "UPDATE $table_name SET LastName = '$lastName'
        WHERE UserName = '$userName'";
}
else if(isset($firstName))
{
    $sql = "UPDATE $table_name SET FirstName = '$firstName'
        WHERE UserName = '$userName'";
}
else if(isset($password))
{
    $sql = "UPDATE $table_name SET Password = '$password'
        WHERE UserName = '$userName'";
}

$result = @mysqli_query($sql, $connection) or die(mysqli_error());

   header("Location: http://bwagner.org/menu/ap/show_Accounts.php");
   exit;

?>

<html>
<head>
<title>Edit Account</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body>

</body>
</html>
