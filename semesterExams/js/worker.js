var speedQ = "sorting";
var countQ = 0;

onmessage = function(e) {
   let result = getUserResponse(e.data[0], e.data[1], e.data[2]); 
   
   // response 

   postMessage(result[0] + " seconds");
 }

 
function getUserResponse(sortName, sizeAmount, caseName)
{
   speedQ = "Populating Array...";
   postMessage(speedQ);
   let dataSet=[];
   if(caseName === "average")
      dataSet = createAverageCaseDataSet(sizeAmount);
   if(caseName === "worst")
      dataSet = createWorstCaseDataSet(sizeAmount);
   if(caseName === "best")
      dataSet = createBestCaseDataSet(sizeAmount);

      speedQ = "Sorting Array...";

   return doSort(sortName, dataSet);
}

function doSort(name, dataSet)
{
   let time;
   
   if(name === "bubble")
   {
      time = bubbleSort(dataSet);
   }
   if(name === "selection")
   {
      time = selectionSort(dataSet);
   }
   if(name === "insertion")
   {
      time = insertionSort(dataSet);
   }
   if(name === "merge")
   {
      time = mergeSortStarter(dataSet);
   }
   if(name === "quick")
   {
      time = quickSortStarter(dataSet);
   }

   let result = [time];
   return result;
}

function bubbleSort(numbers)
{
   let temp;
   let done;

   const startTime =  new Date();
   let speed = "Sorting Array...";
   postMessage(speed);
   let count = 0;

   do
   {
      done = true;
      for(let i = 0; i < numbers.length-1; i++)
      {
          if (numbers[i] > numbers[i + 1])
          {            
              // swap
              temp = numbers[i];
              numbers[i] = numbers[i+1];
              numbers[i+1] = temp;
              done = false;             // made a swap
          }        
      }
      count++;
      if(count % 5000 == 0)
      {
         speed += ".";
         postMessage(speed);
      }        
   } 
   while (!done);

   stopTime = new Date();
   let time = (stopTime.getTime() - startTime.getTime()) / 1000;
   if(time < 1)
      return time;
   else
   {
      const start = Math.round(startTime / 1000); 
      const stop  = Math.round(stopTime / 1000);
      return (stop - start);
   }
}

function selectionSort(numbers)
{
   let min, temp;

   const startTime =  new Date();
   let speed = "Sorting Array...";
   postMessage(speed);
   let count = 0;

   for (let i = 0; i < numbers.length-1; i++)
   {
      min = i;
      for (let j = i+1; j < numbers.length; j++)
      {
         if (numbers[j] < numbers[min])
            min = j;
      }
      // swap
      temp = numbers[i];
      numbers[i] = numbers[min];
      numbers[min] = temp;
   
      count++;
      if(count % 5000 == 0)
      {
         speed += ".";
         postMessage(speed);
      }  
    }

    stopTime = new Date();
    let time = (stopTime.getTime() - startTime.getTime()) / 1000;
    if(time < 1)
       return time;
    else
    {
       const start = Math.round(startTime / 1000); 
       const stop  = Math.round(stopTime / 1000);
       return (stop - start);
    }
}

function insertionSort(numbers)
{
   let index;

   const startTime =  new Date();
   let speed = "Sorting Array...";
   postMessage(speed);
   let count = 0;

   for (let i=1; i < numbers.length; i++)
   {
      index = numbers[i];
      let j = i;
      while ((j > 0) && (numbers[j-1] > index))
      {
          numbers[j] = numbers[j-1];
          j = j - 1;
      }
      numbers[j] = index;

      count++;
      if(count % 5000 == 0)
      {
         speed += ".";
         postMessage(speed);
      }  
   }

   stopTime = new Date();
   let time = (stopTime.getTime() - startTime.getTime()) / 1000;
   if(time < 1)
      return time;
   else
   {
      const start = Math.round(startTime / 1000); 
      const stop  = Math.round(stopTime / 1000);
      return (stop - start);
   }
}

function quickSortStarter(numbers)
{
   const startTime =  new Date();
   speedQ = "Sorting Array...";
   countQ = 0;
   postMessage(speedQ);

   let left = 0;
   let right = numbers.length-1;

   quickSort(numbers, left, right);

   stopTime = new Date();
   let time = (stopTime.getTime() - startTime.getTime()) / 1000;
   if(time < 1)
      return time;
   else
   {
      const start = Math.round(startTime / 1000); 
      const stop  = Math.round(stopTime / 1000);
      return (stop - start);
   }
}

