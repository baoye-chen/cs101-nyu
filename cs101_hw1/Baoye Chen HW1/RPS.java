import java.util.Scanner;

/*
	This program lets the user play rock, paper, scissors with the computer.
	The computer's choice would be randomly generated.
	The user can make their own choice according to the insctruction.
*/

public class RPS{

	// This method is used to print the rock, paper, and scissors according to the input i
	// i = 1: print rock
	// i = 2: print paper
	// i = 3: print scissors
	public static void printRPS (int i){

		if (i == 1){

			System.out.println(" __.--.--._\n"+
								"/  | _|  | `|\n" + 
								"|  |` |  |  |\n" +
								"| /’--:--:__/\n" + 
								"|/  /      |\n" + 
								"(  ’ \\     |\n" + 
								" \\    `.  /\n" + 
								"  |      |\n"+
								"  |      |\n ");

		}

		else if (i == 2){

			System.out.println("    --.--.\n"+
						"   |  |  |\n" + 
						".\"\"|  |  |_\n" +  
						"|  |  |  | `|\n" + 
						"|  | _|  |  |\n" +
						"|  |` )  |  |\n" +
						"| /’  /     /\n" +
						"|/   /      |\n" +
						"(   ’ \\     |\n" +
						"\\      `.  /\n" +
						" |        |\n" + 
						" |        |\n");

		}

		else if (i == 3){

			System.out.println(".\"\".   .\"\",\n" +
							   "|  |  /  /\n" +
							   "|  | /  /\n" +
							   "|  |/ .--._\n" +
							   "|    _|  | `|\n" +
							   "|  /` )  |  |\n" +
							   "| /  /’--:__/\n" +
						       "|/  /      |\n" +
							   "(  ’ \\     |\n" +
							   " \\    `.  /\n" +
							   "  |      |\n" +
							   "  |      |\n");

		}

	}

	// This method generates the computer's choice randomly
	public static int computer(){
		int computerChoice;

		// generates a random integer between 1 and 3, inclusive
		computerChoice = (int)((Math.random() * 3) + 1) ;
		return computerChoice;
	}


	// This method compare the computer's choice and the user's choice
	// Then it decides the winner (or draw) according to the two input integers
	// The two integers, between 1 and 3, inclusive, represent player's choice and computer's choice
	public static void playGame(int pla, int comp){

		if (pla == comp){
			System.out.println("Draw! No winner."); 
		}
		else if (pla== 1 && comp == 2 ){
			System.out.println("Computer Won. (paper beats rock)");
		}
		else if (pla== 1 && comp == 3 ){
			System.out.println("Player Won. (rock beats scissors)");
		}
		else if (pla== 2 && comp == 1 ){
			System.out.println("Player Won. (paper beats rock)");
		}
		else if (pla== 2 && comp == 3 ){
			System.out.println("Computer Won. (scissors beats paper)");
		}
		else if (pla== 3 && comp == 1 ){
			System.out.println("Computer Won. (rock beats scissors)");
		}
		else if (pla== 3 && comp == 2 ){
			System.out.println("Player Won. (scissors beats paper)");
		}

	}

	// This is the main method of this class
	// It calls the previously defined method and executes the game
	public static void main(String[] args){

		// prints out the welcome banner
		System.out.println("=========================================");
		System.out.println("Welcome to the Rock-Paper-Scissors game!");
		System.out.println("=========================================");

		// declares the integer p, to represent the player's choice to be sent into the printRPS(i)
		int p;

		// initialize p with the value zero
		p = 0;

		// define a new Scanner object
		Scanner s = new Scanner(System.in);

		// prompt the user to enter their choices until a valid input is entered
		// Then, change the p to the corresponding number among 1, 2, 3
		// If not, the p stays zero, and would prompt the user to eneter again, with a message asking them to enter a proper choice
		while(p == 0){

			System.out.println("\nSelect your element:");
			System.out.println("		R/r - rock");
			System.out.println("		P/p - paper");
			System.out.println("		S/s - scissors");

			String playerChoice = s.nextLine();

			if(playerChoice.equals("R") || playerChoice.equals("r")){
				p = 1;
				
			}
			else if(playerChoice.equals("P") || playerChoice.equals("p")){
				p = 2;
				
			}
			else if(playerChoice.equals("S") || playerChoice.equals("s")){
				p = 3;
				
			}
			else
				System.out.println("Please enter an input according to the instruction!");

		}

		// call the printRPS(i) function to print out the player's choice
		printRPS(p); 
		System.out.println("Player");

		// declare the variable to store the computer's choice
		int c;

		// first generate computer's choice with the computer() method
		// Then it prints out using the printRPS(i) method
		c = computer();
		printRPS(c);
		System.out.println("Computer");

		// Lastly, run the playGame(p, c) to compare the two choices and return the result of the game
		playGame(p, c);

	}
}