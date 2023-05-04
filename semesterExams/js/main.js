   var goButton;
   var myWorker;
   
   function initializeSortAnalyzer()
   {
      goButton = document.querySelector('#myButton');
   
   if (window.Worker) 
   {  
      myWorker = new Worker('js/worker.js');

      goButton.onclick = function() 
      {
         
         document.getElementById("result").innerHTML="";
         let sortList = document.getElementById("sorts");
         let sortName = sortList.options[sortList.selectedIndex].value;
         let size = document.getElementById("data");
         let sizeAmount = size.value;
         let caseTest = document.getElementById("case");
         let caseName = caseTest.value;
         myWorker.postMessage([sortName, sizeAmount, caseName]);
      }

      myWorker.onmessage = function(e)
      {   
         document.getElementById("result").innerHTML = e.data;
         var answer = '';
         answer += e.data;
         //if(answer.substring(0,1) !== "S")
            //myWorker.terminate();
      }
   }
}