import java.util.*;
public class BingoPlayer
{
	
	// Instance variables:
	private String first;
	private String last;
	private static double bank;
	private ArrayList<BingoCard> hand;
	
	private String fullName;
	private String fullInfo;
	
	// Constructor:
	public BingoPlayer(String aFirst, String aLast, double anAmount)
	{
		first = aFirst;
		last = aLast;
		bank = anAmount;
		
		hand = new ArrayList<BingoCard>();
		
		fullName = "";
		fullInfo = "";
		
	}
	// Accessors:
	public String getFullName() // DONE.
	{
		fullName = first + " " + last;
		
		return fullName; 
	}
	public String getFullInfo() // DONE.
	{
		fullInfo = first + " " + last + " ($" + bank + ")";
		
		return fullInfo;
	}
	public String toString()
	{
		// Returns a string representation of a Bingo player
		// together with their Bingo cards in their hand.
		String playerStr = "";
		playerStr += fullInfo + "\n";
		
		if (hand.size() == 0)
		{
			playerStr += "No Bingo Cards" + "\n";
		}
		else
		{
			String handStr = "";
			for (int i = 0; i < hand.size(); i++)
			{
				handStr += hand.get(i);
			}
			playerStr += handStr;
		}
		
		return playerStr;
	}
	public String toFileString()
	{
		String fileStr = "";
		fileStr = first + "," + last + "," + bank;
		return fileStr;
	}
	public boolean isBingo()
	{
		// Returns true or false whether the player has one or more
		// winning card(s).
		boolean hasBingo = false;
		for (int i = 0; i < hand.size(); i++)
		{
			BingoCard aCard = hand.get(i);
			if (aCard.isWinningCard())
			{
				hasBingo = true;
			}
		}
		
		return hasBingo;
	}
	
	public BingoCard[] getBingoCards()
	{
		// Returns an array of type Bingocard that are winning
		// cards.  This method will be called by the host to 
		// verify whether the card is.
		ArrayList<BingoCard> winList = new ArrayList<BingoCard>();
		for (int i = 0; i < hand.size(); i++)
		{
			BingoCard aCard = hand.get(i);
			if (aCard.isWinningCard())
			{
				winList.add(aCard);
			}
		}
		
		BingoCard[] winArr = winList.toArray(new BingoCard[winList.size()]);
		
		return winArr;
	}
	
	// Mutators:
	public int remove(int amount)
	{
		// Removes a given amount in US dollars from a Bingo player.
		
		// This method must adjust the amount of money the player has.
		if (bank >= amount)
		{
			amount = amount;
		}
		else if (bank < amount)
		{
			amount = (int) bank;
		}
		
		bank = bank - amount;
		
		return amount;
	}
	public void add(double amount)
	{
		// Adds more money into the player's pocket.
		bank += amount;
	}
	public void addBingoCards(BingoCard[] cards)
	{
		// Adds Bingo cards into the player's hand in the form of an
		// an array of BingoCard.
		
		for (int i = 0; i < cards.length; i++)
		{
			hand.add(cards[i]);
		}
	}
	public void marks (int number)
	{
		// Marks all Bingo cards in the player's hand that contain the given
		// number.
		for (int i = 0; i < hand.size(); i++)
		{
			BingoCard aCard = hand.get(i);
			
			aCard.mark(number);
			
		}
	}
	public void clear()
	{
		// Clear's the player's hand which must be called before starting a new
		// round of game.
		hand.clear();
	}
}