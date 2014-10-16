package oct2;

import java.util.Scanner;

public class JobTracker {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to the NS-- JobTracker Inc. Type your answer, then hit enter. Or just assume that we're listening.");
		System.out.println("How many hours did you work on Monday?");
		double mon = Double.valueOf(keyboard.next());
		System.out.println("How many hours did you work on Tuesday?");
		double tue = Double.valueOf(keyboard.next());
		System.out.println("How many hours did you work on Wednesday?");
		double wed = Double.valueOf(keyboard.next());
		System.out.println("How many hours did you work on Thursday?");
		double thur = Double.valueOf(keyboard.next());
		System.out.println("How many hours did you work on Friday?");
		double fri = Double.valueOf(keyboard.next());
		double income = calcIncome(mon, tue, wed, thur, fri);
		
		System.out.println("You earned $" + income + " this week. I wouldn't be looking to buy a yacht, if I were you.");
	}
	
	public static double sumHours(double mon, double tue, double wed, double thur,
			double fri) {
		return mon + tue + wed + thur + fri;
	}

	public static double gross(double totalHours) {
		return totalHours * 12.5;
	}

	public static double accountForTax(double gross) {
		return gross * (1 - .27);
	}

	public static double calcIncome(double mon, double tue, double wed, double thur,
			double fri) {
		
		return accountForTax(gross(sumHours(mon, tue, wed, thur, fri)));
	}

}
