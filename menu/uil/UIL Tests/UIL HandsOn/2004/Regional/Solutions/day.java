////////////////////////////////
//  File:        day.java     // 
//  Programmer:  Marc Douet   //
//  Date:        01/24/04     //
////////////////////////////////

import java.util.*;

public class day
{
	public static void main(String[] args)
	{	
                String 		sentence;
                StringTokenizer wordBuffer;
		UILFileReader 	input = new UILFileReader("day.dat");
		
		while( input.ready())
		{	
			sentence = input.readLine();
                        wordBuffer = new StringTokenizer(sentence);

                        while(wordBuffer.countTokens() > 0)
                        {
 				String word = new String(wordBuffer.nextToken());

                                for(int index = word.length()-2; index >= 0; index--)
                                {
 					System.out.print(word.charAt(index));
                                }
                                
                                System.out.print(word.charAt(word.length()-1) + "ay ");
			}
                        System.out.println();
		}
	}

}