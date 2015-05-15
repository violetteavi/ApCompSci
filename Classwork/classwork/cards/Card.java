package cards;

public class Card {

	private String rank;
	private String suit;
	private int pointValue;
	
	public Card(String rank, String suit, int pointValue) {
		this.rank = rank;
		this.suit = suit;
		this.setPointValue(pointValue);
	}
	
	@Override
	public String toString() {
		return rank + " of " + suit + " (point value = " + pointValue + ")";
	}
	
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}

	public void setPointValue(int pointValue) {
		this.pointValue = pointValue;
	}

	public int getPointValue() {
		return pointValue;
	}
}
