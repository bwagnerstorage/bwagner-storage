
/**
 * Write a description of class average here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



public class bust
{

    static int totalGroups;
    static char balloons[][] = new char[5][10];

    public static void main(String[] args)
    {
        UILFileReader input = new UILFileReader("bust.dat");
        int i, j;

        input.eolIsSignificant(false);
        input.readInt();
               

        while( input.ready() )
        {
           for (i = 0; i < 5; i++)
           {
              for (j = 0; j < 10; j++)
                 balloons[i][j] = input.readChar();
              input.skipWhite(true);
           }


           totalGroups = 0;

           for (i = 0; i < 5; i++)
              for (j = 0; j < 10; j++)
                 if (balloons[i][j] != '.')
                 {
                    totalGroups++;    
                    zap(i, j, balloons[i][j]);
                 }

           System.out.println(totalGroups + " groups");
         }   
    }

    public static void zap(int i, int j, char prevBalloon)
    {
       char theBalloon;

       if (i < 0 || i >= 5)
          return;
       if (j < 0 || j >= 10)
          return;

       theBalloon = balloons[i][j];
       if (theBalloon != prevBalloon)
          return;

       balloons[i][j] = '.';
       zap(i-1, j, theBalloon);
       zap(i+1, j, theBalloon); 
       zap(i, j+1, theBalloon);
       zap(i, j-1, theBalloon);
       
    }
}

