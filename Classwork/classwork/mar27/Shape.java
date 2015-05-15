package mar27;

import jan6.Point;

public abstract class Shape {

	private Point center;
	
	public Shape(Point center) {
		this.center = center;
	}
	
	public abstract double getArea();
	
	public String toString() {
		String[] noClass = this.getClass().toString().split(" ");
		String[] noPackage = noClass[noClass.length - 1].split("\\.");
		return noPackage[noPackage.length - 1];
	}
}
