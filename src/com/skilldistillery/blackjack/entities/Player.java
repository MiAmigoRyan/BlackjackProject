package com.skilldistillery.blackjack.entities;

import java.util.List;

public class Player {

	private List<Card> hand;
	
	public void deltCard (Card card) {
		this.hand.add(card);
	}

	public List<Card> getHand() {
		return hand;
	}
	
	public void hit () {
		
	}
	
	public void stay() {
		
	}
	
}
