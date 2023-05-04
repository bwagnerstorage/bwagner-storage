public class Trail
{
	/** Representation of the trail. The number of markers on the trail is markers.length. */
	private int[] markers;
	
	public Trail(int[] list)
	{
		markers = list;
	}
	
	public boolean isLevelTrailSegment(int start, int end)
	{ 
	   int max = markers[start];
	   int min = markers[start];
	   
	   for(int i=start; i < end; i++)
	   {
	   	  max = Math.max(markers[i], max);
	   	  min = Math.min(markers[i], min);
	   }
	   
	   if(max - min <= 10)
	      return true;
	   else
	      return false;
	
	}
	
	public boolean isDifficult()
	{
	   int count = 0;
	   for(int i=0; i < markers.length -1; i++)
	   {
	   	  if(Math.abs(markers[i] - markers[i+1]) >= 30)
	   	     count++;
	   }
	   
	   if(count >= 3)
	      return true;
	   else
	      return false;	
		
	}
	
}