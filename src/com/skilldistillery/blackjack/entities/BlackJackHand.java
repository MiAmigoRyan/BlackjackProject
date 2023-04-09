package com.skilldistillery.blackjack.entities;

public class BlackJackHand extends Hand{

	public int handValue() {
		
				int numAces = 0;
				int sumOfHand = 0;
				for (Card card : cards) {
					if(card.getRank()== Rank.ACE) {
						numAces++;
					}else {
					sumOfHand += card.getValue();
					}
				}
				for (int aces = 0; aces< numAces; aces++) {
					if(sumOfHand +11 >= 21) {
						sumOfHand += 11;
					}else {
						sumOfHand +=1;
					}
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
