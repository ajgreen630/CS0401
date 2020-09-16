public class FullHouse extends Score
{
	private int diceScore;
	private int oneFaces, twoFaces, threeFaces, fourFaces, fiveFaces, sixFaces;
	
	public FullHouse(String aName)
	{
		super(aName);
	}
	public int getDiceScore(DieInterface[] dice)
	{
		for(int i = 0; i < dice.length; i++)
		{
			if(dice[i].getFaceValue() == 1)
			{
				oneFaces++;
			}
			else if(dice[i].getFaceValue() == 2)
			{
				twoFaces++;
			}
			else if(dice[i].getFaceValue() == 3)
			{
				threeFaces++;
			}
			else if(dice[i].getFaceValue() == 4)
			{
				fourFaces++;
			}
			else if(dice[i].getFaceValue() == 5)
			{
				fiveFaces++;
			}
			else if(dice[i].getFaceValue() == 6)
			{
				sixFaces++;
			}
		}
		if(oneFaces == 3 || twoFaces == 3 || threeFaces == 3 || fourFaces == 3 || fiveFaces == 3 || sixFaces == 3)
		{
			if(oneFaces == 2 || twoFaces == 2 || threeFaces == 2 || fourFaces == 2 || fiveFaces == 2 || sixFaces == 2)
			{
				diceScore = 25;
			}
		}
		return diceScore;
	}
}