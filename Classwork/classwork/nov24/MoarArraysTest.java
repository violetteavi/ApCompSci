package nov24;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class MoarArraysTest {

	@Test
	public void numVowelsTest() {
		assertEquals(5, MoarArrays.numVowels("abcdEfghIjklmnOpqrstuv!@#$%^&*"));
	}

	@Test
	public void numVowelsFromStrsTest() {
		String[] strs = new String[3];
		strs[0] = "abcdEfghIjklmnOpqrstuv!@#$%^&*";
		strs[1] = "abcdfghIjklmnpqrstuv!@#$%^&*";
		strs[2] = "abcdEfghIjoooklmnOpqrstuv!@#$%^&*";
		int[] expected = new int[3];
		expected[0] = 5;
		expected[1] = 3;
		expected[2] = 8;
		assertTrue(Arrays.equals(expected, MoarArrays.stringsToNumVowels(strs)));
	}

	@Test
	public void consecAddTest() {
		double[] input = new double[4];
		input[0] = 2;
		input[1] = 3;
		input[2] = 0;
		input[3] = 8;
		double[] expected = new double[3];
		expected[0] = 5;
		expected[1] = 3;
		expected[2] = 8;
		assertTrue(Arrays.equals(expected, MoarArrays.consecutiveAddition(input)));
	}
	
	@Test
	public void consecAddPrintoutTest() {
		double[] input = new double[7];
		input[0] = 3;
		input[1] = 7;
		input[2] = 12;
		input[3] = 9;
		input[4] = -5;
		input[5] = 0;
		input[6] = 3;
		MoarArrays.consecutiveAddition(input);
	}
}
