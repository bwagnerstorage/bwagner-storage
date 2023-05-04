        	   var prev = 0;
				var count = 1;
				var loopCount = 1;
				var sum = 0;
				var done = false;

            function advanceWhile()
            {	
                if(done === false)
                {
                    document.getElementById("box1").innerHTML = loopCount;
                    document.getElementById("box2").innerHTML = sum;
                    document.getElementById("box3").innerHTML = "&nbsp;";
                    document.getElementById("c"+ count).style.background = "yellow";
                    if(prev > 0)
                       document.getElementById("c"+ prev).style.background = "white";
                    if(loopCount === 1)
                    {
                        document.getElementById("box1").style.visibility = "visible";
                        document.getElementById("box1").style.borderWidth = "2px";
                        document.getElementById("var1").style.visibility = "visible";
                    }
                    if(count === 2)
                    {
                        document.getElementById("box2").innerHTML = "0";
                        document.getElementById("box2").style.visibility = "visible";
                        document.getElementById("box2").style.borderWidth = "2px";
                        document.getElementById("var2").style.visibility = "visible";
                    }
                    if(count === 3)
                    {
                        if(loopCount < 11)
                        {
                            document.getElementById("box3").innerHTML = "true";
                            document.getElementById("box3").style.visibility = "visible";
                            document.getElementById("box3").style.borderWidth = "2px";
                            document.getElementById("condition").style.visibility = "visible";
                        }
                        else
                        {
                            done = true;
                            count = 0;
                            document.getElementById("c3").style.background = "yellow";
                            document.getElementById("box3").innerHTML = "false";
                            document.getElementById("box3").style.background = "red"; 
                        }
                    }
                    
                    prev = count;
                    count++;
                    if(count > 5)
                    {
                        count = 3;
                    }
                    if(count === 4)
                    {
                        sum += loopCount;
                    }
                    if(count === 5)
                    {
                        loopCount++;
                    }
                    
                }
                else  // done == false
                {
                    document.getElementById("c3").style.background = "white";
                    document.getElementById("c6").style.background = "yellow";
                }
            }
			
			function advanceFor()
            {
                if(done === false)
                {
                    document.getElementById("box2").innerHTML = loopCount;
                    document.getElementById("box1").innerHTML = sum;
                    document.getElementById("box3").innerHTML = "&nbsp;";
                    document.getElementById("c"+ count).style.background = "yellow";
                    if(prev > 0)
                       document.getElementById("c"+ prev).style.background = "white";
                    if(loopCount === 1)
                    {
                        document.getElementById("box1").style.visibility = "visible";
                        document.getElementById("box1").style.borderWidth = "2px";
                        document.getElementById("var1").style.visibility = "visible";
                    }
                    if(count === 2)
                    {
                        document.getElementById("box2").innerHTML = "1";
                        document.getElementById("box2").style.visibility = "visible";
                        document.getElementById("box2").style.borderWidth = "2px";
                        document.getElementById("var2").style.visibility = "visible";
                    }
                    if(count === 3)
                    {
                        if(loopCount < 11)
                        {
                            document.getElementById("box3").innerHTML = "true";
                            document.getElementById("box3").style.visibility = "visible";
                            document.getElementById("box3").style.borderWidth = "2px";
                            document.getElementById("condition").style.visibility = "visible";
                        }
                        else
                        {
                            done = true;
                            count = 0;
                            document.getElementById("c3").style.background = "yellow";
                            document.getElementById("box3").innerHTML = "false";
                            document.getElementById("box3").style.background = "red"; 
                        }
                    }
                    
                    prev = count;
                    count++;
                    if(count > 5)
                    {
                        count = 3;
                    }
                    if(count === 4)
                    {
                        sum += loopCount;
                    }
                    if(count === 5)
                    {
                        loopCount++;
                    }
                    
                }
                else  // done == false
                {
                    document.getElementById("c3").style.background = "white";
                    document.getElementById("c6").style.background = "yellow";
                }
            }
            
            function reset()
            {
                prev = 0;
                count = 1;
                loopCount = 1;
                sum = 0;
                done = false;
                
                for(i = 1; i <= 6; i++)
                {
                   document.getElementById("c"+ i).style.background = "white"; 
                }
                
                document.getElementById("box1").style.visibility = "hidden";
                document.getElementById("var1").style.visibility = "hidden";
                document.getElementById("box2").style.visibility = "hidden";
                document.getElementById("var2").style.visibility = "hidden";
                document.getElementById("box3").style.visibility = "hidden";
                document.getElementById("condition").style.visibility = "hidden";
                document.getElementById("box3").style.background = "white";
                document.getElementById("box1").style.borderWidth = "0";
                document.getElementById("box2").style.borderWidth = "0";
                document.getElementById("box3").style.borderWidth = "0";
            }
			
			function pad(n, width, z) {
				z = z || '0';
				n = n + '';
				return n.length >= width ? n : new Array(width - n.length + 1).join(z) + n;
			}
			
			var counterDemo = 0;
			var countDemoVar = setInterval(function(){CounterDemo();},100);
			
			function CounterDemo() {
				counterDemo++;
				if(document.getElementById("CounterDemo") != null)
				    document.getElementById("CounterDemo").innerHTML = "&nbsp" + pad(counterDemo, 8);
			}
			
			
			function advanceNested()
            {
                if(done === false)
                {
                    document.getElementById("nestedbox1").innerHTML = cntr;
                    document.getElementById("nestedbox2").innerHTML = i;
                    document.getElementById("nestedbox3").innerHTML = j;
                    document.getElementById("nestedbox4").innerHTML = "&nbsp;";
                    document.getElementById("nestedbox5").innerHTML = "&nbsp;";
                    
                    document.getElementById("c"+ array[loopCount]).style.background = "yellow";
                    if(loopCount > 0)
                       document.getElementById("c"+ array[prev]).style.background = "white";
                    if(loopCount === 0)
                    {
                        document.getElementById("nestedbox1").style.visibility = "visible";
                        document.getElementById("nestedbox1").style.borderWidth = "2px";
                        document.getElementById("var1").style.visibility = "visible";
                    }
                    if(loopCount === 1)
                    {
                        document.getElementById("nestedbox2").style.visibility = "visible";
                        document.getElementById("nestedbox2").style.borderWidth = "2px";
                        document.getElementById("var2").style.visibility = "visible";
                    }
                    if(loopCount === 2)
                    {
                        document.getElementById("condition1").style.visibility = "visible";
                        document.getElementById("nestedbox4").style.visibility = "visible";
                        document.getElementById("nestedbox4").style.borderWidth = "2px";
                    }
                    if(loopCount === 3)
                    {
                        document.getElementById("nestedbox3").style.visibility = "visible";
                        document.getElementById("nestedbox3").style.borderWidth = "2px";
                        document.getElementById("var3").style.visibility = "visible";
                    }
                    if(loopCount === 4)
                    {
                        document.getElementById("condition2").style.visibility = "visible";
                        document.getElementById("nestedbox5").style.visibility = "visible";
                        document.getElementById("nestedbox5").style.borderWidth = "2px";
                    }
                    
                    if(array[loopCount] === 8)
                    {
                        j++;
                    }
                    if(array[loopCount] === 4)
                    {
                        document.getElementById("nestedbox5").style.background = "white";
                        document.getElementById("nestedbox3").style.visibility = "hidden";
                        document.getElementById("var3").style.visibility = "hidden";
                        document.getElementById("nestedbox5").style.visibility = "hidden";
                        document.getElementById("condition2").style.visibility = "hidden";
                        j=0;
                    }
                    if(array[loopCount] === 5)
                    {
                        j=0;
                        document.getElementById("nestedbox3").style.visibility = "visible";
                        document.getElementById("var3").style.visibility = "visible";
                        document.getElementById("nestedbox5").style.visibility = "visible";
                        document.getElementById("condition2").style.visibility = "visible";
                    }

                    if(array[loopCount] === 3)
                    {
                        if(i < 5)
                        {
                            document.getElementById("nestedbox4").innerHTML = "true";
                            document.getElementById("nestedbox4").style.background = "white";
                        }
                        else
                        {
                            document.getElementById("nestedbox4").innerHTML = "false";
                            document.getElementById("nestedbox4").style.background = "red";
                        }
                    }
                    if(array[loopCount] === 6)
                    {
                        
                        if(j < 5)
                        {
                            document.getElementById("nestedbox5").innerHTML = "true";
                            document.getElementById("nestedbox5").style.background = "white";
                            cntr++;  
                        }
                        else
                        {
                            document.getElementById("nestedbox5").innerHTML = "false";
                            document.getElementById("nestedbox5").style.background = "red";
                            i++;  
                        }
                    }
                    if(array[loopCount] === 9)
                    {
                        document.getElementById("nestedbox4").style.background = "white";
                        document.getElementById("nestedbox2").style.visibility = "hidden";
                        document.getElementById("var2").style.visibility = "hidden";
                        document.getElementById("nestedbox4").style.visibility = "hidden";
                        document.getElementById("condition1").style.visibility = "hidden";
                    }
                    
                    
                    prev = loopCount;

                    loopCount++;  
                }

            }
            
            function resetNested()
            {
                array = [1,2,3,5,6,8,7,6,8,7,6,8,7,6,8,7,6,8,7,6,
                         4,3,5,6,8,7,6,8,7,6,8,7,6,8,7,6,8,7,6,
                         4,3,5,6,8,7,6,8,7,6,8,7,6,8,7,6,8,7,6,
                         4,3,5,6,8,7,6,8,7,6,8,7,6,8,7,6,8,7,6,
                         4,3,5,6,8,7,6,8,7,6,8,7,6,8,7,6,8,7,6,4,3,9];
                prev = 0;
                cntr = 0;
                loopCount = 0;
                i = 0;
                j = 0;
                done = false;
                
                for(var x = 1; x <= 9; x++)
                {
                   document.getElementById("c"+ x).style.background = "white"; 
                }
                
                document.getElementById("nestedbox1").style.visibility = "hidden";
                document.getElementById("var1").style.visibility = "hidden";
                document.getElementById("nestedbox2").style.visibility = "hidden";
                document.getElementById("var2").style.visibility = "hidden";
                document.getElementById("nestedbox3").style.visibility = "hidden";
                document.getElementById("var3").style.visibility = "hidden";
                document.getElementById("nestedbox4").style.visibility = "hidden";
                document.getElementById("nestedbox5").style.visibility = "hidden";
                document.getElementById("condition1").style.visibility = "hidden";
                document.getElementById("condition2").style.visibility = "hidden";
                document.getElementById("nestedbox4").style.background = "white";
                document.getElementById("nestedbox5").style.background = "white";

                document.getElementById("nestedbox1").style.borderWidth = "0";
                document.getElementById("nestedbox2").style.borderWidth = "0";
                document.getElementById("nestedbox3").style.borderWidth = "0";                
                document.getElementById("nestedbox4").innerHTML = "false";
                document.getElementById("nestedbox5").innerHTML = "false";
            }
         
        function updateColor(id, newValue)
        {
                var red = document.getElementById("redSlider").getAttribute("value");
                var green = document.getElementById("greenSlider").getAttribute("value");
                var blue = document.getElementById("blueSlider").getAttribute("value");
                
                if(id === "redSlider")
                {
                    red = newValue;
                }
                if(id === "greenSlider")
                {
                    green = newValue;
                }
                if(id === "blueSlider")
                {
                    blue = newValue;
                }
                document.getElementById(id).setAttribute("value", newValue);
                document.getElementById("colorBox").style.backgroundColor= "rgb("+red+","+green+","+blue+")";
                
                if(red < 128 && green < 128 && blue < 128)
                {
                    document.getElementById("colorBox").style.color = "rgb(255,255,255)";
                }
                else
                {
                    document.getElementById("colorBox").style.color = "rgb(0,0,0)";
                }
                
                document.getElementById("colorBox").innerHTML = "" + red + " " + green + " " + blue;

        }
        