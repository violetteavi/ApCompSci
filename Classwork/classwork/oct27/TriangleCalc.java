package oct27;

import java.util.Scanner;

public class TriangleCalc {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Type your answer, then hit enter.");
		System.out.println("What is the length of side a?");
		double a = keyboard.nextDouble();
		System.out.println("What is the length of side b?");
		double b = keyboard.nextDouble();
		System.out.println("What is the length of side c?");
		double c = keyboard.nextDouble();
		System.out.println("These are your summary values.");
		System.out.println("Perimeter: " + TriangleCalc.perimeterOf(a, b, c));
		System.out.println("Area: " + TriangleCalc.areaOf(a, b, c));
		System.out.println("Angle A: " + TriangleCalc.angleOf(b, c, a)/Math.PI + " pi radians");
		System.out.println("Angle B: " + TriangleCalc.angleOf(c, a, b)/Math.PI + " pi radians");
		System.out.println("Angle C: " + TriangleCalc.angleOf(a, b, c)/Math.PI + " pi radians");
	}

	public static double perimeterOf(double a, double b, double c) {
		return a + b + c;
	}

	public static double areaOf(double a, double b, double c) {
		double s = (a + b + c) / 2;
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	public static double angleOf(double a, double b, double c) {
		// returns the angle opposite c
		return Math.acos((a*a + b*b - c*c)/(2 * a * b));
	}

}
