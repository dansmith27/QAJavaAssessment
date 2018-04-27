package danS.BarrenMoor;

public class Potion extends Object{
	//extending functionality of object class to make usable
	public void use() {
		System.out.println("The liquid gurgles and splutters inside you, after a few sips you feel rejuvinated!");
	}
	private int[] location = {5,2};
	private boolean collected = false;
	
	public boolean getCollected() {
		return collected;
	}
	public int[] getLocation() {
		return location;
	}
	public void setCollected(boolean status) {
		collected = status;
	}
}
