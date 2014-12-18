package nov24;

public class MoarArrays {

	public static int numVowels(String str) {
		int numVowels = 0;
		for(int i = 0; i < str.length(); i++) {
			switch(str.charAt(i)) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U': numVowels++;
					break;
			default: break;
			}
		}
		return numVowels;
	}
	
	public static int[] stringsToNumVowels(String[] strs) {
		int[] vowels = new int[strs.length];
		for(int i = 0; i < strs.length; i++) {
			vowels[i] = numVowels(strs[i]);
		}
		return vowels;
	}
	
	public static double[] consecutiveAddition(double[] input) {
		double[] returnable = new double[input.length - 1];
		for(int i = 0; i < returnable.length; i++) {
			returnable[i] = input[i] + input[i + 1];
			System.out.print(returnable[i] + " ");
		}
		System.out.println();
		return returnable;
	}
	
	public static double sum(double[] toSum) {
		double sum = 0;
		for(int i = 0; i < toSum.length; i++) {
			sum+= toSum[i];
		}
		return sum;
	}
}
