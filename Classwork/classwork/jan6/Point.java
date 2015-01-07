package jan6;

public class Point {

	public double x;
	public double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public static double slope(Point p1, Point p2) {
		return (p1.y - p2.y)/ (p1.x-p2.x); 
	}
	
	public static Point midPoint(Point p1, Point p2) {
		return new Point((p1.x + p2.x)/ 2, (p1.y + p2.y)/ 2);  
	}
	
	public static double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow((p1.y - p2.y), 2) + Math.pow((p1.x - p2.x), 2));
	}
}
