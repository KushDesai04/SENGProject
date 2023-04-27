/*
 * This is the Item class.
 */
package main;

public class Item extends Purchasable {
	private String name;
	private STATS stat;
	private int value;
	public Item(String name, STATS stat, int value) {
		this.name = name;
		this.stat = stat;
		this.value = value;
		this.description = name + ". This item increases a players " + getStatName() + " by " + value;
	}

	@Override
	public boolean buy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sell() {
		// TODO Auto-generated method stub
		
	}
	public int getValue() {
		return value;
	}
	
	public String getStatName() {
		switch (this.stat){
		case A:
			return "agility";
		case D:
			return "defence";
		case O:
			return "offence";
		case S:
			return "stamina";
		default:
			return "error";
		}
	}
	
	public STATS getStat() {
		return (this.stat);
	}
	
	public static void main(String[] args) {
		Item item = new Item("Cake", STATS.D, 12);
		System.out.println(item);
	}

}
