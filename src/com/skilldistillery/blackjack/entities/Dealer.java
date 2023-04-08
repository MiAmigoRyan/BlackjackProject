package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer extends Player {
	private Deck deck;
	private List<Card> dealerHand = new ArrayList<>();
	

	public Dealer() {
		super("Dealer");
		deck = new Deck();
		shuffle();
		dealerHand = new ArrayList<>();
	}

	public List<Card> shuffle() {
		Collections.shuffle(deck.getDeck());
		return deck.getDeck();
	}
	
	public Card dealCard() {
		return deck.getDeck().remove(0);
	}

	public void dealToPlayer(Player player) {
	    Card card = dealCard();
	    player.addCard(card);
	}
	public void dealToDealerHand (Card card) {
		dealerHand.add(card);
	}
	
	public void revealTopCard() {
		System.out.println( "dealer hand\n "+ dealerHand.get(0)+"\n__________________________");
	}	

}
