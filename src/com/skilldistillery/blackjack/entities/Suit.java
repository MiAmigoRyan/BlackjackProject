package com.skilldistillery.blackjack.entities;

public enum Suit {
	   CLUBS("♣"), 
	    DIAMONDS("♦"), 
	    HEARTS("♥"), 
	    SPADES("♠");

	private final String name;

	Suit(String name) {
		this.name = name;
	}

	public String toString() {

		return name;
	}

}
