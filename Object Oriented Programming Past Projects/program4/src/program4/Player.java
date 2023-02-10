package program4;

import java.util.LinkedList;
/**
 * <p>
 * Title: The Player Class
 * </p>
 * 
 * <p>
 * Description: Defines the properties and behaviors of a GoFish Player.
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * 
 * @author F. Graham
 */
public class Player {
	private String name;
	private Hand hand = new Hand();
	private int points;
	/**
	 * Parameterized constructor
	 * @param n - the name of the player
	 */
	public Player(String n){
		name = n;
	}
	/**
	 * Returns the player's name
	 * @return - the player's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name
	 * @param name - the new value for name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Returns all of the cards of the specified rank as a LinkedList
	 * @param rank - the rank to search for
	 * @return - the cards of the specified rank as a LinkedList
	 */
	public LinkedList<GoFishCard> getCards(int rank) {
	}
	/**
	 * Sets the hand
	 * @param hand
	 */
	public void setHand(Hand hand){
	}
	/**
	 * Returns the number of books the player has
	 * @return the number of books the player has
	 */
	public int getPoints() {
		return points;
	}
	/**
	 * Returns the string representation of the player
	 * @return the string representation of the player
	 */
	public String toString(){
	}
	/**
	 * Returns the string representation of the hand
	 * @return the string representation of the hand 
	 */
	public String showHand() {
		String str = "";
		
		for(int i = 0; i < hand.getCount(); i++) {
			str += hand.getHand().get(i) + " ";
		}
		
		return str;
	}
	/**
	 * Returns <i>true</> if the player has a specified rank
	 * @param rank - the rank to search for
	 * @return - Returns <i>true</> if the player has a specified rank, <i>false</> otherwise
	 */
	public boolean hasRank(int rank){
	}
	/**
	 * Adds a card to the hand
	 * @param card - the card to add
	 */
	public void addCard(Card card){
		hand.add(card);
	}
	/**
	 * Adds a LinkList of Cards to the hand
	 * @param otherHand - the LinkedList of cards
	 */
	public void addCards(LinkedList<GoFishCard> otherHand) {
	}
	/**
	 * returns the card at a specified index in the hand
	 * @param index - the position of the card
	 * @return - the card at that position
	 */
	public GoFishCard getCardAt(int index){
	}
	 /**
	  * Returns the number of cards the player has
	  * @return Return the number of cards the player has
	  */
	public int getTotalCards() {
		return hand.getCount();
	}
	/**
	 * Returns the cards of a specified rank as a Linkedlist
	 * @param rank - the rank to search for
	 * @return - the Linked List of cards
	 */
	public LinkedList<GoFishCard> getCard(int rank){
	}
}