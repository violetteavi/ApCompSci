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
	public void findPossiblePaths() {
		int[] answers = new int[10];
		int i = 0;
		for(int x = 1; i < 10; x++)	{
			for(int y = 1; y <= x; y++) {
				
			}
		}
	}
}
