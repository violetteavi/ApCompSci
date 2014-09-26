package sept26;

import java.util.Scanner;

public class ScannerPractice {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Type your answer, then press enter.");
		System.out.println("What is your name?");
		String name = keyboard.nextLine();
		System.out.println("Hello " + name + "!");
	}
}
