package danS.BarrenMoor;

public class Treasure extends Object {
	//polymorphic function
	public void use() {
		System.out.println("How am i meant to use treasure?!?");
	}
	
	//location and if collected by player
	private boolean collected = false;
	private int[] location = {15,0};
	
	//get functions for location and status
	public boolean getCollected() {
		return collected;
	}
	public int[] getLocation() {
		return location;
	}
	//set function so status can be changed when player collects
	public void setCollected(boolean ncollected) {
		collected = ncollected;
	}

}
