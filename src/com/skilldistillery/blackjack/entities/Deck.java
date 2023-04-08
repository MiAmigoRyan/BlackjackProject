package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	private List<Card> cards;
	
	public Deck() {
		cards = createDeck();
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
		return cards.size();
	}

	public List<Card> getDeck() {
		return cards;
	}
	
	public Card dealCard() {
		return cards.remove(0);
	}
	}
