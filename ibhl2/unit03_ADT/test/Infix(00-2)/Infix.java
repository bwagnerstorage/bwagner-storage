import java.util.*;

public class Infix
{
	private Queue<Token> infixQ;
	private Queue<Token> postQ;
	
	public Infix()
	{
	   infixQ = getInfixExpression1();
	   postQ = infixToPostfix(infixQ);
	   displayQueue(infixQ);
	   displayQueue(postQ);
	   
	   infixQ = getInfixExpression2();
	   postQ = infixToPostfix(infixQ);
	   displayQueue(infixQ);
	   displayQueue(postQ);
	   
	   infixQ = getInfixExpression3();
	   postQ = infixToPostfix(infixQ);
	   displayQueue(infixQ);
	   displayQueue(postQ);
	   
	}
	
	public Queue<Token> getInfixExpression1()
	{
		// Example 1: 2 * 4 + 3 * 5
		Queue<Token> example = new LinkedList<Token>();
	    Token t1 = new Token(Token.NUMBER, 2);
	    Token t2 = new Token(Token.TIMES);
	    Token t3 = new Token(Token.NUMBER, 4);
	    Token t4 = new Token(Token.PLUS);
	    Token t5 = new Token(Token.NUMBER, 3);
	    Token t6 = new Token(Token.TIMES);
	    Token t7 = new Token(Token.NUMBER, 5);
	    
	    example.add(t1); example.add(t2); example.add(t3); example.add(t4);
	    example.add(t5); example.add(t6); example.add(t7);
	    
	    return example;	
	}
	
	public Queue<Token> getInfixExpression2()
	{
		// Example 2: 4 + 5 * 3 + 6
		Queue<Token> example = new LinkedList<Token>();
	    Token t1 = new Token(Token.NUMBER, 4);
	    Token t2 = new Token(Token.PLUS);
	    Token t3 = new Token(Token.NUMBER, 5);
	    Token t4 = new Token(Token.TIMES);
	    Token t5 = new Token(Token.NUMBER, 3);
	    Token t6 = new Token(Token.PLUS);
	    Token t7 = new Token(Token.NUMBER, 6);
	    
	    example.add(t1); example.add(t2); example.add(t3); example.add(t4);
	    example.add(t5); example.add(t6); example.add(t7);
	    
	    return example;	
	}
	
	public Queue<Token> getInfixExpression3()
	{
		// Example 3: 1 + 2 + 3 + 4
		Queue<Token> example = new LinkedList<Token>();
	    Token t1 = new Token(Token.NUMBER, 1);
	    Token t2 = new Token(Token.PLUS);
	    Token t3 = new Token(Token.NUMBER, 2);
	    Token t4 = new Token(Token.PLUS);
	    Token t5 = new Token(Token.NUMBER, 3);
	    Token t6 = new Token(Token.PLUS);
	    Token t7 = new Token(Token.NUMBER, 4);
	    
	    example.add(t1); example.add(t2); example.add(t3); example.add(t4);
	    example.add(t5); example.add(t6); example.add(t7);
	    
	    return example;	
	}
	
	
	// part (a)
	// postconditon: If the precedence of the token  lhs  is less than
	//      the precedence of  rhs,  then the method should return true.
	//      Tokens of type PLUS should have lower precedence than 
	//      tokens of type  TIMES,  which should have lower precedence
	//      than tokens of type NUMBER. 
	public boolean lessThanOrEqual(Token lhs, Token rhs)
	{
		int op1 = lhs.getOperator();
		int op2 = rhs.getOperator();
		
		return op1 <= op2;
	}
	
	// part (b)
	// precondition:  the sequence of tokens in infixQ represents a 
	//	   valid infix expression using +, *, and integers;
	// postcondition: returns a queue representing a
	//	   valid postfix expression equivalent to the
	//	   infix expression represented by infixQ

	public Queue<Token> infixToPostfix(Queue<Token>infixQ)
	{
		Queue<Token> postQ = new LinkedList<Token>();
		Stack<Token> opStack = new Stack<Token>();
		
		while(!infixQ.isEmpty())
		{
		   Token token = infixQ.remove();
		   if(!token.isOperator())
		   {
		   	   postQ.add(token);
		   }
		   if(token.isOperator())
		   {
		   	   if(opStack.isEmpty())
		       {
		   	      opStack.push(token);
		       }
		       else
		       {
		       	  while(!opStack.isEmpty() && lessThanOrEqual(token, opStack.peek()))
		       	  {
		       	  	  postQ.add(opStack.pop());
		       	  }
		       	  opStack.push(token);
		       }
		   }
		   	
		}
		while(!opStack.isEmpty())
		{
			postQ.add(opStack.pop());
		}
		
	    return postQ;	
	}
	
	// part (c)
	// postcondition: displays each token within the queue.
	//      If the token represents the plus sign the method
	//      should display a "+", if the token represents the
	//      times sign the method should display a "*", and if
	//      the token represents a number the method should 
	//      display the token's value.
	public void displayQueue(Queue<Token> queue)
	{
		for(Token t : queue)
		{
			if(t.isOperator())
			{
				int op = t.getOperator();
				if(op == Token.PLUS)
				{
					System.out.print("+");
				}
				if(op == Token.TIMES)
				{
					System.out.print("*");
				}
			}
			else
			
			   System.out.print(t.getValue());
		}
		System.out.println();
	}
	
	
	public static void main(String[] args)
	{
		Infix app = new Infix();
	}
}