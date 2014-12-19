package dec2;

public class ArrayStuff {

	public static boolean isInOrder(double[] nums) {
		boolean checkGreater;
		if(nums.length > 1) {
			checkGreater = nums[0] <= nums[1];
		} else {
			checkGreater = true;
		}
		for(int i = 0; i < nums.length - 1; i++) {
			if(compare(nums[i], nums[i + 1], checkGreater)) {
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static boolean compare(double num1, double num2, boolean checkGreater) {
		if(checkGreater) {
			return num1 <= num2;
		} else {
			return num1 >= num2;
		}
	}
}
