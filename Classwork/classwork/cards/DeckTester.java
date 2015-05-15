package cards;

import static org.junit.Assert.*;

public class DeckTester {

	public static void main(String[] args) {
		String[] ranks = {"A", "B", "C"};
		String[] suits = {"Giraffes", "Elephants", "Lions"};
		int[] pointValues = {2, 1, 6};
		Deck test = new Deck(ranks, suits, pointValues);
		Deck testNull = new Deck(null, null, null);
		assertFalse(test.isEmpty());
		assertTrue(testNull.isEmpty());
		assertEquals(27, test.size());
		assertEquals(0, testNull.size());
		assertEquals(6, test.deal().getPointValue());
		assertEquals(1, test.deal().getPointValue());
		assertTrue(testNull.deal()==null);
	}
}
