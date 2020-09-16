// CS 0401 Spring 2019
// Lab 10
// You must modify this file so that it works as described in the lab handout.
import java.util.*;
import java.io.*;
public class Lab10
{
	public static void main(String [] args)
	{
		Scanner inScan, fScan = null;
		int [] A = new int[5];
		inScan = new Scanner(System.in);
		System.out.print("Please enter the file to read from: ");
		String fName = inScan.nextLine();
		
		boolean success = false;
		while (!success)
		{
			try
			{
				fScan = new Scanner(new File(fName));
				success = true;
			}
			catch (IOException e1)
			{
				System.out.println("Your file is invalid -- please re-enter");
				System.out.print("Please enter the file to read from: ");
				fName = inScan.nextLine();
			}
		}
		String nextItem;
		int nextInt = 0;
		int i = 0;
		
		while (fScan.hasNextLine())
		{
			nextItem = fScan.nextLine();
			try
			{
				nextInt = Integer.parseInt(nextItem);
				A[i] = nextInt;
				i++;
			}
			catch (NumberFormatException e2)
			{
				System.out.println(nextItem + " is not an integer -- ignored");
			}
			catch (ArrayIndexOutOfBoundsException e3)
			{
				int j = i * 2;
				System.out.println("Resizing array from " + i + " to " + j);
				int [] newArr = new int[j];
				for (int z = 0; z < A.length; z++)
				{
					newArr[z] = A[z];
				}
				
				A = newArr;
				A[i] = nextInt;
				i++;
			}

		}

		System.out.println("Here are your " + i + " items:");
		for (int j = 0; j < i; j++)
		{
			System.out.println(A[j] + " ");
		}
	}
}

