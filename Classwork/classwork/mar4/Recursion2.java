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
		return partialSum + sumRecEven(index + 1, arr);
	}
	
	public static int fib(int n) {
		if(n <= 0) {
			return 0;
		}
		int cur = 1;
		int prev = 0;
		while(n > 1) {
			int tempCur = cur + prev;
			prev = cur;
			cur = tempCur;
			n--;
		}
		return cur;
	}
	
	public static int fibRec(int n, int cur, int prev) {
		if(n < 1) {
			return cur;
		}
		return fibRec(n-1, cur + prev, cur);
	}

	public static int fibRec(int n) {
		return fibRec(n - 1, 1, 0);
	}
	
}
