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

$userName = $_POST['userName'];

$sql = "DELETE FROM $table_name WHERE UserName = '$userName'";

$result = @mysqli_query($sql, $connection) or die(mysqli_error());

$connection = @mysqli_connect("localhost", "bnwagner_ap", "Kolty0624") or die(mysqli_error());
$db_name = "bnwagner_APTester";
$table_name = "table_tests";

$dbl = @mysqli_select_db($connection, $db_name) or die(mysqli_error());

$userName = $_POST['userName'];

$sql = "DELETE FROM $table_name WHERE UserName = '$userName'";

$result = @mysqli_query($sql, $connection) or die(mysqli_error());

header("Location: http://bwagner.org/menu/ap/show_Accounts.php");
exit;

?>


<html>
<head>
<title>Remove Account</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body>

</body>
</html>
