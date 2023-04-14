package main;

import main.Athlete.Stats;

public class Item extends Purchasable {
	private String name;
	private Stats stat;
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
	public Stats getStat() {
		return stat;
	}

}
