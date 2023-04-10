package com.skilldistillery.blackjack.entities;

import java.util.Collections;
import java.util.List;

public class Dealer extends Player {
	private Deck deck;
	

	public Dealer() {
		super("Dealer");
		deck = new Deck();
		shuffle();
	}

	public void clearHand() {
		this.hand.clear();
	}
	public List<Card> shuffle() {
		Collections.shuffle(deck.getDeck());
		return deck.getDeck();
	}
	

	public void dealToPlayer(Player player) {
	   deck.dealCard();
	}
	
	public void revealTopCard(Player player) {
		System.out.println( "\t\tdealer hand\n "+ hand.getCards().get(0) + " [] "
				           +"\n___________________________________");
	}
	
	public void viewDealerHand(Player player){
		System.out.println("___________________________________" 
						 + "\n\t\tDealers's hand"+ "\n"+ hand.getCards()
						 +"\n         "+ hand.handValue()
						 + "\n___________________________________");
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

}
