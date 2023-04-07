package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Dealer {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Dealer deal = new Dealer();
		deal.run();
	}

	private void run() {
		Deck deck = new Deck();
		deck.shuffle();

		List<Card> playerHand = new ArrayList<>(playerHand);
		int sumOfHand = 0;
			Card deltCard1 = deck.dealCard();
			Card deltCard2 = deck.dealCard();
			System.out.println("you have " + deltCard1 + "and " + deltCard2
					+ "\n sum of your hand: " + sumOfHand);
			sumOfHand += deltCard1.getValue()+deltCard2.getValue();
			playerHand.add(deltCard1);
			playerHand.add(deltCard2);		
		}

	}
}
