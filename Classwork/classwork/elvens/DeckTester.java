package elvens;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {
	
	public static void main(String[] args) {
		String[] ranks = {"A", "B", "C"};
		String[] suits = {"Giraffes", "Lions"};
		int[] pointValues = {2, 1, 6};
		Deck d = new Deck(ranks, suits, pointValues);
//		System.out.println(d);
		d.shuffle();
		System.out.println(d);
	}
}

