package cards;
public class Card {
	private CardType cardType;
	private CardColor cardColor;
	private int points;

	public Card(CardType cardType, CardColor cardColor) {
		this.cardType = cardType;
		this.cardColor = cardColor;
		this.points = cardType.getPoints(); //get default points from card type. This was added for ases double values (1/11)
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}

	public CardColor getCardColor() {
		return cardColor;
	}

	public CardType getCardType() {
		return cardType;
	}

	@Override
	public String toString() {
		return cardType.getName() + " " + cardColor.name();
	}
}
