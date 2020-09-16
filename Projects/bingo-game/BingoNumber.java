public class BingoNumber
{
	private int number;
	private int var;
	
	// Constructors:
	public BingoNumber(int aNumber)
	{
		number = aNumber;
		var = 0;
	}
	// Accessor methods:
	public int getNumber()
	{
		return number;
	}
	public boolean isMarked()
	{
		if (var != 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public String toString()
	{
		if (isMarked()){
			return "XX";
		}
		else
		{
			return toNumberString();
		}
			
	}
	public String toNumberString()
	{
		return String.valueOf(number);
	}
	public void mark()
	{
		var = 1;
		isMarked();
	}
}