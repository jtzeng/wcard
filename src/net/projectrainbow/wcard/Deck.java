package net.projectrainbow.wcard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Deck.java
 * @author Whackatre
 * 
 */

import net.projectrainbow.wcard.Card.Suit;

public class Deck {
	
	public static final int SIZE = 52;
	private List<Card> cards = new ArrayList<Card>();
	
	/**
	 * The constructor which automatically
	 * initializes (but does not shuffle)
	 * the deck.
	 */
	public Deck() {
		initialize();
	}
	
	/**
	 * Initializes a deck.
	 */
	private void initialize() {
		cards.clear();
		for (int i = 1; i <= Card.RANGE; i++) {
			for (Suit s : Card.Suit.values()) {
				cards.add(new Card(s, i));
			}
		}
	}
	
	/**
	 * Resets the deck to its initial state.
	 * 
	 * Basically a public method to the
	 * above method initialize().
	 */
	public void reset() {
		initialize();
	}
	
	/**
	 * Shuffles the deck.
	 * It MUST be previously initialized!
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	/**
	 * Adds a card.
	 * @param c
	 */
	public boolean addCard(Card c) {
		return cards.add(c);
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
	 * Pops (removes) a card
	 * and then removes it from the deck.
	 * 
	 * Returns null if it is empty.
	 * @return
	 */
	public Card popCard() {
		if (cards.size() != 0) {
			Card c = cards.get(0);
			cards.remove(c);
			return c;
		}
		return null;
	}
	
	/**
	 * Returns the amount of cards in the deck.
	 * @return
	 */
	public int countCards() {
		return cards.size();
	}
	
	@Override
	public String toString() {
		String output = "DECK\n";
		for (Card c : cards) {
			output += output + c + " ";
		}
		return output;
	}

}
