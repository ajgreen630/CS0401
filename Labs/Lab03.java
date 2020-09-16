import java.util.*;
import java.math.*;

public class Lab03
{
	public static void main(String [] args)
	{
		
		System.out.println("Log base b of x Calculator");
		System.out.println("--------------------------");
		
		System.out.println("Please enter a base b (> 1): ");
		Scanner inScan = new Scanner(System.in);
		
		int numBase = inScan.nextInt();
		// User must enter a base b greater than or equal to 1, or else the program will end.
		while (numBase >= 1)
		{
			inScan = new Scanner(System.in);
			
			System.out.println("Please enter a value x (> 0): ");
			int numValue = inScan.nextInt();
			
			int numY = numValue;
			
			while (numValue <= 0)
			{
				System.out.println("Invalid value for x... Please enter a value x (> 0): ");
				numValue = inScan.nextInt();
			}
			numY = numValue;
			
			int n = 0;
			int m = 0;
			
			for (n = 0; numY >= numBase; n++)
			{
				m++;
				numY = numY/numBase;
			}
			
			System.out.println("Log base " + numBase + " of " + numValue + " is " + m);
			
			System.out.println("Please enter a base b (> 1): ");
			numBase = inScan.nextInt();
		}
		
		System.out.print("Goodbye!");
	}
}