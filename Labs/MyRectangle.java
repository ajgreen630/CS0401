// CS 401 Lab 05
// Fill in the indicated code sections to complete this class.  Then test it
// by compiling and executing Lab05.java.

public class MyRectangle
{
	// Declare instance variables here.  See toString() method below for names.
	protected int startX;
	protected int startY;
	protected int startW;
	protected int startH;
	
	public MyRectangle()
	{
		startX = 0;
		startY = 0;
		startW = 0;
		startH = 0;
		// Default constructor -- initialize all instance variables
		// to 0
	}

	public MyRectangle(int x, int y, int w, int h)
	{
		startX = x;
		startY = y;
		startW = w;
		startH = y;
		
		// Initialize instance variables based on parameters shown.
		// Be careful to get the order correct!
	}

	public int area()
	{
		
		int area = startW * startH;
		return area;// Return the area of this Rectangle
	}

	// I have written this method for you.  Note how a StringBuilder is
	// utilized, since (as we discussed in lecture) it can be modified
	// without having to create a new object each time (unlike a String).
	public String toString()
	{
		StringBuilder S = new StringBuilder();
		S.append("Width: " + startW);
		S.append(" Height: " + startH);
		S.append(" X: " + startX);
		S.append(" Y: " + startY);
		return S.toString();
	}

	public boolean isInside(int x, int y)
	{
		
		if (x >= startX && x <= startX + startW && y >= startY && y <= startY + startH)
		{
			return true;
		}
		else
		{
			return false;
		}
		// This is the trickiest of the methods to write.  This should
		// return true if point (x,y) is anywhere within the borders of the
		// current MyRectangle (including the borders themselves).  Use a
		// pencil and paper to figure out how this can be determined with
		// just a few simple relational operations.
	}

	public void setSize(int w, int h)
	{
		startW = w;
		startH = h;
		// Update width and height as shown
	}

	public void setPosition(int x, int y)
	{
		startX = x;
		startY = y;
		// Update startX and startY as shown
	}

}
