package spiral;

import static org.junit.Assert.*;

import java.lang.reflect.Array;

import org.junit.Test;

public class SpiralTest {

	@Test
	public void equalsTest() {
		Spiral test = new Spiral();
		int[][] answer = new int[2][3];
		answer[0][0] = 1;
		answer[1][0] = 2;
		answer[0][1] = 3;
		answer[1][1] = 4;
		answer[0][2] = 5;
		answer[1][2] = 6;
		int[][] recieved = new int[2][3];
		recieved[0][0] = 1;
		recieved[1][0] = 2;
		recieved[0][1] = 3;
		recieved[1][1] = 4;
		recieved[0][2] = 5;
		recieved[1][2] = 6;
		assertTrue(test.isEqual(answer,recieved));
	}
	
	@Test
	public void notEqualsTest() {
		Spiral test = new Spiral();
		int[][] answer = new int[2][3];
		answer[0][0] = 11;
		answer[1][0] = 21;
		answer[0][1] = 31;
		answer[1][1] = 41;
		answer[0][2] = 51;
		answer[1][2] = 61;
		int[][] recieved = new int[2][3];
		recieved[0][0] = 1;
		recieved[1][0] = 2;
		recieved[0][1] = 3;
		recieved[1][1] = 4;
		recieved[0][2] = 5;
		recieved[1][2] = 6;
		assertFalse(test.isEqual(answer,recieved));
	}
	
	@Test
	public void oneByOne() {
		Spiral test = new Spiral();
		int[][] expected = new int[1][1];
		expected[0][0] = 1;
		int[][] actual = test.spiral(1,1);
		assertTrue(test.isEqual(expected, actual));
	}
	
	@Test
	public void twoByTwo() {
		Spiral test = new Spiral();
		int[][] expected = new int[2][2];
		expected[0][0] = 1;
		expected[0][1] = 2;
		expected[1][0] = 4;
		expected[1][1] = 3;
		int[][] actual = test.spiral(2,2);
		assertTrue(test.isEqual(expected, actual));
	}
	
	@Test
	public void twoByThree() {
		Spiral test = new Spiral();
		int[][] expected = new int[3][2];
		expected[0][0] = 1;
		expected[0][1] = 2;
		expected[1][0] = 6;
		expected[1][1] = 3;
		expected[2][0] = 5;
		expected[2][1] = 4;
		int[][] actual = test.spiral(2,3);
		assertTrue(test.isEqual(expected, actual));
	}
	
}
