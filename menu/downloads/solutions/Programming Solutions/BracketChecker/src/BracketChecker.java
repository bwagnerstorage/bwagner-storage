import java.util.*;

public class BracketChecker
{
   private String[] test = {"(4+5)",
                            "(3 * (5 + 2))",
                            "(6 * 3) + (7 * 5))",
                            "((10/2 + 4) * (6 + 8) + (2 + 9))",
                            "25 / 5)",
                            "((6+8) * (5+2) *(9+9)"};

	public BracketChecker()
	{
            for(String exp : test)
            {
                if(check(exp))
                {
                        System.out.println("passed");
                }
                else
                {
                        System.out.println("failed");
                }
            }
	}

    /* performs test to determine if exp has the correct number and ordering of brackets
     * @param the expression to be evaluated
     * @return true if exp passes test; false otherwise
     */
	public boolean check(String exp)
	{

	}

	public static void main(String[] args)
	{
            BracketChecker app = new BracketChecker();
	}
}