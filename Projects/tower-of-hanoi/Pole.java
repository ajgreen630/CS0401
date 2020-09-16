import java.util.*;
import java.text.*;

public class Pole
{
	private Disk[] disks;
	private int numberOfDisks;
	private int maxNumberOfDisks;
	private int maxDiskSize;
	private char poleChar;
	
	// Constructors:
	public Pole (int aMaxNumberOfDisk, int aMaxDiskSize, char aPoleChar)
	{
		if (aMaxNumberOfDisk < 1)
		{
			maxNumberOfDisks = 1;
		}
		else
		{
			maxNumberOfDisks = aMaxNumberOfDisk;
		}
		numberOfDisks = 0;
		maxDiskSize = aMaxDiskSize;
		poleChar = aPoleChar;
		disks = new Disk[maxNumberOfDisks];
		/*for (int i = maxNumberOfDisks; i > 0; i--)
		{
			Disk toAdd = new Disk(i);
			addDisk(toAdd);
		}*/
	}
	
	public Pole (int aMaxNumberOfDisk, int aMaxDiskSize)
	{
		if (aMaxNumberOfDisk < 1)
		{
			maxNumberOfDisks = 1;
		}
		else
		{
			maxNumberOfDisks = aMaxNumberOfDisk;
		}
		numberOfDisks = 0;
		maxDiskSize = aMaxDiskSize;
		disks = new Disk[maxNumberOfDisks];
		poleChar = '|';
		/*for (int i = maxNumberOfDisks; i > 0; i--)
		{
			Disk toAdd = new Disk(i);
			addDisk(toAdd);
		}*/
	}
	
	public Pole (int aMaxNumberOfDisk)
	{
		if (aMaxNumberOfDisk < 1)
		{
			maxNumberOfDisks = 1;
		}
		else
		{
			maxNumberOfDisks = aMaxNumberOfDisk;
		}
		numberOfDisks = 0;
		maxNumberOfDisks = aMaxNumberOfDisk;
		poleChar = '|';
		maxDiskSize = aMaxNumberOfDisk;
		disks = new Disk[maxNumberOfDisks];
		/*for (int i = maxNumberOfDisks; i > 0; i--)
		{
			Disk toAdd = new Disk(i);
			addDisk(toAdd);
		}*/
	}
	
	// Accessors Methods:
	public int getMaxNumberOfDisks()
	{
		return maxNumberOfDisks;
	}
	
	public int getMaxDiskSize()
	{
		return maxDiskSize;
	}
	
	public int getNumberOfDisks()
	{
		return numberOfDisks;
	}
	
	public Disk peekTopDisk()
	{
		for (int i = disks.length - 1; i >= 0; i--)
		{
			if (disks[i] != null)
			{
				return disks[i];
			}
		}
		
		return null;
	}
	
	public String toString()
	{
		String poleString = "";
		String myString = "";
		String baseString = "";
		// For the top pole decoration:
		for (int k = 0; k < maxDiskSize; k++)
		{
			myString += " ";
		}
		myString += poleChar;
		for (int z = 0; z < maxDiskSize; z++)
		{
			myString += " ";
		}
		myString += "\n";
		// For the actual pole graphic:
		for(int i = disks.length - 1; i >= 0; i--)
		{
			int j = 0;
			
			if(disks[i] != null)
			{
				j = disks[i].getSize();
			}
			for(int h = 0; h < maxDiskSize - j; h++)
			{
				myString += " ";
			}
			for(int m = 0; m < j; m++)
			{
				myString += "*";
			}
			
			myString += poleChar;
			
			for(int n = 0; n < j; n++)
			{
				myString += "*";
			}
			for(int p = 0; p < maxDiskSize - j; p++)
			{
				myString += " ";
			}
			for(int r = 0; r < maxDiskSize - j; r++)
			{
				baseString += "=";
			}
			
			myString += "\n";
		}
		myString += baseString;	
		poleString = myString;
		return poleString;
	}	
	
	// Mutators:
	public boolean addDisk(Disk aDisk)
	{
		if (aDisk.getSize() > maxDiskSize || numberOfDisks == maxNumberOfDisks)
		{
			return false;
		}
		disks[numberOfDisks] = aDisk;
		numberOfDisks++;
		return true;
	}
	
	public Disk removeDisk()
	{
		Disk myTopDisk = peekTopDisk();
		
		for (int i = (disks.length- 1); i >= 0; i--)
		{
			if (disks[i] != null)
			{
				disks[i] = null;
				numberOfDisks --;
				return myTopDisk;
			}
		}
		return null;
	}
	
	public boolean isEmpty()
	{
	    return numberOfDisks == 0;
	}
	
	public boolean isFull()
	{
	    return numberOfDisks == maxNumberOfDisks;
	}
}
/*
		|             |
	   *|*            |
	  **|**           |
	 ***|***          |
	****|****		  |
  ============= =============
  */