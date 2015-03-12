package gazillionproject;

public class Range {
	
	private int min;
	private int max;
	
	private Range(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	public static Range parse(String s) {
		String[] divided = s.split("-");
		if(divided.length==1) {
			String stringVal =  divided[0].substring(1, divided[0].length() - 1);
			return new Range(Integer.valueOf(stringVal), Integer.valueOf(stringVal));
		} else if (divided.length==2){
			String minVal =  divided[0].substring(1, divided[0].length() - 1);
			String maxVal =  divided[1].substring(1, divided[1].length() - 1);
			return new Range(Integer.valueOf(minVal), Integer.valueOf(maxVal));		
		} else {
			return null;
		}
	}

	public boolean contains(int n) {
		return n >= min && n <= max;
	}

	
}
