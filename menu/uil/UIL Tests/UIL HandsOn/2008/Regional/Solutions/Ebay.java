import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class Ebay {

	public static void main(String args[]) throws IOException
	{

		Scanner kb = new Scanner(new File("ebay.dat"));

		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			String t[] = kb.nextLine().trim().split(" ");
			double startPrice = Double.parseDouble(t[0]);
			double salePrice = 0;
			double oldInsertFee, oldFinalValueFee, oldTotalFee;
			double newInsertFee, newFinalValueFee, newTotalFee;
			if(startPrice < 1) {
				oldInsertFee = .20;
				newInsertFee = .15;
			}else if(startPrice < 10) {
				oldInsertFee = .40;
				newInsertFee = .35;
			}else if(startPrice < 25) {
				oldInsertFee = .60;
				newInsertFee = .55;	 
			}else if(startPrice < 50) {
				oldInsertFee = 1.20;
				newInsertFee = 1.00;	 
			}else if(startPrice < 200) {
				oldInsertFee = 2.40;
				newInsertFee = 2.00;	 
			}else if(startPrice < 500) {
				oldInsertFee = 3.60;
				newInsertFee = 3.00;	 
			}else {
				oldInsertFee = 4.80;
				newInsertFee = 4.00;
			}	
			if(t[1].equals("NOT")) {
				oldFinalValueFee = 0;
				newFinalValueFee = 0;
			}
			else {
				salePrice = Double.parseDouble(t[1]); 
				if(salePrice <= 25.00) {
					oldFinalValueFee = .0525 * salePrice;
					newFinalValueFee = .0875 * salePrice;
				} else if(salePrice <= 1000.00) {
					oldFinalValueFee = .0525 * 25 + .0325*(salePrice-25.00);
					newFinalValueFee = .0875 * 25 + .0350*(salePrice-25.00);
				} else {
					oldFinalValueFee = .0525 * 25 + .0325*975.00 + .0150*(salePrice-1000.00);
					newFinalValueFee = .0875 * 25 + .0350*975.00 + .0150*(salePrice-1000.00);
				}
			}
			oldTotalFee = oldInsertFee + oldFinalValueFee;
			newTotalFee = newInsertFee + newFinalValueFee;	
			double difference = Math.abs(oldTotalFee-newTotalFee);
			if(newTotalFee > oldTotalFee)	
				out.printf("More $%.2f\n", difference);
			else if (newTotalFee < oldTotalFee)	
				out.printf("Less $%.2f\n", difference);
			else
				out.printf("Same $%.2f\n", difference);			
		}
	}	
}
