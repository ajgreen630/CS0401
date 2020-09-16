import java.util.*;
public class Yahtzee
{
	public static void main(String[] args)
	{
		Scanner inScan = new Scanner(System.in);
		System.out.println("Welcome!");
		System.out.print("Would you like to play Yahztee? (y/n): ");
		String playRound = inScan.nextLine();
		
		while(!playRound.equals("y") && !playRound.equals("n"))
		{
			System.out.print("Error. Please enter y or n to proceed: ");
			playRound = inScan.nextLine();
		}
		while(playRound.equals("y"))
		{
			System.out.print("Please enter your name: ");
			// User's name:
			String myName = inScan.nextLine();
			
			// Create the variables for the Yahtzee scoring card:
				// UpperSectionScore:
			String[] upperScoreName = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes"};
			ScoreInterface[] upperScore = new ScoreInterface[6];
			for(int i = 0; i < 6; i++)
			{
				upperScore[i] = new UpperSectionScore(upperScoreName[i], i + 1);
			}
			
				// LowerSectionScore:
			ScoreInterface[] lowerScore = new ScoreInterface[7];
			lowerScore[0] = new OfAKind("Three of a Kind", 3);
			lowerScore[1] = new OfAKind("Four of a Kind", 4);
			lowerScore[2] = new FullHouse("Full House");
			lowerScore[3] = new Straight("Small Straight", 4);
			lowerScore[4] = new Straight("Large Straight", 5);
			lowerScore[5] = new Chance("Chance");
			lowerScore[6] = new OfAKind("Yahtzee", 5);
				
				// Dice:
			DieInterface[] dice = new DieInterface[5];
			for(int j = 0; j < 5; j++)
			{
				dice[j] = new Die();
			}
			
			// Print Yahtzee card.
			card(myName, upperScore, lowerScore, dice);
			
			while (!upperScore[0].isUsed() || !upperScore[1].isUsed() || !upperScore[2].isUsed() || !upperScore[3].isUsed() || !upperScore[4].isUsed() || !upperScore[5].isUsed() || !lowerScore[0].isUsed() || !lowerScore[1].isUsed() || !lowerScore[2].isUsed() || !lowerScore[3].isUsed() || !lowerScore[4].isUsed() || !lowerScore[5].isUsed() || !lowerScore[6].isUsed())
			{
				System.out.println("First Roll: ");
				for (int k = 0; k < 5; k++)
				{
					dice[k].roll();
				}
				System.out.println(DieInterface.toDiceString(dice));
				// Ran into a last-second problem attempting to implement code that would let player keep certain dice from being rolled.  
				// For now, the program just rolls the entire array each roll.  My fault...
				System.out.println("Second Roll: ");
				for (int k = 0; k < 5; k++)
				{
					dice[k].roll();
				}
				System.out.println(DieInterface.toDiceString(dice));
				
				System.out.println("Third Roll: ");
				for (int k = 0; k < 5; k++)
				{
					dice[k].roll();
				}
				System.out.println(DieInterface.toDiceString(dice));
				System.out.println("Here are your scores: ");
				for (int h = 0; h < upperScore.length; h++)
				{
					if(!upperScore[h].isUsed())
					{
						int number = h + 1;
						System.out.println(number + ".   " + upperScore[h].getName() + ": " + upperScore[h].getDiceScore(dice));
					}
				}
				for (int u = 0; u < lowerScore.length; u++)
				{
					if(!lowerScore[u].isUsed())
					{
						int number = u + 7;
						System.out.println(number + ".   " + lowerScore[u].getName() + ": " + lowerScore[u].getDiceScore(dice));
					}
				}
				
				System.out.print("Which category would you like to use? ");
				int category = inScan.nextInt();
				
				if (category <= 6)
				{
					upperScore[category - 1].setScore(dice);
				}
				else if (category > 6)
				{
					lowerScore[category - 7].setScore(dice);
				}
				
				card(myName, upperScore, lowerScore, dice);
				
			}
			System.out.println("Here are your final scores: ");
			card(myName, upperScore, lowerScore, dice);
			System.out.print("Would you like to play another round? ");
			playRound = inScan.nextLine();
		}
		if(playRound.equals("n"))
		{
			System.out.println("Thank you, goodbye!");
		}
	}
	
