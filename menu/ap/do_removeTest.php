<?
if(!$_POST[testName])
{
   header("Location: http://bwagner.org/menu/ap/show_Tests.php");
   exit;
}

$connection = @mysqli_connect("localhost", "bnwagner_ap", "Kolty0624") or die(mysqli_error());
$db_name = "bnwagner_APTester";
$table_name = "table_tests";

$dbl = @mysqli_select_db($connection, $db_name) or die(mysqli_error());

$userName = $_POST['userName'];
$testName = $_POST['testName'];

if(isset($testName) && isset($userName))
{
    $sql = "DELETE FROM $table_name WHERE UserName = '$userName' AND TestName = '$testName'";
}
else if(isset($testName))
{
    $sql = "DELETE FROM $table_name WHERE TestName = '$testName'";
}

$result = @mysqli_query($sql, $connection) or die(mysqli_error());

header("Location: http://bwagner.org/menu/ap/show_Tests.php");
exit;

?>


<html>
<head>
<title>Remove Test</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body>

</body>
</html>
