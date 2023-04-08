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

	public List<Card> shuffle() {
		Collections.shuffle(deck.getDeck());
		return deck.getDeck();
	}
	

	public void dealToPlayer(Player player) {
	   deck.dealCard();
//	   player.getHand().addCard(card);
	}
	
	public void revealTopCard(Player player) {
		System.out.println( "dealer hand\n "+ hand.getCards().get(0)
				           +"\n__________________________");
	}
	
	public void viewDealerHand(Player player){
		System.out.println("___________________________________" 
						 + "\nDealers's hand"+ "\n"+ hand.getCards()
						 + "\n___________________________________");
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

}
