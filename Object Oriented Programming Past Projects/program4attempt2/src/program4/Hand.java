package program4;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * <p>
 * Title: The Hand Class
 * </p>
 * 
 * <p>
 * Description: Defines the properties and behaviors of a GoFish Hand.
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * 
 * @author F. Graham
 */
public class Hand{
	/**
	 * LinkList of GoFish Cards
	 */
	private LinkedList<GoFishCard> hand;
	/**
	 * Default constructor
	 */
	public Hand(){
		hand = new LinkedList<GoFishCard>();
	}
	/**
	 * Returns the number of cards in the hand
	 * @return the number of cards in the hand
	 */
	public int getCount(){
		return hand.size();
	}
	/**
	 * Returns the hand as LinkedList of GoFish cards
	 * @return the hand as a LinkedList of GoFish Cards
	 */
	public LinkedList<GoFishCard> getHand() {
		return hand;
	}	
	/**
	 * Returns <i>true</i> if this rank is the hand
	 * @param rank - the rank to search for
	 * @return Returns <i>true</i> if this rank is the hand,<br> 
	 * <i>false</i> otherwise
	 */
//	public boolean hasRank(int rank) {
//		
//	}
	/**
	 * Returns a string representation of the hand
	 */
	public String toString(){
		String str = "";
		
		System.out.println(getCount());
		for(int i = 0; i < hand.size(); i++) {
			str += hand.get(i);
		}
		
		return str;
	}
	/**
	 * Finds and returns all cards of the specified rank
	 * @param rank - the rank to search for
	 * @return all of the cards of that rank as a LinkedList of GoFish Cards
	 */
//	public LinkedList<GoFishCard> findRank(int rank){
//		
//	}
	/**
	 * Adds a Card to the hand, the hand is sorted by rank
	 * @param card - a GoFish Card
	 */
	public void insertByRank(GoFishCard card){
		hand.add(card);
		
	}
	/**
	 * Adds a LinkList of Cards to the hand, the hand is sorted by rank
	 * @param otherHand LinkedList of GoFish Cards
	 */
	public void insertHand(LinkedList<GoFishCard> otherHand) {
		for(int i = 0; i < otherHand.size(); i++) {
			hand.add(otherHand.get(i));
		}
	}
	/**
	 * Determines if the hand is empty
	 * @return - Returns <i>true</i> if the hand is empty, <i>false</i> otherwise
	 */
	public boolean isEmpty() {
		return hand.size() == 0;
	}
	/**
	 * Returns 1 if a book (all 4 cards of a particular suit) is 
	 * in the hand and removes the book from the hand
	 * @return the number of books (all 4 cards of a particular suit) in the hand
	 */
	public int evaluate() {
		for(int i = 0; i < hand.size(); i++) {
			String temp = hand.get(i).getRankAsString();
			int counter = 0;
			
			for(int x = 0; x < i; x++) {
				if(temp.equals(hand.get(x).getRankAsString())) {
					counter++;
				}
			}
			for(int y = 0; y < hand.size(); y++) {
				if(temp.equals(hand.get(y).getRankAsString())) {
					counter++;
				}
			}
			
			if(counter == 4) {
				return 1;
			}
		}
		
		return 0;
		
	}
	/**
	 * Counts the number of cards of a particular rank in the hand
	 * @param rank - the rank to count
	 * @return the number of cards of that rank
	 */
//	public int countRank(int rank){
//	}
	/**
	 * Returns the card at the specified position in this list.
	 * @param index the index of the list
	 * @return
	 */
	public GoFishCard getCardAt(int index){
		return hand.get(index);
	}
	/**
	 * Returns a list of cards of a specified rank
	 * @param rank - the rank to search for 
	 * @return the cards as LinkedList of GoFish Cards
	 */
	public LinkedList<GoFishCard> getCards(String rank) {
		LinkedList<GoFishCard> result = new LinkedList<GoFishCard>();
		
		for(int i = 0; i < hand.size(); i++) {
			if(hand.get(i).getRankAsString().equals(rank)) {
				result.add(hand.get(i));
			}
		}
		
		return result;
	}
	/**
	 * <p>removeCards</p>
	 * 
	 * Removes a card of a certain rank
	 * 
	 * @param rank the rank of cards to remove
	 */
	public void removeCards(String rank) {
		for(int i = 0; i < hand.size(); i++) {
			if(hand.get(i).getRankAsString().equals(rank)) {
				hand.remove(i);
			}
		}
	}
}