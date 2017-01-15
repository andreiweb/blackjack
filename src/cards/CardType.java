package cards;
public enum CardType {

	_2("2", 2), 
	_3("3", 3), 
	_4("4", 4), 
	_5("5", 5), 
	_6("6", 6),
	_7("7", 7), 
	_8("8", 8), 
	_9("9", 9), 
	_10("10", 10), 
	  J("J", 10), 
	  Q("Q", 10), 
	  K("K", 10), 
	  A("A", 11);//actually ace value can be 1 or 11 - the decision is on the player at runtime

	private String name;
	private int points;

	private CardType(String name, int points) {
		this.name = name;
		this.points = points;
	}

	public int getPoints() {
		return points;
	}
	
	String getName() {
		return name;
	}
}
