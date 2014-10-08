package spiral;

public class Spiral {

	public boolean isEqual(int[][] expected, int[][] actual) {
		if(expected==null||actual==null) {
			if(expected==null&&actual==null) {
				return true;
			}
			return false;
		}
		if(expected.length!=actual.length||expected[0].length!=actual[0].length){
			return false;
		}
		for(int y = 0; y < actual.length; y++){
			for(int x = 0; x < actual[y].length; x++){
				if(actual[y][x]!=expected[y][x]) {
					return false;
				}				
			}
			
		}
		return true;
	}

	/**
	 * Returns a 2D array of ints of length x and height y that spiral 1 through x * y inward.
	 */
	public int[][] spiral(int x, int y) {
		int[][] toReturn = new int[y][x];
		return toReturn;
	}

}
