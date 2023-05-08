/*
 * UIL 2005 solution: copier
 */
public class copier {

	public static void main(String[] args) {
		int num_datasets;
		UILFileReader input = new UILFileReader("copier.in");
		
		/* Read the number of data sets */
		num_datasets = input.readInt();
		
		/* Process each data set */
		for (int ds=0; ds<num_datasets; ds++) {
			
			/* Read in the current data set */
			String line = input.readLine();
			
			/* Change this to binary */
			line = line.replace('.','1');
			line = line.replace('-','0');
			
			/* Break it into triples */
			String num1c = line.substring(0,3);
			String num2c = line.substring(3,6);
			String num3c = line.substring(6,9);
			String num4c = line.substring(9,12);
			String num5c = line.substring(12,15);
			
			/* Translate the triples into decimal */
			int num1i = Integer.parseInt(num1c,2);
			int num2i = Integer.parseInt(num2c,2);
			int num3i = Integer.parseInt(num3c,2);
			int num4i = Integer.parseInt(num4c,2);
			int num5i = Integer.parseInt(num5c,2);
			
			/* Output the results */
			System.out.println(num1i+""+num2i+""+num3i+""+num4i+""+num5i);
		}
	}
}
