package net.projectrainbow.wcard;

import net.projectrainbow.util.Utils;

/**
 * Blackjack.java
 * @author Whackatre
 *
 */

public final class Blackjack {
	
	/**
	 * The default amount of cards.
	 */
	private static final int CARDS = 2;
	
	/**
	 * The maximum cards a player is allowed to have.
	 */
	private static final int MAX_CARDS = 8;
	
	/**
	 * The maximum score a player can have.
	 * If the score is greater than this amount,
	 * a bust is called.
	 */
	private static final int BLACK_JACK = 21;
	
	private Deck deck;
	
	private static Blackjack blackJack;
	
	private static int playerWins = 0;
	private static int enemyWins = 0;
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		while (true) {
			System.out.println("Starting new game of Blackjack..");
			blackJack = new Blackjack();
			blackJack.play();
		}
	}
	
	/**
	 * Plays the game.
	 */
	private void play() {
		/*
		 * Instantiate a deck and shuffle it.
		 */
		if (deck == null) {
			deck = new Deck();
			deck.initialize();
		}
		//System.out.println("Deck Count: " + deck.countCards());
		deck.shuffle();
		
		/*
		 * Creating each player's hand.
		 */
		Hand dealer = new Hand(MAX_CARDS);
		Hand player = new Hand(MAX_CARDS);
		
		for (int i = 0; i < CARDS; i++) {
			dealer.addCard(deck.popCard());
			player.addCard(deck.popCard());
		}
		
		/*
		 * The main game loop.
		 */
		while (true) {
			System.out.println("Dealer's Hand: " + dealer);
			System.out.println("Your Hand:     " + player);
			/*
			 * Bust check.
			 */
			if (hasBusted(dealer)) {
				System.out.println("You win (the dealer has busted)!");
				playerWin();
				return;
			}
			if (hasBusted(player)) {
				System.out.println("You lost (you have busted).");
				enemyWin();
				return;
			}
			String action = Utils.input("Enter an action (hit, stand): ").toLowerCase().trim();
			if (action.equals("stand")) {
				int score = getPlayerPoints(player);
				int dealerScore = getPlayerPoints(dealer);
				//System.out.println("Dealer's Score: " + dealerScore);
				//System.out.println("Your Score:     " + score);
				if (!shouldDealerHit(dealer)) {
					if (score > 21) {
						System.out.println("You lost (you busted).");
						enemyWin();
						return;
					} else {
						if (dealerScore == score) {
							if (player.countCards() < dealer.countCards()) {
								System.out.println("You won (you have less cards)!");
								playerWin();
							} else if (player.countCards() > dealer.countCards()) {
								System.out.println("You lost (you have more cards)!");
								enemyWin();
							} else {
								System.out.println("You tied.");
							}
							return;
						} else {
							if (score > dealerScore) {
								System.out.println("You won (higher points)!");
								playerWin();
								return;
							} else {
								System.out.println("You lost (lower points).");
								enemyWin();
								return;
							}
						}
					}
				}
			} else if (action.equals("hit")) {
				player.addCard(deck.popCard());
			} else if (action.equals("score") || action.equals("wins")) {
				System.out.println("Enemy Wins: " + enemyWins);
				System.out.println("Your Wins: " + playerWins);
			}
			if (shouldDealerHit(dealer)) {
				dealer.addCard(deck.popCard());
			}
		}
	}
	
	/**
	 * Gets the player's point count.
	 * @param hand
	 * @return
	 */
	private int getPlayerPoints(Hand hand) {
		int score = 0;
		for (Card card : hand.getCards()) {
			if (card.getNumber() == 1) {
				score += 11;
				continue;
			}
			if (card.getNumber() >= 11 && card.getNumber() <= 13) {
				score += 10;
				continue;
			}
			score += card.getNumber();
		}
		/*
		 * Aces can count as one, too..
		 */
		for (Card card : hand.getCards()) {
			if (score <= BLACK_JACK) {
				break;
			}
			if (card.getNumber() == 1) {
				score -= 10;
			}
		}
		return score;
	}
	
	/**
	 * Checks if the player busted.
	 * @param hand
	 * @return
	 */
	private boolean hasBusted(Hand hand) {
		return getPlayerPoints(hand) > BLACK_JACK;
	}
	
	/**
	 * Should the dealer hit?
	 * @param dealer
	 * @return
	 */
	private boolean shouldDealerHit(Hand dealer) {
		return !(getPlayerPoints(dealer) >= 17);
	}
	
	private void playerWin() {
		playerWins++;
	}
	
	private void enemyWin() {
		enemyWins++;
	}

}
