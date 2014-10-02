package oct1;

import static org.junit.Assert.*;


import org.junit.Test;


public class QuadraticFormulaTest {

	@Test
	public void basicQuadTest() {
		double[] expected = {-1,1};
		double[] returned = QuadraticFormula.quadSolve(1,0,-1);
		assertEquals(expected[0], returned[0], 0.000001);
		assertEquals(expected[1], returned[1], 0.000001);
	}
	
//	@Test
//	public void parseStringTest() {
//		double[] expected = {3,2,3};
//		double[] returned = QuadraticFormula.parseForQuad("3x^2 + 2x + 3");
//		assertEquals(expected[0], returned[0], 0.000001);
//		assertEquals(expected[1], returned[1], 0.000001);
//		assertEquals(expected[2], returned[2], 0.000001);
//	}
}
