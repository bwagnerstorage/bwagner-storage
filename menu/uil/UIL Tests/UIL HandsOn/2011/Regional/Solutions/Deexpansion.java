import java.io.*;
import java.util.Scanner;

public class Deexpansion
{
    public static String _origStr = "This is the original file.\r\n\r\nGood thing you recovered it!\r\nPound #\r\nPercent %\r\nBackslash \\";
    public static boolean _bConvertString = false;
    
    public static String ConvertToBinary(char c)
    {
        String ret = "";
        for (int i = 0; i < Character.SIZE; ++i)
        {
            ret += c >> i & 0x0001;
        }
        
        return ret;
    }
    
    public static char ConvertFromBinary(String str)
    {
        char ret = (char) 0;
        for (int i = 0; i < str.length(); ++i)
        {
            int bit = Integer.parseInt(str.substring(i, i + 1));
            ret |= (bit << i);
        }
        
        return ret;
    }

    public static void main(String args[]) throws IOException
    {
        // Parse each line in the file
        Scanner kb = new Scanner(new File("deexpansion.dat"));
        
        String fileContents = "";
        while (kb.hasNextLine())
        {
            fileContents += kb.nextLine();
        }
        
        String origStr = "";
        
        if (_bConvertString)
        {
            for (int i = 0; i < _origStr.length(); ++i)
            {
                origStr += ConvertToBinary(_origStr.charAt(i));
            }
        }
        else
        {
            int len = fileContents.length();
            int cur = 0;
            while (cur < len)
            {
                String sChar = fileContents.substring(cur, cur + 16);
                origStr += ConvertFromBinary(sChar);
                cur += 16;
            }
        }
        
        System.out.println(origStr);
    }
}
