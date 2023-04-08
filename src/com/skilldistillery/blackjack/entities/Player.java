package com.skilldistillery.blackjack.entities;

public class Player extends Hand {
	private String name;
	 
	public Player(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name ;
	}

	public void viewHand(){
		System.out.println("__________________________" 
						 + "\n"+name+"'s hand"+ "\n"+ cards
						 + "\n________________________");
	}

}
