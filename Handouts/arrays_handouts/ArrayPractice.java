import java.util.*;

public class ArrayPractice
{
	// including max
	public static int[] getRandomArray(int numberOfElements, int min, int max)
	{
		Random rand = new Random();

		int[] array = new int[numberOfElements];

		for(int index = 0; index < numberOfElements; index++)
		{
			array[index] = min + rand.nextInt((max - min) + 1);
		}

		return array;
	}

	public static void printArray(int[] anArray)
	{
		System.out.print("[");
		for(int index = 0; index < anArray.length - 1; index++)
		{
			System.out.print(anArray[index] + ",");
		}
		System.out.println(anArray[anArray.length - 1] + "]");
	}

	public static int indexOf(int aValue, int[] anArray)
	{
		for(int index = 0; index < anArray.length; index++)
		{
			if(anArray[index] == aValue)
				return index;
		}

		return -1;
	}

	public static boolean contains(int aValue, int[] anArray)
	{
		return indexOf(aValue, anArray) != -1;
	}

	public static int frequencyOf(int aValue, int[] anArray)
	{
		int counter = 0;

		for(int index = 0; index < anArray.length; index++)
		{
			if(anArray[index] == aValue)
				counter++;
		}

		return counter;
	}

	public static int mostFrequent(int[] anArray, int lowest, int highest)
	{
		int mostFrequentValue;
		int maxFrequentValue;

		mostFrequentValue = lowest;
		maxFrequentValue = frequencyOf(lowest, anArray);

		for(int value = lowest + 1; value <= highest; value++)
		{
			int freq = frequencyOf(value, anArray);
			if(freq > maxFrequentValue)
			{
				maxFrequentValue = freq;
				mostFrequentValue = value;
			}
		}

		return mostFrequentValue;
	}

	public static void main(String[] args)
	{
		int[] anArray = getRandomArray(1000, 24, 196);
		printArray(anArray);
		System.out.println(mostFrequent(anArray, 24, 196));
	}
}




















