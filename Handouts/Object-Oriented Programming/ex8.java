// CS 0401 Spring 2019 Java Example 8
//   This handout demonstrates some issues relating to reference variables and
//   using them correctly to access objects.

public class ex8
{
	public static void main (String [] args)
	{
		// The StringBuilder class is related to the String class.  See
		// Sections 2.9 and 9.3 in the text for details on the String class.
		// (StringBuilder itself is discussed in Section 9.4.  However, we
		// are just looking at it superficially here.) StringBuilder objects
		// can also store and access strings of text.  However, unlike String
		// class objects, StringBuilder class objects can be modified after
		// they are created.  We will look more at the benefits of each later
		// on.
		StringBuilder S1, S2;
		S1 = new StringBuilder("Hello");
		System.out.println("S1 is " + S1.toString());
		//System.out.println("S2 is " + S2.toString());  // This will give a compilation
		                    // error -- variable might not have been initialized
		S2 = null;
		//System.out.println("S2 is " + S2.toString()); // This will give a
							// NullPointerException
		S2 = S1;
		System.out.println("S2 is " + S2.toString());  // This will work but note that
							// S2 and S1 are references to a single object.
		
		//System.out.println(S2.value[0]);
		System.out.println(S2.charAt(0));
		//System.out.println(S2.value.length);
		// The statements above are accessing data that exists within the
		// StringBuilder but that is not accessible to the user.  Remove the
		// comments and see what happens when you compile the program.  We will
		// discuss this more soon. 

		// updating object via S1.  Note that S2 also reflects the change
		S1.append(" there Java maestros!");
		System.out.println("S1 is " + S1);  // If an object is in a println statement
					// with no method call, then implicitly the "toString()" method
					// for that object will be called.
		System.out.println("S2 is " + S2.toString());

		StringBuilder S3 = new StringBuilder("Hello there Java maestros!");
		if (S1 == S2)	// comparing references
			System.out.println(S1.toString() + " == " + S2);
		if (S1 != S3)
			System.out.println(S1 + " != " + S3);
		if (S1.toString().equals(S3.toString()))  // comparing actual strings
			System.out.println(S1 + " equals " + S3);

		S1 = null;  // Now S1 cannot be accessed using the "dot" notation but
		            // S2 still refers to the same object
		//S1.append(" This is not allowed");
		S2.append(" This is ok");
		System.out.println("S1 is " + S1);  // Even though S1 is null this is allowed
					// because of a special case that is handled in the println
					// statement.  Note the output.
		System.out.println("S2 is " + S2);

		// Additional interesting note about the String class:
		// The first initialization below is assigning a String without
		// using the new operator, while the second uses new.  Java
		// Strings cannot be changed (i.e. they are constant), and String
		// literals implicitly create objects that are "interned" -- or
		// shared among all literals that are the same.  Thus, St1 and
		// St3 below are == whereas St1 and St2 are not (since a new
		// object is made for St2).
		String St1;
		St1 = "Herb";
		String St2 = new String("Herb");
		String St3 = "Herb";

		if (St1 == St2)
			System.out.println("St1 and St2 Equal");
		if (St1 == St3)
			System.out.println("St1 and St3 Equal");
		if (St1.equals(St2))
			System.out.println("St1 and St2 have same data");
			
	}
}
