//////////////////////////////////
//  File:        parse.java     // 
//  Programmer:  Marc Douet     //
//  Date:        03/25/07       //
//////////////////////////////////

import java.util.*;
import java.io.*;


//////////////////////////////////////////////////////////////////////////
//  Class Name:  parse                                                  //
//                                                                      //
//  Description:                                                        //
//////////////////////////////////////////////////////////////////////////
public class parse {
      
	////////////////////
	//  Data Members  //
	////////////////////
	private BufferedReader 	in;
	private int 		numDatasets;	
	private StringTokenizer tokenBuffer;
	private String		line;
	private String		sentence;
	private String[]	nouns = 	{"I", "bridge", "boy", "dog",
					 	 "pizza", "home", "ball", "store"};
	private String[]	verbs = 	{"threw", "ran", "bought", "eats",
					 	 "buy", "loves", "went"};
	private String[]	adjectives = 	{"big", "tall", "tasty", 
					      	 "round", "blue"};
	private String[]	adverbs = 	{"quickly", "loudly"};
	private String[]	prepositions = 	{"to", "under", "from"};
	private String[]	articles = 	{"a", "an", "the"};
	private String[]	conjunctions =	{"and", "or", "but", "yet"};
	

	////////////////////////
	//  Member Functions  //
	////////////////////////
	//////////////////////////////////////////////////////////////////
	// Function:  Constructor				        //
	// 							        //
	// Synopsis:  public parse(void)				//
	//				                                //
	// Description: Initializes all data members of the parse class //
        //                                                              //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	public parse()
	{
		// Initialize all data members.
		numDatasets = 0;			
		tokenBuffer = null;
		line = null;
		sentence = null;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  isNoun		                            	//
	// 								//
	// Synopsis:  private boolean isNoun(String word)               //
	// 						                //
	// Description: Determines if a word is a noun by looking for a //
	//              matching word in the "nouns" list.		//
	//				                                //
	// Return Value: True if this is a noun, false otherwise        //
	//////////////////////////////////////////////////////////////////
	private boolean isNoun(String word)
	{
		for(int i = 0; i < nouns.length; i++)
		{
			if(word.equalsIgnoreCase(nouns[i])) { return true; }
		}

		return false;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  isVerb		                            	//
	// 								//
	// Synopsis:  private boolean isVerb(String word)               //
	// 						                //
	// Description: Determines if a word is a verb by looking for a //
	//              matching word in the "verbs" list.		//
	//				                                //
	// Return Value: True if this is a verb, false otherwise        //
	//////////////////////////////////////////////////////////////////
	private boolean isVerb(String word)
	{
		for(int i = 0; i < verbs.length; i++)
		{
			if(word.equalsIgnoreCase(verbs[i])) { return true; }
		}

		return false;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  isAdjective	                            	//
	// 								//
	// Synopsis:  private boolean isAdjective(String word)          //
	// 						                //
	// Description: Determines if a word is an adjective by looking //
	//              for a matching word in the "adjectives" list.   //
	//				                                //
	// Return Value: True if this is an adjective, false otherwise  //
	//////////////////////////////////////////////////////////////////
	private boolean isAdjective(String word)
	{
		for(int i = 0; i < adjectives.length; i++)
		{
			if(word.equalsIgnoreCase(adjectives[i])) { return true; }
		}

		return false;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  isAdverb		                            	//
	// 								//
	// Synopsis:  private boolean isAdverb(String word)             //
	// 						                //
	// Description: Determines if a word is an adverb by looking for//
	//              a matching word in the "adverbs" list.		//
	//				                                //
	// Return Value: True if this is an adverb, false otherwise     //
	//////////////////////////////////////////////////////////////////
	private boolean isAdverb(String word)
	{
		for(int i = 0; i < adverbs.length; i++)
		{
			if(word.equalsIgnoreCase(adverbs[i])) { return true; }
		}

		return false;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  isPreposition	                            	//
	// 								//
	// Synopsis:  private boolean isPreposition(String word)        //
	// 						                //
	// Description: Determines if a word is a preposition by looking//
	//              for a matching word in the "nouns" list.	//
	//				                                //
	// Return Value: True if this is a preposition, false otherwise //
	//////////////////////////////////////////////////////////////////
	private boolean isPreposition(String word)
	{
		for(int i = 0; i < prepositions.length; i++)
		{
			if(word.equalsIgnoreCase(prepositions[i])) { return true; }
		}

		return false;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  isArticle  	                            	//
	// 								//
	// Synopsis:  private boolean isArticle(String word)            //
	// 						                //
	// Description: Determines if a word is an article by looking   //
	//              for a matching word in the "nouns" list.	//
	//				                                //
	// Return Value: True if this is an article, false otherwise    //
	//////////////////////////////////////////////////////////////////
	private boolean isArticle(String word)
	{
		for(int i = 0; i < articles.length; i++)
		{
			if(word.equalsIgnoreCase(articles[i])) { return true; }
		}

		return false;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  isConjunction	                            	//
	// 								//
	// Synopsis:  private boolean isConjunction(String word)        //
	// 						                //
	// Description: Determines if a word is a conjunction by looking//
	//              for a matching word in the "nouns" list.	//
	//				                                //
	// Return Value: True if this is a conjunction, false otherwise //
	//////////////////////////////////////////////////////////////////
	private boolean isConjunction(String word)
	{
		for(int i = 0; i < conjunctions.length; i++)
		{
			if(word.equalsIgnoreCase(conjunctions[i])) { return true; }
		}

		return false;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  getPP		                            	//
	// 								//
	// Synopsis:  private String getPP(String fragment)	        //
	// 						                //
	// Description: Determine if the next fragment contains a PP.   //
	//              The phrased is parsed using the following rule: //
	//		<PP> = <preposition> <NP>                      	//
	//				                                //
	// Return Value: If a PP phrase was found, the remainder of the //
	//               fragment starting after the end of the PP is   //
	//               returned.  Null is returned if no VP phrase was//
	//               found in the fragment. 			//
	//////////////////////////////////////////////////////////////////
	private String getPP(String fragment)
	{
		String word = "";
		String sentence = "";
		int wordIndex;
		tokenBuffer = new StringTokenizer(fragment);
		int totalWords = tokenBuffer.countTokens();

		// Parse each word in the fragment
		for(wordIndex = 1; wordIndex <= totalWords; wordIndex++)
		{
			// Get the next word in the fragment
			word = tokenBuffer.nextToken();

			switch(wordIndex)
			{
				// The first word must be a <preposition>, if not just 
				// return an empty string since PP is not a manditory phrase.
				case 1:	if(!isPreposition(word)) { return ""; }
					break;

				// The second word must be the start of an <NP>
				case 2: sentence = word;
					// Grab the rest of the frament, starting with this word 
					// and see if it's an <NP>
					sentence = word;
					for(wordIndex = wordIndex; wordIndex < totalWords; wordIndex++)
					{
						sentence = sentence + " " + tokenBuffer.nextToken();
					}
					sentence = getNP(sentence);
					if(sentence == null) { return null; }
					break;

				// If we've gotten here, we're done parsing, so just grab 
				// the rest of the phrase to pass back to the caller
				default:  sentence = sentence + " " + word;
			}
		}

		// Return the remainder of the fragment
		return sentence;
	}
		

	
	//////////////////////////////////////////////////////////////////
	// Function:  getVP		                            	//
	// 								//
	// Synopsis:  private String getVP(String fragment)	        //
	// 						                //
	// Description: Determine if the next fragment contains a VP.   //
	//              The phrased is parsed using the following rule: //
	//		<VP> = <verb> [<adverb>] [<PP>]                	//
	//				                                //
	// Return Value: If a VP phrase was found, the remainder of the //
	//               fragment starting after the end of the VP is   //
	//               returned.  Null is returned if no VP phrase was//
	//               found in the fragment. 			//
	//////////////////////////////////////////////////////////////////
	private String getVP(String fragment)
	{
		String word = "";
		String sentence = "";
		int wordIndex;
		tokenBuffer = new StringTokenizer(fragment);
		int totalWords = tokenBuffer.countTokens();

		// Parse each word in the fragment
		for(wordIndex = 1; wordIndex <= totalWords; wordIndex++)
		{
			word = tokenBuffer.nextToken();

			switch(wordIndex)
			{
				// The first word must be a <verb>
				case 1:	if(!isVerb(word)) { return null; }
					break;

				// Check to see if the second word is an adverb or PP, 
				// if not, then we are done processing this VP
				case 2: if(!isAdverb(word))
					{
						sentence = word;
						for(wordIndex = wordIndex; wordIndex < totalWords; wordIndex++)
						{
							sentence = sentence + " " + tokenBuffer.nextToken();
						}
						String newSentence = getPP(sentence);
						if(newSentence == null) { return null; }
						else if(newSentence != "") { sentence = newSentence; }
					}
					break;

				// Check to see if the third word is a PP, if not, we are
				// done processing this VP
				case 3: sentence = word;
					for(wordIndex = wordIndex; wordIndex < totalWords; wordIndex++)
					{
						sentence = sentence + " " + tokenBuffer.nextToken();
					}
					String newSentence = getPP(sentence);
					if(newSentence == null) { return null; }
					else if(newSentence != "") { sentence = newSentence; }
					break;

				// If we've gotten here, we're done parsing, so just grab 
				// the rest of the phrase to pass back to the caller
				default:  sentence = sentence + " " + word;
			}
		}

		// Return the remainder of the fragment
		return sentence;
	}


	//////////////////////////////////////////////////////////////////
	// Function:  getNP		                            	//
	// 								//
	// Synopsis:  private String getNP(String fragment)	        //
	// 						                //
	// Description: Determine if the next fragment contains an NP.  //
	//              The phrased is parsed using the following rule: //
	//		<NP> = [<article>] [<adjective>] <noun>	       	//
	//				                                //
	// Return Value: If an NP phrase was found, the remainder of the//
	//               fragment starting after the end of the NP is   //
	//               returned.  Null is returned if no NP phrase was//
	//               found in the fragment. 			//
	//////////////////////////////////////////////////////////////////
	private String getNP(String fragment)
	{
		String word = "";
		String sentence = "";
		boolean foundNoun = false;
		boolean foundAdjective = false;
		int wordIndex;
		tokenBuffer = new StringTokenizer(fragment);
		int totalWords = tokenBuffer.countTokens();

		// Parse each word in the fragment
		for(wordIndex = 1; wordIndex <= totalWords; wordIndex++)
		{
			word = tokenBuffer.nextToken();

			switch(wordIndex)
			{
				// The first word can be an <article>, <adjective> and if it's neither
				// of these, then it must be a <noun>.  If we did find a noun, we're
				// done parsing, so set a flag for the future.  Also set a flag if
				// we found an adjective so we can make sure we don't see another one.
				case 1:	if((!isArticle(word) && !isAdjective(word)) && (!isNoun(word))) { return null; }
					if(isNoun(word)) { foundNoun = true; }
					if(isAdjective(word)) { foundAdjective = true; }
					break;

				// The second word can be an adjective unless we have already seen one, 
				// if not it must be a noun.  If we did find a noun, we're done parsing, 
				// so set the flag for the future.  If we found a noun in the past, we're done parsing,
				// so add this word to our ending fragment that will be returned to the caller.
				case 2: if(foundNoun)
					{
						sentence = sentence + " " + word;
						break;
					}
					if((foundAdjective && isAdjective(word)) || (!isAdjective(word) 
							   && !isNoun(word))) { return null; }
					if(isNoun(word)) { foundNoun = true; }
					break;

				// The thrid word must be a noun   If we found a noun in the past, 
				// we're done parsing, so add this word to our ending fragment that 
				// will be returned to the caller.
				case 3: if(foundNoun)
					{
						sentence = sentence + " " + word;
						break;
					}
					if(!isNoun(word)) { return null; }
					break;

				// If we've gotten here, we're done parsing, so just grab 
				// the rest of the phrase to pass back to the caller
				default:  sentence = sentence + " " + word;
			}
		}

		// Return the remainder of the fragment
		return sentence;
	}
		
				
	//////////////////////////////////////////////////////////////////
	// Function:  parseSentence                             	//
	// 								//
	// Synopsis:  private boolean parseSentence()                   //
	// 						                //
	// Description: Determines if a phrase is a valid sentence.     //
	//              The phrased is parsed using the following rule: //
	//		<S> = <NP> <VP> [<conjunction> <NP> <VP>]      	//
	//				                                //
	// Return Value: True if the phrase is a valid sentence, false  //
	//               otherwise					//
	//////////////////////////////////////////////////////////////////
	private boolean parseSentence()
	{
		String sentenceFragment = sentence;
		
		// The first fragment must be an <NP>
		sentenceFragment = getNP(sentenceFragment);
		if(sentenceFragment == null) { return false; }
		
		// The second fragment must be a <VP>
		sentenceFragment = getVP(sentenceFragment);
		if(sentenceFragment == null) { return false; }

		// If we still have words remaining...
		if(sentenceFragment != "")
		{
			tokenBuffer = new StringTokenizer(sentenceFragment);
			String word = tokenBuffer.nextToken();
			int totalWords = tokenBuffer.countTokens();

			// The next word must be a conjunction
			if(!isConjunction(word)) { return false; }

			// Grab the rest of the fragment
			sentenceFragment = "";
			for(int i = 0; i < totalWords; i++)
			{
				sentenceFragment = sentenceFragment + " " + tokenBuffer.nextToken();
			}
		
			// The next fragment must be an <NP>
			sentenceFragment = getNP(sentenceFragment);
			if(sentenceFragment == null) { return false; }

			// The next fragment must be a <VP>
			sentenceFragment = getVP(sentenceFragment);
			if(sentenceFragment == null) { return false; }
		}

		// If we've made it this far, we have ourselves a proper sentence
		return true;	
	}
		

	//////////////////////////////////////////////////////////////////
	// Function:  start						//
	// 								//
	// Synopsis:  public void start(void)		                //
	// 						                //
	// Description: Starts the parse class by reading each pharse	//
	//              and parsing it to determine if it is a proper   //
	//              sentence.					//
	//				                                //
	// Return Value: None.					        //
	//////////////////////////////////////////////////////////////////
	private void start()
	throws FileNotFoundException
	{
		// Open the data file for reading
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("parse.in")));

		// Read in the number of datasets.
		try {
           		line = in.readLine();
			tokenBuffer = new StringTokenizer(line);
			numDatasets = Integer.parseInt(tokenBuffer.nextToken());

            	} catch(IOException ioError) {
				System.out.println(
					"Error occurred while reading in the first line of input.");
                		ioError.printStackTrace();
				System.exit(1);
            	}

		// While we have data to process...
		for(int index = 0; index < numDatasets; index++) {  
			// Read the sentence
			try {
                  		sentence = in.readLine();

                        } catch(IOException ioError) {
					System.out.println(
						"Error occurred while reading in the next line of input.");
                			ioError.printStackTrace();
					System.exit(1);
            		}

			// Parse the sentence and print the results
			if(parseSentence())
			{
				System.out.println("Sentence");
			}
			else 
			{
				System.out.println("Not a sentence");
			}
		}
	}


	/////////////////////////////////////////////////////////////////////
	//  Function:  main                                                //
	//                                                                 //
	//  Synopsis:  public static void main(String args[])              //
        //                                                                 //
	//	         args  [IN]  Not used.	                           //
	//								   //
	//  Description: The main driver of the parse class.               //
	//                                                                 //
	//  Return Value: None.						   //
	/////////////////////////////////////////////////////////////////////
	public static void main(String args[])
	throws FileNotFoundException
	{
		parse parseEngine = new parse();
		parseEngine.start();
		System.exit(0);
	}
}