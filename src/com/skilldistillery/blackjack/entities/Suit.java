package com.skilldistillery.blackjack.entities;

public enum Suit {
	CLUBS("Clubs"), 
	DIAMONDS("Diamonds"), 
	HEARTS("Hearts"), 
	SPADE("Spades");

	private final String name;

	Suit(String name) {
		this.name = name;
	}

	public String toString() {

		return name;
	}

}
