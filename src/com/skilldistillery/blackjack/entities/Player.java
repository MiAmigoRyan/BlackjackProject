package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	private List<Card> hand = new ArrayList<>();
	
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

	public List<Card> getHand() {
		return hand;
	}
	
	public void hit () {
		
	}
	
	public void stay() {
		
	}
	
}
