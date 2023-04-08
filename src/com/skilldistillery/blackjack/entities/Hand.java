package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	protected List<Card> cards;

	
	public abstract int handValue();
	
	public Hand() {
		cards = new ArrayList<>();
	}

	public void addCard(Card card) {
		cards.add(card);

	}

	public void showCards() {
		for (Card card : cards) {
			System.out.println(card.toString());
		}
	}

	public void clear() {
		cards.clear();

	}

}