package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackJackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Hand;
import com.skilldistillery.blackjack.entities.Player;

public class BlackJackApp {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BlackJackApp bJ = new BlackJackApp();
		bJ.run();
	}

	public static void run() {
				
		boolean valid = true;
		while(valid) {
		System.out.println("Would you like to play? \n Y to play -or- N to quit");
		String playGame = sc.next();
		sc.nextLine();
			if(playGame.equalsIgnoreCase("Y")||playGame.equalsIgnoreCase("YES")){
				playBlackJack();
				break;
			}
			else if(playGame.equalsIgnoreCase("N")||playGame.equalsIgnoreCase("no")) {
				quit();
				break;
			}else {
				System.out.println("invalid input please enter yes, no, Y , or N. ");		
			}
		}
	}
	public static void playBlackJack() {
		
		System.out.println("What is your name? ");
		String userName = sc.next();
		sc.nextLine();
		Dealer dealer = new Dealer();
		Player player = new Player(userName);
		BlackJackHand dealerHand = new BlackJackHand();
		BlackJackHand playerHand = new BlackJackHand();
		
		
		dealer.dealToPlayer( player );
		dealer.dealToDealerHand( dealer.dealCard() ) ;
		
		dealer.dealToPlayer( player );
		dealer.dealToDealerHand( dealer.dealCard() ) ;
		
		player.viewHand();
		dealer.revealTopCard();
		
		if( playerHand.blackjack()) {
			System.out.println("Black Jack!!! You Win!!!");
		}
		

			System.out.println("+++++++++++++++++++++++++++++++++++\n"+
	                           "           (1) to HIT \n "   +
						       "	    (2) to STAY\n  "   +         
		                       "+++++++++++++++++++++++++++++++++++");
			int choice = sc.nextInt(); 
			sc.nextLine();
			
			while(!playerHand.bust()) {
				int playerHandValue = playerHand.handValue();
					
				if (choice == 1) {
				dealer.dealToPlayer(player);
				player.viewHand();
				playerHandValue = playerHand.handValue();
				}
				
				if(playerHand.bust()) {
				System.out.println("You BUST, Dealer Wins");
				}
				
				if(choice == 2 ) {
					
					break;
				}
			
		}
		

		}
		
	
	public static void quit() {
		System.out.println("Thanks, come back again soon!");
	}
	// dealer.deals card to player or dealer array list dot notation
}

//		C O M P L E T E		
//		User Story #1
//		Create a class structure that models a deck of cards. 
//		Remember decks hold cards, and cards are dealt to hands which will hold the dealt cards. 
//		Feel free to create the structure in any way you see fit.
//		Your card and deck implementations should NOT be coupled to Blackjack; 
//		you should be able to reuse them to implement a poker or bridge game application.
//
//		C O M P L E T E
//		User Story #2
//		Add methods and fields to your classes that model the functionality of shuffling and dealing
//		a deck of cards. Remember that when a card is dealt you have to remove it from 
//		the current deck. 
//		You should be able to display a shuffled deck to the console.
//
//		D E S I G N 
		// make two classes, one for dealers hand another for players hand
		// dealer deals a card to the play that the player can see
		// deal deals themselves a card that the player cannot see
		// above steps happen again
		// sum of players hand is shown to player
		// dealer asks player if they wish to hit or stay
		// if HIT dealer deals player a card
		// dealer asks player if they wish to hit or stay
		// if player chooses STAY dealer follows rules of BJ
		// if sum of dealer is less than or equal to 17 hit
		// if sum of dealer is greater than 17 stay
		// app announces winner
		// compare dealer finishing hand and player finishing hand
		// bust and blackJack interfaces
		// ask if the player would like to play again with the same deck
//

//		User Story #3
//		Deal two hands of cards - one to a Dealer and another to a Player. 
//		As a card is dealt from the deck, the card will be placed into the hand of either the dealer
//		or the player. Allow the players to Hit (add cards to their hand) 
//		or Stay (not add cards to their hand) in accordance to the rules of blackjack shown 
//		in the wiki.
//		Do not worry about the multiple values for Ace until your basic game logic is working. 
//		Assume they are either 1 or 11 to start.
//
//		User Story #4
//		The Dealer's decisions are based on game logic in the program:
//		The Dealer must decide to Hit or Stay based on the rules of Blackjack: 
//		if the Dealer's hand total is below 17, the Dealer must Hit; 
//		if the hand total is 17 or above, the Dealer must Stay.
//
//		User Story #5
//		Determine the winner of each round by implementing the remaining rules of Blackjack 
//		(such as going over 21) and comparing hand values.

////		Stretch Goals
////		Try as many of these as you like, but ONLY after you've completed, tested, and COMMITTED your working game that meets the requirements.
////
////		"Soft" Ace - Ace has the value 1 or 11.
////
////		A dealer must Hit on a hand with the value "soft 17" (where an Ace is present with value 11 and other cards total 6) and Stay on "hard 17" (where an Ace is present, but hitting could cause the Dealer to go over 21)
////		"Blackjack" hand - if the user is initially dealt an Ace and a card with the value 10, this is a blackjack. The user immediately wins unless the dealer also has a blackjack (two-card hand with an Ace and a 10-value card).
////
////		Allow multiple players in the game.
////
////		Implement a monetary system so players can place bets on their hands.
////
////		Allow players to split hands.
////
////		Allow players to double down.
////
////		Deal from a multi-deck shoe.
////
////		Keep going. How about implementing in-game suggestions based on the player's current hand? Maybe a card-counting player?
////		
