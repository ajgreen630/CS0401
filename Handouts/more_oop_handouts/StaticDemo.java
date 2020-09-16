// CS 0401 Spring 2019
// Demonstration of static variables
import java.util.Scanner;
public class StaticDemo
{		
	public static void main(String [] args)
	{
		Comment com1, com2;
		com1 = new Comment("Hello");
		System.out.println("Comment: " + com1 + " Number: " + com1.howMany());
		com2 = new Comment("There");
		System.out.println("Comment: " + com1 + " Number: " + com1.howMany());
		System.out.println("Comment: " + com2 + " Number: " + com2.howMany());
		
		Comment [] C = new Comment[10];
		System.out.println("Comment: " + com1 + " Number: " + com1.howMany());
		
		for (int i = 0; i < C.length; i++)
		{
			C[i] = new Comment("Wacky");
		}
		
		System.out.println("Comment: " + com1 + " Number: " + com1.howMany());
		System.out.println("Comment: " + C[C.length-1] + " Number: " + C[C.length-1].howMany());
	}
}

class Comment
{
	private static int num;  // static variable -- shared among all objects
	
	private String value;  // instance variable -- separate copy for each object
	
	public Comment(String newC)
	{
		num++;
		value = new String(newC);
	}
	
	public int howMany()
	{
		return num;
	}
	
	public String toString()
	{
		return value;
	}
}
