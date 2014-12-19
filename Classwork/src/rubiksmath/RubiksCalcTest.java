package rubiksmath;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class RubiksCalcTest {

	@Test
	public void test() {
//		System.out.println((BigInteger.valueOf((long)Math.pow(3, 8))).intValue());
//		System.out.println((long) 12 * 11 * 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1);
//		System.out.println(Math.log(Double.MAX_VALUE)/Math.log(10)); // returns 308.2
//		System.out.println(Math.log(Long.MAX_VALUE)/Math.log(10)); // returns 18.9
//		System.out.println(Math.log(Float.MAX_VALUE)/Math.log(10)); // returns 38.5
//		System.out.println(Math.log(Integer.MAX_VALUE)/Math.log(10)); // returns 9.3
//		System.out.println((long) Math.pow(3, 7)); // no interference
		BigInteger thing = BigInteger.valueOf((long)Math.pow(3, 7)
						).multiply(BigInteger.valueOf((long)Math.pow(2, 11))
						).multiply(RubiksCalc.factorial(BigInteger.valueOf(12))
						).multiply(RubiksCalc.factorial(BigInteger.valueOf(8))
						).divide(BigInteger.valueOf((long) Math.pow(3, 7))
						).divide(BigInteger.valueOf((long) Math.pow(2, 12 - 1))
						).divide(RubiksCalc.factorial(BigInteger.valueOf((long) 12))
						).divide(RubiksCalc.factorial(BigInteger.valueOf((long) 8)));
		System.out.println(thing.longValue());
	}
	
	@Test
	public void counterTest() {
		System.out.println(RubiksCalc.gottaCalcEmAll());
	}
	
//	@Test
//	public void durationTest() {
//		System.out.println(RubiksCalc.durationTest());
//		//Test will run forever
//	}
	
	@Test
	public void factorialTest() {
		BigInteger expected = BigInteger.valueOf((long) 12 * 11 * 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1);
		double expecteddouble = expected.doubleValue();
		BigInteger recieved = RubiksCalc.factorial(BigInteger.valueOf(12));
		double recieveddouble = recieved.doubleValue();
		assertTrue(expected.equals(recieved));
	}
	
	@Test
	public void calc3By3CombosFullCubeTest() {
		BigInteger expected = BigInteger.valueOf((long)Math.pow(3, 7));
		double expecteddouble = expected.doubleValue();
				expected = expected.multiply(BigInteger.valueOf((long)Math.pow(2, 10)));
				expecteddouble = expected.doubleValue();
				expected = expected.multiply(RubiksCalc.factorial(BigInteger.valueOf(12)));
				expecteddouble = expected.doubleValue();
				expected = expected.multiply(RubiksCalc.factorial(BigInteger.valueOf(8)));
		expecteddouble = expected.doubleValue();
		BigInteger recieved = RubiksCalc.calc3By3Combos(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		double recieveddouble = recieved.doubleValue();
		assertTrue(expected.equals(recieved));
	}
	
	@Test
	public void calc3By3CombosBlankCubeTest() {
		BigInteger expected = BigInteger.valueOf(1);
		double expecteddouble = expected.doubleValue();
		BigInteger recieved = RubiksCalc.calc3By3Combos(8, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		double recieveddouble = recieved.doubleValue();
		assertTrue(expected.equals(recieved));
	}

}
