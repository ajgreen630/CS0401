// CS 401 Spring 2019
// MyDeque class to implement a simple deque
// Complete the methods indicated.  Be careful about the
// special cases indicated.  See lab for details on how
// to implement the methods.

public class MyDeque implements SimpleDeque
{
	Object [] theData;
	int numItems;
	int maxItems;

	public MyDeque(int maxItem)
	{
		maxItems = maxItem;
		theData = new Object[maxItems];
		numItems = 0;
	}
	
	public boolean isEmpty()
	{
		return (numItems == 0);
	}
	
	public void addFront(Object X)
	{
		// Add new item at front of list (shifting old items
		// to right first).  If the list is full, do not add
		// the item (just do nothing).
		if (numItems != maxItems)
		{
			// Shift items in array to the right.
			for (int i = theData.length - 2; i >= 0; i--)
			{
				theData[i + 1] = theData[i];
			}
			theData[0] = X;
			numItems++;
		}
		
	}

	public void addRear(Object X)
	{
		// Add new item at rear of list.  If the list is full,
		// do not add the item (just do nothing).
		if (numItems != maxItems)
		{
			theData[numItems] = X;
			numItems++;
			
		}
	}

	public Object removeFront()
	{
		// Remove and return front item from list, shifting remaining
		// items to the left to fill the spot.  If list is empty,
		// return null.
		if (isEmpty())
		{
			return null;
		}
		else
		{
			Object frontItem = theData[0];
			theData[0] = null;
			
			Object [] tempData = new Object[maxItems];
			for (int i = 1; i < theData.length; i++)
			{
				tempData[i-1] = theData[i];
			}
			theData = tempData;
			numItems--;
			return frontItem;
		}
	}

	public Object removeRear()
	{
		// Remove and return rear item from list.  If list is empty,
		// return null.
		if (!isEmpty())
		{
			numItems--;
			return theData[numItems];
		}
		else
		{
			return null;
		}
	}
}
