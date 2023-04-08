package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Player extends Hand {
	private String name;
//	private List<Card> hand  ;
	 
	
	public Player(String name) {
		//super();
		this.name = name;
	}

	@Override
	public String toString() {
		return name ;
	}

//	public List<Card> addCardToHand (Card card) {
//		return addCard(hand);
//	}
	
	public void viewHand(){
		System.out.println("__________________________" 
						 + "\n your hand \n"+ cards
						 + "\n________________________");
	}

}
