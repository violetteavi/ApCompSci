package oct27;

import static org.junit.Assert.*;

import org.junit.Test;


public class TriangleCalcTest {

	@Test
	public void rightPerimeterTest() {		
		assertEquals(12.0, TriangleCalc.perimeterOf(3, 4, 5), 0.00001);
	}
	
	@Test
	public void rightAreaTest() {
		assertEquals(6.0, TriangleCalc.areaOf(3, 4, 5), 0.00001);		
	}
	
	@Test
	public void rightAngleTest() {
		assertEquals(Math.PI/2, TriangleCalc.angleOf(3, 4, 5), 0.00001);
	}
}
