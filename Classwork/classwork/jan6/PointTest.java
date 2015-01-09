package jan6;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	@Test
	public void slopeTest() {
		Point origin = new Point(0,0);
		Point p1 = new Point(2,2);
		Point p2 = new Point(4,2);
		Point p3 = new Point(2,4);
		double infinity = 1.0 / 0;
		assertEquals(1.0, Point.slope(origin, p1), 0.000001);
		assertEquals(2.0, Point.slope(origin, p3), 0.000001);
		assertEquals(0.5, Point.slope(origin, p2), 0.000001);
		assertEquals(infinity, Point.slope(p3, p1), 0.000001);
		assertEquals(0.0, Point.slope(p1, p2), 0.000001);
		assertEquals(0.0, Point.slope(p2, p1), 0.000001);
	}

	@Test
	public void midpointTest() {
		Point origin = new Point(0,0);
		Point p1 = new Point(1,1);
		Point p2 = new Point(2,2);
		Point p3 = new Point(3,3);
		Point p4 = new Point(4,4);
		Point p5 = new Point(1, -5);
		Point p6 = new Point(1, -2);
		assertTrue(Point.equals(p2, Point.midPoint(origin, p4)));
		assertTrue(Point.equals(p2, Point.midPoint(p4, origin)));
		assertTrue(Point.equals(origin, Point.midPoint(origin, origin)));
		assertTrue(Point.equals(p3, Point.midPoint(p4, p2)));
		assertTrue(Point.equals(p6, Point.midPoint(p1, p5)));
	}

	@Test
	public void distanceTest() {
		Point origin = new Point(0,0);
		Point p1 = new Point(1,1);
		Point p2 = new Point(2,2);
		Point p3 = new Point(3,3);
		Point p4 = new Point(4,4);
		Point p5 = new Point(1, -5);
		Point p6 = new Point(1, -2);
	}
}
