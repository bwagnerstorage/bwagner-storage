<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Review Test</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<BASE href="http://bwagner.org/menu/ap/APTester/">
<link rel="stylesheet" href="../css/TakeTest.css">

<script type="text/javascript" src="../scripts/pdfobject.js"></script>

<script type="text/javascript">

function embedPDF()
{
		var file = "data/" + name + ".pdf";
		var myPDF = new PDFObject({ 
	
		  url: file,
		  pdfOpenParams: { pagemode: 'none', scrollbars: '1', toolbar: '0', statusbar: '0', messages: '0', navpanes: '0' }
	
		}).embed("content");  
}
</script>

<?php

function populateKey($answers, $key)
{
    for($r=0; $r < 40; $r++)
	{
	     $c = 0;
         if(substr($answers, $r, 1) === substr($key, $r, 1))
	     {
		     $a = substr($answers, $r, 1);
			 if($a === "A")
			 {
		        $c = "0";
			 }
			 if($a === "B")
			 {
		        $c = "1";
			 }
			 if($a === "C")
			 {
		        $c = "2";
			 }
			 if($a === "D")
			 {
		        $c = "3";
			 }
			 if($a === "E")
			 {
		        $c = "4";
			 }
			
			 $id = $r.$c;
			 echo("<script>");
			 echo("var id = \"$id\"".";");
			 echo("MCTable.rows[\"$r\"].cells[0].className = 'C';");
			 echo("var element = document.getElementById(id);");
		     echo("element.className = 'selected';"); 
			 
			 echo("</script>");
			 
			
		 }
		 
		 if(substr($answers, $r, 1) != substr($key, $r, 1))
	     {
		     if(substr($answers, $r, 1) != "S")
			 {
				 $a = substr($answers, $r, 1);
				 if($a === "A")
					$c = "0";
				 if($a === "B")
					$c = "1";
				 if($a === "C")
					$c = "2";
				 if($a === "D")
					$c = "3";
				 if($a === "E")
					$c = "4";
				
				 $id = $r.$c;
				 echo("<script>");
				 echo("var id = \"$id\"".";");
				 echo("var element = document.getElementById(id);");
				 echo("element.className = 'selected';");
				 echo("</script>");	 
			 }

		     $a = substr($key, $r, 1);
			 if($a === "A")
		        $c = "0";
			 if($a === "B")
		        $c = "1";
			 if($a === "C")
		        $c = "2";
			 if($a === "D")
		        $c = "3";
			 if($a === "E")
		        $c = "4";
			
			 $id = $r.$c;
			 echo("<script>");
			 echo("var id = \"$id\"".";");
			 echo("var element = document.getElementById(id);");
		     echo("element.className = 'incorrect';");
			 echo("</script>");
		 }
	}
}

function readKeyFile($testName)
{
    $file=fopen("data/".$testName." key.txt","r") or exit("Unable to open file!");
	$keyString = "";
	
	while(!feof($file))
    { 
	   $keyString = $keyString . fgets($file);
    }	
	fclose($file);
	
	$keyString = str_replace("\n", "", $keyString);  // remove returns from string
	
	return $keyString;
}
?>

</head>

<body>

<?php
    $testName = $_POST['name'];
	$answers = $_POST['answers'];
	$score = $_POST['score'];
	
	$key = readKeyFile($testName);
	
	echo("<script>");
	echo("var name = \"$testName\"".";");
	echo("var answers = \"$answers\"".";");
	echo("var key = \"$key\"".";");
	echo("var score = \"$score\"".";");
	echo("</script>");
?>

<div id="container"> 
  <div id="right"> 
    <div id="righttop"> 
      <script type="text/javascript">
	document.write("<table class='score'><tr>");
	document.write("<td>" + "score = " + score);
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
	   document.write("<td class='U'><div><b>" + num + "</b></div></td>");
	   for(var c=0; c < 5; c++)
	   {
		  var bName;
		  if(c==0) bName = "A";
		  if(c==1) bName = "B";
		  if(c==2) bName = "C";
		  if(c==3) bName = "D";
		  if(c==4) bName = "E";
		  
		  var itemID = r.toString() + c;

		  document.write("<td><button class='unselected' id= " + itemID + "><b>" + bName + "</b></button></td>");
	   }
	   document.write("</tr>");
	}

	document.write("</table>");
	</script>
    </div>
    <div id="rightBottom2"> 
      <table>
        <tr> 
          <td align="center" valign="middle"> <form method="post" name="data" action="SelectTest.php">
              <input name="submit" type="submit" value="  Continue  ">
            </form></td>
        </tr>
      </table>
    </div>
  </div>
  <div id="content"> 
    <script>
	window.onload = embedPDF; 
</script>
  </div>
</div>
  
<?php populateKey($answers, $key); ?>  
</body>
</html>
