package oct23;

import static org.junit.Assert.*;

import org.junit.Test;


public class ReturnPracticeTest {

	@Test
	public void areaRectTest() {
		ReturnPractice test = new ReturnPractice();
		assertEquals(12., test.area(4.0,3.0), 0.000001);
	}
	
	@Test
	public void isEvenTest() {
		ReturnPractice test = new ReturnPractice();
		assertTrue(test.isEven(4));
		assertFalse(test.isEven(7));
	}
	
	@Test
	public void everyOtherCharTest() {
		ReturnPractice test = new ReturnPractice();
		assertEquals("aceg", test.everyOtherChar("abcdefg"));
	}
}
