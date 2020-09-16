public abstract class Score implements ScoreInterface
{
	protected String name;
	private int score;
	private boolean firstCall;
	private boolean isUsed;
	
	public Score(String aName)
	{
		name = aName;
		firstCall = true;
	}
	public String getName()
	{
		return name;
	}
	public int getScore()
	{
		if(firstCall)
		{
			firstCall = false;
			return 0;
		}
		else
		{
			return score;
		}
	}
	abstract public int getDiceScore(DieInterface[] dice);
	public void setScore(DieInterface[] dice)
	{
		score = getDiceScore(dice);
		isUsed = true;
	}
	public boolean isUsed()
	{
		return isUsed;
	}
	public void reset()
	{
		score = 0;
		isUsed = false;
	}
	
	public String toString()
	{
		String scoreString = String.format("%3d", score);
		return name + ": " + scoreString;
	}
}