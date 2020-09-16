import java.util.*;
public class Die implements DieInterface
{
	// You need to implement roll() and getFaceValue() from DieInterface.
	
	Random random = new Random();
	private int maxRoll = 6;
	private int minRoll = 1;
	private int rollNumber;
	private int faceValue;
	
	public Die()
	{
		rollNumber = random.nextInt(maxRoll + 1 - minRoll) + minRoll;
	}
	public int roll()
	{
		rollNumber = random.nextInt(maxRoll + 1 - minRoll) + minRoll;
		
		return rollNumber;
	}
	public int getFaceValue()
	{
		faceValue = rollNumber;
		return faceValue;
	}
	public String toString()
	{
		StringBuilder dieNumber = new StringBuilder();
		dieNumber.append("Die: ");
		dieNumber.append(faceValue);
		
		return dieNumber.toString();
	}
}