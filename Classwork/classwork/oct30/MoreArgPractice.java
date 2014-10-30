package oct30;

public class MoreArgPractice {

	public static boolean hasE(String string) {
		return string.indexOf('e') != -1;
	}

	public static double difference(double d, double e) {
		return Math.abs(d - e);
	}

	public static double getMax(double d, double e, double f) {
		if(d >= e && e>= f) {
			return d;
		} else if (e >= f && f >= d) {
			return e;
		} else if (f >= d && f>= e){
			return d;
		}
		return 0;
	}

	public static String removeVowels(String string) {
		String toReturn = string;
		for(int i = 0; i < toReturn.length(); i += 0) {
			if(toReturn.charAt(i)=='a'||toReturn.charAt(i)=='e'||toReturn.charAt(i)=='i'||toReturn.charAt(i)=='o'||toReturn.charAt(i)=='u') {
				toReturn = toReturn.substring(0, i) + toReturn.substring(i + 1);
			} else {
				i++;
			}
		}
		return toReturn;
	}

}
