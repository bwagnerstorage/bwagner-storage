<?php
    $db_name = "bnwagner_APTester";
    $table_name = "table_tests";
    $connection = @mysqli_connect("localhost", "bnwagner_ap", "Kolty0624") or die(mysqli_error());
    $dbl = @mysqli_select_db($connection, $db_name) or die(mysqli_error());

	$sql = "SELECT * from $table_name";
	$result = @mysqli_query($sql, $connection) or die(mysqli_error());

	// loop through results
	while($row = mysqli_fetch_array($result))
	{
	   $output = "<p>".$row['']. "<br>"
		  .$row['UserName']. "<br>"
		  .$row['TestName']. "<br>"
		  .$row['Type']. "<br>"
		  .$row['Status']. "<br>"
		  .$row['NumQuestions']. "<br>"
		  .$row['NumCorrect']. "<br>"
		  .$row['NumIncorrect']. "<br>"
		  .$row['NumSkips']. "<br>"
		  .$row['Score']. "<br>"
		  .$row['Answers']. "<p>";
		  
		  echo ("$output");
	}

?>

<html>
<head>
<title>View Tests</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body>

</body>
</html>
