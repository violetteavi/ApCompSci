package sept25;

import static org.junit.Assert.*;

import org.junit.Test;

public class CompArithmeticTest {
	
	@Test
	public void positiveFToC() {
		assertEquals(1.0, CompArithmetic.fToC(33.8), 0.0001);
	}
	
	@Test
	public void positiveCToF() {
		assertEquals(33.8, CompArithmetic.cToF(1.0), 0.0001);
	}
	
	@Test
	public void printDigits() {
		CompArithmetic.printDigits(54321);
	}
	
	@Test
	public void reverseDigits() {
		assertEquals(321, CompArithmetic.reverse(123));
	}
}
