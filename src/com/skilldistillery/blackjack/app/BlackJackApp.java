package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackJackApp {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		BlackJackApp bJ = new BlackJackApp();
		bJ.run();
		sc.close();
	}

	public void run() {
		Dealer dealer = playInquisition();
		Player player = playerName();
		dealHands(player, dealer);
		playBlackJack(player, dealer);
		
	}

	public static Dealer playInquisition() {
		boolean valid = true;
		while (valid) {
			System.out.println("      W E L C O M E  T O "
							  +"\n     B L A C K  J A C K"
		                      +"\n"
							  +"\n          ___   ___"
							  +"\n         |A  | |10 |" 
							  +"\n         | ♣ | | ♦ |" 
							  +"\n         |__A| |_10|"
							  +"\n"
		                      +"\n ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ "
							  +"\n Y E S  T O  S T A R T  G A M E "
							  +"\n ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ");
			
			String playGame = sc.next();
			sc.nextLine();
			if (playGame.equalsIgnoreCase("Y") || playGame.equalsIgnoreCase("yes")) {
				break;
			} else if (playGame.equalsIgnoreCase("N") || playGame.equalsIgnoreCase("no")) {
				quit();
				break;
			} else {
				System.err.println("invalid input please enter yes, no, Y , or N. ");
			}
		}
		Dealer dealer = new Dealer();
		return dealer;
	}

	public static Player playerName() {
		System.out.println("E N T E R   N A M E :");
		String userName = sc.next();
		sc.nextLine();
		Player player = new Player(userName);
		return player;
	}

	public static void dealHands(Player player, Dealer dealer) {
		dealer.shuffle();
		player.addCardToHand(dealer.getDeck().dealCard());
		dealer.addCardToHand(dealer.getDeck().dealCard());

		player.addCardToHand(dealer.getDeck().dealCard());
		dealer.addCardToHand(dealer.getDeck().dealCard());

		player.viewHand(player);
		dealer.revealTopCard(dealer);

		if (player.getHand().blackjack()) {
			winner(player, dealer);
		}
	}

	public static void playBlackJack(Player player, Dealer dealer) {
		while (!player.getHand().bust()) {
			System.out.println("♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠  " 
					         + "\n          (1) H I T            "
					         + "\n         (2) S T A Y           " 
					         + "\n♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ");
			int choice = sc.nextInt();
			sc.nextLine();

			if (choice == 1) {
				player.addCardToHand(dealer.getDeck().dealCard());
				if (player.getHand().bust()) {
					System.out.println("Y O U  B U S T E D");
					winner(player, dealer);
					break;
				}
				if (player.getHand().blackjack()) {
					System.out.println("B L A C K J A C K"
									  +"  Y O U   W I N  " );
					
					winner(player, dealer);
					break;
				}
				player.viewHand(player);
				dealer.revealTopCard(dealer);
			}

			if (choice == 2) {
				dealerPlay(dealer);
				winner(player, dealer);
				break;

			}
		}

	}

	public static void dealerPlay(Dealer dealer) {
		int dealerHandValue = 0;
		boolean dealerPlay = true;
		while (dealerPlay) {
			if (dealerHandValue < 17) {
				dealer.addCardToHand(dealer.getDeck().dealCard());
				dealerHandValue = dealer.getHand().handValue();
				System.out.println("___________________________________"
						          +"\n D E A L E R  H I T S");
				dealer.viewHand(dealer);
				// dealer.viewDealerHand( dealer );
			}

			if (dealerHandValue > 21) {
				dealerPlay = false;
				break;
			}
			if (dealerHandValue == 21) {
				dealerPlay = false;
				break;
			}
		}
	}

	public static void winner(Player player, Dealer dealer) {

		if (player.getHand().blackjack()) {
			System.out.println("♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ "
		                       +"\n  "+player.getName()+" W I N "
		                       +"\n♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ");
			finalHands(player, dealer);
			playAgain(player, dealer);
		} else if (player.getHand().bust()) {
			System.out.println("___________________________________"
					           +"\n   D E A L E R  W I N "
					           +"\n___________________________________");
			finalHands(player, dealer);
			playAgain(player, dealer);
		} else if (dealer.getHand().bust()) {
			System.out.println("♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ "
					           +"\n  D E A L E R  B U S T " 
					           +"\n\t "+player.getName()+" W I N "
				               +"\n♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ");
			finalHands(player, dealer);
			playAgain(player, dealer);
		} else if (player.getHand().handValue() > dealer.getHand().handValue()) {
			System.out.println("♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ "
                              +"\n\t  "+player.getName()+" W I N "
                              +"\n♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ♣ ♦ ♥ ♠ ");
			finalHands(player, dealer);
			playAgain(player, dealer);
		} else if (player.getHand().handValue() < dealer.getHand().handValue()) {
			System.out.println("___________________________________"
			                  +"\n   D E A L E R  W I N "
			                  +"\n___________________________________");
			finalHands(player, dealer);
			playAgain(player, dealer);
		} else {
			System.out.println("___________________________________"
	                  		  +"\n           T I E "
	                          +"\n___________________________________");
			finalHands(player, dealer);
			playAgain(player, dealer);
		}
	}
	
	public static void finalHands(Player player, Dealer dealer) {		
		System.out.println("F I N A L  H A N D S :");
		player.viewHand(player);
		dealer.viewHand(dealer);
	}

	public static void playAgain(Player player, Dealer dealer) {
		System.out.println("\n  P L A Y  A G A I N ?");
		String playAgain = sc.next();
		sc.nextLine();
		if (playAgain.equalsIgnoreCase("Y") || playAgain.equalsIgnoreCase("yes")) {
			player.clearHand();
			dealer.clearHand();
			dealHands(player, dealer);
			playBlackJack(player, dealer);
			dealerPlay(dealer);
			winner(player, dealer);
			playAgain(player, dealer);
		} else if (playAgain.equalsIgnoreCase("N") || playAgain.equalsIgnoreCase("no")) {
			quit();
		} else {
			System.err.println("Invalid input. Please enter yes, no, Y, or N.");
			playAgain(player, dealer);
		}
	}

	public static void quit() {
		System.out.println("T H A N K S  F O R  P L A Y I N G ! "
				  	      +"\n  	   B L A C K  J A C K"
                          +"\n	       ___   ___ "
                          +"\n	      |A  | |10 |" 
                          +"\n	      | ♣ | | ♦ |" 
                          +"\n  	  |__A| |_10|" );
	}
	
}
	
