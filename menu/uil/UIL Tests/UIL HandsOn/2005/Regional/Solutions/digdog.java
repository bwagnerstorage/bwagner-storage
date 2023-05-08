/*
 * UIL 2005 solution template
 */
public class digdog {

	public static void main(String[] args) {
		int num_datasets;
		UILFileReader input = new UILFileReader("digdog.in");
		
		/* Read the number of data sets */
		num_datasets = input.readInt();
		
		/* Process each data set */
		for (int ds=0; ds<num_datasets; ds++) {

			/* Read in the current data set */
			
			/*   start with the size of the yard */
			int yard_size = input.readInt();
			
			/*   now read in the yard */
			String yard[] = new String[yard_size];
			for (int i=0; i<yard_size; i++) {
				yard[i] = input.readLine();
			}
			
			/* Process the current data set - by looking where the dog dug */
			boolean owner_happy = true;
			for (int i=0; i<yard_size; i++) {
				String dig_line = input.readLine();
				for (int j=0; j<yard_size; j++) {
					if (dig_line.charAt(j) == 'X' && (yard[i].charAt(j) != '.')) {
						owner_happy = false;
					}
				}
			}
			
			/* Output the result */
			if (owner_happy) {
				System.out.println("GOOD DOG");
			}
			else {
				System.out.println("BAD DOG");
			}
		}
	}
}
