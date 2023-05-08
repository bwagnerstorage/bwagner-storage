/*
 * UIL 2005 solution template
 */
public class juggle {
	static int MAX_BALLS = 40;
	public static void main(String[] args) {
		int num_datasets;
		int balls[] = new int[MAX_BALLS];
		int numBallsDropped, height, step;
		boolean dropped;
		String sequence;
		UILFileReader input = new UILFileReader("juggle.in");
		
		/* Read the number of data sets */
		num_datasets = input.readInt();
				
		/* Process each data set */
		for (int ds=0; ds<num_datasets; ds++) {
			balls = new int[MAX_BALLS];
			for (int i=0; i < MAX_BALLS; i++)
				balls[i] = -1;
		
			sequence = input.readLine();
		
			dropped = false;
			for (step = 0; step < sequence.length(); step++)
			{
				numBallsDropped = 0;
				/* Check how many balls have dropped */
				for (int i=0; i<MAX_BALLS; i++)
					if (--balls[i] == 0)
						numBallsDropped++;
			
				if (numBallsDropped > 1)
				{
					System.out.println("DROPPED " + (numBallsDropped - 1) + " on step " + (step + 1));
					dropped = true;
					break;
				}
				
				height = Integer.parseInt(sequence.substring(step, step + 1));
				
				if (height != 0)
					for (int i=0; i < MAX_BALLS; i++)
						if (balls[i] <= 0)
						{
							balls[i] = height;
							break;
						}
			}
			
			if (!dropped)
			{
				for (int lastStep=0; lastStep<10; step++, lastStep++)
				{				
					numBallsDropped = 0;
					for (int i=0; i<MAX_BALLS; i++)
						if (--balls[i] == 0)
							numBallsDropped++;
				
					if (numBallsDropped > 1)
					{
						System.out.println("DROPPED " + (numBallsDropped - 1) + " on step " + (step + 1));
						dropped = true;
						break;
					}
				}
			}
			
			if (!dropped)
				System.out.println("VALID");
		}
		
		return; /* end of main() */
	}
}
