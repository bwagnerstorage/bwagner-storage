var count = 0;  // used to give unique id to anchor tags in tree
var previousAnchorID;
var flip = false;

function buildTree(dname)
{
	xmlDoc=loadXMLDoc(dname);

	unit=xmlDoc.getElementsByTagName("unit");
	for (u=0;u<unit.length;u++)
	{
	   unitName = unit[u].getElementsByTagName("unitName");
	   document.write('<li><span class="folder">'+unitName[0].childNodes[0].nodeValue+'</span>');  
	   category = unit[u].getElementsByTagName("category");
	   for(c=0;c<category.length;c++)
	   {
	       categoryName = category[c].getElementsByTagName("categoryName");
		   document.write('<ul><li><span class="folder">'+categoryName[0].childNodes[0].nodeValue+'</span>');
		   description = category[c].getElementsByTagName("description");
		   url = category[c].getElementsByTagName("url");
		   document.write('<ul id="folder">');
		   for(d=0; d<description.length; d++)
		   {
		      var str = url[d].childNodes[0].nodeValue;
			  
			  count=count+1;
			  var id = "id"+count;
			  var n=str.search(".html");
              document.write('<li><span class="file">');
			  if(n != -1)
			  {
              	 document.write('<a id='+id+' href="javascript:void()" onclick="javascript:sendRequest(\''+url[d].childNodes[0].nodeValue+'\', \'content\', id)">'); 
			  }
			  else
			  {
			      document.write('<a href=\''+url[d].childNodes[0].nodeValue+'\' target="_blank">');
			  }
			  document.write(description[d].childNodes[0].nodeValue+'</a></span></li>');
   		   }
		   document.write('</ul></li></ul>');
	   }
	   document.write('</li>');	   
    }
	document.write('<br>');	
}

function loadXMLDoc(dname)
{ 
	if (window.XMLHttpRequest)
	{
	  xhttp=new XMLHttpRequest();
    }
	else
    {
	  xhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
	
	xhttp.open("GET",dname,false);
	xhttp.send();
	
	return xhttp.responseXML;
}

function collapseLeftSide()
{
    if(flip === false)
    {
        document.getElementById("leftside").style.display = "none";
        document.getElementById("collapseButton").innerHTML = "expand";
        document.getElementById("content").style.width = "982px";
        flip = true;
    }
    else
    {
        document.getElementById("leftside").style.display = "block";
        document.getElementById("collapseButton").innerHTML = "collapse";
        document.getElementById("content").style.width = "702px";
        flip = false;
    }
}