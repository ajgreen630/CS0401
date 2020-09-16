import java.io.*;
import java.util.*;

public class Lab06
{
	public static void main(String[] args)
	{
		Scanner userINP = new Scanner(System.in);
		int itemAmount;
		double userArray[];
		
		System.out.print("How many items would you like to enter? ");
		itemAmount = userINP.nextInt();
		
		userArray = new double[itemAmount];
		
		System.out.print("Please enter the " + itemAmount + " values now: ");
		
		for (int i = 0; i < userArray.length; i++)
		{
			userArray[i] = userINP.nextDouble();
		}
		
		System.out.println("These are the values you entered: ");
		printArray(userArray);
		System.out.println(" ");
		
		System.out.println("The maximum value in the array is: ");
		System.out.println(max(userArray));
		
		System.out.println("The minimum value in the array is: ");
		System.out.println(min(userArray));
		
		System.out.println("The sum of all of the values in the array is: ");
		System.out.println(sum(userArray));
		
		System.out.println("The average of the values is: ");
		System.out.println(ave(userArray));
	}
	
	public static void printArray(double arr[])
	{
		int arrayLength = arr.length;
		
		for (int i = 0; i < arrayLength; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}
	
	public static double max(double arr[])
	{
		int arrayLength = arr.length;
		double max = arr[0];
		for (int i = 1; i < arrayLength; i++) 
		{
			if (arr[i] > max)
			{
				max = arr[i];
			}
		}
		
		return max;
	}
	
	public static double min(double arr[])
	{
		int arrayLength = arr.length;
		double min = arr[0];
		for (int i = 1; i < arrayLength; i++)
		{
			if (arr[i] < min)
			{
				min = arr[i];
			}
		}
		
		return min;
	}
	
	public static double sum(double arr[])
	{
		double sum = 0;
		
		for (double i : arr)
		{
			sum += i;
		}
		
		return sum;
	}
	
	public static double ave(double arr[])
	{
		double ave = 0;
		double sum = 0;
		sum = sum(arr);
		
		ave = sum / 2;
		
		return ave;
		
		
	}
}