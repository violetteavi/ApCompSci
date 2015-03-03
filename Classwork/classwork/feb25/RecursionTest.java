package feb25;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecursionTest {

	@Test
	public void factorialTest() {
		assertEquals(6, Recursion.factorial(3));
		assertEquals(720, Recursion.factorial(6));
		assertEquals(1, Recursion.factorial(0));
	}

	@Test
	public void factorialRecTest() {
		assertEquals(6, Recursion.factorialRec(3));
		assertEquals(720, Recursion.factorialRec(6));
		assertEquals(1, Recursion.factorialRec(0));
	}
	
	@Test
	public void reverseRecTest() {
		assertTrue("cba".equals(Recursion.reverse("abc")));
		assertTrue("".equals(Recursion.reverse("")));
		assertTrue(null==Recursion.reverse(null));
	}
	
	@Test
	public void palindromeTest() {
		assertTrue(Recursion.isPalindrome("racecar"));
		assertTrue(Recursion.isPalindrome("x"));
		assertTrue(Recursion.isPalindrome(null));
		assertFalse(Recursion.isPalindrome("racecab"));
		assertFalse(Recursion.isPalindrome("racecrar"));
	}
}
