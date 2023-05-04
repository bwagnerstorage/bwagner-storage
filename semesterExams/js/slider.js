function doSlider()
{ 
    $(function() {

	  $('#slider1').bjqs({
		height      : 500,        // 400 x 533
		width       : 633,
		animduration    : 0,      // length of transition
        animspeed       : 0,     // delay between transitions
		automatic   : false,
		responsive  : true,
		showmarkers : false,
		usecaptions : false     // enable/disable captions using img title attribute	
	  });

	});
	
	$(function() {

	  $('#slider2').bjqs({
		height      : 500,
		width       : 633,
		animduration    : 0,      // length of transition
        animspeed       : 0,     // delay between transitions
		automatic   : false,
		responsive  : true,
		showmarkers : false,
		usecaptions : false     // enable/disable captions using img title attribute		
	  });

	});
	
	$(function() {

	  $('#slider3').bjqs({
		height      : 500,
		width       : 633,
		animduration    : 0,      // length of transition
        animspeed       : 0,     // delay between transitions
		automatic   : false,
		responsive  : true,
		showmarkers : false,
		usecaptions : false     // enable/disable captions using img title attribute		
	  });

	});
	
	$(function() {

	  $('#slider4').bjqs({
		height      : 500,
		width       : 633,
		animduration    : 0,      // length of transition
        animspeed       : 0,     // delay between transitions
		automatic   : false,
		responsive  : true,
		showmarkers : false,
		usecaptions : false     // enable/disable captions using img title attribute		
	  });

	});
	
	$(function() {

	  $('#slider5').bjqs({
		height      : 500,
		width       : 633,
		animduration    : 0,      // length of transition
        animspeed       : 0,     // delay between transitions
		automatic   : false,
		responsive  : true,
		showmarkers : false,
		usecaptions : false     // enable/disable captions using img title attribute		
	  });

	});
	
	$(function() {

	  $('#slider6').bjqs({
		height      : 500,
		width       : 633,
		animduration    : 0,      // length of transition
        animspeed       : 0,     // delay between transitions
		automatic   : false,
		responsive  : true,
		showmarkers : false,
		usecaptions : false     // enable/disable captions using img title attribute		
	  });

	});
	
	
}

function doScrollTop()
{
   document.getElementById('content').scrollTop = 0;
}

function getSolution(url)
{
	if (typeof(Storage) !== "undefined") {
		window.sessionStorage.url = url;
	}
}