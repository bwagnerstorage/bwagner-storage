import java.io.File;
import java.io.IOException;
import java.util.*;

public class Little {

    private static final String[] ourRanks = {"Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
        "Queen", "King", "Ace"};
    private static final String[] ourSuits = {"Spades", "Clubs", "Diamonds", "Hearts"};

    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("little.dat"));
        ArrayList<String> ranks = new ArrayList<String>();
        for(String st : ourRanks)
            ranks.add(st);
        ArrayList<String> suits = new ArrayList<String>();
        for(String st : ourSuits)
            suits.add(st);
        int numSets = s.nextInt();
        s.nextLine();
        for(int i = 1; i <= numSets; i++){
            int numCards = s.nextInt();
            s.nextLine();
	    boolean pair = false;
            boolean flush = false;
            boolean highCard = false;
	    int low = 0;
	    int high = 0;
	    int newLow = 0;
            int newHigh = 0;
	    int count = 0;
            for(int j = 0; j < numCards; j++){
                String[] parts = s.nextLine().split("[,\\s]+");
                assert parts.length == 6;
		String rank1 = parts[0].trim();
		String rank2 = parts[3].trim();
                String suit1 = parts[2].trim();
		String suit2 = parts[5].trim();
		newLow = (ranks.indexOf(rank1) < ranks.indexOf(rank2) ? 
			ranks.indexOf(rank1) : ranks.indexOf(rank2));
		newHigh = (ranks.indexOf(rank1) > ranks.indexOf(rank2) ? 
			ranks.indexOf(rank1) : ranks.indexOf(rank2));
       		if (newLow==newHigh){
			if (!pair){
				high = newHigh;
				pair = true;
				count = 1;
			}
			else if (newHigh==high)  
				count++;
			else if (newHigh>high){
				high = newHigh;
				count = 1;
			}
		}
		else if (!pair && suits.indexOf(suit1)==suits.indexOf(suit2)){
			
			if (!flush){
				low = newLow;
				high = newHigh;
				flush = true;
				count = 1;
			}
			else if (newHigh > high){
				low = newLow;
				high = newHigh;
				count= 1;
			}
			else if (newHigh==high && newLow > low){
				low = newLow;
				high = newHigh;
				count = 1;
			}
			else if (newHigh==high && newLow==low){
				count++;
			}
		}
		else if (!pair && !flush){
			if (!highCard){
				low = newLow;
				high = newHigh;
				highCard = true;
				count = 1;
			}
			else if (newHigh > high){
				low = newLow;
				high = newHigh;
				count= 1;
			}
			else if (newHigh==high && newLow > low){
				low = newLow;
				high = newHigh;
				count = 1;
			}
			else if (newHigh==high && newLow==low){
				count++;
			}
		}
				
            }
            if( pair)
                System.out.println("PAIR " + count);
            else if (flush)
                System.out.println("FLUSH " + count);
	    else
		System.out.println("HIGH CARD " + count);
        }
        s.close();
    }
}