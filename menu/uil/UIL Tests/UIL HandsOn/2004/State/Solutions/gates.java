
/**
 * Write a description of class average here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



public class gates
{

    public static void main(String[] args)
    {
        UILFileReader input = new UILFileReader("gates.dat");

        int numBits, i, currOperation, currResult;
        int bits[];
        char operations[];

        input.readInt();

        while( input.ready() )
        {
           numBits = input.readInt();

           bits = new int[numBits];
           operations = new char[numBits - 1];
           
           for (i = 0; i < numBits; i++)
              bits[i] = input.readInt();

           for (i = 0; i < numBits - 1; i++)
           {
              input.skipWhite(true);
              operations[i] = input.readChar();
           }

           currOperation = 0;

           while (numBits != 1)
           {
              currResult = 0;
              for (i = 0; i < numBits - 1; i+=2)
              {
                 bits[currResult++] = doOperation(bits[i], bits[i+1], operations[currOperation++]);
              }
              numBits /= 2;
           }

           System.out.println(bits[0]);
           input.skipWhite(true);
 
         }
     }

     public static int doOperation(int a, int b, char operation)
     {
        if (operation == 'A')
        {
           if (a == 1 && b == 1)
              return 1;
           return 0;
        }
        else if (operation == 'R')
        {
           if (a == 1 || b == 1)
              return 1;
           return 0;
        }
        
        if ((a == 1) && (b == 0) || (a == 0) && (b == 1))
           return 1;
        return 0;
     }

}