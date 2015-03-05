package mar4;

import static org.junit.Assert.*;

import org.junit.Test;


public class Recursion2Test {

	@Test
	public void addsTest() {
		int[] arr = {5,4,3,2,7,4};
		assertEquals(25, Recursion2.sum(arr));
		assertEquals(0, Recursion2.sum(null));
	}

	@Test
	public void addsEvenTest() {
		int[] arr = {5,4,3,2,7,4};
		assertEquals(10, Recursion2.sumEven(arr));
		assertEquals(0, Recursion2.sumEven(null));
	}
}
