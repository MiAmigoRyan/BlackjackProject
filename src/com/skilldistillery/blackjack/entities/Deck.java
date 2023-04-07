package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;
	
	public Deck() {
		deck = createDeck();
	}
	
	public static List<Card> createDeck() {
		
	List<Card> deck = new ArrayList<>(52);	
	for (Suit suit : Suit.values()) {
		for(Rank rank : Rank.values()) {
		deck.add(new Card(suit,rank));
		}
	}
	return deck;
	}
	
	public int cardDeckSize(){		
		return deck.size();
	}
// needs return new deck? - no shuffles each time called?	
// shuffle method should be in dealer +++
	public List<Card> shuffle() {
		Collections.shuffle(deck);
		return deck;
	}
	
	public Card dealCard() {
		return deck.remove(0);
	}

	public List<Card> getDeck() {
		return deck;
	}
	
}
