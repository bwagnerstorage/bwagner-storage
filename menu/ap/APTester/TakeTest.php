<?php
   session_start();
   
   $userName = $_SESSION['username'];

	if (!$userName) 
	{
	   header("Location: http://bwagner.org/menu/ap/show_login.html");
	   exit;
	}
?>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Take Test</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<BASE href="http://bwagner.org/menu/ap/APTester/">
<link rel="stylesheet" href="../css/TakeTest.css">

<script type="text/javascript" src="../scripts/pdfobject.min.js"></script>

<script type="text/javascript">
function sendSubmit()
{
   document.data.name.value = name;
   document.data.type.value = type;
   document.data.answers.value = answers;
   document.data.submit();
} 

function sendSave()
{
  // document.save.name.value = name;
  // document.save.type.value = type;
  // document.save.answers.value = answers;
  // document.save.timeRemaining.value = timeRemaining;
   //document.save.submit();
   
   // new stuff (AJAX)
   
   if (window.XMLHttpRequest)
   {   // code for IE7+, Firefox, Chrome, Opera, Safari
       xmlhttp=new XMLHttpRequest();
   }
   else
   {   // code for IE6, IE5
       xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
   }
   
   xmlhttp.open("POST","SelectTest.php",true);
   xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");  
   var data = "name=" + name + "&type=" + type + "&answers=" + answers + "&timeRemaining=" + timeRemaining;
   xmlhttp.send(data); 
} 

function sendSaveOnExit()
{
	if(answers == "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS")
	{
	/* save nothing*/
	document.save.submit();
	}
	else
	{
	  document.save.name.value = name;
	  document.save.type.value = type;
	  document.save.answers.value = answers;
	  document.save.timeRemaining.value = timeRemaining;
	  document.save.submit();
	}
}

function toggleButton(element) 
{
	if (element.className == "unselected") 
		{ element.className = "selected"; }
	else 
		{ element.className = "unselected"; }
}

function makeSelection(element)
{
   var id = element.id;
   var row;
   var col;
   var letter;
   
   // break id up into (row, col) values
   if(id.length == 2)
   {
      row = id.substring(0,1);
	  col = id.substring(1,2);
   }
   else
   {
      row = id.substring(0,2);
	  col = id.substring(2,3);
   }
   
   // convert column value into A-E format
   if(col == "0")
      letter = "A";
   else if(col == "1")
      letter = "B";
   else if(col == "2")
      letter = "C";
   else if(col == "3")
      letter = "D";
   else
      letter = "E";
 
   var end = parseInt(row) + 1;
   var subst = answers.substring(parseInt(row), end);
   var s = answers.substring(0, parseInt(row));
   var e = answers.substring(parseInt(row)+1);
   if(subst == "S")
   { 
	   answers = s + letter + e;
   }
   else if(subst == letter)
   {
       answers = s + "S" + e;
   }
   else
   {
       answers = s + letter + e;
   }
   
   resetRow(row, col);  
   toggleButton(element);
   toggleRow(element, row);
   sendSave();
}

function toggleRow(element, row)
{
	if (element.className == "selected") 
		MCTable.rows[row].cells[0].className = "S";
	else 
		MCTable.rows[row].cells[0].className = "U";
}

function resetRow(row, col)
{
    if(col != "0")
	{
        var element0 = document.getElementById(row+"0");
	    element0.className = "unselected";
	}
	if(col != "1")
	{
		var element1 = document.getElementById(row+"1");
		element1.className = "unselected"; 
	}
	if(col != "2")
	{
		var element2 = document.getElementById(row+"2");
		element2.className = "unselected";
	}
	if(col != "3")
	{
		var element3 = document.getElementById(row+"3");
		element3.className = "unselected";
	}
	if(col != "4")
	{
		var element4 = document.getElementById(row+"4");
		element4.className = "unselected";
    } 
}

function embedPDF()
{
		var file = "data/" + name + ".pdf";
		var myPDF = new PDFObject({ 
	
		  url: file,
		  pdfOpenParams: { pagemode: 'none', scrollbars: '1', toolbar: '0', statusbar: '0', messages: '0', navpanes: '0' }
	
		}).embed("content");  
}
/*
function embedPDF()
{
   var x = document.getElementById("content");
   x.innerHTML = "<iframe src=" + "data/" + name + ".pdf" +  " width=100% height=100% >";
}*/
</script>

<?php

function convertStringsToJS($answersString)
{
   echo("<script>");
   echo("answers = new String('$answersString');");
   echo("</script>");
}

function readDB($userName, $testName)
{
	$db_name = "bnwagner_APTester";
	$table_name = "table_tests";
	$connection = @mysqli_connect("localhost", "bnwagner_ap", "Kolty0624") or die(mysqli_error());
	$db = @mysqli_select_db($connection, $db_name) or die(mysqli_error());
	
	$sql = "SELECT * FROM $table_name WHERE UserName='$userName' AND TestName='$testName'";
	$result = @mysqli_query($sql, $connection) or die(mysqli_error());
	
	return $result;
}

