package cards;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTester {
	
	@Test
	public void gettersSettersTest() {
		Card test = new Card("Jack", "Hearts", 11);
		assertTrue("Jack".equals(test.getRank()));
		assertTrue("Hearts".equals(test.getSuit()));
		assertEquals(11, test.getPointValue());
	}
}
