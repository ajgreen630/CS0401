import java.util.*;
public class BingoCard
{
	private BingoNumber[][] card;
	
	// Constructors:
	public BingoCard()
	{
		// Constructs a bingo card with an array of BingoNumber
		// objects.
		Random rand = new Random();
		ArrayList<Integer> used = new ArrayList<Integer>();
		card = new BingoNumber[5][5];
		
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				if (i == 2 && j == 2)
				{
					card[i][j] = null;
					continue;
				}
				
				int num = rand.nextInt(76);
				
				while (used.contains(num) || !isValid(j, num))
				{
					num = rand.nextInt(76);
				}
				
				used.add(num);
				card[i][j] = new BingoNumber(num);
			}
		}
	}
	public boolean isValid(int col, int n)
	{
		// Allows for unique random integers
		// with a specified range for each column.
		if (col == 0 && (n < 1 || n > 15))
		{
			return false;
		}
		else if (col == 1 && (n < 16 || n > 30))
		{
			return false;
		}
		else if (col == 2 && (n < 31 || n > 45))
		{
			return false;
		}
		else if (col == 3 && (n < 46 || n > 60))
		{
			return false;
		}
		else if (col == 4 && (n < 61 || n > 75))
		{
			return false;
		}
		return true;
	}
	
	// Accessor methods:
	public String toString()
	{
		// Returns a string representation of a bingo card.
		
		String bingoStr = "  B  I  N  G  O ";
		String rowStr = "+--+--+--+--+--+";
		String colStr = "|";
		String cardStr = "";
		
		cardStr += bingoStr + "\n" + rowStr + "\n";
		for (int i = 0; i < card.length; i++)
		{
			cardStr += colStr;
			for (int j = 0; j < card[i].length; j++)
			{
				if (i == 2 && j == 2)
				{
					cardStr += "XX" + colStr;
					continue;
				}
				if (card[i][j].getNumber() < 10)
				{
					if (card[i][j].isMarked())
					{
						cardStr += "";
					}
					else if (!card[i][j].isMarked())
					{
						cardStr += " ";
					}
				}
				cardStr += card[i][j];
				cardStr += colStr;
			}
			cardStr += "\n" + rowStr + "\n";
		}
		return cardStr;
		
	}
	public BingoNumber getNumber(int row, int col)
	{
		// Returns the number specified at a given row
		// and column.
		return card[row - 1][col - 1];
	}
	public String toSideBySideString()
	{
		// Returns a string representation of a bingo
		// card with marks, alongisde a bingo card without
		// marks for verification on the right side.
		
		String bingoStr = "  B  I  N  G  O ";
		String rowStr = "+--+--+--+--+--+";
		String colStr = "|";
		String sideStr = "";
		
		sideStr += bingoStr + "   " + bingoStr + "\n";
		sideStr += rowStr + "   " + rowStr + "\n";
		for (int i = 0; i < card.length; i++)
		{
			sideStr += colStr;
			for (int j = 0; j < card[i].length; j++)
			{
				if(i == 2 && j == 2)
				{
					sideStr += "XX" + colStr;
					continue;
				}
				if (card[i][j].getNumber() < 10)
				{
					if (card[i][j].isMarked())
					{
						sideStr += "";
					}
					else if (!card[i][j].isMarked())
					{
						sideStr += " ";
					}
				}
				sideStr += card[i][j];
				sideStr += colStr;
			}
			sideStr += "   " + colStr;
			for (int j = 0; j < card[i].length; j++)
			{
				if (i == 2 && j == 2)
				{
					sideStr += "XX" + colStr;
					continue;
				}
				if (card[i][j].getNumber() < 10)
				{
					sideStr += " ";
				}
				sideStr += card[i][j].getNumber();
				sideStr += colStr;
			}
			sideStr += "\n" + rowStr + "   " + rowStr + "\n";
		}
		return sideStr;
	}
	public boolean isWinningCard()
	{
		// Vertical Bingo:
		if (getNumber(1, 1).isMarked() && getNumber(2, 1).isMarked() && getNumber(3, 1).isMarked() && getNumber(4, 1).isMarked() && getNumber(5, 1).isMarked())
		{
			return true;
		}
		else if (getNumber(1, 2).isMarked() && getNumber(2, 2).isMarked() && getNumber(3, 2).isMarked() && getNumber(4, 2).isMarked() && getNumber(5, 2).isMarked())
		{
			return true;
		}
		else if (getNumber(1, 3).isMarked() && getNumber(2, 3).isMarked() && getNumber(4, 3).isMarked() && getNumber(5, 3).isMarked())
		{
			return true;
		}
		else if (getNumber(1, 4).isMarked() && getNumber(2, 4).isMarked() && getNumber(3, 4).isMarked() && getNumber(4, 4).isMarked() && getNumber(5, 4).isMarked())
		{
			return true;
		}
		else if (getNumber(1, 5).isMarked() && getNumber(2, 5).isMarked() && getNumber(3, 5).isMarked() && getNumber(4, 5).isMarked() && getNumber(5, 5).isMarked())
		{
			return true;
		}
		// Horizontal Bingo:
		else if (getNumber(1, 1).isMarked() && getNumber(1, 2).isMarked() && getNumber(1, 3).isMarked() && getNumber(1, 4).isMarked() && getNumber(1, 5).isMarked())
		{
			return true;
		}
		else if (getNumber(2, 1).isMarked() && getNumber(2, 2).isMarked() && getNumber(2, 3).isMarked() && getNumber(2, 4).isMarked() && getNumber(2, 5).isMarked())
		{
			return true;
		}
		else if (getNumber(3, 1).isMarked() && getNumber(3, 2).isMarked() && getNumber(3, 4).isMarked() && getNumber(3, 5).isMarked())
		{
			return true;
		}
		else if (getNumber(4, 1).isMarked() && getNumber(4, 2).isMarked() && getNumber(4, 3).isMarked() && getNumber(4, 4).isMarked() && getNumber(4, 5).isMarked())
		{
			return true;
		}
		else if (getNumber(5, 1).isMarked() && getNumber(5, 2).isMarked() && getNumber(5, 3).isMarked() && getNumber(5, 4).isMarked() && getNumber(5, 5).isMarked())
		{
			return true;
		}
		// Left Diagonal Bingo (top left to bottom right):
		else if (getNumber(1, 1).isMarked() && getNumber(2, 2).isMarked() && getNumber(4, 4).isMarked() && getNumber(5, 5).isMarked())
		{
			return true;
		}
		// Right Diagonal Bingo (bottom right to top left):
		else if (getNumber(5, 1).isMarked() && getNumber(4, 2).isMarked() && getNumber(2, 4).isMarked() && getNumber(1, 5).isMarked())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Mutator methods:
	public boolean mark(int number)
	{
		// Marks a given number on the card and returns whether the
		// given number is successfully marked.  Note: A user can
		// mark a number even if it is not on the card.
		
		// If the user marks a number that is not on the card,
		// this method will mark no number and simply return false.
		
		// Search the card array:
		for (int i = 0; i < card.length; i++)
		{
			for (int j = 0; j < card[i].length; j++)
			{
				if (i == 2 && j == 2)
				{
					continue;
				}
				if (card[i][j].getNumber() == number)
				{
					card[i][j].mark();
					return true;
				}
			}
		}
		return false;
	}
}