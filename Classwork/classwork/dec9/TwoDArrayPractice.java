package dec9;

import java.util.Scanner;

public class TwoDArrayPractice {
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		numVowelsUI(kb);
	}
	
	public static int[][] rollTwoDice(int numRolls) {
		int[][] rolled = new int[6][6]; // [first die][second die]
		for(int i = 0; i < numRolls; i++) {
			rolled[rollADie() - 1][rollADie() - 1]++;
		}
		return rolled;
	}

	public static int rollADie() {
		return (int) (Math.random() * 6 + 1);
	}
	
	public static void numVowelsUI(Scanner kb) {
		System.out.println("Type your answer, then press enter.");
		System.out.println("Hello! How many words would you like to input?");
		int numWords = kb.nextInt();
		kb.nextLine();
		String[] strs = new String[numWords];
		for(int i = 0; i < numWords; i++) {
			System.out.println("Type your word, then press enter.");
			strs[i] = kb.nextLine();
		}
		System.out.println("In the format of #a, #e, #i, #o, #u, your vowels were:");
		printVowels(numVowels(strs), strs);
	}
	
	private static void printVowels(int[][] numVowels, String[] strs) {
		for(int i = 0; i < numVowels.length; i++) {
			System.out.print("[" + numVowels[i][0]);
			for(int j = 1; j < numVowels[i].length; j++) {
				System.out.print(", " + numVowels[i][j]);
			}
			System.out.println("] for " + strs[i]);
		}
	}

	public static int[][] numVowels(String[] strs) {
		int[][] vowels = new int[strs.length][5];
		for(int i = 0; i < strs.length; i++) {
			vowels[i] = vowelSet(strs[i]);
		}
		return vowels;
	}
	
	public static int[] vowelSet(String str) {
		int[] vowels = new int[5];
		for(int i = 0; i < str.length(); i++) {
			switch(str.charAt(i)) {
			case 'a': vowels[0]++;
				break;
			case 'e': vowels[1]++;
				break;
			case 'i': vowels[2]++;
				break;
			case 'o': vowels[3]++;
				break;
			case 'u': vowels[4]++;
				break;
			}
		}
		return vowels;
	}

}
