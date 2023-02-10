package program4;

import java.util.Scanner;
/**
 * <p>
 * Title: The GoFish Class
 * </p>
 *  
 * <p>
 * Description: Defines the properties and behaviors of a GoFish game.
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * 
 * @author F. Graham
 */
public class GoFish {
	private Deck deck = new Deck();
	private Player[] player = new Player[2];
	
	public void playGame(){
		System.out.println("Let the game begin.... \n");
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = in.nextLine();
		player[0] = new Player(name);
		player[1] = new Player("Computer");
		System.out.println("Game starting in cheat mode");
		
		dealCards();
		
		int turn = 0;
		String rank = "";
		int player0points = 0;
		int player1points = 0;
		
		while(!(deck.isEmpty()) || player[0].getTotalCards() == 0 || player[1].getTotalCards() == 0) {
			System.out.println();
			System.out.println("********************************");
			System.out.println("Number of cards left in deck " + deck.deckSize());
			System.out.println("********************************");
			System.out.println();
			boolean exists = false;
			boolean hasCard = false;
			
			if(turn == 0) {
				System.out.println(name + " [Books: " + player0points + "]");
				displayHands(0);
				
				while(exists == false) {
					System.out.print("Computer, do you have any: ");
					rank = in.nextLine();
					
					for(int i = 0; i < player[0].getTotalCards(); i++) {
						if(rank.equals(player[0].getCardAt(i).getRankAsString())) {
							exists = true;
							break;
						}
					}
				}
				
				for(int i = 0; i < player[1].getTotalCards(); i++) {
					if(rank.equals(player[1].getCardAt(i).getRankAsString())) {
						hasCard = true;
					}
				}
				
				if(hasCard == true) {
					System.out.println("Computer says \"Yes!!\"");
					player[0].addCards(player[1].getCards(rank));
					player[1].removeCards(rank);
				}
				else {
					System.out.println("Computer says \"No, Go Fish!!\"");
					Card card0 = deck.deal();
					player[0].addCard(new GoFishCard(card0.getRank(), card0.getSuit()));
				}
				
				for(int i = 0; i < player[0].getTotalCards(); i++) {
					if(player[0].evaluate(player[0].getCardAt(i).getRankAsString())) {
						System.out.println("Book: [" +
								player[0].getCardAt(i).getRankAsString() + "C, " +
								player[0].getCardAt(i).getRankAsString() + "D, " +
								player[0].getCardAt(i).getRankAsString() + "H, " +
								player[0].getCardAt(i).getRankAsString() + "S]");
						player0points++;
						player[0].removeCards(player[0].getCardAt(i).getRankAsString());
						break;
					}
				}
				
				System.out.println(name + " [Books: " + player0points + "]");
				displayHands(0);
				
				turn++;
			}
			else if(turn == 1) {
				System.out.println("Computer" + " [Books: " + player1points + "]");
				displayHands(1);
				
				while(exists == false) {
					System.out.print(name + ", do you have any: ");
					rank = in.nextLine();
					
					for(int i = 0; i < player[1].getTotalCards(); i++) {
						if(rank.equals(player[1].getCardAt(i).getRankAsString())) {
							exists = true;
							break;
						}
					}
				}
				
				for(int i = 0; i < player[0].getTotalCards(); i++) {
					if(rank.equals(player[0].getCardAt(i).getRankAsString())) {
						hasCard = true;
					}
				}
				
				if(hasCard == true) {
					System.out.println(name + " says \"Yes!!\"");
					player[1].addCards(player[0].getCards(rank));
					player[0].removeCards(rank);
				}
				else {
					System.out.println(name + " says \"No, Go Fish!!\"");
					Card card0 = deck.deal();
					player[1].addCard(new GoFishCard(card0.getRank(), card0.getSuit()));
				}
				
				for(int i = 0; i < player[1].getTotalCards(); i++) {
					if(player[1].evaluate(player[1].getCardAt(i).getRankAsString())) {
						System.out.println("Book: [" +
								player[1].getCardAt(i).getRankAsString() + "C, " +
								player[1].getCardAt(i).getRankAsString() + "D, " +
								player[1].getCardAt(i).getRankAsString() + "H, " +
								player[1].getCardAt(i).getRankAsString() + "S]");
						player1points++;
						player[1].removeCards(player[1].getCardAt(i).getRankAsString());
						break;
					}
				}
				
				System.out.println("Computer" + " [Books: " + player1points + "]");
				displayHands(1);
				
				turn--;
			}
		}
		
		System.out.println();
		if(player0points > player1points){
			System.out.println(name + " is the Winner...");
		}
		else {
			System.out.println("Computer is the Winner...");
		}
	}
	public void getNames() {
		
	}
	/**
	 * deals 7 cards to each player
	 */
	public void dealCards() {
		deck.shuffle();
		
		for(int i = 0; i < 7; i++) {
			Card card0 = deck.deal();
			player[0].addCard(new GoFishCard(card0.getRank(), card0.getSuit()));
			
			Card card1 = deck.deal();
			player[1].addCard(new GoFishCard(card1.getRank(), card1.getSuit()));
		}
	}
	/**
	 * Shows the cards in a players hand
	 * 
	 * @param playerNum which player to show
	 */
	public void displayHands(int playerNum) {
		System.out.println(player[playerNum].showHand());
	}
	public int getRank(Player p) {
		return 0;
	}
	public static void gameResults() {
		
	}
}
