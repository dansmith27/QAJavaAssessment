package danS.BarrenMoor;

public class WinConditions {
	//returns  true if player succeeds to end game
	static public boolean checkWinConditions(Player player, Treasure treasure) {
		if (treasure.getCollected() && player.getLocation()[0] == player.getStartLocation()[0] && player.getLocation()[1] == player.getStartLocation()[1]) {
			System.out.println("You climb aboard your ship, throw the rogue trader his share of the ");
			System.out.println("Treasure, and sail away into the sunset.");
			return true;
		}
		else {
			return false;
		}
	}
}
