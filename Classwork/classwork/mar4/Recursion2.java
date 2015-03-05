package mar4;

public class Recursion2 {

	public static int sum(int[] arr) {
		return sumRec(0, arr);
	}
	
	private static int sumRec(int index, int[] arr) {
		if(arr==null ||index > arr.length - 1) {
			return 0;
		}
		return arr[index] + sumRec(index + 1, arr);
	}

	public static int sumEven(int[] arr) {
		return sumRecEven(0, arr);
	}
	
	private static int sumRecEven(int index, int[] arr) {
		if(arr==null ||index > arr.length - 1) {
			return 0;
		}
		int partialSum = 0;
		if(arr[index]%2==0) {
			partialSum += arr[index];
		}
		return partialSum + sumRec(index + 1, arr);
	}
	
	
	
}
