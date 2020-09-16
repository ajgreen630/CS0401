public class UpperSectionScore extends Score
{
	private int number;
	private int diceScore;
	
	public UpperSectionScore(String aName, int aNumber)
	{
		super(aName);
		number = aNumber;
	}
	public int getDiceScore(DieInterface[] dice)
	{
		for(int i = 0; i < dice.length; i++)
		{
			if(dice[i].getFaceValue() == number)
			{
				diceScore++;
			}
		}
		return diceScore;
	}
}