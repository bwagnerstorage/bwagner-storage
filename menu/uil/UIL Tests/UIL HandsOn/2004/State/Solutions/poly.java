
/**
 * Write a description of class average here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



public class poly
{
    static Term terms[] = new Term[10];

    public static void main(String[] args)
    {
        UILFileReader input = new UILFileReader("poly.dat");

        char firstChar;
        boolean positive;
        boolean firstTerm;
        int i;
        Term nextTerm;


        input.eolIsSignificant(true);

        input.readInt();

        while( input.ready() )
        {
           for (i = 0; i < 10; i++)
              terms[i] = null;

           input.skipWhite(true);
           firstChar = input.peek();
           positive = true;
 
           if (firstChar == '-')
              positive = readSign(input);

           nextTerm = new Term();
           nextTerm.setPositive(positive);
           nextTerm.readTerm(input);

           terms[nextTerm.degree()] = nextTerm;

           while(input.peek() != '\n')
           {
              nextTerm = new Term();
              positive = readSign(input);
              nextTerm.setPositive(positive);
              nextTerm.readTerm(input);
              terms[nextTerm.degree()] = nextTerm;
           }
           input.skipWhite(true);

           firstTerm = true;

           for (i = 9; i >= 0; i--)
           {
              if (terms[i] == null)
                 continue;

              if (firstTerm)
              {
                 if (terms[i].negative())
                    System.out.print(terms[i].sign + " ");
              }
              else
                 System.out.print(" " + terms[i].sign + " ");

              System.out.print(terms[i].term);
             
              firstTerm = false;
           }
           System.out.println();
        }   
    }

    public static boolean readSign(UILFileReader input)
    {
        char sign;

        input.skipWhite(true);
        sign = input.readChar();
        input.skipWhite(true);

        return(sign == '+');
    }
}


class Term
{

   char sign;
   String term;
  
   public Term()
   {
      sign = '+';
   }

   public void setPositive(boolean positive)
   {
       if (positive)
          sign = '+';
       else
          sign = '-';
   }

   public void readTerm(UILFileReader input)
   {
      input.skipWhite(true);
      term = input.readWord();

   }

   public int degree()
   {
      if (term.indexOf('x') == -1)
         return 0;
      if (term.indexOf('^') == -1)
         return 1;
      
      return (Integer.parseInt(term.substring(term.indexOf('^')+1)));
   }

   public boolean negative()
   {
      return(sign == '-');
   }
      
}
