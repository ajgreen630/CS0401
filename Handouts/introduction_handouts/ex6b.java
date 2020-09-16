/* CS 0401 Spring 2019 Java Example 6b
   This example demonstrates the switch statement as well as simple formatting
   of numeric output, this time using printf rather than NumberFormat.
   Compare to ex6.java.  I have removed the previous comments.
*/
import java.util.*;

public class ex6b
{	
	public static void main (String [] args)
	{
		Scanner inScan = new Scanner(System.in);

		String title;
		int stars;
		double gross;
		boolean valid;
	   
		System.out.println("Welcome to the Movie Tracker Program");
		System.out.print("Would you like to rate a movie? (yes/no): ");
		String test = inScan.next();
		while (test.equals("yes"))
		{
			inScan.nextLine(); 
			System.out.print("Please enter the movie name: ");
			title = inScan.nextLine();
			System.out.print("Please enter number of stars (0-5): ");
			stars = inScan.nextInt();
			System.out.print("Please enter the gross: $");
			gross = inScan.nextDouble();
			System.out.println();

			valid = true;
			switch (stars)
			{
				case 0:
				case 1:
					System.out.println(title + " is a bomb!");
					System.out.println("Don't waste your money!");
					break;
				case 2:
					System.out.println(title + " is only fair.");
					System.out.println("Wait for the DVD");
					break;
				case 3:
				case 4:
					System.out.println(title + " is pretty good.");
					System.out.println("Worth the entry price");
					break;
				case 5:
					System.out.println(title + " is excellent!");
					System.out.println("See it again!");
					break;
				default:
					System.out.println("Your input was invalid!");
					valid = false;
			}

			// The printf statement allows output to be produced using a
			// formatting string.  Note that there are two arguments to printf
			// below.  The first is a string containing both output and
			// and formatting information.  The second is the data that will
			// be shown in the formatted way.  See Section 3.10 for more
			// information on printf
			if (valid)
			{
				System.out.printf("Total Gross: $%,.2f\n", gross);
				//System.out.println(gross);
				System.out.println();
			}
			System.out.print("Would you like to rate a movie? (yes/no): ");
			test = inScan.next();
		}
	}
}
