///////////////////////////////
// File:        dvr.java     //
// Programmer:  Marc Douet   //
// Date:        03/14/04     //
///////////////////////////////

import java.util.*;
	                     
public class dvr
{
    public static UILFileReader    input = new UILFileReader("dvr.dat");
    public static int              numShows, 
	                           numTimes, 
	                           showIndex, 
	                           timeIndex, 
	                           showTimeIndex, 
	                           matchingShowIndex, 
	                           numRecordedShows, 
	                           numUniqueTimes;
    public static final int        MAX_SHOWS = 100,
	                           MAX_TIMES = 100;
    public static int[]            times = new int[MAX_TIMES];
    public static String[]         recordedShows = new String[MAX_SHOWS];
    public static Show[]           matchingShows = new Show[MAX_SHOWS];
    public static Show[]           shows = new Show[MAX_SHOWS];
		
		
    /*
     * Use a bubble sort algorithm to sort the passed-in list of times in ascending order.
     */
    public static void sortByTime(int timeList[])
    {
        boolean swap;
        int     index;
   
        while(true)
        {
            swap = false;
            for(index = 0; index < numUniqueTimes; index++)
            {
                if(index == numUniqueTimes-1)
                {
                    break;
                }
                
                if(timeList[index] > timeList[index+1])
                {
                    int temp = timeList[index];
                    timeList[index] = timeList[index+1];
                    timeList[index+1] = temp;
                    swap = true;
                }
            }
            
            if(!swap)
            {
                break;
            }
        }
    }
           
    
    /* 
     * Use a bubble sort algorithm to sort the passed-in Show list by priority and 
     * print the show with the lowest (best) priority that hasn't been recorded yet. 
     */
    public static void getHighestPriority(Show showList[])
    {
        boolean swap;
        int     index, showIndex;
   
        while(true)
        {
            swap = false;
            for(index = 0; index < matchingShowIndex; index++)
            {
                if(index == matchingShowIndex-1)
                {
                    continue;
                }
                
                if(showList[index].priority > showList[index+1].priority)
                {
                    Show temp = showList[index];
                    showList[index] = showList[index+1];
                    showList[index+1] = temp;
                    swap = true;
                }
            }
            
            if(!swap)
            {
                break;
            }
        }
        
        for(showIndex = 0; showIndex < matchingShowIndex; showIndex++)
        {
            for(index = 0; index < numRecordedShows; index++)
            {
                if(showList[showIndex].title.equals(recordedShows[index]))
                {
                    break;
                }
            }
            
            if(index >= numRecordedShows)
            {
                System.out.println(showList[showIndex].title);
                recordedShows[numRecordedShows++] = new String(showList[showIndex].title);
                break;
            }
	  }
    }
    
    
    public static void main(String[] args)
    {
        numShows = Integer.parseInt(input.readWord());
        numTimes = Integer.parseInt(input.readWord());
        numUniqueTimes = 0;
        numRecordedShows = 0;
        matchingShowIndex = 0;
        
        for(showIndex = 0; showIndex < numShows; showIndex++)
        {
            shows[showIndex] = new Show();
        }	
		
        for(timeIndex = 0; timeIndex < numTimes; timeIndex++)
        {
            times[timeIndex] = 0;
        }
			
        while( input.ready())
        {	                
            /* 
             * Read in the title and priority of each show. 
             */
            for(showIndex = 0; showIndex < numShows; showIndex++)
            {
                shows[showIndex].priority = showIndex;
                shows[showIndex].title = input.readLine();
            }
             
            /* 
             * Read in the times and what shows are playing at each time. 
             */
            for(int index = 0; index < numTimes; index++)
            {
                int time = Integer.parseInt(input.readWord());
                String title = new String(input.readLine());
                
                for(timeIndex = 0; timeIndex < index; timeIndex++)
                {
                    if(times[timeIndex] == time)
                    {
                        break;
                    }
                }
                
                if(timeIndex >= index)
                {
                    times[numUniqueTimes++] = time;
                } 
                
                for(showIndex = 0; showIndex < numShows; showIndex++)
                {
                    if(shows[showIndex].title.equals(title))
                    {
                        shows[showIndex].times[shows[showIndex].timeIndex++] = time;
                        break;
                    }
                }
            }
            
            /* 
             * Sort the list of times so we know the order the shows should be recorded. 
             */
            sortByTime(times);       
           
            /* 
             * Find the shows that match each time and print the one with the highest priority. 
             */
            for(timeIndex = 0; timeIndex < numUniqueTimes; timeIndex++)
            {
                for(showIndex = 0; showIndex < numShows; showIndex++)
                {
                    for(showTimeIndex = 0; showTimeIndex < shows[showIndex].timeIndex; showTimeIndex++)
                    {
                        if(shows[showIndex].times[showTimeIndex] == times[timeIndex])
                        {
                            matchingShows[matchingShowIndex++] = shows[showIndex];
                            break;
                        }
                    }
                }
                
                /*
                 * Print the show in this time slot with the lowest (best) priority
                 * that hasn't been recorded yet.
                 */
                getHighestPriority(matchingShows);
                matchingShowIndex = 0;
            }
        }
    }
}


/*
 * This class is merely a structure that allows for easy sorting
 * of show times and priorities.
 */
class Show {

    private final int  MAX_TIMES = 100;
    public int[]       times = new int[MAX_TIMES];
    public int         timeIndex;
    public int         priority;
    public String      title;
    
    
    public Show()
    {
        title = new String("\0");
        priority = -1;
        timeIndex = 0;
        for(int index = 0; index < 100; index++)
        {
            times[index] = 0;
        }
    }
}