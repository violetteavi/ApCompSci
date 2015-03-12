package mar12;

public class Recursion3 {

	public static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
	
	public static int binarySearch(int[] nums, int target) {
		return binarySearch(nums, target, 0, nums.length - 1);
	}

	private static int binarySearch(int[] nums, int target, int min, int max) {
		if(min>max) {
			return -1;
		}
		int mid = (min + max)/2;
		if(nums[mid]==target) {
			return mid;
		} else if(nums[mid]>target) {
			return binarySearch(nums, target, min, mid - 1);
		} else {
			return binarySearch(nums, target, mid + 1, max);
		}
	}
}
