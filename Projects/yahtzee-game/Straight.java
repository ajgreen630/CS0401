public class Straight extends Score
{
	private int consecutiveFaces;
	private int diceScore;
	
	public Straight(String aName, int numConsecutiveFaces)
	{
		super(aName);
		consecutiveFaces = numConsecutiveFaces;
	}
	public int getDiceScore(DieInterface[] dice)
	{
		int counter = 1;
		for(int i = 1; i < dice.length; i++)
		{
			if(dice[i].getFaceValue() == (dice[i - 1].getFaceValue() + 1))
			{
				counter++;
			}
			else
			{
				counter = 1;
			}
		}
		
		if(consecutiveFaces == 4)
		{
			if(counter == 4)
			{
				diceScore = 30;
			}
		}
		else if(consecutiveFaces == 5)
		{
			if(counter == 5)
			{
				diceScore = 40;
			}
		}
		return diceScore;
	}
}