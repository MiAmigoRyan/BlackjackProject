package com.skilldistillery.blackjack.entities;

import java.util.Collections;
import java.util.List;

public class Dealer extends Player {
	private Deck deck;

	public Dealer() {
		super("Dealer");
		deck = new Deck();
		shuffle();
	}

//	public void dealCard() {
//		deck.dealCard();
//	}

	private void revealTopCard() {

	}

//	private void shuffle() {
//		deck.shuffle();
//	}
	
	public List<Card> shuffle() {
		Collections.shuffle(deck.getDeck());
		return deck.getDeck();
	}
	
	public Card dealCard() {
		return deck.getDeck().remove(0);
	}
}
