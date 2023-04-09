package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackJackApp {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BlackJackApp bJ = new BlackJackApp();
		bJ.run();

	}

	public static void run() {
		Dealer dealer = playInquisition();
		Player player = playerName();
		dealHands(player, dealer);
		playBlackJack(player,dealer);
		//winner(player, dealer);
		}
	
	public static Dealer playInquisition() {
		boolean valid = true;
		while(valid) {
		System.out.println("Would you like to play? \n Y to play -or- N to quit");
		String playGame = sc.next();
		sc.nextLine();
			if(playGame.equalsIgnoreCase("Y")||playGame.equalsIgnoreCase("YES")){
				break;
			}
			else if(playGame.equalsIgnoreCase("N")||playGame.equalsIgnoreCase("no")) {
				quit();
				break;
			}else {
				System.out.println("invalid input please enter yes, no, Y , or N. ");		
			}
		}
		Dealer dealer = new Dealer();	
		return dealer;
	}
	public static Player playerName( ) {
	System.out.println("What is your name? ");
	String userName = sc.next();
	sc.nextLine();
	Player player = new Player(userName);
	return player;
	}
	public static void dealHands(Player player, Dealer dealer) {
		// shuffles deck
		dealer.shuffle();
		//deals card to player
		player.addCardToHand(dealer.getDeck().dealCard());
		//deals card to dealer
		dealer.addCardToHand(dealer.getDeck().dealCard());
		
		player.addCardToHand(dealer.getDeck().dealCard());
		dealer.addCardToHand(dealer.getDeck().dealCard());
				
		player.viewHand( player );
		dealer.revealTopCard( dealer );

		if( player.getHand().blackjack()) {
			winner(player, dealer);	
		}
	}
	public static void playBlackJack (Player player, Dealer dealer) {	
		while(!player.getHand().bust()) {
			System.out.println("+++++++++++++++++++++++++++++++++++"+
	                           "\n           (1) to HIT            "+
						       "\n           (2) to STAY           "+         
		                       "\n+++++++++++++++++++++++++++++++++++");
			int choice = sc.nextInt(); 
			sc.nextLine();
			
					
			if (choice == 1) {
				player.addCardToHand(dealer.getDeck().dealCard());
				if(player.getHand().bust()) {
					System.out.println("you busted!");
					winner(player, dealer);
					break;
				}
				if(player.getHand().blackjack()) {
					System.out.println("BlackJack!");
					winner(player, dealer);
					break;
				}
				player.viewHand(player);
				dealer.revealTopCard(dealer);
				}
				
			if(choice == 2 ) {
					System.out.println("Stay");
					winner(player, dealer);
					break;

				}
			}

		}
	public static void dealerPlay(Dealer dealer) {
	 int dealerHandValue = 0;
	 boolean dealerPlay = true;
	 while (dealerPlay) { 
		 if (dealerHandValue<17) {
			dealer.addCardToHand(dealer.getDeck().dealCard());
			dealerHandValue = dealer.getHand().handValue();
			System.out.println("Dealer Hits :");
			//dealer.viewDealerHand( dealer );	
		 	}
	 
	 		if (dealerHandValue > 21 ) {
	 			dealerPlay = false;
	 			break;
	 		}
	 		if (dealerHandValue == 21 ) {
	 			dealerPlay = false;
	 			break;
	 		}
	 	}
	} 
	public static void winner(Player player, Dealer dealer) {
	    System.out.println("Final hands :");
	    player.viewHand(player);
	    dealer.viewHand(dealer);

	    if (player.getHand().blackjack()) {
	        System.out.println( player.getName() + " wins!");
	        playAgain(player, dealer);
	        
	    }
	    else if (player.getHand().bust()) {
	        System.out.println("Dealer wins!");
	        playAgain(player, dealer);
	    }
	    else if (dealer.getHand().bust()) {
	        System.out.println("Dealer busts! " + player.getName() + " wins!");
	        playAgain(player, dealer);
	    }
	    else if (player.getHand().handValue() > dealer.getHand().handValue()) {
	        System.out.println(player.getName() + " wins!");
	        playAgain(player, dealer);
	    }
	    else if (player.getHand().handValue() < dealer.getHand().handValue()) {
	        System.out.println("Dealer wins!");
	        playAgain(player, dealer);
	    }
	    else {
	        System.out.println("It's a tie!");
	        playAgain(player, dealer);
	    }
	}
	public static void playAgain(Player player, Dealer dealer) {
	    System.out.println("Do you want to play again? \n Y to play again -or- N to quit");
	    String playAgain = sc.next();
	    sc.nextLine();
	    if (playAgain.equalsIgnoreCase("Y") || playAgain.equalsIgnoreCase("YES")) {
	        player.clearHand();
	        dealer.clearHand();
	        dealHands(player, dealer);
	        playBlackJack(player, dealer);
	        dealerPlay(dealer);
	        winner(player, dealer);
	        playAgain(player, dealer);
	    } else if (playAgain.equalsIgnoreCase("N") || playAgain.equalsIgnoreCase("NO")) {
	        quit();
	    } else {
	        System.out.println("Invalid input. Please enter yes, no, Y, or N.");
	        playAgain(player, dealer);
	    }
	}
		
	public static void quit() {
		System.out.println("Thanks, come back again soon!");
	}
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
