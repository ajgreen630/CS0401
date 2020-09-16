public class Chance extends Score
{
	private int diceScore;
	private int oneFaces, twoFaces, threeFaces, fourFaces, fiveFaces, sixFaces;
	
	public Chance(String aName)
	{
		super(aName);
	}
	public int getDiceScore(DieInterface[] dice)
	{
		int oneScore, twoScore, threeScore, fourScore, fiveScore, sixScore;
		
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
		
			oneScore = oneFaces;
			twoScore = twoFaces * 2;
			threeScore = threeFaces * 3;
			fourScore = fourFaces * 4;
			fiveScore = fiveFaces * 5;
			sixScore = sixFaces * 6;
			
			diceScore = oneScore + twoScore + threeScore + fourScore + fiveScore + sixScore;
			
			return diceScore;
	}
}