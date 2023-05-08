import java.util.*;

public class reloaded
{
	public static void main(String[] args)
	{	
                int		numMatrix;
		UILFileReader 	input = new UILFileReader("reloaded.dat");
		Matrix		theMatrix;

		numMatrix = input.readInt();
		
		while(input.ready())
		{
			theMatrix = new Matrix(input);

			if (theMatrix.isMagic())
				System.out.println("This could be a magic square.");
			else
				System.out.println("This can't be a magic square.");
		}

	}
}

class Matrix
{

private int size;
private int magicSum;
private int numbers[][];
private boolean numbersEntered[];
private int numRowBlanks[];
private int numColBlanks[];
private int blanksLeft;
private boolean magic;

public Matrix(UILFileReader input)
{
	int i, j;

	numbers = new int[10][10];
	numbersEntered = new boolean[101];
	numRowBlanks = new int[10];
	numColBlanks = new int[10];
	Arrays.fill(numRowBlanks, 0);
	Arrays.fill(numColBlanks, 0);
	Arrays.fill(numbersEntered, false);
	magic = true;

	blanksLeft = 0;
	size = input.readInt();
	if (size == 2)
		magic = false;
	magicSum = size * (int)((Math.pow((double) size, 2.0) + 1)) / 2;

	for (i = 0; i < size; i++)
	{
		for (j = 0; j < size; j++)
		{
			numbers[i][j] = input.readInt();

			if (numbers[i][j] == 0)
			{
				numRowBlanks[i]++;
				numColBlanks[j]++;
				blanksLeft++;
			}
			else
			{
				if (numbers[i][j] > size * size)
					magic = false;
				else if (numbersEntered[numbers[i][j]])
					magic = false;
				else
					numbersEntered[numbers[i][j]] = true;
			}
		}
	}
}

public boolean isMagic()
{
	if (!magic)
		return(false);
	if (blanksLeft > 0 && !fillInBlanks())
		return(false);
	return(checkMagic());
}

public boolean checkMagic()
{
	int	i, j;
	int	diagonal1Sum = 0;
	int	diagonal2Sum = 0;
	int	rowSum[];
	int	colSum[];

	rowSum = new int[10];
	colSum = new int[10];

	Arrays.fill(rowSum, 0);
	Arrays.fill(colSum, 0);

	for (i = 0; i < size; i++)
	{
		for (j = 0; j < size; j++)
		{
			rowSum[i] += numbers[i][j];
			colSum[i] += numbers[j][i];
			if (i == j)
				diagonal1Sum += numbers[i][j];
			if (i + j + 1 == size || size == 1)
				diagonal2Sum += numbers[i][j];
		}
		if (rowSum[i] != magicSum)
			return false;
	}
	for (i = 0; i < size; i++)
		if (colSum[i] != magicSum)
			return false;

	if (diagonal1Sum != magicSum || diagonal2Sum != magicSum)
		return false;

	for (i = 1; i <= size * size; i++)
		if (!numbersEntered[i])
			return false;

	return true; 
}

private boolean fillInBlanks()
{
	int sum, row = 0, col = 0, numToEnter, i, j;

	while (blanksLeft > 0)
	{
		for (i = 0; i < size; i++)
		{
			if (numRowBlanks[i] == 1)
			{
				sum = 0;
				for (j = 0; j < size; j++)
				{
					if (numbers[i][j] == 0)
					{
						row = i;
						col = j;
					}
					else
						sum += numbers[i][j];
				}
				numToEnter = magicSum - sum;
				if (numToEnter > size * size || numbersEntered[numToEnter])
					return false;
				numbers[row][col] = numToEnter;
				numbersEntered[numToEnter] = true;
				blanksLeft--;
				numRowBlanks[row]--;
				numColBlanks[col]--;
			}
		}

		for (i = 0; i < size; i++)
		{
			if (numColBlanks[i] == 1)
			{
				sum = 0;
				for (j = 0; j < size; j++)
				{
					if (numbers[j][i] == 0)
					{
						row = j;
						col = i;
					}
					else
						sum += numbers[j][i];
				}
				numToEnter = magicSum - sum;
				if (numToEnter > size * size || numbersEntered[numToEnter])
					return false;
				numbers[row][col] = numToEnter;
				numbersEntered[numToEnter] = true;
				blanksLeft--;
				numRowBlanks[row]--;
				numColBlanks[col]--;
			}
		}
 
	}
	return true;
}

}