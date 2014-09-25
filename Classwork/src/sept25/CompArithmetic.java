package sept25;

public class CompArithmetic {
	
	public static double fToC(double f) {
		double returnable  = f;
		returnable -= 32;
		returnable *= 5.0/9.0;
		return returnable;
	}

	public static double cToF(double c) {
		double returnable  = c;
		returnable *= 9.0/5.0;
		returnable += 32;
		return returnable;
	}

	public static int reverse(int toReverse) {
		int flippable = toReverse;
		int toReturn = 0;
		while(flippable > 0) {
			toReturn *= 10;
			toReturn += flippable % 10;
			flippable /= 10;
		}
		return toReturn;
	}

	public static void printDigits(int i) {
		 i = reverse(i);
		while(i > 0 && i != 0) {
			System.out.println(i % 10);
			i /= 10;
		}
	}

}
