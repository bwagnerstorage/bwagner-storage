/*
 * UIL 2005 solution template
 */
public class assembly {
	
	public static void main(String[] args) {
		String set_label[] = {"A","B","C","D","E","F","G","H","I"};
		int num_datasets;
		UILFileReader input = new UILFileReader("assembly.in");
		
		/* Read the number of data sets */
		num_datasets = input.readInt();
		
		/* Process each data set */
		int screw_gt_count[] = new int[9];
		for (int ds=0; ds<num_datasets; ds++) {
			
			/* Read in the current data set */
			// First get the number of types of screws
			int num_screw_types = input.readInt();
			
			// Now read in the screw comparison tables and count the number of '>'s
			for (int i=0; i<num_screw_types; i++) {
				String line = input.readLine();
				screw_gt_count[i] = 0;
				for (int j=0; j<line.length(); j++) {
					if (line.substring(j,j+1).equals(">")) {
						screw_gt_count[i]++;
					}
				}
			}
			
			// read the list of screw sizes
			String size_line = input.readLine();
			
			// read the target size
			String target_size = input.readLine();
			
			/* Process the current data set */
			// where is the target_size in the size_line?
			int target_index;
			String sizes[] = size_line.split(" ");
			for (target_index = 0; target_index < num_screw_types; target_index++) {
				if (sizes[target_index].equals(target_size)) break;
			}
			
			// what pile has the right number of '>'s?
			int target_num_gts = num_screw_types - target_index - 1;
			
			/* Output the result */
			for (int i=0; i<num_screw_types; i++) {
				if (screw_gt_count[i] == target_num_gts) System.out.println("SET " + set_label[i]);
			}			
		}
		
		return; /* end of main() */
	}
}
