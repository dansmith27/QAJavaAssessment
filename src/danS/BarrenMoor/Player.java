package danS.BarrenMoor;

public class Player {
	//required private variables
	private String name;
	private int health;
	private int gold;
	private int[] location;
	private Object[] objects;
	private int[] pStartLocation = {0,0};
	
	//getters
	public String getName() {
		return name;
	}
	public int getHealth() {
		return health;
	}
	public int getGold() {
		return gold;
	}
	public int[] getLocation() {
		return location;
	}
	public int[] getStartLocation() {
		return pStartLocation;
	}
	public Object[] getObjects() {
		return objects;
	}
	
	//value manipulator functions
	public void takeDamage() {
		health -= 20;
	}
	//may be used in future if system expanded upon
	public void addObject(Object newObject) {
		for(int i = 0; i < objects.length; i++) {
			if (objects[i] == null) {
				objects[i] = newObject;
				System.out.println("Item added to inventory");
				break;
			}
			else if(i == objects.length-1 && objects[i] != null) {
				System.out.println("You have no room to carry such an item.");
			}
		}
	}
	
	//player movement functions
	public void move(int direction) { //0=north,1=east,2=south,3=west
		if(direction < 4 && direction >=0) {
			switch(direction) {
			//move north
			case 0:
				System.out.println("You moved north!");
				location[1]++;
				break;
			//move east
			case 1:
				System.out.println("You moved east!");
				location[0]++;
				break;
			//move south
			case 2:
				System.out.println("You moved south!");
				location[1]--;
				break;
			//move west
			case 3:
				System.out.println("You moved west!");
				location[0]--;
			}
		}
		else {
			System.out.println("Invalid movement direction");
		}
	}
	
	//constructor to initialise player values
	public Player(String nName, int[] startLocation, Object[] startObjects ){
		name = nName;
		health = 100;
		gold = 0;
		location = startLocation;
		objects = startObjects;
	}
}
