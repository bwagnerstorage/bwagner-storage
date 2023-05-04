public class TokenPass
{
	private int[] board;
	private int currentPlayer;

	public TokenPass(int playerCount)
	{
		board = new int[playCount];
		for(int x = 0; x < playCount; x++)
		{
			board[x] = (int)(Math.random() * 10) + 1;
		}
		currentPlayer = (int)(Math.random() * playerCount);
	}

	public void distributeCurrentPlayerTokens()
	{
		int nextPlayer = currentPlayer + 1;
		int tokens = board[currentPlayer];
		board[currentPlayer] = 0;

		while(tokens > 0)
		{
			if(nextPlayer == board.length)
			{
				nextPlayer = 0;
			}
			board[nextPlayer] ++;
			nextPlayer++;
			tokens--;
		}
	}
}