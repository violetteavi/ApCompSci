package spacebattle;

import org.junit.Test;

public class FirstShipTest {

	@Test
	public void thrustTest() {
		FirstShip test = new FirstShip();
		test.thrust(30);
		System.out.println();
	}
}
