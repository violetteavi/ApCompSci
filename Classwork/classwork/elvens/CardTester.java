package elvens;

import static org.junit.Assert.*;
/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	public static void main(String[] args) {
		Card card = new Card("Queen", "Clubs", 12);
		assertTrue("Queen".equals(card.rank()));
		assertTrue("Clubs".equals(card.suit()));
		assertEquals(12, card.pointValue());
		System.out.println(card);
	}
}

