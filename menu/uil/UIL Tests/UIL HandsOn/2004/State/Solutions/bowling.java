///////////////////////////////
// File:        bowling.java //
// Programmer:  Marc Douet   //
// Date:        03/14/04     //
///////////////////////////////

import java.util.*;

public class bowling
{
    public static void main(String[] args)
    {	
        UILFileReader  input = new UILFileReader("bowling.dat");
        int            numGames, 
                       totalScore, 
                       firstRoll, 
                       secondRoll, 
                       turn;
        String         pinsKnocked = new String();
        final int      NUM_FRAMES = 10;
        int[]          FrameScore = new int[NUM_FRAMES];
        int[]          FrameStrike = new int[NUM_FRAMES];
        int[]          FrameSpare = new int[NUM_FRAMES];

        numGames = input.readInt();
        while( input.ready())
        {	                
            totalScore = 0;
            for(turn = 0; turn < NUM_FRAMES; turn++)
            {
                FrameScore[turn] = 0;
                FrameStrike[turn] = 0;
                FrameSpare[turn] = 0;
            }
          
            for(turn = 0; turn < NUM_FRAMES; turn++)
            {                                
                pinsKnocked = input.readWord();  
                firstRoll = 0;
                secondRoll = 0;
                
                if(pinsKnocked.equals("X"))
                {
                    if(turn > 0 && FrameStrike[turn-1] > 0)
                    { 
                        FrameScore[turn-1] += 10;
                        FrameStrike[turn-1]++;
                        if(FrameStrike[turn-1] > 2)
                        {
                            FrameStrike[turn-1] = 0;
                        }
                    }
                    
                    if(turn > 1 && FrameStrike[turn-2] > 0)
                    {
                        FrameScore[turn-2] += 10;
                        FrameStrike[turn-2]++;
                        if(FrameStrike[turn-2] > 2)
                        {
                            FrameStrike[turn-2] = 0;
                        }
                    }
                    
                    if(turn > 0 && FrameSpare[turn-1] > 0)
                    {
                        FrameScore[turn-1] += 10;
                        FrameSpare[turn-1] = 0;
                    }
                         
                    FrameStrike[turn]++;
                    FrameScore[turn] = 10;
                         
                    continue;
                } else {
                    firstRoll = Integer.parseInt(pinsKnocked);
                    FrameScore[turn] = firstRoll;
                    pinsKnocked = input.readWord();
                    if(pinsKnocked.equals("/"))
                    {
                        FrameSpare[turn] = 1;
                        FrameScore[turn] = 10;
                        secondRoll = (10 - firstRoll);
                    } else {
                        secondRoll = Integer.parseInt(pinsKnocked);
                        FrameScore[turn] += secondRoll;
                    }
                    
                    if(turn > 1 && FrameStrike[turn-2] > 0)
                    {
                        FrameScore[turn-2] += firstRoll;
                        FrameStrike[turn-2]++;
       
                        if(FrameStrike[turn-2] > 2)
                        {
                            FrameStrike[turn-2] = 0;
                        }
                    }
                    
                    if(turn > 0 && FrameStrike[turn-1] > 0)
                    {
                        FrameScore[turn-1] += firstRoll;
                        FrameStrike[turn-1]++;
                        
                        if(FrameStrike[turn-1] > 2)
                        {
                            FrameStrike[turn-1] = 0;
                        }
                    }
                    
                    if(turn > 1 && FrameStrike[turn-2] > 0)
                    {
                        FrameScore[turn-2] += secondRoll;
                        FrameStrike[turn-2]++;
                        
                        if(FrameStrike[turn-2] > 2)
                        {
                            FrameStrike[turn-2] = 0;
                        }
                    }
                    
                    if(turn > 0 && FrameStrike[turn-1] > 0)
                    {
                        FrameScore[turn-1] += secondRoll;
                        FrameStrike[turn-1]++;
                        
                        if(turn > 0 && FrameStrike[turn-1] > 2)
                        {
                            FrameStrike[turn-1] = 0;
                        }
                    }
                    
                    if(turn > 0 && FrameSpare[turn-1] > 0)
                    {
                        FrameScore[turn-1] += firstRoll;
                        FrameSpare[turn-1] = 0;
                    }
                }     
			}
			
            if(FrameStrike[9] > 0)
            {
                pinsKnocked = input.readWord();
                    
                if(pinsKnocked.equals("X"))
                {
                    FrameScore[9] += 10;
                    firstRoll = 10;

                    if(FrameStrike[8] > 0)
                    {
                        FrameScore[8] += 10;
                    }
                } else {
                    firstRoll = Integer.parseInt(pinsKnocked);
                    FrameScore[9] += firstRoll;
                    
                    if(FrameStrike[8] > 0)
                    {
                        FrameScore[8] += firstRoll;
                    }
                }
                pinsKnocked = input.readWord();
                
                if(pinsKnocked.equals("X"))
                {
                    FrameScore[9] += 10;
                    
                } else if(pinsKnocked.equals("/")){
                    FrameScore[9] += (10 - firstRoll);
                } else {
                    FrameScore[9] += Integer.parseInt(pinsKnocked);
                }
            } else if(FrameSpare[9] > 0) {
                pinsKnocked = input.readWord();
                    
                if(pinsKnocked.equals("X"))
                {
                    FrameScore[9] += 10;
                } else {
                    firstRoll = Integer.parseInt(pinsKnocked);
                    FrameScore[9] += firstRoll;
                }
            }         
                   
            for(int frame = 0; frame < 10; frame++)
            {
                totalScore += FrameScore[frame];
            }
			
            System.out.println(totalScore);
        }
    }
}