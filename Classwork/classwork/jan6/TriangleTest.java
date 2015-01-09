package jan6;

import static org.junit.Assert.*;

import org.junit.Test;


public class TriangleTest {

	@Test
	public void perimeterTest() {
		Point origin = new Point(0, 0);
		Point p1 = new Point(0, 2);
		Point p2 = new Point(2, 2);
		Point p3 = new Point(2, 0);
		assertEquals((2+2+Math.sqrt(2)*2), Triangle.perimeter(new Triangle(p1,p2,p3)), 0.0000001);
	}
	
}
