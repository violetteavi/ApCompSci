package mar27;

import jan6.Point;

public class Circle extends Shape{

	private double radius;

	public Circle(Point center, double radius) {
		super(center);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

}
