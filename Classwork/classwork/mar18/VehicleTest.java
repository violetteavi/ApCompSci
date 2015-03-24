package mar18;

import java.util.Arrays;

import org.junit.Test;


public class VehicleTest {

	@Test
	public void typeTest() {
		System.out.println(new Vehicle("Lightning").getType());
		System.out.println(new PickupTruck("Mater").getType());
	}
}
