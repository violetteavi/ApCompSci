package pathmaker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PathMakerTest {

	PathMaker test;
	
	@Before
	public void init() {
		test = new PathMaker();
	}
	
	@Test
	public void oneByOne() {
		assertEquals(2, test.numPaths(1, 1));
	}
	
	@Test
	public void twoByOne() {
		assertEquals(3, test.numPaths(1, 2));		
	}
	
	@Test
	public void twoByTwo() {
		assertEquals(6, test.numPaths(2, 2));		
	}
	
	@Test
	public void fourByTwo() {
		assertEquals(15, test.numPaths(4, 2));		
	}
	
	@Test
	public void isSymmetric() {
		assertEquals(test.numPaths(2, 1), test.numPaths(1, 2));				
	}
	
	@Test
	public void sumTest() {
		assertEquals(15, test.sumDigits(54321));
		assertEquals(15, test.sumDigits(12345));
	}
	
	@Test
	public void findPossiblePathsForHC() {
		int[][] answers = new int[10][2];
		int i = 0;
		for(int y = 1; i < 10; y++)	{
			for(int x = 1; x <= y; x++) {
				if(x + y - 2 == test.sumDigits(test.numPaths(x, y))) {
					answers[i][0] = x;
					answers[i][1] = y;
					i++;
				}				
			}
		}
		for(int[] answer: answers) {
			System.out.print("[ " + answer[0] + " , " + answer[1] + " ]");
			System.out.println(test.numPaths(answer[0], answer[1]));
		}
	}
}
