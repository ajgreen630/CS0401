public class OfAKind extends Score
{
	private int numFaces;
	private int diceScore;
	private int oneFaces, twoFaces, threeFaces, fourFaces, fiveFaces, sixFaces;
	
	public OfAKind(String aName, int numSameFaces)
	{
		super(aName);
		numFaces = numSameFaces;
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
		if(numFaces == 3 || numFaces == 4)
		{
			if(oneFaces >= numFaces || twoFaces >= numFaces || threeFaces >= numFaces || fourFaces >= numFaces || fiveFaces >= numFaces || sixFaces >= numFaces)
			{
				oneScore = oneFaces;
				twoScore = twoFaces * 2;
				threeScore = threeFaces * 3;
				fourScore = fourFaces * 4;
				fiveScore = fiveFaces * 5;
				sixScore = sixFaces * 6;
				
				diceScore = oneScore + twoScore + threeScore + fourScore + fiveScore + sixScore;
			}	
		}
		else if (numFaces == 5)
		{
			if(oneFaces == 5 || twoFaces == 5 || threeFaces == 5 || fourFaces == 5 || fiveFaces == 5 || sixFaces == 5)
			{
				diceScore = 50;
			}
		}
		return diceScore;
	}
}