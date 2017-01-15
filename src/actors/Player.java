package actors;
import java.util.ArrayList;
import java.util.List;

import cards.Card;

public class Player {
	
	private List<Card> cards;
	
	public Player() {
		cards = new ArrayList<Card>();
	}
	
	public int getScore() {
		int total = 0;
		for (Card card : cards) {
			total+=card.getPoints();
		}
		
		return total;
	}

	public Card showLastCard() {
		return getCards().get(getCards().size()-1);
	}
	
	public List<Card> getCards() {
		return cards;
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public boolean checkIfPlayerHasBlackjack(Player player) {
		return player.getScore()==21;
	}
	
	public boolean checkIfPlayerHasLost(Player player) {
		return player.getScore()>21;
	}
	
}
