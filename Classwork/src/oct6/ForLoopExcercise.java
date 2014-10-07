package oct6;

import java.util.Scanner;

public class ForLoopExcercise {

	static Scanner keyboard;
	
	public static void main(String[] args) {
		keyboard = new Scanner(System.in);
		System.out.println("Type your answer, then press enter");
		repeatNumber();
		factorial();
	}
	
//	public static void print(int num) {
//		System.out.print(num);
//		int places = 1;
//		while(num%10 != 0) {
//			num /= 10;
//			places++;
//		}
//		int spaces = 4 - places;
//		for(int i = spaces; i > 0; i--)
//		System.out.print(" ");
//	}
	
	public static void repeatNumber() {
		System.out.println("What string do you wish to repeat? How many times? Answer in the form \"word number\"");
		String word = keyboard.next();
		int toRepeat = Integer.valueOf(keyboard.next());
		for(int i  = 0; i < toRepeat; i++) {
			System.out.println(word);
		}
	}
	
	public static void factorial() {
		System.out.println("What number should I factorial? Please use integers.");
		int num = Integer.valueOf(keyboard.next());
		int answer = num;
		for(int i = 1; i < num; i++) {
			answer *= (num - i);
		}
		System.out.println(num + " factorial is " + answer);
	}
}
