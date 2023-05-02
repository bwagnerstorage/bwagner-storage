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
         