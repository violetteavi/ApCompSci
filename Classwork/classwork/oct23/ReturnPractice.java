package oct23;

public class ReturnPractice {

	public double area(double x, double y) {
		return x * y;
	}

	public boolean isEven(int i) {
		return 0 == i % 2;
	}

	public String everyOtherChar(String string) {
		String toReturn = "";
		for(int i = 0; i < string.length(); i += 2) {
			toReturn = toReturn + string.charAt(i);
		}
		return toReturn;
	}

}
