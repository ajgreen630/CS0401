// NOTE: Unfortunately due to time constraints the game itself is unplayable, but most of the project is complete.
// I uploaded it to demonstrate a solid understanding of the surface of OOP, and I plan on polishing the code later
// so that the game can properly run.
import java.util.*;
import java.io.*;
public class TowerOfHanoiPuzzle
{
	public static void main(String[] args)
	{
		Scanner inScan = new Scanner(System.in);
		int playChoice;
		
		System.out.println("Welcome to the Tower of Hanoi Puzzle!");
		System.out.println("Do you wish to play or exit?");
		System.out.println("	1. Play a Tower of Hanoi Puzzle");
		System.out.println("	2. Exit");
		// User picks on of the menu options:
		playChoice = inScan.nextInt();
		
		while(playChoice != 1 && playChoice != 2)
		{
			System.out.println("Sorry, that is an invalid entry.");
			System.out.println("Please enter either 1 or 2.");
			System.out.println("	1. Play a Tower of Hanoi Puzzle");
			System.out.println("	2. Exit");
			playChoice = inScan.nextInt();
		}
		while(playChoice != 2)
		{
			int numDisk;
			String yesNo;
			
			System.out.print("How many disks would you like to play (between 1 and 64): ");
			numDisk = inScan.nextInt();
			while (numDisk < 1 || numDisk > 64)
			{
				System.out.println("Out-of-range!");
				System.out.print("Please choose a number of disks between 1 and 64: ");
				numDisk = inScan.nextInt();
			}
			
			TowerOfHanoi myTower = new TowerOfHanoi(numDisk);
			System.out.println(myTower.toString());
			System.out.println();
			System.out.println("The goal is to move all " + numDisk + " from pole 1 to pole 3.");
			int leastNumber = (int) Math.pow(2, numDisk);	
			System.out.println("The least number of moves for " + numDisk + " disks is " + leastNumber + ".");
			System.out.print("Are you ready to play? (y/n): ");
			yesNo = inScan.next();
			
		}
	}
}
