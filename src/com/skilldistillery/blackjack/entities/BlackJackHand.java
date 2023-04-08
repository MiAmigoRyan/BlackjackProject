package com.skilldistillery.blackjack.entities;

import java.util.List;

public class BlackJackHand extends Hand {

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
	public void addCards(List<Card> hand) {
		// TODO Auto-generated method stub
		
	}
}
