package net.projectrainbow.wcard;

/**
 * CardDemo.java
 * @author Whackatre
 *
 */

public class CardDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();
		//System.out.println(deck);
		
		Hand hand = new Hand(5);
		
		for (int i = 0; i < 5; i++) {
			hand.addCard(deck.popCard());
		}
		System.out.println(hand);
	}

}
