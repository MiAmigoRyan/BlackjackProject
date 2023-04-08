package com.skilldistillery.blackjack.entities;

public class BlackJackHand extends Hand {

	@Override
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
}
