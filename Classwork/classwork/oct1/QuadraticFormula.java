package oct1;

import java.util.Scanner;

public class QuadraticFormula {

	public static void main(String[] args) {
		quadSolveFromUser();
	}
	
	public static void quadSolveFromUser() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Type your input, then press enter.");
		System.out.println("Type the coefficient of the x^2 term, a.");
		double a = keyboard.nextDouble();
		System.out.println("Type the coefficient of the x term, b.");
		double b = keyboard.nextDouble();
		System.out.println("Type the coefficient of the constant term, c.");
		double c = keyboard.nextDouble();
		double[] roots = quadSolve(a, b, c);
		System.out.println("Your roots are: " + roots[0] + " and " + roots[1]);
	}
	
	public static double[] quadSolve(double a, double b, double c) {
		double[] returnable = {0,0};
		returnable[0] = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
		returnable[1] = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
		return returnable;
	}
	
}
