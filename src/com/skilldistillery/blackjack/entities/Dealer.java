package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Dealer extends Player {

	


private void deal() {
}

private void revealTopCard() {
	
}

	
	private void shuffle() {
		Deck deck = new Deck();
		deck.createDeck();
		deck.shuffle();
	}
}

//		List<Card> playerHand = new ArrayList<>();
//		List<Card> dealerHand = new ArrayList<>();
// 		
//		int sumOfPlayerHand = 0;
//		int sumOfDealerHand = 0;
//		
// 		Card deltCard1 = deck.dealCard();
// 		playerHand.add(deltCard1);
//		
//		Card deltCard2 = deck.dealCard();
//		dealerHand.add(deltCard2);
//		
//		Card deltCard3 = deck.dealCard();
//		playerHand.add(deltCard3);
//		
//		Card deltCard4 = deck.dealCard();
//		dealerHand.add(deltCard4);
//		
//		sumOfPlayerHand += deltCard1.getValue() + deltCard3.getValue();
//		System.out.println(sumOfPlayerHand);
//		sumOfDealerHand += deltCard2.getValue() + deltCard4.getValue();
//		System.out.println(sumOfDealerHand);
	}


