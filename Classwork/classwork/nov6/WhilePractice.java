package nov6;

import java.util.Scanner;

public class WhilePractice {
	
	public static void main(String[] args) {
//		nPLoop();
		sumInputs();
	}

	public static void nPLoop() {
		Scanner kb = new Scanner(System.in);
		System.out.println("Type your response, then press enter.");
		System.out.println("What is your starting value?");
		double number = kb.nextDouble();
		kb.nextLine();
		String input;
		do {
			System.out.println("Your current number is: " + number);
			System.out.println("Type p to add one, n to subtact one, and anything else to exit.");
			input = kb.nextLine();
			if(input.equals("p")) {
				number++;
			}
			if(input.equals("n")) {
				number--;
			}
		}
		while(input.equals("n")||input.equals("p"));
		System.out.println("Your final number is: " + number);		
	}
	
	public static void sumInputs() {
		Scanner kb = new Scanner(System.in);
		double sum = 0;
		double input = 0;
		System.out.println("Type your response, then press enter.");
		while(input >= 0) {
			sum += input;
			System.out.println("What number do you want to add to the sum? Type a negative number to exit.");
			input = kb.nextDouble();
		}	
		System.out.println("The sum of your numbers is: " + sum);
	}
}
