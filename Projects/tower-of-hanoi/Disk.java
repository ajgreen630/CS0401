public class Disk
{
	// Immutable instance variables:
	private int diskSize;
	private String diskString;
	private char diskChar;
	private char poleChar;
	
	// Constructors:
	public Disk(int aDiskSize, char aDiskChar, char aPoleChar)
	{
		// Allows user to construct a disk with any size greater than 0.
		// aDiskChar and aPoleChar used to generate String representation
		// of an object of type Disk.
		if(aDiskSize <= 0)
		{
			diskSize = 1;
		}
		else
		{
			diskSize = aDiskSize;
		}
		
		diskChar = aDiskChar;
		poleChar = aPoleChar;
	}
	public Disk(int aDiskSize)
	{
		if(aDiskSize <= 0)
		{
			diskSize = 1;
		}
		else
		{
			diskSize = aDiskSize;
		}
		
		diskChar = '*';
		poleChar = '|';
	}
	
	// Accessor Methods:
	public int getSize()
	{
		// Returns the size of the disk integer.
		return diskSize;
	}
	public String toString()
	{
		// Returns the string presentation of a disk.
		String myString = "";
		for(int i = 0; i < diskSize; i++)
		{
			myString += diskChar;
		}
		myString += poleChar;
		for(int i = 0; i < diskSize; i++)
		{
			myString += diskChar;
		}
		// Set diskString:
		diskString = myString;
		
		return diskString;
	}
}