	public static void card(String aName, ScoreInterface[] anUpperScore, ScoreInterface[] aLowerScore, DieInterface[] dice)
	{
		int reqSpace = 22;
		int reqDash = 22;
		int totalScore = 0;
		int aNameLen = aName.length();
		
		// Values of scores:
		int onesScore = anUpperScore[0].getDiceScore(dice);
		int twosScore = anUpperScore[1].getDiceScore(dice);
		int threesScore = anUpperScore[2].getDiceScore(dice);
		int foursScore = anUpperScore[3].getDiceScore(dice);
		int fivesScore = anUpperScore[4].getDiceScore(dice);
		int sixesScore = anUpperScore[5].getDiceScore(dice);
		int threeOAKScore = aLowerScore[0].getDiceScore(dice);
		int fourOAKScore = aLowerScore[1].getDiceScore(dice);
		int fullScore = aLowerScore[2].getDiceScore(dice);
		int smallScore = aLowerScore[3].getDiceScore(dice);
		int largeScore = aLowerScore[4].getDiceScore(dice);
		int chanceScore = aLowerScore[5].getDiceScore(dice);
		int yahtzeeScore = aLowerScore[6].getDiceScore(dice);
		
		totalScore = onesScore + twosScore + threesScore + foursScore + fivesScore + sixesScore + threeOAKScore + fourOAKScore + fullScore + smallScore + largeScore + chanceScore + yahtzeeScore;
		
		String onesStr = "";
		String twosStr = "";
		String threesStr = "";
		String foursStr = "";
		String fivesStr = "";
		String sixesStr = "";
		String threeOAKStr = "";
		String fourOAKStr = "";
		String fullStr = "";
		String smallStr = "";
		String largeStr = "";
		String chanceStr = "";
		String yahtzeeStr = "";
		String totalStr = "";
		
		String nameStr = " Name: " + aName + " ";
		int nameStrLen = nameStr.length();
		if (nameStrLen < reqSpace)
		{
			for (int i = 0; i < (reqSpace - nameStrLen); i++)
			{
				nameStr += " ";
			}
		}
		nameStrLen = nameStr.length();
		if (nameStrLen > reqDash)
		{
			reqDash += (nameStrLen - reqDash);
		}
		if (nameStrLen > reqSpace)
		{
			for (int i = 0; i < (nameStrLen - reqSpace); i++)
			{
				onesStr += " ";
				twosStr += " ";
				threesStr += " ";
				foursStr += " ";
				fivesStr += " ";
				sixesStr += " ";
				threeOAKStr += " ";
				fourOAKStr += " ";
				fullStr += " ";
				smallStr += " ";
				largeStr += " ";
				chanceStr += " ";
				yahtzeeStr += " ";
				totalStr += " ";
				
			}
		}
		// ones:
		if (!anUpperScore[0].isUsed())
		{
			onesStr += "            Ones: ___ ";
		}
		else if (anUpperScore[0].isUsed())
		{
			if(onesScore < 10)
			{
				onesStr += "            Ones:   " + onesScore + " ";
			}
			else if(onesScore > 10 && onesScore < 100)
			{
				onesStr += "            Ones:  " + onesScore + " ";
			}
			else if(onesScore >= 100)
			{
				onesStr += "            Ones: " + onesScore + " ";
			}
		}
		// twos:
		if (!anUpperScore[1].isUsed())
		{
			twosStr += "            Twos: ___ ";
		}
		else if (anUpperScore[1].isUsed())
		{
			if(twosScore < 10)
			{
				twosStr += "            Twos:   " + twosScore + " ";
			}
			else if(twosScore > 10 && twosScore < 100)
			{
				twosStr += "            Twos:  " + twosScore + " ";
			}
			else if(twosScore >= 100)
			{
				twosStr += "            Twos: " + twosScore + " ";
			}
		}
		// threes:
		if (!anUpperScore[2].isUsed())
		{
			threesStr += "          Threes: ___ ";
		}
		else if (anUpperScore[2].isUsed())
		{
			if(threesScore < 10)
			{
				threesStr += "          Threes:   " + threesScore + " ";
			}
			else if(threesScore > 10 && threesScore < 100)
			{
				threesStr += "          Threes:  " + threesScore + " ";
			}
			else if(threesScore >= 100)
			{
				threesStr += "          Threes: " + threesScore + " ";
			}
		}
		// fours:
		if (!anUpperScore[3].isUsed())
		{
			foursStr += "           Fours: ___ ";
		}
		else if (anUpperScore[3].isUsed())
		{
			if(foursScore < 10)
			{
				foursStr += "           Fours:   " + foursScore + " ";
			}
			else if(foursScore > 10 && foursScore < 100)
			{
				foursStr += "           Fours:  " + foursScore + " ";
			}
			else if(foursScore >= 100)
			{
				foursStr += "           Fours: " + foursScore + " ";
			}
		}
		// fives:
		if (!anUpperScore[4].isUsed())
		{
			fivesStr += "           Fives: ___ ";
		}
		else if (anUpperScore[4].isUsed())
		{
			if(fivesScore < 10)
			{
				fivesStr += "           Fives:   " + fivesScore + " ";
			}
			else if(fivesScore > 10 && fivesScore < 100)
			{
				fivesStr += "           Fives:  " + fivesScore + " ";
			}
			else if(fivesScore >= 100)
			{
				fivesStr += "           Fives: " + fivesScore + " ";
			}
		}
		// sixes:
		if (!anUpperScore[5].isUsed())
		{
			sixesStr += "           Sixes: ___ ";
		}
		else if (anUpperScore[5].isUsed())
		{
			if(sixesScore < 10)
			{
				sixesStr += "           Sixes:   " + sixesScore + " ";
			}
			else if(sixesScore > 10 && sixesScore < 100)
			{
				sixesStr += "           Sixes:  " + sixesScore + " ";
			}
			else if(sixesScore >= 100)
			{
				sixesStr += "           Sixes: " + sixesScore + " ";
			}
		}
		// three of a kind:
		if (!aLowerScore[0].isUsed())
		{
			threeOAKStr += " Three of a Kind: ___ ";
		}
		else if (aLowerScore[0].isUsed())
		{
			if(threeOAKScore < 10)
			{
				threeOAKStr += " Three of a Kind:   " + threeOAKScore + " ";
			}
			else if(threeOAKScore > 10 && threeOAKScore < 100)
			{
				threeOAKStr += " Three of a Kind:  " + threeOAKScore + " ";
			}
			else if(threeOAKScore >= 100)
			{
				threeOAKStr += " Three of a Kind:  " + threeOAKScore + " ";
			}
		}
		// four of a kind:
		if (!aLowerScore[1].isUsed())
		{
			fourOAKStr += "  Four of a Kind: ___ ";
		}
		else if (aLowerScore[1].isUsed())
		{
			if(fourOAKScore < 10)
			{
				fourOAKStr += "  Four of a Kind:   " + fourOAKScore + " ";
			}
			else if(fourOAKScore > 10 && fourOAKScore < 100)
			{
				fourOAKStr += "  Four of a Kind:  " + fourOAKScore + " ";
			}
			else if(fourOAKScore >= 100)
			{
				fourOAKStr += "  Four of a Kind:   " + fourOAKScore + " ";
			}
		}
		// full house:
		if (!aLowerScore[2].isUsed())
		{
			fullStr += "      Full House: ___ ";
		}
		else if (aLowerScore[2].isUsed())
		{
			if(fullScore < 10)
			{
				fullStr += "      Full House:   " + fullScore + " ";
			}
			else if(fullScore > 10 && fullScore < 100)
			{
				fullStr += "      Full House:  " + fullScore + " ";
			}
			else if(fullScore >= 100)
			{
				fullStr += "      Full House: " + fullScore + " ";
			}
		}
		// small straight:
		if (!aLowerScore[3].isUsed())
		{
			smallStr += "  Small Straight: ___ ";
		}
		else if (aLowerScore[3].isUsed())
		{
			if(smallScore < 10)
			{
				smallStr += "  Small Straight:   " + smallScore + " ";
			}
			else if(smallScore > 10 && smallScore < 100)
			{
				smallStr += "  Small Straight:  " + smallScore + " ";
			}
			else if(smallScore >= 100)
			{
				smallStr += "  Small Straight: " + smallScore + " ";
			}
		}
		// large straight:
		if (!aLowerScore[4].isUsed())
		{
			largeStr += "  Large Straight: ___ ";
		}
		else if (aLowerScore[4].isUsed())
		{
			if(largeScore < 10)
			{
				largeStr += "  Large Straight:   " + largeScore + " ";
			}
			else if(largeScore > 10 && largeScore < 100)
			{
				largeStr += "  Large Straight:  " + largeScore + " ";
			}
			else if(largeScore >= 100)
			{
				largeStr += "  Large Straight: " + largeScore + " ";
			}
		}
		// chance:
		if (!aLowerScore[5].isUsed())
		{
			chanceStr += "          Chance: ___ ";
		}
		else if (aLowerScore[5].isUsed())
		{
			if(chanceScore < 10)
			{
				chanceStr += "          Chance:   " + chanceScore + " ";
			}
			else if(chanceScore > 10 && chanceScore < 100)
			{
				chanceStr += "          Chance:  " + chanceScore + " ";
			}
			else if(chanceScore >= 100)
			{
				chanceStr += "          Chance: " + chanceScore + " ";
			}
		}
		// yahtzee:
		if (!aLowerScore[6].isUsed())
		{
			yahtzeeStr += "         Yahtzee: ___ ";
		}
		else if (aLowerScore[6].isUsed())
		{
			if(yahtzeeScore < 10)
			{
				yahtzeeStr += "         Yahtzee:   " + yahtzeeScore + " ";
			}
			else if(yahtzeeScore > 10 && yahtzeeScore < 100)
			{
				yahtzeeStr += "         Yahtzee:  " + yahtzeeScore + " ";
			}
			else if(yahtzeeScore >= 100)
			{
				yahtzeeStr += "         Yahtzee: " + yahtzeeScore + " ";
			}
		}
		// total:
		if (totalScore < 10)
		{
			totalStr += "           Total:   " + totalScore + " ";
		}
		else if (totalScore > 10 && totalScore < 100)
		{
			totalStr += "           Total:  " + totalScore + " ";
		}
		else if (totalScore >= 100)
		{
			totalStr += "           Total: " + totalScore + " ";
		}
		
		String cardStr = "";
		cardStr += "+";
		for (int i = 0; i < reqDash; i++)
		{
			cardStr += "-";
		}
		cardStr += "+\n";
		
		cardStr += "|" + nameStr + "|\n";
		cardStr += "|";
		for (int j = 0; j < nameStrLen; j++)
		{
			cardStr += " ";
		}
		cardStr += "|\n";
		cardStr += "|" + onesStr + "|\n";
		cardStr += "|" + twosStr + "|\n";
		cardStr += "|" + threesStr + "|\n";
		cardStr += "|" + foursStr + "|\n";
		cardStr += "|" + fivesStr + "|\n";
		cardStr += "|" + sixesStr + "|\n";
		cardStr += "|" + threeOAKStr + "|\n";
		cardStr += "|" + fourOAKStr + "|\n";
		cardStr += "|" + fullStr + "|\n";
		cardStr += "|" + smallStr + "|\n";
		cardStr += "|" + largeStr + "|\n";
		cardStr += "|" + chanceStr + "|\n";
		cardStr += "|" + yahtzeeStr + "|\n";
		
		cardStr += "| ";
		for (int k = 0; k < (reqDash - 2); k++)
		{
			cardStr += "-";
		}
		cardStr += " |\n";
		cardStr += "|" + totalStr + "|\n";
		cardStr += "| ";
		for (int l = 0; l < (reqDash - 2); l++)
		{
			cardStr += "=";
		}
		cardStr += " |\n";
		
		cardStr += "+";
		for (int m = 0; m < reqDash; m++)
		{
			cardStr += "-";
		}
		cardStr += "+";
		System.out.println(cardStr);
	}
}