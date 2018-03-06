import java.io.IOException;
import java.util.*;
public class CountingGame {

	public static void main(String[] args) throws IOException, InterruptedException {
		Menu();
		Game();
	}
	
	private static void Menu() throws InterruptedException{
		Scanner c = new Scanner(System.in);
		int MenuChoice;
		System.out.println("Welcome to the Counting Game.");
		System.out.println("1.Play\n2.Instructions\n3.Exit");
		System.out.print("Your choice: ");
		MenuChoice = c.nextInt();
		while(MenuChoice < 0 || MenuChoice > 3){
			System.out.println("Please make a valid choice!");
			MenuChoice = c.nextInt();
		}	
		System.out.println("You chose " + MenuChoice + ".\n\n\n\n\n");	//Clear Screen
		if(MenuChoice == 2){
			String cont = null;
			System.out.print("Instructions:\nThe counting game is a game ");
			System.out.print("Where the player faces off against the AI in a counting sequence.\n");
			System.out.print("The Player and the AI get to strategically add 1 to 3 numbers to the count.\n");
			System.out.print("To finish your turn input 0.");
			System.out.print("The limit to the count is set ahead of the\nplay and the one to add the final number ");
			System.out.println("to the count sequence loses.");
			System.out.println("Play...?\n(Y/N)?");
			cont = c.next();
			while(cont.charAt(0) != 'Y' && cont.charAt(0) != 'y' && cont.charAt(0) != 'N' && cont.charAt(0) != 'n'){
				System.out.println("Make a valid choice");
				cont = c.next();
			}
			if(cont.charAt(0) == 'Y' || cont.charAt(0) == 'y'){}
			else if(cont.charAt(0) == 'N' || cont.charAt(0) == 'n'){
				System.exit(0);
			}
		}
		else if(MenuChoice == 3){
			System.exit(0);
		}
		else{
			Game();	//Clear Screen
		}
	}

	private static void Game() throws InterruptedException {
		Scanner c = new Scanner(System.in);
		Random ran = new Random();
		int Limit = 0;
		System.out.println("Choose a number as an end limit for the game:");
		Limit = c.nextInt();
		System.out.print("Starting game");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		for(int count = 0;	count < 100; count++){
			System.out.println();
		}
		int GameCounter = 0, Score = 0, MoveCounter = 0;
		System.out.println("The game ends at " + Limit + ".");
		while(GameCounter < Limit){
			int PMove = 0;
			System.out.println("Your turn...");
			MoveCounter++;
			for(int PMoveCounter = 1;	PMoveCounter < 4;	PMoveCounter++){
				PMove = c.nextInt();
				if(PMove == 0 && PMoveCounter == 0){
					while(PMove == 0){
						System.out.println("You must go at least once during your turn!");
						PMove = c.nextInt();
					}
					GameCounter++;
				}
				else if(PMove == 0 && PMoveCounter != 0){
					System.out.println("Your turn has ended...");
					PMoveCounter = 4;
				}
				else{
					GameCounter++;
				}
			}
			System.out.println();
			System.out.println("The play so far:");
			for(int disp = 1;	disp <= GameCounter;	disp++){
				System.out.print(disp + " ");
			}
			System.out.println();
			if(GameCounter < Limit){
				System.out.println("AI's turn...");
				MoveCounter++;
				Thread.sleep(1000);
				int MovesLeft = Limit - GameCounter;
				int AIturn = 0;
				if(MovesLeft == 1){
					AIturn = 1; 
				}
				else if(MovesLeft == 2){
					AIturn = 1;
				}
				else{
					AIturn = ran.nextInt(2) + 1;
				}
				for(int MoveLoop = 0;	MoveLoop <AIturn;	MoveLoop++){
					Thread.sleep(500);
					GameCounter++;
					System.out.println(GameCounter + " ");
				}
				System.out.println();
				System.out.println("The play so far:");
				for(int disp = 1;	disp <= GameCounter;	disp++){
					System.out.print(disp + " ");
				}
				System.out.println();
			}
			else{}
		}
		Thread.sleep(1000);
		for(int count = 0;	count < 100; count++){
			System.out.println();
		}
		System.out.println("The game has ended...");
		if(MoveCounter % 2 == 0){
			Score = 1;
		}
		else{
			Score = 0;
		}
		c.close();
		if(Score > 0){
			System.out.println("You Win!");
		}
		else{
			System.out.println("You Lose!");
		}
		Thread.sleep(10000);
		System.exit(0);
	}
}
