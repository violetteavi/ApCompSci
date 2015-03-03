package feb25;

public class Recursion {

	public static int factorial(int n) {
		int fac = 1;
		for(int i = n; i > 0; i--) {
			fac *= i;
		}
		return fac;
	}
	
	public static int factorialRec(int n) {
		if(n <= 1) {
			return 1;
		}
		return n * factorialRec(n - 1);
	}

	public static String reverse(String string) {
		if(string== null) {
			return null;
		}
		if(string.length() <= 1) {
			return string;
		}
		return string.charAt(string.length()-1) + reverse(string.substring(0, string.length() - 1));
	}

	public static boolean isPalindrome(String string) {
		if(string==null) {
			return true;
		}
		if(string.charAt(0)!=string.charAt(string.length() - 1)) {
			return false;
		}
		if(string.length() <= 1) {
			return true;
		}
		return isPalindrome(string.substring(1, string.length() - 1));
	}
}
