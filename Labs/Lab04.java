import java.util.*;

public class Lab04
{
	public static void main(String [] args){
		Scanner userInput = new Scanner(System.in);	// Scanner for user input.
		
		String yesNo = "y"; 	// Set control variable for while loop.
		
		while(yesNo.equals("y")|| yesNo.equals("Y")){
		
			System.out.print("Please enter a number of rolls: ");
			int rollNumber = userInput.nextInt();	// User puts custom number of rolls.
			Random randRoll = new Random();				// Object for random.
			
			rollDice(rollNumber, randRoll);		// Call rollDice with roll number and random object parameters.
			
			System.out.print("Do you want to continue? (y/n): ");	// Conditional check.
			yesNo = userInput.next();
		}
		
		System.out.println("Goodbye!"); // When user breaks loop with "n".
	}
	
	public static void rollDice (int num, Random rand){
		// Intialize values 2-12:
		double valTwo = 0;
		double valThree = 0;
		double valFour = 0;
		double valFive = 0;
		double valSix = 0;
		double valSeven = 0;
		double valEight = 0;
		double valNine = 0;
		double valTen = 0;
		double valEleven = 0;
		double valTwelve = 0;
		
		for(int i = 0; i < num; i++){
			
			int dieOne = rand.nextInt(6) + 1;
			int dieTwo = rand.nextInt(6) + 1;
			
			int dieValue = dieOne + dieTwo;
			
			if(dieValue == 2){
				valTwo++;
			}
			else if(dieValue == 3){
				valThree++;
			}
			else if(dieValue == 4){
				valFour++;
			}
			else if(dieValue == 5){
				valFive++;
			}
			else if(dieValue == 6){
				valSix++;
			}
			else if(dieValue == 7){
				valSeven++;
			}
			else if(dieValue == 8){
				valEight++;
			}
			else if(dieValue == 9){
				valNine++;
			}
			else if(dieValue == 10){
				valTen++;
			}
			else if(dieValue == 11){
				valEleven++;
			}
			else if(dieValue == 12){
				valTwelve++;
			}	
			
		}
		double val2 = valTwo / num;
		double val3 = valThree / num;
		double val4 = valFour / num;
		double val5 = valFive / num;
		double val6 = valSix / num;
		double val7 = valSeven / num;
		double val8 = valEight / num;
		double val9 = valNine / num;
		double val10 = valTen / num;
		double val11 = valEleven / num;
		double val12 = valTwelve / num;
		
		System.out.println("Value: 2 Probability: " + val2);
		System.out.println("Value: 3 Probability: " + val3);
		System.out.println("Value: 4 Probability: " + val4);
		System.out.println("Value: 5 Probability: " + val5);
		System.out.println("Value: 6 Probability: " + val6);
		System.out.println("Value: 7 Probability: " + val7);
		System.out.println("Value: 8 Probability: " + val8);
		System.out.println("Value: 9 Probability: " + val9);
		System.out.println("Value: 10 Probability: " + val10);
		System.out.println("Value: 11 Probability: " + val11);
		System.out.println("Value: 12 Probability: " + val12);
	}
}