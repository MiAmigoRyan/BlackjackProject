package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	protected List<Card> cards;

	public Hand() {
		cards = new ArrayList<>();
	}

	public List<Card> getCards() {
		return cards;
	}

	public void addCard(Card card) {
		getCards().add(card);

	}

	public String toString() {
		return cards+"";
	}

	public void clear() {
		cards.clear();

	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

//	public int handValue() {
//		int sumOfHand = 0;
//		for (Card card : cards) {
//			sumOfHand += card.getValue();
//		}
//		return sumOfHand;
//	}

}