import java.util.*;
public class TestDeque
{
	public static void main(String[] args)
	{
		int maxItems = 10;
		int[] x = new int[maxItems];
		int numItems = 0;
		int addItem = 1;
		int turnNum = 1;
		
		System.out.println("Array before any objects are added:");
		System.out.println(Arrays.toString(x));
		
		while(numItems != maxItems)
		{
			// Shift items in array to the right.
			for (int i = x.length - 2; i >= 0; i--)
			{
				x[i + 1] = x[i];
			}
			x[0] = addItem;
			numItems++;
			addItem++;
			System.out.println("Turn " + turnNum);
			System.out.println(Arrays.toString(x));
			turnNum++;
		}
		
		int frontNum = x[0];
		System.out.println("Let's remove " + frontNum + " from the array.");
		x[0] = 0;
		System.out.println("Here is the updated array without " + frontNum);
		System.out.println(Arrays.toString(x));
		System.out.println();
		System.out.println("Shifting all objects in the array to the  left.");
		for (int j = 0; j <= x.length - 1; j++)
		{
			x[j] = x[j + 1];
		}
		x[x.length - 1] = frontNum;
		System.out.println(Arrays.toString(x));
	}
}