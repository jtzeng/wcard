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
	 * @param c
	 * @return
	 */
	public boolean addCard(Card c) {
		if (c == null)
			throw new NullPointerException("Card is null!");
		if (cards.size() < maximumSize) {
			cards.add(c);
			return true;
		}
		return false;
	}
	
	/**
	 * Removes a card.
	 * @param c
	 */
	public void removeCard(Card c) {
		cards.remove(c);
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
		String output = ""; //HAND:\n";
		for (Card c : cards) {
			output = output + c + " ";
		}
		return output;
	}

}
