package calcproject;

import java.util.Scanner;

public class MathCalc {

	public static String[] parse(String string) {
		int numThings = 1;
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == ' ') {
				numThings++;
			}
		}
		String[] toReturn = new String[numThings];
		for(int i = 0; i < toReturn.length; i++) {
			toReturn[i] = "";
		}
		int slot = 0;
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) != ' ') {
				toReturn[slot] += string.charAt(i);
			} else {
				slot++;
			}
		}
		
		return toReturn;
	}

	public static boolean isOperator(String string) {
		if(string.length() != 1) {
			return false;
		}
		if(string.equals("+")) {
			return true;
		} else if(string.equals("-")) {
			return true;
		} else if(string.equals("*")) {
			return true;
		} else if(string.equals("/")) {
			return true;
		} else if(string.equals("^")) {
			return true;
		} else if(string.equals("|")) {
			return true;
		} else if(string.equals("v")) {
			return true;
		} else if(string.equals("~")) {
			return true;
		} else if(string.equals("s")) {
			return true;
		} else if(string.equals("c")) {
			return true;
		} else if(string.equals("t")) {
			return true;
		}
		return false;
	}

	public static double add(double a, double b) {
		return a + b;
	}

	public static double subtract(double a, double b) {
		return a - b;
	}

	public static double multiply(double a, double b) {
		return a * b;
	}

	public static double divide(double a, double b) {
		return a / b;
	}

	public static double pow(double a, double b) {
		return Math.pow(a, b);
	}

	public static double abs(double a) {
		return Math.abs(a);
	}

	public static int round(double a) {
		return (int) Math.round(a);
	}

	public static double sqrt(double a) {
		return Math.sqrt(a);
	}

	public static double sin(double a) {
		return Math.sin(a);
	}

	public static double cos(double a) {
		return Math.cos(a);
	}

	public static double tan(double a) {
		return Math.tan(a);
	}

}
