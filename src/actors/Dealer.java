package actors;

import cards.Card;
import cards.Packet;

public class Dealer extends Player {
	
	private Packet packet;
	
	public Dealer() {
		super();
	}
	
	public void getNewPacket() {
		packet = new Packet();
	}
	
	public void shuffleCards() {
		packet.shuffle();
	}
	
	public Packet getPacket() {
		return packet;
	}
	
	public Card showFirstCard() {
		return getCards().get(0);
	}
	
	public Card showHiddenCard() {
		return getCards().get(1);
	}
	
	/*
	 * Deal number of cards to player
	 */
	public void dealCards(Player player, int numberOfCards) {
		
		for (int i = 0; i < numberOfCards; i++) {
		Card nextCard = packet.getNextCard();
			if (nextCard!=null) {
				player.addCard(nextCard);
			}
		}
		
	}
	
}