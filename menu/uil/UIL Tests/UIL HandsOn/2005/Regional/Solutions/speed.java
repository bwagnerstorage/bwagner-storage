/*
 * UIL 2005 solution template
 */
public class speed {

	public static void main(String[] args) {
		int num_datasets;
		UILFileReader input = new UILFileReader("speed.in");
		
		/* Read the number of data sets */
		num_datasets = input.readInt();
		
		/* Process each data set */
		for (int ds=0; ds<num_datasets; ds++) {
			
			/* Read in the current data set */
			if (((double)input.readInt())/((double)input.readInt()) > 55)
				System.out.println("SPEEDING TICKET");
			else
				System.out.println("NO SPEEDING TICKET");
		}
	}
}
