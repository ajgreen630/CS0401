public class TowerOfHanoi
{
	// Instance variables:
	private int numberOfDisks;
	private int poleNumber;
	private Pole[] poles;
	/* Other possible instance variables?
	private Disk[] disks;
	private Disk ..?; Do I need to contruct a
	                  a separate disk object?
	*/
	
	// Constructors:
	public TowerOfHanoi()	// Default constructor.
	{
		numberOfDisks = 7;
		poles = new Pole[3];
		for (int i = 0; i < poles.length; i++)
		{
			poles[i] = new Pole(7, 7);
		}
		for (int i = numberOfDisks; i > 0; i--)
		{
			Disk aDisk = new Disk(i);
			poles[0].addDisk(aDisk);
		}
		// All of the disks are stacked on pole #1 (index 0).  Pole #2 and pole #3 are empty.
	}
	public TowerOfHanoi(int aNumberOfDisks)
	{
		// Allows user to play Tower of Hanoi puzzle with a valid numberOfDisks
		// greater than or less than 7...
		if(aNumberOfDisks < 1)
		{
			numberOfDisks = 1;
		}
		else
		{
			numberOfDisks = aNumberOfDisks;
		}
		// Copy for loop from first constructor into this one?
		poles = new Pole[3];
		for (int i = 0; i < poles.length; i++)
		{
			poles[i] = new Pole(numberOfDisks, numberOfDisks);
		}
		for (int i = numberOfDisks; i > 0; i--)
		{
			Disk aDisk = new Disk(i);
			poles[0].addDisk(aDisk);
		}
	}
	
	// Accessor Methods:
	public Disk peekTopDisk(int aPoleNumber)
	{
		Pole currentPole = poles[aPoleNumber - 1];
		return currentPole.peekTopDisk();
		// Returns a reference to the top disk of a given pole.
		
	}
	public int getNumberOfDisks(int aPoleNumber)
	{
		Pole currentPole = poles[aPoleNumber - 1];
		return currentPole.getNumberOfDisks();
	}
	public String toString()
	{
		String myString = "";
		String baseString = "";
		for (int i = 0; i <= numberOfDisks; i++)
		{
			String [] split;
			for (int j = 0; j < poles.length; j++)
			{
				String temp = poles[j].toString();
				split= temp.split("\n");
				myString+=split[i];
			}
			
			myString += "\n";
		}
		return myString;
	}
	
	// Mutator Methods:
	public boolean move(int fromPole, int toPole)
	{
		// Moves top disk from fromPole to where fromPole and toPole are 1, 2, or 3.
		// "
		
		// if fromPole or toPole are not 1,2,3.. then return false
		if (fromPole < 1 || fromPole > 3 || toPole < 1 || toPole > 3)
		{
		    return false;
		}
		
		fromPole--;
		toPole--;
		
		// if fromPole is empty, then return false
		if (poles[fromPole].isEmpty())
		{
		    return false;
		}
		
		// if toPole is full , then return false
		if (poles[toPole].isFull())
		{
		    return false;
		}
		
		// move top disk from fromPole to toPole
		// Use removeDisk on fromPole, and addDisk on toPole?
		boolean diskMoved = false;
		Disk topDisk = poles[fromPole].removeDisk();
		if (topDisk != null) {
			diskMoved = poles[toPole].addDisk(topDisk);
		    if (!diskMoved) {
		       poles[fromPole].addDisk(topDisk);
		    }
		}
		
		return diskMoved;
	}
	public void reset()
	{
		for (int i = 0; i < poles.length; i++)
		{
			poles[i] = new Pole(7, 7);
		}
		for (int i = numberOfDisks; i > 0; i--)
		{
			Disk aDisk = new Disk(i);
			poles[0].addDisk(aDisk);
		}
	    
	}
}
