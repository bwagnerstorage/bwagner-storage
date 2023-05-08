/*
 * UIL 2005 solution template
 */
public class brain {

	public static void main(String[] args) {
		int num_datasets;
		UILFileReader input = new UILFileReader("brain.in");
		
		/* Read the number of data sets */
		num_datasets = input.readInt();
		
		/* Process each data set */
		for (int ds=0; ds<num_datasets; ds++) {
			String lineA, lineB;
			String answer = "";
			
			/* Read in the current data set */
			lineA = input.readLine();
			lineB = input.readLine();
			
			/* Process the current data set */
			for (int i=0; i<18; i++) {
				if (lineA.charAt(i) == lineB.charAt(i)) {
					answer = answer.concat(lineA.substring(i,i+1));
				}
				else {
					answer = answer.concat("*");
				}
			}
			
			/* Output the result */
			System.out.println(answer);
		}
		
		return; /* end of main() */
	}
}
