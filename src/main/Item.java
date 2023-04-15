/*
 * This is the Item class.
 */
package main;

public class Item extends Purchasable {
	private String name;
	private STATS stat;
	private int value;
	public Item() {
		
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
	public STATS getStat() {
		return stat;
	}
	
	public static void main(String[] args) {
		Item item = new Item();
		System.out.println(item.stat);
	}

}
