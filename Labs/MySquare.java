public class MySquare extends MyRectangle
{
	// No instance variables needed.
	
	public MySquare(int x, int y, int side)
	{
		super(x, y, side, side);
	}
	public MySquare()
	{
		super(0, 0, 0, 0);
	}
	public String toString()
	{
		StringBuilder S = new StringBuilder();
		
		S.append("Side: " + startW);
		S.append(" X: " + startX);
		S.append(" Y: " + startY);
		return S.toString();
	}
	public void setSize(int w, int h)
	{
		if (w == h)
		{
			super.setSize(w, h);
		}
		else
		{
			System.out.println("Sides must be equal, " + w + " != " + h + " so no action taken");
		}
	}
	public void setSide(int side)
	{
		super.setSize(side, side);
	}
}