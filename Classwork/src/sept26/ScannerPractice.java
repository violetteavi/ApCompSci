package sept26;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerPractice {

	private static Scanner keyboard;
	
	public static void main(String[] args) {
		keyboard = new Scanner(System.in);
		System.out.println("Type your answer, then press enter.");
//		getName();
		multiply();
	}
	
	public static void getName() {
		System.out.println("What is your name?");
		String name = keyboard.nextLine();
		System.out.println("Hello " + name + "!");
	}
	
	public static void multiply() {
		System.out.println("Type the first double you wish to multiply.");
		double num1 = 0;
		double num2 = 0;
		boolean num1Done = false;
		boolean num2Done = false;
		while(!num1Done) {
			if(keyboard.hasNextDouble()) {
				num1Done = true;
				num1 = keyboard.nextDouble();
			} else {
				System.out.println("That's not a double! Try again.");			
			}
		}
//			try{
//				num1Done = true;
//				num1 = keyboard.nextDouble();
//			}
//			catch(InputMismatchException error) {
//				System.out.println("That's not a double! Try again.");
//				num1Done = false;
//			}
//		System.out.println("Type the second double you wish to multiply.");
//		while(!num2Done) {
//			try{
//				num2 = keyboard.nextDouble();
//				num1Done = true;
//			}
//			catch(InputMismatchException error) {
//				System.out.println("That's not a double! Try again.");
//				while(!keyboard.hasNext()) {
//				}
//			}
//		}
		System.out.println("The product of your two doubles is: " + num1 * num2 + ".");
	}
}
