package mar16;

public class MergeSort {
	
	public static void merge(int[] toSort1, int startIndex1, int finishIndex1, int[]toSort2, int startIndex2, int finishIndex2, int[] sorted) {
		int placeHolder1 = startIndex1;
		int placeHolder2 = startIndex2;
		for(int i = startIndex1; i <= finishIndex2; i++) {
			if(placeHolder1 <= finishIndex1 && placeHolder2 <= finishIndex2) {
				if(toSort1[placeHolder1] < toSort2[placeHolder2]) {
					sorted[i] = toSort1[placeHolder1];
					placeHolder1++;
				} else {
					sorted[i] = toSort2[placeHolder2];
					placeHolder2++;
				}
			} else if (placeHolder1 <= finishIndex1) {
				sorted[i] = toSort1[placeHolder1];
				placeHolder1++;				
			} else {
				sorted[i] = toSort2[placeHolder2];
				placeHolder2++;
			}
		}
	}

}
