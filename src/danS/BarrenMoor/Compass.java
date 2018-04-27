package danS.BarrenMoor;


import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Compass {
	public void use(Treasure treasure, Player player, Potion potion) {
		//Player vs treasure
		//player positions
		int pX = player.getLocation()[0];
		int pY = player.getLocation()[1];
		
		//treasure positions
		int tX = treasure.getLocation()[0];
		int tY = treasure.getLocation()[1];
		
		//x length of triangle formed by points
		int xlength;
		if(pX > tX) {
			xlength = pX-tX;
		}
		else {
			xlength = tX-pX;
		}
		
		//y length of triangle formed by points
		int ylength;
		if(pY > tY) {
			ylength = pY-tY;
		}
		else {
			ylength = tY-pY;
		}
		
		//calculate length
		double playerToTreasure = Math.hypot(ylength, xlength);
		
		
		//Player vs potion
			
				
		//potion positions
		int poX = potion.getLocation()[0];
		int poY = potion.getLocation()[1];
		
		
		if(pX > poX) {
			xlength = pX-poX;
		}
		else {
			xlength = poX-pX;
		}
		
		//y length of triangle formed by points
		
		if(pY > poY) {
			ylength = pY-poY;
		}
		else {
			ylength = poY-pY;
		}

		double playerToPotion = Math.hypot(ylength, xlength);

		
		
		
		//create formatter and format to two decimal places
		NumberFormat formatter = new DecimalFormat("####.##");
		
		
		//show closest non collected item
		if (playerToTreasure < playerToPotion && !treasure.getCollected()) {
			System.out.println("Disance to next object: " + formatter.format(playerToTreasure) + "m");
		}
		else if(!potion.getCollected()) {
			System.out.println("Disance to next object: " + formatter.format(playerToPotion)+ "m");
		}
		else if (!treasure.getCollected()) {
			System.out.println("Disance to next object: " + formatter.format(playerToTreasure)+ "m");
		}
		else {
			System.out.println("No objects left to collect");
		}
		
	}
}
