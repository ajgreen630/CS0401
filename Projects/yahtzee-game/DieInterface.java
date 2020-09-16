public interface DieInterface
{
	public static String[] dieFaces =
		{"+---+\n|   |\n| o |\n|   |\n+---+",
		 "+---+\n|o  |\n|   |\n|  o|\n+---+",
		 "+---+\n|o  |\n| o |\n|  o|\n+---+",
		 "+---+\n|o o|\n|   |\n|o o|\n+---+",
		 "+---+\n|o o|\n| o |\n|o o|\n+---+",
		 "+---+\n|o o|\n|o o|\n|o o|\n+---+"};

	public static String toDieString(DieInterface aDie)
	{
		return dieFaces[aDie.getFaceValue() - 1];
	}

	// Do not modify above this line

	public static String toDiceString(DieInterface[] dice)
	{
		StringBuilder result = new StringBuilder();

		// Add your code here.
		String[] dieOne = dieFaces[0].split("\n");
		String[] dieTwo = dieFaces[1].split("\n");
		String[] dieThree = dieFaces[2].split("\n");
		String[] dieFour = dieFaces[3].split("\n");
		String[] dieFive = dieFaces[4].split("\n");
		String[] dieSix = dieFaces[5].split("\n");
		
		result.append("+---+  +---+  +---+  +---+  +---+  \n");
		// Row 1:
		for(int i = 0; i < dice.length; i++)
		{
			if(dice[i].getFaceValue() == 1)
			{
				result.append(dieOne[1] + "  ");
			}
			else if(dice[i].getFaceValue() == 2)
			{
				result.append(dieTwo[1] + "  ");
			}
			else if(dice[i].getFaceValue() == 3)
			{
				result.append(dieThree[1] + "  ");
			}
			else if(dice[i].getFaceValue() == 4)
			{
				result.append(dieFour[1] + "  ");
			}
			else if(dice[i].getFaceValue() == 5)
			{
				result.append(dieFive[1] + "  ");
			}
			else if(dice[i].getFaceValue() == 6)
			{
				result.append(dieSix[1] + "  ");
			}
		}
		result.append("\n");
		// Row 2;
		for(int i = 0; i < dice.length; i++)
		{
			if(dice[i].getFaceValue() == 1)
			{
				result.append(dieOne[2] + "  ");
			}
			else if(dice[i].getFaceValue() == 2)
			{
				result.append(dieTwo[2] + "  ");
			}
			else if(dice[i].getFaceValue() == 3)
			{
				result.append(dieThree[2] + "  ");
			}
			else if(dice[i].getFaceValue() == 4)
			{
				result.append(dieFour[2] + "  ");
			}
			else if(dice[i].getFaceValue() == 5)
			{
				result.append(dieFive[2] + "  ");
			}
			else if(dice[i].getFaceValue() == 6)
			{
				result.append(dieSix[2] + "  ");
			}
		}
		result.append("\n");
		// Row 3:
		for(int i = 0; i < dice.length; i++)
		{
			if(dice[i].getFaceValue() == 1)
			{
				result.append(dieOne[3] + "  ");
			}
			else if(dice[i].getFaceValue() == 2)
			{
				result.append(dieTwo[3] + "  ");
			}
			else if(dice[i].getFaceValue() == 3)
			{
				result.append(dieThree[3] + "  ");
			}
			else if(dice[i].getFaceValue() == 4)
			{
				result.append(dieFour[3] + "  ");
			}
			else if(dice[i].getFaceValue() == 5)
			{
				result.append(dieFive[3] + "  ");
			}
			else if(dice[i].getFaceValue() == 6)
			{
				result.append(dieSix[3] + "  ");
			}
		}
		result.append("\n");
		result.append("+---+  +---+  +---+  +---+  +---+  \n");
		result.append("  1      2      3      4      5  ");
		
		return result.toString();
	}

	// Do not modify below this line
    public int roll();
	public int getFaceValue();
	
	// String s = "1 3 4 5";
	// int i = s.indexOf("1");  i will be 0.
	// i = s.indexOf("2");		i will be -1.
}
