<?php
   session_start(); 
   
$username = $_POST[username];
$password = $_POST[password];
$verify = $_POST[verify];
 
if((!$password) || (!$verify))
{
   header("Location: http://bwagner.org/menu/ap/show_changePassword.html");
   exit;
}
if(strcmp($password,$verify) != 0)
{
   header("Location: http://bwagner.org/menu/ap/show_changePassword.html");
   exit;
}

$db_name = "bnwagner_APTester";
$table_name = "table_users";
$connection = @mysqli_connect("localhost", "bnwagner_ap", "Kolty0624") or die(mysqli_error());
$db = @mysqli_select_db($connection, $db_name) or die(mysqli_error());

$sql = "SELECT * FROM $table_name 
        WHERE username = '$username'
		AND password = ''";
$result = @mysqli_query($sql, $connection) or die(mysqli_error());
$num = mysqli_num_rows($result);
if($num == 0)
{
   header("Location: http://bwagner.org/menu/ap/show_changePassword.html");
   exit;
}

$sql = "UPDATE $table_name SET Password = '$password'
        WHERE UserName = '$username'";
$result = @mysqli_query($sql, $connection) or die(mysqli_error());

$_SESSION['username']=$username;
header("Location: http://bwagner.org/menu/ap/APTester/SelectTest.php");

function sendData($username)
{
   echo("<script>");
   echo("var username = new String('$userame');");
   echo("document.data.username.value = username;");
   echo("document.data.submit();");
   echo("</script>");
}

?>

<html>
<head>
<title>Change Password</title>
</head>
<body>
</body>
</html>
