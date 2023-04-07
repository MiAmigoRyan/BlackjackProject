package com.skilldistillery.blackjack.entities;

public class Card {
 private Suit suit;
 private Rank rank;

 public Card(Suit suit, Rank rank) {
	super();
	this.suit = suit;
	this.rank = rank;
}

public Suit getSuit() {
	return suit;
}

public Rank getRank() {
	return rank;
}

@Override
public String toString() {
	return rank + " of " + suit ;
}
 
public int getValue() {
	return rank.getValue();
}
 
}
