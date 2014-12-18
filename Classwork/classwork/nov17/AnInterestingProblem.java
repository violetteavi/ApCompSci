package nov17; 

import java.util.Scanner;

public class AnInterestingProblem {

	public static void main(String[] args) {
		Scanner kb  = new Scanner(System.in);
		System.out.println("Welcome to the sales calculator! Type your response, then press enter.");
		System.out.println("How many days were we open this week?");
		int numDays = kb.nextInt();
		kb.nextLine();
		int totalSales = 0;
		for(int i = 0; i < numDays; i++) {
			System.out.println("How many sales were there on day " + (i + 1) + "?");
			int sales = kb.nextInt();
			kb.nextLine();
			totalSales += sales;
		}
		summaryStatistics(totalSales, numDays);
	}
	
	public static void summaryStatistics(int totalSales, int numDays) {
		System.out.println("You made " + totalSales + " sales at an average of " + (double) totalSales / numDays + " sales per day.");
	}
}
