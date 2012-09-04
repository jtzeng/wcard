package net.projectrainbow.blackjack;

/**
 * Main.java
 * @author Whackatre
 *
 */

public final class Main {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Loops the game forever.
		 */
		while (true) {
			System.out.println("Starting new game of Blackjack..");
			new BlackJack().play();
		}
	}

}