function quickSort(a, left, right)
{ 
   if(left >= right)
      return;  
   let i = left;
   let j = right;
   let pivotValue = a[Math.floor((left + right) / 2)];   // choose middle as pivot 
   
   while(i < j)
   {
       // Starting from left side of partition
       // find the first value that is greater than pivot.
       while(a[i] < pivotValue)
          i++; 
		    
       // Starting from right side of partition
       // find the first value that is less than the pivot.
       while(a[j] > pivotValue)
          j--;
		   
       // Swap the two values
       if(i <= j)
       {   
          let temp = a[i];
          a[i] = a[j];
          a[j] = temp;
          i++;
          j--;
       }
       countQ++;
       if(countQ % 10000000 == 0)
       {
          speedQ += ".";
          postMessage(speedQ);
       } 
    }

    // Recursively partition the list
    quickSort(a, left, j);
    quickSort(a, i, right);

    return a;
}

function mergeSortStarter(numbers)
{
   const startTime =  new Date();
   let speedQ = "Sorting Array...";
   postMessage(speedQ);
   countQ = 0;

   let result = mergeSort2(numbers);

   stopTime = new Date();
   let time = (stopTime.getTime() - startTime.getTime()) / 1000;
   if(time < 1)
      return time;
   else
   {
      const start = Math.round(startTime / 1000); 
      const stop  = Math.round(stopTime / 1000);
      return (stop - start);
   }
}

function merge(left, right){
   var result = [],
       lLen = left.length,
       rLen = right.length,
       l = 0,
       r = 0;
   while(l < lLen && r < rLen){
      if(left[l] < right[r]){
        result.push(left[l++]);
      }
      else{
        result.push(right[r++]);
     }
     countQ++;
     if(countQ % 10000000 == 0)
     {
        speedQ += ".";
        postMessage(speedQ);
     }
   }  
   //remaining part needs to be added to the result
   return result.concat(left.slice(l)).concat(right.slice(r));
 }

function mergeSort(arr)
{
   var len = arr.length;
   if(len <2)
      return arr;
   var mid = Math.floor(len/2),
       left = arr.slice(0,mid),
       right =arr.slice(mid);
   //send left and right to the mergeSort to break them down into pieces
   //then merge those
   return merge(mergeSort(left),mergeSort(right));
}

//iterative merge sort algorithm
function mergeSort2(arr) 
{
   var sorted = arr.slice(),
         n = sorted.length,
         buffer = new Array(n);
   
   for (var size = 1; size < n; size *= 2) {
      for (var leftStart = 0; leftStart < n; leftStart += 2*size) {
         var left = leftStart,
            right = Math.min(left + size, n),
            leftLimit = right,
            rightLimit = Math.min(right + size, n),
            i = left;
         while (left < leftLimit && right < rightLimit) {
         if (sorted[left] <= sorted[right]) {
            buffer[i++] = sorted[left++];
         } else {
            buffer[i++] = sorted[right++];
         }
         }
         while (left < leftLimit) {
         buffer[i++] = sorted[left++];
         }
         while (right < rightLimit) {
         buffer[i++] = sorted[right++];

         countQ++;
         if(countQ % 10000000 == 0)
         {
            speedQ += ".";
            postMessage(speedQ);
         }

         }
      }
      var temp = sorted,
         sorted = buffer,
         buffer = temp;
   }
   
   return sorted;
}


function createBestCaseDataSet(size)
{
   let array = [];
   for(let i=0; i<size; i++)
   {
      array[i] = i;

      if(i % 1000000 == 0)
      {
         speedQ += ".";
         postMessage(speedQ);
      } 
   }
   return array;
}

function createWorstCaseDataSet(size)
{
   let array = [];
   let j=0;
   for(let i = size-1; i >= 0;  i--)
   {
      array[i] = j;
      j++;

      if(i % 1000000 == 0)
      {
         speedQ += ".";
         postMessage(speedQ);
      } 
   }
   return array;
}

function createAverageCaseDataSet(size)
{
   let array = [];
   for(let i=0; i<size; i++)
   {
      array[i] = Math.floor(Math.random() * size);

      if(i % 1000000 == 0)
      {
         speedQ += ".";
         postMessage(speedQ);
      } 
   }
   return array;
}
