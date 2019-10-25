import java.util.*;	

	public class FruitMachine {	
	  public static void main(String[] args) { 

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in); // This sets up keyboard input.
		Random r = new Random(); // This sets up generating random numbers.
		
		// Declare variables.
		int Credits = 10;
		int UserInput = 0;
		boolean Game = true;

		while (Game == true) { 
		  //The game menu is displayed and allows the user to navigate.
		  System.out.println("============================================="+"\n"+" Welcome to Griffith College Fruit Machine! " +"\n" +"	 Game Menu" +"\n" + " 1. Display remaining credits, please press (1)" +"\n" +" 2. Play Game, please press (2)" +"\n" +" 3. Exit Game, please press (3)"+"\n"+"=============================================");
		  UserInput = scan.nextInt(); // Assign variable to keyboard input.

		  // user opts to exit the program.
		  if (UserInput == 3) {
			System.out.println(" Credits remaining: " + Credits);
			System.out.println(" Thank you for playing.");
			Game = false;
		  }
		  else if(UserInput != 1 && UserInput != 2 && UserInput != 3){
			  System.out.println("wrong entry");
			  }	

		  // user makes an inquiry for their credits balance.
		  if (UserInput == 1) {								
		  System.out.println(" You currently have " + Credits + " credits remaining.");
		  }

		  // user decides to play the game.
		  if (UserInput == 2) {
			if (Credits == 0) {
			  System.out.println(" Game Over! Thanks for playing.");
			  Game = false;
			}
		  else if (Credits !=0) {										
			  int Wheel1 = r.nextInt(6)+1; // Generate 3 random numbers.
			  int Wheel2 = r.nextInt(6)+1;
			  int Wheel3 = r.nextInt(6)+1;
			  Credits--;
			  System.out.println(" Wheel Spinning...	||" + Wheel1 + "||" + Wheel2 + "||" + Wheel3 + "||");
			 
			  //To check if the user got 7-7-7
		  if (Wheel1 == 7 && Wheel2 == 7 && Wheel3 == 7) {
				Credits = (Credits + 150);
				System.out.println(" THREE 7s!!! You have won 150 credits,"+"\n"+" you currently have " + Credits + " credits remaining.");
			  } 
		  
		  //To check if all of the user's numbers are identical
			  else if (Wheel1 == Wheel2 && Wheel1 == Wheel3) {
				 Credits = (Credits + 80);
				 System.out.println(" THREE MATCHING NUMBERS!!! You have won 80 credits,"+"\n"+" you currently have " + Credits + " credits remaining. ");
			  } 
		  
		  //To determine if the user's number is sequential
			  else if ((Wheel3 - Wheel2) == 1 && (Wheel2 - Wheel1) == 1){
				 Credits = (Credits + 40);
				 System.out.println(" THREE IN A ROW SEQUENTIAL NUMBERS!!! You have won 40 credits,"+"\n"+" you currently have " + Credits + " credits remaining.");
			  } 
		  
		  //To determine if the user's number is non sequential
			  else if (NonSequential(Wheel1,Wheel2,Wheel3)){
				 Credits = (Credits + 25);
				 System.out.println(" THREE IN A ROW NON SEQUENTIAL NUMBERS!!! You have won 25 credits,"+"\n"+" you currently have " + Credits + " credits remaining.");
			  }  
		  
		  //To check if the any 2 of the user's numbers are matching even
			  else if  (Wheel1 == Wheel2 && Wheel1 % 2 == 0 || Wheel1 == Wheel3 && Wheel1 % 2 == 0 || Wheel2 == Wheel3 && Wheel2 % 2 == 0) {
				 Credits = (Credits + 10);
				 System.out.println(" TWO MATCHING EVEN!!! You have won 10 credits,"+"\n"+" you currently have " + Credits + " credits remaining.");
			  } 
		  
		  //To check if any 2 of the user's numbers are matching odd
			  else if (Wheel1 == Wheel2 && Wheel1 % 2 != 0 || Wheel1 == Wheel3 && Wheel1 % 2 != 0 || Wheel2 ==  Wheel3 && Wheel2 % 2 != 0) {
				 Credits = (Credits + 5);
				 System.out.println(" TWO MATCHING ODD!!! You have won 5 credits,"+"\n"+" you currently have " + Credits + " credits remaining.");
			  }  
		  
		  //To check if any 1 of the user's number is a 7
			  else  if (Wheel1 == 7 || Wheel2 == 7 || Wheel3 == 7) {
				 Credits = (Credits + 2);
				 System.out.println(" ONE 7!!! You have won 2 credits,"+"\n"+" you currently have " + Credits + " credits remaining.");
			  }
			  else {
				 System.out.println(" Unlucky you did not win,"+"\n"+" you currently have " + Credits + " credits remaining.");
				} 
			} 
		} 
	} 
} 
	  
// This defines the method which will be called to determine if a set of numbers is non-sequential.
	    static boolean NonSequential(int w1, int w2, int w3) {
		int Mean = (w1 + w2+ w3)/3;
		return ((w1 == Mean || w2 == Mean || w3 == Mean ) && (w1 == Mean + 1 || w2 == Mean + 1 || w3 == Mean + 1) && (w1 == Mean -1 || w2 == Mean -1 || w3 == Mean -1));
	  }
	} 