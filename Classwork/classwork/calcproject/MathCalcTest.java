package calcproject;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathCalcTest {

	@Test
	public void parse2OperandsTest() {
		String[] expected = new String[3];
		expected[0] = "5";
		expected[1] = "+";
		expected[2] = "7";
		String[] recieved = MathCalc.parse("5 + 7");
		for(int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], recieved[i]);
		}
	}

	@Test
	public void parse1OperandTest() {
		String[] expected = new String[2];
		expected[0] = "|";
		expected[1] = "-7";
		String[] recieved = MathCalc.parse("| -7");
		for(int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], recieved[i]);
		}
	}
	
	@Test
	public void isOperatorTest() {
		assertTrue(MathCalc.isOperator("+"));
		assertTrue(MathCalc.isOperator("-"));
		assertTrue(MathCalc.isOperator("*"));
		assertTrue(MathCalc.isOperator("/"));
		assertTrue(MathCalc.isOperator("^"));
		assertTrue(MathCalc.isOperator("|"));
		assertTrue(MathCalc.isOperator("v"));
		assertTrue(MathCalc.isOperator("~"));
		assertTrue(MathCalc.isOperator("s"));
		assertTrue(MathCalc.isOperator("c"));
		assertTrue(MathCalc.isOperator("t"));
		assertFalse(MathCalc.isOperator(""));
		assertFalse(MathCalc.isOperator("3"));
		assertFalse(MathCalc.isOperator("-7"));
		assertFalse(MathCalc.isOperator("3.58"));
	}
	
	// math functions
	
	@Test
	public void additionTest() {
		assertEquals(4.0, MathCalc.add(2,2), 0.000001);
		assertEquals(-4.0, MathCalc.add(2,-6), 0.000001);
		assertEquals(-4.0, MathCalc.add(-6,2), 0.000001);
	}

	@Test
	public void subtractionTest() {
		assertEquals(0.0, MathCalc.subtract(2,2), 0.000001);
		assertEquals(-4.0, MathCalc.subtract(2,6), 0.000001);
		assertEquals(-8.0, MathCalc.subtract(-6,2), 0.000001);
	}

	@Test
	public void multiplicationTest() {
		assertEquals(4.0, MathCalc.multiply(2,2), 0.000001);
		assertEquals(-12.0, MathCalc.multiply(2,-6), 0.000001);
		assertEquals(-12.0, MathCalc.multiply(-6,2), 0.000001);
	}

	@Test
	public void divisionTest() {
		assertEquals(1.0, MathCalc.divide(2,2), 0.000001);
		assertEquals(-0.33333333333, MathCalc.divide(2,-6), 0.000001);
		assertEquals(-3.0, MathCalc.divide(-6,2), 0.000001);
		assertEquals(24.0, MathCalc.divide(-6,-0.25), 0.000001);
	}

	@Test
	public void exponentTest() {
		assertEquals(4.0, MathCalc.pow(2,2), 0.000001);
		assertEquals(1.0 / 64, MathCalc.pow(2,-6), 0.000001);
		assertEquals(36.0, MathCalc.pow(-6,2), 0.000001);
		assertEquals(2.0, MathCalc.pow(16,.25), 0.000001);
	}

	@Test
	public void absValueTest() {
		assertEquals(2, MathCalc.abs(2), 0.000001);
		assertEquals(6.23, MathCalc.abs(-6.23), 0.000001);
	}

	@Test
	public void roundTest() {
		assertEquals(2, MathCalc.round(2));
		assertEquals(2, MathCalc.round(2.49));
		assertEquals(2, MathCalc.round(1.5));
		assertEquals(-6, MathCalc.round(-6.23));
		assertEquals(-7, MathCalc.round(-6.73), 0.000001);
	}

	@Test
	public void sqrtTest() {
		assertEquals(2, MathCalc.sqrt(4), 0.000001);
		assertEquals(6.23, MathCalc.sqrt(38.8129), 0.000001);
	}

	@Test
	public void sinTest() {
		assertEquals(0, MathCalc.sin(0), 0.000001);
		assertEquals(-1, MathCalc.sin(-Math.PI/2), 0.000001);
	}

	@Test
	public void cosTest() {
		assertEquals(-1, MathCalc.cos(Math.PI), 0.000001);
		assertEquals(0, MathCalc.cos(Math.PI/2), 0.000001);
	}

	@Test
	public void tanTest() {
		assertEquals(0, MathCalc.tan(0), 0.000001);
		assertEquals(0, MathCalc.tan(Math.PI * 37), 0.000001);
	}
	
}
