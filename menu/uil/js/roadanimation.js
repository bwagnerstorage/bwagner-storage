
var animCount = 1;

function moveCopy1() {
    var elem = document.getElementById("background2");
    var elem1 = document.getElementById("buffer");
    var elem2 = document.getElementById("code1");
    var elem3 = document.getElementById("code2");
    var comment = document.getElementById("comment");
    
    elem.style.visibility = "visible";
    elem2.style.visibility = "hidden";
    elem3.style.visibility = "visible";
    
    comment.innerHTML = "Make a copy of the background<br>" +
                        "image and store it in copy.";
    
    var topPos = 210;
    var id = setInterval(frame, 15);
    function frame() 
    {

        if (topPos === 2) 
        {
            clearInterval(id);
            document.getElementById("animateNext").disabled = false;
        } 
        else 
        {
            topPos--; 
            elem.style.top = topPos + 'px';  
        }
    }
    
}

function moveCopy2()
{
    var elem2 = document.getElementById("background3"); 
    var elem3 = document.getElementById("code2");
    var elem4 = document.getElementById("code3");
    
    var topPos = 2;
    var leftPos = 60;
    var part2 = false;
    
    comment.innerHTML = "Draw copy onto the background<br>" + 
                        "image positioned SCROLL_<br>" + 
                        "SPEED units to the left of its<br>" + 
                        "original position. It is positioned<br>"+
                        "to the left because SCROLL_<br>"+ 
                        "SPEED is a negative number.";
    
    elem2.style.visibility = "visible";
    elem3.style.visibility = "hidden";
    elem4.style.visibility = "visible";

    var id = setInterval(frame, 15);
    function frame() 
    {
        if(part2 === false)
        {
            if (leftPos === 30) 
            {
                clearInterval(id);
                part2 = true;
                id = setInterval(frame, 15);
            } 
            else 
            {
                leftPos--; 
                elem2.style.left = leftPos + 'px';  
            }
        }
        else
        {
            if(topPos === 210) 
            {
                clearInterval(id);
                document.getElementById("animateNext").disabled = false;

            } 
            else
            {
                topPos++; 
                elem2.style.top = topPos + 'px';  
            }
        }
    }
}

function moveCopy3() 
{
    var elem = document.getElementById("background2"); 
    var elem2 = document.getElementById("background4"); 
    var elem3 = document.getElementById("code3");
    var elem4 = document.getElementById("code4");
    var comment = document.getElementById("comment");
    
    elem2.style.top = elem.style.top;
    elem2.style.left = elem.style.left;
    var topPos = 2;
    var leftPos = 30;
    var part2 = false;
    
    comment.innerHTML = "Draw copy onto the background<br>" + 
                        "image again with its position<br>" +
                        "located at the right side of the<br>"+
                        "background image so that the<br>"+
                        "space vacated by the moving<br>"+
                        "background is filled with the <br>"+
                        "front section of the background<br>"+
                        "image.";
    
    elem2.style.visibility = "visible";
    elem3.style.visibility = "hidden";
    elem4.style.visibility = "visible";

    var id = setInterval(frame, 15);
    function frame() 
    {
        if(part2 === false)    
        {
            if (leftPos === 327) 
            {
                clearInterval(id);
                id = setInterval(frame, 15);
                part2 = true;
            } 
            else
            {
                leftPos++;
                elem2.style.left = leftPos + 'px';  
            }
        }
        else
        {
            if (topPos === 210) 
            {
                clearInterval(id);
                document.getElementById("animateNext").disabled = false;

            } 
            else
            {
                topPos++; 
                elem2.style.top = topPos + 'px';  
            }
        }
    }  
}

function moveCopy4() 
{
    var elem = document.getElementById("background5");
    var elem2 = document.getElementById("background3"); 
    var elem3 = document.getElementById("background4"); 
    var comment = document.getElementById("comment");

    comment.innerHTML = "This new background image can<br>"+
                        "now be displayed.";

    fadeOut(elem2, elem3);
    elem.style.visibility = "visible";
    document.getElementById("animateNext").disabled = false;
}

function fadeOut(element1, element2) {
    var op = 1;  // initial opacity
    var timer = setInterval(function () {
        if (op <= 0.1){
            clearInterval(timer);
            element1.style.display = 'none';
            element2.style.display = 'none';
        }
        element1.style.opacity = op;
        element1.style.filter = 'alpha(opacity=' + op * 100 + ")";
        element2.style.opacity = op;
        element2.style.filter = 'alpha(opacity=' + op * 100 + ")";
        op -= op * 0.1;
    }, 75);
}

function unfade(element1, element2) {
    var op = 0.1;  // initial opacity
    element1.style.display = 'block';
    element2.style.display = 'block';
    var timer = setInterval(function () {
        if (op >= 1){
            clearInterval(timer);
        }
        element1.style.opacity = op;
        element1.style.filter = 'alpha(opacity=' + op * 100 + ")";
        element2.style.opacity = op;
        element2.style.filter = 'alpha(opacity=' + op * 100 + ")";
        op += op * 0.1;
    }, 10);
}

function resetAnimation()
{
    document.getElementById("animateNext").disabled = false;
    animCount = 1;
    document.getElementById("background1").style.visibility = "visible";
    document.getElementById("background2").style.visibility = "hidden";
    document.getElementById("background3").style.visibility = "hidden";
    document.getElementById("background4").style.visibility = "hidden";
    document.getElementById("background5").style.visibility = "hidden";
    
    document.getElementById("background2").style.top = "210px";
    document.getElementById("background2").style.left = "60px";
    
    document.getElementById("background3").style.top = "2px";
    document.getElementById("background3").style.left = "60px";
    
    unfade(document.getElementById("background3"), document.getElementById("background4"));
    
    document.getElementById("code1").style.visibility = "visible";
    document.getElementById("code2").style.visibility = "hidden";
    document.getElementById("code3").style.visibility = "hidden";
    document.getElementById("code4").style.visibility = "hidden";
    comment.innerHTML = "";
}

function advanceAnimation()
{
    document.getElementById("animateNext").disabled = true;
    if(animCount === 1)
    {
        moveCopy1();
    }
    if(animCount === 2)
    {
        moveCopy2();
    }
    if(animCount === 3)
    {
        moveCopy3();
    }
    if(animCount === 4)
    {
        moveCopy4();
    }
    animCount++;
    
}


