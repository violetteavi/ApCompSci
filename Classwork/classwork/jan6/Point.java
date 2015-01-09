package jan6;

public class Point {

	private double x, y, r, theta;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
		this.r = Math.sqrt(x*x + y*y);
		this.theta = Math.atan2(y, x);
	}
	
	public Point(double r, double theta, double marker) {
		//marker distinguishes it from the other point constructor
		this.r = r;
		this.theta = theta;
		this.x = r * Math.cos(theta);
		this.y = r * Math.sin(theta);
	}
	
	public static double slope(Point p1, Point p2) {
		return (p1.getY() - p2.getY())/ (p1.getX()-p2.getX()); 
	}
	
	public static Point midPoint(Point p1, Point p2) {
		return new Point((p1.getX() + p2.getX())/ 2, (p1.getY() + p2.getY())/ 2);  
	}
	
	public static double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow((p1.getY() - p2.getY()), 2) + Math.pow((p1.getX() - p2.getX()), 2));
	}
	
	public static boolean equals(Point p1, Point p2) {
		return p1.getX()==p2.getX()&&p1.getY()==p2.getY();
	}
	
	// getters and setters
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}


}
