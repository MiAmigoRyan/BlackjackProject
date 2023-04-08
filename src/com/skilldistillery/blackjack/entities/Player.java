package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Player extends Hand {
	private String name;
	private List<Card> hand = new ArrayList<>() ;
	 
	
	public Player(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name ;
	}

	public void addCardToHand (Card card) {
		this.hand.add(card);
	}

	public String getHand() {
		return hand.toString();
	}
	
	public BlackJackHand getBJHand() {
	    BlackJackHand blackjackHand = new BlackJackHand();
	    blackjackHand.addCards(hand);
	    return blackjackHand;
	}	
	
	public void viewHand(){
		System.out.println("__________________________" + "\n your hand \n"+ hand + "\n____________________________________");
	}

}
