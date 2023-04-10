package com.skilldistillery.blackjack.entities;

public class Player  {
	private String name;
	
	protected BlackJackHand hand = new BlackJackHand();
	

	public Player(String name) {
		this.name = name;
	}
	
	public void clearHand() {
		this.hand.clear();
	}

	@Override
	public String toString() {
		return name ;
	}
	public void addCardToHand(Card card) {
	    hand.addCard(card);
	}

	public void viewHand(Player player){
		System.out.println("___________________________________" 
						 + "\n\t\t   "+name
						 + "\n\t\t HAND VALUE:"+ hand.handValue()
						 + "\n"+ hand
						 + "\n___________________________________");
	}
	public int viewSumOfHand() {
		return hand.handValue();
	}

	public BlackJackHand getHand() {
		return hand;
	}

	public void setHand(BlackJackHand hand) {
		this.hand = hand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
