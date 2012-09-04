package net.projectrainbow.wcard;

import java.util.ArrayList;
import java.util.List;

/**
 * Hand.java
 * @author Whackatre
 *
 */

public class Hand {
	
	public int maximumSize;
	private List<Card> cards = new ArrayList<Card>();
	
	/**
	 * @param maximumSize
	 */
	public Hand(int maximumSize) {
		this.maximumSize = maximumSize;
	}
	
	/**
	 * Adds a card.
	 * Returns false if it is not possible.
	 * @param c
	 * @return
	 */
	public boolean addCard(Card c) {
		if (c == null)
			return false;
		if (cards.size() < maximumSize) {
			return cards.add(c);
		}
		return false;
	}
	
	/**
	 * Removes a card.
	 * @param c
	 * @return
	 */
	public boolean removeCard(Card c) {
		return cards.remove(c);
	}
	
	/**
	 * Clears the hand.
	 */
	public void clearCards() {
		cards.clear();
	}
	
	/**
	 * Returns the amount of cards in the deck.
	 * @return
	 */
	public int countCards() {
		return cards.size();
	}
	
	/**
	 * Does the player have a particular number in hand?
	 * @param number
	 * @return
	 */
	public boolean hasCard(int number) {
		for (Card.Suit suit : Card.Suit.values()) {
			if (cards.contains(new Card(suit, number))) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets the cards as an ArrayList.
	 * @return
	 */
	public List<Card> getCards() {
		return cards;
	}
	
	@Override
	public String toString() {
		String output = "";
		for (Card c : cards) {
			output = output + c + " ";
		}
		return output;
	}

}
