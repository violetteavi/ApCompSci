package guessproject2;

import static org.junit.Assert.*;

import org.junit.Test;

public class GuessingGame2Test {

	@Test
	public void randomIntTest() {
		System.out.println(GuessingGame2.randomInt(29, 39));
		System.out.println(GuessingGame2.randomInt(29, 39));
		System.out.println(GuessingGame2.randomInt(40, 58));
		System.out.println(GuessingGame2.randomInt(40, 58));
	}

}
