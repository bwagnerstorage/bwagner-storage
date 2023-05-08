/*
 * UIL 2005 solution template
 */
public class word {

	public static void main(String[] args) {
		int num_datasets;
		UILFileReader input = new UILFileReader("word.in");
		
		/* Read the number of data sets */
		num_datasets = input.readInt();
		
		/* Process each data set */
		for (int ds=0; ds<num_datasets; ds++) {

			/* Read in the current data set */
			String line = input.readLine();
			
			/* Process the current data set */
			String words[] = line.split(" ");
						
			/* Build the target word */
			String target_word = "";
			for (int curword = 0; curword < words.length; curword++) {
				target_word = target_word.concat(words[curword].substring(0,1));
			}
			
			/* Output the result */
			if (words[0].equalsIgnoreCase(target_word)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		
		return; /* end of main() */
	}
}
