import java.util.Scanner;

import actors.Dealer;
import actors.Player;
import cards.CardType;

import static java.lang.System.out;

public class ConsoleGame {

	Dealer dealer;
	Player player;

	public static void main(String[] args) {
		ConsoleGame blackjack = new ConsoleGame();
		blackjack.startGame();
	}

	private void startGame() {

		dealer = new Dealer();
		player = new Player();

		/* dealer pick a packet, shuffle it, then deal 2 cards to each player */
		dealer.getNewPacket();
		dealer.shuffleCards();
		out.println("Initial draw");
		
		dealer.dealCards(dealer, 2);
		dealer.dealCards(player, 2);

		play();

	}

	private void play() {
		int playerScore = player.getScore();

		if (playerScore == 21) {// blackjack

			out.println("Player's cards: " + player.getCards() + "; score:" + player.getScore());

			out.println("Dealer's cards: " + dealer.getCards());

			out.println("Player has Blackjack!");

			out.println(dealer.checkIfPlayerHasBlackjack(dealer) ? "Dealer has also Blackjack! The game finishes equal!" : "Player WINS!!!");
			
			playAgain();
		
		} else if (playerScore > 21) {// player has lost
			
			out.println("Player score is "+playerScore+". Dealer WINS!!!");
			playAgain();
			
		} else {

			out.println("Dealer's cards: [" + dealer.getCards().get(0) + ", hidden]");

			out.println("Player's cards: " + player.getCards() + "; score:" + player.getScore());

			String input = null;

			while (input == null || (!input.equals("N") && !input.equals("Y"))) {
				out.println("Do you want to draw another card? (Y/N)");
				input = getInputFromUser();
			}

			if (input.equals("Y")) {
			
				dealer.dealCards(player, 1);
				out.println("Do you want to draw another card? (Y/N)");
				
				out.println("Player Draw: " + player.showLastCard());
				
				if (player.showLastCard().getCardType() == CardType.A) {
					out.println("Do you want to use ACE card as 1 or as 11? (1/11)");
					Scanner inputScanner = new Scanner(System.in);
					int points = inputScanner.nextInt();
					if (points == 1) {
						player.showLastCard().setPoints(points);
					}
				}
				
				play();

			} else {// N: user chose to stop 
				
				out.println("Dealer Hidden Card Was:" + dealer.showHiddenCard() + ". Dealer hand is " + dealer.getScore());
				
				while (dealer.getScore() < 17) {
					dealer.dealCards(dealer, 1);
					out.println("Dealer draw another hand. Dealer draw: " + dealer.showLastCard() + ". Dealer hand is " + dealer.getScore());
				}

				out.println("Dealer stops");

				out.println("Player Hand values " + player.getScore() + ", Dealer Hand values " + dealer.getScore());

				if (player.getScore() > dealer.getScore() || dealer.getScore() > 21) {
					out.println("Player WINS!!!");
				} else if (player.getScore() == dealer.getScore()) {
					out.println("The game finishes equal!");
				} else {
					out.println("Dealer WINS!!!");
				}
				
				playAgain();
			}

		}
	}
	
	private void playAgain() {
		out.println("Do you want to play again? Y/N");
		if (getInputFromUser().equals("Y")) {
			startGame();
		}
	}

	private String getInputFromUser() {
		Scanner inputScanner = new Scanner(System.in);
		String input = inputScanner.next();

		return input;
	}

}
