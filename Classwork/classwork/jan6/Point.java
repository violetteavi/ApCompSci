package jan6;

public class Point {

	private static final int X = 0;
	private static final int Y = 1;
	private static final int RADIUS = 2;
	private static final int THETA = 3;
	private double x, y, r, theta;
	
	//constructors
	
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
	
	//static calculations
	
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
	
	public static double distanceFromCenter(Point p) {
		return distance(p, new Point(0,0));
	}
	
	public int quadrant(Point p) {
		if(p.getX()>=0) {
			if(p.getY()>=0) {
				return 1;
			} else {
				return 4;
			}
		} else {
			if(p.getY()>=0) {
				return 2;
			} else {
				return 3;
			}
		}
	}
	
	public String toString(Point p) {
		return "(" + p.getX() + "," + ")";
	}
	
	//OO methods
	
	public double slopeTo(Point other) {
		return slope(this, other);
	}
	
	public Point midPointTo(Point other) {
		return midPoint(this, other);
	}
	
	public double distanceTo(Point other) {
		return distance(this, other);
	}
	
	public boolean equals(Point other) {
		return equals(this, other);
	}
	
	public double distanceFromCenter() {
		return distanceFromCenter(this);
	}
	
	public int quadrant() {
		return quadrant(this);
	}
	
	public String toString() {
		return toString(this);
	}
	
	// getters and setters
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
		this.update(X);
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
		this.update(Y);
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
		this.update(RADIUS);
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
		this.update(THETA);
	}

	private void update(int change) {
		switch(change) {
		case Y:
		case X: 
			this.r = Math.sqrt(x*x + y*y);
			this.theta = Math.atan2(y, x);
			break;
		case RADIUS:
		case THETA:
			this.x = r * Math.cos(theta);
			this.y = r * Math.sin(theta);
			break;
		}
		
	}


}
