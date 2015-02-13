package feb6;

public class BinarySearch {

	
	public static int binarySearch(int[] values, int key) {
		int imin = 0;
		int imax = values.length-1;
		while(imin <= imax) {
			int imid = midPoint(imin, imax);
			if(values[imid] == key) {
				return imid;
			} else if(values[imid] < key) {
				imin = imid + 1;
			} else {
				imax = imid - 1;
			}
		}
		return -1;
	}

	private static int midPoint(int min, int max) {
		return (min + max) / 2;
	}
}
