package guessproject2;

import java.util.Scanner;

public class GuessingGame2 {
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Hello! Welcome to the guessing game. Type your answer, then press enter.");
		System.out.println("What number would you like as your upper bound?");
		int upperBound = kb.nextInt();
		int totalGuesses = 0;
		int totalGames = 0;
		int lowestGuesses = Integer.MAX_VALUE;
		String wantsToPlay;
		do {
			int numGuesses = playGame(upperBound, kb);
			totalGames++;
			totalGuesses += numGuesses;
			if(numGuesses < lowestGuesses) {
				lowestGuesses = numGuesses;
			}
			System.out.println("Would you like to play again? (yes/no)");
			wantsToPlay = kb.nextLine();
		} while(wantsToPlay.equalsIgnoreCase("yes"));
		System.out.println("You played " + totalGames + " games with an average of " + totalGuesses / totalGames + " guesses each.");
		System.out.println("Your best score was " + lowestGuesses + " guesses.");
		System.out.println("Thanks for playing!");
	}

	public static int randomInt(int lowerBound, int upperBound) {
		return (int) (lowerBound + Math.random() * (upperBound - lowerBound + 1));
	}
	
	public static int playGame(int upperBound, Scanner kb) {
		int number = randomInt(1, upperBound);
		int guess;
		int numGuesses = 0;
		do {
			System.out.println("What do you think my number is?");
			guess = kb.nextInt();
			kb.nextLine();
			if(guess > 0) {
				numGuesses++;
				if(guess > number) {
					System.out.print("My number is lower! ");
				} else if(guess < number) {
					System.out.print("My number is higher! ");
				} else if(guess == number) {
					System.out.println("You got it! My number is " + number + "! It took you " + numGuesses + " guesses.");
				}
			}
		} while(guess > 0 && guess != number);
		if(guess <= 0) {
			System.out.println("You gave up in " + numGuesses + " guesses.");
		}
		return numGuesses;
	}
}
