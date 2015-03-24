package projects.gazillionproject;

import static org.junit.Assert.*;

import org.junit.Test;


public class SongTest {

	@Test
	public void parseTest() {
		Song test = Song.parse("1893	6	J.W. Myers	Two Little Girls in Blue");
		assertEquals(1893, test.getYear());
		assertEquals(6, test.getRank());
		assertTrue("J.W. Myers".equals(test.getArtist()));
		assertTrue("Two Little Girls in Blue".equals(test.getTitle()));
	}

	@Test
	public void toStringTest() {
		Song test = Song.parse("1893	6	J.W. Myers	Two Little Girls in Blue");
		assertTrue("1893	6	J.W. Myers	Two Little Girls in Blue".equals(test.toString()));
	}
	
	
}
