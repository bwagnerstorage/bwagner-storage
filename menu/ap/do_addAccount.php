<?
if(!$_POST[lastName] || !$_POST[firstName] || !$_POST[userName])
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

$sql = "INSERT INTO $table_name (LastName, FirstName, UserName, Password)
        VALUES ('$lastName', '$firstName', '$userName', '$password')";

$result = @mysqli_query($sql, $connection) or die(mysqli_error());

   header("Location: http://bwagner.org/menu/ap/show_Accounts.php");
   exit;

?>


<html>
<head>
<title>Add Account</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body>

</body>
</html>
