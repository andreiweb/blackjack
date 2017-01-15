package cards;
import java.util.ArrayList;
import java.util.List;

import util.PacketShuffeler;

public class Packet {

	private List<Card> cards;

	public Packet() {
		createPacket();
	}
	
	public Card getNextCard() {
		if (cards.size() > 0) {
			Card nextCard = cards.get(0);
			cards.remove(nextCard);
			return nextCard;
		}
		return null; // return null if no more cards in the pack
	}
	
	public List<Card> getCards() {
		return cards;
	}

	public void shuffle() {
		PacketShuffeler.shuffle(cards);
	}

	private void createPacket() {
		cards = new ArrayList<Card>();
		
		for (CardType cardType : CardType.values()) {
			for (CardColor cardColor : CardColor.values()) {
				cards.add(new Card(cardType, cardColor));
			}
		}
		
	}
	
}
