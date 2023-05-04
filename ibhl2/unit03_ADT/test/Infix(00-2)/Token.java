public class Token
{
	public static final int PLUS = 0;
	public static final int TIMES = 1;
	public static final int NUMBER = 2;
	
	private int operator;    // operator == NUMBER means token represents
	private int value;       // a value; otherwise, value is undefined
	private boolean amIOperator;
	
	public Token(int o, int v)  // Token is a number
	{
		operator = o;
		value = v;
		amIOperator = false;
	}
	
	public Token(int o)         // Token is a symbol: PLUS or TIMES
	{
		operator = o;
		value = 0;      // value undefined
		amIOperator = true;
	}
	
	public boolean isOperator()
	{
		return amIOperator;
	}
	
	public int getOperator()
	{
		return operator;
	}
	
	public int getValue()
	{
		return value;
	}
	
	
}