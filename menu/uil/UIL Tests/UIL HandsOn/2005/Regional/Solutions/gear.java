/*
 * UIL 2005 solution template
 */
public class gear {

	public static void main(String[] args) {
		int num_datasets;
		UILFileReader input = new UILFileReader("gear.in");
		
		/* Read the number of data sets */
		num_datasets = input.readInt();
		
		/* Process each data set */
		for (int ds=0; ds<num_datasets; ds++) {
		    
            // We will index the gears from left to right starting at 0
            // Use invalid values as initializers to aid in debugging
            int index_one = -1;       
            int index_nine = -1;
            
			// Look through the set of gears, recording indicies of gears 1 and 9
            for (int i=0; i<9; i++) {
                switch (input.readInt()) {
                    case 1:
                        index_one = i;
                        break;
                    case 9:
                        index_nine = i;
                        break;
                }
            }

            // determine if gears 1 and 9 are going in the same direction
            boolean same_direction = false;
            if ((Math.abs(index_one - index_nine) % 2) == 0) {
                same_direction = true;
            }
            
            // read gear 1's direction and display gear 9's direction
            String direction_one = input.readLine();
            if ((direction_one.equals("CLOCKWISE") && same_direction) ||
                (direction_one.equals("COUNTER-CLOCKWISE") && !same_direction)) {
                System.out.println("CLOCKWISE");
            }
            else {
                System.out.println("COUNTER-CLOCKWISE");
            }
		}
		
		return; /* end of main() */
	}
}
