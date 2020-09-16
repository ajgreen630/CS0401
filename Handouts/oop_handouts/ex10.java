/* CS 0401 Spring 2019 Java Example 10
   Simple demonstration of using a simple class.  See also IntCircle.java
*/
public class ex10
{
	public static void main (String [] args)
	{
		// Two circle variables, but no objects yet
		IntCircle C1 = null, C2 = null;

		// Now create objects using the CONSTRUCTOR
		C1 = new IntCircle(2);
		C2 = new IntCircle(4);

		IntCircle C3 = new IntCircle();

		// Using the ACCESSORS
		System.out.println(C1.toString() + " Area: " + C1.area() +
			               " Circumference: " + C1.circumference());
		System.out.println(C2 + " Area: " + C2.area() +
			               " Circumference: " + C2.circumference());
		System.out.println(C3 + " Area: " + C3.area() +
			               " Circumference: " + C3.circumference());

		// Using the MUTATOR to change the radius
		C1.setRadius(3);
		System.out.println(C1 + " Area: " + C1.area() +
			" Circumference: " + C1.circumference());

		C1.setRadius(-10);  // See how IntCircle handles this
		
		// Note: Since the data is private we are NOT allowed to do the
		// following:
		//C1.radius = -5;
		//System.out.println("Radius: " + C1.radius);
		System.out.println(C1 + " Area: " + C1.area() +
			" Circumference: " + C1.circumference());
		// Uncomment the lines above to see the resulting error.  This is why
		// we use accessor methods and mutator methods to access the data.
		// Also change the declaration of radius in IntCircle to public to see
		// that the lines above would then be legal.  However, in that case we
		// would not be able to "protect" the circle from the assignment of a
		// negative radius.
		
		C1 = new IntCircle(3);
		C2 = new IntCircle(3);
		C3 = C1;
		System.out.println("Testing C1 and C2:");
		test(C1, C2);
		System.out.println("Testing C1 and C3:");
		test(C1, C3);
		C1.setRadius(2);
		System.out.println("Are C1 and C3 still the same?");
		test(C1, C3);
	}
	
	// Comparing IntCircles using == and equals()
	public static void test(IntCircle A, IntCircle B)
	{
		if (A == B)
			System.out.println(A + " and " + B + " are the same object");
		if (A.equals(B))
			System.out.println(A + " and " + B + " have the same data");
	}
}
