/* 
	PDFObject, copyright (C) 2008 Philip Hutchison (pipwerks.com)
	Documentation and examples are at www.pdfobject.com 
	Version 1.0, September 2008
	MIT style license
*/

var pipwerks=pipwerks||{};
pipwerks.pdfUTILS={termFound:function(a,b){return(a.indexOf(b)!==-1)},detect:{hasReaderActiveX:function(){var a=null;
if(window.ActiveXObject)
{
    a=new ActiveXObject("AcroPDF.PDF");
    if(!a)
	{
	     a=new ActiveXObject("PDF.PdfCtrl")}if(a!==null){return true}}return false},hasReader:function(){var a=pipwerks.pdfUTILS.termFound;
var n=navigator.plugins;
for(var i=0;i<n.length;i++){var b=n[i].name;
if(a(b,"Adobe Reader")||a(b,"Adobe PDF")||a(b,"Acrobat")){return true}}return false},hasGeneric:function(){var a=navigator.mimeTypes["application/pdf"];
return(a&&a.enabledPlugin)},pluginFound:function(){var a=null;
var b=pipwerks.pdfUTILS.detect;
if(b.hasReader()||b.hasReaderActiveX()){a="Adobe"}else if(b.hasGeneric()){a="generic"}return a}},setCssForFullWindowPdf:function(){if(!document.getElementsByTagName){return false}var a=document.getElementsByTagName("html");
if(!a){return false}var c=a[0];
c.style.height="100%";
c.style.overflow="hidden";
var b=document.body;b.style.margin="0";
b.style.padding="0";
b.style.height="100%";
b.style.overflow="hidden"},buildQueryString:function(a){var b="";
if(!a){return b}for(var c in a){if(a.hasOwnProperty(c)){b+=c+"=";
if(c==="search"){b+=encodeURI(a[c])}else{b+=a[c]}b+="&"}}return b.slice(0,b.length-1)}};
pipwerks.pdfObject=function(a){if(!document.getElementById||!a.url){return false}this.url=encodeURI(a.url)+"#";
this.id=a.id||false;this.width=a.width||"100%";this.height=a.height||"100%";this.pdfOpenParams=a.pdfOpenParams;this.url+=pipwerks.pdfUTILS.buildQueryString(this.pdfOpenParams);this.pluginTypeFound=pipwerks.pdfUTILS.detect.pluginFound();this.pdfobjectversion="1.0";return this};pipwerks.pdfObject.prototype.get=function(a){var b=null;switch(a){case"url":b=this.url;break;case"id":b=this.id;break;case"width":b=this.width;break;case"height":b=this.height;break;case"pdfOpenParams":b=this.pdfOpenParams;break;case"pluginTypeFound":b=this.pluginTypeFound;break;case"pdfobjectversion":b=this.pdfobjectversion;break}return b};pipwerks.pdfObject.prototype.embed=function(a){if(!this.pluginTypeFound){return false}if(!document.createElement||!document.getElementById){return false}var b=/*@cc_on!@*/false;var c=null;if(a){c=document.getElementById(a);if(!c){return false}}else{c=document.body;pipwerks.pdfUTILS.setCssForFullWindowPdf();this.width="100%";this.height="100%"}var d;if(b){d=document.createElement("<object classid='CLSID:CA8A9780-280D-11CF-A24D-444553540000'>")}else{d=document.createElement("object")}d.setAttribute("type","application/pdf");
d.setAttribute("data",this.url);
d.setAttribute("width",this.width);
d.setAttribute("height",this.height);
if(this.id){d.setAttribute("id",this.id)}if(c.hasChildNodes){while(c.childNodes.length>0){c.removeChild(c.firstChild)}}c.appendChild(d);
return d};
var PDFObject=pipwerks.pdfObject;