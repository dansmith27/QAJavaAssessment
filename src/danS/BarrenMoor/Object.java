package danS.BarrenMoor;

public abstract class Object {
	//required private variables
	private String name;
	private int damage, durability, value;
	//abstract to require overriding
	public abstract void use();
	
	//getters
	public String getName() {
		return name;
	}
	public int getDamage() {
		return damage;
	}
	public int getDurability() {
		return durability;
	}
	public int getValue() {
		return value;
	}
	
	//set name to null, return value
	public int sell() {
		name = null;
		return value;
	}
	
	//initialise item, would use constructor however not sure how to inherit these
	public void setItem(String iName, int iDamage, int iDurability, int iValue) {
		name = iName;
		damage = iDamage;
		durability = iDurability;
		value = iValue;
	}
}
