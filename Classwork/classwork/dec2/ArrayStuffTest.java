package dec2;

import static org.junit.Assert.*;

import org.junit.Test;


public class ArrayStuffTest {

	@Test
	public void isInOrder() {
		double[] input = new double[5];
		input[0] = -3;
		input[1] = -3;
		input[2] = 2;
		input[3] = 4.5;
		input[4] = 5;
		assertTrue(ArrayStuff.isInOrder(input));
	}
}
