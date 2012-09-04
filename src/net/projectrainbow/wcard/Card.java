package net.projectrainbow.wcard;

/**
 * Card.java
 * @author Whackatre
 * 
 */

public class Card {
	
	private final Suit suit;
	private final int number;
	
	public static final int RANGE = 13;
	
	/**
	 * An enum representing the
	 * suit of the card.
	 */
	public enum Suit {
		DIAMONDS, CLUBS, HEARTS, SPADES
	}
	
	/**
	 * The constructor used when
	 * instantiating this Card class.
	 * 
	 * @param suit
	 * @param number
	 */
	public Card(Suit suit, int number) {
		if (suit == null)
			throw new java.lang.NullPointerException("Card suit has a null value!");
		if (number == 0 || number > RANGE)
			throw new java.lang.IllegalArgumentException("Card number (" + number + ") is out of range!");
		this.suit = suit;
		this.number = number;
	}
	
	/**
	 * Returns the card suit.
	 * @return
	 */
	public Suit getSuit() {
		return suit;
	}
	
	/**
	 * Returns the card number.
	 * @return
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * Returns true if the card
	 * is a Jack, Queen, King, or Ace.
	 * @return
	 */
	public boolean isFaceCard() {
		return (number >= 11 && number <= 13) || (number == 1);
	}
	
	/**
	 * Gets the face name of the card.
	 * @return
	 */
	public String getFaceName() {
		switch (number) {
		case 11:
			return "J";
		case 12:
			return "Q";
		case 13:
			return "K";
		case 1:
			return "A";
		default:
			return "NOT_A_FACE_CARD";
		}
	}
	
	/**
	 * Gets the card symbol.
	 * Use with caution because there is no
	 * guarantee of a correct display.
	 * @return
	 */
	public String getSuitName() {
		switch (suit) {
		case HEARTS:
			return "\u2661";
		case DIAMONDS:
			return "\u2662";
		case CLUBS:
			return "\u2663";
		case SPADES:
			return "\u2660";
		default:
			return suit.name();
		}
	}
	
	@Override
	public String toString() {
		return "[" + ((isFaceCard() ? getFaceName() : number) + getSuitName() + "]");
	}

}
