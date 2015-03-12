package mar12;

import static org.junit.Assert.*;

import org.junit.Test;


public class Recursion3Test {

	@Test
	public void gcdTest() {
		assertEquals(3, Recursion3.gcd(12, 57));
		assertEquals(3, Recursion3.gcd(3, 3));
		assertEquals(1, Recursion3.gcd(13, 37));
	}
	
	@Test
	public void binarySearchTest() {
		int[] nums = {-10, 0, 1, 3, 5, 7, 7, 9, 10, 17, 100};
		assertEquals(3, Recursion3.binarySearch(nums, 3));
		assertEquals(0, Recursion3.binarySearch(nums, -10));
		assertEquals(10, Recursion3.binarySearch(nums, 100));
	}
}
