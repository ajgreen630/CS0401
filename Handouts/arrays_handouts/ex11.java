// CS 0401 Sprint 2019
// Simple example of using arrays and text files

import java.util.*;
import java.io.*;  // import needed for Java file classes
public class ex11
{
	// Note again the "throws IOException" tags on various methods.  This is 
	// necessary for creating, reading or writing to Java files.

	public static void main(String [] args) throws IOException
	{
		// A Scanner is used for both the keyboard input and the file
		// input.  The only difference is in the argument to the constructor.
		Scanner keyIn = new Scanner(System.in);
		System.out.print("Input file name: ");
		String fName = keyIn.nextLine();
		File inFile = new File(fName);
		Scanner fileIn = new Scanner(inFile);
		
		int num = fileIn.nextInt();  // Read an int from the file that indicates
		           // how many values are in the rest of the file.

		// Note how the array size is determined dynamically.  This way,
		// the program will work for any properly formatted file.
		int [] A = new int[num];
		for (int i = 0; i < num; i++)
			 A[i] = fileIn.nextInt();
		fileIn.close();
		
		//A.length++;

		show(A);
		modify(A, keyIn);
		save(A, fName);
		
		// Uncomment the line below to see an example of appending to the
		// end of a file.  Note that this item will not be read in again when
		// the program is re-run, since the int indicating how many items are
		// to be read will not take this value into account.
		//addToEnd(99, fName);
	}

	// Demonstration of the "foreach" loop in Java.  This is useful if you
	// are only concerned with the data and not the indices.
	public static void show(int [] Ar)
	{
		for (int value : Ar)
			System.out.print(value + " ");
		System.out.println();
	}

	// Even though Java parameters are value, since we are passing a
	// reference to the method, this allows us to update the contents
	// of the array (i.e. mutate it) from within the method.
	public static void modify(int [] Ar, Scanner keyBoard)
	{
		int index = 0;
		do
		{
			System.out.print("Enter index you wish to update: ");
			index = keyBoard.nextInt();
		} while (index < 0 || index >= Ar.length);
		System.out.print("Enter new value: ");
		Ar[index] = keyBoard.nextInt();
	}

	// Note how the PrintWriter is used to output the array data back to
	// the text file.  Don't forget to close the file at the end --
	// otherwise some data may be lost.
	public static void save(int [] Ar, String fName) throws IOException
	{
		PrintWriter fileOut = new PrintWriter(fName);
		fileOut.println(Ar.length);
		for (int data : Ar)
			fileOut.println(data);
		fileOut.close();
	}
	
	// This method uses a FileOutputStream to enable an append to the end
	// of a file.  When a file is opened in this way, writing via printlns
	// begins at the end of the file, rather than at the beginning, thus
	// preserving the data that was previously in the file
	public static void addToEnd(int x, String fName) throws IOException
	{
		PrintWriter fileOut = new PrintWriter(new FileOutputStream(fName,true));
												// FileOutputStream allows file
												// to be opened in "append" mode
		fileOut.println(""+x);
		fileOut.close();
	}
}
