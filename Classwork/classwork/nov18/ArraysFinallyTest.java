package nov18;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class ArraysFinallyTest {

	@Test
	public void parsesTest() {
		String input = "abc  .decz";
		int[] expected = new int[26];
		for(int i = 0; i < 5; i++) {
			expected[i]++;
		}
		expected[25]++;
		expected[2]++;
		assertTrue(Arrays.equals(expected, ArraysFinally.numLetters(input)));
	}

	@Test
	public void parsesUppercaseTest() {
		System.out.println('A' + 0);
		String input = "ABC  .DECZ";
		int[] expected = new int[26];
		for(int i = 0; i < 5; i++) {
			expected[i]++;
		}
		expected[25]++;
		expected[2]++;
		assertTrue(Arrays.equals(expected, ArraysFinally.numLetters(input)));
	}
	//a is 97, A is 65, all letters after that are just +1 to move forward
}
