
import java.io.File;
import java.io.IOException;
import java.util.*;

public class PrettyHands {

    private static final String[] ourRanks = {"Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
        "Queen", "King", "Ace"};
    private static final String[] ourSuits = {"Spades", "Clubs", "Diamonds", "Hearts"};

    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("prettyhands.dat"));
        ArrayList<String> ranks = new ArrayList<String>();
        for(String st : ourRanks)
            ranks.add(st);
        ArrayList<String> suits = new ArrayList<String>();
        for(String st : ourSuits)
            suits.add(st);
        final int FACE_CARD_INDEX = ranks.indexOf("Jack");
        final int RED_INDEX = suits.indexOf("Diamonds");

        int numSets = s.nextInt();
        s.nextLine();
        for(int i = 1; i <= numSets; i++){
            int numCards = s.nextInt();
            s.nextLine();
            boolean allRed = true;
            boolean allFace = true;
            for(int j = 0; j < numCards; j++){
                String[] parts = s.nextLine().split("\\s+");
                assert parts.length == 3;
                String rank = parts[0].trim();
                String suit = parts[2].trim();
                if(ranks.indexOf(rank) < FACE_CARD_INDEX)
                    allFace = false;
                if(ranks.indexOf(rank) >= FACE_CARD_INDEX || suits.indexOf(suit) < RED_INDEX)
                    allRed = false;
            }
            if( allRed || allFace)
                System.out.println("PRETTY");
            else
                System.out.println("NOT PRETTY");
        }
        s.close();
    }
}