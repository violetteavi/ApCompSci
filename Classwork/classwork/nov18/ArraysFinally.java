package nov18;

import java.util.Scanner;

public class ArraysFinally {
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
//		rollSomeDiceForUser(kb);
		getNumLettersForUser(kb);
	}

	public static int rollADie() {
		return (int) (Math.random() * 6 + 1);
	}
	
	public static void rollSomeDiceForUser(Scanner kb) {
		System.out.println("How many dice would you like to roll?");
		int numDice = kb.nextInt();
		System.out.println("How many times would you like to roll the dice?");
		int numRolled = kb.nextInt();
		kb.nextLine();
		int[] rolled = new int[numRolled];
		for(int i = 0; i < numRolled; i++) {
			int total = 0;
			for(int j = 0; j < numDice; j++) {
				total+= rollADie();
			}
			rolled[i] = total;
		}
		int[] values = new int[5 * numDice + 1];
		for(int i = 0; i < numRolled; i++) {
			values[rolled[i] - numDice]++; // the slots in values represent a number rolled -2, and the value in the slot is the quantity of that rolled.
		}
		for(int i = 0; i < 5 * numDice + 1; i++) { 
			System.out.println("You rolled a '" + (i + numDice) + "' " + values[i] + " times.");
		}
	}
	
	public static void getNumLettersForUser(Scanner kb) {
		System.out.println("Type your answer, then hit enter.");
		System.out.println("What phrase would you like to know the letters of?");
		String input = kb.nextLine();
		int[] result = numLetters(input);
		for(int i = 0; i < 26; i++) {
			if(result[i] != 0) {
				System.out.println("Your phrase has " + result[i] + " of the letter " + (char) (i + 65) + ".");
			}
		}
	}

	public static int[] numLetters(String input) {
		int[] letters = new int[26];
		for(int i = 0; i < input.length(); i++) {
			if((input.charAt(i) - 97) > -1 && (input.charAt(i) - 97) < 26) {
				letters[input.charAt(i) - 97]++;
			} // lowercase
			if((input.charAt(i) - 65) > -1 && (input.charAt(i) - 65) < 26) {
				letters[input.charAt(i) - 65]++;
			} //uppercase
		}
		return letters;
	}
	
//	public static void rollDiceForUser(Scanner kb) {
//		System.out.println("How many dice would you like to roll?");
//		int numDice = kb.nextInt();
//		kb.nextLine();
//		int[] diceRolled = new int[numDice];
//		for(int i = 0; i < numDice; i++) {
//			diceRolled[i] = rollADie();
//		}
//		int[] values = new int[6];
//		for(int i = 0; i < numDice; i++) {
//			values[diceRolled[i] - 1]++; // the slots in values represent a number rolled -1, and the value in the slot is the quantity of that rolled.
//		}
//		for(int i = 0; i < 6; i++) {
//			System.out.println("You rolled a '" + (i + 1) + "' " + values[i] + " times.");
//		}
//	}
//	
//	public static void rollTwoDiceForUser(Scanner kb) {
//		System.out.println("How many times would you like to roll the dice?");
//		int numRolled = kb.nextInt();
//		kb.nextLine();
//		int[] rolled = new int[numRolled];
//		for(int i = 0; i < numRolled; i++) {
//			rolled[i] = rollADie() + rollADie();
//		}
//		int[] values = new int[11];
//		for(int i = 0; i < numRolled; i++) {
//			values[rolled[i] - 2]++; // the slots in values represent a number rolled -2, and the value in the slot is the quantity of that rolled.
//		}
//		for(int i = 0; i < 11; i++) { 
//			System.out.println("You rolled a '" + (i + 2) + "' " + values[i] + " times.");
//		}
//	}
}
