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
		System.out.println("Let the game begin....");
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = in.nextLine();
		player[0] = new Player(name);
		player[1] = new Player("Computer");
		
		System.out.println("Game starting in cheat mode");
		
		dealCards();
		
		int turn = 1;
		int rank = 0;
		boolean hasCard = false;
		boolean exists = false;
		
		while(!(deck.isEmpty())) {
			System.out.println("**********");
			
			if(turn % 2 == 0) {
				System.out.println(name);
				displayHands(turn % 2);
				System.out.print("Computer, do you have any: ");
				
				while(exists == false) {
					rank = in.nextInt();
					for(int i = 0; i < player[0].getTotalCards(); i++) {
						if(player[0].getCardAt(i).getRank() == rank) {
							exists = true;
						}
					}
				}
				for(int i = 0; i < player[1].getTotalCards(); i++) {
					if(player[1].getCardAt(i).getRank() == rank) {
						
					}
				}
			}
			
			turn++;
		}
		
		displayHands(1);
	}
	public void getNames() {
		
	}
	public void dealCards() {
		deck.shuffle();
		
		for(int i = 0; i < 7; i++) {
			player[0].addCard(deck.deal());
			player[1].addCard(deck.deal());
		}
	}
	public void displayHands(int playerNum) {
		System.out.println(player[playerNum].showHand());
	}
	public int getRank(Player p) {
		return 0;
	}
	public static void gameResults() {
		
	}
}