?>

</head>

<body>
<?php
   $userName = $_SESSION['username'];
   $testName = $_POST['testName'];
   $testType = $_POST['testType'];
   $testStatus = $_POST['testStatus'];
   $timeRemaining = $_POST['timeRemaining'];
   
   $result = readDB($userName, $testName);
   $num = mysqli_num_rows($result);
   if($num > 0)
   {
      $row = mysqli_fetch_array($result);
	  $answersString = $row['Answers'];
	  $timeRemaining = $row['TimeRemaining'];
   }
   else
   {
	   $answersString = "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS";
	   $timeRemaining = 2700;   // 45 minutes
   }
   
   echo("<script>");
   echo("name = \"$testName\"".";");
   echo("type = \"$testType\"".";");
   echo("timeRemaining = \"$timeRemaining\"".";");
   echo("</script>");
   
   convertStringsToJS($answersString);
?>
<div id="container"> 
  <div id="right"> 
    <div id="righttop"> 
      <script type="text/javascript">
	
	document.write("<table id='header'><tr>");
	document.write("<td align='left'>");
	document.write("<div id='countdown'></div>");
	document.write("</td>");
	document.write("<td>");
	document.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='image' src = 'img/question.jpg' onClick='window.open(\"data/quickref.pdf\", \"_blank\")'>");
	document.write("</td>");
	document.write("</tr></table>");

	</script>
    </div>
    <div id="rightmiddle"> 
      <script type="text/javascript">
	document.write("<table class='MC' id='MCTable'>");
	for(var r=0; r < 40; r++)
	{  
	   document.write("<tr class='MC'>");
	   var num = r + 1;
	   
	   if(answers.substring(r, r+1) == "S")
	      document.write("<td class='U'><div><b>" + num + "</b></div></td>");
	   else
	      document.write("<td class='S'><div><b>" + num + "</b></div></td>");
		  
	   for(var c=0; c < 5; c++)
	   {
		  var bName;
		  if(c==0) bName = "A";
		  if(c==1) bName = "B";
		  if(c==2) bName = "C";
		  if(c==3) bName = "D";
		  if(c==4) bName = "E";
		  
		  var itemID = r.toString() + c;
		  
		  if(answers.substring(r, r+1) == bName)
		  {
             document.write("<td><button class='selected' id= " + itemID + " onclick = makeSelection(this)><b>" + bName + "</b></button></td>");
		  }	 
		  else
		  {
		     document.write("<td><button class='unselected' id= " + itemID + " onclick = makeSelection(this)><b>" + bName + "</b></button></td>");
		  } 
	   }
	   document.write("</tr>");
	}

	document.write("</table>");
	</script>
    </div>
    <div id="rightBottom"> 
      <table>
        <tr> 
          <td> <form method="post" name="data" action="Score.php">
              <input name="data" type="button" value="Submit " onClick="sendSubmit()" class="btn" onmouseover="this.className='btn btnhov'" onmouseout="this.className='btn'">
              <script>document.write("<input type='hidden' name='name' >");</script>
              <script>document.write("<input type='hidden' name='type' >");</script>
              <script>document.write("<input type='hidden' name='answers' >");</script>
              <script>document.write("<input type='hidden' name='timeRemaining' >");</script>
            </form></td>
          <td> <form method="post" name="save" action="SelectTest.php">
              <input name="save"  type="button" value="  Exit  "  onClick="sendSaveOnExit()" class="btn" onmouseover="this.className='btn btnhov'" onmouseout="this.className='btn'">
              <script>document.write("<input type='hidden' name='name' >");</script>
              <script>document.write("<input type='hidden' name='type' >");</script>
              <script>document.write("<input type='hidden' name='answers' >");</script>
              <script>document.write("<input type='hidden' name='timeRemaining' >");</script>
            </form></td>
          <!--
		   <td align="center" valign="middle">
		   <form method="post" name="exit" action="SelectTest.php">
		       <input name="exit"  value="   Exit   " method="link" type="submit" class="btn" onmouseover="this.className='btn btnhov'" onmouseout="this.className='btn'">

		   </form>
		   
		   </td>
		   -->
        </tr>
      </table>
    </div>
  </div>
  <div id="content"> 
  <IFRAME SRC="data/Test 08 Jan 18 2020.pdf" WIDTH=450 HEIGHT=100></IFRAME>
<script>
	window.onload = embedPDF; 
</script>
  </div>
</div>
<script type="text/javascript">

  function display( notifier, str ) {
    document.getElementById(notifier).innerHTML = str;
  }
	
  function toMinuteAndSecond( x ) {
    return Math.floor(x/60) + ":" + x%60;
  }
	
  function setTimer(actions ) {
    (function countdown() {
       display("countdown", toMinuteAndSecond(timeRemaining));		
       actions[timeRemaining] && actions[timeRemaining]();
       (timeRemaining -= 1) >= 0 && setTimeout(arguments.callee, 1000);
    })();
  }

  setTimer({
  });	

</script>
    
</body>
</html>
