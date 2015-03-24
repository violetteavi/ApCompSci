package projects.calcproject;

import static org.junit.Assert.*;

import java.util.List;
import java.util.LinkedList;

import org.junit.Test;

public class MathCalcTest {
	
	@Test
	public void evaluatesParentheses() {
		List<String> input = new LinkedList<String>();
		input.add("(");
		input.add("7");
		input.add("+");
		input.add("10");
		input.add(")");
		input.add("/");
		input.add("2");
		String recieved = MathCalc.evaluate(input);
		assertTrue("8.5".equals(recieved));
	}
	
	@Test
	public void evaluatesNestedParentheses() {
	List<String> input = new LinkedList<String>();
		input.add("(");
		input.add("7");
		input.add("+");
		input.add("(");
		input.add("10");
		input.add("/");
		input.add("2");
		input.add(")");
		input.add(")");
		input.add("/");
		input.add("2");
		String recieved = MathCalc.evaluate(input);
		assertTrue("6.0".equals(recieved));
	}
	
//	@Test
//	public void grabsInsideParentheses() {
//		List<String> input = new LinkedList<String>();
//		input.add("(");
//		input.add("7");
//		input.add("+");
//		input.add("10");
//		input.add(")");
//		input.add("/");
//		input.add("2");
//		List<String> expected = new LinkedList<String>();
//		expected.add("7");
//		expected.add("+");
//		expected.add("10");	
//		assertTrue(expected.equals(MathCalc.grabInsideParentheses(input, 0)));
//	}
//	
//	@Test
//	public void grabsInsideNestedParentheses() {
//		List<String> input = new LinkedList<String>();
//		input.add("(");
//		input.add("7");
//		input.add("+");
//		input.add("(");
//		input.add("10");
//		input.add("/");
//		input.add("2");
//		input.add(")");
//		input.add(")");
//		input.add("/");
//		input.add("2");
//		List<String> expected = new LinkedList<String>();
//		expected.add("7");
//		expected.add("+");
//		expected.add("(");
//		expected.add("10");
//		expected.add("/");
//		expected.add("2");
//		expected.add(")");
//		assertTrue(expected.equals(MathCalc.grabInsideParentheses(input, 0)));
//	}

	@Test
	public void evaluatesOrderOfOps() {
		List<String> input = new LinkedList<String>();
		input.add("7");
		input.add("+");
		input.add("10");
		input.add("/");
		input.add("2");
		assertTrue("12.0".equals(MathCalc.evaluate(input)));
		List<String> input2 = new LinkedList<String>();
		input2.add("15");
		input2.add("+");
		input2.add("-9");
		input2.add("/");
		input2.add("|");
		input2.add("-3");
		assertTrue("12.0".equals(MathCalc.evaluate(input2)));
	}
	
	@Test
	public void evaluatesMultipleOps() {
		List<String> input = new LinkedList<String>();
		input.add("10");
		input.add("/");
		input.add("2");
		input.add("+");
		input.add("7");
		assertTrue("12.0".equals(MathCalc.evaluate(input)));
		List<String> input2 = new LinkedList<String>();
		input2.add("|");
		input2.add("-9");
		input2.add("/");
		input2.add("-3");
		input2.add("+");
		input2.add("15");
		assertTrue("12.0".equals(MathCalc.evaluate(input2)));
	}
	
	@Test
	public void evaluatesSimpleInput() {
		List<String> input = new LinkedList<String>();
		input.add("5");
		input.add("+");
		input.add("7");
		assertTrue("12.0".equals(MathCalc.evaluate(input)));
		List<String> input2 = new LinkedList<String>();
		input2.add("|");
		input2.add("-7");
		assertTrue("7.0".equals(MathCalc.evaluate(input2)));
	}
	
	@Test
	public void calc1OperandTest() {
		assertEquals(7.0, Double.valueOf(MathCalc.calcOneOperand("|", "-7")), 0.000001);
		assertEquals(7.0, Double.valueOf(MathCalc.calcOneOperand("v", "49")), 0.000001);
		assertEquals(7.0, Double.valueOf(MathCalc.calcOneOperand("~", "7.4")), 0.000001);
		assertEquals(Math.sin(-7.0), Double.valueOf(MathCalc.calcOneOperand("s", "-7")), 0.000001);
		assertEquals(Math.cos(-7.0), Double.valueOf(MathCalc.calcOneOperand("c", "-7")), 0.000001);
		assertEquals(Math.tan(-7.0), Double.valueOf(MathCalc.calcOneOperand("t", "-7")), 0.000001);
	}

	@Test
	public void calc2OperandTest() {
		assertEquals(49.0, Double.valueOf(MathCalc.calcTwoOperands("^", "-7", "2")), 0.000001);
		assertEquals(-14.0, Double.valueOf(MathCalc.calcTwoOperands("*", "-7", "2")), 0.000001);
		assertEquals(-3.5, Double.valueOf(MathCalc.calcTwoOperands("/", "-7", "2")), 0.000001);
		assertEquals(-5.0, Double.valueOf(MathCalc.calcTwoOperands("+", "-7", "2")), 0.000001);
		assertEquals(-9.0, Double.valueOf(MathCalc.calcTwoOperands("-", "-7", "2")), 0.000001);
	}
	
	@Test
	public void parse2OperandsTest() {
		List<String> expected = new LinkedList<String>();
		expected.add("5");
		expected.add("+");
		expected.add("7");
		List<String> received = MathCalc.parse("5 + 7");
		assertTrue(MathCalc.isEqual(expected, received));
	}

	@Test
	public void parse1OperandTest() {
		List<String> expected = new LinkedList<String>();
		expected.add("|");
		expected.add("-7");
		List<String> received = MathCalc.parse("| -7");
		assertTrue(MathCalc.isEqual(expected, received));
	}
	
	@Test
	public void equalsTest() {
		List<String> expected = new LinkedList<String>();
		expected.add("5");
		expected.add("+");
		expected.add("7");
		List<String> expectedClone = new LinkedList<String>();
		expectedClone.add("5");
		expectedClone.add("+");
		expectedClone.add("7");
		List<String> unexpected = new LinkedList<String>();
		unexpected.add("5");
		unexpected.add("-");
		unexpected.add("7");
		assertTrue(MathCalc.isEqual(expected, expectedClone));
		assertFalse(MathCalc.isEqual(expected, unexpected));
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
		assertTrue(MathCalc.isOperator("("));
		assertTrue(MathCalc.isOperator(")"));
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
		assertEquals(2, MathCalc.round(2), 0.00001);
		assertEquals(2, MathCalc.round(2.49), 0.00001);
		assertEquals(2, MathCalc.round(1.5), 0.00001);
		assertEquals(-6, MathCalc.round(-6.23), 0.00001);
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
	
//	@Test
//	public void explorationOfEdgeTest() {
//		System.out.println(Double.valueOf("8.ab")); // Returns NumberFormatException 
//		System.out.println(String.valueOf(MathCalc.add(5, MathCalc.sqrt(-7)))); //returns NaN
//	}
	
}
