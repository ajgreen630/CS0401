import java.io.*;
import java.util.*;
public class Bingo
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		File inputFile = new File("players.txt");
		Scanner inputFileScanner = new Scanner(inputFile);
		ArrayList<String> dataList = new ArrayList<String>();
		
		while (inputFileScanner.hasNextLine())
		{
			dataList.add(inputFileScanner.nextLine());
		}
		
		inputFileScanner.close();
		
		String houseBankStr = dataList.get(0);
		String numberOfPlayersStr = dataList.get(1);
		
		double houseBank = Double.valueOf(houseBankStr);
		int numberOfPlayers = Integer.valueOf(numberOfPlayersStr);
		
		dataList.remove(0);
		dataList.remove(0);
		Collections.sort(dataList);
		
		String oneStr = dataList.get(0);
		String[] oneArr = oneStr.split(",");
		String oneFirst = oneArr[0];
		String oneLast = oneArr[1];
		double oneAmount = Double.valueOf(oneArr[2]);
		BingoPlayer playerOne = new BingoPlayer(oneFirst, oneLast, oneAmount);
	//  ============================================================================
		String twoStr = dataList.get(1);
		String[] twoArr = twoStr.split(",");
		String twoFirst = twoArr[0];
		String twoLast = twoArr[1];
		double twoAmount = Double.valueOf(twoArr[2]);
		BingoPlayer playerTwo = new BingoPlayer(twoFirst, twoLast, twoAmount);
	//  ============================================================================
		String threeStr = dataList.get(2);
		String[] threeArr = threeStr.split(",");
		String threeFirst = threeArr[0];
		String threeLast = threeArr[1];
		double threeAmount = Double.valueOf(threeArr[2]);
		BingoPlayer playerThree = new BingoPlayer(threeFirst, threeLast, threeAmount);
	//  ============================================================================
		String fourStr = dataList.get(3);
		String[] fourArr = fourStr.split(",");
		String fourFirst = fourArr[0];
		String fourLast = fourArr[1];
		double fourAmount = Double.valueOf(fourArr[2]);
		BingoPlayer playerFour = new BingoPlayer(fourFirst, fourLast, fourAmount);
	//  ============================================================================
		String fiveStr = dataList.get(4);
		String[] fiveArr = fiveStr.split(",");
		String fiveFirst = fiveArr[0];
		String fiveLast = fiveArr[1];
		double fiveAmount = Double.valueOf(fiveArr[2]);
		BingoPlayer playerFive = new BingoPlayer(fiveFirst, fiveLast, fiveAmount);
	//  ============================================================================
		String sixStr = dataList.get(5);
		String[] sixArr = sixStr.split(",");
		String sixFirst = sixArr[0];
		String sixLast = sixArr[1];
		double sixAmount = Double.valueOf(sixArr[2]);
		BingoPlayer playerSix = new BingoPlayer(sixFirst, sixLast, sixAmount);
	//  ============================================================================
		String sevenStr = dataList.get(6);
		String[] sevenArr = sevenStr.split(",");
		String sevenFirst = sevenArr[0];
		String sevenLast = sevenArr[1];
		double sevenAmount = Double.valueOf(sevenArr[2]);
		BingoPlayer playerSeven = new BingoPlayer(sevenFirst, sevenLast, sevenAmount);
	//  ============================================================================
		String eightStr = dataList.get(7);
		String[] eightArr = eightStr.split(",");
		String eightFirst = eightArr[0];
		String eightLast = eightArr[1];
		double eightAmount = Double.valueOf(eightArr[2]);
		BingoPlayer playerEight = new BingoPlayer(eightFirst, eightLast, eightAmount);
	//  ============================================================================
		String nineStr = dataList.get(8);
		String[] nineArr = nineStr.split(",");
		String nineFirst = nineArr[0];
		String nineLast = nineArr[1];
		double nineAmount = Double.valueOf(nineArr[2]);
		BingoPlayer playerNine = new BingoPlayer(nineFirst, nineLast, nineAmount);
	//  ============================================================================
		String tenStr = dataList.get(9);
		String[] tenArr = tenStr.split(",");
		String tenFirst = tenArr[0];
		String tenLast = tenArr[1];
		double tenAmount = Double.valueOf(tenArr[2]);
		BingoPlayer playerTen = new BingoPlayer(tenFirst, tenLast, tenAmount);
	//  ============================================================================
		
		System.out.println("******************************");
		System.out.println("* Welcome to SCI Bingo House *");
		System.out.println("******************************");
		System.out.println("These are all the available players:");
		System.out.println("1. " + playerOne.getFullInfo());
		System.out.println("2. " + playerTwo.getFullInfo());
		System.out.println("3. " + playerThree.getFullInfo());
		System.out.println("4. " + playerFour.getFullInfo());
		System.out.println("5. " + playerFive.getFullInfo());
		System.out.println("6. " + playerSix.getFullInfo());
		System.out.println("7. " + playerSeven.getFullInfo());
		System.out.println("8. " + playerEight.getFullInfo());
		System.out.println("9. " + playerNine.getFullInfo());
		System.out.println("10. " + playerTen.getFullInfo());
		
		int notPlaying = 0;
		double potAmount = 0;
		
		while (notPlaying < 10)
		{
			notPlaying = 0;
			ArrayList<BingoPlayer> roster = new ArrayList<BingoPlayer>();
			roster.add(playerOne);
			roster.add(playerTwo);
			roster.add(playerThree);
			roster.add(playerFour);
			roster.add(playerFive);
			roster.add(playerSix);
			roster.add(playerSeven);
			roster.add(playerEight);
			roster.add(playerNine);
			roster.add(playerTen);
			ArrayList<BingoPlayer> playingRoster = new ArrayList<>(roster);
			Scanner inScan = new Scanner(System.in);
			
			for (int i = 0; i < 10; i++)
			{
				BingoPlayer aPlayer = roster.get(i);
				System.out.print(aPlayer.getFullName());
				System.out.print(", would you like to play this round? (y/n): ");
				
				String willPlay = inScan.nextLine();
				
				if (willPlay.equals("y"))
				{
					System.out.print("How many Bingo cards would you like to buy? (1 - 4): ");
					int numCards = Integer.parseInt(inScan.nextLine());
					
					while (numCards < 1 || numCards > 4)
					{
						System.out.println("ERROR: Please enter (1 - 4) to continue.");
						System.out.print("How many Bingo cards would you like to buy? (1 - 4): ");
						numCards = Integer.parseInt(inScan.nextLine()); 
						// Getting a very weird output, where it prints this question for one player,
						// skips taking their input, then moves on to the next player to get their
						// input.
					}
					int cost = numCards;
					aPlayer.remove(cost);
					potAmount += cost;
					
					BingoCard[] cards = new BingoCard[numCards];
					for (int j = 0; j < numCards; j++)
					{
						cards[j] = new BingoCard();
					}
					
					aPlayer.addBingoCards(cards);
				}
				
				else if (willPlay.equals("n"))
				{
					playingRoster.remove(aPlayer);
					notPlaying += 1;
				}
			}
			
			// Make sure Bingo cage has all 75 balls (either reset the old object or construct
			// a new one).
			BingoCage aCage = new BingoCage();
			
			
			// Show amount of money of house, amount of money in the pot, the list of ball
			// numbers (should be empty at the beginning) and show only those players that
			// are playing (together with his/her hand) in this round).
			
			// 
			ArrayList<BingoBall> ballList = new ArrayList<BingoBall>();
			boolean hasBingo = false;
			
			int playingRosterSize = playingRoster.size();
			
			System.out.println("House: " + houseBank);
			System.out.println("Pot: " + potAmount);
			System.out.println("Balls: " + Arrays.toString(ballList.toArray()));				
			// Print playerRoster:
			for (int j = 0; j < playingRosterSize; j++)
			{
				BingoPlayer aPlayer = playingRoster.get(j);
				int listNumber = j + 1;
				System.out.println(listNumber + ". " + aPlayer);
			}
			System.out.println("There are no winning cards yet.");
			System.out.println();
			System.out.print("1) Draw a ball, 2) Draw balls until Bingo: ");
			int ballOption = Integer.parseInt(inScan.nextLine());
			
			while (ballList.size() < 76 && hasBingo != true)
			{
				
				if (ballOption == 1)
				{
					// Draw ball, add ball to list:
					BingoBall theBall = aCage.draw();
					ballList.add(theBall);
					int thisBallNum = theBall.getNumber();
					for (int j = 0; j < playingRosterSize; j++)
					{
						BingoPlayer aPlayer = playingRoster.get(j);
						aPlayer.marks(thisBallNum);
					}
					// Check if any of the players have winning cards.
					for (int u = 0; u < playingRosterSize; u++)
					{
						BingoPlayer aPlayer = playingRoster.get(u);
						if(aPlayer.isBingo())
						{
							hasBingo = true;
						}
					}
					// Print house, pot, balls:
					System.out.println("House: " + houseBank);
					System.out.println("Pot: " + potAmount);
					System.out.println("Balls: " + Arrays.toString(ballList.toArray()));
					// Print playing roster:
					for (int j = 0; j < playingRosterSize; j++)
					{
						BingoPlayer aPlayer = playingRoster.get(j);
						int listNumber = j + 1;
						System.out.println(listNumber + ". " + aPlayer);
					}
					System.out.println("There are no winning cards yet.");
					System.out.println();
					System.out.print("1) Draw a ball, 2) Draw balls until Bingo: ");
					ballOption = Integer.parseInt(inScan.nextLine());
				}
				else if (ballOption == 2)
				{
					System.out.println("House: " + houseBank);
					System.out.println("Pot: " + potAmount);
					System.out.println("Balls: " + Arrays.toString(ballList.toArray()));
					// Print playing roster:
					for (int j = 0; j < playingRosterSize; j++)
					{
						BingoPlayer aPlayer = playingRoster.get(j);
						int listNumber = j + 1;
						System.out.println(listNumber + ". " + aPlayer);
					}
					System.out.println("There are no winning cards yet.");
					
					// Draw ball, add ball to list:
					BingoBall theBall = aCage.draw();
					ballList.add(theBall);
					int thisBallNum = theBall.getNumber();
					for (int j = 0; j < playingRosterSize; j++)
					{
						BingoPlayer aPlayer = playingRoster.get(j);
						aPlayer.marks(thisBallNum);
					}
					// Check if any of the players have winning cards.
					for (int u = 0; u < playingRosterSize; u++)
					{
						BingoPlayer aPlayer = playingRoster.get(u);
						if(aPlayer.isBingo())
						{
							hasBingo = true;
						}
					}
				}
			}
			
			for (int r = 0; r < playingRosterSize; r++)
			{
				BingoPlayer aPlayer = playingRoster.get(r);
				if(aPlayer.isBingo())
				{
					System.out.println(aPlayer.getFullName() + " says this card is a winning card: ");
					BingoCard[] winningCards = aPlayer.getBingoCards();
					for (int i = 0; i < winningCards.length; i++)
					{
						System.out.println(winningCards[i].toSideBySideString());
					}
					System.out.println("These are the balls that have been drawn so far in this round: ");
					System.out.println(Arrays.toString(ballList.toArray()));
					System.out.print("Is it a winning card? (y/n): ");
					String itIsWin = inScan.nextLine();
					aPlayer.add(potAmount);
					houseBank += potAmount;
					PrintStream outFile = new PrintStream(new File("players.txt"));
					String houseBankFile = Double.toString(houseBank);
					String numPlayerFile = Integer.toString(numberOfPlayers);
					outFile.println(houseBankFile);
					outFile.println(numPlayerFile);
					for (int z = 0; z < roster.size(); z++)
					{
						BingoPlayer thisPlayer = roster.get(z);
						outFile.println(thisPlayer.toFileString());
					}
					outFile.close();
				}
			}
			for (int h = 0; h < roster.size(); h++)
			{
				BingoPlayer aPlayer = roster.get(h);
				aPlayer.clear();
			}
			roster.clear();
			playingRoster.clear();
		}
	}
}