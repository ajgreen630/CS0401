import java.util.*;
public class BingoCage
{
	private BingoBall[] cage;
	private ArrayList<BingoBall> cageList;
	private BingoBall ball;
	
	public BingoCage()
	{
		// A constructor that constructs a Bingo cage containing
		// 75 unique Bingo balls (75 objects of type BingoBall).
		cage = new BingoBall[75];
		int ballNumber = 1;
		for (int i = 0; i < 75; i++)
		{
			cage[i] = new BingoBall(ballNumber);
			ballNumber++;
		}
		
		cageList = new ArrayList<BingoBall>(Arrays.asList(cage));
	}
	public BingoBall draw()
	{
		Random rand = new Random();
		// Randomly return a Bingo ball (object of type BingoBall).
		if (cageList.size() != 0)
		{
			Collections.shuffle(cageList);
			BingoBall aBall = cageList.get(0);
			cageList.remove(0);
			return aBall;
			
		}
		// If there are no more Bingo balls left, this method should
		// return null.
		else
		{
			return null;
		}
	}
	public void reset()
	{
		cageList = new ArrayList<BingoBall>(Arrays.asList(cage));
	}
}