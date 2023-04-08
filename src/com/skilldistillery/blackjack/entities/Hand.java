package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	protected List<Card> cards;

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

	public int handValue() {
//this is where aces could be considered 11 or 1	
		int sumOfHand = 0;

		for (Card card : cards) {
			sumOfHand += card.getValue();
		}

		return sumOfHand;

	}

	public boolean blackjack() {
		return (handValue() == 21 && cards.size() == 2);
	}

	public boolean bust() {
		return (handValue() > 21);

	}

	public void clear() {
		cards.clear();

	}

}