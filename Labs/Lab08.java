import java.util.*;
public class Lab08
{
	public static void reverse(int[] data)
	{
		recursive_reverse(data, 0, data.length - 1);
	}
	
	public static void recursive_reverse(int[] data, int firstIndex, int lastIndex)
	{
		if (firstIndex > lastIndex)
		{
			data = data;
		}
		else
		{
			int tempIndex = data[firstIndex];
			data[firstIndex] = data[lastIndex];
			data[lastIndex] = tempIndex;
			recursive_reverse(data, ++firstIndex, --lastIndex);
		}
	}
	
	public static void showIntArray(int[] data)
	{
		System.out.println(Arrays.toString(data));
	}
	
	public static void main(String[] args)
	{
		int[] myData = {12, 5, 7, 2, 6, 32, 1, 9, 44};
		// Showed to TA that it also reverses properly
		// when we remove 44 from the array.
		showIntArray(myData);
		reverse(myData);
		showIntArray(myData);
	}
	
	// First lab where I didn't need help.  Suck it.
}