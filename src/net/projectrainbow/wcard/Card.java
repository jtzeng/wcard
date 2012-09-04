package net.projectrainbow.wcard;

/**
 * Card.java
 * @author Whackatre
 * 
 */

public class Card {
	
	private final Suit suit;
	private final int number;
	
	/**
	 * Card unicode code constants.
	 */
	private static final String UNICODE_HEARTS = "\u2661";
	private static final String UNICODE_DIAMONDS = "\u2662";
	private static final String UNICODE_CLUBS = "\u2663";
	private static final String UNICODE_SPADES = "\u2660";
	
	/**
	 * Face card number constants.
	 */
	public static final int ACE_NUM = 1;
	public static final int JACK_NUM = 11;
	public static final int QUEEN_NUM = 12;
	public static final int KING_NUM = 13;
	
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
			throw new IllegalArgumentException("Card suit has a null value!");
		if (number < 1 || number > RANGE)
			throw new IllegalArgumentException("Card number (" + number + ") is out of range!");
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
		return (number >= JACK_NUM && number <= KING_NUM) || (number == ACE_NUM);
	}
	
	/**
	 * Gets the face name of the card.
	 * @return
	 */
	public String getFaceName() {
		switch (number) {
		case JACK_NUM:
			return "J";
		case QUEEN_NUM:
			return "Q";
		case KING_NUM:
			return "K";
		case ACE_NUM:
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
			return UNICODE_HEARTS;
		case DIAMONDS:
			return UNICODE_DIAMONDS;
		case CLUBS:
			return UNICODE_CLUBS;
		case SPADES:
			return UNICODE_SPADES;
		default:
			return suit.name();
		}
	}
	
	@Override
	public String toString() {
		return "[" + ((isFaceCard() ? getFaceName() : number) + getSuitName() + "]");
	}

}
