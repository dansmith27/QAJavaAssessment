package danS.BarrenMoor;


import java.util.Scanner;

public class GameLoop {
	
	private Scanner sc;
	private Player player;
	private Compass compass;
	private Treasure treasure;
	private Potion potion;
	private Boolean gameComplete = false;
	
	//Write out intro text
	public void intro() {
		System.out.println("----------------------");
		System.out.println("Welcome to Barren Moor");
		System.out.println("----------------------");
		
		System.out.println("Here you are faced with your toughest challenge yet.");
		System.out.println("Trapped in a swamp by a merchant holding your ship hostage ");
		System.out.println("you must find some treasure and return to pay his randsom in");
		System.out.println("order to escape. Good Luck! \n");
	}
	
	//get values from player
	public void getInformation() {
		
		//Create Scanner for input
		sc = new Scanner(System.in);
		
		//prompt user to enter their name
		System.out.println("Say, sailor, what is your name?");
		
		//get name from user and validate
		boolean gotName = false;
		String playerName = "";
		while(!gotName) {
			String temp=" ";
			temp = sc.nextLine();
			if(temp !=" " && !temp.isEmpty()) {
				playerName = temp;
				gotName = true;
			}
			else {
				System.out.println("Please enter your name:");
			}
		}
		
		//continue story
		System.out.println("Well " + playerName + ", I demand 3000 gold coins for the return ");
		System.out.println("of your ship, return here when you have them.");
		System.out.println("I have left you with your sword and shield. Enjoy. \n");
		
		//Create Sword and shield
		Object[] items = new Object[5];
		items[0] = new Sword();
		items[0].setItem("Starting Sword", 30, 200, 50);
		items[1] = new Shield();
		items[1].setItem("Starting Shield", 2, 500, 50);
		
		//create player
		int[] pStartLocation = {0,0};
		player = new Player(playerName, pStartLocation, items);
		
		//create compass
		compass = new Compass();
		
		//create potion
		potion = new Potion();
		potion.setItem("Health Potion", -50, 0, 20);
		
		//create treasure
		treasure = new Treasure();
		treasure.setItem("Treasure!", 0, 100000, 10000);

		//continue story, prints what objects player currently has
		System.out.print("As you go out into the world with your ");
		for(int i = 0; i < player.getObjects().length; i++) {
			if (player.getObjects()[i] != null) {
				if(player.getObjects()[i + 1] != null ) {
					System.out.print(player.getObjects()[i].getName() + " and ");
				}
				else {
					System.out.print(player.getObjects()[i].getName() + " ");
				}
				
			}
		}
		System.out.println("\nin hand, you can't help but wonder what adventures await.");
	}
	
	
	//main game loop
	public void gameLoop() {
		//intro
		System.out.println("You stand on your ship looking out into the swamp with no choice but to continue on.");
		System.out.println("You hear your magical compass jingle, sure that if you use it you will be guided down the right path.");
		//main game loop
		while(!gameComplete) {
			
			//get action, main control scheme
			System.out.println("\nWhat action to you wish to perform? (type 'help' for hints)");
			boolean validAction = false;
			while (!validAction) {
				String tempInput = sc.nextLine();
				switch(tempInput) {
				case "help":
					help();
					validAction=true;
					break;
				case "north":
					player.move(0);
					checkPickup();
					validAction = true;
					break;
				case "south":
					player.move(2);
					checkPickup();
					validAction = true;
					break;
				case "east":
					player.move(1);
					checkPickup();
					validAction = true;
					break;
				case "west":
					player.move(3);
					checkPickup();
					validAction = true;
					break;
				case "compass":
					compass.use(treasure, player, potion);
					validAction = true;
					break;
				case "use":
					useItem();
					validAction = true;
					break;
				case "locations":
					printLocations(player);
					validAction = true;
					break;
				
				}
				if (!validAction) {
					System.out.println("Invalid action entered, please try again:");
				}
			}
			gameComplete = WinConditions.checkWinConditions(player, treasure);
		}
	}
	
	//output control help
	private void help() {
		System.out.println("\nControl help");
		System.out.println("'north' = move north");
		System.out.println("'south' = move south");
		System.out.println("'east' = move east");
		System.out.println("'west' = move west");
		System.out.println("'use' = use item (prompt for which item follows)");
		System.out.println("'locations' = list known locations \n");
	}
	
	//check if player is on treasure
	private void checkPickup() {
		if(player.getLocation()[0] == treasure.getLocation()[0] && player.getLocation()[1] == treasure.getLocation()[1]) {
			System.out.println("Battling the elements and many worthy foes along the way you have collected the treasure.");
			System.out.println("You are filled with a sense of accomplishment, knowing you can collect your ship and sail away a free man.");
			treasure.setCollected(true);
		}
		else if (player.getLocation()[0] == potion.getLocation()[0] && player.getLocation()[1] == potion.getLocation()[1]) {
			System.out.println("You have found a potion!");
			player.addObject(potion);
			potion.setCollected(true);
		}
	}
	
	//use item
	private void useItem() {
		//get valid inputs based on carried objects + compass
		System.out.println("Which item do you wish to use?");
		int[] validInputs = new int [6];
		for(int i = 0; i < player.getObjects().length; i++) {
			if (player.getObjects()[i] != null) {
				System.out.println("[" + i + "] = " + player.getObjects()[i].getName());
				validInputs[i] = i;
			}
			else {
				System.out.println("[" + i + "] = " + "Compass");
				break;
			}
		}
		
		//validate user input to make sure int is entered
		while(!sc.hasNextInt()) {
			System.out.println("invalid number entered, please enter valid number");
			sc.nextLine();
		}
		int inputTemp = sc.nextInt();
		System.out.println(inputTemp);
		
		//validate number
		if(inputTemp > 0 && inputTemp < 6) {
			//use object selected
			if (player.getObjects()[inputTemp] != null) {
				player.getObjects()[inputTemp].use();
			}
			//use compass if chosen
			else if (player.getObjects()[inputTemp] == null && player.getObjects()[inputTemp -1] != null) {
				compass.use(treasure, player, potion);
			}
			else {
				System.out.println("You look down at your empty hands confused");
			}
		}
		else {
			System.out.println("You look down at your empty hands confused");
		}
		
		
	}
	
	//function to print known locations when option is selected
	private void printLocations(Player player) {
		System.out.println("Your Location is: (" + player.getLocation()[0] + "," + player.getLocation()[1] + ") ");
		System.out.println("Your Starting location was: (" + player.getStartLocation()[0] + "," + player.getStartLocation()[1] + ") ");
	}
}
