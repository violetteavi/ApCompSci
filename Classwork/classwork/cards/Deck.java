package cards;

import java.util.LinkedList;
import java.util.List;

public class Deck {

	private List<Card> cards;
	private int size = 0;
	
	public Deck(String[] ranks, String[] suits, int[] pointValues) {
		cards = new LinkedList<Card>();
		if(ranks!=null&&suits!=null&&pointValues!=null) {
			for(int i = 0; i < ranks.length; i++) {
				for(int j = 0; j < suits.length; j++) {
					for(int k = 0; k < pointValues.length; k++) {
						cards.add(new Card(ranks[i], suits[j], pointValues[k]));
						size++;
					}
				}
			}
		}
	}
	
	public boolean isEmpty() {
		return cards.size()==0;
	}
	
	public int size() {
		return size ;
	}
	
	public Card deal() {
		if(size()!=0) {
			size--;
			return cards.get(size);
		}
		return null;
	}
}
