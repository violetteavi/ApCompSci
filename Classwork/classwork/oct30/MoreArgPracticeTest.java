package oct30;

import static org.junit.Assert.*;

import org.junit.Test;


public class MoreArgPracticeTest {

	@Test
	public void hasETest() {
		assertTrue(MoreArgPractice.hasE("mine"));
		assertFalse(MoreArgPractice.hasE("mini"));
	}
	
	@Test
	public void differenceTest() {
		assertEquals(3.0, MoreArgPractice.difference(5.0,2.0), 0.000001);
		assertEquals(3.0, MoreArgPractice.difference(2.0,5.0), 0.000001);
		assertEquals(3.0, MoreArgPractice.difference(-5.0,-2.0), 0.000001);
	}
	
	@Test
	public void getMaxTest() {
		assertEquals(5.0, MoreArgPractice.getMax(5.0, 3.0, -5.0), 0.00001);
		assertEquals(5.0, MoreArgPractice.getMax(5.0, 5.0, 5.0), 0.00001);
	}
	
	@Test
	public void removeVowelsTest() {
		assertEquals("bcdntl", MoreArgPractice.removeVowels("abcedental"));
	}
}
