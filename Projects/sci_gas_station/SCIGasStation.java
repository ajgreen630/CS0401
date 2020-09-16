import java.util.*;

public class SCIGasStation{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		
		int typeOfService = 0;
		
		while (typeOfService != 3){
			int typeOfGas;
			int typeOfWash;
			
			String answer = "y";
			
			Random rand = new Random();
			double randNum = rand.nextDouble();
			double start = 10;
			double end = 20;
			
			double gallonExact = 0.0;
			double gallonTotal = 0.0;
			
			double gasPriceDisc = 0.0;
			double gasPriceReg = 0.0;
			double gasPriceTotal = 0.0;
			double washPrice = 0.0;
			
			double priceExact = 0.0;
			double priceTotal = 0.0;
				
			System.out.println("Welcome to SCI Gas Station!");
			System.out.println("Please choose your service:");
			System.out.println("1) Gas only");
			System.out.println("2) Gas w/ car wash (10c off per gal. up to 15 gal.)");
			System.out.println("3) Exit");
			typeOfService = sc.nextInt();
			
			while (typeOfService < 1 || typeOfService > 3){
				System.out.println("Invalid option!");
				System.out.println("Please choose your service:");
				System.out.println("1) Gas only");
				System.out.println("2) Gas w/ car wash (10c off per gal. up to 15 gal.)");
				System.out.println("3) Exit");
			}
			
			if (typeOfService == 1){
				gallonExact = 0.0;
				gallonTotal = 0.0;
				
				System.out.println("Please choose a gasoline type:");
				System.out.println("1) 87 ($2.59 per gal.)");
				System.out.println("2) 89 ($2.69 per gal.)");
				System.out.println("3) 91 ($2.84 per gal.)");
				System.out.println("4) 94 ($2.99 per gal.)");
				System.out.println("5) Cancel");
				
				typeOfGas = sc.nextInt();
				while (typeOfGas < 1 || typeOfGas > 5){
					System.out.println("Invalid option!");
					System.out.println("Please choose a gasoline type:");
					System.out.println("1) 87 ($2.59 per gal.)");
					System.out.println("2) 89 ($2.69 per gal.)");
					System.out.println("3) 91 ($2.84 per gal.)");
					System.out.println("4) 94 ($2.99 per gal.)");
					System.out.println("5) Cancel");
					
					typeOfGas = sc.nextInt();
				}
				if (typeOfGas == 1){
					System.out.println("Your order is as follows: ");
					System.out.println("1. Full tank of gas 87 ($2.59 per gal.)");
					System.out.print("Confirm order? (y/n): ");
					answer = sc.next();
					
					while (!"y".equals(answer) && !"n".equals(answer)){
						System.out.println("Invalid option!");
						System.out.print("Confirm order? (y/n): ");
						answer = sc.next();
					}
					if ("n".equals(answer)){ // Back to main.
					}
					if ("y".equals(answer)){
						gallonExact = start + (randNum * (end - start)); // Fill up tank.
						gallonTotal = Math.round(gallonExact * 100.00) / 100.0; // Round gallons to readable number.
						
						priceExact = gallonTotal * 2.59;  // Exact price.
						priceTotal = Math.round(priceExact * 100.0) / 100.0; // Round price to make sense.
						
						System.out.println("It took " + gallonTotal + " gallons to fill your tank.");
						
						makePayment(priceTotal);
					}
				}
				if (typeOfGas == 2){
					System.out.println("Your order is as follows: ");
					System.out.println("1. Full tank of fas 89 ($2.69 per gal.)");
					System.out.print("Confirm order? (y/n): ");
					answer = sc.next();
					
					while (!"y".equals(answer) && !"n".equals(answer)){
						System.out.println("Invalid option!");
						System.out.print("Confirm order? (y/n): ");
						answer = sc.next();
					}
					if ("n".equals(answer)){
					}
					if ("y".equals(answer)){
						gallonExact = start + (randNum * (end - start));
						gallonTotal = Math.round(gallonExact * 100.0) / 100.0;
						
						priceExact = gallonTotal * 2.69;
						priceTotal = Math.round(priceExact * 100.0) / 100.0;
						
						System.out.println("It took " + gallonTotal + " gallons to fill your tank.");
						
						makePayment(priceTotal);
					}
				}
				if (typeOfGas == 3){
					System.out.println("Your order is as follows: ");
					System.out.println("1. Full tank of fas 91 ($2.84 per gal.)");
					System.out.print("Confirm order? (y/n): ");
					answer = sc.next();
					
					while (!"y".equals(answer) && !"n".equals(answer)){
						System.out.println("Invalid option!");
						System.out.print("Confirm order? (y/n): ");
						answer = sc.next();
					}
					if ("n".equals(answer)){
					}
					if ("y".equals(answer)){
						gallonExact = start + (randNum * (end - start));
						gallonTotal = Math.round(gallonExact * 100.0) / 100.0;
						
						priceExact = gallonTotal * 2.84;
						priceTotal = Math.round(priceExact * 100.0) / 100.0;
						
						System.out.println("It took " + gallonTotal + " gallons to fill your tank.");
						
						makePayment(priceTotal);
					}
				}
				if (typeOfGas == 4){
					System.out.println("Your order is as follows: ");
					System.out.println("1. Full tank of fas 94 ($2.99 per gal.)");
					System.out.print("Confirm order? (y/n): ");
					answer = sc.next();
					
					while (!"y".equals(answer) && !"n".equals(answer)){
						System.out.println("Invalid option!");
						System.out.print("Confirm order? (y/n): ");
						answer = sc.next();
					}
					if ("n".equals(answer)){
					}
					if ("y".equals(answer)){
						gallonExact = start + (randNum * (end - start));
						gallonTotal = Math.round(gallonExact * 100.0) / 100.0;
						
						priceExact = gallonTotal * 2.99;
						priceTotal = Math.round(priceExact * 100.0) / 100.0;
						
						System.out.println("It took " + gallonTotal + " gallons to fill your tank.");
						
						makePayment(priceTotal);
					}
				}
				if (typeOfGas == 5){ // Back to Main.
				}
			}
// --------------------------------------------------------------------------------------------------
			if (typeOfService == 2){
				gallonExact = 0.0;
				gallonTotal = 0.0;
				
				System.out.println("Please choose a gasoline type:");
				System.out.println("1) 87 ($2.49 per gal.)");
				System.out.println("2) 89 ($2.59 per gal.)");
				System.out.println("3) 91 ($2.74 per gal.)");
				System.out.println("4) 94 ($2.89 per gal.)");
				System.out.println("5) Cancel");
				typeOfGas = sc.nextInt();
				
				while (typeOfGas < 1 || typeOfGas > 5){
					System.out.println("Invalid option!");
					System.out.println("Please choose a gasoline type:");
					System.out.println("1) 87 ($2.49 per gal.)");
					System.out.println("2) 89 ($2.59 per gal.)");
					System.out.println("3) 91 ($2.74 per gal.)");
					System.out.println("4) 94 ($2.89 per gal.)");
					System.out.println("5) Cancel");
					typeOfGas = sc.nextInt();
				}
				
				System.out.println("Please select a wash type:");
				System.out.println("1) Basic ($5.00)");
				System.out.println("2) Shine ($7.00)");
				System.out.println("3) Deluxe ($9.00)");
				System.out.println("4) Premium ($11.00)");
				System.out.println("5) Cancel");
				typeOfWash = sc.nextInt();
				
				while (typeOfWash < 1 || typeOfWash > 5){
					System.out.println("Invalid option!");
					System.out.println("1) Basic ($5.00)");
					System.out.println("2) Shine ($7.00)");
					System.out.println("3) Deluxe ($9.00)");
					System.out.println("4) Premium ($11.00)");
					System.out.println("5) Cancel");
					typeOfWash = sc.nextInt();
				}
				
				// if Statements for gas type:
				if (typeOfGas == 1){
					gallonExact = start + (randNum * (end - start));
					gallonTotal = Math.round(gallonExact * 100.0) / 100.0;
					
					if (gallonTotal <= 15.0){
						gasPriceDisc = gallonTotal * 2.49;
						gasPriceTotal = gasPriceDisc; // Just to keep everything consistent.
					}
					if (gallonTotal > 15.0){
						gasPriceReg = (gallonTotal - 15.0) * 2.59;
						gasPriceDisc = 15.0 * 2.49;
						gasPriceTotal = gasPriceDisc + gasPriceReg;
					}
					
					System.out.println("Your order is as follows: ");
					System.out.println("1. Full tank of fas 87 ($2.49 per gal. up to 15 gal.)");
				}
				if (typeOfGas == 2){
					gallonExact = start + (randNum * (end - start));
					gallonTotal = Math.round(gallonExact * 100.0) / 100.0;
					
					if (gallonTotal <= 15.0){
						gasPriceDisc = gallonTotal * 2.59;
						gasPriceTotal = gasPriceDisc; // Just to keep everything consistent.
					}
					if (gallonTotal > 15.0){
						gasPriceReg = (gallonTotal - 15.0) * 2.69;
						gasPriceDisc = 15.0 * 2.59;
						gasPriceTotal = gasPriceDisc + gasPriceReg;
					}
					
					System.out.println("Your order is as follows: ");
					System.out.println("1. Full tank of fas 89 ($2.59 per gal. up to 15 gal.)");
				}
				if (typeOfGas == 3){
					gallonExact = start + (randNum * (end - start));
					gallonTotal = Math.round(gallonExact * 100.0) / 100.0;
					
					if (gallonTotal <= 15.0){
						gasPriceDisc = gallonTotal * 2.74;
						gasPriceTotal = gasPriceDisc; // Just to keep everything consistent.
					}
					if (gallonTotal > 15.0){
						gasPriceReg = (gallonTotal - 15.0) * 2.84;
						gasPriceDisc = 15.0 * 2.74;
						gasPriceTotal = gasPriceDisc + gasPriceReg;
					}
					
					System.out.println("Your order is as follows: ");
					System.out.println("1. Full tank of fas 91 ($2.74 per gal. up to 15 gal.)");
				}
				if (typeOfGas == 4){
					gallonExact = start + (randNum * (end - start));
					gallonTotal = Math.round(gallonExact * 100.0) / 100.0;
					
					if (gallonTotal <= 15.0){
						gasPriceDisc = gallonTotal * 2.89;
						gasPriceTotal = gasPriceDisc; // Just to keep everything consistent.
					}
					if (gallonTotal > 15.0){
						gasPriceReg = (gallonTotal - 15.0) * 2.99;
						gasPriceDisc = 15.0 * 2.89;
						gasPriceTotal = gasPriceDisc + gasPriceReg;
					}
					
					System.out.println("Your order is as follows: ");
					System.out.println("1. Full tank of fas 94 ($2.89 per gal. up to 15 gal.)");
				}
				if (typeOfGas == 5){ // Back to Main.
				}
				
				// if Statements for wash type:
				if (typeOfWash == 1){
					System.out.println("2. Basic wash ($5.00)");
					System.out.print("Confirm order? (y/n): ");
					answer = sc.next();
					
					while (!"y".equals(answer) && !"n".equals(answer)){
						System.out.println("Invalid option!");
						System.out.print("Confirm order? (y/n): ");
						answer = sc.next();
					}
					if ("n".equals(answer)){ // Back to main.
					}
					if ("y".equals(answer)){
						washPrice = 5.0;
						
						priceExact = gasPriceTotal + washPrice;
						priceTotal = Math.round(priceExact * 100.0) / 100.0;
						
						System.out.println("It took " + gallonTotal + " gallons to fill your tank.");
						
						makePayment(priceTotal);
					}
				}
				if (typeOfWash == 2){
					System.out.println("2. Shine wash ($7.00)");
					System.out.print("Confirm order? (y/n): ");
					answer = sc.next();
					
					while (!"y".equals(answer) && !"n".equals(answer)){
					}
					if ("n".equals(answer)){
					}
					if ("y".equals(answer)){
						washPrice = 7.0;
						
						priceExact = gasPriceTotal + washPrice;
						priceTotal = Math.round(priceExact * 100.0) / 100.0;
						
						System.out.println("It took " + gallonTotal + " gallons to fill your tank.");
						
						makePayment(priceTotal);
					}
				}
				if (typeOfWash == 3){
					System.out.println("2. Deluxe wash ($9.00)");
					System.out.print("Confirm order? (y/n): ");
					answer = sc.next();
					
					while (!"y".equals(answer) && !"n".equals(answer)){
					}
					if ("n".equals(answer)){
					}
					if ("y".equals(answer)){
						washPrice = 9.0;
						
						priceExact = gasPriceTotal + washPrice;
						priceTotal = Math.round(priceExact * 100.0) / 100.0;
						
						System.out.println("It took " + gallonTotal + " gallons to fill your tank.");
						
						makePayment(priceTotal);
					}
				}
				if (typeOfWash == 4){
					System.out.println("2. Premium wash ($11.00)");
					System.out.print("Confirm order? (y/n): ");
					answer = sc.next();
					
					while (!"y".equals(answer) && !"n".equals(answer)){
					}
					if ("n".equals(answer)){
					}
					if ("y".equals(answer)){
						washPrice = 11.0;
						
						priceExact = gasPriceTotal + washPrice;
						priceTotal = Math.round(priceExact * 100.0) / 100.0;
						
						System.out.println("It took " + gallonTotal + " gallons to fill your tank.");
						
						makePayment(priceTotal);
					}
				}
				if (typeOfWash == 5){ // Back to main.
				}
			}
// --------------------------------------------------------------------------------------------------
			if (typeOfService == 3){
				break;
			}
			
		}
	}
	
	public static void makePayment(double totalBill){
		Scanner keyboard = new Scanner(System.in);
		int amount;
		String moneyType;
		double customerPayment = 0;
		double amountPaid = 0;
		double amountOwed = 0;
		double changeTotal = 0;
		
		System.out.println("Your total is $" + totalBill + ".");
		System.out.println("Please enter a payment amount in the following format:");
		System.out.println("	 <amount><space><type>");
		System.out.println("  where  <amount> is an integer,");
		System.out.println("         <space>  is a blank space,");
		System.out.println("	 <type>   is either 20s, 10s, 5, or 1s.");
		System.out.println("  You may enter as many times as you like. Each entry will be");
		System.out.println("  added to your total until sufficient funds have been obtained.");
		
		while (amountPaid < totalBill){
			System.out.print("Enter your payment: ");
			amount = keyboard.nextInt();
			moneyType = keyboard.next();
			
			if ("20s".equals(moneyType)){
				customerPayment = amount * 20.00;
				customerPayment = Math.round(customerPayment * 100.0) / 100.0;
			}
			if ("10s".equals(moneyType)){
				customerPayment = amount * 10.00;
				customerPayment = Math.round(customerPayment * 100.0) / 100.0;
			}
			if ("5s".equals(moneyType)){
				customerPayment = amount * 5.00;
				customerPayment = Math.round(customerPayment * 100.0) / 100.0;
			}
			if ("1s".equals(moneyType)){
				customerPayment = amount * 1.00;
				customerPayment = Math.round(customerPayment * 100.0) / 100.0;
			}
			
			amountPaid += customerPayment;
			amountOwed = totalBill - amountPaid;
			amountOwed = Math.round(amountOwed * 100.0) / 100.0;
			
			System.out.println("You have added $" + customerPayment + " to your total.");
			System.out.println("You have paid $" + amountPaid + " out of $" + totalBill + ".");
			if (amountOwed > 0){
				System.out.println("You still owe $" + amountOwed + ".");
			}
		}
		
		changeTotal = amountPaid - totalBill;
		changeTotal = Math.round(changeTotal * 100.0) / 100.0;
		System.out.println("Your change is $" + changeTotal + ".");

		int numTwenty = (int)(changeTotal / 20);
		changeTotal -= (numTwenty * 20);

		int numTen = (int)(changeTotal / 10);
		changeTotal = changeTotal - (numTen * 10);

		int numFive = (int)(changeTotal / 5);
		changeTotal = changeTotal - (numFive * 5);

		int numOne = (int)(changeTotal / 1);
		changeTotal = changeTotal - (numOne * 1);

		changeTotal = Math.round(changeTotal * 100);  

		int numQuarter = (int)(changeTotal / 25);
		changeTotal = changeTotal - (numQuarter * 25);

		int numDime = (int)(changeTotal / 10);
		changeTotal = changeTotal - (numDime * 10);

		int numNickel = (int)(changeTotal / 5);
		changeTotal = changeTotal - (numNickel * 5);

		int numPenny = (int)(changeTotal / 1);
		
		// Change in Twenties:
		if (numTwenty > 1){
			System.out.println("  " + numTwenty + " Twenties");
		}
		if (numTwenty == 1){
			System.out.println("  " + numTwenty + " Twenty");
		}
		if (numTwenty < 1){
		}
		// Change in Tens:
		if (numTen > 1){
			System.out.println("  " + numTen + " Tens");
		}
		if (numTen == 1){
			System.out.println("  " + numTen + " Ten");
		}
		if (numTen < 1){
		}
		// Change in Fives:
		if (numFive > 1){
			System.out.println("  " + numFive + " Fives");
		}
		if (numFive == 1){
			System.out.println("  " + numFive + " Five");
		}
		if (numFive < 1){
		}
		// Change in Ones:
		if (numOne > 1){
			System.out.println("  " + numOne + " Ones");
		}
		if (numOne == 1){
			System.out.println("  " + numOne + " One");
		}
		if (numOne < 1){
		}
		// Change in Quarters:
		if (numQuarter > 1){
			System.out.println("  " + numQuarter + " Quarters");
		}
		if (numQuarter == 1){
			System.out.println("  " + numQuarter + " Quarter");
		}
		if (numQuarter < 1){
		}
		// Change in Dimes:
		if (numDime > 1){
			System.out.println("  " + numDime + " Dimes");
		}
		if (numDime == 1){
			System.out.println("  " + numDime + " Dime");
		}
		if (numDime < 1){
		}
		// Change in Nickels:
		if (numNickel > 1){
			System.out.println("  " + numNickel + " Nickels");
		}
		if (numNickel == 1){
			System.out.println("  " + numNickel + " Nickel");
		}
		if (numNickel < 1){
		}
		// Change in Pennies:
		if (numPenny > 1){
			System.out.println("  " + numPenny + " Pennies");
		}
		if (numPenny == 1){
			System.out.println("  " + numPenny + " Penny");
		}
		if (numPenny < 1){
		}
		
		System.out.println("Thank you for shopping at SCI Gas Station. :)");
		System.out.println("");
	}
}