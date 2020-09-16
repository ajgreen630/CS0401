import java.util.Scanner;
import java.math.*;

public class Lab02
{
	public static void main(String [] args)
	{
		Scanner inScan = new Scanner(System.in);

		System.out.print("Please enter an amount: ");
		double numAmount = Math.round(inScan.nextDouble() * 100.0) / 100.0;

		int numTwenty = (int)(numAmount / 20); // Twenty-dollar bills.
		// Update the remaining amount:
		numAmount = numAmount - (numTwenty * 20);

		int numTen = (int)(numAmount / 10); // Ten-dollar bills.
		// Update the remaining amount:
		numAmount = numAmount - (numTen * 10);

		int numFive = (int)(numAmount / 5); // Five-dollar bills.
		// Update the remaining amount:
		numAmount = numAmount - (numFive * 5);

		int numOne = (int)(numAmount / 1); // One-dollar bills.
		// Update the remaining amount:
		numAmount = numAmount - (numOne * 1);

		numAmount = Math.round(numAmount * 100);  
		// Cents will now round to the nearest integer. :)

		int numQuarter = (int)(numAmount / 25); // Quarters.
		// Update the remaining amount:
		numAmount = numAmount - (numQuarter * 25);


		int numDime = (int)(numAmount / 10); // Dimes.
		// Update the remaining amount:
		numAmount = numAmount - (numDime * 10);


		int numNickel = (int)(numAmount / 5); // Nickels.
		// Update the remaining amount:
		numAmount = numAmount - (numNickel * 5);

		int numPenny = (int)(numAmount / 1); // Pennies.

		System.out.print("You need the following:\n");
		System.out.print(numTwenty + " twenty-dollar bills(s),\n");
		System.out.print(numTen + " ten-dollar bills(s),\n");
		System.out.print(numFive + " five-dollar bills(s),\n");
		System.out.print(numOne + " one-dollar bill(s),\n");
		System.out.print(numQuarter + " quarter(s),\n");
		System.out.print(numDime + " dime(s),\n");
		System.out.print(numNickel + " nickel(s), and\n");
		System.out.print(numPenny + " penny(ies),\n");

	}
}

